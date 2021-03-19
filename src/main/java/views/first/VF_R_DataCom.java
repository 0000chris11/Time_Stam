package views.first;

import MC.DT;
import com.cofii2.components.swing.ButtonGradient;
import com.cofii2.components.swing.CheckBoxMenuItemCustom;
import com.cofii2.components.swing.ComboBoxE;
import com.cofii2.components.swing.MenuBarCustom;
import com.cofii2.components.swing.MenuCustom;
import com.cofii2.components.swing.MenuItemCustom;
import com.cofii2.custom.TableCellRenderer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

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
      static JPanel PL_UT = new JPanel();
      static JPanel PL_UC = new JPanel();
      static JScrollPane sc_PL_UC = new JScrollPane(PL_UC);
      
      static JPanel PL_B = new JPanel();
      static JScrollPane sc_PL_B = new JScrollPane(PL_B);
      static JProgressBar JPB = new JProgressBar();
      
      static JTable JT = new JTable();
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
      static JMenuBar JMB = new MenuBarCustom();

      static JMenu JM_Options = new MenuCustom("Options");

      static JMenuItem mi_changeLogin = new MenuItemCustom("Change Login or DB");
      static JMenuItem mi_showTablesInfo = new MenuItemCustom("Show Tables Info");
      
      static JMenu JMS_ShowList = new MenuCustom("Show List");
      JMenuItem mi_STables = new MenuItemCustom("Tables");
      JMenuItem mi_SColumns = new MenuItemCustom("Columns");
      JMenuItem mi_SDists = new MenuItemCustom("Dists");
      JMenuItem mi_SListD = new MenuItemCustom("ListD");
      JMenuItem mi_SJFComponents = new MenuItemCustom("JF Components");
      JMenuItem mi_SP1Components = new MenuItemCustom("P1 Components");

      static JMenu JMS_ShowListeners = new MenuCustom("Show Listener");
      JMenuItem mi_S_JTFS_FL = new MenuItemCustom("JTextFields FL");
      JMenuItem mi_S_JTFS_KL = new MenuItemCustom("JTextFields KL");
      JMenuItem mi_S_JTFS_ML = new MenuItemCustom("JTextFields ML");
      JMenuItem mi_S_JLSTS_LSL = new MenuItemCustom("JLists LSL");
      JMenuItem mi_S_JLSTS_FL = new MenuItemCustom("JLists FL");

      Separator sep0 = new Separator();
      static JCheckBoxMenuItem mi_AOT = new CheckBoxMenuItemCustom("Always On Top");
      static JCheckBoxMenuItem mi_AutoR = new CheckBoxMenuItemCustom("Auto-Resize");
      static JCheckBoxMenuItem mi_Grid = new CheckBoxMenuItemCustom("Show Grid");
      Separator sep1 = new Separator();
      static JMenuItem mi_SaveOp = new MenuItemCustom("Save Options");

      static JMenu JM_Select = new MenuCustom("Select");

      JMenu JM_Table = new MenuCustom("Table");
      static JMenu JMS_TableOptions = new MenuCustom("Options");
      static JCheckBoxMenuItem mi_ClearValuesWhenDeleted = new CheckBoxMenuItemCustom("Clear values when a row is deleted");
      static JMenuItem mi_ReloadImageC = new MenuItemCustom("Reload Current ImageC Directory");
      
      static JMenu JMS_ChangeDTable = new MenuCustom("Change Default Table");
      Separator sep3 = new Separator();
      static JMenuItem mi_CreateTable = new MenuItemCustom("Create Table");
      static JMenuItem mi_UpdateTable = new MenuItemCustom("Update Table");
      static JMenuItem mi_DeleteTables = new MenuItemCustom("Delete Tables");
      static JMenuItem mi_DeleteThisTable = new MenuItemCustom("Delete this Table");
      //+++++++++++++++++++++++++++++++++++
      static JButton btn_minus = new ButtonGradient("-");
      static JButton btn_plus = new ButtonGradient("+");
      static JButton[] btns_MC = new JButton[]{
            new ButtonGradient("ADD"), new ButtonGradient("UPDATE"),
            new ButtonGradient("DELETE"), new ButtonGradient("FIND")};
      //+++++++++++++++++++++++++++++++++++
      static JToggleButton btn_Show_All = new JToggleButton("Show All");

      static JLabel lb_Title = new JLabel("No Table Selected");
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      
      static JPanel[] tfPanel = new JPanel[DT.maxColumns];
      public static final String[] tfPanelTypes = {"JTextField", "JComboBox", "JTextField_Clock"};
      public static final String[] tfPanelATypes = {"JTextField", "JComboBox", "JPanel"};
      static CardLayout[] tfCL = new CardLayout[DT.maxColumns];
      public static String[] tfPanelSelected = new String[]{
            "JTextField", "JTextField", "JTextField", "JTextField", "JTextField", "JTextField"};
      
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      
      static JTextField[] tfsE = new JTextField[DT.maxColumns];
      static JComboBox[] cbs = new ComboBoxE[DT.maxColumns];
      
      static JPanel[] pClocks = new JPanel[DT.maxColumns];
      static JTextField[] tfClocks = new JTextField[DT.maxColumns];
      
      static JButton[] btns_C = new JButton[DT.maxColumns];
      static JScrollPane[] scs = new JScrollPane[DT.maxColumns];
      static JList[] lsts = new JList[DT.maxColumns];

      static JButton[] btns_TB = new JButton[]{new ButtonGradient(""), new ButtonGradient("")};
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      //static JPanel[] clocksPanel = new JPanel[DT.maxColumns];
      static JTextField[] tfs_MD = new JTextField[DT.maxColumns];
      static JTextField[] tfs_MU = new JTextField[DT.maxColumns];      
      static JTextField[] tfs_SD = new JTextField[DT.maxColumns];
      static JTextField[] tfs_SU = new JTextField[DT.maxColumns];
      static JLabel[] lb_2ds = new JLabel[DT.maxColumns];
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel lb_Status = new JLabel("Waiting for Action...");
      
      static JLabel[] lbs_Icons = new JLabel[DT.maxIcons];
      static JLabel lb_Icon = new JLabel("NO ICON SELECTED");
      static JLabel lb_PL = new JLabel("No Table Selected", SwingConstants.CENTER);
      static JLabel lb_JT = new JLabel("NO ROWS INSERTED", SwingConstants.CENTER);
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      static boolean getDefault = true;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      static TableCellRenderer JTCL = new TableCellRenderer();
      static JTextField tf_ce = new JTextField();

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
      
      public static JLabel[] getLBSIcons(){
            return lbs_Icons;
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

      public static JButton[] getBTNS_C() {
            return btns_C;
      }

      public static JLabel[] getJLBS() {
            return lbs;
      }
      
      public static JPanel[] getJTFPanel(){
            return tfPanel;
      }
      public static CardLayout[] getJTFPanelCL(){
            return tfCL;
      }
      
      public static JComboBox[] getJCBS(){
            return cbs;
      }
      
      public static JTextField[] getJTFS(){
            return tfs;
      }
      
      public static JTextField[] getJTFES(){
            return tfsE;
      }
      
      public static JTextField[] getJTF_CKS(){
            return tfClocks;
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
      
      public static JMenuItem getMI_ShowTablesInfo(){
            return mi_showTablesInfo;
      }
      
      public static JMenuItem getMi_ReloadImageC(){
            return mi_ReloadImageC;
      }
      
      public static JCheckBoxMenuItem getMI_ClearValuesWhenDeleted(){
            return mi_ClearValuesWhenDeleted;
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

      public static TableCellRenderer getJTCL(){
            return JTCL;
      }
}
