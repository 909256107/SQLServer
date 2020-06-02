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
    //��ҳ��ѯ����
    EUDataGridResult findByPhone(int pageNum, int pageSize, Putao users);
    //���
    void insert(Putao users);
    //����
    void update(Putao users);
    //ɾ������
    void deleteById(Putao users);
}
