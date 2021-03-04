/**
 * 查询的属性
 * 当前页面
 * 每页显示多少
 * 关键词
 */
package req;

public class StudentRequest {
    private int pageNow;
    private int pageSize;
    private int start;
    private String searchKey;

    public int getStart() {
        return (pageNow-1)*pageSize;//从第几条开始
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }


}
