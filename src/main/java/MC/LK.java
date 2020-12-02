/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author C0FII
 */
public class LK {
      
      private LK(){
            throw new IllegalStateException("Private Constructor");
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static final Dimension MAIN_FRAME_SIZE = new Dimension(1270, 627);
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static final Color CP_BK_NORMAL = new Color(51, 51, 51);
      public static final Color CP_BK_DIST1 = new Color(0, 0, 51);
      public static final Color CP_BK_DIST2 = new Color(0, 0, 81);
      public static final Color CP_BK_AUTO_INCR_IDEN = new Color(14, 150, 199);
      
      public static final Font CP_FONT_NORMAL = new Font("Dialog", Font.BOLD, 16);
      public static final String CP_TEXT_AUTO_INCREMENT = "AUTO_INCREMENT";
      public static final Font CP_FONT_AUTO_INCREMENT = new Font("Dialog", Font.ITALIC, 16);
      public static final Color CP_FOREGROUND_AUTO_INCREMENT = Color.GRAY;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public final static Border MARGIN_DEFAULT = new EmptyBorder(1, 3, 1, 3);      
      public final static Border BORDER_LINE_FOCUS_OFF = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
      public final static Border BORDER_LINE_FOCUS_ON = BorderFactory.createLineBorder(Color.WHITE, 2);
      
      public final static CompoundBorder BORDER_LINEMARIGIN_FOCUS_OFF = new CompoundBorder(
              BORDER_LINE_FOCUS_OFF, MARGIN_DEFAULT);
      public final static CompoundBorder BORDER_LINEMARIGIN_FOCUS_ON = new CompoundBorder(
              BORDER_LINE_FOCUS_ON, MARGIN_DEFAULT);
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private static final Color CUSTOM_CYAN = new Color(37,161,231);
      public static final Color[] GP_BLACK_AND_DARK_RED = new Color[]{Color.BLACK, new Color(102,0,0)};
      public static final Color[] GP_WHITE_AND_CYAN = new Color[]{Color.WHITE, CUSTOM_CYAN};
      public static final Color[] GP_CYAN_AND_WHITE = new Color[]{CUSTOM_CYAN, Color.WHITE};
      public static final Color[] GP_GREEN_AND_WHITE = new Color[]{Color.GREEN, Color.WHITE};
      public static final Color[] GP_YELLOW_AND_WHITE = new Color[]{Color.YELLOW, Color.WHITE};
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void setClientProperties(){
            
      }
}
