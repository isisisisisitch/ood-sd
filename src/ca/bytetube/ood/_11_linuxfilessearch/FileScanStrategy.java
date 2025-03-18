package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;
import java.util.List;

public interface FileScanStrategy {

    List<File> scan(File directory, Filter filter);

}
