/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.sql;

import MC.MainInstances;
import com.cofii2.custom.JTCustomCellRenderer;
import com.cofii2.myClasses.STColor;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.myMethods.MComp;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.mainTable.VMT_DataCom;

/**
 *
 * @author C0FII
 */
public class SelectColumns implements IActions {

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();

      @Override
      public void beforeQuery() {
            dt.getJTTypes().setModel(dt.getDTMTypes());
            
            dt.getDTMTypes().setColumnCount(0);
            dt.getDTMTypes().setRowCount(0);
            
            dt.getDTMTypes().addColumn("Field");
            dt.getDTMTypes().addColumn("Type");
            dt.getDTMTypes().addColumn("Null");
            dt.getDTMTypes().addColumn("Key");
            dt.getDTMTypes().addColumn("Default");
            dt.getDTMTypes().addColumn("Extra");
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            String field = getStringControl(rs.getString(1));
            String type = getStringControl(rs.getString(2));
            String nulll = getStringControl(rs.getString(3));
            String key = getStringControl(rs.getString(4));
            String defaultt = getStringControl(rs.getString(5));
            String extra = getStringControl(rs.getString(6));
            
            Object[] rows = new Object[]{
                  field, type, nulll, key, defaultt, extra};

            dt.getDTMTypes().addRow(rows);
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            if(rsValue){
                  JTCustomCellRenderer cr = new JTCustomCellRenderer();
                  cr.addWordChoice(new STColor("NONE", Color.RED.darker()));
                  MComp.setTableRenderer(dt.getJTTypes(), cr);
            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }
      //++++++++++++++++++++++++++++++++++++++++++
      private String getStringControl(String text){
            String returnValue = text;
            if(text != null){
                  returnValue = "NONE";
            }
            return returnValue;
      }
}
