package com.hlw.service;

import com.hlw.constant.PageResult;
import com.hlw.constant.Pagination;
import com.hlw.domain.GoodsList;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GoodsListService {
    PageResult<GoodsList> showGoodsList(Pagination pagination);
}
