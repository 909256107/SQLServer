package com.dfq.putao.Service.impl;

import com.dfq.putao.Service.PutaoCharacterService;
import com.dfq.putao.dao.PutaoCharacterDao;
import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Putao;
import com.dfq.putao.domain.PutaoCharacter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Duan
 * @create 2020-06-02 17:26
 */
@Service
public class PutaoCharacterServiceImpl implements PutaoCharacterService {
    @Autowired
    private PutaoCharacterDao putaoCharacterDao;
    @Override
    public EUDataGridResult findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PutaoCharacter> list = putaoCharacterDao.findByPage();
        System.out.println(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<PutaoCharacter> usersPageInfo = new PageInfo<>(list);
        result.setTotal(usersPageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult findByPhone(int pageNum, int pageSize, PutaoCharacter putaoCharacter) {
        PageHelper.startPage(pageNum, pageSize);
        List<PutaoCharacter> list = putaoCharacterDao.findByPhone(putaoCharacter);
        System.out.println(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<PutaoCharacter> usersPageInfo = new PageInfo<>(list);
        result.setTotal(usersPageInfo.getTotal());
        return result;
    }


    @Override
    public void insert(PutaoCharacter users) {
        putaoCharacterDao.insert(users);
    }

    @Override
    public void update(PutaoCharacter users) {
        putaoCharacterDao.update(users);
    }

    @Override
    public void deleteById(PutaoCharacter users) {
            putaoCharacterDao.deleteById(users);
    }
}
