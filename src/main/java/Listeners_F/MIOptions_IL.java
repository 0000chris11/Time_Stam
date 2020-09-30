package Listeners_F;

import First.VF_R_DataCom;
import First.VF_R;
import MC.DT;
import mMethods.MM;
import MC.MakeCon;
import MC.MethodM;
import MC.Status;
import MC.notMyMethods;
import mMethods.MText;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Christopher
 */
public class MIOptions_IL implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
            String item = ((JComponent) e.getSource()).getName();

            setFOptions(e, item);
            setPanelsOptions(e, item);
            //+++++++++++++++++++++++++
            if (e.getActionCommand().contains("Save")) {
                  //Data dt = new Data("MIOptions_IL");
                  MakeCon mc = new MakeCon(this.getClass().getName(), 
                          DT.CCount++);

                  if (VF_R.getMI_AOT().getState() != DT.getList_BL().get(0)) {
                        mc.UpdateConfig(VF_R.getMI_AOT().getState(), 1);
                  }else if (VF_R.getMI_AutoR().getState() != DT.getList_BL().get(1)) {
                        mc.UpdateConfig(VF_R.getMI_AutoR().getState(), 2);
                  }else if (VF_R.getMI_Grid().getState() != DT.getList_BL().get(2)) {
                        mc.UpdateConfig(VF_R.getMI_Grid().getState(), 3);
                  }else{
                        new Status().startLBStatus(
                                VF_R.getLB_Status(), DT.RGY[2], "Nothing has changed.", 6000);
                  }
                        mc.SelectConfig();
            }
      }

      private void setFOptions(ActionEvent e, String item) {
            if (item.contains("mi_AOT")) {
                  if (VF_R.getMI_AOT().isSelected()) {
                        VF_R.getJF().setAlwaysOnTop(true);
                  } else {
                        VF_R.getJF().setAlwaysOnTop(false);
                  }

            } else if (item.contains("mi_AutoR")) {
                  boolean b = false;
                  if (VF_R.getMI_AutoR().isSelected()) {
                        b = true;
                  }
                  new notMyMethods().rez(VF_R.getJT(), b);

            } else if (item.contains("mi_Grid")) {
                  if (VF_R.getMI_Grid().isSelected()) {
                        VF_R.getJT().setShowGrid(true);
                  } else {
                        VF_R.getJT().setShowGrid(false);
                  }
            }
      }

      private void setPanelsOptions(ActionEvent e, String item) {
            System.out.println("setPanelsIOptions");
            System.out.println("item: " + item);
            JFrame JF = VF_R.getJF();
            JPanel p3 = VF_R.getP3();

            if (MText.getMatch(VF_R.getMI_SEEL().getName(), item, Pattern.CASE_INSENSITIVE)) {
                  System.out.println("\tMI_SEEL");
                  if (VF_R.getMI_SEEL().isSelected()) {//UNHIDE LEFT PANEL
                        System.out.println("\t\tOPEN");
                        JF.setSize(DT.defaultFrameSize);
                        VF_R.getSC_P1().setVisible(true);

                        int x = VF_R.getSC_P1().getX() + VF_R.getSC_P1().getWidth();
                        VF_R.getSC_JT().setLocation(x - 2, VF_R.getSC_JT().getY());
                        //sc_p1.getWidth() + sc_JT.getWidth() + 2
                        VF_R.getTB().setLocation(
                                VF_R.getSC_P1().getWidth() + VF_R.getSC_JT().getWidth() + 2, VF_R.getTB().getY());
                        //+++++++++++++++++++++++++++++++
                        p3.setSize(VF_R.getSC_P1().getWidth() + VF_R.getSC_JT().getWidth() + 40,
                                p3.getHeight());
                        VF_R.getLB_Status().setSize(
                                VF_R.getSC_P1().getWidth() + VF_R.getSC_JT().getWidth() + 20,
                                VF_R.getLB_Status().getHeight());
                  } else {
                        if (VF_R.getMI_SEER().isSelected()) {
                              System.out.println("\t\tHIDING");
                              VF_R.getSC_P1().setVisible(false);

                              VF_R.getSC_JT().setLocation(
                                      VF_R.getSC_P1().getX(), VF_R.getSC_JT().getY());
                              VF_R.getTB().setLocation(
                                      VF_R.getSC_JT().getWidth() + 2,
                                      VF_R.getTB().getY());
                              JF.setSize(VF_R.getSC_JT().getWidth() + VF_R.getTB().getWidth() + 21, JF.getHeight());
                              //++++++++++++++++++++++++++
                              p3.setSize(VF_R.getSC_JT().getWidth() + VF_R.getTB().getWidth(), p3.getHeight());
                              VF_R.getLB_Status().setSize(VF_R.getP3().getWidth() - 12,
                                      VF_R.getLB_Status().getHeight());
                              /*
                              VF_R.getLB_Status().setSize(
                                      VF_R.getSC_JT().getWidth() + VF_R.getTB().getWidth() - 80, 
                                      VF_R.getLB_Status().getHeight());
                               */
                        } else {
                              System.out.println("\t\tBLOCKED");
                              VF_R.getMI_SEEL().setSelected(true);
                        }
                  }
            } else if (MText.getMatch(VF_R.getMI_SEER().getName(), item, Pattern.CASE_INSENSITIVE)) {
                  System.out.println("\tMI_SEER");
                  if (VF_R.getMI_SEER().isSelected()) {//UNHIDE TABLE
                        System.out.println("\t\tOPEN");
                        VF_R.getSC_JT().setVisible(true);
                        JF.setSize(DT.defaultFrameSize);
                        //+++++++++++++++++++++++++
                        p3.setSize(VF_R.getSC_P1().getWidth() + VF_R.getSC_JT().getWidth() + 40,
                                p3.getHeight());
                        VF_R.getLB_Status().setSize(p3.getWidth() - 100, VF_R.getLB_Status().getHeight());
                  } else {//HIDE TABLE
                        if (VF_R.getMI_SEEL().isSelected()) {//ONLY WHEN THE PANEL IS VISBLE
                              System.out.println("\t\tHIDING");
                              VF_R.getSC_JT().setVisible(false);
                              VF_R.getJF().setSize(
                                      VF_R.getSC_P1().getWidth() + 20, JF.getHeight());
                              //++++++++++++++++++++
                              p3.setSize(VF_R.getSC_P1().getWidth(), p3.getHeight());
                              VF_R.getLB_Status().setSize(VF_R.getP3().getWidth() - 12,
                                      VF_R.getLB_Status().getHeight());

                        } else {//CHANGES BACK TO TRUE
                              System.out.println("\t\tBLOCK");
                              VF_R.getMI_SEER().setSelected(true);
                        }
                  }
            }
      }

}
