/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.createUpdate;

import MC.DT;
import MC.DTSQL;
import MC.LK_C;
import MC.MainInstances;
import SQLStores.TableDistC;
import SQLStores.TableKeysC;
import SQLStores.TableTypeC;
import SQLStores.TablesDists;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MImage;
import com.cofii2.methods.MList;
import com.cofii2.methods.MString;
import com.cofii2.myAClasses.MLayout;
import com.cofii2.stores.CC;
import com.cofii2.stores.DInt;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import views.create.Actions.Table_KControlException;
import views.create.listeners.BTN_CU_AL;
import views.create.listeners.VCListener;
import com.cofii2.textControl.TextControl;
import javax.swing.text.AbstractDocument;
import views.first.VF_R;
import views.update.listeners.BTNTableRename_AL;

/**
 *
 * @author C0FII
 */
public class VC_R2 {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps vc = MainInstances.getVC_R_Comps();

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private void startCreate() {
            for (int a = 0; a < vc.compsD.length; a++) {
                  for (int b = 0; b < vc.compsD[a].length; b++) {
                        if (a > 1) {
                              //EVERY ROW BUT THE FIRST AND SECOND
                              vc.compsD[a][b].setVisible(false);
                        }
                        if (a == 1) {
                              vc.btns_m[a].setVisible(true);
                              vc.btns_p[a].setVisible(true);
                        } else {
                              vc.btns_m[a].setVisible(false);
                              vc.btns_p[a].setVisible(false);
                        }
                  }
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (a > 1) {
                        vc.getBTNS_Dist()[a].setVisible(false);

                        vc.getBTNS_ImageC()[a].setVisible(false);
                        vc.getBTNS_Tag()[a].setVisible(false);
                        vc.getBTNS_Clock()[a].setVisible(false);
                  }
            }
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (a > 0) {
                        vc.getBTNS_Dist2()[a].setVisible(false);
                  }
            }
            dt.setPCDistHeigth(2);

