import req.TipsRequst;
import res.Stutips;
import res.TipsDTO;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 * 教师查看学生建议
 */
public class SeeTips extends JDialog {
    JPanel north=new JPanel();
    JButton searchbutton=new JButton("查询");
    JTextField  contentsno=new JTextField();
    JPanel center=new JPanel();
    JTextArea tips=new JTextArea();
    JPanel bottom=new JPanel();
    JButton exit=new JButton("退出");
    Container container=getContentPane();
    SeeTipsHander seeTipsHander=new SeeTipsHander(this);
    public SeeTips(){};
    public SeeTips( MainViews mainViews){
        super(mainViews,"意见",true);
        north.add(searchbutton);
        searchbutton.addActionListener(seeTipsHander);
        north.add(contentsno);
        contentsno.setPreferredSize(new Dimension(100,20));
        container.add(north,BorderLayout.NORTH);
        center.add(tips);
        tips.setPreferredSize(new Dimension(480,300));
        container.add(tips,BorderLayout.CENTER);
        bottom.add(exit);
        exit.addActionListener(seeTipsHander);
        container.add(bottom,BorderLayout.SOUTH);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public JTextArea getTips() {
        return tips;
    }

    public void setTips(JTextArea tips) {
        this.tips = tips;
    }

    //获取输入的内容
    public TipsRequst getTip() {
        TipsRequst tipsRequst=new TipsRequst();
        tipsRequst.setSno(contentsno.getText());
        return tipsRequst;

    }


}
