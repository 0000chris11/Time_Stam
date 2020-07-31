package MC;

import First.VF;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Status {

      public void startLBStatus(JLabel status, Color c, String ex, int time) {
            Thread t1 = new Thread(new Runnable() {
                  public void run() {
                        status.setForeground(c);
                        status.setText(ex);
                        
                        try {
                              Thread.sleep(time);

                        } catch (InterruptedException ex1) {
                              Logger.getLogger(VF.class
                                      .getName()).log(Level.SEVERE, null, ex1);
                        }
                        status.setForeground(Color.WHITE);
                        status.setText("Waiting for action...");
                  }
            });
            t1.start();
      }
}
