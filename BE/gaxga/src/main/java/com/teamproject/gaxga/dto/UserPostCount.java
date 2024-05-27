package com.teamproject.gaxga.dto;

public class UserPostCount {

    private String gaNick;
    private Long postCount;

    public UserPostCount(String gaNick, Long postCount) {
        this.gaNick = gaNick;
        this.postCount = postCount;
    }

    // Getters and Setters
    public String getGaNick() {
        return gaNick;
    }

    public void setGaNick(String gaNick) {
        this.gaNick = gaNick;
    }

    public Long getPostCount() {
        return postCount;
    }

    public void setPostCount(Long postCount) {
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        return
                gaNick + '\'' +
                ", postCount=" + postCount +
                '}';
    }
}
