/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import SQLActions.SelectData;
import SQLStores.TableDistC;
import com.cofii2.methods.MText;
import com.cofii2.mysql.MSQL;
import java.util.ArrayList;
import views.first.VF_R;

/**
 *
 * @author Christopher
 */
public class CompReset {

      private String CName = this.getClass().getName();
      private MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      public void changeLB_TFandSelectData(int cc, ArrayList<String> listC) {
            System.out.println("\tColumnCount: " + cc);

            String[] cols = new String[listC.size()];//TEXT FOR LABELS
            for (int a = 0; a < cols.length; a++) {
                  System.out.println("\tlistC " + a + ": " + listC.get(a));
                  cols[a] = listC.get(a);
            }

            String table = TableDistC.getTable();
            
            String ed2 = MText.filterTextName(table, "TAKE");
            TableDistC.setTable(MText.filterTextName(table, "ADD"));
            //++++++++++++++++++++++++++++++++++++++++++++++++
            VF_R.getLB_Title().setText(ed2);

            for (int a = 0; a < DT.maxColumns ; a++) {//Limit of 1 to 6
                  VF_R.getJCBS()[a].removeAllItems();
                  if (cc == a + 1) {
                        if (VF_R.JPL_layout.equals("null")) {
                              //IF IS 1 COL THE LB_ICON BE BELLOW TFS[0]
                              //VF_R.getLB_Icon().setLocation(VF_R.getLB_Icon().getX(),
                                //      VF_R.getJCBS()[a].getY() + 66);
                        }

                        //MAKE COMPONENTS UNDER LIMIT VISIBLE
                        for (int b = 0; b < a + 1; b++) {
                              //1, 2, 3, 4, 5
                              VF_R.getJLBS()[b].setText((b + 1) + ". " + cols[b]);
                              MText.shortenLB(VF_R.getJLBS()[b]);
                              VF_R.getJTFPanel()[b].setVisible(true);
                              
                              VF_R.getJTFPanelCL()[b].show(VF_R.getJTFPanel()[b], VF_R.tfPanelTypes[0]);
                              /*
                              if(VF_R.getJTFPanel()[b].getComponent(0).getName().contains("CB")){
                                    VF_R.getJTFPanel()[b].remove(VF_R.getJCBS()[b]);
                                    VF_R.getJTFPanel()[b].add(VF_R.getJTFS()[b], 0);
                                    
                                    //VF_R.getJS()[b].setVisible(true);
                              }
                              */
                              
                              VF_R.getJLBS()[b].setVisible(true);
                              //VF_R.getJTFS()[b].setVisible(true);
                              VF_R.getBTNS_C()[b].setVisible(true);
                              
                        }
                        //HIDES OUT LENGTH COMPONENTS
                        for (int b = 0; b < DT.maxColumns - (a + 1); b++) {
                              VF_R.getJLBS()[b + (1 + a)].setVisible(false);
                              VF_R.getJTFPanel()[b + (1 + a)].setVisible(false);
                              VF_R.getBTNS_C()[b + (1 + a)].setVisible(false);
                        }

                        //mc.SelectData(a + 1, DT.getTable());
                        ms.selectData(table.replaceAll(" ", "_"), new SelectData(a + 1));
                  }
            }
            for(int a = 0; a < DT.maxColumns; a++){
                  //VF_R.getJCBS()[a].setVisible(true);
                  /*
                  System.out.println(VF_R.getJTFPanel()[a].getName() + ": " + VF_R.getJTFPanel()[a].isVisible());
                  if(VF_R.getJTFPanel()[a].getComponent(0).getName().contains("CB")){
                        System.out.println(VF_R.getJCBS()[a].getName() + ": " + VF_R.getJCBS()[a].isVisible());
                  }else{
                        System.out.println(VF_R.getJTFES()[a].getName() + ": " + VF_R.getJTFES()[a].isVisible());
                  }
                  */
            }
      }
}
