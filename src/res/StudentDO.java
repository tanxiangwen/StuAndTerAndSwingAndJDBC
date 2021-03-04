/**
 * 添加学生的属性
 */
package res;

public class StudentDO {
    private String sno;
    private String name;
    private Double Chinese;
    private Double Math;
    private Double english;
    private Double total;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getChinese() {
        return Chinese;
    }

    public void setChinese(Double chinese) {
        Chinese = chinese;
    }

    public Double getMath() {
        return Math;
    }

    public void setMath(Double math) {
        Math = math;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }


}
