import req.StudentRequest;
import res.StudentDO;
import res.TableDTO;

import java.sql.*;
import java.util.Vector;

/**
 * 实现StudentService方法
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public TableDTO retrieveStudent(StudentRequest requst) {
        //拼接sql语句
        StringBuilder sql=new StringBuilder();
        sql.append("select * from t_studentifm ");
        if(requst.getSearchKey()!=null&&!"".equals(requst.getSearchKey().trim())){
            sql.append(" where name like '%"+requst.getSearchKey().trim()+"%'");
        }
        //如果为空就降序排
       // sql.append("order by stuid desc");
        sql.append(" order by sno  limit ").append(requst.getStart()).append(",")
                .append(requst.getPageSize());

        Connection con1 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TableDTO returnDTO=new TableDTO();
       // Vector<Vector<Object>> data=new Vector<>();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con1 = DriverManager.getConnection(url, name, password);
            ps= con1.prepareStatement(sql.toString());
           rs= ps.executeQuery();
           //查询记录
            returnDTO.setData( fillData(rs));
            //fillData(rs);
            //查总数
            //清除原来的sql
            sql.setLength(0);
           sql.append("select count(*) from t_studentifm ");
            if(requst.getSearchKey()!=null&&!"".equals(requst.getSearchKey().trim())){
                sql.append(" where name like '%"+requst.getSearchKey()+"%'");
            }
            ps= con1.prepareStatement(sql.toString());
            rs= ps.executeQuery();
            int count=0;
            while(rs.next()){
                 count++;
                 returnDTO.setTotalcount(count);
            }
            return returnDTO;


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
            }if(con1!=null){
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }

    @Override
    public boolean add(StudentDO studentDO) {
        StringBuilder sql=new StringBuilder();
        sql.append(" insert into t_studentifm(sno,name,Chinese,Math,英语,total) ");
        sql.append(" values(?,?,?,?,?,?) ");
        Connection con1 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con1 = DriverManager.getConnection(url, name, password);
            ps= con1.prepareStatement(sql.toString());
           ps.setString(1,studentDO.getSno());
           ps.setString(2,studentDO.getName());
           ps.setDouble(3,studentDO.getChinese());
           ps.setDouble(4,studentDO.getMath());
           ps.setDouble(5,studentDO.getEnglish());
           ps.setDouble(6,studentDO.getTotal());
           return ps.executeUpdate()==1;

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
            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

         return false;
    }

    @Override
    public StudentDO getByid(String selectedstudentsno) {
        StringBuilder sql=new StringBuilder("select * from t_studentifm where sno=?");
        Connection con1 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StudentDO studentDO=new StudentDO();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con1 = DriverManager.getConnection(url, name, password);
            ps=con1.prepareStatement(sql.toString());
            ps.setString(1,selectedstudentsno);
            rs=ps.executeQuery();
            while(rs.next()){
                //处理记录
                String s1=rs.getString("sno");
                String s2=rs.getString("name");
                Double s3=rs.getDouble("Chinese");
                Double s4=rs.getDouble("Math");
                Double s5=rs.getDouble("英语");
              //  Double total=s3+s4+s5;
                Double s6=rs.getDouble("total");
                studentDO.setSno(s1);
                studentDO.setName(s2);
                studentDO.setChinese(s3);
                studentDO.setMath(s4);
                studentDO.setEnglish(s5);
                studentDO.setTotal(s6);

            }

            return studentDO;



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
            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public boolean update(StudentDO studentDO) {
        StringBuilder sql=new StringBuilder();
        sql.append(" update t_studentifm set name=?,Chinese=?,Math=?,英语=?");
        sql.append(" where sno=?");
        Connection con1 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con1 = DriverManager.getConnection(url, name, password);
            ps=con1.prepareStatement(sql.toString());

            ps.setString(1,studentDO.getName());
            ps.setDouble(2,studentDO.getChinese());
            ps.setDouble(3,studentDO.getMath());
            ps.setDouble(4,studentDO.getEnglish());
            //ps.setDouble(5,studentDO.getTotal());
            ps.setString(5,studentDO.getSno());
            return ps.executeUpdate()==1;

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
            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
//删除
    @Override
    public boolean delete(String selectedstudentsno) {

        Connection con1 = null;
       Statement ps = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://127.0.0.1:3306/text?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            String name = "root";
            String password = "031518";
            con1 = DriverManager.getConnection(url, name, password);
            ps=con1.createStatement();
            String sql="delete from t_studentifm where sno= '"+selectedstudentsno+"'";
           int count= ps.executeUpdate(sql);
           if(count==1){
               return true;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(con1!=null){
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    private  Vector<Vector<Object>> fillData(ResultSet rs) throws SQLException {
        Vector<Vector<Object>> data=new Vector<>();
        while(rs.next()){
            //处理记录
            Vector<Object> oneRecord=new Vector<>();
            String s1=rs.getString("sno");
            String s2=rs.getString("name");
            Double s3=rs.getDouble("Chinese");
            Double s4=rs.getDouble("Math");
            Double s5=rs.getDouble("英语");
            Double total=s3+s4+s5;
            int s6=rs.getInt("stuid");
            oneRecord.addElement(s1);
            oneRecord.addElement(s2);
            oneRecord.addElement(s3);
            oneRecord.addElement(s4);
            oneRecord.addElement(s5);
            oneRecord.addElement(total);
            oneRecord.addElement(s6);
            data.addElement(oneRecord);


        }
        return data;
    }

}
