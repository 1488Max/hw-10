import java.util.stream.Stream;

public class TaskFour {
    public void random(long seed){
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2,48);
        Stream.iterate(seed,x -> (a*x +c)%m).filter(x->x>0).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TaskFour taskFour = new TaskFour();
        taskFour.random(5);
    }


}
