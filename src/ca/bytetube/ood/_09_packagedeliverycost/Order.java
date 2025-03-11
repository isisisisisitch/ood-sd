package ca.bytetube.ood._09_packagedeliverycost;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private static int orderCounter = 0;
    private List<Package> packages = new ArrayList<>();
    private Member member;

    public Order(Member member) {
        this.orderId = ++orderCounter;
        this.member = member;
    }

    public void addPackage(Package p) {
        packages.add(p);
    }

    public double getSubtotal() {
        return packages.stream().mapToDouble(Package::getCost).sum();
    }

    public double getTotalPrice() {
        double price = getSubtotal();
        if (member != null && member.getLevel() != MembershipLevel.NONE) {
            MembershipDiscount discount = new MembershipDiscount(member);
            price = discount.applyDiscount(price);
        }
        return price;
    }

    public void printOrderDetails() {
        System.out.println("Order #" + orderId);

        if (member != null) {
            System.out.println("Member: " + member.getName() + " (" + member.getLevel() + ")");
        }

        System.out.println("\nItems:");
        packages.forEach(p ->
                System.out.println("- " + p.getDescription() +
                        " : $" + String.format("%.2f", p.getCost())));

        System.out.println("\nSubtotal: $" + String.format("%.2f", getSubtotal()));

        System.out.println("Final Total: $" + String.format("%.2f", getTotalPrice()));
    }
}
