/**
 * 接收学生发送的建议
 */
package res;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

    public class Stutips {
        String sno;
       String tips;
        Map<String, String> map = new HashMap<>();

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

    }

