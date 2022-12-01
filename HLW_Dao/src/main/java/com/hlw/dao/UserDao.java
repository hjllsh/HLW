package com.hlw.dao;

public interface UserDao {
    void findUserById(Integer id);

    Float findAccountById(String id);

    int UpdateAccoumtByid(String id, Float newAccount);
}
