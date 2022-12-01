package com.hlw.utils;

import java.util.UUID;

public class UuId {
    public static String getUuId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
