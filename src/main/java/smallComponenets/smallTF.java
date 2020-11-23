package smallComponenets;

import views.first.VF_R;
import MC.DT;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.Caret;
import javax.swing.plaf.BorderUIResource;
import java.io.Writer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Christopher
 */
public class smallTF extends JTextField {

      public smallTF() {
            Font f = new Font("Dialog", Font.BOLD, 16);
            setBackground(DT.TFColor[0]);
            setForeground(Color.WHITE);
            
            setBorder(DT.compoundBorder_N);
            //+++++++++++++++++++++++++++++++++++++++
            setFont(f);
            setEnabled(true);
            setFocusable(true);
            setEditable(true);
            setCaretColor(Color.WHITE);
      }
}
