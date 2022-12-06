package com.hlw.service.impl;

import com.hlw.dao.UploadDao;
import com.hlw.domain.Goods;
import com.hlw.domain.GoodsImg;
import com.hlw.domain.GoodsList;
import com.hlw.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    UploadDao uploadDao;
    public void releaseGoods(Goods goods) {
        uploadDao.releaseGoods(goods);
    }

    public void uploadImages(GoodsImg goodsImg) {
        String goodsId = goodsImg.getGoodsId();
        String userId = goodsImg.getUserId();
        for (String image : goodsImg.getImg()) {
            System.out.println(image);
            uploadDao.uploadImages(userId,goodsId,image);
        }
    }

    public String findStoreName(String userId) {
        return uploadDao.findStoreName(userId);
    }

    public void uploadGoodsList(GoodsList goodsList) {
        uploadDao.uploadGoodsList(goodsList);
    }
}
