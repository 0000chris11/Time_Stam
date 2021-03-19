/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.update.listeners;

import MC.MainInstances;
import MC.Status;
import SQL.DefaultConnection;
import com.cofii2.myInterfaces.IUpdates;
import com.cofii2.mysql.MSQL;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class BTNTableRename_AL implements ActionListener{

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private VC_R_DataCom d = MainInstances.getVC_R_DataCom();
      private String table = c.getUpdateStore().getTable();
      
      @Override
      public void actionPerformed(ActionEvent e) {
            if(d.getTF_Title().getForeground().equals(Color.BLUE.brighter())){
                  String newTable = d.getTF_Title().getText().toLowerCase().replaceAll(" ", "_").trim();
                  MSQL ms = new MSQL(new DefaultConnection());
                  ms.renameTable(table, newTable, new IUpdates(){
                        @Override
                        public void executeResultRowN() {
                              Status.startLBStatus(d.getLB_Status(), Color.RED, 
                                      "Table " + table + " has fail to be renamed", 5000);
                        }

                        @Override
                        public void executeResult0() {
                              Status.startLBStatus(d.getLB_Status(), Color.GREEN, 
                                      "Table " + table + " has been rename to " + newTable, 4000);
                        }

                        @Override
                        public void exception(SQLException ex) {
                              ex.printStackTrace();
                        }
                        
                  });
            }
      }
      
}
