import res.Stutips;

import javax.swing.*;
/**
 * 学生建议的监听器
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuWriteHander implements ActionListener {
    StuWrite stuWrite;
    //Stutips stutips;
    public StuWriteHander(StuWrite stuWrite){
        this.stuWrite=stuWrite;
        //this.stutips=stutips;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("确定".equals(text)){
            Studentsearch studentsearch=new Studentsearchsever();
            Stutips stutips=stuWrite.assess();
            studentsearch.assess(stutips);
           // stutips.addtips(stutips);
            stuWrite.dispose();
        }

    }
}
