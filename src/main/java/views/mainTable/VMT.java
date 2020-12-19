/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable;

import MC.DTSQL;
import MC.MainInstances;
import com.cofii2.custom.JTCustomCellRenderer;
import com.cofii2.custom.LKCustom;
import com.cofii2.myMethods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import views.mainTable.listeners.BTN_AL;
import views.mainTable.listeners.JTDists_LSL;
import views.mainTable.listeners.JT_TML;
import views.mainTable.listeners.VMTListener;
import views.mainTable.sql.SelectDists;

/**
 *
 * @author C0FII
 */
public class VMT {

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();

      public VMT() {
            dt.JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dt.JF.getContentPane().add(dt.sc_JTTypes);
            dt.JF.addWindowListener(new VMTListener());

            dt.JF.getContentPane().setLayout(new BorderLayout());
            dt.JF.add(dt.PU, BorderLayout.CENTER);
            dt.PU.setBackground(Color.BLACK);
            dt.PU.setLayout(dt.cd);
            dt.PU.add(dt.sc_JTDists, "DISTS");
            dt.sc_JTDists.getViewport().setBackground(Color.BLACK);
            dt.PU.add(dt.sc_JTTypes, "TYPES");
            dt.sc_JTTypes.getViewport().setBackground(Color.BLACK);
            dt.PU.add(dt.lbTypes, "LB_TYPES");
            dt.lbTypes.setForeground(Color.RED);
            dt.lbTypes.setFont(LKCustom.FONT_BIG_LB_MESSAGE);
            dt.cd.show(dt.PU, "DISTS");

            dt.JF.add(dt.PD, BorderLayout.SOUTH);
            dt.PD.setBackground(Color.BLACK);
            dt.PD.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));
            dt.PD.setLayout(new BoxLayout(dt.PD, BoxLayout.X_AXIS));
            JToggleButton[] btns = new JToggleButton[]{dt.btnDists, dt.btnTypes};
            BTN_AL al = new BTN_AL(btns);
            
            dt.PD.add(dt.btnDists);
            dt.btnDists.setMinimumSize(new Dimension(200, 28));
            dt.btnDists.setSelected(true);
            dt.btnDists.addActionListener(al);
            dt.PD.add(dt.btnTypes);
            dt.btnTypes.setMinimumSize(new Dimension(200, 28));
            dt.btnTypes.addActionListener(al);
            dt.PD.add(Box.createHorizontalGlue());
            //System.out.println("++++++++++VMT " + MainInstances.getVMT());
            //DISTS ++++++++++++++++++++++++++++
            dt.ms.selectData(DTSQL.mainTable, new SelectDists());
            //CLOSE ++++++++++++++++++++++++++++++++++++++
            try {
                  dt.ms.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(VMT.class.getName()).log(Level.SEVERE, null, ex);
            }
            //CELL RENDERER +++++++++++++++++++++++
            MComp.setTableRenderer(dt.JTDists, new JTCustomCellRenderer());
            dt.JTTypes.getModel().addTableModelListener(new JT_TML());
            //SIZE +++++++++++++++++++++++++++++++++
            MComp.setTableDefaultColumnWidth(dt.JTDists);
            MComp.setTableDefaultColumnWidth(dt.JTTypes);
            //+++++++++++++++++++++++++++++++++++++
            dt.JTDists.getSelectionModel().addListSelectionListener(new JTDists_LSL());
            start();
      }

      private void start() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        dt.JF.setSize(LKCustom.MAINTABLE_FRAME_SIZE);
                        MComp.setFrameToCenterOfScreen(dt.JF);
                        dt.sc_JTTypes.setPreferredSize(new Dimension());
                        dt.JF.setVisible(true);
                        dt.JF.setAlwaysOnTop(true);

                        System.out.println(dt.JTTypes.getColumnCount());
                        System.out.println(dt.JTTypes.getRowCount());
                  }

            });
      }
      //+++++++++++++++++++++++++++++++++++

      
}
