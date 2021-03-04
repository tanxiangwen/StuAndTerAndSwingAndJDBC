package ext;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Vector;

public class StudentTableModel extends DefaultTableModel {
    static Vector<String>colums=new Vector<>();
    static{
        colums.addElement("学号:");
        colums.addElement("姓名:");
        colums.addElement("语文:");
        colums.addElement("数学:");
        colums.addElement("英语:");
        colums.addElement("总分:");
        colums.addElement("序号");

    }
    private StudentTableModel(){
        super(null,colums);
    }
    private static StudentTableModel mainViewTable=new StudentTableModel();
    public static StudentTableModel assembleModel(Vector<Vector<Object>>data){
        mainViewTable.setDataVector(data,colums);
        return mainViewTable;
    }
    //更新
    public static void updateModel(Vector<Vector<Object>>data){
        mainViewTable.setDataVector(data,colums);

    }
    public static Vector<String> getColums(){
        return colums;
    }

    @Override
    //不可编辑
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
