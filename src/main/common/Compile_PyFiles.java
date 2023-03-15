/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.IOException;
import static main.CamReqs.MainInfo.CamJobName;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.PythonFolderMainName;
import static main.common.Folders.PythonFolderParametersName;
import static main.common.Folders.PythonFolderParametersName_Arbortext;
import static main.common.Folders.mainFolder;
import static main.pros.SystemProps.CamsDiag_MainPath;

/**
 *
 * @author MManolas
 */
public class Compile_PyFiles {
   
   //public static String ph1 = CamsDiag_MainPath();//"C:\\Users\\mmanolas\\Documents\\NetBeansProjects\\MnIT_CamsDiag\\";
   
   
    public static String CompilePyF01() throws IOException {
        String h1 = "";
        String ph1 = CamsDiag_MainPath();
        h1 = "cmd /c "
                + "cd \""
                + ph1
                + PathWebServer
                + "\\"
                + mainFolder + "\\"
                + CamJobName()
                + "\\"
                + PythonFolderMainName() + "\""
                + " && "
                + ph1 + PathWebServer + "\\"
                + mainFolder + "\\"
                + CamJobName()
                + "\\"
                + PythonFolderMainName()
                + "\\"
//                + PyNamesFiles()
                + "_"
                + PythonFolderParametersName_Arbortext() + ".py";

        return h1;
    }
    
    public static String CompilePyF02() throws IOException {
        String h1 = "";
        String ph1 = CamsDiag_MainPath();
        h1 = "cmd /c "
                + "cd \"" + ph1 + PathWebServer + "\\" + mainFolder + "\\"
                + CamJobName() + "\\"
                + PythonFolderMainName() + "\""
                + " && "
                + ph1 + PathWebServer + "\\" + mainFolder + "\\"
                + CamJobName() + "\\"
                + PythonFolderMainName() + "\\"
//                + PyNamesFiles() + "_"
                + PythonFolderParametersName() + ".py";
        return h1;
    }

    
        public static String RemoveLeadingSpaces() throws IOException {
        String h1 = "";
        String ph1 = CamsDiag_MainPath();
//        h1 = "cmd /c "
//                + sedwin+" -i \"s/^[ \\t]*//;s/[ \\t]*$//\" "
//                //%sedpath% -i "s/^[ \t]*//;s/[ \t]*$//" "%tempf%"
//                
//                + "\""+ph1 + PathWebServer+"\\"+
//                mainFolder+"\\"+
////                CamJobName() + "\\"+PythonFolderMainName()+"\\" + PyNamesFiles() + ".py\" "
//                + "&& del sed*";
        return h1;
    }
        
        public static String DeleteSEDfiles() throws IOException {
        String h1 = "";
        h1 = "cmd /c del sed*";
        return h1;
    }        
    
    
    
}
