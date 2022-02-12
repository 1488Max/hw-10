import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFive<T> {
    public static <T> Stream<String> zip(Supplier<Stream<T>> first, Supplier<Stream<T>> second){
        List<T> firstList = first.get().collect(Collectors.toList());
        List<T> secondList = second.get().collect(Collectors.toList());
        int counter1 = (int) first.get().count();
        int counter2 = (int) second.get().count();
        if(counter1>counter2){
            return second.get().map(p-> firstList.get(secondList.indexOf(p)) + ", " + p);
        }

        else {
            return first.get().map(p-> p + ", " + secondList.get(firstList.indexOf(p)));
        }

    }

    public static void main(String[] args) {
        String[] array1 = {"1","2","3","4","5"};
        String[] array2 = {"6","7","8","9","10"};
        Supplier<Stream<String>> streamSupplier1 = () -> Stream.of(array1);
        Supplier<Stream<String>> streamSupplier2 = () -> Stream.of(array2);
        System.out.println( zip(streamSupplier1,streamSupplier2).collect(Collectors.toList()));
    }
}
