import res.StudentDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatestudentviewHandler implements ActionListener {
    private Updatestuview updatestuview;
    private MainViews mainView;
    public UpdatestudentviewHandler(Updatestuview updatestuview, MainViews mainview){
      this.updatestuview=updatestuview;
        this.mainView=mainview;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton)actionEvent.getSource();
        String text=jButton.getText();
        if("修改".equals(text)){
            StudentService studentService=new StudentServiceImpl();
            StudentDO studentDO=updatestuview.buildStudentDO();
            boolean updateresult=studentService.update(studentDO);
            if(updateresult){
                mainView.reloadTable();
                updatestuview.dispose();
            }else{
                JOptionPane.showMessageDialog(updatestuview,"修改失败");
            }
        }


    }
}
