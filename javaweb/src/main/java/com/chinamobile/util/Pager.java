package com.chinamobile.util;

import java.util.List;

/**
 * 分页类
 * @param <T>
 */
public class Pager<T> {

    //总页数
    private Integer total;
    //分页数据集合
    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
