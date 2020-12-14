/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C0FII;

import MC.DTSQL;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C0FII
 */
public class TestDeletLater {

      public static void main(String[] args) {
            String table1 = "Table_Others";
            String table2 = "Table_Names";

            MDString md = new MDString(table1, table2);
            MSQLConnect mc = new MSQLConnect(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
            MSQL2 ms2 = new MSQL2(md, mc);

            ms2.addColumn(new MDString(table1, "id"));
            ms2.addColumn(new MDString(table2, "Name"));
            ms2.addColumn(new MDString(table1, "pk"));

            ms2.selectTablesJoin(new MDString(table1, "id"), new MDString(table2, "id"), new IActions() {
                  @Override
                  public void beforeQuery() {

                  }

                  @Override
                  public void setData(ResultSet rs, int i) throws SQLException {
                        
                  }

                  @Override
                  public void afterQuery(String string, boolean bln) {

                  }

                  @Override
                  public void exception(SQLException sqle, String string) {
                        System.out.println(string);
                        sqle.printStackTrace();
                  }

            });
            try {
                  ms2.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(TestDeletLater.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
}
