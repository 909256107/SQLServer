package com.dfq.putao.Service.impl;
import com.dfq.putao.Service.PutaoService;
import com.dfq.putao.dao.PutaoDao;
import com.dfq.putao.dao.UsersDao;
import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Putao;
import com.dfq.putao.domain.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Mr Duan
 * @create 2020-06-02 17:16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PutaoServiceImpl implements PutaoService {
    @Autowired
    private PutaoDao putaoDao;

    @Override
    public EUDataGridResult findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Putao> list = putaoDao.findByPage();
        System.out.println(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Putao> usersPageInfo = new PageInfo<>(list);
        result.setTotal(usersPageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult findByPhone(int pageNum, int pageSize, Putao putao) {
        PageHelper.startPage(pageNum, pageSize);
        List<Putao> list = putaoDao.findByPhone(putao);
        System.out.println(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Putao> usersPageInfo = new PageInfo<>(list);
        result.setTotal(usersPageInfo.getTotal());
        return result;
    }

    @Override
    public void insert(Putao users) {
            putaoDao.insert(users);
    }

    @Override
    public void update(Putao users) {
        putaoDao.update(users);
    }

    @Override
    public void deleteById(Putao users) {
        putaoDao.deleteById(users);
    }
}
