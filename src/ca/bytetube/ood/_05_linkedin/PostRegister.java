package ca.bytetube.ood._05_linkedin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PostRegister {
    Map<Post, Account> posts = new HashMap<>();
    Map<Post, List<Comment>> comments = new HashMap<>();
    Map<Post, List<Account>> likes = new HashMap<>();

    public Post makePost(String content, Account user) {
        Post newPost = new Post(posts.size(), content);
        posts.put(newPost, user);
        return newPost;
    }

    public void addComments(Post post, String content, Account user) {
        List<Comment> tmp = new LinkedList<>();
        if (comments.containsKey(post)) {
            tmp = comments.get(post);
        }
        tmp.add(new Comment(content, user));
        comments.put(post, tmp);
    }

    public void likes(Post post, Account user) {
        List<Account> tmp = new LinkedList<>();
        if (likes.containsKey(post)) {
            tmp = likes.get(post);
        }
        tmp.add(user);
        likes.put(post, tmp);
    }

    private Post findPost(int postId) {
        Post ans = null;

        for (Map.Entry<Post, Account> entry : posts.entrySet()) {
            if (entry.getKey().getPostId() == postId) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }

    public Account findCreator(Post post) {
        Account ans = null;

        for (Map.Entry<Post, Account> entry : posts.entrySet()) {
            if (entry.getKey().getPostId() == post.getPostId()) {
                ans = entry.getValue();
                break;
            }
        }
        return ans;
    }

}
