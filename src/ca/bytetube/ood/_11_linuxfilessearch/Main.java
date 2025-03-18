package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileFinder finder = new FileFinder();

        //查找大于1MB的文件
//        List<File> largeFiles = finder.findLargeFiles("/Users/dall./Desktop/apache-tomcat-8.5.55", 1 * 1024 * 1024);
//        System.out.println("Files larger than 1MB:");
//        largeFiles.forEach(file -> System.out.println(file.getAbsolutePath()));
//
//        //查找XML文件
//        List<File> xmlFiles = finder.findByExtension("/Users/dall./Desktop/apache-tomcat-8.5.55", "xml");
//        System.out.println("\nXML files:");
//        xmlFiles.forEach(file -> System.out.println(file.getAbsolutePath()));

        // 复杂查询：查找大于1MB的XML文件
        Filter complexFilter = new AndFilter(
                new SizeFilter(1 * 1024 * 1024),
                new ExtensionFilter("xml")
        );
        List<File> largeXmlFiles = finder.find("/Users/dall./Desktop/apache-tomcat-8.5.55", complexFilter);
        System.out.println("\nXML files larger than 1MB:");
        largeXmlFiles.forEach(file -> System.out.println(file.getAbsolutePath()));

        // 使用OR过滤器：查找XML文件或大于10MB的文件
        Filter orFilter = new OrFilter(
                new ExtensionFilter("xml"),
                new SizeFilter(10 * 1024 * 1024)
        );
        List<File> xmlOrLargeFiles = finder.find("/Users/dall./Desktop/apache-tomcat-8.5.55", orFilter);
        System.out.println("\nXML files or files larger than 10MB:");
        xmlOrLargeFiles.forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}
