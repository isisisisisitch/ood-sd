package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;

public class SizeFilter implements Filter {
    private long minSize;
    private long maxSize;

    public SizeFilter(long minSize) {
        this.minSize = minSize;
    }

    public SizeFilter(long minSize, long maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean matches(File file) {

        return file.isFile() && file.length() >= minSize && file.length() <= maxSize;

    }
}
