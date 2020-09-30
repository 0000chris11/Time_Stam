/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mMethods;

import static Copy.Lots.searchFilter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Christopher
 */
public class MKey {
      
      private static void scrollUpDown(JList lst, KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                  lst.ensureIndexIsVisible(lst.getSelectedIndex() + 1);
            } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                  lst.ensureIndexIsVisible(lst.getSelectedIndex() - 1);
            }
      }

      private static void searchFilterWhen(JLabel lb, JTextField tf, KeyEvent evt,
              ArrayList<String> list, JList lst) {
            if (evt.getKeyCode() == KeyEvent.VK_LEFT
                    || evt.getKeyCode() == KeyEvent.VK_RIGHT
                    || evt.getKeyCode() == KeyEvent.VK_DOWN
                    || evt.getKeyCode() == KeyEvent.VK_UP) {
            } else {
                  //System.out.println("\tNONE DIRECTIONAL");
                  if (lb.getText().contains("*")) {
                        //System.out.println("\t\tTags ALLOWED");
                        if (tf.getText().contains("; ")) {
                              //System.out.println("\t\t\ttag detected");
                              String textf = tf.getText();

                              //SEARCH AFTER PREVIOS TAG
                              //System.out.println("\t\t\t\tbefore search");
                              searchFilter(textf.substring(textf.lastIndexOf("; ") + 2),
                                      list, lst);
                              //System.out.println("\t\t\t\tafter search");
                        } else {
                              //WITHOUT TAG
                              //NORMAL SEARCH WITH NO TAG
                              //System.out.println("\tsearching without tag");
                              searchFilter(tf.getText(), list, lst);
                        }
                  } else {
                        //System.out.println("\t\tTags NOT ALLOWED");
                        //NORMAL SEARCH WITH NO TAGS ALLOWED
                        searchFilter(tf.getText(), list, lst);
                  }
            }
      }

      private static void changeIndexTAG(JList jls, JTextField tf, KeyEvent ev) {
            int ik = ev.getKeyCode();

            if (ik == 40) {
                  jls.setSelectedIndex(jls.getSelectedIndex() + 1);
            } else if (ik == 38) {
                  jls.setSelectedIndex(jls.getSelectedIndex() - 1);
            }

            if (tf.getText().contains(";")) {
                  //System.out.println("1st Step");
                  String text = tf.getText();
                  tf.setText(text.substring(0, text.lastIndexOf(";") + 2));

                  //System.out.println("2nd Step");
                  String text0 = jls.getSelectedValue().toString();

                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        tf.setText(tf.getText() + text0.substring(text0.indexOf(":") + 1, text0.length()));
                  } else {
                        tf.setText(tf.getText() + text0);
                  }

            } else {
                  String value = jls.getSelectedValue().toString();
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        tf.setText(value.substring(value.indexOf(":") + 1, value.length()).trim());
                  } else {
                        tf.setText(value);
                  }
            }
      }

      private static void changeIndexNoTAG(JList jls, JTextField tf, KeyEvent ev) {
            int ik = ev.getKeyCode();

            if (ik == 40) {
                  jls.setSelectedIndex(jls.getSelectedIndex() + 1);
            } else if (ik == 38) {
                  System.out.println("selectedIndex: " + jls.getSelectedIndex());
                  if (jls.getSelectedIndex() <= 0) {
                        jls.setSelectedIndex(jls.getSelectedIndex() - 1);
                  }
            }

            if (jls.getModel().getSize() != 0) {
                  String value = jls.getSelectedValue().toString();
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        tf.setText(value.substring(value.indexOf(":") + 1, value.length()).trim());
                  } else {
                        tf.setText(value);
                  }
            }

      }

      private static void changeIndexWhen(JLabel lb, JTextField tf, JTextField tf0,
              KeyEvent evt, JList lst) {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN
                    || evt.getKeyCode() == KeyEvent.VK_UP) {
                  //IF TAGS ARE ALLOWED
                  if (lb.getText().contains("*")) {
                        changeIndexTAG(lst, tf, evt);
                  } else {
                        changeIndexNoTAG(lst, tf, evt);
                  }
                  //If DIST2 IS IMPLEMENTED
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        if (lst.getModel().getElementAt(0).toString().contains(":")) {
                              //System.out.println(lst.getSelectedValue().toString());
                              String v0 = lst.getSelectedValue().toString();
                              tf0.setText(v0.substring(0, v0.indexOf(":")));
                        }
                  }
            }
      }

      private static void changeIndexWhen(JLabel lb, JTextField tf,
              KeyEvent evt, JList lst) {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN
                    || evt.getKeyCode() == KeyEvent.VK_UP) {
                  //IF TAGS ARE ALLOWED
                  if (lb.getText().contains("*")) {
                        changeIndexTAG(lst, tf, evt);
                  } else {
                        changeIndexNoTAG(lst, tf, evt);
                  }
            }
      }

      public static void keyReleasedN_T(JTextField tf, KeyEvent evt) {
            String text = tf.getText();
            if (text.matches("[0-9]+")) {

                  long nn = Integer.parseInt(tf.getText());

                  if (evt.getKeyCode() == KeyEvent.VK_UP) {
                        if (nn == 1) {
                        } else if (nn > 1) {
                              nn--;
                              tf.setText(Long.toString(nn));
                        }
                  } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (nn < 10000) {
                              nn++;
                              tf.setText(Long.toString(nn));
                        }
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void tf_ConfigDists_K(JLabel lb, JTextField tf0, JTextField tf, JList lst,
              ArrayList<String> list, KeyEvent evt) {

            if (tf.getBackground().equals(new Color(0, 0, 51))
                    || tf.getBackground().equals(new Color(0, 0, 81))) {

                  //System.out.println("\nScrollUpDown");
                  scrollUpDown(lst, evt);
                  //System.out.println("searchFilterWhen");
                  searchFilterWhen(lb, tf, evt, list, lst);
                  //System.out.println("changeIndex");
                  changeIndexWhen(lb, tf, tf0, evt, lst);

            } else {
                  //NO DISTS IMPLEMENTED
                  keyReleasedN_T(tf, evt);
            }
      }

      public static void tf_ConfigDists_K(JLabel lb, JTextField tf, JList lst,
              ArrayList<String> list, KeyEvent evt) {
            if (list.isEmpty()) {
                  System.out.println("\tlist has nothing");
            }

            if (tf.getBackground().equals(new Color(0, 0, 51))
                    || tf.getBackground().equals(new Color(0, 0, 81))) {
                  //System.out.println("\tscrollUpDown // searchFilter // changeIndex");
                  //System.out.println("\nScrollUpDown");
                  scrollUpDown(lst, evt);
                  //System.out.println("searchFilterWhen");
                  searchFilterWhen(lb, tf, evt, list, lst);
                  //System.out.println("changeIndex");
                  changeIndexWhen(lb, tf, evt, lst);

            } else {
                  //NO DISTS IMPLEMENTED
                  keyReleasedN_T(tf, evt);
            }
      }

      public static void lst_ConfigDists_L(DefaultListModel dm, JList lst, JTextField tf0, JTextField tf, JLabel lb,
              ListSelectionEvent evt) {
            if (evt.getValueIsAdjusting() == true) {
                  //IF DIST2 IS IMPLEMENTED
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        //System.out.println("\nis DIST2");
                        String value = lst.getSelectedValue().toString();

                        if (dm.getElementAt(0).toString().contains(":")) {
                              //System.out.println("\tElement does contain > : <");
                              value = lst.getSelectedValue().toString();
                              tf.setText(value.substring(value.indexOf(":") + 2, value.length()));

                              String v1 = value.substring(0, value.indexOf(":"));
                              //tf.setText(v1);
                              tf0.setText(v1);

                              value = value.substring(value.indexOf(":") + 2, value.length());
                        }
                  } else {
                        String value = lst.getSelectedValue().toString();
                        //System.out.println("One list, NO TAG");
                        if (lb.getText().contains("*")) {
                              if (tf.getText().contains(";")) {
                                    String t_f = tf.getText();

                                    tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                                    tf.setText(tf.getText() + value);
                                    //System.out.println("One list, TAG using ; ");
                              } else {
                                    tf.setText(value);
                                    //System.out.println("One list, TAG not using ; ");
                              }
                        } else {
                              tf.setText(value);
                              //System.out.println("One list, NO TAG");
                        }
                  }
            }
      }

      public static void lst_ConfigDists_L(JList lst, JTextField tf0, JTextField tf, JLabel lb,
              ListSelectionEvent evt) {
            //System.out.println("\nlst_ConfigDists_L");
            if (!lst.isSelectionEmpty()) {
                  //IF DIST2 IS IMPLEMENTED
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        //System.out.println("\nis DIST2");
                        String value = lst.getSelectedValue().toString();

                        if (lst.getModel().getElementAt(0).toString().contains(":")) {
                              //System.out.println("\tElement does contain > : <");
                              value = lst.getSelectedValue().toString();
                              tf.setText(value.substring(value.indexOf(":") + 2, value.length()));

                              String v1 = value.substring(0, value.indexOf(":"));
                              //tf.setText(v1);
                              tf0.setText(v1);

                              value = value.substring(value.indexOf(":") + 2, value.length());
                        }
                  } else {//DIST1
                        //System.out.println("LST: ITEMCOUNT: " + lst.getModel().getSize());
                        String value = lst.getSelectedValue().toString();
                        //System.out.println("One list, NO TAG");
                        if (lb.getText().contains("*")) {
                              if (tf.getText().contains(";")) {
                                    String t_f = tf.getText();

                                    tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                                    tf.setText(tf.getText() + value);
                                    //System.out.println("One list, TAG using ; ");
                              } else {
                                    tf.setText(value);
                                    //System.out.println("One list, TAG not using ; ");
                              }
                        } else {
                              tf.setText(value);
                              //System.out.println("One list, NO TAG");
                        }
                  }
            }
      }

      public static void lst_ConfigDists_K(DefaultListModel dm, JList lst, JTextField tf0, JTextField tf, JLabel lb,
              KeyEvent evt) {

            scrollUpDown(lst, evt);

            if (evt.getKeyCode() == KeyEvent.VK_DOWN
                    || evt.getKeyCode() == KeyEvent.VK_UP) {
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        String value = lst.getSelectedValue().toString();

                        if (dm.getElementAt(0).toString().contains(":")) {

                              value = lst.getSelectedValue().toString();
                              tf.setText(value.substring(value.indexOf(":") + 2, value.length()));

                              String v1 = value.substring(0, value.indexOf(":"));
                              tf0.setText(v1);

                              value = value.substring(value.indexOf(":") + 2, value.length());
                        }
                        /*
                        if (lb.getText().contains("*")) {
                              if (tf.getText().contains(";")) {
                                    String t_f = tf.getText();

                                    tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                                    tf.setText(tf.getText() + value);
                                    //System.out.println("Fused list, TAG using ; ");
                              } else {
                                    tf.setText(value);
                                    //System.out.println("Fused list, TAG not using ;");
                              }
                        } else {
                              tf.setText(value);
                              //System.out.println("Fused list, NO TAG");
                        }
                         */
                  } else {
                        String value = lst.getSelectedValue().toString();
                        //System.out.println("One list, NO TAG");
                        if (lb.getText().contains("*")) {
                              if (tf.getText().contains(";")) {
                                    String t_f = tf.getText();

                                    tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                                    tf.setText(tf.getText() + value);
                                    //System.out.println("One list, TAG using ; ");
                              } else {
                                    tf.setText(value);
                                    //System.out.println("One list, TAG not using ; ");
                              }
                        } else {
                              tf.setText(value);
                              //System.out.println("One list, NO TAG");
                        }
                  }
            }
      }

      public static void lst_ConfigDists_K(ListModel dm, JList lst, JTextField tf0, JTextField tf, JLabel lb,
              KeyEvent evt) {

            scrollUpDown(lst, evt);

            if (evt.getKeyCode() == KeyEvent.VK_DOWN
                    || evt.getKeyCode() == KeyEvent.VK_UP) {
                  if (tf.getBackground().equals(new Color(0, 0, 81))) {
                        String value = lst.getSelectedValue().toString();

                        if (dm.getElementAt(0).toString().contains(":")) {

                              value = lst.getSelectedValue().toString();
                              tf.setText(value.substring(value.indexOf(":") + 2, value.length()));

                              String v1 = value.substring(0, value.indexOf(":"));
                              tf0.setText(v1);

                              value = value.substring(value.indexOf(":") + 2, value.length());
                        }
                        /*
                        if (lb.getText().contains("*")) {
                              if (tf.getText().contains(";")) {
                                    String t_f = tf.getText();

                                    tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                                    tf.setText(tf.getText() + value);
                                    //System.out.println("Fused list, TAG using ; ");
                              } else {
                                    tf.setText(value);
                                    //System.out.println("Fused list, TAG not using ;");
                              }
                        } else {
                              tf.setText(value);
                              //System.out.println("Fused list, NO TAG");
                        }
                         */
                  } else {
                        String value = lst.getSelectedValue().toString();
                        //System.out.println("One list, NO TAG");
                        if (lb.getText().contains("*")) {
                              if (tf.getText().contains(";")) {
                                    String t_f = tf.getText();

                                    tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                                    tf.setText(tf.getText() + value);
                                    //System.out.println("One list, TAG using ; ");
                              } else {
                                    tf.setText(value);
                                    //System.out.println("One list, TAG not using ; ");
                              }
                        } else {
                              tf.setText(value);
                              //System.out.println("One list, NO TAG");
                        }
                  }
            }
      }

      public static void tf_ConfigDists_M(JLabel lb, JTextField tf, JList lst, DefaultListModel dm,
              ArrayList<String> list) {

            if (tf.getBackground().equals(new Color(0, 0, 51))
                    || tf.getBackground().equals(new Color(0, 0, 81))) {
                  if (lb.getText().contains("*")) {
                        //IF IS ALREADY A TAG > ; <
                        if (tf.getText().contains("; ")) {
                              String textf = tf.getText();

                              //SEARCH AFTER PREVIOS TAG
                              searchFilter(textf.substring(textf.lastIndexOf("; ") + 2),
                                      list, lst);
                        } else {
                              //WITHOUT TAG
                              //NORMAL SEARCH WITH NO TAG
                              searchFilter(tf.getText(), list, lst);
                        }
                  } else {
                        //NORMAL SEARCH WITH NO TAGS ALLOWED
                        searchFilter(tf.getText(), list, lst);
                  }
            }
      }

}
