/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Christopher
 */
public class MList {
      
      public static void add_SetDefaultListModel(JList lst, ArrayList<String> list, DefaultListModel dlm, boolean b) {
            lst.setModel(dlm);
            if (b == true) {
                  for (int a = 0; a < list.size(); a++) {
                        dlm.addElement(list.get(a));
                  }
            }
      }
      
      public static void mixRowList(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3, String conn) {
            list3.clear();
            for (int c = 0; c < list.size(); c++) {
                  list3.add(list.get(c) + conn + list2.get(c));
            }
      }
      
      public static void unTagList(ArrayList<String> list) {
            //Separate elements with ; (TAG)
            String sub1;
            String sub2;
            //System.out.println("MList Size Before: " + list.size());
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
      
      public static void printFor(ArrayList<String> list) {
            if (list.isEmpty()) {
                  System.out.println("the list has no elements");
            } else {
                  for (int a = 0; a < list.size(); a++) {
                        System.out.println("element " + a + ": " + list.get(a));
                  }
            }
      }
}

