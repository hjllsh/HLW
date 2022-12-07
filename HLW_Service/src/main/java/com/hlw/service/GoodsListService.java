package com.hlw.service;

import com.hlw.constant.PageResult;
import com.hlw.constant.Pagination;
import com.hlw.domain.GoodsList;

import java.util.List;

public interface GoodsListService {
    PageResult<GoodsList> showGoodsList(Pagination pagination);
}
