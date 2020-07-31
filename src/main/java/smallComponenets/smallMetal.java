/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalButtonUI;

/**
 *
 * @author Christopher
 */
public class smallMetal extends MetalButtonUI {

      @Override
      public void update(Graphics g, JComponent c) {
            AbstractButton button = (AbstractButton) c;
            if ((c.getBackground() instanceof UIResource)
                    && button.isContentAreaFilled() && c.isEnabled()) {
                  ButtonModel model = button.getModel();
                  //if (!MetalUtils.isToolBarButton(c)) {
                        
                  //}
            }
      }
      public smallMetal(){
            //this.u
      }
}
