package First;

import static First.VF_R_DataCom.btn_plus;
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

/**
 *
 * @author Christopher
 */
public class VT {

      //Data dt = new Data("VT");
      private static JFrame JF = new JFrame();

      public static JFrame getJF() {
            return JF;
      }
      JButton[] btns = new JButton[]{
            new JButton("Font to PLAIN"),
            new JButton("UIManager PUT"),
            new JButton("Add to P1"),
            new JButton("Ad to TB"),
            new JButton("getP1 UI"),
            new JButton("add Gradient"),
            new JButton("Arrays of VC")};
      int count = 0;

      public VT() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setTitle("Test Window");

            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            int sum = 0;
            for (int a = 0; a < btns.length; a++) {
                  JF.add(btns[a]);
                  //btns[a].setSize(100, 80);
                  btns[a].addActionListener(new BTNSActionL());
                  sum += btns[a].getWidth();
            }
            //btns[0].setSize(100, 80);
            JF.setSize(sum + 20, 100);
            JF.pack();
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
                        System.out.println("\nSET_BG");

                  } else if (ac.equals(btns[2].getText())) {
                        System.out.println("\nAdd to P1");
                        JButton btn = new JButton();
                        VF_R.getP1().add(btn);
                        btn.setBounds(30, 400, 40, 40);

                  } else if (ac.equals(btns[3].getText())) {
                        System.out.println("\nAdd to TB");
                        JButton btn = VF_R.getBTNS_MC()[1];
                        //VF_R.getTB().add(btn);
                        btn.setBounds(6, 400, 40, 40);
                        //VF_R.getTB().setUI(new ToolBarUI());
                        VF_R.getTB().add(btn);
                  } else if (ac.equals(btns[4].getText())) {
                        System.out.println("P1 UI: " + VF_R.getP1().getUI());
                        System.out.println("P1 BG: " + VF_R.getP1().getBackground());
                  } else if (ac.equals(btns[5].getText())) {
                        System.out.println("add Gradient");
                        VF_R.getP1().repaint();
                        //GradientPaint gp = new GradientPaint();
                        //VF_R.getP1()

                  } else if (ac.equals(btns[6].getText())) {
                        System.out.println(btns[6].getText());

                        System.out.println("\tJBTNS_P");
                        if (VC_R.getJBTNS_P().length != 0) {
                              for (int a = 0; a < VC_R.getJBTNS_P().length; a++) {
                                    try {
                                          System.out.println("\t\t" + VC_R.getJBTNS_P()[a].getName());
                                    } catch (NullPointerException ex) {
                                          System.out.println(CC.YELLOW + "\t\t\tNO ELEMENTS"
                                                  + CC.RESET);
                                    }
                              }
                        } else {
                              System.out.println("\t\tJBTNS_P is empty");
                        }
                        System.out.println("\tJBTNS_M");
                        if (VC_R.getJBTNS_M().length != 0) {
                              for (int a = 0; a < VC_R.getJBTNS_M().length; a++) {
                                    try {
                                          System.out.println("\t\t" + VC_R.getJBTNS_M()[a].getName());
                                    } catch (NullPointerException ex) {
                                          System.out.println(CC.YELLOW + "\t\t\tNO ELEMENTS"
                                                  + CC.RESET);
                                    }
                              }
                        } else {
                              System.out.println("\t\tJBTNS_M is empty");
                        }
                        System.out.println("\tBTN_Dist");
                        if (VC_R.getBTNS_Dist().length != 0) {
                              for (int a = 0; a < VC_R.getBTNS_Dist().length; a++) {
                                    System.out.println("\t\t" + VC_R.getBTNS_Dist()[a].getName());
                              }
                        } else {
                              System.out.println("\t\tgetBTNS_Dist is empty");
                        }
                  }
            }

      }
}
