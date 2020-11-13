/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import Create.Listeners.BTN_Dists;
import Create.Listeners.BTN_MP_AL;
import Create.Listeners.TFTable_KL_Control;
import Create.Listeners.TF_KL_Control;
import static Create.VC_R_DataCom.lb_Status;
import MC.DT;
import Others.LimitN;
import com.cofii.myClasses.MLayout;
import com.cofii.myInterfaces.SerializationExceptionAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.JTextComponent;
import org.apache.commons.lang3.SerializationException;
import smallComponenets.NumberOTF;
import smallComponenets.smallBTN_C;
import smallComponenets.smallBTN_TG;
import smallComponenets.smallCHBX;
import smallComponenets.smallCOMBX;
import smallComponenets.smallLB;
import smallComponenets.smallTF;
import smallComponenets.smallTR_JP;

/**
 *
 * @author C0FII
 */
public class VC_R2 extends VC_R_DataCom {

      private void componentsConfig() {
            for (int a = 0; a < headers.length; a++) {
                  headers[a] = new smallLB(headers_t[a]);
            }
            
            panelType.setLayout(new BoxLayout(panelType, BoxLayout.X_AXIS));
            panelType.add(combType);
            panelType.add(tfType1);
            //((AbstractDocument) tfType1.getDocument()).setDocumentFilter(new LimitN());
            panelType.add(tfType2);
            //((AbstractDocument) tfType2.getDocument()).setDocumentFilter(new LimitN());
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private <T> T[] getColumn(Class<T> clas, T[][] doubleArray, int col) {
            T[] returnObject = (T[]) Array.newInstance(clas, doubleArray.length);
            for (int a = 0; a < doubleArray.length; a++) {
                  returnObject[a] = (T) doubleArray[a][col];
            }
            return returnObject;
      }

      private <T> void listToArray(ArrayList<T> list, T[] array) {
            for (int a = 0; a < list.size(); a++) {
                  array[a] = list.get(a);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private void startCreate() {
            for (int a = 0; a < compsD.length; a++) {
                  for (int b = 0; b < compsD[a].length; b++) {
                        if (a > 1) {
                              compsD[a][b].setVisible(false);
                        }
                  }
            }

            TF_KL_Control tfkl = new TF_KL_Control();
            BTN_MP_AL btnAC = new BTN_MP_AL();
            BTN_Dists btnDis = new BTN_Dists();

            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = (smallLB) getColumn(JComponent.class, compsD, 0)[a + 1];
                  tfs[a] = (smallTF) getColumn(JComponent.class, compsD, 1)[a + 1];
                  btns_m[a] = (smallBTN_C) getColumn(JComponent.class, compsD, 2)[a + 1];
                  btns_p[a] = (smallBTN_C) getColumn(JComponent.class, compsD, 3)[a + 1];
                  combs[a] = (smallCOMBX) getColumn(JComponent.class, compsD, 4)[a + 1];
                  checkbs[a] = (smallCHBX) getColumn(JComponent.class, compsD, 5)[a + 1];
                  
                  panelTypes[a] = (smallTR_JP) getColumn(JComponent.class, compsD, 6)[a + 1];
                  
                  btns_Dist[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 7)[a + 1];
                  btns_Dist2[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 8)[a + 1];
                  btns_Tabl[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 9)[a + 1];
                  btns_Tag[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 10)[a + 1];
                  btns_Clock[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 11)[a + 1];
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  lbOrigText[a] = "Column " + (a + 1);
                  btns_Tabl[a].setName("btns_Tabl " + (a + 1));
                  btns_Clock[a].setName("btns_Clock " + (a + 1));
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  tfs[a].setMinimumSize(new Dimension(200, 27));
                  tfs[a].addKeyListener(tfkl);
                  btns_m[a].addActionListener(btnAC);
                  btns_p[a].addActionListener(btnAC);
                  
                  panelTypes[a].setMinimumSize(new Dimension(240, 27));
                  
                  btns_Dist[a].addActionListener(btnDis);
                  btns_Dist2[a].setEnabled(false);
                  btns_Tag[a].addActionListener(btnDis);

                  btns_Tabl[a].addActionListener(btnDis);
                  btns_Clock[a].addActionListener(btnDis);
            }
            
            for(int a = 0; a < panelTypes.length; a++){
                  combTypes[a] = (smallCOMBX) panelTypes[a].getComponent(0);
                  //combTypes[a]
                  tfsTypes1[a] = (NumberOTF) panelTypes[a].getComponent(1);
                  tfsTypes2[a] = (NumberOTF) panelTypes[a].getComponent(2);
                  
                  ((AbstractDocument) tfsTypes1[a].getDocument()).setDocumentFilter(new LimitN());
                  ((AbstractDocument) tfsTypes2[a].getDocument()).setDocumentFilter(new LimitN());
                  
                  combTypes[a].setMinimumSize(new Dimension(100, 27));
                  tfsTypes1[a].setMinimumSize(new Dimension(40, 27));
                  tfsTypes2[a].setMinimumSize(new Dimension(40, 27));
            }

            btns_m[0].setEnabled(false);
            btns_p[DT.maxColumns - 1].setEnabled(false);
            headers[7].setForeground(Color.GRAY);

      }

      private void startUpdate() {

      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void JPUConfig() {
            JF.add(JPU, BorderLayout.NORTH);
            JPU.setLayout(new BoxLayout(JPU, BoxLayout.X_AXIS));
            JPU.setBorder(new LineBorder(Color.WHITE, 1));
            JPU.setBackground(Color.BLACK);
            JPU.setPreferredSize(new Dimension(500, 46));
            JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

            JPU.add(lb_Title);
            lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setPreferredSize(new Dimension(200, 27));
            lb_Title.setMaximumSize(new Dimension(200, 27));

            JPU.add(tf_Title);
            tf_Title.setPreferredSize(new Dimension(tf_Title.getPreferredSize().width, 27));
            tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            tf_Title.addKeyListener(new TFTable_KL_Control());
            JPU.add(Box.createHorizontalStrut(10));
      }

      private void JPCConfig() {
            JF.add(sc_JPC, BorderLayout.CENTER);
            sc_JPC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sc_JPC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            sc_JPC.setBorder(new LineBorder(Color.WHITE, 1));

            componentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(JPC);
            JPC.setLayout(gl);
            JComponent[] comps = new JComponent[]{
                  lb, tf, btn_m, btn_p, comb, checkb, panelType,
                  btn_Dist, btn_Dist2, btn_Tabl, btn_Tag, btn_Clock};
            MLayout.setSerializationExceptionAction(new SerializationExceptionAction() {
                  @Override
                  public JComponent getComponent(SerializationException se, JComponent jc) {
                        JComponent returnValue = null;
                        if (jc instanceof smallBTN_TG) {
                              Color[] c = ((smallBTN_TG) jc).C;
                              returnValue = new smallBTN_TG(c);
                              
                        } else if (jc instanceof smallBTN_C) {
                              String text = ((smallBTN_C) jc).Title;
                              returnValue = new smallBTN_C(text);
                        }
                        return returnValue;
                  }

            });
            compsD = MLayout.lineSequence(gl, headers, comps, DT.maxColumns, 27);
      }

      private void JPBConfig(String text) {
            JF.add(JPB, BorderLayout.SOUTH);
            JPB.setBackground(Color.BLACK);
            JPB.setPreferredSize(new Dimension(500, 40));
            JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
            JPB.setLayout(new BoxLayout(JPB, BoxLayout.X_AXIS));

            JPB.add(lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            lb_Status.setBorder(new CompoundBorder(bb, be));
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));

            JPB.add(Box.createHorizontalStrut(6));
            JPB.add(btn_CU);
            btn_CU.setText(text);
            btn_CU.setMinimumSize(new Dimension(60, 28));
            JPB.add(Box.createHorizontalStrut(10));
      }

      private void JPRConfig(String choice) {
            JF.add(JPR, BorderLayout.EAST);
            JPR.setBackground(Color.BLACK);
            JPR.setBorder(new LineBorder(Color.WHITE, 1));
            JPR.setMinimumSize(new Dimension(200, 40));
            JPR.setPreferredSize(new Dimension(200, 500));
            JPR.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
            JPR.setLayout(new BoxLayout(JPR, BoxLayout.Y_AXIS));

            //ADDING LB TO JPR AND TO TDISP+++++++++++++++++++++
            for (int a = 0; a < lb_TDisp.length; a++) {
                  if (choice.equals("CREATE")) {
                        lb_TDisp[a] = new smallLB(lb_Disp_textC[a]);
                  }

                  lb_TDisp[a].setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
                  if (a % 2 == 0) {
                        lb_TDisp[a].setFont(new Font("Dialog", Font.BOLD, 22));
                  }
                  JPR.add(lb_TDisp[a]);//HOLD ALL LBS AT THIS TIME
            }
            JPR.add(lb_ClockLocation);
            lb_ClockLocation.setForeground(Color.YELLOW.darker());
            //lb_ClockLocation.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            
            JPR.add(bxClock);
            bxClock.add(tfClock);
            tfClock.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            bxClock.add(btn_ClockLocation);
            btn_ClockLocation.setMinimumSize(new Dimension(20, 27));
            lb_ClockLocation.setVisible(false);
            bxClock.setVisible(false);
            
            //ADDING LB TO ADISP
            ArrayList<JLabel> listLabelsA = new ArrayList<JLabel>();
            ArrayList<JLabel> listLabelsT = new ArrayList<JLabel>();
            for (int a = 0; a < lb_TDisp.length; a++) {
                  if (a % 2 == 1) {
                        listLabelsA.add(lb_TDisp[a]);
                  } else {
                        listLabelsT.add(lb_TDisp[a]);
                  }
            }
            listToArray(listLabelsT, lb_TDisp);
            listToArray(listLabelsA, lb_ADisp);
            //DIST2 OFF
            lb_TDisp[1].setForeground(Color.GRAY);
            lb_ADisp[1].setForeground(Color.GRAY);
      }

      public VC_R2(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(new BorderLayout());

            JPUConfig();
            JPCConfig();//GroupLayout setUp

            //+++++++++++++++++++++++++++++++++++++
            if (choice.equals("CREATE")) {
                  startCreate();
            } else if (choice.equals("UPDATE")) {
                  startUpdate();
            }
            //+++++++++++++++++++++++++++++++++++++

            JPBConfig(choice);
            JPRConfig(choice);

            JF.setVisible(true);
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        VC_R2 vc = new VC_R2("CREATE");
                        vc.JF.setSize(1100, 500);
                        vc.JF.setAlwaysOnTop(true);
                  }

            });
      }
}
