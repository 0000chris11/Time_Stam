/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import MC.DTSQL;
import com.cofii.myClasses.MLayout;
import com.cofii.myClasses.MSQL;
import com.cofii.myInterfaces.IActions;
import com.cofii.myMethods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import views.Login.listeners.TFLST_FL;

/**
 *
 * @author C0FII
 */
public class VL extends VL_DataCom {

      MSQL ms = new MSQL(DTSQL.initURLConnection, DTSQL.rootUser, DTSQL.passw);

      private void querys() {
            System.out.println("VL's Querys\n");
            ms.selectUsers(new IActions() {
                  @Override
                  public void beforeQuery() {

                  }

                  @Override
                  public void setData(ResultSet rs) throws SQLException {
                        String data = null;
                        for (int a = 0; a < DTSQL.bandDB.length; a++) {
                              data = rs.getString(1);
                              if (data.equalsIgnoreCase(DTSQL.bandDB[a])) {
                                    data = null;
                                    break;
                              }
                        }
                        if (data != null) {
                              cbUser.addItem(data);
                        }
                  }

                  @Override
                  public void afterQuery(String sql, boolean bln) {
                        System.out.println("sql: " + sql);
                        if(bln){
                              System.out.println("\tTRUE");
                        }else{
                              System.out.println("\tFALSE");
                        }
                  }

                  @Override
                  public void exception(SQLException sqle, String string) {
                        sqle.printStackTrace();
                  }

            });
      }

      private void setNames() {
            cbUser.setName("tfUser");
            tfPass.setName("tfPass");
            cbDB.setName("tfDB");
      }

      public VL(String option) {
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            JF.getContentPane().setLayout(new BorderLayout());
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
            MLayout.singlelineSequence(gl, components, 28);
            //+++++++++++++++++++++++++++++++++++++++++
            JF.getContentPane().add(JPS, BorderLayout.SOUTH);
            JPS.setBackground(Color.BLACK);
            JPS.setBorder(new LineBorder(Color.WHITE, 2));
            JPS.setMaximumSize(new Dimension(60, Short.MAX_VALUE));

            //JPS.setLayout(new BoxLayout(JPS, BoxLayout.X_AXIS));
            JPS.setLayout(new FlowLayout());
            JPS.add(btn_login);
            btn_login.setText(option);
            btn_login.setPreferredSize(new Dimension(100, 30));
            //+++++++++++++++++++++++++++++++++++++++++
            querys();
            //+++++++++++++++++++++++++++++++++++++++++
            setNames();
            star();
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
      /*
      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        new VL("Login");
                        JF.setLocationRelativeTo(null);

                        JF.setSize(400, 500);
                        JF.setVisible(true);
                  }

            });
      }
       */
}
