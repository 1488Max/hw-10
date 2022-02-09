import java.util.ArrayList;
import java.util.stream.IntStream;

public class FirstTask {
    static class IndexedValue {
         int index;
        String name;
        IndexedValue(int index, String name) {
            this.index = index ;
            this.name = name ;
        }
        int getIndex() { return index ;}

        @Override
        public String toString() {
            return "{" +
                    "index=" + index +
                    ", name='" + name + '\'' +
                    '}';
        }

    }
    public void oddIndex(ArrayList<String> names){

        IntStream.range(0, names.size()).mapToObj(s -> new IndexedValue(s, names.get(s)))
                .filter(v -> v.getIndex() % 2 == 1)
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
        FirstTask firstTask = new FirstTask();
        firstTask.oddIndex(names);
    }
}
