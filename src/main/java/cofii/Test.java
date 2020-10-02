/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofii;

import javax.swing.JList;

/**
 *
 * @author COFII
 */
public class Test {
      public static void main(String[] args){
            JList<String> list = new JList<String>(new String[]{"this", "that", "there"});
            System.out.println(list.getModel().getElementAt(1));
      }
}
