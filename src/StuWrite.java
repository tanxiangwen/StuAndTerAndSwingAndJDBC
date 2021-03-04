import res.Stutips;

import javax.swing.*;
import java.awt.*;

/**
 * 学生查出自己的成绩以后可以编辑备注，备注内容教师端可以查看
 */
public class StuWrite extends JDialog {
  StudentMain studentMain;
  Stutips stutips;
    JPanel jPanel=new JPanel();
    JLabel snoLable=new JLabel("学号:");
    JTextField snotext=new JTextField();
    JTextArea write=new JTextArea(5,5);
    JButton jButton=new JButton("确定");
    Container container=getContentPane();
    public StuWrite(){};
    StuWriteHander stuWriteHander=new StuWriteHander(this);
    public StuWrite(StudentMain studentMain){
        super(studentMain,"意见反馈",true);
        jPanel.add(snoLable);
        jPanel.add(snotext);
        snotext.setPreferredSize(new Dimension(100,20));
        jPanel.add(write);
        jPanel.add(jButton);
        jButton.addActionListener(stuWriteHander);
        write.setPreferredSize(new Dimension(480,300));
        container.add(jPanel);
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);

        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public JTextField getSnotext() {
        return snotext;
    }

    public void setSnotext(JTextField snotext) {
        this.snotext = snotext;
    }

    public JTextArea getWrite() {
        return write;
    }

    public void setWrite(JTextArea write) {
        this.write = write;
    }

    /**
     * 获取学号和建议转为Stutips类型
     * @return
     */
    public Stutips assess(){
        Stutips stutips=new Stutips();
        stutips.setSno(snotext.getText());
        stutips.setTips(write.getText());
        return stutips;
    }
}
