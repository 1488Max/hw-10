import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdTask {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void findAndSort(String[] values){
        String str = Arrays.toString(values);
        String[] generalMassive = str.split("[\\p{Punct}\\s]+");
        List<Integer> list = Arrays.stream(generalMassive)
                .filter(ThirdTask::isDigit)
                .map(v->Integer.parseInt(v))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        String[] newString = {"1, 2, 0", "4, 5","12, 11, 10, 11"};
        ThirdTask thirdTask = new ThirdTask();
        thirdTask.findAndSort(newString);
    }
}
