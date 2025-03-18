package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSFileScanStrategy implements FileScanStrategy {
    @Override
    public List<File> scan(File directory, Filter filter) {
        List<File> result = new ArrayList<>();
        if (!directory.isDirectory()) return result;
        Queue<File> queue = new LinkedList<>();
        queue.add(directory);
        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] files = current.listFiles();
            if (files == null) continue;
            for (File f : files) {
                if (f.isFile() && filter.matches(f)) result.add(f);
                else if (f.isDirectory()) queue.add(f);
            }
        }


        return result;
    }
}
