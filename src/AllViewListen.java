/**
 * 主界面监听
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllViewListen implements ActionListener {
    AllView allView;

    public AllViewListen(AllView allView){
        this.allView=allView;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("学生端".equals(text)){
            JOptionPane.showMessageDialog(allView, "欢迎进入");
            new StudentLogin();


        }else if("教师端".equals(text)) {

            JOptionPane.showMessageDialog(allView, "欢迎进入");
            new Loginview();


        }

    }


}


