import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 教师端对按钮监听
 */
public class MainViewHandler implements ActionListener {
    private MainViews mainViews;
    public MainViewHandler(MainViews mainViews){
        this.mainViews=mainViews;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton=(JButton) actionEvent.getSource();
        String text=jButton.getText();
        if("增加".equals(text)){
            new addstuview(mainViews);

        }else if("修改".equals(text)){
            //获取修改的行
            String[] selectedstudentsno = mainViews.getselectedstudentsno();
            if(selectedstudentsno.length!=1){
                JOptionPane.showMessageDialog(mainViews,"一次只能修改一条");
                return;
            }


            new Updatestuview(mainViews,selectedstudentsno[0]);

        }else if("返回".equals(text)){
            new AllView();
        }
        else if("学生意见".equals(text)){
                new SeeTips(mainViews);
        }
        else if("删除".equals(text)){
            //获取修改的行
            String[] selectedstudentsno = mainViews.getselectedstudentsno();
            if(selectedstudentsno.length==0){
                JOptionPane.showMessageDialog(mainViews,"请选择删除的行");
                return;
            }
            //确认对话框
            int option=JOptionPane.showConfirmDialog(mainViews,"确定要删除所选择的行吗"
            ,"确认删除",JOptionPane.YES_OPTION);
            if(option==JOptionPane.YES_OPTION){
                //执行删除
                StudentService studentService=new StudentServiceImpl();
                boolean deleteresult= studentService.delete(selectedstudentsno[0]);
                if(deleteresult){
                    //重新加载
                    mainViews.reloadTable();
                }else{
                    JOptionPane.showMessageDialog(mainViews,"删除失败");
                }
            }

        }else if("查找".equals(text)){
            //从第一页开始
            mainViews.setPagenow(1);
            //重新加载
            mainViews.reloadTable();

        }else if("下一页".equals(text)){
            mainViews.setPagenow(mainViews.getPagenow()+1);
            mainViews.reloadTable();

        }else if("上一页".equals(text)){
            mainViews.setPagenow(mainViews.getPagenow()-1);
            mainViews.reloadTable();

        }

    }


}
