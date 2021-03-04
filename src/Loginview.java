/**
 * 教师端登录组件
 */

import javax.swing.*;
import java.awt.*;

public class Loginview extends JFrame{

    loginLsten loginlsten;
     JLabel namelable=new JLabel("学生信息管理系统",JLabel.CENTER);//居中
     //弹簧布局
    SpringLayout springlayout=new SpringLayout();
    //流体布局
    JPanel jpanel=new JPanel(springlayout);
    JLabel userlabel=new JLabel("职工编号:");

    JTextField userfield=new JTextField();
    JLabel psw=new JLabel("密码:");
    JPasswordField pswfield=new JPasswordField();
    JButton login=new JButton("登录");
    JButton reset=new JButton("重置");

    public Loginview() {
        JFrame jf = new JFrame("java管理系统");
        loginlsten = new loginLsten(this);
        //设置namelable字体
        namelable.setFont(new Font("行楷", Font.PLAIN, 40));
        Font centerfont = new Font("楷体", Font.PLAIN, 20);
        //设置其他的字体
        userlabel.setFont(centerfont);
        psw.setFont(centerfont);
        login.setFont(centerfont);
        reset.setFont(centerfont);
        Container contentPane = jf.getContentPane();
        jpanel.add(namelable);
        jpanel.add(userlabel);
        jpanel.add(userfield);
        userfield.setPreferredSize(new Dimension(200, 20));
        jpanel.add(psw);
        jpanel.add(pswfield);
        pswfield.setPreferredSize(new Dimension(200, 20));
        jpanel.add(login);
        login.addActionListener(loginlsten);//添加监听器
        //login.addKeyListener(loginlsten);
        jpanel.add(reset);
        reset.addActionListener(loginlsten);

        //弹簧布局
        //居中
        Spring userlabelwidth = Spring.width(userlabel);
        Spring userfieldwidth = Spring.width(userfield);
        Spring centerall = Spring.sum(userlabelwidth,userfieldwidth);
        int avg = centerall.getValue() / 2;
        //获取约束
        SpringLayout.Constraints userlabelc = springlayout.getConstraints(userlabel);
        //让其居中
        springlayout.putConstraint(SpringLayout.WEST, userlabel, -avg, SpringLayout.HORIZONTAL_CENTER, jpanel);
        springlayout.putConstraint(SpringLayout.NORTH, userlabel, 20, SpringLayout.NORTH, jpanel);
        //userfield
        springlayout.putConstraint(SpringLayout.WEST, userfield, 20, SpringLayout.EAST, userlabel);
        springlayout.putConstraint(SpringLayout.NORTH, userfield, 0, SpringLayout.NORTH, userlabel);
        //psw
        springlayout.putConstraint(SpringLayout.EAST, psw, 0, SpringLayout.EAST, userlabel);
        springlayout.putConstraint(SpringLayout.NORTH, psw, 20, SpringLayout.SOUTH, userlabel);
        //pswfield
        springlayout.putConstraint(SpringLayout.WEST, pswfield, 20, SpringLayout.EAST, psw);
        springlayout.putConstraint(SpringLayout.NORTH, pswfield, 0, SpringLayout.NORTH, psw);
        //login
        springlayout.putConstraint(SpringLayout.WEST, login, 50, SpringLayout.WEST, psw);
        springlayout.putConstraint(SpringLayout.NORTH, login, 20, SpringLayout.SOUTH, psw);
        //reset
        springlayout.putConstraint(SpringLayout.WEST, reset, 50, SpringLayout.EAST, login);
        springlayout.putConstraint(SpringLayout.NORTH, reset, 0, SpringLayout.NORTH, login);


        contentPane.add(namelable, BorderLayout.NORTH);//标题靠上
        contentPane.add(jpanel, BorderLayout.CENTER);//主要部分在中间
        jf.setSize(600, 400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setVisible(true);

    }
    //生成userfield和pswfield方法:为了当点击重置时清空

    public JTextField getUserfield() {
        return userfield;
    }

    public void setUserfield(JTextField userfield) {
        this.userfield = userfield;
    }

    public JPasswordField getPswfield() {
        return pswfield;
    }

    public void setPswfield(JPasswordField pswfield) {
        this.pswfield = pswfield;
    }
 public static void main(String[] args){
        new Loginview();
 }

}
