import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {
    public void sort(String input, List<String> in){
        StringBuilder stringBuilder = new StringBuilder();
        char [] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length-3) {
                if (chars[i] == 'E')
                    if (chars[i + 1] == 'A')
                        if (chars[i + 2] == 'A')
                            stringBuilder.insert(i, "\n");
            }
            stringBuilder.append(chars[i]);
        }

        in.add(stringBuilder.toString());
    }
}
