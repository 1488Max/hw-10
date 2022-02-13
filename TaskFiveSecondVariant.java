import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFiveSecondVariant {

    static Stream<Object> third = Stream.empty();
    static Supplier<Object> supplier3 = () -> third;
    static long currentIndex = 0;

    public static <T> Stream<T> zip(Supplier<Stream<T>> first, Supplier<Stream<T>> second) {
        int counter1 = (int) first.get().count();
        int counter2 = (int) second.get().count();

        if(counter1 > counter2){
            second.get().forEachOrdered(x -> {
                Optional<T> findFirst = (Optional<T>) first.get().skip(currentIndex).findFirst();
                Stream<T> n = (Stream<T>) Stream.of(findFirst.orElse((T) findFirst),x);
                third =  Stream.concat(third, n);
                currentIndex++;

            });
        }
        else {
            first.get().forEachOrdered(x -> {
                Optional<T> findSecond = (Optional<T>) second.get().skip(currentIndex).findFirst();
                Stream<T> n = (Stream<T>) Stream.of(x, findSecond.orElse((T) findSecond));
                third = Stream.concat(third, n);
                currentIndex++;

            });
        }
        return (Stream<T>) third;

    }

    public static void main(String[] args) {
        String[] array1 = {"1","2","3","4","5"};
        String[] array2 = {"6","7","8","9"};
        Supplier<Stream<String>> streamSupplier1 = () -> Stream.of(array1);
        Supplier<Stream<String>> streamSupplier2 = () -> Stream.of(array2);
        System.out.println( zip(streamSupplier1,streamSupplier2).collect(Collectors.toList()).toString());
    }
}
