package com.hlw.service.impl;

import com.hlw.dao.SellerDao;
import com.hlw.domain.Store;
import com.hlw.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerDao sellerDao;
    public void sellerAdd(Store store) {
        sellerDao.sellerAdd(store);
    }
}
