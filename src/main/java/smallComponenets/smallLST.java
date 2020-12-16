package smallComponenets;

import MC.DT;
import MC.LKCustom;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
/**
 *
 * @author Christopher
 */
public class smallLST extends JList {

      public smallLST() {
            Font f = new Font("Dialog", Font.BOLD, 16);

            setBackground(LKCustom.BK_NORMAL);
            setForeground(Color.WHITE);
            setFont(f);
            setFixedCellWidth(240);
            this.setSelectionBackground(new Color(0,0,90));
            this.setSelectionForeground(Color.WHITE);
            
            setBorder(LKCustom.BR_LINEMARIGIN_FOCUS_OFF);
            //setSize(290, 170);
      }
}
