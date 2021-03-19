/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first;

import SQLStores.TableKeysList;
import SQLStores.TablesDists;

import com.cofii2.components.swing.MenuItemCustom;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MImage;
import com.cofii2.methods.MList;
import com.cofii2.stores.IntString;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import static views.first.VF_R_DataCom.JMS_ChangeDTable;
import static views.first.VF_R_DataCom.JM_Select;
import views.first.listeners.JTChanged_AL;

/**
 *
 * @author C0FII
 */
public class MENU {

      private MENU() {
            throw new IllegalStateException("Private Constructor");
      }

      //++++++++++++++++++++++++++++++++++++
      public static void addItemToMenus() {
            JTChanged_AL MIAL = new JTChanged_AL();

            JM_Select.removeAll();
            JMS_ChangeDTable.removeAll();

            ArrayList<String> tableDists = TablesDists.getTableList();
            ArrayList<String> tableKeys = TableKeysList.getTables();
            ArrayList<IntString> pks = TableKeysList.getPKS();
            ArrayList<IntString> fks = TableKeysList.getFKS();
            ArrayList<String> tableRS = TableKeysList.getTablesR();

            Collections.sort(tableDists);

            int length = tableDists.size();
            int length2 = TableKeysList.getTables().size();

            for (int a = 0; a < length; a++) {
                  ArrayList<String> keys = new ArrayList<>();
                  String table = tableDists.get(a).replace(" ", "_");//USING FULL LIST OF TABLE
                  String tableR = null;

                  for (int b = 0; b < length2; b++) {
                        String tableK = tableKeys.get(b);
                        tableR = tableRS.get(b);
                        int pk = pks.get(b).index;
                        int fk = fks.get(b).index;
                        if (table.equalsIgnoreCase(tableK) && pk > 0) {
                              keys.add("PRIMARY KEY");
                        } else if (table.equalsIgnoreCase(tableK) && fk > 0) {
                              keys.add("FOREIGN KEY");
                        }
                  }
                  //++++++++++++++++++++++++++++++++++++++++++
                  if (!keys.isEmpty()) {
                        if (MList.isOnlyOneElementCopyiedOnThisList(keys)) {
                              if (keys.get(0).equals("PRIMARY KEY")) {
                                    MImage.setColor(Color.YELLOW);

                              } else if (keys.get(0).equals("FOREIGN KEY")) {
                                    MImage.setColor(Color.BLUE);
                              }
                              MImage.setOption(MImage.DRAW_CIRCLE);
                              Icon ii = MImage.resizeIcon(null, 15, 15);

                              JMenuItem mi = new MenuItemCustom(tableDists.get(a), ii);
                              mi.setToolTipText(tableR);
                              JM_Select.add(mi);
                        } else {//MIXED
                              MImage.setColors(new Color[]{Color.YELLOW, Color.BLUE});
                              MImage.setOption(MImage.DRAW_CIRCLES);
                              Icon ii = MImage.resizeIcon(null, 15, 15);

                              JMenuItem mi = new MenuItemCustom(tableDists.get(a), ii);
                              mi.setToolTipText(tableR);
                              JM_Select.add(mi);
                        }
                  }else {
                        JM_Select.add(new MenuItemCustom(tableDists.get(a)));
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  JMS_ChangeDTable.add(new MenuItemCustom(TablesDists.getIdList().get(a) + ": " + tableDists.get(a)));
                  
            }

            MComp.printItems(JM_Select);
            for (int a = 0; a < JM_Select.getItemCount(); a++) {
                  JM_Select.getItem(a).addActionListener(MIAL);
                  JMS_ChangeDTable.getItem(a).addActionListener(MIAL);
            }
      }

      public static void setColorToDItem(String table, String dtable) {
            //System.out.println("MTH - setColorToDItem");
            Font F = new Font("Dialog", Font.BOLD, 12);
            if (JMS_ChangeDTable.getItemCount() == 0) {
                  //System.out.println("###LTABLE IS NULL");
            } else {
                  //System.out.println("###COUNT: " + JMS_ChangeDTable.getItemCount());
                  for (int a = 0; a < JMS_ChangeDTable.getItemCount(); a++) {
                        JM_Select.getItem(a).setBackground(Color.BLACK);
                        JM_Select.getItem(a).setForeground(Color.WHITE);
                        JMS_ChangeDTable.getItem(a).setBackground(Color.BLACK);
                        JMS_ChangeDTable.getItem(a).setForeground(Color.WHITE);
                  }
                  for (int a = 0; a < JMS_ChangeDTable.getItemCount(); a++) {
                        String itemText = JM_Select.getItem(a).getText();
                        //System.out.println(CC.PURPLE + "ItemText: " + itemText + CC.RESET);
                        //System.out.println(CC.PURPLE + "\tdt.getTable: " + DT.getTable() + CC.RESET);
                        //System.out.println(CC.PURPLE + "\tdt.getDTable: " + DT.getDTable() + CC.RESET);
                        if (itemText.contains(" ")) {
                              itemText = itemText.replaceAll(" ", "_");
                        }

                        if (itemText.equals(table)
                                && itemText.equals(dtable)) {
                              JM_Select.getItem(a).setBackground(new Color(100, 100, 100));
                              JMS_ChangeDTable.getItem(a).setBackground(new Color(100, 100, 100));
                        } else if (itemText.equals(table)
                                && !itemText.equals(dtable)) {
                              JM_Select.getItem(a).setBackground(new Color(50, 50, 50));
                              JMS_ChangeDTable.getItem(a).setBackground(new Color(50, 50, 50));
                        } else if (!itemText.equals(table)
                                && itemText.equals(dtable)) {
                              JM_Select.getItem(a).setBackground(new Color(80, 80, 80));
                              JMS_ChangeDTable.getItem(a).setBackground(new Color(80, 80, 80));
                        }
                  }
            }
      }
}
