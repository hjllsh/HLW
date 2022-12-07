package com.hlw.dao;

import com.hlw.domain.GoodsList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsListDao {
    public List<GoodsList> showGoodsList(@Param("start") Integer start, @Param("size") Integer pageSize, @Param("queryString") String searchData);
    public Integer findTotal(@Param("queryString") String searchData);
}
