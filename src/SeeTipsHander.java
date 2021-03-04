import req.TipsRequst;
import res.Stutips;
import res.TipsDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 对SeeTips监听
 */
public class SeeTipsHander implements ActionListener {
    SeeTips seeTips;
    public SeeTipsHander( SeeTips seeTips){
        this.seeTips=seeTips;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("查询".equals(text)){

            Studentsearch studentsearch=new Studentsearchsever();
            TipsRequst tip = seeTips.getTip();
            TipsDTO tipsDTO = studentsearch.seeTip(tip);
            String s1=tipsDTO.getText();
          seeTips.getTips().setText(s1);




        }else if("退出".equals(text)){
               seeTips.dispose();
        }

    }
}
