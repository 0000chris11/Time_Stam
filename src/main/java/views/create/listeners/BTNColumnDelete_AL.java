/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import MC.Status;
import SQL.DefaultConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.cofii2.components.swing.VO;
import com.cofii2.myInterfaces.IUpdates;
import com.cofii2.mysql.MSQL;
import java.awt.Color;
import java.sql.SQLException;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;
import views.first.VF_R;
import views.first.listeners.JTChanged_AL;

/**
 *
 * @author C0FII
 */
public class BTNColumnDelete_AL implements ActionListener {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      
      private String message = "Delete column <DEFAULT>";
      private JButton[] array;
      private JButton btnNo = new JButton("No");
      private JButton btnYes = new JButton("Yes");
      private VO vo;
      private int index;

      public BTNColumnDelete_AL(int index) {
            this.index = index;
            if(index < c.getUpdateStore().getColumnNames().length){
                  message = "Delete column \"" + c.getUpdateStore().getColumnNames()[index] + "\" (" + (index + 1) + ")";
            }
            
            array = new JButton[]{btnNo, btnYes};

            btnNo.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        vo.JF.dispose();
                  }
            });
            btnYes.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        MSQL ms = new MSQL(new DefaultConnection());
                        String table = c.getUpdateStore().getTable();
                        String column = c.getUpdateStore().getColumnNames()[index];
                        ms.deleteColumn(table, column, new IUpdates(){
                              @Override
                              public void executeResultRowN() {
                                    Status.startLBStatus(dt.getLB_Status(), Color.GREEN, "Column \"" + column + "\" deleted!", 4000);
                                    VF_R.setDropAddColumn(true);
                                    JTChanged_AL.action(table);
                              }

                              @Override
                              public void executeResult0() {
                                    Status.startLBStatus(dt.getLB_Status(), Color.YELLOW, "Column \"" + column + "\" fail to be deleted!", 5000);
                                    VF_R.setDropAddColumn(false);
                                    int index1 = 30;
                                    int index2 = 40;
                                    
                              }

                              @Override
                              public void exception(SQLException ex) {
                                    ex.printStackTrace();
                              }
                              
                        });
                  }

            });
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            vo = new VO("Delete Column", message, array);
      }

}
