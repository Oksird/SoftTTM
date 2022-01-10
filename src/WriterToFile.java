import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {
    public void write(String line) throws IOException {

        File file = new File("/Users/max/Desktop/LabJava/New/SOS.txt");
        boolean check = true;
        try {
            if (!file.exists()) {
                check = file.createNewFile();
                System.out.println("File created!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            FileWriter writer = new FileWriter(file);

                writer.write(line);

            System.out.println("Data written to file " + file.getName());
            writer.close();
        }
    }

    public String parse(String string) {
        string = string.substring(1, string.length() - 1);

        return string;
    }
}