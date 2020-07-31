package Copy;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListModel;

public class Lots {

      public static void mixList(ArrayList<String> list, ArrayList<String> list2,
              /*Map<String, String> m*/ ArrayList<String> list3) {
            list3.clear();

            for (int c = 0; c < list.size(); c++) {

                  //listc = list.get(c).toString() + " (" + tList.get(c).toString() + ")";
                  list3.add(list.get(c) + " (" + list2.get(c) + ")");
            }
      }

      public static void searchFilter(String text, ArrayList<String> list, JList lst) {
            //System.out.println("\t\tsearchFilter");
            DefaultListModel filteredItems = new DefaultListModel();

            ArrayList<String> tList = list;
            if(list.isEmpty()){
                  System.out.println("\t\t\tList has nothing");
            }
            for (int a = 0; a < tList.size(); a++) {
                  //System.out.println("\t\t\t" + a + ": " + tList.get(a));
                  if (tList.get(a).toLowerCase().contains(text.toLowerCase())) {
                        
                        filteredItems.addElement(list.get(a));
                  }
            }
            
            //ListModel lm = lst.getModel();
            DefaultListModel lm2 = filteredItems;
            lst.setModel(lm2);
      }

      //WITH TAG SYS
      public static void changeIndex(JList jls, JTextField tf, KeyEvent ev) {
            int ik = ev.getKeyCode();

            if (ik == 40) {
                  jls.setSelectedIndex(jls.getSelectedIndex() + 1);
            } else if (ik == 38) {
                  jls.setSelectedIndex(jls.getSelectedIndex() - 1);
            }

            if (tf.getText().contains(";")) {
                  String text = tf.getText();
                  tf.setText(text.substring(0, text.lastIndexOf(";") + 2));

                  tf.setText(tf.getText() + jls.getSelectedValue().toString());
                  //}
            } else {
                  if (ev.getKeyCode() != KeyEvent.VK_F5) {

                        tf.setText(jls.getSelectedValue().toString());
                  }
            }
      }

