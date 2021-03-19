/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Christopher
 */
public class RBFKComponent extends ComponentAdapter{
      
      @Override
      public void componentHidden(ComponentEvent e) {
            RBFKModel.action();
      }

      @Override
      public void componentShown(ComponentEvent e) {
            RBFKModel.action();
      }
}
