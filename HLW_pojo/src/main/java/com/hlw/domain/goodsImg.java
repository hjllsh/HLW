package com.hlw.domain;

import java.util.Objects;

public class goodsImg {
    private String userId;
    private int goodsId;
    private String img;

    public goodsImg() {
    }

    public goodsImg(String userId, int goodsId, String img) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.img = img;
    }

    @Override
    public String toString() {
        return "goodsImg{" +
                "userId='" + userId + '\'' +
                ", goodsId=" + goodsId +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        goodsImg goodsImg = (goodsImg) o;
        return goodsId == goodsImg.goodsId && Objects.equals(userId, goodsImg.userId) && Objects.equals(img, goodsImg.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, goodsId, img);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
