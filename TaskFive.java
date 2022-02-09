import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFive<T> {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
      return  Stream.concat(first,second);
    }

    public static void main(String[] args) {
        Stream<Integer> integerStream = zip(Stream.of(1,2,3,4,5),Stream.of(6,7,8,9,10));
        List<Integer> collect= integerStream.collect(Collectors.toList());
        System.out.println(collect);
    }
}
