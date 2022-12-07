package com.hlw.constant;

import java.util.List;

public class PageResult<E> {
    private boolean flag;
    private List<E> dataForm;
    private String total;

    public PageResult(boolean flag, List<E> dataForm, String total) {
        this.flag = flag;
        this.dataForm = dataForm;
        this.total = total;
    }

    public PageResult() {
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "flag=" + flag +
                ", dataForm=" + dataForm +
                ", total='" + total + '\'' +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<E> getDataForm() {
        return dataForm;
    }

    public void setDataForm(List<E> dataForm) {
        this.dataForm = dataForm;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
