/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author C0FII
 */
public class LogForm extends Formatter{

      static {
            
      }
      
      @Override
      public String format(LogRecord record) {
            return record.getMessage() + "!!!!";
      }
      
}
