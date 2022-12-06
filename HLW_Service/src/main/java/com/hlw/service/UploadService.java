package com.hlw.service;

import com.hlw.domain.Goods;
import com.hlw.domain.GoodsImg;

public interface UploadService {
    void releaseGoods(Goods goods);

    void uploadImages(GoodsImg goodsImg);
}
