/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

/**
 *
 * @author C0FII
 */
public class TableInfoC {

      private static int id;
      private static String table;
      private static String dist1;
      private static String dist2;
      private static String imageC;
      private static String tag;
      private static String clock;

      public TableInfoC(int id, String table, String dist1, String dist2, String imageC, String tag, String clock) {
            this.id = id;
            this.table = table;
            this.dist1 = dist1;
            this.dist2 = dist2;
            this.imageC = imageC;
            this.tag = tag;
            this.clock = clock;
      }
      
      public static Object[] toArray(){
            return new Object[]{id, table, dist1, dist2, imageC, tag, clock};
      }
      
      public static int getId(){
            return id;
      }
      public static void setId(int id){
            TableInfoC.id = id;
      }
      public static String getTable(){
            return table;
      }
      public static void setTable(String table){
            TableInfoC.table = table;
      }
      public static String getDist1(){
            return dist1;
      }
      public static void setDist1(String dist1){
            TableInfoC.dist1 = dist1;
      }
      public static String getDist2(){
            return dist2;
      }
      public static void setDist2(String dist2){
            TableInfoC.dist2 = dist2;
      }
      public static String getImageC(){
            return imageC;
      }
      public static void setImageC(String imageC){
            TableInfoC.imageC = imageC;
      }
      public static String getTag(){
            return tag;
      }
      public static void setTag(String tag){
            TableInfoC.tag = tag;
      }
      public static String getClock(){
            return clock;
      }
      public static void setClock(String clock){
            TableInfoC.clock = clock;
      }
}