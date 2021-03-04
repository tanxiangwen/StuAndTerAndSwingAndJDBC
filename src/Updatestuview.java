/**
 * 教师端更新面板
 */

import ext.MainViewTableModel;
import req.StudentRequest;
import res.StudentDO;
import res.TableDTO;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Updatestuview extends JDialog {
    JPanel jpanel=new JPanel();

    JLabel snolable=new JLabel("学号:");
    JTextField snofield=new JTextField();
    JLabel namelable=new JLabel("姓名:");
    JTextField namefield=new JTextField();
    JLabel chinalable=new JLabel("语文:");
    JTextField chinafield=new JTextField();
    JLabel mathlable=new JLabel("数学:") ;
    JTextField mathfield=new JTextField();
    JLabel englable=new JLabel("英语:");
    JTextField engfield=new JTextField();
    //JLabel totallable=new JLabel("总分:");
  //  JTextField totalfield=new JTextField();
    JButton update=new JButton("修改");
    UpdatestudentviewHandler updatestudentviewHandler;
    public Updatestuview(MainViews mainview, String selectedstudentsno){
        super(mainview,"更新学生",true);//模态窗体在Mainview显示
        //数据查询selectedstudentsno对应的记录并显示
        updatestudentviewHandler=new UpdatestudentviewHandler(this,mainview);
        StudentService studentService=new StudentServiceImpl();
       StudentDO selectstu= studentService.getByid(selectedstudentsno);
        //设置
        snolable.setPreferredSize(new Dimension(80,20));
        jpanel.add(snolable);
        snofield.setPreferredSize(new Dimension(200,30));
        snofield.setText(selectstu.getSno() + "");
        //设置学号不可编辑
        snofield.setEnabled(false);
        jpanel.add(snofield);
        namelable.setPreferredSize(new Dimension(80,20));
        jpanel.add(namelable);
        namefield.setPreferredSize(new Dimension(200,30));
        namefield.setText(selectstu.getName());
        jpanel.add(namefield);
        chinalable.setPreferredSize(new Dimension(80,20));
        jpanel.add(chinalable);
        chinafield.setPreferredSize(new Dimension(200,30));
        chinafield.setText(String.valueOf(selectstu.getChinese()));
        jpanel.add(chinafield);
        mathlable.setPreferredSize(new Dimension(80,20));
        jpanel.add(mathlable);
        mathfield.setPreferredSize(new Dimension(200,30));
        mathfield.setText(String.valueOf(selectstu.getMath()));
        jpanel.add(mathfield);
        englable.setPreferredSize(new Dimension(80,20));
        jpanel.add(englable);
        engfield.setPreferredSize(new Dimension(200,30));
        engfield.setText(String.valueOf(selectstu.getEnglish()));
        jpanel.add(engfield);
        //totallable.setPreferredSize(new Dimension(80,20));
        //jpanel.add(totallable);
        //totalfield.setPreferredSize(new Dimension(200,30));
        //totalfield.setText(String.valueOf(selectstu.getTotal()));
       // jpanel.add(totalfield);
        jpanel.add(update);
        update.addActionListener(updatestudentviewHandler);
        Container con=getContentPane();
        con.add(jpanel);
        setSize(350,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//只销毁当前窗体
        setResizable(false);
        setVisible(true);
    }

//获取修改后的学生对象
    public StudentDO buildStudentDO() {
        StudentDO studentDO=new StudentDO();
        studentDO.setSno(snofield.getText());
        studentDO.setName(namefield.getText());
        studentDO.setChinese(Double.valueOf(chinafield.getText()));
        studentDO.setMath(Double.valueOf(mathfield.getText()));
        studentDO.setEnglish(Double.valueOf(engfield.getText()));
       // studentDO.setTotal(Double.valueOf(totalfield.getText()));
        return studentDO;


    }
}


