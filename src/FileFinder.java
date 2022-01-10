import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileFinder {
    public List<String> listFilesForFolder(final File folder) {
        List<String> list = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                list.addAll(listFilesForFolder(fileEntry));
            } else {
                if (fileEntry.getAbsolutePath().endsWith("Cookies_JSON.txt")) {
                    list.add(fileEntry.getAbsolutePath());
                    System.out.println("Path is added");
                }
                if (fileEntry.getAbsolutePath().endsWith("User_Agent.txt")) {
                    list.add(fileEntry.getAbsolutePath());
                    System.out.println("Path is added");
                }
            }
        }
        return list;
    }

}
