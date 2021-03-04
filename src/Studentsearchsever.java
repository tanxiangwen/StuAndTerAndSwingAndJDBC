/**
 * 实现学生自查
 */

import req.SearchRequest;
import req.TipsRequst;
import res.StuDTO;
import res.Stutips;
import res.TipsDTO;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Studentsearchsever implements Studentsearch {
    StudentMain studentMain;

    @Override
    public StuDTO Mysearch(SearchRequest searchRequest) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        StuDTO stuDTO=new StuDTO();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con = DriverManager.getConnection(url, name, password);
            String sql="select * from t_studentifm where sno=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,searchRequest.getSno().trim());
            rs=ps.executeQuery();
            stuDTO.setData(fillDatas(rs));
            return stuDTO;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    //查看自己的排名
    @Override
    public int Mylocation(String a) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ResultSet rs1=null;
        int count = 0;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con = DriverManager.getConnection(url, name, password);
            String sql="select total from t_studentifm where sno=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,a);
            rs1=ps.executeQuery();
            if(rs1.next()) {
                Double totals = rs1.getDouble("total");
                String sql2 = "select * from t_studentifm AS t where t.total>=?";
                ps = con.prepareStatement(sql2);
                ps.setDouble(1, totals);
                rs = ps.executeQuery();

                while (rs.next()) {
                    count = count + 1;
                }

            }
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

         return 0;

    }

    @Override
    public void assess(Stutips stutips) {
        StuWrite stuWrite=new StuWrite();
        //String sno=stutips.getSno();
       // String tips=stutips.getTips();
        Connection con=null;
        PreparedStatement ps=null;
       // ResultSet rs=null;
       // ResultSet rs1=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con = DriverManager.getConnection(url, name, password);
            String sql="insert into stutitle(sno,tips)values(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,stutips.getSno());
            ps.setString(2,  stutips.getTips());
            int count=ps.executeUpdate();
            if(count==1){
                JOptionPane.showMessageDialog(stuWrite,"保存成功");
            }
            else{
                JOptionPane.showMessageDialog(stuWrite,"失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public TipsDTO seeTip(TipsRequst tipsRequst) {
        SeeTips seeTips=new SeeTips();
        TipsDTO tipsDTO=new TipsDTO();
        Connection con=null;
        PreparedStatement ps=null;
         ResultSet rs=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con = DriverManager.getConnection(url, name, password);
            String sql="select tips from stutitle where sno=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,tipsRequst.getSno());
            rs=ps.executeQuery();
            if(rs.next()){
                String s1=rs.getString("tips");
                tipsDTO.setText(s1);
            }
            else{
                JOptionPane.showMessageDialog(seeTips,"暂无反馈");

            }
            return tipsDTO;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

  return null;
    }

    private Vector<Vector<Object>> fillDatas(ResultSet rs) throws SQLException {
        Vector<Vector<Object>>data=new Vector<>();
        while(rs.next()){
            Vector<Object>rows=new Vector<>();
            String s1=rs.getString("sno");
            String s2=rs.getString("name");
            Double s3=rs.getDouble("Chinese");
            Double s4=rs.getDouble("Math");
            Double s5=rs.getDouble("英语");
            Double s6=rs.getDouble("total");
            int s7=rs.getInt("stuid");
            rows.addElement(s1);
            rows.addElement(s2);
            rows.addElement(s3);
            rows.addElement(s4);
            rows.addElement(s5);
            rows.addElement(s6);
            rows.addElement(s7);
            data.addElement(rows);

        }

        return data;

    }
    public static void main(String[] args){

    }
}
