package ca.bytetube.ood._06_bookreservation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("A0001", "OOD and SYSTEM DESIGN", 4, "DAL", "ISBN0001");
        Book book2 = new Book("A0002", "java basic", 2, "James", "ISBN0002");
        Book book3 = new Book("A0003", "python basic", 1, "Karl", "ISBN0003");
        Book book4 = new Book("A0004", "OPERATING SYSTEM", 1, "ALAN", "ISBN0004");
        CD cd1 = new CD("C0001","BLACK AND WHITE",1,"MJ",60);


        library.addResource(book1);
        library.addResource(book2);
        library.addResource(book3);
        library.addResource(book4);
        //test search

        List<Resource> resourceResults = library.search("SYSTEM");
        resourceResults.forEach(resource ->
                System.out.println("search result:" + resource.getName()));

        //test reserve
        String user1 = "U0001";
        String user2 = "U0002";
        String user3 = "U0003";
        String user4 = "U0004";


        boolean reserved1 = library.reserve("A0001", user1);
        System.out.println(reserved1);
        boolean reserved2 = library.reserve("A0001", user2);
        System.out.println(reserved2);
        boolean reserved3 = library.reserve("A0001", user3);
        System.out.println(reserved3);
        boolean reserved4 = library.reserve("A0001", user4);
        System.out.println(reserved4);


        //test release
        library.release("A0001", user1);

        //test resource status
        Resource resource = library.getResource("A0001");
        if (resource != null) {
            System.out.println("resource " + resource.getName() + " current available quantity:" + resource.getAvailableQuantity());
            System.out.println("resource " + resource.getName() + " waiting list len:" + resource.getWaitingList().size());

        } else {
            System.out.println("there is no A0001 resource");
        }


    }
}
