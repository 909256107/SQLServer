package com.dfq.putao.Service;

import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.PutaoCharacter;

/**
 * @author Mr Duan
 * @create 2020-06-02 17:26
 */
public interface PutaoCharacterService {
    EUDataGridResult findByPage(int pageNum, int pageSize);
    //分页查询单个
    EUDataGridResult findByPhone(int pageNum, int pageSize, PutaoCharacter putaoCharacter);
    //添加
    void insert(PutaoCharacter users);
    //更新
    void update(PutaoCharacter users);
    //删除单个
    void deleteById(PutaoCharacter users);
}
