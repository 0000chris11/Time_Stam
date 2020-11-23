/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import MC.DTSQL;
import com.cofii.myMethods.MOthers;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author C0FII
 */
public class TFTable_KL_Control implements KeyListener{

      @Override
      public void keyTyped(KeyEvent e) {
            
      }

      @Override
      public void keyPressed(KeyEvent e) {
            
      }

      @Override
      public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            boolean matchBW = false;//MATCH SQL BANDWORDS
            boolean matchST = false;//MATCH EXISTING TABLE
            
            String table = VC_R2.getTF_Title().getText();
            matchBW = MOthers.getContainMatchFromStringToList(table, DTSQL.getBandW());
            //TEST WHEN YOU ACCESS FROM VF_R
            matchST = MOthers.getEqualMatchFromStringToList(table, DT.getList_T());
            
            if(matchBW == true){
                  VC_R2.getTF_Title().setForeground(Color.RED);
            }else{
                  VC_R2.getTF_Title().setForeground(Color.WHITE);
            }
            
            if(matchST == true){
                  VC_R2.getLB_Title().setForeground(Color.RED);
                  VC_R2.getLB_Title().setText("This table already exist");
                  
            }else{
                  VC_R2.getLB_Title().setForeground(Color.WHITE);
                  VC_R2.getLB_Title().setText(VC_R2.getLB_TitleOrigText());
            }
      }
      
}
