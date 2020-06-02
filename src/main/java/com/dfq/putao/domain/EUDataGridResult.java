package com.dfq.putao.domain;

import java.util.List;

/**
 * @author Mr Duan
 * @create 2020-04-25 12:52
 */
public class EUDataGridResult {
    //结果总数
    private long total;
    //结果行数
    private List<?> rows;
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
    }


}
