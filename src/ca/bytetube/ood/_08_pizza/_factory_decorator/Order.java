package ca.bytetube.ood._08_pizza._factory_decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Pizza> pizzas = new ArrayList<>();
    private final List<DiscountStrategy> discounts = new ArrayList<>();
    private final int orderId;
    private static int orderCounter = 0;
    private Member member;

    public Order(Member member) {
        this.orderId = ++orderCounter;
        this.member = member;
        if (member != null && member.getLevel() != MembershipLevel.NONE) {
            addDiscount(new MembershipDiscount(member));
        }
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDiscount(DiscountStrategy discount) {
        discounts.add(discount);
    }

    public double getSubtotal() {
        return pizzas.stream()
                .mapToDouble(Pizza::getCost)
                .sum();
    }

    public double getTotalPrice() {
        double price = getSubtotal();
        for (DiscountStrategy discount : discounts) {
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
        pizzas.forEach(pizza ->
                System.out.println("- " + pizza.getDescription() +
                        " : $" + String.format("%.2f", pizza.getCost())));

        System.out.println("\nSubtotal: $" + String.format("%.2f", getSubtotal()));

        if (!discounts.isEmpty()) {
            System.out.println("\nApplied Discounts:");
            discounts.forEach(discount ->
                    System.out.println("- " + discount.getDescription()));
        }

        System.out.println("Final Total: $" + String.format("%.2f", getTotalPrice()));
    }
}

