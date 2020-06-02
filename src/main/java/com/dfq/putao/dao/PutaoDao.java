package com.dfq.putao.dao;

import com.dfq.putao.domain.Putao;
import com.dfq.putao.domain.Users;
import com.github.pagehelper.Page;


/**
 * @author Mr Duan
 * @create 2020-06-02 17:14
 */
public interface PutaoDao {
    Page<Putao> findByPhone(Putao users);

    /**
     * 分页查询
     *
     * @return {@link Users}
     */
    Page<Putao> findByPage();

    /**
     * 新增
     *
     * @param users
     */
    void insert(Putao users);

    /**
     * 修改
     *
     * @param users
     */
    void update(Putao users);

    /**
     * 通过ID删除单个
     *
     *
     */
    void deleteById(Putao users);
    //登录
    Users login(Putao users);
}
