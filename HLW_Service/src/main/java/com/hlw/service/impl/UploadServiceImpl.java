package com.hlw.service.impl;

import com.hlw.dao.UploadDao;
import com.hlw.domain.Goods;
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
}
