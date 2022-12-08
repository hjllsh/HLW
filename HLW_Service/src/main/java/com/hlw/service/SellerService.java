package com.hlw.service;

import com.hlw.domain.Store;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SellerService {
    public void sellerAdd(Store store);
}
