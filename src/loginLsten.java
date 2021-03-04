/**
 * 教师端用户登录监听器
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ResourceBundle;

public class loginLsten implements ActionListener {
     Loginview loginview;
     public loginLsten( Loginview loginview){
         this.loginview=loginview;
     }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         //获取源操作转为按钮
       JButton jbutton=(JButton) actionEvent.getSource();
       //获取按钮上的文字
        String text=jbutton.getText();
        if("重置".equals(text)){
            //把用户和密码清空
            loginview.getUserfield().setText("");
            loginview.getPswfield().setText("");



        }else if("登录".equals(text)){
            //获取输入内容
        boolean t1= check();
        if(t1){
            JOptionPane.showMessageDialog(loginview,"登录成功");
            //登录主界面
            new MainViews();


        }
        else{
            JOptionPane.showMessageDialog(loginview,"用户名或密码不正确");
        }

        }

    }
    //登录链接数据库检查
    public boolean check() {
        //获取输入内容
        String user = loginview.getUserfield().getText();
        char[] password1 = loginview.getPswfield().getPassword();
        String passwords = new String(password1);//转为字符串
        if ("".equals(user.trim()) || "".equals(passwords.trim())) {
            JOptionPane.showMessageDialog(loginview, "用户名或密码必须填写");

        }
            //数据库
            boolean t = false;
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           /* ResourceBundle bandle=ResourceBundle.getBundle("mess");
            String url=bandle.getString("url");
            String name=bandle.getString("name");
            String password=bandle.getString("password");*/
                String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
                String name = "root";
                String password = "031518";
                con = DriverManager.getConnection(url, name, password);
                con.setAutoCommit(false);
                //执行预编译的数据库
                String sql = "select * from t_teacherifo where sno=? and pswd=? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, passwords);
                rs = ps.executeQuery();
                if (rs.next()) {
                    t = true;
                }
                con.commit();
            } catch (SQLException e) {
                if (con != null) {
                    try {
                        con.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
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



        return t;

    }
}
