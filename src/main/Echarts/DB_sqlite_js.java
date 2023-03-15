/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import static main.CamReqs.MainInfo.NumberOfCams;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.dbjsfile;
import static main.common.MainVars.dbname;
import static main.common.MainVars.jsgeneral_js;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class DB_sqlite_js {
    
    
        public static void main(String args[]) throws Exception {
        DB_Main();
    }
    
    
    public static String DBwrite() {
        String h1 = "";
        String h2 = UserInfo.Get_UserName();
        String h3 = UserInfo.Get_ComputerName();
        Integer h4 = NumberOfCams();

        h1 = "\n"
                + "var outputListElement = null;\n"
                + "var outputListID = 'outputList';\n"
                + "\n"
                + "var dbName = '"+dbname+"';\n"
                + "var dbVersion = '2.0.1.27';\n"
                + "var dbDesc = 'CamsDiag Database.';\n"
                + "var dbSize = 2 * 1024 * 1024;\n"
                + "var database = null;"
                + "\n";

        return h1;
    }
    
    
    public static void DB_Main() throws IOException {
        File statText = new File(PathWebServer+"//MnIT_libs//db//"+ dbjsfile);

        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write(DBwrite()
            );
            w.close();
        }
    }      
    
    
}
