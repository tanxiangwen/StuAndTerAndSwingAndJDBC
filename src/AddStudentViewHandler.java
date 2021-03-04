/**
 * 添加学生的监听器
 */

import res.StudentDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentViewHandler implements ActionListener {
    private addstuview Addstuview;
    private MainViews mainView;
    public AddStudentViewHandler(addstuview Addstuview, MainViews mainview){
        this.Addstuview=Addstuview;
       this.mainView=mainview;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("添加".equals(text)){
            StudentService studentService=new StudentServiceImpl();
            StudentDO studentDO=Addstuview.buildStudentDO();
            boolean result=studentService.add(studentDO);
            if(result){
                //重新加载表格查到最新数据
                mainView.reloadTable();
                //销毁当前窗口
                Addstuview.dispose();

            }else{
                JOptionPane.showMessageDialog(Addstuview,"添加失败");
            }


        }

    }
}
