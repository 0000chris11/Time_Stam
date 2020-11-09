/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import Create.Listeners.BTN_Dists;
import Create.Listeners.BTN_MP_AL;
import Create.Listeners.TF_KL_Control;
import static Create.VC_R_DataCom.lb_Status;
import MC.DT;
import com.cofii.myClasses.MLayout;
import com.cofii.myInterfaces.SerializationExceptionAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
import org.apache.commons.lang3.SerializationException;
import smallComponenets.smallBTN_TG;
import smallComponenets.smallLB;

/**
 *
 * @author C0FII
 */
public class VC_R2 extends VC_R_DataCom {

      private void componentsConfig() {
            for (int a = 0; a < headers.length; a++) {
                  headers[a] = new smallLB(headers_t[a]);
            }

            //btn_m.setMaximumSize(new Dimension(20, 27));
            //btn_p.setMaximumSize(new Dimension(20, 27));
            comb.setBackground(DT.TFColor[0]);
            comb.setForeground(Color.WHITE);
            comb.setFont(tf.getFont());
            checkb.setToolTipText("Allow null");

            //btn_Dist.setBackground(Color.WHITE);
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

            /*
            Object[] ob_lbs = getColumn(compsD, 0);
            Object[] ob_tfs = getColumn(compsD, 1);
            Object[] ob_btnm = getColumn(compsD, 2);
            Object[] ob_btnp = getColumn(compsD, 3);
            Object[] ob_dis = getColumn(compsD, 6);
            Object[] ob_dis2 = getColumn(compsD, 7);
            Object[] ob_tab = getColumn(compsD, 8);
            Object[] ob_tag = getColumn(compsD, 9);
            Object[] ob_ck = getColumn(compsD, 10);
            */
            TF_KL_Control tfkl = new TF_KL_Control();
            BTN_MP_AL btnAC = new BTN_MP_AL();
            BTN_Dists btnDis = new BTN_Dists();
            /*
            tfs = (JTextField[]) getColumn(JComponent.class, compsD, 1);
            btns_m = (JButton[]) getColumn(JComponent.class, compsD, 2);
            btns_p = (JButton[]) getColumn(JComponent.class, compsD, 3);
            btns_Dist = (smallBTN_TG[]) getColumn(JComponent.class, compsD, 6);
            btns_Dist2 = (smallBTN_TG[]) getColumn(JComponent.class, compsD, 7);
            btns_Tabl = (smallBTN_TG[]) getColumn(JComponent.class, compsD, 8);
            btns_Tag = (smallBTN_TG[]) getColumn(JComponent.class, compsD, 9);
            btns_Clock = (smallBTN_TG[]) getColumn(JComponent.class, compsD, 10);
            */
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = (JLabel) getColumn(JComponent.class, compsD, 0)[a + 1];
                  tfs[a] = (JTextField) getColumn(JComponent.class, compsD, 1)[a + 1];
                  btns_m[a] = (JButton) getColumn(JComponent.class, compsD, 2)[a + 1];
                  btns_p[a] = (JButton) getColumn(JComponent.class, compsD, 3)[a + 1];
                  btns_Dist[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 6)[a + 1];
                  btns_Dist2[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 7)[a + 1];
                  btns_Tabl[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 8)[a + 1];
                  btns_Tag[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 9)[a + 1];
                  btns_Clock[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 10)[a + 1];
                  
                  lbOrigText[a] = "Column " + (a + 1);
                  //tfs[a] = (JTextField) ob_tfs[a + 1];
                  //btns_m[a] = (JButton) ob_btnm[a + 1];
                  //btns_p[a] = (JButton) ob_btnp[a + 1];
                  //btns_Dist[a] = (smallBTN_TG) ob_dis[a + 1];
                  //btns_Dist2[a] = (smallBTN_TG) ob_dis2[a + 1];
                  //btns_Tabl[a] = (smallBTN_TG) ob_tab[a + 1];
                  //btns_Tag[a] = (smallBTN_TG) ob_tag[a + 1];
                  //btns_Clock[a] = (smallBTN_TG) ob_ck[a + 1];

                  btns_Tabl[a].setName("btns_Tabl " + (a + 1));
                  btns_Clock[a].setName("btns_Clock " + (a + 1));

                  tfs[a].addKeyListener(tfkl);
                  btns_m[a].addActionListener(btnAC);
                  btns_p[a].addActionListener(btnAC);
                  btns_Dist[a].addActionListener(btnDis);
                  btns_Dist2[a].setEnabled(false);
                  btns_Tag[a].addActionListener(btnDis);

                  btns_Tabl[a].addActionListener(btnDis);
                  btns_Clock[a].addActionListener(btnDis);
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
                  lb, tf, btn_m, btn_p, comb, checkb,
                  btn_Dist, btn_Dist2, btn_Tabl, btn_Tag, btn_Clock};
            MLayout.setSerializationExceptionAction(new SerializationExceptionAction() {
                  @Override
                  public JComponent getComponent(SerializationException se, JComponent jc) {
                        JComponent returnValue = null;
                        if (jc instanceof smallBTN_TG) {
                              returnValue = new smallBTN_TG();
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

            //System.out.println("lb_TDisp length: " + lb_TDisp.length);
            //System.out.println("lb_Disp_textC length: " + lb_Disp_textC.length);
            for (int a = 0; a < lb_TDisp.length; a++) {
                  if (choice.equals("CREATE")) {
                        lb_TDisp[a] = new smallLB(lb_Disp_textC[a]);
                  }

                  lb_TDisp[a].setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
                  if (a % 2 == 0) {
                        lb_TDisp[a].setFont(new Font("Dialog", Font.BOLD, 22));
                  }
                  JPR.add(lb_TDisp[a]);
            }
            ArrayList<JLabel> listLabels = new ArrayList<JLabel>();
            for (int a = 0; a < lb_TDisp.length; a++) {
                  if (a % 2 == 1) {
                        listLabels.add(lb_TDisp[a]);
                  }
            }

            listToArray(listLabels, lb_ADisp);
      }

      public VC_R2(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(new BorderLayout());

            JPUConfig();
            JPCConfig();

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
                        vc.JF.setSize(800, 500);
                  }

            });
      }
}
