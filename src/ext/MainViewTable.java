
package ext;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class MainViewTable extends JTable {
    public MainViewTable(){


        JTableHeader head=new JTableHeader();
        head.setFont(new Font(null,Font.BOLD,16));
        head.setBackground(Color.RED);
       getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//设置多行选择

    }
   /* public void setDataModel(MainViewTableModel mainViewTableModel){
        this.setModel(mainViewTableModel);
    }*/

    /**
     * 功能没反应忽略
     */
    public void renderRule(){
        //设置表格渲染方式
        Vector<String> colums=MainViewTableModel.getColums();
        MainViewCellRender render=new MainViewCellRender();
        for(int i=0;i<colums.size();i++) {
            TableColumn column = getColumn(colums.get(i));
            column.setCellRenderer(render);
            if(i==0){
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }
        }
    }
}
