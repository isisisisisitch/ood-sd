package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;

public class ExtensionFilter implements Filter {
    private String extension;


    public ExtensionFilter(String extension) {
        this.extension = extension.toLowerCase();
    }


    @Override
    public boolean matches(File file) {

        if (!file.isFile()) return false;
        String name = file.getName().toLowerCase();
        return name.endsWith("." + extension);
    }
}
