/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first;

import MC.DT;
import MC.MainInstances;
import com.cofii2.methods.MComp;
import com.cofii2.myAClasses.VT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class VT_T extends VF_R_DataCom {

      private int count = 0;
      
      public VT_T() {
            VT vt = new VT(BoxLayout.Y_AXIS);
            //JTextField tf = new JTextField();
            //vt.add(tf);
            JButton btn = new JButton("GET CB COLOR INFO");
            vt.add(btn);
            JButton btn2 = new JButton("Comparing");
            vt.add(btn2);
            JButton btn3 = new JButton("GET LISTENERS");
            vt.add(btn3);
            JButton btn4 = new JButton("DIST BUTTONS");
            vt.add(btn4);

            btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        VC_R_Comps c = MainInstances.getVC_R_Comps();
                        MComp.printComboBoxColorInfo(c.getCBS_Customs()[0]);
                        MComp.printComboBoxColorInfo(c.getCBS_Customs()[1]);

                  }

            });
            btn2.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println(btn2.getText());
                        JComponent leftC = (JComponent) VF_R.getSPL().getLeftComponent();
                        JComponent rightC = (JComponent) VF_R.getSPL().getRightComponent();

                        System.out.println("SPL Divider Location: " + VF_R.getSPL().getDividerLocation());

                        MComp.printComponentSizeInfo(leftC);
                        MComp.printComponentSizeInfo(rightC);

                        System.out.println("SPL_SUB Divider Location: " + VF_R.getSPL_SUB().getDividerLocation());
                        JComponent topC = (JComponent) VF_R.getSPL_SUB().getTopComponent();
                        JComponent bottC = (JComponent) VF_R.getSPL_SUB().getBottomComponent();
                        MComp.printComponentSizeInfo(topC);
                        MComp.printComponentSizeInfo(bottC);
                        //MTable.printTableModelInfo(JT.getModel());
                        //MComp.printComponentSizeInfo(PL_B);
                        //MComp.printComponentSizeInfo(JT);

                  }

            });
            btn3.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        VC_R_Comps c = MainInstances.getVC_R_Comps();
                        for (int a = 0; a < DT.maxColumns; a++) {
                              for (int b = 0; b < c.getBTNS_ImageC()[a].getActionListeners().length; b++) {
                                    System.out.println((a + 1) + ": " + c.getBTNS_ImageC()[a].
                                            getActionListeners()[b].getClass().toString());
                              }
                        }
                  }

            });
            btn4.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        VC_R_DataCom d = MainInstances.getVC_R_DataCom();
                        VC_R_Comps c = MainInstances.getVC_R_Comps();
                        System.out.println("PCD_U HEIGHT: " + d.getPCD_U().getHeight());
                        System.out.println("\tPCD_UDist HEIGHT: " + d.getPCD_UDist().getHeight());
                        System.out.println("\tPCD_UDist2 HEIGHT: " + d.getPCD_UDist2().getHeight());
                        System.out.println("\tPCD_UImageC HEIGHT: " + d.getPCD_UImageC().getHeight());
                        System.out.println("\tPCD_UTag HEIGHT: " + d.getPCD_UTag().getHeight());
                        System.out.println("\tPCD_UClock HEIGHT: " + d.getPCD_UClock().getHeight());

                  }

            });

            vt.pack();
            vt.setVisible(true);
      }

      public void printArray(Object[] ar) {
            for (int a = 0; a < ar.length; a++) {
                  System.out.println("\t" + ar[a]);
            }
      }
}
