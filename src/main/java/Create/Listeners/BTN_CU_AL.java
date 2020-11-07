/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import com.cofii.myClasses.CC;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C0FII
 */
public class BTN_CU_AL implements ActionListener {
      
      private String Choice;
      private int countO = -1;
      
      public BTN_CU_AL(String choice) {
            Choice = choice;
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            if (Choice.equals("CREATE")) {
                  int countV = 0;

                  //HOW MANY COLS ARE VISIBLE
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (VC_R2.getJTFS()[a].isVisible()) {
                              countV++;
                        }
                  }
                  System.out.println("'\tColumns Visible: " + countV);
                  
                  String[] cols = TFSControl(countV);
                  boolean tableMatch = tableControl();
                  if (countV == countO && tableMatch == false) {
                        
                  }
                  
            } else if (Choice.equals("UPDATE")) {
                  
            }
      }
      
      private String[] TFSControl(int cv) {
            countO = 0;
            int countC = 0;
            String[] cols = new String[cv];
            //IF EACH JTF HAS TEXT AND NO SQL ERRORS
            for (int a = 0; a < cv; a++) {
                  //IF THE COLUMNS ARE OK
                  if (!VC_R2.getJTFS()[a].getText().isEmpty()) {
                        if (!VC_R2.getJTFS()[a].getForeground().equals(Color.RED)
                                && !VC_R2.getJLBS()[a].getForeground().equals(Color.RED)) {
                              System.out.println("\t\tCNEEDED " + (cv) + " = " + countC);
                              cols[countC] = VC_R2.getJTFS()[a].getText();
                              countC++;//count up only if it meats the conditions
                              countO++;
                              
                        }
                  }
            }
            return cols;
      }
      
      private boolean tableControl() {
            boolean match = false;
            for (int b = 0; b < DT.getList_T().size(); b++) {
                  if (VC_R2.getTable_Name().getText().equalsIgnoreCase(
                          DT.getList_T().get(b))) {
                        match = true;
                  } else {
                        if (match != true) {
                              match = false;
                        }
                  }
            }
            System.out.print("\t\tTable ");
            if (match == false) {
                  System.out.println(CC.GREEN + "OK" + CC.RESET);
            } else {
                  System.out.println(CC.RED + "ALREADY EXIST" + CC.RESET);
            }
            return match;
      }
      
}
