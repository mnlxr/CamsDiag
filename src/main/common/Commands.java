/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static main.CamReqs.MainInfo.CamJobName;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.PythonFolderMainName;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.main_path_installation;
import static main.common.MainVars.pdfliteImage;
import static main.common.MainVars.pdflitetext2pdf;
import static main.common.MainVars.sedwin;
import static main.common.Windows.ZipDate;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class Commands {

    /**
     *
     * @return
     */
    public static String PDFlite_Image() {
        String h1 = "";
        String pathExport = main_path_installation + "\\PDFs";
        String cmdpdflite = "\"" + pdfliteImage + "\"" + " -o \"" + pathExport + "\\" + UserInfo.Get_UserName() + "_CamsDiag" + "_" + ZipDate() + ".pdf\" -p num ";
        String cmd_cd = "cd " + pathExport + " && ";
        String CMD_final = "cmd /c " + cmd_cd + cmdpdflite;
        return CMD_final;
    }
    
    /**
     *
     * @return
     */
    public static String PDFlite_Text() {
        String h1 = "";
        String pathExport = main_path_installation + "\\PDFs";
        String cmdpdflite = "\"" + pdflitetext2pdf + "\"" + " -o \"" + pathExport + "\\" + UserInfo.Get_UserName() + "_Text" + "_" + ZipDate() + ".pdf\" ";
        String cmd_cd = "cd " + pathExport + " && ";
        String CMD_final = "cmd /c " + cmd_cd + cmdpdflite;
        return CMD_final;
    }    

    /**
     *
     * @return
     */
    public static String Sed_RemoveTrailingSpaces() {
       
        String sedClear = sedwin+" -i -e \"s/^\\s*//\"";

        return sedClear;
    }
    
    /**
     *
     * @throws IOException
     */
    public static void CompilePythonFiles_CamJobs() throws IOException {            
 //           SedCamJobUserData();
//            CompilePyCamJob();
//            CompilePyArCamJob();
//            DelSedTempFilesCamJob();    
    }
    
//    public static void SedCamJobUserData() throws IOException {
//        String sed01 = Sed_RemoveTrailingSpaces() + " " + "\"" + pyUserData() + "\"";
//        try {
//            String line;
//            Process p = Runtime.getRuntime().exec(sed01);
//            System.out.println("Sed Done : " + sed01);
//            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//            while ((line = bri.readLine()) != null) {
//                System.out.println(line);
//            }
//            bri.close();
//            while ((line = bre.readLine()) != null) {
//                System.out.println(line);
//            }
//            bre.close();
//            p.waitFor();
//            System.out.println("Done.");
//            //jLabel21.setText("Done");
//            //convertBt.setEnabled(false);
//            //ta.append("PDF is Ready!\n");
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//
//    }

    /**
     *
     */

    public static void CompilePyCamJob() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            // Windows
//            processBuilder.command("cmd.exe", "/c", "cd \"" + PyFolder() + "\" "
//                    + "&& "
//                    + "\"" + PyFile() + "\"");

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
                //System.exit(0);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception err) {
        }
    }
    
//    public static void CompilePyArCamJob() {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            // Windows
//            processBuilder.command("cmd.exe", "/c", "cd \"" + PyFolder() + "\" "
//                    + "&& "
//                    + "\"" + PyArbortext() + "\"");
//
//            try {
//
//                Process process = processBuilder.start();
//
//                BufferedReader reader
//                        = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//
//                }
//
//                int exitCode = process.waitFor();
//                System.out.println("\nExited with error code : " + exitCode);
//                //System.exit(0);
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        } catch (Exception err) {
//        }
//    }
//    
//    public static void DelSedTempFilesCamJob() {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            // Windows
//            processBuilder.command("cmd.exe", "/c", "del sed*");
//
//            try {
//
//                Process process = processBuilder.start();
//
//                BufferedReader reader
//                        = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//
//                }
//
//                int exitCode = process.waitFor();
//                System.out.println("\nExited with error code : " + exitCode);
//                //System.exit(0);
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        } catch (Exception err) {
//        }
//    }    
//    
//    public static String PyFolder() throws IOException {
//
//        String mh1 = MainVars.main_path_installation + "\\";
//
//        String pyFolder = PathWebServer + "\\"
//                + mainFolder + "\\"
//                + CamJobName()
//                + "\\"
//                + PythonFolderMainName()
//                + "\\";
//
//        return pyFolder;
//    }

//    public static String PyFile() throws IOException {
//
//        String PyFile = PyFolder()
//                + PyNamesFiles() + "_"
//                + PythonFolderParametersName() + ".py";
//        return PyFile;
//    }
//
//    public static String pyUserData() throws IOException {
//
//        String pyUserData = PyFolder() + CamJobName() + ".py";
//
//        return pyUserData;
//    }
//
//    public static String PyArbortext() throws IOException {
//
//        String pyAr = PyFolder()
//                + PyNamesFiles()
//                + "_"
//                + PythonFolderParametersName_Arbortext() + ".py";
//
//        return pyAr;
//    }

}
