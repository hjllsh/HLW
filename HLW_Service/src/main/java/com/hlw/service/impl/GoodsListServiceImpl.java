package com.hlw.service.impl;

import com.hlw.constant.PageResult;
import com.hlw.constant.Pagination;
import com.hlw.dao.GoodsListDao;
import com.hlw.domain.GoodsList;
import com.hlw.service.GoodsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsListServiceImpl implements GoodsListService {
    @Autowired
    GoodsListDao goodsListDao;

    public PageResult<GoodsList> showGoodsList(Pagination pagination) {
        String temple = pagination.getPageSize().toString();
        int pageSize = Integer.parseInt(temple);
        String temple1 = pagination.getCurrentPage().toString();
        int currentPage = Integer.parseInt(temple1);
        int start = (currentPage-1)*pageSize;
        String searchData = pagination.getSearchData();
        List<GoodsList> goodsLists = goodsListDao.showGoodsList(start, pageSize, searchData);
        List<GoodsList> realGoodsLists = new ArrayList<GoodsList>();
        //加后缀
        for (GoodsList goodsList : goodsLists) {
            String goodsLinkurl = "maininfo.html?goodsId="+goodsList.getGoodsId();
            goodsList.setGoodsLinkurl(goodsLinkurl);
            realGoodsLists.add(goodsList);
        }
        Integer total = goodsListDao.findTotal(searchData);
        PageResult<GoodsList> pageResult = new PageResult<GoodsList>();
        pageResult.setDataForm(realGoodsLists);
        pageResult.setTotal(String.valueOf(total));
        pageResult.setFlag(true);
        return pageResult;
    }
}
