package MC;

import Others.CC;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Data {

      private static ArrayList<String> list_R = new ArrayList<String>();//ROWS
      private static ArrayList<String> list_TP = new ArrayList<String>();//COL TYPE
      private static ArrayList<String> list_NL = new ArrayList<String>();//COL NULL

      private static ArrayList<Integer> list_1 = new ArrayList<Integer>();//id
      private static ArrayList<String> list_2 = new ArrayList<String>();
      private static ArrayList<String> list_3 = new ArrayList<String>();
      private static ArrayList<String> list_4 = new ArrayList<String>();
      private static ArrayList<String> list_5 = new ArrayList<String>();
      private static ArrayList<String> list_6 = new ArrayList<String>();

      ArrayList<Object>[] rowData;

      private static ArrayList<String> list_S23 = new ArrayList<String>();
      private static ArrayList<String> list_S34 = new ArrayList<String>();
      private static ArrayList<String> list_S45 = new ArrayList<String>();
      private static ArrayList<String> list_S56 = new ArrayList<String>();

      private static ArrayList<String> listD_2 = new ArrayList<String>();
      private static ArrayList<String> listD_3 = new ArrayList<String>();
      private static ArrayList<String> listD_4 = new ArrayList<String>();
      private static ArrayList<String> listD_5 = new ArrayList<String>();
      private static ArrayList<String> listD_6 = new ArrayList<String>();

      private static ArrayList<String> list_IconUrl = new ArrayList<String>();
      private static ArrayList<ImageIcon> list_newIcon = new ArrayList<ImageIcon>();
      private static ArrayList<String> list_cutUrl = new ArrayList<String>();

      private String[] bw = {" FROM", " WHERE", " SHOW", " WITH", "-"};
      private ArrayList<String> bandW = new ArrayList<String>(Arrays.asList(bw));
      //++++++++++++++++++++
      private final static Border line1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
      private final static Border line2 = BorderFactory.createLineBorder(Color.WHITE, 2);
      public final static Border emptyBorder = new EmptyBorder(1, 3, 1, 3);
      public final static 
              CompoundBorder compoundBorder_N = new CompoundBorder(line1, emptyBorder);
      public final static 
              CompoundBorder compoundBorder_O = new CompoundBorder(line2, emptyBorder);

      public final Color[] RGY = new Color[]{Color.RED, Color.GREEN, Color.YELLOW};
      public final Color[] TFColor = new Color[]{new Color(51, 51, 51), new Color(0, 0, 51),
            new Color(0, 0, 81)};
      public static final Color[] GP_darkRed = new Color[]{
            Color.BLACK, new Color(102,0,0)};
      public static final Color[] GP_brightCeleste = new Color[]{
            Color.WHITE, new Color(37,161,231)};

      public final Color[] cl = {Color.RED, Color.GREEN, Color.YELLOW};
      //++++++++++++++++++++++++++++
      public char[] chars = new char[8];
      public static char[] charss = new char[8];
      public String[] strings = new String[8];
      public static String[] stringss = new String[8];
      public int[] ints = new int[8];
      public static int[] intss = new int[8];
      public String[] cols = new String[8];
      public static String[] colss = new String[8];

      public final String IconURL = "C:\\C0F\\About Music\\Album Front\\";
      public static final String IconURLs = "C:\\C0F\\About Music\\Album Front\\";

      public static boolean autoState;

      public static boolean bool_Add;
      public static boolean bool_Upd;
      public static boolean bool_Del;
      public static boolean bool_Sel;
      public static boolean bool_Chan;
      public static boolean bool_SelectC;
      public static boolean cellSys = true;

      public final String inter = "Nothing Changed";
      public static final Dimension defaultFrameSize = new Dimension(1280, 627);
      public final int maxColumns = 6;
      public static final int maxColumnss = 6;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public Data(String from){
            System.out.println(CC.CYAN + "CLASS ### Data ---------- FROM: " 
                    + from + CC.RESET);
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++

      public ArrayList<String> getList_R() {
            return list_R;
      }

      public ArrayList<String> getList_TP() {
            return list_TP;
      }

      public ArrayList<String> getList_NL() {
            return list_NL;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<Integer> getList_1() {
            return list_1;
      }

      public ArrayList<String> getList_2() {
            return list_2;
      }

      public ArrayList<String> getList_3() {
            return list_3;
      }

      public ArrayList<String> getList_4() {
            return list_4;
      }

      public ArrayList<String> getList_5() {
            return list_5;
      }

      public ArrayList<String> getList_6() {
            return list_6;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getList_S23() {
            return list_S23;
      }

      public ArrayList<String> getList_S34() {
            return list_S34;
      }

      public ArrayList<String> getList_S45() {
            return list_S45;
      }

      public ArrayList<String> getList_S56() {
            return list_S56;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getListD_2() {
            return listD_2;
      }

      public ArrayList<String> getListD_3() {
            return listD_3;
      }

      public ArrayList<String> getListD_4() {
            return listD_4;
      }

      public ArrayList<String> getListD_5() {
            return listD_5;
      }

      public ArrayList<String> getListD_6() {
            return listD_6;
      }

      public void setListD_2(ArrayList<String> list) {
            listD_2.clear();
            for (int a = 0; a < list.size(); a++) {
                  listD_2.add(list.get(a));
            }
      }

      public void setListD_3(ArrayList<String> list) {
            listD_3.clear();
            for (int a = 0; a < list.size(); a++) {
                  listD_3.add(list.get(a));
            }
      }

      public void setListD_4(ArrayList<String> list) {
            listD_4.clear();
            for (int a = 0; a < list.size(); a++) {
                  listD_4.add(list.get(a));
            }
      }

      public void setListD_5(ArrayList<String> list) {
            listD_5.clear();
            for (int a = 0; a < list.size(); a++) {
                  listD_5.add(list.get(a));
            }
      }

      public void setListD_6(ArrayList<String> list) {
            listD_6.clear();
            for (int a = 0; a < list.size(); a++) {
                  listD_6.add(list.get(a));
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getList_IconUrl() {
            return list_IconUrl;
      }
      
      public static ArrayList<String> getList_IconUrls(){
            return list_IconUrl;
      }

      public ArrayList<ImageIcon> getList_newIcon() {
            return list_newIcon;
      }
      public static ArrayList<ImageIcon> getList_newIcons(){
            return list_newIcon;
      }

      public ArrayList<String> getList_cutUrl() {
            return list_cutUrl;
      }
      public static ArrayList<String> getList_cutUrls(){
            return list_cutUrl;
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getBandW() {
            return bandW;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++
      /*
      public Data(){
            rowData = new ArrayList<Object>[]{list_1};
      }
       */
}
