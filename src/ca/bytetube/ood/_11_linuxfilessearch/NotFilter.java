package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class NotFilter implements Filter {
    private Filter filter;

    public NotFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public boolean matches(File file) {
        return !filter.matches(file);
    }
}
