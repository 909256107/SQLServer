package com.dfq.putao.Service.impl;

import com.dfq.putao.Service.UsersService;
import com.dfq.putao.dao.UsersDao;
import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:52
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;


    @Transactional(readOnly = true)
    @Override
//用过手机号查找用户
    public EUDataGridResult findByPhone(int pageNum, int pageSize, Users phone) {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> list = usersDao.findByPhone(phone);
        System.out.println(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Users> usersPageInfo = new PageInfo<>(list);
        result.setTotal(usersPageInfo.getTotal());
        return result;

    }
    //分页查看用户
    @Transactional(readOnly = true)
    @Override
    //@Param("page")Integer page, @Param("rows")Integer rows
    public EUDataGridResult findByPage (int pageNum,  int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> list = usersDao.findByPage();
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Users> usersPageInfo = new PageInfo<>(list);
        result.setTotal(usersPageInfo.getTotal());
        return result;

    }
    //添加用户
    @Override
    public void insert(Users users) {
        usersDao.insert(users);
    }
    //修改用户
    @Override
    public void update(Users users) {
        usersDao.update(users);
    }
    //通过ID删除用户
    @Override
    public void deleteById(Users id) {
        usersDao.deleteById(id);
    }

    @Override
    public Users login(Users users) {

        return usersDao.login(users);
    }
}
