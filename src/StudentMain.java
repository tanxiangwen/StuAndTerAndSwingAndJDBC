import ext.MainViewTable;
import ext.StudentTableModel;
import req.SearchRequest;
import res.StuDTO;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * 学生查询主页面
 * 查询自己的成绩，查自己的排名
 */
public class StudentMain extends JFrame {
    StuWrite stuWrite;
    JPanel northpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JTextField search=new JTextField();
    JButton searchButton=new JButton("查找");
    JButton lookButton =new JButton("排名");
    JTextField look=new JTextField();
    JButton tips=new JButton("意见反馈");
    JButton pre=new JButton("返回");
    JTable dataTable=new JTable();
    MainViewTable mainViewTable=new MainViewTable();
    SearchHander searchHander=new SearchHander(this,stuWrite);
    public StudentMain(){
        JFrame jf=new JFrame("查找");
        Container container=jf.getContentPane();
        //北边布局
        northpanel.add(search);

        search.setPreferredSize(new Dimension(200,20));
        northpanel.add(searchButton);
        searchButton.addActionListener(searchHander);
        northpanel.add(lookButton);
        lookButton.addActionListener(searchHander);
        northpanel.add(look);
        look.setPreferredSize(new Dimension(50,20));
        northpanel.add(tips);
        tips.addActionListener(searchHander);
        northpanel.add(pre);
        pre.addActionListener(searchHander);
        container.add(northpanel,BorderLayout.NORTH);
        //中间
        centerpanel(container);
        jf.setVisible(true);
        jf.setSize(1283,640);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);


    }
    private void centerpanel( Container container){

          Studentsearch studentsearch=new Studentsearchsever();
        SearchRequest searchRequest=new SearchRequest();
        searchRequest.setSno(search.getText().trim());
        StuDTO mysearch = studentsearch.Mysearch(searchRequest);
        Vector<Vector<Object>> data=mysearch.getData();
        StudentTableModel mainViewTableModel=StudentTableModel.assembleModel(data);
        mainViewTable.setModel(mainViewTableModel);
      JScrollPane jScrollPane=new JScrollPane(mainViewTable);
      container.add(jScrollPane,BorderLayout.CENTER);


    }
    public void reloadTable() {
        Studentsearch studentsearch=new Studentsearchsever();
        SearchRequest searchRequest=new SearchRequest();
        searchRequest.setSno(search.getText().trim());
        StuDTO mysearch = studentsearch.Mysearch(searchRequest);
        Vector<Vector<Object>> data = mysearch.getData();
        StudentTableModel.updateModel(data);
        //渲染
        //mainViewTable.renderRule();
    }
        public static void main(String[] args){
        new StudentMain();
    }

    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }

    public JTextField getLook() {
        return look;
    }

    public void setLook(JTextField look) {
        this.look = look;
    }
}
