/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable;

import MC.DTSQL;
import com.cofii.myClasses.MSQL;
import com.cofii.myInterfaces.IActions;
import com.cofii.myMethods.MComp;
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

/**
 *
 * @author C0FII
 */
public class VMT {
      
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      
      private JFrame JF = new JFrame();
      static JTable JTM = new JTable();
      static JScrollPane sc_JTM = new JScrollPane(JTM);
      private DefaultTableModel tm = new DefaultTableModel();
      
      public VMT(){
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());
            JF.getContentPane().add(sc_JTM, BorderLayout.CENTER);
            
            ms.selectData(DTSQL.mainTable, new IActions(){
                  
                  
                  
                  @Override
                  public void beforeQuery() {
                        JTM.setModel(tm);
                        for(String x : DTSQL.mainTableColumns){
                              tm.addColumn(x);
                        }
                  }

                  @Override
                  public void setData(ResultSet rs, int i) throws SQLException {
                        Object[] row = new Object[]{
                              rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                              rs.getString(5), rs.getString(6), rs.getString(7)};
                        
                        tm.addRow(row);
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
                  Logger.getLogger(VMT.class.getName()).log(Level.SEVERE, null, ex);
            }
            start();
      }
      private void start(){
            SwingUtilities.invokeLater(new Runnable(){
                  @Override
                  public void run() {
                        JF.setSize(600, 500);
                        MComp.setFrameToCenterOfScreen(JF);
                        sc_JTM.setPreferredSize(new Dimension());
                        JF.setVisible(true);
                        
                        System.out.println(JTM.getColumnCount());
                        System.out.println(JTM.getRowCount());
                  }
                  
            });
      }
     
}
