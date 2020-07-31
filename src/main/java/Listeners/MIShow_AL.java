package Listeners;

import First.VF_R;
import MC.DT;
import MC.MM;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import MC.MethodM;
import java.util.EventListener;
import javax.swing.JMenuItem;

/**
 *
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
                  MM.printFor(DT.getList_T());
            } else if (ac.equals("Columns")) {
                  System.out.println();
                  MM.printFor(DT.getList_C());
            } else if (ac.equals("Dists")) {
                  System.out.println();
                  System.out.println("Dist1: " + DT.getDist1());
                  System.out.println("Dist2: " + DT.getDist2());
                  System.out.println("Tabl: " + DT.getTabl());
                  System.out.println("Tag1: " + DT.getTag());
                  System.out.println("Clock: " + DT.getClock());
            } else if (ac.equals("ListD")) {
                  MM.printFor(DT.getListD_2());
                  MM.printFor(DT.getListD_3());
                  MM.printFor(DT.getListD_4());
                  MM.printFor(DT.getListD_5());
                  MM.printFor(DT.getListD_6());
            } else if(ac.contains("P1 Components")){
                  for(int a = 0; a < VF_R.getP1().getComponents().length; a++){
                        System.out.println(a + ": " + VF_R.getP1().getComponents()[a].getName()
                        + " == " + VF_R.getP1().getComponent(a).toString());
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
                  for(int a = 0; a < VF_R.getJTFS().length; a++){
                        for(int b = 0; b < VF_R.getJTFS()[a].getFocusListeners().length; b++){
                              System.out.println(VF_R.getJTFS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJTFS()[a].getFocusListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JTextFields KL")){
                  System.out.println("\nJTextFields Key Listeners");
                  for(int a = 0; a < VF_R.getJTFS().length; a++){
                        for(int b = 0; b < VF_R.getJTFS()[a].getKeyListeners().length; b++){
                              System.out.println(VF_R.getJTFS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJTFS()[a].getKeyListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JTextFields ML")){
                  System.out.println("\nJTextFields Mouse Listeners");
                  for(int a = 0; a < VF_R.getJTFS().length; a++){
                        for(int b = 0; b < VF_R.getJTFS()[a].getMouseListeners().length; b++){
                              System.out.println(VF_R.getJTFS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJTFS()[a].getMouseListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JLists LSL")){
                  System.out.println("\nJLists ListSelection Listeners");
                  for(int a = 0; a < VF_R.getJLSTS().length; a++){
                        for(int b = 0; b < VF_R.getJLSTS()[a].getListSelectionListeners().length; b++){
                              System.out.println(VF_R.getJLSTS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJLSTS()[a].getListSelectionListeners()[b].toString());
                        }
                  }
            }else if(ac.equals("JLists FL")){
                  System.out.println("\nJLists Focus Listeners");
                  for(int a = 0; a < VF_R.getJLSTS().length; a++){
                        for(int b = 0; b < VF_R.getJLSTS()[a].getFocusListeners().length; b++){
                              System.out.println(VF_R.getJLSTS()[a].getName()
                              + " " + (b + 1) + ": " + VF_R.getJLSTS()[a].getFocusListeners()[b].toString());
                        }
                  }
            }
      }
}
