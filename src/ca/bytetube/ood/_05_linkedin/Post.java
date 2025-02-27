package ca.bytetube.ood._05_linkedin;

public class Post {
    int postId;
    String information;

    public Post(int postId, String information) {
        this.postId = postId;
        this.information = information;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
