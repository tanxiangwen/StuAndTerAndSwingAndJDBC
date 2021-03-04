/**
 * 学生账号密码检查
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentLoginHander implements ActionListener {
    StudentLogin studentLogin;
    public StudentLoginHander( StudentLogin studentLogin){
        this.studentLogin=studentLogin;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("登录".equals(text)){
            Boolean t=check();
            if(t){
                JOptionPane.showMessageDialog(studentLogin,"登录成功");
                  new StudentMain();

            }else{
                JOptionPane.showMessageDialog(studentLogin,"用户名或密码不正确");

            }
        }else if("重置".equals(text)){
            studentLogin.getUserfield().setText("");
            studentLogin.getPassword().setText("");
        }

    }
    public boolean check(){
        String user=studentLogin.getUserfield().getText();
        char[]password1=studentLogin.getPassword().getPassword();
        String password2=new String(password1);
        if("".equals(user.trim())||"".equals(password2.trim())){
            JOptionPane.showMessageDialog(studentLogin,"用户名密码必须填写");
        }
        boolean t = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con = DriverManager.getConnection(url, name, password);
            String sql="select * from t_studentifo where sno=? and pswd=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password2);
            rs=ps.executeQuery();
            int count=0;
            while(rs.next()){
                count++;

            }
            if(count==1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}