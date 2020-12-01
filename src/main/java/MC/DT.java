package MC;

import Table.CustomTableModel;
import com.cofii.myClasses.CC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class DT {

      private static String Id;
      private static String Old_id;
      private static String Table;
      private static String DTable;
      private static String Dist1;
      private static String Dist2;
      private static String ImageC;
      private static String Tag;
      private static String Clock;

      private static ArrayList<String> list_TC = new ArrayList<String>();
      private static ArrayList<Boolean> list_BL = new ArrayList<Boolean>();

      private static ArrayList<String> list_id = new ArrayList<String>();
      private static ArrayList<String> list_T = new ArrayList<String>();//TABLES
      private static ArrayList<String> list_Dist1 = new ArrayList<String>();
      private static ArrayList<String> list_Dist2 = new ArrayList<String>();
      private static ArrayList<String> list_ImageC = new ArrayList<String>();
      private static ArrayList<String> list_Tag = new ArrayList<String>();
      private static ArrayList<String> list_Clock = new ArrayList<String>();

      private static ArrayList<String> list_C = new ArrayList<String>();//COLUMNS
      private static ArrayList<Object> list_R = new ArrayList<Object>();//ROWS
      private static ArrayList<String> list_Types = new ArrayList<String>();//COL TYPE
      private static ArrayList<String> list_Nulls = new ArrayList<String>();//COL NULL
      private static int primaryKey = 0;//SINGLE PRIMARY KEY
      private static ArrayList<String> list_Defaults = new ArrayList<String>();//COL DEFAULT VALUES
      private static Object[] extra = new Object[2];

      private static ArrayList<String>[] list_DS = new ArrayList[DT.maxColumns];//DISTINC LISTS
      private static ArrayList<String>[] list_MXS = new ArrayList[DT.maxColumns - 1];//MIXED LISTS
      private static DefaultListModel[] dlms = new DefaultListModel[DT.maxColumns];

      private static ArrayList<String> list_IconUrl = new ArrayList<String>();
      private static ArrayList<ImageIcon> list_newIcon = new ArrayList<ImageIcon>();
      private static ArrayList<String> list_cutUrl = new ArrayList<String>();
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
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private DT(){
            throw new IllegalStateException("Private Constructor");
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public static String getId() {
            return Id;
      }

      public static void setId(String id) {
            Id = id;
      }

      public static String getOld_id() {
            return Old_id;
      }

      public static void setOld_id(String old_id) {
            Old_id = old_id;
      }

      public static String getTable(){
            return Table;
      }

      public static void setTable(String table) {
            Table = table;
      }

      public static String getDist1(){
            return Dist1;
      }

      public static void setDist1(String dist1) {
            Dist1 = dist1;
      }

      public static String getDist2(){
            return Dist2;
      }

      public static void setDist2(String dist2) {
            Dist2 = dist2;
      }

      public static String getImageC(){
            return ImageC;
      }

      public static void setImageC(String imagec) {
            ImageC = imagec;
      }

      public static String getTag(){
            return Tag;
      }

      public static void setTag(String tag) {
            Tag = tag;
      }

      public static String getClock(){
            return Clock;
      }

      public static void setClock(String clock) {
            Clock = clock;
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getList_TC() {
            return list_TC;
      }

      public static ArrayList<Boolean> getList_BL() {
            return list_BL;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getList_id() {
            return list_id;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getList_T() {
            return list_T;
      }

      public static ArrayList<String> getList_Dist1() {
            return list_Dist1;
      }

      public static ArrayList<String> getList_Dist2() {
            return list_Dist2;
      }

      public static ArrayList<String> getList_ImageC() {
            return list_ImageC;
      }

      public static ArrayList<String> getList_Tag() {
            return list_Tag;
      }
      
      public static ArrayList<String> getList_Clock(){
            return list_Clock;
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

      public static ArrayList<String> getList_Nulls() {
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

      public static ArrayList<ImageIcon> getList_newIcon(){
            return list_newIcon;
      }

      public static ArrayList<String> getList_cutUrl(){
            return list_cutUrl;
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
