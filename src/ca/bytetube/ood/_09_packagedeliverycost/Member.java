package ca.bytetube.ood._09_packagedeliverycost;

public class Member {
    private String id;
    private String name;
    private MembershipLevel level;

    public Member(String id, String name, MembershipLevel level) {
        this.id = id;
        this.name = name;
        this.level = level;
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

    public MembershipLevel getLevel() {
        return level;
    }

    public void setLevel(MembershipLevel level) {
        this.level = level;
    }
}
