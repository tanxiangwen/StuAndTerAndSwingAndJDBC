import res.StudentDO;

import javax.swing.*;
import java.awt.*;

/**
 * 添加学生面板
 */
//模态窗体
public class addstuview extends JDialog {
    JPanel jpanel = new JPanel();

    JLabel snolable = new JLabel("学号:");
    JTextField snofield = new JTextField();
    JLabel namelable = new JLabel("姓名:");
    JTextField namefield = new JTextField();
    JLabel chinalable = new JLabel("语文:");
    JTextField chinafield = new JTextField();
    JLabel mathlable = new JLabel("数学:");
    JTextField mathfield = new JTextField();
    JLabel englable = new JLabel("英语:");
    JTextField engfield = new JTextField();
    JLabel totallable = new JLabel("总分:");
    JTextField totalfield = new JTextField();
    JButton addbtn = new JButton("添加");
  AddStudentViewHandler addStudentViewHandler;
    public addstuview(MainViews mainview) {
        super(mainview, "添加学生", true);//模态窗体在Mainview显示
        //设置
        addStudentViewHandler=new AddStudentViewHandler(this,mainview);
        snolable.setPreferredSize(new Dimension(80, 20));
        jpanel.add(snolable);
        snofield.setPreferredSize(new Dimension(200, 30));
        jpanel.add(snofield);
        namelable.setPreferredSize(new Dimension(80, 20));
        jpanel.add(namelable);
        namefield.setPreferredSize(new Dimension(200, 30));
        jpanel.add(namefield);
        chinalable.setPreferredSize(new Dimension(80, 20));
        jpanel.add(chinalable);
        chinafield.setPreferredSize(new Dimension(200, 30));
        jpanel.add(chinafield);
        mathlable.setPreferredSize(new Dimension(80, 20));
        jpanel.add(mathlable);
        mathfield.setPreferredSize(new Dimension(200, 30));
        jpanel.add(mathfield);
        englable.setPreferredSize(new Dimension(80, 20));
        jpanel.add(englable);
        engfield.setPreferredSize(new Dimension(200, 30));
        jpanel.add(engfield);
        totallable.setPreferredSize(new Dimension(80,20));
        jpanel.add(totallable);
        totalfield.setPreferredSize(new Dimension(200,30));
        jpanel.add(totalfield);
        jpanel.add(addbtn);
        addbtn.addActionListener(addStudentViewHandler);
        Container con = getContentPane();
        con.add(jpanel);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//只销毁当前窗体
        setResizable(false);
        setVisible(true);
    }
    //添加学生的信息
    public StudentDO buildStudentDO(){
        StudentDO studentDO=new StudentDO();
        studentDO.setSno(snofield.getText());
        studentDO.setName(namefield.getText());
        studentDO.setChinese(Double.valueOf(chinafield.getText()));
        studentDO.setMath(Double.valueOf(mathfield.getText()));
        studentDO.setEnglish(Double.valueOf(engfield.getText()));
        studentDO.setTotal(Double.valueOf(totalfield.getText()));
        return studentDO;
    }

}