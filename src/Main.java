import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class Main {
    public static final String DIR_PATH = "C:\\Users\\romak\\Desktop\\logs";
    //   /Users/max/Desktop/logs

    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {

            WriterToFile writer = new WriterToFile();
            FileFinder fileFinder = new FileFinder();

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
                Callable callable = new ReaderFiles(new File(list.get(i)));
                futureTasks[i] = new FutureTask(callable);

                Thread t = new Thread(futureTasks[i]);
                t.start();
            }

          //  List<String> listToWrite = new ArrayList<>();
        StringBuilder listToWrite = new StringBuilder();

            for (FutureTask f : futureTasks) {
                System.out.println("\n");
                String string = writer.parse(f.get().toString());
                listToWrite.append(string);
            }

            writer.write(listToWrite.toString());

            System.out.println(listToWrite);
        }

        public static int counter = 1;

    }
