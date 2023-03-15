/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Echarts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import static main.CamReqs.MainInfo.CamJobName;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_PropertiesFile;
import static main.common.Windows.LibPath_HTML_Windir;

/**
 *
 * @author MManolas
 */
public class JS_ReadProps {
    
            public static void main(String args[]) throws Exception {
        JS_PropertiesFile();
    }
    
    
    
    public static void JS_PropertiesFile() throws IOException {

        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+CamsDiag_PropertiesFile);
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(Readprpsfile());
        }
    }    
    
    
    
    
    public static String Readprpsfile() {
        String h1 = "";
h1="//java;\n"
        + "/*\n"
        + "var p;\n"
        + "if(p==null)\n"
        + "{\n"
        + "p=new java.util.Properties();\n"
        + "var fis=new java.io.FileInputStream(\""+LibPath_HTML_Windir()+"/mnit/echarts.properties\");\n"
        + "p.load(fis);\n"
        + "fis.close();\n"
        + "}\n"
        + "var showlabelsprop=p.getProperty(\"echarts.labels\");\n"
        + "*/"
        + "";
        return h1;
    }
    
}
