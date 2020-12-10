/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.mTFControl;

import com.cofii.myMethods.MList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import javax.swing.JTextField;
import views.create.Actions.IKeyMatchActions2;

/**
 *
 * @author C0FII
 */
public class MTF_Control3 implements KeyListener {

      private ArrayList<Storage> Lists = new ArrayList<Storage>();

      public static final int CONTAIN_MATCH = 1;
      public static final int EQUAL_MATCH = 2;
      public static final int DUPLICATED_ELEMENTS = 3;

      public static ArrayList<Integer> list_MI = new ArrayList<Integer>();

      private IKeyMatchActions3 ac;

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public MTF_Control3(IKeyMatchActions3 ac) {
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
                                    System.out.println("\tCONTAIN_MATCH (" + (a + 1) + ")");
                                    matches[el++] = getContainMatchFromStringToList(text, list, false, false, false);
                              } else if (option == EQUAL_MATCH) {
                                    System.out.println("\tEQUAL_MATCH (" + (a + 1) + ")");
                                    matches[el++] = getEqualMatchFromStringToList(text, list, minusIndex, true);
                              } else if (option == DUPLICATED_ELEMENTS) {
                                    System.out.println("\tDUPLICATED_ELEMENTS (" + (a + 1) + ")");
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

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void addList(ArrayList<String> list, int option) {
            Lists.add(new Storage(list, option));
            list_MI.add(-1);
      }

      public void setMinusIndex(int listID, int minusIndex) {
            list_MI.set(listID, minusIndex);
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
            //System.out.println("getContainMatchFromStringToList");
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

                  //System.out.println("\ttext: " + text);
                  //System.out.println("\tcont: " + cont);
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
