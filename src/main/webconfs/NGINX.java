/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.webconfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import main.common.MainVars;

/**
 *
 * @author MManolas
 */
public class NGINX {
    
        public static void main(String args[]) throws Exception {
StartNGINX_CMD();
System.exit(0);
    }
    

    public static void StartNGINX_CMD() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", "cd \"" + MainVars.main_path_installation + "\\nginx\\\" "
                + "&& "
                + "start nginx.exe");
        
        try {
            
            Process process = processBuilder.start();
            
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                
            }
            
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
    }
    
    public static void StopNGINX_CMD() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", 
                "taskkill /f /IM \"nginx.exe\""
                //"tasklist | find /i \"nginx.exe\">nul  && taskkill /F /IM  \"nginx.exe\" & exit/b"
//                +"cd \"" + MainVars.main_path_installation + "\\nginx\\\" "
//                + "&& "
//                + "nginx -s stop"
        );
        
        try {
            
            Process process = processBuilder.start();
            
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
    }    
    
    public static void RestartNGINX_CMD() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", "cd \"" + MainVars.main_path_installation + "\\nginx\\\" "
                + "&& "
                + "nginx.exe -s stop"
                + "&& start nginx.exe");
        
        try {
            
            Process process = processBuilder.start();
            
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
    }    
    
}
