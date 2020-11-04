/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import org.apache.commons.lang3.SerializationUtils;

/**
 *
 * @author Christopher
 */
public class test {
      int rows = 6;
      String[] headers = new String[]{"A","B"};
      String[] components = new String[]{"a", "b"};
      
      String[][] compList = new String[rows + 1][components.length];
      
      public test(){
            for (int a = 0; a < rows + 1; a++) {
                  for (int b = 0; b < components.length; b++) {
                        //compList[a][b] = cloneSwingComponent(components[a]);
                        if (a == 0) {
                              compList[a][b] = headers[b];
                        } else {
                              compList[a][b] = SerializationUtils.clone(components[b]);
                        }
                  }
            }
            for(int a = 0; a < rows + 1; a++){
                  for(int b = 0; b < components.length; b++){
                        System.out.println((a + 1) + "." + (b + 1) + ": " + compList[a][b]);
                  }
            }
      }
      public static void main(String[] args){
            new test();
      }
}