            setNames();
      }

      private void startUpdate() {
            System.out.println(CC.CYAN + "\n### START UPDATE ###" + CC.RESET);
            vc.setColumnDisplayed(VF_R.getJT().getColumnCount());
            for (int r = 0; r < vc.compsD.length; r++) {
                  for (int c = 0; c < vc.compsD[r].length; c++) {
                        if (r > VF_R.getJT().getColumnCount() - 1) {
                              vc.compsD[r][c].setVisible(false);
                        }
                  }
            }
            for (int r = 0; r < DT.maxColumns; r++) {
                  if (r + 1 > VF_R.getJT().getColumnCount()) {
                        vc.getBTNS_Dist()[r].setVisible(false);
                        vc.getBTNS_Dist2()[r - 1].setVisible(false);
                        vc.getBTNS_ImageC()[r].setVisible(false);
                        vc.getBTNS_Tag()[r].setVisible(false);
                        vc.getBTNS_Clock()[r].setVisible(false);
                  }
            }
            dt.getBTNChange_Table().setEnabled(false);
            for (int a = 0; a < DT.maxColumns; a++) {
                  vc.getBTNSChange_TFS()[a].setEnabled(false);
                  vc.getBTNSChange_Types()[a].setEnabled(false);
                  vc.getBTNSChange_Nulls()[a].setEnabled(false);
                  vc.getBTNSChange_PK()[a].setEnabled(false);
                  vc.getBTNSChange_FK()[a].setEnabled(false);
                  vc.getBTNSChange_Defaults()[a].setEnabled(false);
                  vc.getBTNSChange_Extra()[a].setEnabled(false);
            }
      }

      private void setVariables() {
            //MList.printFor(DT.getList_Types());
            UpdateStore u = vc.getUpdateStore();
            dt.getTF_Title().setText(vc.updateStore.getTable().replaceAll("_", " "));
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  //COLUMNS NAME+++++++++++++++
                  vc.getTFS()[a].setText(u.getColumnNames()[a]);
                  //COLUMNS TYPES & WIDTHS+++++++++++++++
                  String type = u.getTypes()[a].string;
                  int width = u.getTypes()[a].index;
                  vc.getCBSTypes()[a].setSelectedItem(type);

                  int selected = vc.getCBSTypes()[a].getSelectedIndex();
                  boolean bool = DTSQL.mysqlTypesFixedSize[selected];
                  if (bool) {
                        vc.getTFSTypes()[a].setText(Integer.toString(width));
                  } else {
                  }
                  //COLUMNS NULL ALLOWED VALUE++++++++++
                  vc.getCKSNulls()[a].setSelected(DT.getList_Nulls().get(a));
            }
            //PRIMARY KEYS+++++++++++++++++++++++++++++
            for (int a = 0; a < TableKeysC.getPK().length; a++) {
                  vc.getHeaders()[4].setForeground(Color.YELLOW);

                  int index = TableKeysC.getPK()[a].index;
                  vc.getRBS_PK()[index - 1].setSelected(true);
            }
            //FOREIGN KEYS+++++++++++++++++++++++++++++UNTESTED
            for (int a = 0; a < TableKeysC.getFK().length; a++) {
                  vc.getHeaders()[5].setForeground(Color.BLUE);

                  int index = TableKeysC.getFK()[a].index;
                  vc.getRBS_FK()[index - 1].setSelected(true);
            }
            //DEFAULT+++++++++++++++++++++++++++++UNTESTED
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  String defaultValue = DT.getList_Defaults().get(a);
                  if (defaultValue != null) {
                        vc.getRBSDefaults()[a].setSelected(true);
                  }
            }
            //EXTRA++++++++++++++++++++++++++++++++++++
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  int index = TableTypeC.getEX().index;
                  if (index > 0) {
                        vc.getRBSExtra()[index - 1].setSelected(true);
                  }
            }
            //DIST++++++++++++++++++++++++++++++++++++++
            int[] dists = MString.getCustomDistTagSelected(TableDistC.getDist1());
            dt.getLBADist().setText(TableDistC.getDist1());
            for (int a = 0; a < dists.length; a++) {
                  if (a == 0) {
                        dt.getLBADist().setForeground(Color.CYAN);
                  }
                  vc.getBTNS_Dist()[dists[a] - 1].setSelected(true);
            }
            //DIST2++++++++++++++++++++++++++++++++++++++
            DInt[] dists2 = MString.getCustomDist2Selected(TableDistC.getDist2());
            dt.getLBADist2().setText(TableDistC.getDist2());
            for (int a = 0; a < dists2.length; a++) {
                  if (a == 0) {
                        dt.getLBADist2().setForeground(Color.CYAN);
                  }
                  vc.getBTNS_Dist2()[dists2[a].index1 - 1].setSelected(true);
            }
            //IMAGEC++++++++++++++++++++++++++++++++++++++
            String imageC = TableDistC.getImageC();
            dt.getLBAImageC().setText(imageC);
            String imageCPath = TableDistC.getImageCPath();

            if (!imageC.equals("NONE")) {
                  int col = Character.getNumericValue(imageC.charAt(1));
                  dt.getLBAImageC().setForeground(Color.CYAN);
                  vc.getBTNS_ImageC()[col - 1].setSelected(true);
                  if (!imageCPath.equals("NONE")) {
                        dt.getPImageC().setVisible(true); //SOMETHING SHOULD SET THIS INVISIVLE LATER ON
                        dt.getLBImageC().setVisible(true);
                        dt.getTFImageC().setText(imageCPath);
                  }
            }
            //TAG++++++++++++++++++++++++++++++++++++++
            int[] tags = MString.getCustomDistTagSelected(TableDistC.getTag());
            dt.getLBATag().setText(TableDistC.getTag());
            for (int a = 0; a < tags.length; a++) {
                  if (a == 0) {
                        dt.getLBATag().setForeground(Color.CYAN);
                  }
                  vc.getBTNS_Tag()[tags[a] - 1].setSelected(true);
            }
            //CLOCK++++++++++++++++++++++++++++++++++++++
            String clock = TableDistC.getClock();
            dt.getLBAClock().setText(clock);
            if (!clock.equals("NONE")) {
                  int col = Character.getNumericValue(clock.charAt(1));
                  vc.getBTNS_Clock()[col - 1].setSelected(true);
                  dt.getLBAClock().setForeground(Color.CYAN);
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void setNames() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.lbOrigText[a] = "Column " + (a + 1);
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      //GLASS
      private void glassConfig() {
            JPanel glass = (JPanel) dt.JF.getGlassPane();
            glass.setLayout(new BorderLayout());
            glass.add(dt.vlGlass, BorderLayout.CENTER);
            glass.setVisible(true);
      }

      //TABLE
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
            dt.lb_Title.setPreferredSize(new Dimension(160, 27));
            dt.lb_Title.setMaximumSize(new Dimension(160, 27));
            dt.lb_Title.setMinimumSize(new Dimension(160, 27));

            dt.JPU.add(dt.tf_Title);
            dt.tf_Title.setPreferredSize(new Dimension(dt.tf_Title.getPreferredSize().width, 27));
            dt.tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (vc.getUpdateStore() != null) {
                  dt.JPU.add(dt.btnChange_Table);
                  dt.btnChange_Table.setToolTipText("Rename Table");
                  dt.btnChange_Table.setMaximumSize(new Dimension(100, 27));
                  dt.btnChange_Table.addActionListener(new BTNTableRename_AL());
            } else {

            }

            TextControl mtf = new TextControl(new Table_KControlException(), TextControl.KEY_RELEASED);
            mtf.addList(DTSQL.getBandWE_mysql(), TextControl.EQUAL_MATCH);
            mtf.addList(DTSQL.getBandWC_mysql(), TextControl.CONTAIN_MATCH);
            mtf.addList(TablesDists.getTableList(), TextControl.EQUAL_MATCH);

            dt.tf_Title.addKeyListener(mtf);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            dt.JPU.add(Box.createHorizontalStrut(10));
      }

      //CENTER COMPONENTS
      private void JPCConfig() {
            dt.JF.add(dt.JSP, BorderLayout.CENTER);
            dt.JSP.setOneTouchExpandable(true);
            dt.JSP.setLeftComponent(dt.sc_JPC);
            dt.JPC.setBackground(LK_C.BK_PANELC);
            dt.sc_JPC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            dt.sc_JPC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            //dt.sc_JPC.setBorder(new LineBorder(Color.WHITE, 1));

            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(dt.JPC);
            dt.JPC.setLayout(gl);
            MLayout.setComponentsHeight(27);
            //vc.compsD = MLayout.lineSequenceYClone(gl, vc.headers, comps, DT.maxColumns);
            MLayout.lineSequence(gl, vc.headers, vc.compsD);
      }

      private void JPCDConfig() {
            dt.JSP.setRightComponent(dt.sc_JPCD);//SPLIT PANE
            //dt.JPCD.setBackground(LK_C.BK_PANELC);//MAIN PANEL
            dt.JPCD.setBackground(Color.BLACK);
            dt.sc_JPCD.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            dt.sc_JPCD.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            dt.setPCDistHeigth(VF_R.getJT().getColumnCount());
            dt.JPCD.setLayout(new BoxLayout(dt.JPCD, BoxLayout.Y_AXIS));
            dt.JPCD.add(dt.JPCD_U, 0);
            dt.JPCD.add(dt.JPCD_D, 1);

            JPCD_UConfig();
            JPCD_DConfig();

      }

      private void JPCD_UConfig() {
            dt.JPCD_U.setBackground(Color.BLACK);
            dt.JPCD_U.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            dt.JPCD_U.setLayout(new BoxLayout(dt.JPCD_U, BoxLayout.X_AXIS));

            dt.JPCD_U.add(dt.JPCD_UDist, 0);
            dt.JPCD_U.add(dt.JPCD_UDist2, 1);
            dt.JPCD_U.add(dt.JPCD_UImageC, 2);
            dt.JPCD_U.add(dt.JPCD_UTag, 3);
            dt.JPCD_U.add(dt.JPCD_UClock, 4);

            dt.JPCD_UDist.setAlignmentY(JComponent.TOP_ALIGNMENT);
            dt.JPCD_UDist2.setAlignmentY(JComponent.TOP_ALIGNMENT);
            dt.JPCD_UImageC.setAlignmentY(JComponent.TOP_ALIGNMENT);
            dt.JPCD_UTag.setAlignmentY(JComponent.TOP_ALIGNMENT);
            dt.JPCD_UClock.setAlignmentY(JComponent.TOP_ALIGNMENT);

            dt.JPCD_UDist.setBackground(Color.BLACK);
            dt.JPCD_UDist2.setBackground(Color.BLACK);
            dt.JPCD_UImageC.setBackground(Color.BLACK);
            dt.JPCD_UTag.setBackground(Color.BLACK);
            dt.JPCD_UClock.setBackground(Color.BLACK);

            dt.JPCD_UDist.setLayout(new BoxLayout(dt.JPCD_UDist, BoxLayout.Y_AXIS));
            dt.JPCD_UDist2.setLayout(new BoxLayout(dt.JPCD_UDist2, BoxLayout.Y_AXIS));
            dt.JPCD_UImageC.setLayout(new BoxLayout(dt.JPCD_UImageC, BoxLayout.Y_AXIS));
            dt.JPCD_UTag.setLayout(new BoxLayout(dt.JPCD_UTag, BoxLayout.Y_AXIS));
            dt.JPCD_UClock.setLayout(new BoxLayout(dt.JPCD_UClock, BoxLayout.Y_AXIS));

            dt.JPCD_UDist.add(Box.createVerticalStrut(12), 0);
            dt.JPCD_UDist2.add(Box.createVerticalStrut(12), 0);
            dt.JPCD_UImageC.add(Box.createVerticalStrut(12), 0);
            dt.JPCD_UTag.add(Box.createVerticalStrut(12), 0);
            dt.JPCD_UClock.add(Box.createVerticalStrut(12), 0);
            dt.JPCD_UDist.add(vc.headersDists[0], 1);
            dt.JPCD_UDist2.add(vc.headersDists[1], 1);
            dt.JPCD_UImageC.add(vc.headersDists[2], 1);
            dt.JPCD_UTag.add(vc.headersDists[3], 1);
            dt.JPCD_UClock.add(vc.headersDists[4], 1);
            vc.headersDists[0].setAlignmentX(JComponent.CENTER_ALIGNMENT);
            vc.headersDists[1].setAlignmentX(JComponent.CENTER_ALIGNMENT);
            vc.headersDists[2].setAlignmentX(JComponent.CENTER_ALIGNMENT);
            vc.headersDists[3].setAlignmentX(JComponent.CENTER_ALIGNMENT);
            vc.headersDists[4].setAlignmentX(JComponent.CENTER_ALIGNMENT);
            dt.JPCD_UDist.add(Box.createVerticalStrut(12), 2);
            dt.JPCD_UDist2.add(Box.createVerticalStrut(12 + 16), 2);//DIST2
            dt.JPCD_UImageC.add(Box.createVerticalStrut(12), 2);
            dt.JPCD_UTag.add(Box.createVerticalStrut(12), 2);
            dt.JPCD_UClock.add(Box.createVerticalStrut(12), 2);

            int c = 3;//DISTS 
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.JPCD_UDist.add(vc.btns_Dist[a], c++);
                  vc.btns_Dist[a].setMinimumSize(new Dimension(40, 27));
                  vc.btns_Dist[a].setMaximumSize(new Dimension(40, 27));
                  vc.btns_Dist[a].setPreferredSize(new Dimension(40, 27));

                  vc.btns_Dist[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);

                  dt.JPCD_UDist.add(Box.createVerticalStrut(6), c++);
            }
            c = 3;//DISTS 2
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  dt.JPCD_UDist2.add(vc.btns_Dist2[a], c++);
                  vc.btns_Dist2[a].setMinimumSize(new Dimension(40, 27));
                  vc.btns_Dist2[a].setMaximumSize(new Dimension(40, 27));
                  vc.btns_Dist2[a].setPreferredSize(new Dimension(40, 27));

                  vc.btns_Dist2[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);

                  dt.JPCD_UDist2.add(Box.createVerticalStrut(6), c++);
            }
            c = 3;//IMAGEC
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.JPCD_UImageC.add(vc.btns_ImageC[a], c++);
                  vc.btns_ImageC[a].setMinimumSize(new Dimension(40, 27));
                  vc.btns_ImageC[a].setMaximumSize(new Dimension(40, 27));
                  vc.btns_ImageC[a].setPreferredSize(new Dimension(40, 27));

                  vc.btns_ImageC[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);

                  dt.JPCD_UImageC.add(Box.createVerticalStrut(6), c++);
            }
            c = 3;//TAG
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.JPCD_UTag.add(vc.btns_Tag[a], c++);
                  vc.btns_Tag[a].setMinimumSize(new Dimension(40, 27));
                  vc.btns_Tag[a].setMaximumSize(new Dimension(40, 27));
                  vc.btns_Tag[a].setPreferredSize(new Dimension(40, 27));

                  vc.btns_Tag[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);

                  dt.JPCD_UTag.add(Box.createVerticalStrut(6), c++);
            }
            c = 3;//CLOCK
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.JPCD_UClock.add(vc.btns_Clock[a], c++);
                  vc.btns_Clock[a].setMinimumSize(new Dimension(40, 27));
                  vc.btns_Clock[a].setMaximumSize(new Dimension(40, 27));
                  vc.btns_Clock[a].setPreferredSize(new Dimension(40, 27));

                  vc.btns_Clock[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);

                  dt.JPCD_UClock.add(Box.createVerticalStrut(6), c++);
            }
      }

      private void JPCD_DConfig() {
            dt.JPCD_D.setBackground(Color.BLACK);
            dt.JPCD_D.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            dt.JPCD_D.setLayout(new BoxLayout(dt.JPCD_D, BoxLayout.X_AXIS));
            dt.JPCD_D.setMinimumSize(new Dimension(300, 51));
            dt.JPCD_D.setMaximumSize(new Dimension(300, 51));
            dt.JPCD_D.setPreferredSize(new Dimension(300, 51));

            dt.JPCD_D.add(Box.createHorizontalStrut(10), 0); //GETX
            dt.JPCD_D.add(vc.getBTNChange_DistDist2(), 1); //100
            dt.JPCD_D.add(Box.createHorizontalStrut(20), 2);
            dt.JPCD_D.add(vc.getBTNChange_ImageC(), 3);
            dt.JPCD_D.add(Box.createHorizontalStrut(20), 4);
            dt.JPCD_D.add(vc.getBTNChange_Tag(), 5);
            dt.JPCD_D.add(Box.createHorizontalStrut(20), 6);
            dt.JPCD_D.add(vc.getBTNChange_Clock(), 7);

            vc.getBTNChange_DistDist2().setMinimumSize(new Dimension(100, 27));
            vc.getBTNChange_DistDist2().setMaximumSize(new Dimension(100, 27));
            vc.getBTNChange_DistDist2().setPreferredSize(new Dimension(100, 27));
            vc.getBTNChange_ImageC().setMinimumSize(new Dimension(40, 27));
            vc.getBTNChange_ImageC().setMaximumSize(new Dimension(40, 27));
            vc.getBTNChange_ImageC().setPreferredSize(new Dimension(40, 27));
            vc.getBTNChange_Tag().setMinimumSize(new Dimension(40, 27));
            vc.getBTNChange_Tag().setMaximumSize(new Dimension(40, 27));
            vc.getBTNChange_Tag().setPreferredSize(new Dimension(40, 27));
            vc.getBTNChange_Clock().setMinimumSize(new Dimension(40, 27));
            vc.getBTNChange_Clock().setMaximumSize(new Dimension(40, 27));
            vc.getBTNChange_Clock().setPreferredSize(new Dimension(40, 27));
      }

      private void JPBConfig() {
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
            dt.btn_CU.setText("CREATE");
            dt.btn_CU.setMinimumSize(new Dimension(60, 28));
            dt.btn_CU.addActionListener(new BTN_CU_AL());
            dt.JPB.add(Box.createHorizontalStrut(10));
      }

      private void JPRConfig() {
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
            setLBS_PR_T(dt.lbTDist);
            setLBS_PR_A(dt.lbADist);
            setLBS_PR_T(dt.lbTDist2);
            setLBS_PR_A(dt.lbADist2);
            setLBS_PR_T(dt.lbTImageC);
            setLBS_PR_A(dt.lbAImageC);
            setLBS_PR_T(dt.lbTTag);
            setLBS_PR_A(dt.lbATag);
            setLBS_PR_T(dt.lbTClock);
            setLBS_PR_A(dt.lbAClock);

            dt.JPR_U.add(dt.lbTDist, 0);
            dt.JPR_U.add(dt.lbADist, 1);
            dt.JPR_U.add(dt.lbTDist2, 2);
            dt.JPR_U.add(dt.lbADist2, 3);
            dt.JPR_U.add(dt.lbTImageC, 4);
            dt.JPR_U.add(dt.lbAImageC, 5);
            dt.JPR_U.add(dt.lbTTag, 6);
            dt.JPR_U.add(dt.lbATag, 7);
            dt.JPR_U.add(dt.lbTClock, 8);
            dt.JPR_U.add(dt.lbAClock, 9);

            dt.JPR_U.add(Box.createVerticalGlue());
            dt.JPR_U.add(dt.lbImageC);
            dt.lbImageC.setForeground(Color.YELLOW.darker());
            //lb_ClockLocation.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));

            dt.JPR.add(dt.JPImageC, BorderLayout.SOUTH);
            dt.JPImageC.setMinimumSize(new Dimension(100, 27));
            dt.JPImageC.setMaximumSize(new Dimension(100, 27));
            dt.JPImageC.setBackground(Color.BLACK);
            dt.JPImageC.setLayout(new BoxLayout(dt.JPImageC, BoxLayout.X_AXIS));
            dt.JPImageC.add(dt.tfImageC);
            dt.tfImageC.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            dt.tfImageC.setBackground(Color.BLACK);
            dt.tfImageC.setMinimumSize(new Dimension(80, 27));
            dt.tfImageC.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            dt.JPImageC.add(dt.btn_ImageCLocation);

            MImage.setOption(MImage.DRAW_IMAGE);
            Icon icon = MImage.resizeIcon(new ImageIcon("C:\\C0F\\Image\\Z Icons\\Not Mine\\folder-blue-512.png"), 20, 20);

            dt.btn_ImageCLocation.setIcon(icon);
            dt.btn_ImageCLocation.setBorder(BorderFactory.createEmptyBorder());
            dt.btn_ImageCLocation.setMinimumSize(new Dimension(40, 27));
            dt.btn_ImageCLocation.setPreferredSize(new Dimension(40, 27));
            dt.btn_ImageCLocation.setMaximumSize(new Dimension(40, 27));

            dt.lbImageC.setVisible(false);
            dt.JPImageC.setVisible(false);
      }

      private void clockImageConfig() {

            //dt.btn_ImageCLocation.setIcon(defaultIcon);
            dt.btn_ImageCLocation.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        //dt.FC.setCurrentDirectory(dir);
                        dt.FC.setDialogTitle("ImageC Folder Location");
                        dt.FC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        dt.FC.setAcceptAllFileFilterUsed(false);

                        int res = dt.FC.showOpenDialog(dt.JF);
                        if (res == JFileChooser.APPROVE_OPTION) {
                              File file = dt.FC.getSelectedFile();
                              String path = file.getPath();

                              dt.tfImageC.setText(path);
                        }

                  }

            });

      }

      private void setLBS_PR_T(JLabel lb) {
            lb.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            lb.setFont(new Font("Dialog", Font.BOLD, 22));
      }

      private void setLBS_PR_A(JLabel lb) {
            lb.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
      }

      public void toolKitConfig() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (!vc.rbsPK[a].isEnabled() && !vc.rbsPK[a].isSelected()) {
                        vc.rbsPK[a].setToolTipText("Auto_increment column needs to be a Primary Key");
                  } else {
                        vc.rbsPK[a].setToolTipText("");
                  }
            }
      }

      public VC_R2() {
            dt.JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dt.JF.setLayout(new BorderLayout());
            dt.JF.addWindowListener(new VCListener());

            glassConfig();
            JPUConfig();
            JPCConfig();//GroupLayout setUp
            JPCDConfig();
            //+++++++++++++++++++++++++++++++++++++
            startCreate();
            setNames();
            vc.setListeners();
            vc.enabledControl();
            //+++++++++++++++++++++++++++++++++++++
            JPBConfig();
            JPRConfig();
            clockImageConfig();
            //toolKitConfig();

            //MComp.isNull(MainInstances.getVC_R_Comps(), true);
            start();
      }

      public VC_R2(String update) {
            //+++++++++++++++++++++++++++++++++++
            dt.JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dt.JF.setLayout(new BorderLayout());
            dt.JF.addWindowListener(new VCListener());

            glassConfig();
            JPUConfig();
            JPCConfig();//GroupLayout setUp
            JPCDConfig();
            //+++++++++++++++++++++++++++++++++++++
            startUpdate();
            setVariables();
            setNames();
            vc.setListeners();
            vc.enabledControl();
            //+++++++++++++++++++++++++++++++++++++

            JPBConfig();
            JPRConfig();
            clockImageConfig();
            
            start();
      }

      private void start() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        dt.JF.setSize(1100, 500);
                        MComp.setFrameToCenterOfScreen(dt.JF);

                        dt.JSP.setSize(1100, 500);
                        dt.JSP.setDividerLocation(0.52);
                        dt.JSP.revalidate();

                        dt.JF.setAlwaysOnTop(true);
                        dt.JF.setVisible(true);
                  }

            });
      }
}
