package MC;

import com.cofii2.stores.CC;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class DT {
      
      //private static int Id;
      private static int Old_id;
      private static String DTable;

      private static ArrayList<String> list_TC = new ArrayList<String>();
      private static ArrayList<Boolean> list_BL = new ArrayList<Boolean>();

      private static ArrayList<String> list_C = new ArrayList<String>();//COLUMNS
      private static ArrayList<Object> list_R = new ArrayList<Object>();//ROWS
      private static ArrayList<String> list_Types = new ArrayList<String>();//COL TYPE
      private static ArrayList<Boolean> list_Nulls = new ArrayList<Boolean>();//COL NULL
      private static int primaryKey = 0;//SINGLE PRIMARY KEY
      private static ArrayList<String> list_Defaults = new ArrayList<String>();//COL DEFAULT VALUES
      private static Object[] extra = new Object[2];

      private static ArrayList<String>[] list_DS = new ArrayList[DT.maxColumns];//DISTINC LISTS
      private static ArrayList<String>[] list_MXS = new ArrayList[DT.maxColumns - 1];//MIXED LISTS
      private static DefaultListModel[] dlms = new DefaultListModel[DT.maxColumns];

      private static ArrayList<String> list_IconUrl = new ArrayList<String>();
      private static ArrayList<ImageIcon> list_Icon = new ArrayList<ImageIcon>();
      private static ArrayList<String> list_cutUrl = new ArrayList<String>();
      
      //NEW
      private static ArrayList<String> list_IconUrl2 = new ArrayList<String>();
      private static ArrayList<String> list_IconName = new ArrayList<String>();
      //++++++++++++++++++++++++++++
      public static int[] ints = new int[8];
      public static String[] cols = new String[8];
      //++++++++++++++++++++++++++++++++++++++++++++
      private static boolean wrongPassword;
      private static boolean lockCaps;
      private static boolean RTable;//Are There Tables on MainTable
      //++++++++++++++++++++++++++++++++++++++++++++
      public static boolean autoState;
      public static boolean bool_Add;
      public static boolean bool_Upd;
      public static boolean bool_Del;
      public static boolean bool_Sel;
      public static boolean bool_Chan;
      public static boolean bool_SelectC;
      public static boolean cellSys = true;

      public static final String inter = "Nothing Changed";
      public static final int maxColumns = 6;
      public static final int maxIcons = 2;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private DT(){
            throw new IllegalStateException("Private Constructor");
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public static int getOld_id() {
            return Old_id;
      }

      public static void setOld_id(int old_id) {
            Old_id = old_id;
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getList_TC() {
            return list_TC;
      }

      public static ArrayList<Boolean> getList_BL() {
            return list_BL;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getList_C() {
            return list_C;
      }

      public static ArrayList<Object> getList_R() {
            return list_R;
      }

      public static ArrayList<String> getList_Types() {
            return list_Types;
      }

      public static ArrayList<Boolean> getList_Nulls() {
            return list_Nulls;
      }

      public static int getPrimaryKey(){
            return primaryKey;
      }
      
      public static void setPrimaryKey(int v){
            primaryKey = v;
      }
      
      public static ArrayList<String> getList_Defaults(){
            return list_Defaults;
      }
      
      public static Object[] getExtra(){
            return extra;
      }
      
      public static void setExtra(int v1, String v2){
            extra[0] = v1;
            extra[1] = v2;
      }
      //=======================================
      public static ArrayList<String>[] getList_DS(){
            return list_DS;
      }
      
      public static ArrayList<String>[] getList_MXS(){
            return list_MXS;
      }
      //=======================================
      
      public static ArrayList<String> getList_IconUrl(){
            return list_IconUrl;
      }

      public static ArrayList<ImageIcon> getList_Icon(){
            return list_Icon;
      }

      public static ArrayList<String> getList_cutUrl(){
            return list_cutUrl;
      }

      
      public static ArrayList<String> getList_IconHolePath(){
            return list_IconUrl2;
      }
      
      public static ArrayList<String> getList_IconName(){
            return list_IconName;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++
      
      public static DefaultListModel[] getDLMS(){
            return dlms;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public static String getDTable() {
            return DTable;
      }

      public static void setDTable(String dtable) {
            DTable = dtable;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++
      public static boolean getWrongPassword(){
            return wrongPassword;
      }
      
      public static void setWrongPassword(boolean value){
            wrongPassword = value;
      }
      
      public static boolean getRTable(){
            return RTable;
      }
      
      public static void setRTable(boolean v){
            RTable = v;
      }
      
      public static boolean getLockCaps(){
            return lockCaps;
      }
      
      public static void setLockCaps(boolean v){
            lockCaps = v;
      }
      //===================================================
      public static int CCount = 1;
      public static final boolean cons = false;
      
      public static void getConstructorName(boolean b, String CName, String from, int cc){
            if(b == true){
                  System.out.println(CC.CYAN + cc + " - " + CName + " "
                          + "### Constructor from \""
                         + from + "\""+ CC.RESET);
            }
      }
      
      /*
      public Data(){
            rowData = new ArrayList<Object>[]{list_1};
      }
       */
}
