/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.mTFControl;

import com.cofii2.methods.MList;
import com.cofii2.methods.MOthers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class MTF_Control3 extends MTXControlData implements KeyListener {

      public MTF_Control3(AKeyMatchActions3 ac) {
            this.ac = ac;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
            if (e.getSource() instanceof JTextField) {
                  ac.beforeActions(e);

                  boolean[] matches = new boolean[Lists.size()];
                  JTextField tf = (JTextField) e.getSource();
                  String text = tf.getText();

                  int el = 0;
                  if (Lists.size() != 0) {
                        for (int a = 0; a < Lists.size(); a++) {
                              ArrayList<String> list = Lists.get(a).list;
                              int minusIndex = list_MI.get(a);
                              int option = Lists.get(a).option;

                              UpdateList ul = ac.getUpdatedList(a, list);
                              if (ul.IDlist == a) {
                                    list = ul.list;
                              }

                              if (option == CONTAIN_MATCH) {
                                    //System.out.println("\tCONTAIN_MATCH (" + (a + 1) + ")");
                                    matches[el++] = MOthers.getContainMatchFromStringToList(text, list, false, false, false);
                              } else if (option == EQUAL_MATCH) {
                                    //System.out.println("\tEQUAL_MATCH (" + (a + 1) + ")");
                                    matches[el++] = MOthers.getEqualMatchFromStringToList(text, list, minusIndex, true);
                              } else if (option == DUPLICATED_ELEMENTS) {
                                    //System.out.println("\tDUPLICATED_ELEMENTS (" + (a + 1) + ")");
                                    matches[el++] = MList.areTheyDuplicatedElementsOnList(list);
                              } else {
                                    throw new InvalidParameterException("Option not Found");
                              }
                        }
                        ac.listsAction(e, matches);
                  }else{
                        throw new InvalidParameterException("Empy List");
                  }

            } else {
                  throw new InvalidParameterException("this class is only for JTextField to implement the ActionListener");
            }
      }

}
