/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DTSQL;
import com.cofii2.methods.MList;
import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author COFII
 */
public class TablesExistFQ implements IActions{
      
      private ArrayList<String> listTables = new ArrayList<String>();
      
      @Override
      public void beforeQuery() {
            
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            listTables.add(rs.getString(1));
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            if(rsValue){
                  boolean mainTableExist = MList.isOnThisList(listTables, DTSQL.mainTable, true);
                  DTSQL.setMainTableExist(mainTableExist);
                  System.out.println("\tmainTableExist: " + mainTableExist);
                  
                  boolean PKTable = MList.isOnThisList(listTables, DTSQL.defautlTable, true);
                  DTSQL.setPKTableExist(PKTable);
                  System.out.println("\tPKTable: " + PKTable);
                  
                  boolean configTableExist = MList.isOnThisList(listTables, DTSQL.configTable, true);
                  DTSQL.setConfigTableExist(configTableExist);
                  System.out.println("\tconfigTableExist: " + configTableExist);
                  
                  boolean defautlTable = MList.isOnThisList(listTables, DTSQL.defautlTable, true);
                  DTSQL.setDefaultTableExist(defautlTable);
                  System.out.println("\tdefautlTable: " + defautlTable);
            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }
      
}
