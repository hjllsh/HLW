package com.hlw.service;

import com.hlw.domain.Goods;
import com.hlw.domain.GoodsImg;
import com.hlw.domain.GoodsList;

public interface UploadService {
    void releaseGoods(Goods goods);

    void uploadImages(GoodsImg goodsImg);

    String findStoreName(String userId);

    void uploadGoodsList(GoodsList goodsList);
}
