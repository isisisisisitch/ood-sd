package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DFSFileScanStrategy implements FileScanStrategy {

    @Override
    public List<File> scan(File directory, Filter filter) {
        List<File> result = new ArrayList<>();
        if (!directory.isDirectory()) return result;
        scanDirectory(directory, filter, result);

        return result;
    }

    public void scanDirectory(File directory, Filter filter, List<File> result) {
        File[] files = directory.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isFile() && filter.matches(file)) result.add(file);
            else if (file.isDirectory()) scanDirectory(file, filter, result);
        }
    }
}
