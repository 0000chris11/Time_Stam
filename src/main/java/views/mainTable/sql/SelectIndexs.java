/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.sql;

import MC.MainInstances;
import com.cofii2.custom.TableCellRenderer;
import com.cofii2.methods.MComp;
import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.mainTable.VMT_DataCom;

/**
 *
 * @author C0FII
 */
public class SelectIndexs implements IActions{
      
      private VMT_DataCom dt = MainInstances.getVMT_DataCom();

      @Override
      public void beforeQuery() {
            dt.getJTIndexs().setModel(dt.getDTMIndexs());
            
            dt.getDTMIndexs().setColumnCount(0);
            dt.getDTMIndexs().setRowCount(0);
            
            dt.getDTMIndexs().addColumn("table");
            dt.getDTMIndexs().addColumn("key_name");
            dt.getDTMIndexs().addColumn("seq_in_index");
            dt.getDTMIndexs().addColumn("column_name");
            dt.getDTMIndexs().addColumn("collation");
            dt.getDTMIndexs().addColumn("cardinality");
            dt.getDTMIndexs().addColumn("sub_part");
            dt.getDTMIndexs().addColumn("packed");
            dt.getDTMIndexs().addColumn("null");
            dt.getDTMIndexs().addColumn("index_type");
            dt.getDTMIndexs().addColumn("comment");
            dt.getDTMIndexs().addColumn("index_comment");
            dt.getDTMIndexs().addColumn("visible");
            dt.getDTMIndexs().addColumn("expression");
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            String table = rs.getString(1);
            String key_name = rs.getString(2);
            String seq_in_index = rs.getString(3);
            String column_name = rs.getString(4);
            String collation = rs.getString(5);
            String cardinality = rs.getString(6);
            String sub_part = rs.getString(7);
            String packed = rs.getString(8);
            String nulll = rs.getString(9);
            String index_type = rs.getString(10);
            String comment = rs.getString(11);
            String index_comment = rs.getString(12);
            String visible = rs.getString(13);
            String expression = rs.getString(14);
            
            String[] rows = new String[]{
                  table, key_name, seq_in_index, column_name, collation, cardinality, sub_part, packed, nulll, index_type,
                  comment, index_comment, visible, expression};
            
            dt.getDTMIndexs().addRow(rows);
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            if(rsValue){
                  TableCellRenderer cr = new TableCellRenderer();
                  //cr.addWordChoice(new STColor("NONE", Color.RED.darker()));
                  MComp.setTableRenderer(dt.getJTIndexs(), cr);
            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }
      
}
