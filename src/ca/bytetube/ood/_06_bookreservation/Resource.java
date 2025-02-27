package ca.bytetube.ood._06_bookreservation;

import java.util.LinkedList;
import java.util.Queue;

public class Resource {
    private String id;
    private String name;
    private int totalQuantity;
    private int availableQuantity;
    private Queue<String> waitingList;//每个资源维护自己的queue（存储用户id）

    public Resource(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.totalQuantity = quantity;
        this.availableQuantity = quantity;
        waitingList = new LinkedList<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Queue<String> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(Queue<String> waitingList) {
        this.waitingList = waitingList;
    }
}
