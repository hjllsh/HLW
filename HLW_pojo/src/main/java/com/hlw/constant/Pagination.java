package com.hlw.constant;

public class Pagination {
    private String searchData;
    private String currentPage;
    private String pageSize;

    public Pagination() {
    }

    public String getSearchData() {
        return searchData;
    }

    public void setSearchData(String searchData) {
        this.searchData = searchData;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "searchData='" + searchData + '\'' +
                ", currentPage='" + currentPage + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }

    public Pagination(String searchData, String currentPage, String pageSize) {
        this.searchData = searchData;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
