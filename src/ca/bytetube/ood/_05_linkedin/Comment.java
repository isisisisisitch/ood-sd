package ca.bytetube.ood._05_linkedin;

public class Comment {
    String comment;
    Account userId;

    public Comment(String comment, Account userId) {
        this.comment = comment;
        this.userId = userId;
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getUserId() {
        return userId;
    }

    public void setUserId(Account userId) {
        this.userId = userId;
    }

}
