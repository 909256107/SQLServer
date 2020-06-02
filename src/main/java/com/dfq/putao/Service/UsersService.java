package com.dfq.putao.Service;

import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Users;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:51
 */
public interface UsersService {
    /*
   分页查询所有
    */
    EUDataGridResult findByPage(int pageNum, int pageSize);
    //分页查询单个
    EUDataGridResult findByPhone(int pageNum, int pageSize, Users users);
    //添加
    void insert(Users users);
    //更新
    void update(Users users);
    //删除单个
    void deleteById(Users users);
    //登录
    Users login(Users users);



}
