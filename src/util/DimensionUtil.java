/**
 * 屏幕工具类
 */
/*package util;

import javax.swing.*;
import java.awt.*;

public class DimensionUtil {
    public static Rectangle getBouns(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //保证主界面不会覆盖电脑屏幕任务栏
        //获取屏幕不可见的大小
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());
        //矩形
       Rectangle rectangle = new Rectangle(screenInsets.left, screenInsets.top, screenSize.width - screenInsets.right - screenInsets.left,
                screenSize.height - screenInsets.top - screenInsets.bottom);
        return rectangle;

    }
}*/
