package jsp.entities;

/**
 * Created by Hao on 4/14/16.
 */
public class Route {
    private String username;
    private String title;
    private String srartLocation;
    private String endLocation;
    private int review;
    private String postDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrartLocation() {
        return srartLocation;
    }

    public void setSrartLocation(String srartLocation) {
        this.srartLocation = srartLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
}
