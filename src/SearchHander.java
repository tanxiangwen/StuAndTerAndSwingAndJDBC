/**
 * 查找学生监听
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchHander implements ActionListener {
    StudentMain studentMain;
    StuWrite stuWrite;
    //StudentTableModel studentTableModel;
  //  StuDTO stu=new StuDTO();
    public SearchHander( StudentMain studentMain,StuWrite stuWrite){
        this.studentMain=studentMain;
        this.stuWrite=stuWrite;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
     String snos=studentMain.getSearch().getText();
        Studentsearchsever studentsearchsever=new Studentsearchsever();
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("查找".equals(text)||"排名".equals(text)){
            if("".equals(snos.trim())){
                JOptionPane.showMessageDialog(studentMain,"请输入要查询的学号");
            }
            //排名
            //StudentMain studentMain=new StudentMain();
            studentMain.getSearch().setText(snos);
            int count= studentsearchsever.Mylocation(snos);
            String s=String.valueOf(count);
            studentMain.getLook().setText(s);
            //显示信息
                studentMain.reloadTable();
        }/*else if("排名".equals(text)){
           StudentMain studentMain=new StudentMain();
           studentMain.getSearch().setText(snos);
            int count= studentsearchsever.Mylocation(snos);
            String s=String.valueOf(count);
            studentMain.getLook().setText(s);

        }*/else if("意见反馈".equals(text)){
            new StuWrite(studentMain);


        }
        else if("返回".equals(text)){
            new AllView();
        }
    }
}
