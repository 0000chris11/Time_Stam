/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.delete;

import MC.DT;
import MC.DTSQL;
import MC.MainInstances;
import MC.Status;
import SQL.DefaultConnection;
import SQL.SQLQuerys;
import SQLActions.SelectKeys;
import SQLActions.SelectTables;
import SQLStores.TableDistC;
import SQLStores.TablesDists;
import com.cofii2.components.swing.ComboBoxE;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MList;
import com.cofii2.myInterfaces.IUpdates;
import com.cofii2.mysql.MSQL;
import com.cofii2.mysql.MSQL1;
import com.cofii2.stores.CC;
import edu.emory.mathcs.backport.java.util.Collections;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import views.first.MENU;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class VD {

      private JFrame JF = new JFrame();
      private JComboBox cb;
      private JButton btnDelete = new JButton("Delete");

      private MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      private boolean tableDeleted = false;
      private boolean tableRemoveFromMT = false;

      public VD() {
            System.out.println(CC.CYAN + "\n#### VD STARS ####" + CC.RESET);
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            JF.setResizable(false);
            JF.addWindowListener(new WindowAdapter() {
                  @Override
                  public void windowClosed​(WindowEvent e) {
                        MainInstances.setVD(null);
                  }
            });
            JF.getContentPane().setBackground(Color.BLACK);
            JF.getContentPane().setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));

            ArrayList<String> list = TablesDists.getTableList();
            Collections.sort(list);
            String[] tableList = MList.getListToArray(String.class, list);

            cb = new ComboBoxE(tableList);
            JF.getContentPane().add(cb, 0);

            cb.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            JF.getContentPane().add(btnDelete, 1);
            btnDelete.setPreferredSize(new Dimension(100, 27));
            btnDelete.setMaximumSize(new Dimension(100, 27));
            btnDelete.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JTextField tf = (JTextField) cb.getEditor().getEditorComponent();
                        String text = tf.getText();

                        for (int a = 0; a < tableList.length; a++) {
                              if (text.equals(tableList[a])) {
                                    //ms.deleteTable_TEST(text);
                                    ms.deleteTable(text.replaceAll(" ", "_"), new IUpdates() {
                                          @Override
                                          public void executeResultRowN() {
                                                
                                          }

                                          @Override
                                          public void executeResult0() {
                                                tableDeleted = true;

                                          }

                                          @Override
                                          public void exception(SQLException ex) {
                                                ex.printStackTrace();
                                          }

                                    });
                                    if (tableDeleted) {
                                          //System.out.println("TEST TABLE DELETED");
                                          ms.deleteRow(DTSQL.mainTable, DTSQL.mainTableColumns[1], text, new IUpdates() {
                                                @Override
                                                public void executeResultRowN() {
                                                      Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN,
                                                        "Table " + text + " has been deleted", 4000);
                                                      tableRemoveFromMT = true;
                                                }

                                                @Override
                                                public void executeResult0() {
                                                      Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
                                                              "Table " + text + " fail to be deleted", 5000);
                                                }

                                                @Override
                                                public void exception(SQLException ex) {
                                                      ex.printStackTrace();
                                                }

                                          });
                                          if (tableRemoveFromMT) {
                                                //System.out.println("TEST TABLE REMOVED FROM MAIN TABLES");
                                                MSQL1 ms1 = new MSQL1(new DefaultConnection());
                                                ms1.select(SQLQuerys.SELECT_KEYS, new SelectKeys());

                                                ms.selectData(DTSQL.mainTable, new SelectTables());

                                                MENU.addItemToMenus();
                                                MENU.setColorToDItem(TableDistC.getTable(), DT.getDTable());
                                                if(text.equalsIgnoreCase(TableDistC.getTable())){
                                                      VF_R.tableDeletedState();
                                                }
                                                
                                                cb.removeItem(text);
                                          }else{
                                                Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                                                        "Table " + text + " fail to be removed from table_names", 5000);
                                          }
                                    }else{
                                          System.out.println("TEST TABLE NOT DELETED");
                                    }
                              }
                        }
                  }

            });

            start();
      }

      private void start() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        JF.pack();
                        MComp.setFrameToCenterOfScreen(JF);
                        JF.setVisible(true);
                  }

            });
      }
}
