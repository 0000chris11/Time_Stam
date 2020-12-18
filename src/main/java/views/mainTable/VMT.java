/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable;

import MC.DTSQL;
import MC.TablesInfo;
import com.cofii2.components.swing.Table;
import com.cofii2.custom.JTCustomCellRenderer;
import com.cofii2.custom.LKCustom;
import com.cofii2.myClasses.MSQL;
import com.cofii2.myMethods.MComp;
import com.cofii2.myMethods.MList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import smallComponenets.MComboBoxE;
import views.mainTable.listeners.BTN_AL;
import views.mainTable.listeners.CBTables_IL;
import views.mainTable.listeners.VMTListener;
import views.mainTable.sql.SelectDists;

/**
 *
 * @author C0FII
 */
public class VMT {

      private MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      private JFrame JF = new JFrame();

      private JPanel PU = new JPanel();
      private JPanel PD = new JPanel();

      private JToggleButton btnDists = new JToggleButton("Dists");
      private JToggleButton btnTypes = new JToggleButton("Types");
      private JComboBox cbTables = new MComboBoxE(MList.getListToArray(String.class, TablesInfo.getTableList()));

      private JTable JTTypes = new Table();
      private JScrollPane sc_JTTypes = new JScrollPane(JTTypes);

      private JTable JTDists = new Table();
      private JScrollPane sc_JTDists = new JScrollPane(JTDists);
      //NON-EDITABLE ++++++++++++
      private DefaultTableModel dtmDists = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                  return false;
            }
      };
      private DefaultTableModel dtmTypes = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                  return false;
            }
      };

      public VMT() {
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.getContentPane().add(sc_JTTypes);
            JF.addWindowListener(new VMTListener());

            JF.getContentPane().setLayout(new BorderLayout());
            JF.add(PU, BorderLayout.CENTER);
            PU.setBackground(Color.BLACK);
            CardLayout cd = new CardLayout();
            PU.setLayout(cd);
            PU.add(sc_JTDists, "DISTS");
            sc_JTDists.getViewport().setBackground(Color.BLACK);
            PU.add(sc_JTTypes, "TYPES");
            sc_JTTypes.getViewport().setBackground(Color.BLACK);
            cd.show(PU, "DISTS");

            JF.add(PD, BorderLayout.SOUTH);
            PD.setBackground(Color.BLACK);
            PD.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));
            PD.setLayout(new BoxLayout(PD, BoxLayout.X_AXIS));
            JToggleButton[] btns = new JToggleButton[]{btnDists, btnTypes};
            BTN_AL al = new BTN_AL(btns, PU, cbTables);
            PD.add(cbTables);
            cbTables.setVisible(false);
            PD.add(Box.createHorizontalGlue());
            PD.add(btnDists);
            btnDists.setMinimumSize(new Dimension(200, 28));
            btnDists.setSelected(true);
            btnDists.addActionListener(al);
            PD.add(btnTypes);
            btnTypes.setMinimumSize(new Dimension(200, 28));
            btnTypes.addActionListener(al);

            //DISTS ++++++++++++++++++++++++++++
            ms.selectData(DTSQL.mainTable, new SelectDists());
            //TYPES +++++++++++++++++++++++++++
            JTextField tf = (JTextField)cbTables.getEditor().getEditorComponent();
            tf.setText("");
            cbTables.addItemListener(new CBTables_IL());
            //CLOSE ++++++++++++++++++++++++++++++++++++++
            try {
                  ms.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(VMT.class.getName()).log(Level.SEVERE, null, ex);
            }
            //CELL RENDERER +++++++++++++++++++++++
            MComp.setTableRenderer(JTDists);
            JTCustomCellRenderer cellR = new JTCustomCellRenderer();
            //cellR.addComponentAt(new OTInts(new JComboBox(), 0, 2));
            for (int a = 0; a < JTTypes.getColumnCount(); a++) {
                  JTTypes.getColumnModel().getColumn(a).setCellRenderer(cellR);
            }
            //SIZE +++++++++++++++++++++++++++++++++
            MComp.setTableDefaultColumnWidth(JTDists);
            MComp.setTableDefaultColumnWidth(JTTypes);

            start();
      }

      private void start() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        JF.setSize(LKCustom.MAINTABLE_FRAME_SIZE);
                        MComp.setFrameToCenterOfScreen(JF);
                        sc_JTTypes.setPreferredSize(new Dimension());
                        JF.setVisible(true);
                        JF.setAlwaysOnTop(true);

                        System.out.println(JTTypes.getColumnCount());
                        System.out.println(JTTypes.getRowCount());
                  }

            });
      }
      //+++++++++++++++++++++++++++++++++++

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
      
      public JComboBox getCBTables(){
            return cbTables;
      }
}
