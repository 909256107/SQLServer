package com.dfq.putao.dao;

import com.dfq.putao.domain.Users;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:49
 */
public interface UsersDao {
    Page<Users> findByPhone(Users users);
    List<Users> getAll(@Param("content") Map map);
    /**
     * 分页查询
     *
     * @return {@link Users}
     */
    Page<Users> findByPage();

    /**
     * 新增
     *
     * @param users
     */
    void insert(Users users);

    /**
     * 修改
     *
     * @param users
     */
    void update(Users users);

    /**
     * 通过ID删除单个
     *
     *
     */
    void deleteById(Users users);
    //登录
    Users login(Users users);

    //初始化数据库
    void init();

}
