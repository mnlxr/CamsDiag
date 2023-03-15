/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.MnIT_Main;

/**
 *
 * @author MManolas
 */
public class MnIT_checkForUpdates {
    
    public static void CheckForUpdates(){
String cmdjar="java -jar";
        String updatejar="C:\\Data\\CamsDiag\\MnIT_CamsDiag_Update.jar";
        String runjar = cmdjar+" "+updatejar;
        
        ProcessBuilder builder = new ProcessBuilder(
            //"cmd.exe", "/c", "cd \"C:\\Program Files\\Microsoft SQL Server\" && dir"
                "cmd.exe", "/c", cmdjar+" "+updatejar
        );
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException ex) {
                Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (line == null) { break; }
            System.out.println(line);
        }            
    }
    
}
