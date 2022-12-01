package com.hlw.dao.impl;

import com.hlw.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    public void findUserById(Integer id) {
        System.out.println("user dao ..."+id);
    }

    public Float findAccountById(String id){
        Float account = Float.valueOf(0);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        account = sqlSession.selectOne("selectAccount", id);
        return account;
    }

    public int UpdateAccoumtByid(String id, Float newAccount){
        Map<String, Object> map = new HashMap<String, Object>();
        int count = 0;
        SqlSession sqlSession = SqlSessionUtil.openSession();
        count = sqlSession.update("UpdateAccount",map);
        return count;
    }
}