      //SUPPOSE TAG-SYS
      public static void changeIndexWithN(JList jls, JTextField tf, KeyEvent ev) {
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
                  tf.setText(tf.getText() + text0.substring(text0.indexOf(":") + 1, text0.length()));
                  
                  //}
            } else {
                  String value = jls.getSelectedValue().toString();
                  tf.setText(value.substring(value.indexOf(":") + 1, value.length()).trim());
            }
      }
      //WITH TAG SYS

      public static void changeIndexWithPRNTS(JList lst, JTextField tf, KeyEvent ev) {
            int ik = ev.getKeyCode();

            if (ik == 40) {
                  lst.setSelectedIndex(lst.getSelectedIndex() + 1);
            } else if (ik == 38) {
                  lst.setSelectedIndex(lst.getSelectedIndex() - 1);
            }

            if (tf.getText().contains(";")) {
                  //System.out.println("1st Step");
                  String text = tf.getText();
                  tf.setText(text.substring(0, text.lastIndexOf(";") + 2));

                  //System.out.println("2nd Step");
                  String text0 = lst.getSelectedValue().toString();
                  tf.setText(tf.getText() + text0.substring(0, text0.lastIndexOf("(") - 1));

            } else {
                  if (ev.getKeyCode() != KeyEvent.VK_F5) {
                        String text = lst.getSelectedValue().toString();
                        tf.setText(text.substring(0, text.indexOf("(") - 1));
                  }
            }
      }

      //WITH TAG SYS
      public static void changeIndexWithMix(JList<String> lst, JTextField tf, KeyEvent ev) {
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            int ik = ev.getKeyCode();

            if (ik == 40) {
                  lst.setSelectedIndex(lst.getSelectedIndex() + 1);
            } else if (ik == 38) {
                  lst.setSelectedIndex(lst.getSelectedIndex() - 1);
            }

            if (tf.getText().contains(";")) {
                  //System.out.println("1st Step");
                  String text = tf.getText();
                  tf.setText(text.substring(0, text.lastIndexOf(";") + 2));

                  //System.out.println("2nd Step");
                  if (lst.getSelectedValue().contains("(")) {
                        String text0 = lst.getSelectedValue().toString();
                        tf.setText(tf.getText() + text0.substring(0, text0.lastIndexOf("(") - 1));
                  } else {
                        String text0 = lst.getSelectedValue().toString();
                        tf.setText(tf.getText() + text0);
                  }

            } else {
                  if (ev.getKeyCode() != KeyEvent.VK_F5) {
                        if (lst.getSelectedValue().contains("(")) {
                              String text = lst.getSelectedValue().toString();
                              tf.setText(text.substring(0, text.indexOf("(") - 1));
                        } else {
                              tf.setText(lst.getSelectedValue().toString());
                        }
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      }

      public static void addSet(JList jl, DefaultListModel dlm, ArrayList al) {
            jl.setModel(dlm);

            for (int a = 0; a < al.size(); a++) {
                  dlm.addElement(al.get(a));
            }
      }

      public static void ky3(JList lst, JTextField tf, ArrayList<String> list,
              KeyEvent ev, String chg) {
            if (ev.getKeyCode() == KeyEvent.VK_DOWN) { // SCROLL DOWN & UP
                  lst.ensureIndexIsVisible(lst.getSelectedIndex() + 1);
            } else if (ev.getKeyCode() == KeyEvent.VK_UP) {
                  lst.ensureIndexIsVisible(lst.getSelectedIndex() - 1);
            }

            if (ev.getKeyCode() == KeyEvent.VK_DOWN // TAG SYSTEM FOR ChangeIndex
                    || ev.getKeyCode() == KeyEvent.VK_UP) {
                  if (chg.equals("Normal")) {
                        changeIndex(lst, tf, ev);
                  } else if (chg.equals("Number")) {
                        changeIndexWithN(lst, tf, ev);
                  } else if (chg.equals("withPRNTS")) {
                        changeIndexWithPRNTS(lst, tf, ev);
                  } else if (chg.equals("Mix")) {
                        changeIndexWithMix(lst, tf, ev);
                  }
            }
            if (ev.getKeyCode() == KeyEvent.VK_LEFT //TAG SYSTEM FOR SEARCHFILTER
                    || ev.getKeyCode() == KeyEvent.VK_RIGHT
                    || ev.getKeyCode() == KeyEvent.VK_DOWN
                    || ev.getKeyCode() == KeyEvent.VK_UP
                    || ev.getKeyCode() == KeyEvent.VK_F5) {
            } else {
                  if (tf.getText().contains("; ")) {
                        String textf = tf.getText();
                        searchFilter(textf.substring(textf.lastIndexOf(";") + 2),
                                list, lst);
                  } else {
                        searchFilter(tf.getText(), list, lst);
                  }

            }
      }

      //CHANGEINDEX FOR LST++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void lst_PointC(JTextField tf, JList lst, KeyEvent ev) {
            if (ev.getKeyCode() == KeyEvent.VK_UP
                    || ev.getKeyCode() == KeyEvent.VK_DOWN) {
                  if (tf.getText().contains(";")) {
                        String t_f = tf.getText();

                        tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                        tf.setText(tf.getText() + lst.getSelectedValue().toString());
                  } else {
                        tf.setText(lst.getSelectedValue().toString());
                  }
            }

      }

      public static void lst_PointC(JTextField tf, JList lst, ListSelectionEvent ev) {
            if (ev.getValueIsAdjusting() == true) {
                  if (tf.getText().contains(";")) {

                        String t_f = tf.getText();
                        tf.setText(t_f.substring(0, t_f.lastIndexOf(";") + 2));

                        tf.setText(tf.getText() + lst.getSelectedValue().toString());
                  } else {
                        tf.setText(lst.getSelectedValue().toString());
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      //BLOCK BUTTON_ADD
      public static void compLST_ADDP(JTextField tf, ArrayList<String> list, JButton btn) {
            int z = 0;
            if (tf.getText().equals("") || tf.getText().contains(";")) {
                  z = 1;
            } else {

                  for (int a = 0; a < list.size(); a++) {
                        if (list.get(a).contains("(")) {
                              if (list.get(a).substring(0, list.get(a).indexOf("(") - 1)
                                      .equals(tf.getText())) {
                                    z = 1;
                              } else {
                                    if (z == 1) {
                                    } else {
                                          z = 0;
                                    }
                              }
                        } else {
                              if (list.get(a).equals(tf.getText())) {
                                    z = 1;
                              } else {
                                    if (z == 1) {
                                    } else {
                                          z = 0;
                                    }
                              }
                        }
                  }
            }
            if (z >= 1) {
                  btn.setForeground(Color.GRAY);
                  btn.setEnabled(false);
            } else if (z == 0) {
                  btn.setForeground(Color.BLACK);
                  btn.setEnabled(true);
            }

      }
}
