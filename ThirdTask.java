import java.util.Arrays;
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
        List<String> list = Arrays.stream(generalMassive)
                .filter(ThirdTask::isDigit)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        String[] newString = {"1, 2, 0", "4, 5"};
        ThirdTask thirdTask = new ThirdTask();
        thirdTask.findAndSort(newString);
    }
}
