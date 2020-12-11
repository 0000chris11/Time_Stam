/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.mTFControl;

import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class MTXControlData {

      public ArrayList<Storage> Lists = new ArrayList<Storage>();

      public static final int CONTAIN_MATCH = 1;
      public static final int EQUAL_MATCH = 2;
      public static final int DUPLICATED_ELEMENTS = 3;

      public static ArrayList<Integer> list_MI = new ArrayList<Integer>();

      public IKeyMatchActions3 ac;
      
      public void addList(ArrayList<String> list, int option) {
            Lists.add(new Storage(list, option));
            list_MI.add(-1);
      }

      public void setMinusIndex(int listID, int minusIndex) {
            list_MI.set(listID, minusIndex);
      }
}
