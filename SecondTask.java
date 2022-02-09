import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.IntStream;

public class SecondTask {
    public void sortByUnnaturalOrder(ArrayList<String> names){
        names.stream()
                .map(s -> new String(s.toUpperCase(Locale.ROOT)))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Mark");
        names.add("Ivan");
        names.add("Igor");
        names.add("Eugen");
        names.add("Max");
        names.add("Marik");
        names.add("Frog");
    SecondTask secondTask = new SecondTask();
    secondTask.sortByUnnaturalOrder(names);
    }
}
