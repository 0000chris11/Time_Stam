package MC;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import First.VF_R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodM {

      String CName = this.getClass().getName();
      
      Connection con;
      //Data DT = new Data("MethodM");

      public MethodM(String from, int CC) {
            DT.getConstructorName(DT.cons, CName, from, CC);
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public int getComponentIndex(Component component) {
            Container c = component.getParent();
            for (int a = 0; a < c.getComponentCount(); a++) {
                  if (c.getComponent(a) == component) {
                        return a;
                  }
            }
            return -1;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void printListSelectionListeners(JList lst) {
            System.out.println("\n" + lst.getName() + " ListSelectionListeners count: "
                    + lst.getListSelectionListeners().length);
            for (int a = 0; a < lst.getListSelectionListeners().length; a++) {
                  System.out.println("\t" + lst.getName() + " " + a + ": " + lst.getListSelectionListeners()[a].toString());
            }
      }

      public void printListSelectionListeners(JTable jt) {
            DefaultListSelectionModel dlsm = (DefaultListSelectionModel) jt.getSelectionModel();
            System.out.println("\n" + jt.getName() + " ListSelectionListeners count: "
                    + dlsm.getListSelectionListeners().length);
            for (int a = 0; a < dlsm.getListSelectionListeners().length; a++) {
                  System.out.println("\t" + jt.getName() + " " + a + ": " + dlsm.getListSelectionListeners()[a].toString());
            }
      }

      public void printKeyListeners(JComponent jc) {
            System.out.println("\n" + jc.getName() + " KeyListeners count: "
                    + jc.getKeyListeners().length);
            for (int a = 0; a < jc.getKeyListeners().length; a++) {
                  System.out.println("\t" + jc.getName() + " " + a + ": " + jc.getKeyListeners()[a].toString());
            }
      }

      public void printFocusListeners(JComponent jc) {
            System.out.println("\n" + jc.getName() + " FocusListeners count: "
                    + jc.getFocusListeners().length);
            for (int a = 0; a < jc.getFocusListeners().length; a++) {
                  System.out.println("\t" + jc.getName() + " " + a + ": " + jc.getFocusListeners()[a].toString());
            }
      }

      public void printMouseListeners(JComponent jc) {
            System.out.println("\n" + jc.getName() + " MouseListeners count: "
                    + jc.getMouseListeners().length);

            for (int a = 0; a < jc.getMouseListeners().length; a++) {
                  System.out.println("\t" + jc.getName() + " " + a + ": " + jc.getMouseListeners()[a].toString());
            }
      }

      public void printTableModelListeners(DefaultTableModel dtm) {
            System.out.println("\nTableModelListeners count: " + dtm.getTableModelListeners().length);

            for (int a = 0; a < dtm.getTableModelListeners().length; a++) {
                  System.out.println("\t" + a + ": " + dtm.getTableModelListeners()[a].toString());
            }
      }

      public void printActionListeners(JButton jb) {
            System.out.println("\n" + jb.getName() + " ActionListeners count: " + jb.getActionListeners().length);

            for (int a = 0; a < jb.getActionListeners().length; a++) {
                  System.out.println("\t" + a + ": " + jb.getActionListeners()[a].toString());
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static boolean getMatch(String text, String comp) {
            Pattern pat = Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE);
            Matcher match = pat.matcher(comp);
            return match.find();
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void scrollUpDown(JList lst, KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                  lst.ensureIndexIsVisible(lst.getSelectedIndex() + 1);
            } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                  lst.ensureIndexIsVisible(lst.getSelectedIndex() - 1);
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
                  //ADDS ONLY THE ELEMENTS THAT MATCH
                  if (tList.get(a).toLowerCase().contains(text.toLowerCase())) {
                        
                        filteredItems.addElement(list.get(a));
                  }
            }
            
            //ListModel lm = lst.getModel();
            DefaultListModel lm2 = filteredItems;
            lst.setModel(lm2);
      }

      public void searchFilterWhen(JLabel lb, JTextField tf, KeyEvent evt,
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

      public static void changeIndexTAG(JList jls, JTextField tf, KeyEvent ev) {
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

      public static void changeIndexNoTAG(JList jls, JTextField tf, KeyEvent ev) {
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

      public void changeIndexWhen(JLabel lb, JTextField tf, JTextField tf0,
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

      public void changeIndexWhen(JLabel lb, JTextField tf,
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

      public void keyReleasedN_T(JTextField tf, KeyEvent evt) {
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
      public void tf_ConfigDists_K(JLabel lb, JTextField tf0, JTextField tf, JList lst,
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

      public void tf_ConfigDists_K(JLabel lb, JTextField tf, JList lst,
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

      public void lst_ConfigDists_L(DefaultListModel dm, JList lst, JTextField tf0, JTextField tf, JLabel lb,
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

      public void lst_ConfigDists_L(JList lst, JTextField tf0, JTextField tf, JLabel lb,
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

      public void lst_ConfigDists_K(DefaultListModel dm, JList lst, JTextField tf0, JTextField tf, JLabel lb,
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

      public void lst_ConfigDists_K(ListModel dm, JList lst, JTextField tf0, JTextField tf, JLabel lb,
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

      public void tf_ConfigDists_M(JLabel lb, JTextField tf, JList lst, DefaultListModel dm,
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

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void add_Set(JList lst, ArrayList<String> list, DefaultListModel dlm, boolean b) {
            lst.setModel(dlm);
            if (b == true) {
                  for (int a = 0; a < list.size(); a++) {
                        dlm.addElement(list.get(a));
                  }
            }
      }

      public void mixList(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3) {
            list3.clear();
            for (int c = 0; c < list.size(); c++) {
                  list3.add(list.get(c) + ": " + list2.get(c));
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void resetTF_LB(JTextField tf, JLabel lb) {
            if (lb != null) {
                  tf.setBackground(new Color(51, 51, 51));
                  tf.setSize(290, tf.getHeight());

                  String l = lb.getText();
                  if (l.contains("*")) {
                        lb.setText(l.substring(l.indexOf("*") + 1, l.length()));
                  }
            } else {//TF_1 CASE
                  tf.setSize(70, tf.getHeight());
            }
      }

      public void resetClock(JTextField MD, JTextField MU, JTextField SD, JTextField SU,
              JLabel D2) {
            MD.setText("0");
            MU.setText("0");
            SD.setText("0");
            SU.setText("0");

            D2.setVisible(false);
            MD.setVisible(false);
            MU.setVisible(false);
            SD.setVisible(false);
            SU.setVisible(false);

      }

      public void shortenLB(JLabel lb) {
            if (lb.getText().length() >= 10) {
                  String somet = lb.getText().substring(0, 10);
                  lb.setText(somet + "...");
            }
      }

      public String filterTableName(String table, String op) {
            //System.out.println(CC.PURPLE + "FilterTableName" + CC.RESET);
            //System.out.println("\tTable: " + table);
            if (op.equals("ADD")) {
                  if (table.contains(" ")) {
                        //table.replaceAll(" ", "_");
                        table = table.replaceAll(" ", "_");
                  }
            } else if (op.equals("TAKE")) {
                  if (table.contains("_")) {
                        //table.replaceAll(" ", "_");
                        table = table.replaceAll("_", " ");
                  }
            }
            //System.out.println("\tTable: " + table);
            return table;
      }

      public void unTagList(ArrayList<String> list) {
            String sub1;
            String sub2;
            //System.out.println("List Size Before: " + list.size());
            for (int a = 0; a < list.size(); a++) {
                  //System.out.println("- - - - - - " + a + " >" + list.get(a));
                  if (list.get(a).contains(";")) {
                        sub1 = list.get(a).substring(0, list.get(a).indexOf(";"));
                        sub2 = list.get(a).substring(list.get(a).indexOf(";") + 2, list.get(a).length());

                        list.add(sub1);
                        list.add(sub2);

                        list.remove(a);

                        a--;
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++
            ArrayList<String> copy = new ArrayList<String>();
            copy.addAll(list);

            Set<String> set = new LinkedHashSet<>(copy);

            copy = new ArrayList<String>(set);
            Collections.sort(copy);

            list.clear();
            list.addAll(copy);
      }

      public int getMayorId(JTable jt) {
            Object data;
            int valor;
            int mayor = 0;
            for (int a = 0; a < jt.getRowCount(); a++) {
                  data = jt.getValueAt(a, 0);
                  if (data instanceof String) {
                        //System.out.println("\tID " + a + " is Instanceof of String");
                  } else if (data instanceof Integer) {
                        //System.out.println("\tID " + a + " Instanceof Integer");
                  }
                  valor = (Integer) data;
                  if (valor > mayor) {
                        mayor = valor;
                  }
            }
            return mayor;
      }

      public void typeConvert() {
            int selectedRow = VF_R.getJT().getSelectionModel().getMinSelectionIndex();

            DT.getList_R().clear();
            Object oo;
            String aaa;
            int bbb;
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  oo = VF_R.getJT().getValueAt(selectedRow, a);
                  if (oo instanceof String) {
                        aaa = (String) oo;
                        DT.getList_R().add(aaa);
                  } else if (oo instanceof Integer) {
                        bbb = (int) oo;
                        DT.getList_R().add(Integer.toString(bbb));
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void setImageIcon(JButton btn, String url) {
            ImageIcon ic = new ImageIcon(url);
            Icon i = (Icon) ic;
            btn.setIcon(i);
      }

      public ImageIcon resizeIcon(ImageIcon ii) {
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            BufferedImage bimage = new BufferedImage(225, 225, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bimage.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(ii.getImage(), 0, 0, 225, 225, null);

            ImageIcon icon2 = new ImageIcon(bimage);

            //System.out.println("------------------------Icon2 Width: " + icon2.getIconWidth() + "\tHeight: " + icon2.getIconHeight());
            return icon2;
            //++++++++++++++++++++++++++++++++++++++++++++++++++
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void printFor(ArrayList<String> list) {
            if (list.isEmpty()) {
                  System.out.println("the list has no elements");
            } else {
                  for (int a = 0; a < list.size(); a++) {
                        System.out.println("element " + a + ": " + list.get(a));
                  }
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void threadHandle(Thread t) {
            System.out.println("\nState: " + t.getState().toString());
            if (t.isAlive()) {
                  System.out.println("\tThread is Alive");
            } else {
                  System.out.println("\tThread is Dead");
            }
            if (t.isInterrupted()) {
                  System.out.println("\tThread is Interrupted");
            } else {
                  System.out.println("\tThread is NOT Interrupted");
            }
      }

      //public void testing() {
      //     System.out.println("TESTED");
      //}
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void setButtonColorWhenPress(MouseEvent evt) {

      }

      public static void main(String[] args) {
            //System.out.println("MethodM STAR");
      }
}
