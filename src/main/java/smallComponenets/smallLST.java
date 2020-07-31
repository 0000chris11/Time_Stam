package smallComponenets;

import MC.DT;
import MC.Data;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Christopher
 */
public class smallLST extends JList {

      public smallLST() {
            Font f = new Font("Dialog", Font.BOLD, 16);

            setBackground(DT.TFColor[0]);
            setForeground(Color.WHITE);
            setFont(f);
            setFixedCellWidth(240);
            this.setSelectionBackground(new Color(0,0,90));
            this.setSelectionForeground(Color.WHITE);
            
            setBorder(Data.compoundBorder_N);
            //setSize(290, 170);
      }
}
