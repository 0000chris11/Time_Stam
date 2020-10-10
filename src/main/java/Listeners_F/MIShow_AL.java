package Listeners_F;

import First.VF_R;
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
                  System.out.println();
                  MList.printFor(DT.getList_T());
            } else if (ac.equals("Columns")) {
                  System.out.println();
                  MList.printFor(DT.getList_C());
            } else if (ac.equals("Dists")) {
                  System.out.println();
                  System.out.println("Dist1: " + DT.getDist1());
                  System.out.println("Dist2: " + DT.getDist2());
                  System.out.println("Tabl: " + DT.getTabl());
                  System.out.println("Tag1: " + DT.getTag());
                  System.out.println("Clock: " + DT.getClock());
            } else if (ac.equals("ListD")) {
                  MList.printFor(DT.getListD_2());
                  MList.printFor(DT.getListD_3());
                  MList.printFor(DT.getListD_4());
                  MList.printFor(DT.getListD_5());
                  MList.printFor(DT.getListD_6());
            } else if(ac.contains("P1 Components")){
                  for(int a = 0; a < VF_R.getPL_C().getComponents().length; a++){
                        System.out.println(a + ": " + VF_R.getPL_C().getComponents()[a].getName()
                        + " == " + VF_R.getPL_C().getComponent(a).toString());
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
                        for(int b = 0; b < VF_R.getJTFS()[a].getFocusListeners().length; b++){
                              System.out.println(VF_R.getJTFS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJTFS()[a].getFocusListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JTextFields KL")){
                  System.out.println("\nJTextFields Key Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJTFS()[a].getKeyListeners().length; b++){
                              System.out.println(VF_R.getJTFS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJTFS()[a].getKeyListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JTextFields ML")){
                  System.out.println("\nJTextFields Mouse Listeners");
                  for(int a = 0; a < DT.maxColumns; a++){
                        for(int b = 0; b < VF_R.getJTFS()[a].getMouseListeners().length; b++){
                              System.out.println(VF_R.getJTFS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJTFS()[a].getMouseListeners()[b].toString());
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
