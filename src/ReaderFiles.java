import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;


public class ReaderFiles implements Callable<List<String>> {
    private final File file;
    private String fileName;
    private List<String> lines;

    public ReaderFiles(File file) {
        this.file = file;
    }

    @Override
    public List<String> call() {
        List<String> list = new ArrayList<>();
        try {
            readFile();
            list.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void readFile() throws IOException {
        String in;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<String> listOfSorted = new ArrayList<>();
        Sorter sorter = new Sorter();
      /*

       while ((in = bufferedReader.readLine()) != null) {
            sorter.sort(in, listOfSorted);

        }
       */

        in =  bufferedReader.lines().collect(Collectors.joining());
        sorter.sort(in,listOfSorted);




        setLines(listOfSorted);
        setFileName(file.getName());

        bufferedReader.close();
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
