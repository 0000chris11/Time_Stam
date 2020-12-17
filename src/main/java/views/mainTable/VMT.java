/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable;

import MC.DTSQL;
import SQL.DefaultConnection;
import SQL.DefaultTables;
import com.cofii2.components.swing.Table;
import com.cofii2.custom.LKCustom;
import com.cofii2.myClasses.MSQL;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.myMethods.MComp;
import com.cofii2.myMethods.MList;
import com.cofii2.mysql.MSQL2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import views.mainTable.listeners.VMTListener;

/**
 *
 * @author C0FII
 */
public class VMT {

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      private JFrame JF = new JFrame();
      static JTable JMT = new Table();
      static JScrollPane sc_JTM = new JScrollPane(JMT);
      //NON-EDITABLE ++++++++++++
      private DefaultTableModel tm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                  return false;
            }
      };

      public VMT() {
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());
            JF.getContentPane().add(sc_JTM, BorderLayout.CENTER);
            JF.addWindowListener(new VMTListener());

            MSQL2 ms2 = new MSQL2(new DefaultTables(), new DefaultConnection());
            ms2.addAllColumns(MList.getArrayToArrayList(DTSQL.listDS));
            ms2.selectTablesJoin(DTSQL.match1, DTSQL.match2, new IActions() {
                  @Override
                  public void beforeQuery() {
                        JMT.setModel(tm);
                        for (String x : DTSQL.mainTableColumns) {
                              tm.addColumn(x);
                        }
                        tm.addColumn("PKC");
                  }

                  @Override
                  public void setData(ResultSet rs, int row) throws SQLException {
                        Object[] rows = new Object[]{
                              rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                              rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};

                        tm.addRow(rows);
                  }

                  @Override
                  public void afterQuery(String query, boolean rsValue) {

                  }

                  @Override
                  public void exception(SQLException ex, String query) {

                  }

            });

            try {
                  ms.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(VMT.class.getName()).log(Level.SEVERE, null, ex);
            }

            MComp.setTableRenderer(JMT);
            MComp.setTableDefaultColumnWidth(JMT);

            start();
      }

      private void start() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        JF.setSize(LKCustom.MAINTABLE_FRAME_SIZE);
                        MComp.setFrameToCenterOfScreen(JF);
                        sc_JTM.setPreferredSize(new Dimension());
                        JF.setVisible(true);

                        System.out.println(JMT.getColumnCount());
                        System.out.println(JMT.getRowCount());
                  }

            });
      }
      //+++++++++++++++++++++++++++++++++++

      public JTable getJMT() {
            return JMT;
      }
}
