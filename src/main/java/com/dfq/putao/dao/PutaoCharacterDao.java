package com.dfq.putao.dao;

import com.dfq.putao.domain.Putao;
import com.dfq.putao.domain.PutaoCharacter;
import com.dfq.putao.domain.Users;
import com.github.pagehelper.Page;

/**
 * @author Mr Duan
 * @create 2020-06-02 17:22
 */
public interface PutaoCharacterDao {
    Page<PutaoCharacter> findByPhone(PutaoCharacter users);

    /**
     * 分页查询
     *
     * @return {@link Users}
     */
    Page<PutaoCharacter> findByPage();

    /**
     * 新增
     *
     * @param users
     */
    void insert(PutaoCharacter users);

    /**
     * 修改
     *
     * @param users
     */
    void update(PutaoCharacter users);

    /**
     * 通过ID删除单个
     *
     *
     */
    void deleteById(PutaoCharacter users);

}
