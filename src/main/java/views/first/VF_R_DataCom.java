package views.first;

import MC.DT;
import com.cofii.myMethods.MCell;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.GradientPaint;
import java.util.EventObject;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import smallComponenets.JPanelGradient;
import smallComponenets.smallBTN_C;

/**
 *
 * @author C0FII
 */
public class VF_R_DataCom {

      //+++++++++++++++++++++++++++++++++++++++++++
      static JFrame JF = new JFrame("Time Stamp");
      //============================================================
      static JSplitPane SPL = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      
      static JSplitPane SPL_SUB = new JSplitPane(JSplitPane.VERTICAL_SPLIT);    
      static JPanel PL_U = new JPanel();
      static JLabel lb_PL = new JLabel("No Table Selected");
      static JPanel PL_UT = new JPanel();
      static JPanel PL_UC = new JPanelGradient(DT.GP_blackRed);
      static JScrollPane sc_PL_UC = new JScrollPane(PL_UC);
      
      static JPanel PL_B = new JPanel();
      static JScrollPane sc_PL_B = new JScrollPane(PL_B);
      static JLabel lb_Icon = new JLabel("NO ICON SELECTED");
      static JProgressBar JPB = new JProgressBar();
      
      static JTable JT = new JTable();
      static JLabel lb_JT = new JLabel("NO ROWS INSERTED", SwingConstants.CENTER);
      static JScrollPane sc_JT = new JScrollPane(JT);
      //============================================================    
      static JPanel p3 = new JPanel();

      static JToolBar TB = new JToolBar() {
            @Override
            public void paintComponents(Graphics g) {
                  super.paintComponents(g);
                  Graphics2D g2 = (Graphics2D) g;
                  g2.setPaint(new GradientPaint(
                          0, 0, Color.BLACK,
                          getWidth(), getHeight(),
                          new Color(0, 204, 204)));
                  g2.fillRect(0, 0, getWidth(), getHeight());
            }
      };
      //+++++++++++++++++++++++++++++++++++
      public static final String JPL_layout = "Group Layout";
      //+++++++++++++++++++++++++++++++++++
      static JMenuBar JMB = new JMenuBar();

      static JMenu JM_Options = new JMenu("Options");

      static JMenuItem mi_changeLogin = new JMenuItem("Change Login or DB");
      
      static JMenu JMS_ShowList = new JMenu("Show List");
      JMenuItem mi_STables = new JMenuItem("Tables");
      JMenuItem mi_SColumns = new JMenuItem("Columns");
      JMenuItem mi_SDists = new JMenuItem("Dists");
      JMenuItem mi_SListD = new JMenuItem("ListD");
      JMenuItem mi_SJFComponents = new JMenuItem("JF Components");
      JMenuItem mi_SP1Components = new JMenuItem("P1 Components");

      static JMenu JMS_ShowListeners = new JMenu("Show Listener");
      JMenuItem mi_S_JTFS_FL = new JMenuItem("JTextFields FL");
      JMenuItem mi_S_JTFS_KL = new JMenuItem("JTextFields KL");
      JMenuItem mi_S_JTFS_ML = new JMenuItem("JTextFields ML");
      JMenuItem mi_S_JLSTS_LSL = new JMenuItem("JLists LSL");
      JMenuItem mi_S_JLSTS_FL = new JMenuItem("JLists FL");

      Separator sep0 = new Separator();
      static JCheckBoxMenuItem mi_AOT = new JCheckBoxMenuItem("Always On Top");
      static JCheckBoxMenuItem mi_AutoR = new JCheckBoxMenuItem("Auto-Resize");
      static JCheckBoxMenuItem mi_Grid = new JCheckBoxMenuItem("Show Grid");
      Separator sep1 = new Separator();
      static JMenuItem mi_SaveOp = new JMenuItem("Save Options");

      static JMenu JM_Select = new JMenu("Select");

      JMenu JM_Table = new JMenu("Table");
      static JMenu JMS_ChangeDTable = new JMenu("Change Default Table");
      Separator sep3 = new Separator();
      static JMenuItem mi_CreateTable = new JMenuItem("Create Table");
      static JMenuItem mi_UpdateTable = new JMenuItem("Update Table");
      static JMenuItem mi_DeleteTables = new JMenuItem("Delete Tables");
      static JMenuItem mi_DeleteThisTable = new JMenuItem("Delete this Table");
      //+++++++++++++++++++++++++++++++++++
      static JButton btn_minus = new smallBTN_C("-");
      static JButton btn_plus = new smallBTN_C("+");
      static JButton[] btns_MC = new JButton[]{
            new smallBTN_C("ADD"), new smallBTN_C("UPDATE"),
            new smallBTN_C("DELETE"), new smallBTN_C("FIND")};
      //+++++++++++++++++++++++++++++++++++
      static JLabel lb_Status = new JLabel("Waiting for Action...");
      static JToggleButton btn_Show_All = new JToggleButton("Show All");

