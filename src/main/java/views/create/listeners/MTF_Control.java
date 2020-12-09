/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import MC.DTSQL;
import com.cofii.myMethods.MOthers;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import javax.swing.JTextField;
import views.create.Actions.IKeyMatchActions;
import views.create.VC_R2;

/**
 *
 * @author C0FII
 */
public class MTF_Control implements KeyListener {

      private ArrayList<String> List1;
      private ArrayList<String> List2;

      private static int OPTION1 = 1;
      private static int OPTION2 = 2;
      
      public static final int CONTAIN_MATCH = 1;
      public static final int EQUAL_MATCH = 2;
      public static final int DUPLICATED_ELEMENTS = 3;
      
      public static int LIST2_MINUS_INDEX = -1;

      private IKeyMatchActions ac;

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public MTF_Control(ArrayList<String> list1, int option1, IKeyMatchActions ac) {
            List1 = list1;
            OPTION1 = option1;
            List2 = null;
            OPTION2 = 0;
            this.ac = ac;
      }

      public MTF_Control(ArrayList<String> list1, int option1, ArrayList<String> list2, int option2, IKeyMatchActions ac) {
            List1 = list1;
            OPTION1 = option1;
            List2 = list2;
            OPTION2 = option2;
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
                  boolean matchBW = false;//MATCH SQL BANDWORDS
                  boolean matchEST = false;//MATCH EXISTING TABLE
                  JTextField tf = (JTextField) e.getSource();

                  String text = tf.getText();
                  if (OPTION1 == CONTAIN_MATCH) {
                        List1 = ac.getUpdatedList1(List1);
                        matchBW = MOthers.getContainMatchFromStringToList(text, List1, false);
                        ac.list1Action(e, matchBW);
                  }else if(OPTION1 == EQUAL_MATCH){
                        
                  }else if(OPTION1 == DUPLICATED_ELEMENTS){
                        
                  }
                  if (List2 != null) {
                        if (OPTION2 == EQUAL_MATCH) {
                              List2 = ac.getUpdateList2(List2);
                              int minusIndex = ac.getMinusIndex(e, LIST2_MINUS_INDEX);
                              matchEST = getEqualMatchFromStringToList(text, List2, minusIndex);
                              ac.list2Action(e, matchEST);
                        }
                  }
                  ac.afterActions();
            } else {
                  throw new InvalidParameterException("this class is only for JTextField to implement the ActionListener");
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static boolean getEqualMatchFromStringToList(String text, ArrayList<String> list, int minus) {
            System.out.println("getEqualMatchFromStringToList+++++++++++");
            System.out.println("List size: " + list.size());
            boolean returnValue = false;
            int count = 0;
            text = getStringAdjust(text);
            System.out.println("\tText: " + text);
            for (String x : list) {
                  System.out.println("\tX: " + x);
                  System.out.println();
                  String cont = getStringAdjust(x);
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

      private static String getStringAdjust(String text) {
            text = text.toUpperCase().trim();
            if (text.contains("_")) {
                  text = text.replaceAll("_", " ");
            }
            /*
            if(text.contains(" ")){
                  text = text.replaceAll(" ", "");
            }
             */
            return text;
      }

}
