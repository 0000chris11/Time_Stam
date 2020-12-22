/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.mTFControl;

import com.cofii2.methods.MList;
import com.cofii2.methods.MOthers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class MBTN_Control extends MTXControlData implements ActionListener {

      private String text;

      public MBTN_Control(String text, AKeyMatchActions3 ac) {
            this.ac = ac;
            this.text = text;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            ac.beforeActions(e);

            boolean[] matches = new boolean[Lists.size()];

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
                              if (text != null) {
                                    System.out.println("\tCONTAIN_MATCH (" + (a + 1) + ")");
                                    matches[el++] = MOthers.getContainMatchFromStringToList(text, list, false, false, false);
                              }else{
                                    throw new NullPointerException("Text is null");
                              }
                        } else if (option == EQUAL_MATCH) {
                              if (text != null) {
                                    System.out.println("\tEQUAL_MATCH (" + (a + 1) + ")");
                                    matches[el++] = MOthers.getEqualMatchFromStringToList(text, list, minusIndex, true);
                              }else{
                                    throw new NullPointerException("Text is null");
                              }
                        } else if (option == DUPLICATED_ELEMENTS) {
                              //System.out.println("\tDUPLICATED_ELEMENTS (" + (a + 1) + ")");
                              matches[el++] = MList.areTheyDuplicatedElementsOnList(list);
                        } else {
                              throw new InvalidParameterException("Option not Found");
                        }
                  }
                  ac.listsAction(e, matches);
            } else {
                  throw new InvalidParameterException("Empy List");
            }

      }

}
