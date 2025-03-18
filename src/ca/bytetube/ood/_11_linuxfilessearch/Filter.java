package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;

public interface Filter {
    boolean matches(File file);
}
