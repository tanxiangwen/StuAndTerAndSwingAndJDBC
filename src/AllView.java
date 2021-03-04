/**
 * 登录的主界面，选择学生端还是老师端
 */

import javax.swing.*;
import java.awt.*;

public class AllView extends JFrame {

    AllViewListen allViewListen;
    JLabel title=new JLabel("学生-教师一体化服务平台",JLabel.CENTER);
    JButton stu=new JButton("学生端");
    JButton tea=new JButton("教师端");
    SpringLayout springLayout=new SpringLayout();
    JPanel jPanel=new JPanel(springLayout);
    public AllView(){
        allViewListen=new AllViewListen(this);
        JFrame jf=new JFrame("综合平台");
        Container container=jf.getContentPane();
        title.setFont(new Font("行楷",Font.PLAIN,25));
        Font font=new Font("楷体",Font.PLAIN,20);
        stu.addActionListener(allViewListen);
        tea.addActionListener(allViewListen);
        stu.setFont(font);
        tea.setFont(font);
        // Spring stuwidth = Spring.width(stu);
        // int avg=stuwidth.getValue()/2;
        SpringLayout.Constraints userlabelc = springLayout.getConstraints(stu);
        //让其居中
        springLayout.putConstraint(SpringLayout.WEST, stu, -100, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, stu, 100, SpringLayout.NORTH, jPanel);
        //设置另一个按钮
        springLayout.putConstraint(SpringLayout.WEST,tea,20,SpringLayout.EAST,stu);
        springLayout.putConstraint(SpringLayout.NORTH,tea,0,SpringLayout.NORTH,stu);
        //添加到Jpanel
        jPanel.add(stu);
        jPanel.add(tea);
        container.add(title,BorderLayout.NORTH);
        container.add(jPanel,BorderLayout.CENTER);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setSize(500,400);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);

    }

    public JButton getStu() {
        return stu;
    }

    public void setStu(JButton stu) {
        this.stu = stu;
    }

    public JButton getTea() {
        return tea;
    }

    public void setTea(JButton tea) {
        this.tea = tea;
    }
    public static void main(String[] args){
        new AllView();
    }
}


