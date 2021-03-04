package ext;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

//在每一行,每一列显示数据之前都会调用
public class MainViewCellRender extends DefaultTableCellRenderer {
    public Component getTableCellRenderComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        if(row % 2==0){
            setBackground(Color.LIGHT_GRAY);
        }else{
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
    }
}
