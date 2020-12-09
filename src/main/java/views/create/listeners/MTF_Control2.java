/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import com.cofii.myMethods.MList;
import com.cofii.myMethods.MOthers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import javax.swing.JTextField;
import views.create.Actions.IKeyMatchActions;
import views.create.Actions.IKeyMatchActions2;

/**
 *
 * @author C0FII
 */
public class MTF_Control2 implements KeyListener {

      private ArrayList<String> List1;

      private int OPTION = 1;

      public static final int CONTAIN_MATCH = 1;
      public static final int EQUAL_MATCH = 2;
      public static final int DUPLICATED_ELEMENTS = 3;

      public static int LIST_MINUS_INDEX = -1;

      private IKeyMatchActions2 ac;

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public MTF_Control2(ArrayList<String> list1, int option, IKeyMatchActions2 ac) {
            List1 = list1;
            OPTION = option;
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
            System.out.println("MTF_Control2");
            if (e.getSource() instanceof JTextField) {
                  ac.beforeActions(e);

                  boolean match = false;
                  JTextField tf = (JTextField) e.getSource();
                  String text = tf.getText();

                  List1 = ac.getUpdatedList(List1);//OVERRIDE----------------
                  if (OPTION == CONTAIN_MATCH) {
                        System.out.println("\tCONTAIN_MATCH");
                        match = getContainMatchFromStringToList(text, List1, false, false, false);
                  } else if (OPTION == EQUAL_MATCH) {
                        System.out.println("\tEQUAL_MATCH");
                        int minusIndex = ac.getMinusIndex(e, LIST_MINUS_INDEX);//OVERRIDE------------------
                        match = getEqualMatchFromStringToList(text, List1, minusIndex, true);
                  } else if (OPTION == DUPLICATED_ELEMENTS) {
                        System.out.println("\tDUPLICATED_ELEMENTS");
                        match = MList.areTheyDuplicatedElementsOnList(List1);
                  } else {
                        throw new InvalidParameterException("Option not Found");
                  }

                  ac.listAction(e, match);
                  ac.afterActions();
            } else {
                  throw new InvalidParameterException("this class is only for JTextField to implement the ActionListener");
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static boolean getEqualMatchFromStringToList(String text, ArrayList<String> list, int minus, boolean trim) {
            System.out.println("getEqualMatchFromStringToList+++++++++++");
            System.out.println("List size: " + list.size());
            boolean returnValue = false;
            int count = 0;
            text = getStringAdjust(text);
            if (trim) {
                  text = text.trim();
            }
            System.out.println("\tText: " + text);
            for (String x : list) {
                  System.out.println("\tX: " + x);
                  String cont = getStringAdjust(x);
                  if (trim) {
                        cont = cont.trim();
                  }
                  if (count != minus && minus >= 0) {
                        if (text.equalsIgnoreCase(cont) && !text.isEmpty()) {
                              returnValue = true;
                        }
                  } else if (minus < 0) {
                        if (text.equalsIgnoreCase(cont) && !text.isEmpty()) {
                              returnValue = true;
                        }
                  }
                  count++;
            }
            //System.out.println("\t\tRETURN VALUE: " + returnValue);
            return returnValue;
      }

      public static boolean getContainMatchFromStringToList(String text, ArrayList<String> list,
              boolean caseSensitive, boolean trim, boolean adjust) {
            System.out.println("getContainMatchFromStringToList");
            boolean returnValue = false;

            if (adjust) {
                  text = getStringAdjust(text);
            }
            if (!caseSensitive) {
                  text = text.toUpperCase();
            }
            if (trim) {
                  text = text.trim();
            }

            for (String x : list) {
                  String cont;
                  if (adjust) {
                        cont = getStringAdjust(x);
                  } else if (!caseSensitive) {
                        cont = x.toUpperCase();
                  } else {
                        cont = x;
                  }
                  if (trim) {
                        cont.trim();
                  }

                  System.out.println("\ttext: " + text);
                  System.out.println("\tcont: " + cont);
                  if (text.contains(cont)) {
                        returnValue = true;
                  }
            }
            return returnValue;
      }

      private static String getStringAdjust(String text) {
            if (text.contains("_")) {
                  text = text.replaceAll("_", " ");
            }
            return text;
      }

}
