package app.entity;

public class Liked {
    private int likedId;
    private int fromWho;
    private int toWhom;
    private boolean isLiked = false;

    public Liked(int likedId, int fromWho, int toWhom) {
        this.likedId = likedId;
        this.fromWho = fromWho;
        this.toWhom = toWhom;
    }

    public Liked(int fromWho, int toWhom) {
        this.fromWho=fromWho;
        this.toWhom=toWhom;
    }


    public Liked() {

    }

    public int getLikedId() {
        return likedId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void setLikedId(int likedId) {
        this.likedId = likedId;
    }

    public int getFromWho() {
        return fromWho;
    }

    public void setFromWho(int fromWho) {
        this.fromWho = fromWho;
    }

    public int getToWhom() {
        return toWhom;
    }

    public void setToWhom(int toWhom) {
        this.toWhom = toWhom;
    }
}
