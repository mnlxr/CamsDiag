/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.converts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static main.CamReqs.MainInfo.CamJobName;

/**
 *
 * @author MManolas
 */
public class JS_toPy {
    
      public static void main(String args[]) throws FileNotFoundException, IOException {
          try {
              ReadJS_File_UserData();
          } catch (ScriptException ex) {
              Logger.getLogger(JS_toPy.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    
    
    public static void ReadJS_File_UserData() throws ScriptException, FileNotFoundException, IOException {
        ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

   
    Object result = engine.eval(Files.newBufferedReader(Paths.get("C:\\Users\\mmanolas\\Documents\\NetBeansProjects\\Cams_Diag\\"+CamJobName() + "\\" + CamJobName() + ".js"), StandardCharsets.UTF_8));
    //Object result = engine.eval(new FileReader(CamJobName() + "//" + CamJobName() + ".js"));
    //Files.newBufferedReader(Paths.get("C:/Scripts/Jsfunctions.js"), StandardCharsets.UTF_8)
    System.out.println("Result returned by Javascript is: " + result+"\n");
    }
    
}

/*
mnit_camtest_v6.js
*/