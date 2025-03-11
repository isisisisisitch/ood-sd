package ca.bytetube.ood._09_packagedeliverycost;

public class Main {
    public static void main(String[] args) {
        Member member = new Member("M001", "Dal", MembershipLevel.GOLD);// 0.9
        Order order = new Order(member);

     Package pack1 = new BasePackage(Size.LARGE, DeliverySpeed.SAME_DAY);// $6
        pack1 = new GiftWrapDecorator(pack1);// $12
        order.addPackage(pack1);

        Package pack2 = new BasePackage(Size.MEDIUM, DeliverySpeed.NEXT_DAY);// $15
        pack2 = new GiftWrapDecorator(pack2);// $19.5
        pack2 = new FragilePackingDecorator(pack2);// $27
        order.addPackage(pack2);

        order.printOrderDetails();// $35.1
    }
}