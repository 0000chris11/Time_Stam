/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import MC.DTSQL;
import MC.Status;
import com.cofii.myInterfaces.IActions;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.Login.VL;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class MainTableExistFQ implements IActions {

      private String MainTableName;

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            MainTableName = rs.getObject(1).toString();

      }

      @Override
      public void afterQuery(String string, boolean value) {
            /*
            CREATE TABLE IF NOT EXISTS Table_Names (
                  id [Ljava.lang.String;@1dda4a50 NOT NULL AUTO_INCREMENT, 
                  Table_Names [Ljava.lang.String;@1dda4a50 NOT NULL, 
                  Dist1 [Ljava.lang.String;@1dda4a50 NOT NULL, 
                  Dist2 [Ljava.lang.String;@1dda4a50 NOT NULL, 
                  ImageC [Ljava.lang.String;@1dda4a50 NOT NULL, 
                  Tag1 [Ljava.lang.String;@1dda4a50 NOT NULL, 
                  Clock [Ljava.lang.String;@1dda4a50 NOT NULL,  
                  PRIMARY KEY(id)) ENGINE=INNODB
            */
            if (value && MainTableName.equals(DTSQL.mainTable)) {
                  System.out.println("\tMain Table Exist Already");
                  DTSQL.setMainTableExist(true);
            } else {
                  System.out.println("\tMain Table doesn't exist");
                  DTSQL.setMainTableExist(false);
            }
      }

      @Override
      public void exception(SQLException ex, String string) {
            System.out.println("ERROR QUERY: " + string);
            System.out.println("MESSAGE: " + ex.getMessage());
            if (ex.getMessage().contains("Access denied for user")) {
                  System.out.println("\tWRONG PASSWORD");
                  DT.setWrongPassword(true);
                  VL.getLBPass().setForeground(Color.RED);
                  VL.getLBPass().setText("Incorrect Password");
            } else {
                  DT.setWrongPassword(false);
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectTables: " + ex.toString(), 8000);
            }
      }

}
