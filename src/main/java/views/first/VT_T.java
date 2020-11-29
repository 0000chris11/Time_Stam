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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import views.Login.VL;

/**
 *
 * @author C0FII
 */
public class VT_T extends VF_R_DataCom {

      public VT_T() {
            VT vt = new VT(BoxLayout.Y_AXIS);
            //JTextField tf = new JTextField();
            //vt.add(tf);
            JButton btn = new JButton("Get Info About Component");
            vt.add(btn);
            JButton btn2 = new JButton("Comparing");
            vt.add(btn2);
            JButton btn3 = new JButton("Get SPL Components");
            vt.add(btn3);
            JButton btn4 = new JButton("GET Default Table");
            vt.add(btn4);

            btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        Class ss = JT.getModel().getClass();
                        System.out.println("DeclaredFields: " + ss.getDeclaredFields());
                        printArray(ss.getDeclaredFields());
                        System.out.println("TypeParameters: " + ss.getTypeParameters());
                        printArray(ss.getTypeParameters());
                        System.out.println("Fields: " + ss.getFields());
                        printArray(ss.getFields());
                        System.out.println("Methods: " + ss.getMethods());
                        printArray(ss.getMethods());

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
                        System.out.println("SPL LeftComponent: " + 
                                VF_R.getSPL().getLeftComponent().getClass());
                        System.out.println("SPL RightComponent: " + 
                                VF_R.getSPL().getRightComponent().getClass());
                  }

            });
            btn4.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("DefaultTable: " + DT.getDTable());
                        
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
