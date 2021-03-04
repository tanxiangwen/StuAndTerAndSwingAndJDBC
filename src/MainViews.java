/**
 * 数据增加
 * 教师端主页
 */

import ext.MainViewCellRender;
import ext.MainViewTable;
import ext.MainViewTableModel;
import req.StudentRequest;
import res.TableDTO;
//import util.DimensionUtil;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class MainViews extends JFrame {

    //组件
    JPanel northjpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton addbtu=new JButton("增加");
    JButton updatebtu=new JButton("修改");
    JButton deletebtu=new JButton("删除");
    JTextField searchtext=new JTextField();
    JButton searchbtu=new JButton("查找");
    JButton tipsbutton=new JButton("学生意见");
    JButton pre=new JButton("返回");
    //南边布局
    JPanel sourthpanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton prebtu=new JButton("上一页");
    JButton nextbtu=new JButton("下一页");
    private int pagenow=1;//默认显示第一页
    private int pagesize=10;//每页显示10条
    MainViewTable mainViewTable=new MainViewTable();
    MainViewHandler mainViewHandler=new MainViewHandler(this);


    public MainViews(){
        JFrame jf=new JFrame("主界面");
        Container con=jf.getContentPane();
        //根据屏幕大小来适应主界面大小
       // setBounds(DimensionUtil.getBouns());

        //设置窗体完全充满整个屏幕可见大小
      //  setExtendedState(JFrame.MAXIMIZED_BOTH);
        //北边布局
        LayoutNorth(con);
        //中间布局
       LayoutCenter(con);
        //南边布局
        LayoutSouth(con);

        //设置表头
       /* JTableHeader head=new JTableHeader();
        head.setFont(new Font(null,Font.BOLD,16));
        head.setBackground(Color.RED);*/
        jf.setSize(1000,640);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(true);

    }

    private void LayoutCenter(Container con) {
        StudentService studentService=new StudentServiceImpl();
        StudentRequest studentRequest=new StudentRequest();
        studentRequest.setPageNow(pagenow);
        studentRequest.setPageSize(pagesize);
        studentRequest.setSearchKey(searchtext.getText().trim());
        TableDTO tableDTO = studentService.retrieveStudent(studentRequest);
        Vector<Vector<Object>> data = tableDTO.getData();

        MainViewTableModel mainViewTableModel= MainViewTableModel.assembleModel(data);
        //jtable和Model关联
       mainViewTable.setModel(mainViewTableModel);
      // mainViewTable.renderRule();


        JScrollPane jScrollPane=new JScrollPane(mainViewTable);
        con.add(jScrollPane,BorderLayout.CENTER);
    }

    private void LayoutSouth(Container con) {
        sourthpanel.add(prebtu);
        prebtu.addActionListener(mainViewHandler);
        sourthpanel.add(nextbtu);
        nextbtu.addActionListener(mainViewHandler);
        con.add(sourthpanel,BorderLayout.SOUTH);
    }

    /**
     * 动态显示上一页下一页没有实现
     * @param con
     */
    private void LayoutNorth(Container con) {
        northjpanel.add(addbtu);
        //添加监听
        addbtu.addActionListener(mainViewHandler);
        //添加监听
        northjpanel.add(updatebtu);
        //添加监听
        updatebtu.addActionListener(mainViewHandler);
        northjpanel.add(deletebtu);
        //添加监听
        deletebtu.addActionListener(mainViewHandler);
        northjpanel.add(searchtext);
        searchtext.setPreferredSize(new Dimension(200,20));
        northjpanel.add(searchbtu);
        northjpanel.add(tipsbutton);
        tipsbutton.addActionListener(mainViewHandler);
        northjpanel.add(pre);
        pre.addActionListener(mainViewHandler);
        //添加监听
        searchbtu.addActionListener(mainViewHandler);
        con.add(northjpanel,BorderLayout.NORTH);
    }

    public static void main(String[] args){
        new MainViews();
    }
    public void setPagenow(int pagenow){
        this.pagenow=pagenow;
    }

    public int getPagenow() {
        return pagenow;
    }
 //重新加载
    public void reloadTable() {
        StudentService studentService=new StudentServiceImpl();
        StudentRequest studentRequest=new StudentRequest();
        studentRequest.setPageNow(pagenow);
        studentRequest.setPageSize(pagesize);
        studentRequest.setSearchKey(searchtext.getText().trim());
        TableDTO tableDTO = studentService.retrieveStudent(studentRequest);
        Vector<Vector<Object>> data = tableDTO.getData();
        MainViewTableModel.updateModel(data);
    }
 //获取选中的id(学号)
    public String[] getselectedstudentsno(){
        //获取选中的行
        int[] selectedRow = mainViewTable.getSelectedRows();
        String[] snos=new String[selectedRow.length];
        //取到sno
        for(int i=0;i<selectedRow.length;i++){
            int rowIndex=selectedRow[i];
            Object snoobj=mainViewTable.getValueAt(rowIndex,0);
            snos[i]=snoobj.toString();


        }
       return snos;
    }
}

