package com.hlw.domain;

import java.util.List;


public class goodsImg {
    private String userId;
    private int goodsId;
    private List<String> img;

    public goodsImg() {
    }

    @Override
    public String toString() {
        return "goodsImg{" +
                "userId='" + userId + '\'' +
                ", goodsId=" + goodsId +
                ", img=" + img +
                '}';
    }

    public goodsImg(String userId, int goodsId, List<String> img) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.img = img;
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
