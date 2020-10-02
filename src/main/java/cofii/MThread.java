/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofii;

/**
 *
 * @author Christopher
 */
public class MThread {
      
      public static void threadHandle(Thread t) {
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
}
