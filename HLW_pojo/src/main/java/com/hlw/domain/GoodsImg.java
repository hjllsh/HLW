package com.hlw.domain;

import java.util.List;
import java.util.Objects;


public class GoodsImg {
    private String userId;
    private int goodsId;
    private List<String> img;

    public GoodsImg() {
    }

    @Override
    public String toString() {
        return "GoodsImg{" +
                "userId='" + userId + '\'' +
                ", goodsId=" + goodsId +
                ", img=" + img +
                '}';
    }

    public GoodsImg(String userId, int goodsId, List<String> img) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.img = img;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsImg goodsImg = (GoodsImg) o;
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

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }
}
