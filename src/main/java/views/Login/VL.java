/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import MC.DTSQL;
import com.cofii2.myAClasses.MLayout;
import com.cofii2.mysql.MSQL;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MOthers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import static views.Login.VL_DataCom.setDefaultUser;
import views.Login.listeners.BTNLogin_AL;
import views.first.VF_R;
import views.first.listeners.KEDispatcher;

/**
 *
 * @author C0FII
 */
public class VL extends VL_DataCom {

      MSQL ms = new MSQL(DTSQL.initURLConnection, DTSQL.rootUser, DTSQL.rootPassw);
      private boolean defaultUser = false;

      private void defaultUser() {
            ms.selectRowFromTable(DTSQL.defaultUserTable, 1, new IActions() {
                  @Override
                  public void beforeQuery() {

                  }

                  @Override
                  public void setData(ResultSet rs, int row) throws SQLException {
                        DTSQL.setUser(rs.getString(1));
                        DTSQL.setPassw(rs.getString(2));
                        DTSQL.setDatabase(rs.getString(3));
                  }

                  @Override
                  public void afterQuery(String string, boolean bln) {
                        if (bln) {
                              setDefaultUser(true);
                        } else {
                              setDefaultUser(false);
                        }
                  }

                  @Override
                  public void exception(SQLException sqle, String string) {
                        sqle.printStackTrace();
                  }

            });
      }

      private void querys() {
            System.out.println("VL's Querys\n");

            ms.selectUsers(new IActions() {
                  @Override
                  public void beforeQuery() {

                  }

                  @Override
                  public void setData(ResultSet rs, int row) throws SQLException {
                        String data = rs.getString(1);
                        if (!MOthers.getEqualMatchFromStringToArray(data, DTSQL.bandUsers)) {
                              cbUser.addItem(data);
                              userData.add(data);
                        }
                        //SELECT * FROM users WHERE users_name= "0000chris11" && users_password= "ccfmps00112"
                  }

                  @Override
                  public void afterQuery(String sql, boolean bln) {
                        /*
                        System.out.println("sql: " + sql);
                        if(bln){
                              System.out.println("\tTRUE");
                        }else{
                              System.out.println("\tFALSE");
                        }
                         */
                  }

                  @Override
                  public void exception(SQLException sqle, String string) {
                        sqle.printStackTrace();
                  }

            });
            ms.selectDataBases(new IActions() {
                  @Override
                  public void beforeQuery() {

                  }

                  @Override
                  public void setData(ResultSet rs, int row) throws SQLException {
                        String data = rs.getString(1);
                        if (!MOthers.getEqualMatchFromStringToArray(data, DTSQL.bandDB)) {
                              cbDB.addItem(data);
                              dbData.add(data);
                        }
                  }

                  @Override
                  public void afterQuery(String string, boolean bln) {

                  }

                  @Override
                  public void exception(SQLException sqle, String string) {

                  }

            });

            try {
                  ms.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(VL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

      private void keyDispatch() {
            boolean check = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                    new KEDispatcher(check));
      }

      private void setNames() {
            cbUser.setName("tfUser");
            tfPass.setName("tfPass");
            cbDB.setName("tfDB");
      }

      public VL(String option) {//OPTION MANAGE NEEDED
            if (option.equals("Login")) {
                  defaultUser();
            }
            if (!getDefaultUser() || option.equals("Change")) {
                  System.out.println("LOGIN +++++ STARS");
                  //++++++++++++++++++++++++++++++++++++++++
                  JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                  JF.setAlwaysOnTop(true);
                  JF.getContentPane().setLayout(new BorderLayout());
                  JF.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                              if (VF_R.getJF() == null) {
                                    System.out.println("X DISPOSE X");
                                    System.exit(0);
                              } else {
                                    System.out.println("XXXX TERMINTATE XXXX");
                                    JF.dispose();
                              }
                        }
                  });
                  //++++++++++++++++++++++++++++++
                  JComponent[] components = new JComponent[6];
                  components[0] = lbUser;
                  components[1] = cbUser;
                  components[2] = lbPass;
                  components[3] = tfPass;
                  components[4] = lbDB;
                  components[5] = cbDB;

                  //+++++++++++++++++++++++++++
                  JF.getContentPane().add(JPC, BorderLayout.CENTER);
                  JPC.setBackground(Color.BLACK);
                  JPC.setBorder(new LineBorder(Color.WHITE, 2));
                  JPC.setMinimumSize(new Dimension(401, 200));
                  JPC.setPreferredSize(new Dimension(401, 200));
                  JPC.setMaximumSize(new Dimension(401, Short.MAX_VALUE));

                  GroupLayout gl = new GroupLayout(JPC);
                  JPC.setLayout(gl);
                  MLayout.setComponentsHeight(28);
                  MLayout.singlelineSequence(gl, components);
                  //+++++++++++++++++++++++++++++++++++++++++
                  JF.getContentPane().add(JPS, BorderLayout.SOUTH);
                  JPS.setBackground(Color.BLACK);
                  JPS.setBorder(new LineBorder(Color.WHITE, 2));
                  JPS.setMaximumSize(new Dimension(60, Short.MAX_VALUE));

                  //JPS.setLayout(new BoxLayout(JPS, BoxLayout.X_AXIS));
                  JPS.setLayout(new BoxLayout(JPS, BoxLayout.X_AXIS));
                  JPS.add(Box.createHorizontalStrut(3));
                  JPS.add(btn_login);
                  btn_login.setText(option);
                  btn_login.setPreferredSize(new Dimension(100, 30));
                  btn_login.addActionListener(new BTNLogin_AL());
                  JPS.add(Box.createHorizontalGlue());
                  JPS.add(ckb_Default);
                  ckb_Default.setForeground(Color.WHITE);

                  //+++++++++++++++++++++++++++++++++++++++++
                  querys();
                  keyDispatch();
                  //+++++++++++++++++++++++++++++++++++++++++
                  setNames();
                  star();
            } else {
                  new VF_R();
            }
      }

      private void star() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        JF.setSize(400, 400);
                        MComp.setFrameToCenterOfScreen(JF);
                        JF.setVisible(true);
                  }

            });
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        new VL("Login");
                  }

            });
      }

}
