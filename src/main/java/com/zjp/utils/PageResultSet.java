package com.zjp.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 返回结果处理集
 *
 * @Author: zhujunpeng
 * @Date: 2018/11/24 22:15
 * @Version 1.0
 */
public class PageResultSet<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页码数
     */
    private long pageNum;
    /**
     * 返回行
     */
    private List<T> rows;

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
