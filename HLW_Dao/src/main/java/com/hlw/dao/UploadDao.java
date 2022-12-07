package com.hlw.dao;

import com.hlw.domain.Goods;
import com.hlw.domain.GoodsList;
import org.apache.ibatis.annotations.Param;

public interface UploadDao {
    void releaseGoods(Goods goods);

    void uploadImages(@Param("userId") String userId, @Param("goodsId") String goodsId, @Param("image") String image);

    String findStoreName(@Param("userId") String userId);

    void uploadGoodsList(GoodsList goodsList);
}
