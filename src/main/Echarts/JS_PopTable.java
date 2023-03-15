/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Echarts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.NumberOfCams;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;

/**
 *
 * @author MManolas
 */
public class JS_PopTable {
    
            public static void main(String args[]) throws Exception {
        JS_PopTable();
    }
    
    
    public static void JS_PopTable() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//" + CamJobName() + "_Table.js");

        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write("\nfunction GenerateTable() {\n"
                    + "//Build an array containing Customer records.\n"
                    + "var camstable = new Array();\n"
                    //+ "camstable.push([\"IDX\",\"Cam Drw Number\", \"Description\", \"Shaft Diam(mm)\", \"R (mm)\", \"Deg (°)\", \"Eccentric\""
                    + "camstable.push([\"IDX\",\"Cam Drw Number\", \"Description\", \"Shaft Diam(mm)\", \"Deg (°)\", \"R (mm)\", \"Eccentric (mm)\""
                    //+ ", "
                    //+ "\"<button id=\\\"addNewRow\\\" class=\\\"btn btn-primary btn-sm\\\">Add New Row</button>\""
                    + "]);\n"
            );
            //+ "camstable.push([\"IDX\",\"Cam Drw Number\", \"Description\", \"Shaft Diam(mm)\", \"R (mm)\", \"Deg (°)\", \"Eccentric\"]);\n");
            String h1 = "\n", h2 = "";
            w.write(h1);
            
            
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                h2 = String.valueOf(NumberOfCams);
                w.write(                                
                        h1 = "camstable.push([\"C" + NumberOfCams + "\", "
                        + "cam" + NumberOfCams + "label, "
                        + "cam" + NumberOfCams + "descl, "
                        + "cam" + NumberOfCams + "diameter, "
                        + "cam" + NumberOfCams + "x, "
                        + "cam" + NumberOfCams + "y, "
                        + "Recc" + NumberOfCams + "]);\n\n\n"
                    //+ " var text"+NumberOfCams+" = document.createTextNode(\"C" + NumberOfCams + "\"); \n"
                    + " var link"+NumberOfCams+" = document.createElement('a');\n"
                    + " link"+NumberOfCams+".setAttribute('href', \"#camcnv"+NumberOfCams+"\");\n"
                    //+ " link"+NumberOfCams+".setAttribute('html', \"test\");\n"
                    //" link.setAttribute('target', \"_blank\");\n" +
                    //" link"+NumberOfCams+".appendChild(text"+NumberOfCams+");\n"                                
                                //+","
                                //
//                        + "<button id=\"addNewRow\">Add New Row</button>"
//                                + "]);\n" 
                            
                            
                        +" \n"
                );
            }
            w.write("        "
                    + "//Create a HTML Table element.\n"
                        + "        var table = document.createElement(\"TABLE\");\n"
                        + "        table.border = \"1\";\n"
                    + " \n"
                    + " "
       
                        + "        //Get the count of columns.\n"
                        + "        var columnCount = camstable[0].length;\n"
                        + " \n"
                        + "        //Add the header row.\n"
                        + "        var row = table.insertRow(-1);\n"
                        + "        for (var i = 0; i < columnCount; i++) {\n"
                        + "            var headerCell = document.createElement(\"TH\");\n"
                        + "            headerCell.innerHTML = camstable[0][i];\n"
                        //+ "            headerCell.setAttribute('href',camstable[0][i]);\n"
                        + "            row.appendChild(headerCell);\n"


          
                        + "        }\n"
                        + " \n"
                        + "        //Add the data rows.\n"
                        + "        for (var i = 1; i < camstable.length; i++) {\n"
                        + "            row = table.insertRow(-1);\n"
                        + "            for (var j = 0; j < columnCount; j++) {\n"
                        + "                var cell = row.insertCell(-1);\n"
                        + "                cell.innerHTML = camstable[i][j];\n"
                        + "            }\n"
                        + "        }\n"
                    + " \n"
                    + "\n"
                    + "//onclick=\"rowEdit(this)\";\n"
                    + "\n"
                    + "        table.className = \"camsdiagTable\";\n"
                    + "         table.id=\"camatables\";\n"
                    + "         //table.getElementById(\"camatables\").innerHTML = table.id=\"camatables\";\n"
                    + "//        table.setAttribute(\"id\", \"camatables\");\n"
                    + "        var dvTable = document.getElementById(\"dvTable\");\n"
                    + "        dvTable.innerHTML = \"\";\n"
                    //+ "        dvTable.classList.add('camsdiagTable');\n"
                    + "        dvTable.appendChild(table);\n"
                    + "    }\n\n");
            w.write("//////////////////////////////////////////////");
            w.close();
        }
    }  
    
    
    public static String PopTable_Function(Integer t) {
        String h1 = "";
        h1="\nfunction GenerateTable() {\n" +
"        //Build an array containing Customer records.\n" +
"        var camstable = new Array();\n" +
"        camstable.push([\"IDX\",\"Cam Drw Number\", \"Description\", \"Shaft Diam(mm)\", \"R (mm)\", \"Deg (°)\", \"Eccentric\"]);\n" +
"        camstable.push([\"<a href=\"#\">C"+t+"\"</a>, cam"+t+"label, cam"+t+"descl, cam"+t+"diameter, cam"+t+"x, cam"+t+"y, Recc"+t+" ]);\n" +
//"        camstable.push([2, \"Mudassar Khan\", \"India\"]);\n" +
//"        camstable.push([3, \"Suzanne Mathews\", \"France\"]);\n" +
//"        camstable.push([4, \"Robert Schidner\", \"Russia\"]);\n" +
" \n" +
" "
                + " var text = document.createTextNode(\"This is link\"); \n" +
" var link = document.createElement('a');\n" +
" link.setAttribute('href', \"camcnv"+t+"\");\n" +
" link.setAttribute('html', \"test\");\n" +
//" link.setAttribute('target', \"_blank\");\n" +
" link.appendChild(text);\n"
                + ""
                + ""
                + "       //Create a HTML Table element.\n" +
"        var table = document.createElement(\"TABLE\");\n" +
"        table.border = \"1\";\n" +
" \n" +
"        //Get the count of columns.\n" +
"        var columnCount = camstable[0].length;\n" +
" \n" +
"        //Add the header row.\n" +
"        var row = table.insertRow(-1);\n" +
"        for (var i = 0; i < columnCount; i++) {\n" +
"            var headerCell = document.createElement(\"TH\");\n" +
"            headerCell.innerHTML = camstable[0][i];\n" +
"            row.appendChild(headerCell);\n" +
"            row.appendChild(link);"+                
"        }\n" +
" \n" +
"        //Add the data rows.\n" +
"        for (var i = 1; i < camstable.length; i++) {\n" +
"            row = table.insertRow(-1);\n" +
"            for (var j = 0; j < columnCount; j++) {\n" +
"                var cell = row.insertCell(-1);\n" +
"                cell.innerHTML = camstable[i][j];\n" +
"            }\n" +
"        }\n" +
" \n" +
"        var dvTable = document.getElementById(\"dvTable\");\n" +
"        dvTable.innerHTML = \"\";\n" +
"        dvTable.appendChild(table);\n" +
"    }\n\n";
        return h1;
    }
    
}
