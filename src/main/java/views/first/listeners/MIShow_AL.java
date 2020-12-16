package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.cofii.myMethods.MList;

/**
 *Show Listeners and List
 * @author Christopher
 */
public class MIShow_AL implements ActionListener {

      //Data dt = new Data("MIShow_AL");
      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);

      @Override
      public void actionPerformed(ActionEvent evt) {
            System.out.println("actionPerformed");
            String ac = evt.getActionCommand();
            
            showLists(ac);
            showListeners(ac);
            
      }
      
      private void showLists(String ac){
            if (ac.equals("Tables")) {
                  
                  /*
                  REPLACE+++++++++++++++++++
                  System.out.println();
                  MList.printFor(DT.getList_T());
                  */
            } else if (ac.equals("Columns")) {
                  System.out.println();
                  MList.printFor(DT.getList_C());
            } else if (ac.equals("Dists")) {
                  //REPLACE+++++++++++++++++++++++++
            } else if (ac.equals("ListD")) {
                  for(int a = 0; a < DT.maxColumns; a++){
                        MList.printFor(DT.getList_DS()[a]);
                  }
            } else if(ac.contains("P1 Components")){
                  for(int a = 0; a < VF_R.getPL_UC().getComponents().length; a++){
                        System.out.println(a + ": " + VF_R.getPL_UC().getComponents()[a].getName()
                        + " == " + VF_R.getPL_UC().getComponent(a).toString());
                  }
            }else if(ac.contains("JF Components")){
                  for(int a = 0; a < VF_R.getJF().getContentPane().getComponents().length; a++){
                        System.out.println(a + ": " + VF_R.getJF().getContentPane().getComponents()[a].getName()
                        + " == " + VF_R.getJF().getContentPane().getComponent(a).toString());
                  }
            }
      }
      
      private void showListeners(String ac){
            if(ac.equals("JTextFields FL")){
                  System.out.println("\nJTextFields Focus Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJCBS()[a].getFocusListeners().length; b++){
                              System.out.println(VF_R.getJCBS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJCBS()[a].getFocusListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JTextFields KL")){
                  System.out.println("\nJTextFields Key Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJCBS()[a].getKeyListeners().length; b++){
                              System.out.println(VF_R.getJCBS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJCBS()[a].getKeyListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JTextFields ML")){
                  System.out.println("\nJTextFields Mouse Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJCBS()[a].getMouseListeners().length; b++){
                              System.out.println(VF_R.getJCBS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJCBS()[a].getMouseListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JLists LSL")){
                  System.out.println("\nJLists ListSelection Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJLSTS()[a].getListSelectionListeners().length; b++){
                              System.out.println(VF_R.getJLSTS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJLSTS()[a].getListSelectionListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JLists FL")){
                  System.out.println("\nJLists Focus Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJLSTS()[a].getFocusListeners().length; b++){
                              System.out.println(VF_R.getJLSTS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJLSTS()[a].getFocusListeners()[b].toString());
                        }
                  }
            }
      }
}
