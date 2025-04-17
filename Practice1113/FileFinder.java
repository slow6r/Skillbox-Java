import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {
    public static List<File> findFiles(String path, List<String> extensions) {
        List<File> result = new ArrayList<>();
        File root = new File(path);
        searchFiles(root, extensions, result);
        return result;
    }

    private static void searchFiles(File dir, List<String> extensions, List<File> result) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchFiles(file, extensions, result);
            } else {
                String ext = getFileExtension(file.getName());
                if (extensions.contains(ext)) {
                    result.add(file);
                }
            }
        }
    }

    private static String getFileExtension(String name) {
        int lastIndex = name.lastIndexOf('.');
        return lastIndex == -1 ? "" : name.substring(lastIndex + 1);
    }
}