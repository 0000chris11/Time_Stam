/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import com.cofii.myClasses.CC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Login.VL;

/**
 *
 * @author C0FII
 */
public class MIOptions_AL implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
            System.out.println(CC.CYAN + "#### VL STARS ####" + CC.RESET);
            new VL("Change");
      }
      
}
