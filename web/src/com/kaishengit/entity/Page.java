package com.kaishengit.entity;

import java.util.List;

public class Page<T> {
    private int pageNo;
    private int pageSize;
    private int pageTotals;
    private int totalCount;
    private int startNo;
    private List<T> list;
    public Page(){};
    public Page(String pageNo,int count,int size){
        this.pageSize = size;
        this.pageTotals = count/size;
        if(count%size != 0){
            this.pageTotals+=1;
        }
        if(pageNo != null&&pageNo.matches("[1-9]+")){
            this.pageNo = Integer.parseInt(pageNo);
            if(this.pageNo > this.pageTotals){
                this.pageNo = this.pageTotals;
            }
        }else{
            this.pageNo = 1;
        }

        this.totalCount = count;

        this.startNo = (this.pageNo - 1)*size;
    }
    public Page(String pageNo,int count){
        this(pageNo,count,5);
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageTotals() {
        return pageTotals;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStartNo() {
        return startNo;
    }


}
