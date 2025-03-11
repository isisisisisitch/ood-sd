package ca.bytetube.ood._09_packagedeliverycost;

public class MembershipDiscount {
    private final Member member;

    public MembershipDiscount(Member member) {
        this.member = member;
    }

    public double applyDiscount(double originalPrice) {
        return originalPrice * member.getLevel().getDiscountMultiplier();
    }

    public String getDescription() {
        return "Membership " + member.getLevel() + " Discount";
    }
}
