/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create;

import MC.DT;
import MC.DTSQL;
import MC.LK_C;
import MC.MainInstances;
import MC.TablesInfo;
import com.cofii2.methods.MComp;
import com.cofii2.myAClasses.MLayout;
import com.cofii2.myInterfaces.SerializationExceptionAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import org.apache.commons.lang3.SerializationException;
import smallComponenets.smallBTN_C;
import smallComponenets.smallBTN_TG;
import smallComponenets.smallLB;
import views.create.Actions.Table_KControlException;
import views.create.listeners.BTN_CU_AL;
import views.create.listeners.VCListener;
import views.create.mTFControl.MTF_Control3;

/**
 *
 * @author C0FII
 */
public class VC_R2 {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps vc = MainInstances.getVC_R_Comps();

      //CHANGE THEM LATER++++++++++++++++++++++++++++++++++++++++++++
      private void beforeComponentsConfig() {
            for (int a = 0; a < vc.headers.length; a++) {
                  vc.headers[a] = new smallLB(vc.headers_t[a]);
            }

            vc.panelExtra.setLayout(new BoxLayout(vc.panelExtra, BoxLayout.X_AXIS));
            vc.panelExtra.add(vc.rbExtra, 0);
            vc.panelExtra.add(vc.cbExtra, 1);
            vc.panelExtra.add(vc.tfIDEN1, 2);
            vc.panelExtra.add(vc.tfIDEN2, 3);
            vc.panelExtra.add(Box.createGlue());

            vc.panelDefault.setLayout(new BoxLayout(vc.panelDefault, BoxLayout.X_AXIS));
            vc.panelDefault.add(vc.rbDefault, 0);
            vc.panelDefault.add(vc.tfDefault, 1);
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private <T> void listToArray(ArrayList<T> list, T[] array) {
            for (int a = 0; a < list.size(); a++) {
                  array[a] = list.get(a);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private void startCreate() {
            for (int a = 0; a < vc.compsD.length; a++) {
                  for (int b = 0; b < vc.compsD[a].length; b++) {
                        if (a > 1) {
                              //EVERY ROW BUT THE FIRST ONE
                              vc.compsD[a][b].setVisible(false);
                        }
                  }
            }
            setNames();
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void setNames() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.lbOrigText[a] = "Column " + (a + 1);
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void JPUConfig() {
            dt.JF.add(dt.JPU, BorderLayout.NORTH);
            dt.JPU.setLayout(new BoxLayout(dt.JPU, BoxLayout.X_AXIS));
            dt.JPU.setBorder(new LineBorder(Color.WHITE, 1));
            dt.JPU.setBackground(Color.BLACK);
            dt.JPU.setPreferredSize(new Dimension(500, 46));
            dt.JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

            dt.JPU.add(dt.lb_Title);
            dt.lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            dt.lb_Title.setForeground(Color.WHITE);
            dt.lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            dt.lb_Title.setPreferredSize(new Dimension(200, 27));
            dt.lb_Title.setMaximumSize(new Dimension(200, 27));

            dt.JPU.add(dt.tf_Title);
            dt.tf_Title.setPreferredSize(new Dimension(dt.tf_Title.getPreferredSize().width, 27));
            dt.tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            MTF_Control3 mtf = new MTF_Control3(new Table_KControlException());
            mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
            mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
            mtf.addList(TablesInfo.getTableList(), MTF_Control3.EQUAL_MATCH);

            dt.tf_Title.addKeyListener(mtf);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            dt.JPU.add(Box.createHorizontalStrut(10));
      }

      private void JPCConfig() {
            dt.JF.add(dt.sc_JPC, BorderLayout.CENTER);
            dt.JPC.setBackground(LK_C.BK_PANELC);
            dt.sc_JPC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            dt.sc_JPC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            dt.sc_JPC.setBorder(new LineBorder(Color.WHITE, 1));

            beforeComponentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(dt.JPC);
            dt.JPC.setLayout(gl);
            /*
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"
             */
            JComponent[] comps = new JComponent[]{
                  vc.lb, vc.tf, vc.btn_m, vc.btn_p, vc.cbTypes, vc.ckNulls, vc.rbPK, vc.panelDefault, vc.panelExtra,
                  vc.btn_Dist, vc.btn_Dist2, vc.btn_ImageC, vc.btn_Tag, vc.btn_Clock};

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
            MLayout.setComponentsHeight(27);
            vc.compsD = MLayout.lineSequenceYClone(gl, vc.headers, comps, DT.maxColumns);
      }

      private void JPBConfig(String choice) {
            dt.JF.add(dt.JPB, BorderLayout.SOUTH);
            dt.JPB.setBackground(Color.BLACK);
            dt.JPB.setBorder(new LineBorder(Color.WHITE, 1));
            dt.JPB.setPreferredSize(new Dimension(500, 40));
            dt.JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
            dt.JPB.setLayout(new BoxLayout(dt.JPB, BoxLayout.X_AXIS));

            dt.JPB.add(dt.lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            dt.lb_Status.setBorder(new CompoundBorder(bb, be));
            dt.lb_Status.setForeground(Color.WHITE);
            dt.lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            dt.lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));

            dt.JPB.add(Box.createHorizontalStrut(6));
            dt.JPB.add(dt.btn_CU);
            dt.btn_CU.setText(choice);
            dt.btn_CU.setMinimumSize(new Dimension(60, 28));
            dt.btn_CU.addActionListener(new BTN_CU_AL(choice));
            dt.JPB.add(Box.createHorizontalStrut(10));
      }

      private void JPRConfig(String choice) {
            dt.JF.add(dt.JPR, BorderLayout.EAST);
            dt.JPR.setLayout(new BorderLayout());
            dt.JPR.add(dt.JPR_U, BorderLayout.CENTER);
            dt.JPR_U.setBackground(Color.BLACK);
            dt.JPR_U.setBorder(new LineBorder(Color.WHITE, 1));
            dt.JPR_U.setMinimumSize(new Dimension(200, 40));
            dt.JPR_U.setPreferredSize(new Dimension(200, 500));
            dt.JPR_U.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
            dt.JPR_U.setLayout(new BoxLayout(dt.JPR_U, BoxLayout.Y_AXIS));

            //ADDING LB TO JPR_U AND TO TDISP+++++++++++++++++++++
            for (int a = 0; a < dt.lb_TDisp.length; a++) {
                  if (choice.equals("CREATE")) {
                        dt.lb_TDisp[a] = new smallLB(dt.lb_Disp_textC[a]);
                  }

                  dt.lb_TDisp[a].setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
                  if (a % 2 == 0) {
                        dt.lb_TDisp[a].setFont(new Font("Dialog", Font.BOLD, 22));
                  }
                  dt.JPR_U.add(dt.lb_TDisp[a]);//HOLD ALL LBS AT THIS TIME
            }
            dt.JPR_U.add(Box.createVerticalGlue());
            dt.JPR_U.add(dt.lb_ClockLocation);
            dt.lb_ClockLocation.setForeground(Color.YELLOW.darker());
            //lb_ClockLocation.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));

            dt.JPR.add(dt.boxImageC, BorderLayout.SOUTH);
            dt.boxImageC.setMinimumSize(new Dimension(100, 27));
            dt.boxImageC.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            dt.boxImageC.setBackground(Color.BLACK);
            dt.boxImageC.setLayout(new BoxLayout(dt.boxImageC, BoxLayout.X_AXIS));
            dt.boxImageC.add(dt.tfClock);
            dt.tfClock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            dt.tfClock.setMinimumSize(new Dimension(80, 27));
            dt.tfClock.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            dt.boxImageC.add(dt.btn_ClockLocation);
            dt.btn_ClockLocation.setBorder(BorderFactory.createEmptyBorder());
            dt.btn_ClockLocation.setMinimumSize(new Dimension(20, 27));
            dt.btn_ClockLocation.setPreferredSize(new Dimension(20, 27));
            dt.btn_ClockLocation.setMaximumSize(new Dimension(20, 27));

            dt.lb_ClockLocation.setVisible(false);
            dt.boxImageC.setVisible(false);

            //ADDING LB TO ADISP
            ArrayList<JLabel> listLabelsA = new ArrayList<JLabel>();
            ArrayList<JLabel> listLabelsT = new ArrayList<JLabel>();
            for (int a = 0; a < dt.lb_TDisp.length; a++) {
                  if (a % 2 == 1) {
                        listLabelsA.add(dt.lb_TDisp[a]);
                  } else {
                        listLabelsT.add(dt.lb_TDisp[a]);
                  }
            }
            listToArray(listLabelsT, dt.lb_TDisp);
            listToArray(listLabelsA, dt.lb_ADisp);
            //DIST2 OFF
            dt.lb_TDisp[1].setForeground(Color.GRAY);
            dt.lb_ADisp[1].setForeground(Color.GRAY);
      }

      public void toolKitConfig() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JComboBox cb = vc.cbsExtra[a];
                  String selected = cb.getSelectedItem().toString();
                  if (!cb.isEnabled() && !vc.rbsPK[a].isSelected() && selected.equals("AUTO_INCREMENT")) {
                        cb.setToolTipText("Auto_increment column needs to be a Primary Key");
                  } else {
                        cb.setToolTipText("");
                  }
            }
      }

      public VC_R2(String choice) {
            dt.JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dt.JF.setLayout(new BorderLayout());
            dt.JF.addWindowListener(new VCListener());

            JPUConfig();
            JPCConfig();//GroupLayout setUp

            //+++++++++++++++++++++++++++++++++++++
            if (choice.equals("CREATE")) {
                  startCreate();
            } else if (choice.equals("UPDATE")) {
                  //startUpdate();
            }
            //+++++++++++++++++++++++++++++++++++++

            JPBConfig(choice);
            JPRConfig(choice);
            toolKitConfig();

            start();
      }

      private void start() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        dt.JF.setSize(1100, 500);
                        MComp.setFrameToCenterOfScreen(dt.JF);
                        dt.JF.setAlwaysOnTop(true);
                        dt.JF.setVisible(true);
                  }

            });
      }
}
