/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable;

import MC.DTSQL;
import com.cofii2.components.swing.Table;
import com.cofii2.mysql.MSQL;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import smallComponenets.smallLB;

/**
 *
 * @author C0FII
 */
public class VMT_DataCom {
      
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      JFrame JF = new JFrame();

      JPanel PU = new JPanel();
      JPanel PD = new JPanel();
      
      CardLayout cd = new CardLayout();
      
      JLabel lbTypes = new smallLB("No Table Selected on Dists", SwingConstants.CENTER);

      JToggleButton btnDists = new JToggleButton("Dists");
      JToggleButton btnTypes = new JToggleButton("Types");

      JTable JTTypes = new Table();
      JScrollPane sc_JTTypes = new JScrollPane(JTTypes);

      JTable JTDists = new Table();
      JScrollPane sc_JTDists = new JScrollPane(JTDists);
      //NON-EDITABLE ++++++++++++
      DefaultTableModel dtmDists = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                  return false;
            }
      };
      DefaultTableModel dtmTypes = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                  return false;
            }
      };
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public JPanel getPU(){
            return PU;
      }
      
      public CardLayout getCD(){
            return cd;
      }
      
      public JTable getJTDists() {
            return JTDists;
      }

      public JTable getJTTypes() {
            return JTTypes;
      }

      public JScrollPane getSC_JTDists() {
            return sc_JTDists;
      }

      public JScrollPane getSC_JTTypes() {
            return sc_JTTypes;
      }
      
      public DefaultTableModel getDTMDists(){
            return dtmDists;
      }
      
      public DefaultTableModel getDTMTypes(){
            return dtmTypes;
      }
      
      public JLabel getLBTypes(){
            return lbTypes;
      }
      
      public JToggleButton getBTNDists(){
            return btnDists;
      }
      public JToggleButton getBTNTypes(){
            return btnTypes;
      }
}
