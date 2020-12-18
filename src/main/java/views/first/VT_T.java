/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first;

import MC.DT;
import MC.MainInstances;
import com.cofii2.myClasses.VT;
import com.cofii2.myMethods.MComp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import static views.first.VF_R_DataCom.cbs;
import views.mainTable.VMT;

/**
 *
 * @author C0FII
 */
public class VT_T extends VF_R_DataCom {

      public VT_T() {
            VT vt = new VT(BoxLayout.Y_AXIS);
            //JTextField tf = new JTextField();
            //vt.add(tf);
            JButton btn = new JButton("GET JCBS SIZE INFO");
            vt.add(btn);
            JButton btn2 = new JButton("Comparing");
            vt.add(btn2);
            JButton btn3 = new JButton("Get CLIENT PROPERTY");
            vt.add(btn3);
            JButton btn4 = new JButton("GET JMT COLUMNS SIZE");
            vt.add(btn4);

            btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        for (int a = 0; a < DT.maxColumns; a++) {
                              MComp.printComponentSizeInfo(VF_R.getJCBS()[a]);
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
                       VMT vmt = MainInstances.getVMT();
                       System.out.println(vmt.getSC_JTDists().getParent().toString());
                       System.out.println("Dist row count: " + vmt.getJTDists().getRowCount());
                       System.out.println("Dist column count: " + vmt.getJTDists().getColumnCount());
                       MComp.printComponentSizeInfo(vmt.getSC_JTDists());
                       System.out.println("###############################");
                       System.out.println(vmt.getSC_JTTypes().getParent().toString());
                       System.out.println("Dist row count: " + vmt.getJTTypes().getRowCount());
                       System.out.println("Dist column count: " + vmt.getJTTypes().getColumnCount());
                       MComp.printComponentSizeInfo(vmt.getSC_JTTypes());
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
