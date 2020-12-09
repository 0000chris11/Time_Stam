/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.LK;
import com.cofii.myMethods.MComp;
import com.cofii.myMethods.MList;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import views.create.VC_R2;

/**
 *
 * @author C0FII
 */
public class TFS_KL_ASameColumns extends IKeyMatchActions2 {

      private int index;
      
      public TFS_KL_ASameColumns(int index){
            this.index = index;
      }
      /*
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      @Override
      public int getMinusIndex(KeyEvent e, int index){
            return MComp.getLastDigitCharsCountAtEnd(e.getComponent().getName()) - 1;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      
      @Override
      public void beforeActions(KeyEvent e) {       
            VC_R2.getList_C().clear();
            for (JTextField x : VC_R2.getTFS()) {
                  if (x.isVisible()) {
                        VC_R2.getList_C().add(x.getText());
                  }
            }
            System.out.println("++++++++++++++++LIST_C++++++++++++++++");
            MList.printFor(VC_R2.getList_C());
      }
*/
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      @Override
      public ArrayList<String> getUpdatedList(ArrayList<String> list) {
            return VC_R2.getList_C();
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      @Override
      public void listAction(KeyEvent e, boolean v) {

            if (v) {
                  //lb.setForeground(Color.RED);
                  //lb.setText("Same Column");
                  
                  VC_R2.getHeaders()[1].setForeground(Color.RED);
                  VC_R2.getHeaders()[1].setText("Same Columns");
                  //tf.setBorder(LK.BR_TITLE_COLUMN_EXIST);
            } else {
                  //lb.setForeground(Color.WHITE);
                  //lb.setText(VC_R2.getLBOrigTexts()[index]);
                  VC_R2.getHeaders()[1].setForeground(Color.WHITE);
                  VC_R2.getHeaders()[1].setText("Names");
                  //tf.setBorder(LK.BR_LINEMARIGIN_FOCUS_OFF);
            }
      }

}
