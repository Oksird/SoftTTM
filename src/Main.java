import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static final String DIR_PATH = "C:\\Users\\romak\\Desktop\\logs";
    //   /Users/max/Desktop/logs

    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {

            WriterToFile writer = new WriterToFile();
            FileFinder fileFinder = new FileFinder();
            StringBuilder listToWrite = new StringBuilder();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the source directory:");
            String sourceDirectory = "/Users/max/Desktop/logs";

            while (!new File(sourceDirectory).exists()) {
                System.out.println("Enter the existing source directory");
                sourceDirectory = scanner.nextLine();
            }

            List<String> list = fileFinder.listFilesForFolder(new File(sourceDirectory));
            FutureTask[] futureTasks = new FutureTask[list.size()];


            for (int i = 0; i < list.size(); i++) {
                Callable<List<String>> callable = new ReaderFiles(new File(list.get(i)));
                futureTasks[i] = new FutureTask(callable);

                Thread t = new Thread(futureTasks[i]);
                t.start();
            }

            for (FutureTask f : futureTasks) {
                String string = writer.parse(f.get().toString());
                listToWrite.append(string);
            }

            writer.write(listToWrite.toString());

            System.out.println(listToWrite);
        }
    }
