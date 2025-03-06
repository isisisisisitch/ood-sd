package ca.bytetube.ood._08_pizza._factory_decorator;

public class Member {
    private String id;
    private String name;
    private MembershipLevel level;

    public Member(String id, String name, MembershipLevel level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public MembershipLevel getLevel() {
        return level;
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

    public void setLevel(MembershipLevel level) {
        this.level = level;
    }

    // getters and setters
}
