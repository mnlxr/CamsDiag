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
import static main.common.MainVars.jsgeneral_js;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class JS_globmnit {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        GlobMnit();
    }
    
    /**
     *
     * @return
     */
    public static String UniqIDJS() {
        String h1 = "";
        String h2 = UserInfo.Get_UserName();
        String h3 = UserInfo.Get_ComputerName();
        Integer h4 = NumberOfCams();

        h1 = "function uniqueID() {\n"
                + "var uniq1 = \""+h2+h3+"\"; \n"
                + "var uniq2 = Math.floor(Math.random() * Date.now()); \n"
                //+ "var uniq3 = uniq2.concat(uniq1); \n"
                + "var uniq4 = uniq2.toString();"
                + "return uniq4; \n"
                + "}\n";
    
    return h1;
    }
    
    /**
     *
     * @throws IOException
     */
    public static void GlobMnit() throws IOException {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+ jsgeneral_js);

        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
//        w.write(Echarts_OptionsCamAll_p01());
//            for (int i = 1; i <= NumberOfCams(); i++) {
//                w.write(Echarts_OptionsCamAll_p02(i));                
//            }
            w.write(UniqIDJS()
            );
            w.close();
        }
    }    
    
    
   
    
    
}
