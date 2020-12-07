/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first;

import views.first.VF_R;
import static views.first.VF_R_DataCom.JT;
import MC.DT;
import com.cofii.myClasses.VT;
import com.cofii.myMethods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import views.Login.VL;
import static views.first.VF_R_DataCom.cbs;

/**
 *
 * @author C0FII
 */
public class VT_T extends VF_R_DataCom {

      public VT_T() {
            VT vt = new VT(BoxLayout.Y_AXIS);
            //JTextField tf = new JTextField();
            //vt.add(tf);
            JButton btn = new JButton("SET RIGHT COMPONENT");
            vt.add(btn);
            JButton btn2 = new JButton("Comparing");
            vt.add(btn2);
            JButton btn3 = new JButton("Get CLIENT PROPERTY");
            vt.add(btn3);
            JButton btn4 = new JButton("GET CBS TFS BACKGROUND");
            vt.add(btn4);

            btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        for (int a = 0; a < DT.maxColumns; a++) {
                              MComp.printComponentSizeInfo(VF_R.getJCBS()[a]);
                              MComp.printComponentSizeInfo(VF_R.getJTFES()[a]);
                        }

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
                        for (int a = 0; a < DT.maxColumns; a++) {
                              //System.out.println(VF_R.getJTFES()[a].getClientProperty("TextField.highlight"));
                              System.out.println(cbs[a].getEditor().getEditorComponent().getClass().toString());
                        }
                        System.out.println("TextField.shadow: " + UIManager.get("TextField.shadow"));
                        System.out.println("TextField.margin: " + UIManager.get("TextField.margin"));
                        System.out.println("TextField.highlight: " + UIManager.get("TextField.highlight"));
                        System.out.println("TextField.focusInputMap: " + UIManager.get("TextField.focusInputMap"));
                        System.out.println("TextField.darkShadow: " + UIManager.get("TextField.darkShadow"));
                        System.out.println("TextField.border: " + UIManager.get("TextField.border"));
                  }

            });
            btn4.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJTFPanel()[a].getComponent(0).getName().contains("CB")) {
                                    System.out.println("CB_" + (a + 1) + ": " + VF_R.getJCBS()[a].getBackground());
                              } else {
                                    System.out.println("TF_" + (a + 1) + ": " + VF_R.getJTFES()[a].getBackground());
                              }
                        }
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
