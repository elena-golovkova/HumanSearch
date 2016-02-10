import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.GroupLayout.SequentialGroup;

public class Human {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 0;

    private String name;
    private int age;
    static Human[] array = new Human[2];
    private static int temp = -1;

    public Human() {
        super();
    }

    public Human(int age, String name) throws WrongAgeException {

        setAge(age);
        setName(name);
    }

    public void setAge(int number) throws WrongAgeException {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER)
            this.age = number;
        else
            throw new WrongAgeException(
                    "Wrong number. You should use age between " + MIN_NUMBER + " and " + MAX_NUMBER);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Human ctreateHuman() {
        Human human = null;
        int age;
        String name;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name:");
            name = br.readLine();
            System.out.println("Enter the age:");
            age = parsInt(br);
            while (human == null) {

                try {
                    human = new Human(age, name);

                } catch (WrongAgeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Input human's age again:");
                    age = parsInt(br);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return human;
    }

    public static int parsInt(BufferedReader br) throws IOException {
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("It is not a number \nTry again:");
            }
        }
        return number;
    }

    public static void addToArray() {
        while (temp < array.length - 1) {
            System.out.println("Human #" + (temp + 2));
            array[++temp] = ctreateHuman();

        }
    }

    public static void printArray() {
        for (Human i : array) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + "]";
    }

}