package First;

import static First.VF_R_DataCom.btn_plus;
import MC.DT;
import Others.CC;
import Second.VC_R;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicToolBarUI;
import smallComponenets.smallTF;
import javax.swing.plaf.metal.MetalButtonUI;
import static First.VF_R_DataCom.PT;
import mMethods.MM;
import java.awt.FontMetrics;
import java.util.ArrayList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author Christopher
 */
public class VT {

      //Data dt = new Data("VT");
      private static JFrame JF = new JFrame();
      
      private static JSeparator SP = new JSeparator();
      final int sp_h = 4;

      public static JFrame getJF() {
            return JF;
      }
      /*
      JButton[] btns = new JButton[]{
            new JButton("Font to PLAIN"),//SPECIAL
            new JButton("VF_R Frame Size"),
            new JButton("getLook and Feel"),
            new JButton("Change FG of JTB"),
            new JButton("ADD Test SP"),
            new JButton("LB_JT to Y=0"),
            new JButton("NoRowsDetection")};
      */
      JButton[] btns;
      int count = 0;

      public VT(ArrayList<String> list) {
            //+++++++++++++++++++++++++++++++
            //+++++++++++++++++++++++++++++++
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setTitle("Test Window");
            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            
            int sum = 0;
            btns = new JButton[list.size()];
            for (int a = 0; a < list.size(); a++) {
                  //JF.add(btns[a]);
                  btns[a] = new JButton(list.get(a));
                  JF.add(btns[a]);
                  //btns[a].setSize(100, 80);
                  btns[a].addActionListener(new BTNSActionL());
                  sum += btns[a].getWidth();
            }
            //btns[0].setSize(100, 80);
            JF.setSize(sum + 20, 100);
            JF.pack();
            //++++++++++++++++++++++++++++++
            SP.setForeground(Color.BLUE);
            SP.setOrientation(SwingConstants.HORIZONTAL);
            SP.setSize(60, sp_h);
            SP.setBorder(new LineBorder(new Color(0,0,255), sp_h));
            //+++++++++++++++++++++++++++++++
      }

      /*
      public static void main(String[] args) {
            new VT().JF.setVisible(true);
      }
       */
      class BTNSActionL implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                  String ac = evt.getActionCommand();
                  
                  for(int a = 0; a < btns.length; a++){
                        
                  }
                  
                  
                  if (ac.equals(btns[0].getText())) {
                        int fontSize = VF_R.getJM_Select().getMenuComponent(0).getFont().getSize();
                        Font[] F = new Font[]{
                              new Font("Dialog", Font.PLAIN, fontSize),
                              new Font("Dialog", Font.BOLD, fontSize)};
                        if (count % 2 == 0) {
                              System.out.println("PLAIN");
                              VF_R.getJM_Select().getMenuComponent(0).setFont(F[0]);
                              btns[0].setText("Font to BOLD");
                        } else {
                              System.out.println("BOLD");
                              VF_R.getJM_Select().getMenuComponent(0).setFont(F[1]);
                              btns[0].setText("Font to PLAIN");
                        }
                        count++;

                  } else if (ac.equals(btns[1].getText())) {
                        System.out.println(btns[1].getText());
                        System.out.println("\t" + VF_R.getJF().getSize());

                  } else if (ac.equals(btns[2].getText())) {
                        System.out.println(btns[2].getText());
                        System.out.println("\t" + UIManager.getLookAndFeel().getName());

                  } else if (ac.equals(btns[3].getText())) {
                        System.out.println(btns[3].getText());

                        VF_R.getJT().setForeground(Color.RED);
                  } else if (ac.equals(btns[4].getText())) {
                        System.out.println(btns[4].getText());
                        JLabel LB = VF_R.getLB_JT();
                        FontMetrics FM = LB.getFontMetrics(LB.getFont());
                        
                        VF_R.getJF().add(SP);
                        SP.setLocation(LB.getX() + LB.getInsets().left
                                , VF_R.getLB_JT().getY() - 6);
                        SP.setSize(FM.stringWidth(LB.getText()), sp_h);
                        
                        
                        
                        
                  } else if (ac.equals(btns[5].getText())) {
                        System.out.println("add Gradient");
                        VF_R.getLB_JT().setLocation
                              (VF_R.getLB_JT().getX(), VF_R.getJMB().getHeight());

                  } else if (ac.equals(btns[6].getText())) {
                        System.out.println(btns[6].getText());

                        VF_R.setLB_JTToCenter(VF_R.getLB_JT(), VF_R.getSC_JT());
                        System.out.println("\tLB_JT Location: " + 
                                VF_R.getLB_JT().getLocation());
                  }
            }

      }
}
