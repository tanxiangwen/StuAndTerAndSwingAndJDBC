import javax.swing.*;
import java.awt.*;

/**
 * 学生登录窗体
 */
public class StudentLogin extends JFrame {
    JLabel title=new JLabel("学生自助平台",JLabel.CENTER);
    JLabel userLable=new JLabel("学号:");
    JTextField userfield=new JTextField();
    JLabel psw=new JLabel("密码:");
    JPasswordField password=new JPasswordField();
    JButton login=new JButton("登录");
    JButton reset=new JButton("重置");
    SpringLayout springLayout=new SpringLayout();
    JPanel jPanel=new JPanel(springLayout);
    StudentLoginHander studentLoginHander;
    public StudentLogin(){
        studentLoginHander=new StudentLoginHander(this);
        JFrame jf=new JFrame("学生自助");
        Container container=jf.getContentPane();
        title.setFont(new Font("隶书",Font.PLAIN,30));
        Font font=new Font("正楷",Font.PLAIN,20);
        userLable.setFont(font);
        psw.setFont(font);
        jPanel.add(userLable);
        //userLable.setPreferredSize(new Dimension(20,20));
        jPanel.add(userfield);
        userfield.setPreferredSize(new Dimension(200,20));
        jPanel.add(psw);
        jPanel.add(password);
        password.setPreferredSize(new Dimension(200,20));
        jPanel.add(login);
        login.addActionListener(studentLoginHander);
        jPanel.add(reset);
        reset.addActionListener(studentLoginHander);
        //弹簧布局
        //居中
        Spring userlablewidth = Spring.width(userLable);
        Spring userfieldwidth = Spring.width(userfield);
        Spring sum = Spring.sum(userfieldwidth, userlablewidth);
        int avg=sum.getValue() / 2;
       //userlable
        springLayout.putConstraint(SpringLayout.WEST,userLable,-avg,SpringLayout.HORIZONTAL_CENTER,jPanel);
        springLayout.putConstraint(SpringLayout.NORTH,userLable,20,SpringLayout.NORTH,jPanel);
        //userfield
        springLayout.putConstraint(SpringLayout.WEST,userfield,20,SpringLayout.EAST,userLable);
        springLayout.putConstraint(SpringLayout.NORTH,userfield,0,SpringLayout.NORTH,userLable);
        //psw
        springLayout.putConstraint(SpringLayout.EAST,psw,0,SpringLayout.EAST,userLable);
        springLayout.putConstraint(SpringLayout.NORTH,psw,20,SpringLayout.SOUTH,userLable);
        //password
        springLayout.putConstraint(SpringLayout.WEST,password,20,SpringLayout.EAST,psw);
        springLayout.putConstraint(SpringLayout.NORTH,password,0,SpringLayout.NORTH,psw);
       //login
        springLayout.putConstraint(SpringLayout.WEST, login, 70, SpringLayout.WEST, psw);
        springLayout.putConstraint(SpringLayout.NORTH, login, 20, SpringLayout.SOUTH, psw);
        //reset
        springLayout.putConstraint(SpringLayout.WEST, reset, 70, SpringLayout.EAST, login);
        springLayout.putConstraint(SpringLayout.NORTH, reset, 0, SpringLayout.NORTH, login);
        container.add(title,BorderLayout.NORTH);
    container.add(jPanel,BorderLayout.CENTER);


        jf.setSize(600,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setVisible(true);


    }
    public static void main(String[] args){
        new StudentLogin();
    }

    public JTextField getUserfield() {
        return userfield;
    }

    public void setUserfield(JTextField userfield) {
        this.userfield = userfield;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }
}
