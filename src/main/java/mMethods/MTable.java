/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mMethods;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Christopher
 */
public class MTable {
      
    public static int getMayorId(JTable jt, int col) {
            Object data;
            int valor;
            int mayor = 0;
            
            for (int a = 0; a < jt.getRowCount(); a++) {
                  data = jt.getValueAt(a, col);
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
    
    public static void typeConvert(JTable JT, ArrayList<String> list, int row) {
            list.clear();
            Object oo;
            String aaa;
            int bbb;
            for (int a = 0; a < JT.getColumnCount(); a++) {
                  oo = JT.getValueAt(row, a);
                  if (oo instanceof String) {
                        aaa = (String) oo;
                        list.add(aaa);
                  } else if (oo instanceof Integer) {
                        bbb = (int) oo;
                        list.add(Integer.toString(bbb));
                  }
            }
      }
    
    public static void typeConvert(JTable JT, int row){
            Object oo;
            String aaa;
            int bbb;
            for (int a = 0; a < JT.getColumnCount(); a++) {
                  oo = JT.getValueAt(row, a);
                  if (oo instanceof String) {
                        aaa = (String) oo;
                        JT.setValueAt(aaa, row, a);
                  } else if (oo instanceof Integer) {
                        bbb = (int) oo;
                        JT.setValueAt(bbb, row, a);
                  }
            }
      }
}
