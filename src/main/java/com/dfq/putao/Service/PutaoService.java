package com.dfq.putao.Service;

import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Putao;
import com.dfq.putao.domain.Users;

/**
 * @author Mr Duan
 * @create 2020-06-02 17:15
 */
public interface PutaoService {
    EUDataGridResult findByPage(int pageNum, int pageSize);
    //分页查询单个
    EUDataGridResult findByPhone(int pageNum, int pageSize, Putao users);
    //添加
    void insert(Putao users);
    //更新
    void update(Putao users);
    //删除单个
    void deleteById(Putao users);
}
