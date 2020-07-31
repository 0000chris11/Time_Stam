package smallComponenets;

import First.VF_R;
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
      /*
      private static JTextField tf;

      public static JTextField getTF() {
            return tf;
      }
      Graphics tf_g;
      //+++++++++++++++++++++++++++++++++++
      private static JTextField T1;

      public static JTextField getT1() {
            return T1;
      }

      private static JTextField T2;

      public static JTextField getT2() {
            return T2;
      }
      */
      //+++++++++++++++++++++++++++++++++++
      @Override
      public void paintComponents(Graphics g) {
            super.paintComponents(g);
            /*
            tf.setBorder(new LineBorder(Color.RED, 3));
            System.out.println("\t" + getName() + " is painting (" + tf.getBorder());
            new Thread() {
                  @Override
                  public void run() {
                        int count = 0;
                        do {
                              try {
                                    Thread.sleep(800);
                                    System.out.println(++count);
                                    System.out.println("smallTF: " + smallTF.this.getName());
                                    System.out.println("tf Graphics: " + tf.getGraphics());
                                    System.out.println("smallTF getWidth: " + smallTF.this.getWidth());
                                    System.out.println("smallTF getHeight: " + smallTF.this.getHeight());
                                    tf.getBorder().paintBorder(smallTF.this, tf.getGraphics(), 0, 0,
                                            smallTF.this.getWidth(), smallTF.this.getHeight());

                                    //smallTF.this.getBorder().pa
                                    System.out.println("\t\tpainted Border: " + smallTF.this.getName());
                              } catch (NullPointerException | InterruptedException ex) {
                                    System.err.println(ex.getClass());
                                    //ex.printStackTrace();
                              }
                        } while (true);
                  }
            }.start();
            //getBorder().paintBorder(this, tf.getGraphics(), 0, 0, getWidth(), getHeight());
            */
      }
      /*
      private void setTestJTFS() {
            T1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            T2.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));   
      }
      */
      public smallTF() {
            Font f = new Font("Dialog", Font.BOLD, 16);
            setLayout(null);
            setBackground(DT.TFColor[0]);
            setForeground(Color.WHITE);
            
            setBorder(DT.compoundBorder_N);
            //setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.compoundBorder_N"));
            //+++++++++++++++++++++++++++++++++++++++
            /*
            tf = new JTextField();
            tf.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            tf_g = tf.getGraphics();
            */
            //+++++++++++++++++++++++++++++++++++++++
            setFont(f);
            setEnabled(true);
            setFocusable(true);
            setEditable(true);
            setCaretColor(Color.WHITE);
      }
}
