package com.hlw.domain;

import java.util.List;
import java.util.Objects;

public class goodsImg {
    private String userId;
    private String goodsId;
    private List<String> img;

    public goodsImg() {
    }

    public goodsImg(String userId, String goodsId, List<String> img) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.img = img;
    }

    @Override
    public String toString() {
        return "goodsImg{" +
                "userId='" + userId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", img=" + img +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        goodsImg goodsImg = (goodsImg) o;
        return Objects.equals(userId, goodsImg.userId) && Objects.equals(goodsId, goodsImg.goodsId) && Objects.equals(img, goodsImg.img);
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }
}
