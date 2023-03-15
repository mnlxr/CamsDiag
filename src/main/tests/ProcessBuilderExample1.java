/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

/**
 *
 * @author MManolas
 */
import main.webconfs.NGINX;
import static main.webconfs.NGINX.StopNGINX_CMD;

public class ProcessBuilderExample1 {

    public static void main(String[] args) {
        
     StopNGINX_CMD();  
        NGINX.StartNGINX_CMD();
    
//
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        // Windows
//        processBuilder.command("cmd.exe", "/c", "cd \""+MainVars.main_path_installation+"\\nginx\\\" "
//                + "&& "
//                + "start nginx.exe");
//
//        try {
//
//            Process process = processBuilder.start();
//
//            BufferedReader reader =
//                    new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            int exitCode = process.waitFor();
//            System.out.println("\nExited with error code : " + exitCode);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
    }

}
