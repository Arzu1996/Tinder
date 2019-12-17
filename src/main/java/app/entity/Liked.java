package app.entity;

public class Liked {
    private int likedId;
    private boolean isLiked = false;

    public int getLikedId() {
        return likedId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
