/**
 * 数据传输对象
 */
package res;

import java.util.Vector;

public class TableDTO {
    private Vector< Vector<Object>> data;
    private int totalcount;

    public Vector<Vector<Object>> getData() {
        return data;
    }

    public void setData(Vector<Vector<Object>> data) {
        this.data = data;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
}