      static JLabel lb_Title = new JLabel("No Table Selected");
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_C = new JButton[DT.maxColumns];
      static JScrollPane[] scs = new JScrollPane[DT.maxColumns];
      static JList[] lsts = new JList[DT.maxColumns];

      static JButton[] btns_TB = new JButton[]{new smallBTN_C(""), new smallBTN_C("")};
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      static JPanel[] clocks = new JPanel[DT.maxColumns];
      static JTextField[] tfs_MD = new JTextField[DT.maxColumns];
      static JTextField[] tfs_MU = new JTextField[DT.maxColumns];      
      static JTextField[] tfs_SD = new JTextField[DT.maxColumns];
      static JTextField[] tfs_SU = new JTextField[DT.maxColumns];
      static JLabel[] lb_2ds = new JLabel[DT.maxColumns];
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      static boolean getDefault = true;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      static JTextField tf_ce = new JTextField();
      static DefaultCellEditor DTCellEditor = new DefaultCellEditor(tf_ce) {
            @Override
            public boolean isCellEditable(EventObject anEvent) {                  
                  return MCell.getCharacterInputandDefault(anEvent, 
                          super.isCellEditable(anEvent));
            }
      };

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static JFrame getJF() {
            return JF;
      }
      
      public static JSplitPane getSPL(){
            return SPL;
      }

      public static JSplitPane getSPL_SUB(){
            return SPL_SUB;
      }
      
      public static JPanel getPL() {
            return PL_U;
      }
      
      public static JPanel getPL_T(){
            return PL_UT;
      }

      public static JPanel getPL_UC(){
            return PL_UC;
      }
      public static JPanel getP3() {
            return p3;
      }

      public static JTable getJT() {
            return JT;
      }

      public static JLabel getLB_JT() {
            return lb_JT;
      }

      public static JToolBar getTB() {
            return TB;
      }

      public static JMenuBar getJMB() {
            return JMB;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static JToggleButton getBTN_Show_All() {
            return btn_Show_All;
      }

      public static JLabel getLB_Title() {
            return lb_Title;
      }

      public static JScrollPane getSC_JT() {
            return sc_JT;
      }

      //+++++++++++++++++++++++++++++++++++++++++++
      public static JLabel getLB_Icon() {
            return lb_Icon;
      }

      public static JProgressBar getJPB() {
            return JPB;
      }

      //+++++++++++++++++++++++++++++++++++++++++++
      public static JLabel getLB_Status() {
            return lb_Status;
      }

      public static JTextField[] getTFS_MD() {
            return tfs_MD;
      }

      public static JTextField[] getTFS_MU() {
            return tfs_MU;
      }

      public static JTextField[] getTFS_SD() {
            return tfs_SD;
      }

      public static JTextField[] getTFS_SU() {
            return tfs_SU;
      }

      public static JLabel[] getLB_2DS() {
            return lb_2ds;
      }
      
      public static JPanel[] getClocks(){
            return clocks;
      }

      public static JButton[] getBTNS_C() {
            return btns_C;
      }

      public static JLabel[] getJLBS() {
            return lbs;
      }

      public static JTextField[] getJTFS() {
            return tfs;
      }

      public static JScrollPane[] getJSCS() {
            return scs;
      }

      public static JList[] getJLSTS() {
            return lsts;
      }

      public static JButton getBTN_MINUS() {
            return btn_minus;
      }

      public static JButton getBTN_PLUS() {
            return btn_plus;
      }

      public static JButton[] getBTNS_MC() {
            return btns_MC;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static JMenu getJM_Options() {
            return JM_Options;
      }

      public static JMenu getJM_Select() {
            return JM_Select;
      }

      public static JMenu getJMS_ChangeDTable() {
            return JMS_ChangeDTable;
      }

      public static JMenu getJMS_ShowList() {
            return JMS_ShowList;
      }

      public static JMenu getJMS_ShowListeners() {
            return JMS_ShowListeners;
      }
      
      public static JMenuItem getMI_ChangeLogin(){
            return mi_changeLogin;
      }

      public static JMenuItem getMI_CreateTable() {
            return mi_CreateTable;
      }

      public static JMenuItem getMI_UpdateTable() {
            return mi_UpdateTable;
      }

      public static JMenuItem getMI_DeleteTables() {
            return mi_DeleteTables;
      }

      public static JMenuItem getMI_DeleteThisTable() {
            return mi_DeleteThisTable;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static JCheckBoxMenuItem getMI_AOT() {
            return mi_AOT;
      }

      public static JCheckBoxMenuItem getMI_AutoR() {
            return mi_AutoR;
      }

      public static JCheckBoxMenuItem getMI_Grid() {
            return mi_Grid;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static JMenuItem getSaveOp() {
            return mi_SaveOp;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static JTextField getTF_CE() {
            return tf_ce;
      }

      public static DefaultCellEditor getDTCellEditor() {
            return DTCellEditor;
      }

}