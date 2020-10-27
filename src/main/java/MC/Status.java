package MC;


import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Status {

      private Status(){
            throw new IllegalStateException("Private Constructor");
      }
      
      public static void startLBStatus(JLabel status, Color c, String ex, int time) {
            Thread t1 = new Thread(new Runnable() {
                  public void run() {
                        status.setForeground(c);
                        status.setText(ex);
                        
                        try {
                              Thread.sleep(time);

                        } catch (InterruptedException ex1) {
                              ex1.printStackTrace();
                        }
                        status.setForeground(Color.WHITE);
                        status.setText("Waiting for action...");
                  }
            });
            t1.start();
      }
}
