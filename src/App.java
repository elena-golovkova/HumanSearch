import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws WrongAgeException {
        /*Human.addToArray();
        Human.printArray();*/

        Human h1 = new Human(22, "Olga");
        Human h2 = new Human(15, "Miha");
        Human h3 = new Human(64, "Lola");
        Human h4 = new Human(64, "Saha");

        Human [] newArray = {h4, h2, h3, h1};
        for (Human human : newArray) {
            System.out.println(human);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //сортировка объектов Human, анономный класс, лямбда выражения
        Arrays.sort(newArray, (o1, o2) -> o1.getAge()-o2.getAge());


        for (Human human : newArray) {
            System.out.println(human);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Arrays.sort(newArray, new HumanComparator());
        for (Human human : newArray) {
            System.out.println(human);
        }
        //сортировка объектов Human, анономный класс
        Arrays.sort(newArray, new Comparator<Human>() {

            @Override
            public int compare(Human o1, Human o2) {

                return o1.getAge()-o2.getAge();
            }
        });

    }

}