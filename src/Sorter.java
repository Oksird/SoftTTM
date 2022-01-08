import java.util.Arrays;
import java.util.List;

public class Sorter {
    public void sort(String input, List<String> in){
        int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isSorted = false;
        int buf;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < (numbers != null ? numbers.length : 0) -1; i++) {
                if(numbers[i] > numbers[i+1]){
                    isSorted = false;

                    buf = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = buf;
                }
            }
        }
        in.add(Arrays.toString(numbers));
    }
}
