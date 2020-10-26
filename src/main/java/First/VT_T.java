/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import static First.VF_R_DataCom.JT;
import static First.VF_R_DataCom.PL_B;
import com.cofii.myMethods.MTable;
import com.cofii.myClasses.VT;
import com.cofii.myMethods.MComp;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author C0FII
 */
public class VT_T extends VF_R_DataCom{
     
      public VT_T() {
            VT vt = new VT(BoxLayout.Y_AXIS);
            //JTextField tf = new JTextField();
            //vt.add(tf);
            JButton btn = new JButton("GET INFO");
            vt.add(btn);
            JButton btn2 = new JButton("COMPARING");
            vt.add(btn2);
            JButton btn3 = new JButton("GET TABLE MODEL");
            vt.add(btn3);
            JButton btn4 = new JButton("JF COMPONENTS");
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
                        MTable.printTableModelInfo(JT.getModel());
                        MComp.printComponentSizeInfo(PL_B);
                        MComp.printComponentSizeInfo(JT);
                        
                  }

            });
            btn3.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        
                  }

            });
            btn4.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        for (int a = 0; a < JF.getContentPane().getComponentCount(); a++) {
                              if (JF.getContentPane().getLayout() instanceof BorderLayout) {
                                    System.out.println(JF.getContentPane().getComponent(a).getName() + ": "
                                            + ((BorderLayout) JF.getContentPane().getLayout()).getConstraints(
                                                    JF.getContentPane().getComponent(a)));
                              } else {
                                    System.out.println(JF.getClass().toString() + " "
                                            + "is not instanceof BorderLayout");
                              }
                        };
                  }

            });

            vt.pack();
            vt.setVisible(true);
      }
      
      public void printArray(Object[] ar){
            for(int a = 0; a < ar.length; a++){
                  System.out.println("\t" + ar[a]);
            }
      }
}
