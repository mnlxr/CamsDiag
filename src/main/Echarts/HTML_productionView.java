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
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.NumberOfCams;
import static main.Echarts.HTML_Commons.HTML_Head_MetaData;
import static main.Echarts.HTML_Commons.HTML_footer;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.Cam_All_js;
import static main.common.MainVars.Cam_DatGui_js;
import static main.common.MainVars.Cam_Polar_js;
import static main.common.MainVars.CamsDiag_Common_js;
import static main.common.MainVars.CamsDiag_PropertiesFile;
import static main.common.MainVars.aniscamsdiag01url;
import static main.common.Windows.LibPathServer_HTML_Windir;
import main.info.UserInfo;


/**
 *
 * @author MManolas
 */
public class HTML_productionView {
 
    public static String aniscams;
    
    public static void main(String args[]) throws Exception {
        CamsDiag_index_HTML_View();
    }
    
    public static void CamsDiag_index_HTML_View() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"\\"+mainFolder+"\\"+"PROD_"+CamJobName() + ".html");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                   HTML_Head() + HTML_Body()
            );
            w.close();
        }
    }   
    
    public static String Echarts_Dimensions() {
        String h1 = "";
        h1 = "style=\"width: 90%; min-height: 450pt; height:450pt; display: inline-block;\"";
        return h1;
    }
    

    
    public static String HTML_scripts_ReadFilesTXT() throws IOException {
        String h1 = "";
        h1 = "\n<script>\n"
                + "  jQuery \n"
                + "    .ajax({\n"
                + "      url: '"+CamJobName()+"\\\\CamsDiag_NofCams.txt',\n"
                + "      dataType: 'text'\n"
                + "    })\n"
                + "    .error(function(){\n"
                + "      console.warn('An error occurred whilst loading the file', arguments);\n"
                + "    })\n"
                + "    .done(function(res){\n"
                + "      jQuery.each(res.split(/\\r?\\n/g), function(i, v){\n"
                + "        jQuery('#output_nof_cams').append('<p>' + v + '</p>');\n"
                + "      });\n"
                + "    })\n"
                + "  ;\n"
                + "</script>        \n"
                + "\n"
                + "<script>\n"
                + "  jQuery \n"
                + "    .ajax({\n"
                + "      url: '"+CamJobName()+"\\\\CamsDiag_JobName.txt',\n"
                + "      dataType: 'text'\n"
                + "    })\n"
                + "    .error(function(){\n"
                + "      console.warn('An error occurred whilst loading the file', arguments);\n"
                + "    })\n"
                + "    .done(function(res){\n"
                + "      jQuery.each(res.split(/\\r?\\n/g), function(i, v){\n"
                + "        jQuery('#output_job_name').append('<p>' + v + '</p>');\n"
                + "      });\n"
                + "    })\n"
                + "  ;\n"
                + "</script> \n";

        return h1;
    }

    public static String HTML_LibImports_External() {
        String h1 = "";
        h1 = "\n"
                + "<!-- html2Canvas-->\n"
                + "<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js\"></script>\n"
                + "<!-- BlueBird -->\n"
                + "<script src=\"//cdn.jsdelivr.net/npm/bluebird@3.7.2/js/browser/bluebird.js\"></script>\n\n"
                + "<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\n"
                + "<!-- <script src=\"http://s1.bdstatic.com/r/www/cache/efe/esl/2-1-6/esl.js\"></script>\n -->"
                + "<!-- jsPdf -->\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js\"></script>\n"
                + "<script src=\"https://unpkg.com/jspdf@latest/dist/jspdf.umd.min.js\"></script>\n"
                + "<!-- <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.2.61/jspdf.debug.js\"></script>\n -->"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                + "<!-- <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/2.3.4/jspdf.plugin.autotable.min.js\"></script> -->\n"
                + "\n"
                + "<!-- pdfmake -->\n"
                + ""
                + "<!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js\"></script> -->\n"
                + "<!-- Package -->\n"
                + "<!-- <script type=\"text/javascript\" src=\"https://raw.github.com/Stuk/jszip/master/jszip.js\"></script> -->\n";
        return h1;
    } 
    
    public static String HTML_LibImports_Internal() throws IOException {
        String h1 = "";
        h1 = "\n<script src=\""+LibPathServer_HTML_Windir()+"/echarts/echarts.js\"></script>\n\n"
                + "<!-- <script src=\""+LibPathServer_HTML_Windir()+"/echarts/echarts.common.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/echarts.js.map\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/echarts.esm.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/extension/dataTool.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/extension/bmap.js\"></script>-->\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/ecStat.js\"></script>-->\n"
                + "<!-- Themes -->\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/MnIT.js\"></script> \n"
                 + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/dark.js\"></script> \n"
                 + "<!-- <script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/vintage.js\"></script> -->\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/walden.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/macarons.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/westeros.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/roma.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/shine.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/infographic.js\"></script> \n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/themes/essos.js\"></script> \n"
                + "<!-- End -->\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/jquery-3.2.1.min.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts/jquery-ui.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/mnit/mnit_info.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/mnit/myDataTable.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/others/jszip.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/others/html2canvas.js\"></script>\n"
                
                + "<!-- <script src=\""+LibPathServer_HTML_Windir()+"/testHelper.js\"></script> -->\n"
                + "<!-- <script src=\"cams/cam_CommonSettings.js\"></script> -->\n"

                + "<!--\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/testHelper.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/draggable.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/frameInsight.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/perlin.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/config.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/jquery.min.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/facePrint.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/simpleRequire.js\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/draggable.js\"></script>\n"
                + "-->\n"
                + "<script src=\""+CamJobName()+"/"+CamJobName()+".js\"></script>\n"
                + "<script src=\"" + CamJobName() + "/"+CamsDiag_Common_js+"\"></script>\n"
                + "<script src=\""+CamJobName()+"/"+CamJobName()+"_Table.js\"></script>\n"
                //+ "<script src=\""+LibPathServer_HTML_Windir()+"/mnit/backtotop.js\"></script>\n"
        +"<script>window.onload = GenerateTable;</script>\n"
            + "<script src=\""+LibPathServer_HTML_Windir()+"/echarts_libs/dat.gui.min.js\"></script>\n"   ; 
                //+ "<script src=\""+LibPathServer_HTML_Windir()+"echarts/jquery-3.2.1.min.js\"></script>\n"
                //+ "<script src=\""+LibPathServer_HTML_Windir()+"echarts/jquery-ui.js\"></script>"
                ;
        return h1;
    }  
    
    public static String HTML_CamsJS_Import() throws IOException {
        String h1 = "";
        h1 = "<!-- Cams JS Import -->\n"
                + "<script src=\"" + CamJobName() + "/"+CamsDiag_PropertiesFile+"\"></script>\n"
                + "<script src=\"" + CamJobName() + "/"+CamsDiag_Common_js+"\"></script>\n"
                + "<script src=\"" + CamJobName() + "/"+Cam_All_js+"\"></script>\n"
                + "<!-- <script src=\"" + CamJobName() + "/"+Cam_DatGui_js+"\"></script>\n -->"
                + "<script src=\"" + CamJobName() + "/"+Cam_Polar_js+"\"></script>\n"
                + "<script src=\""+LibPathServer_HTML_Windir()+"/mnit/backtotop.js\"></script>\n"
                + "<script src=\"" + CamJobName() + "/"+CamJobName() + "_func.js\"></script>\n"  
                + "<script src=\""+LibPathServer_HTML_Windir()+"/others/bootstable.js\"></script>\n"
                //+ "<script src=\""+LibPathServer_HTML_Windir()+"/mnit/backtotop.js\"></script>\n"
                + "<!-- END -->\n";
        return h1;
    }

    public static String HTML_JSlibsBODY_Import() throws IOException {
        String h1 = "";
        h1 = "<!-- Libs Import -->\n"
                + "<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js\"></script>\n"+
    "<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js\"></script>\n"
                + "<!-- END -->\n";
        return h1;
    }    
    
    
    public static String HTML_CamAll_Visibility() {
        String h1 = "";
        if (NumberOfCams() == 1) {
                h1 = "\n<!-- <div id=\"mainAll\" style=\"width: 90%;height:160mm; display: inline-block;\" class=\"chart\"></div> -->\n"
                    ;
        } else if(NumberOfCams() != 1){
            h1 = "<div id=\"mainAll\" style=\"width: 90%;height:160mm; display: inline-block;\" class=\"chart\"></div>\n"
                    + "\n"
                    + "<!-- "
                    + "<p align=\"center\"><a href=\"#TopPage\">Go to Top</a></p><br>\n"
                    + "-->\n";
        }
        return h1;
    }  
    
    public static String HTML_Buttons() throws IOException, URISyntaxException {
        String h1 = "";
        String buttonWidth="20";
        h1 = "\n"
                
                + "<div>\n"
                + "\n"
                //http://localhost:8158/
                //+"<a href=\""+WebServerPath().substring(0, 22)+"\">"
                +"<!--\n"
                +"<a href=\""+aniscamsdiag01url+"\">"
                + "<button class=\"button\" "
                + "type=\"submit\" "
                //+ "value=\"Generate Table\" onclick=\"GenerateTable()\" "
                + "style=\"width:"+buttonWidth+"%\">Home</button>"
                + "</a>\n"
                +"-->\n"
                
                
                +"<!-- \n"
                + "\n"
                + "<a href=\""+CamJobName()+"/"+CamJobName()+".js\" "
                + "target=\"_blank\" "
                + "onclick=\"document.location='"+CamJobName()+"/"+CamJobName()+".js'\">"
                + "<button class=\"button\" "
                + "type=\"submit\" "
                + "style=\"width:"+buttonWidth+"%\">View RAW Data ("+NumberOfCams()+" Charts)</button></a>\n"
                +"-->\n"
                
                
                +"<a href=\"#datatable\">"
                + "<button class=\"button\" "
                + "type=\"submit\" "
                //+ "value=\"Generate Table\" onclick=\"GenerateTable()\" "
                + "style=\"width:15%\">Data Table for "+CamJobName()+"</button>"
                + "</a>\n"
                +"<!--\n"
                //+ "<a href=\"#print\">"
                + "<button class=\"button\" "
                + "id=\"camExport\" "
                + "type=\"button\" "
                + "onclick=\"CamImagesToPDF()\" "
                + "style=\"width:"+buttonWidth+"%\">Print Charts</button>\n"
                +"-->\n"
               // + "</a>\n"                                
                
//                + "<button class=\"button\" "
//                + "id=\"printDataTable\" "
//                + "type=\"button\" "
//                + "style=\"width:"+buttonWidth+"%\">Print Data Table</button>\n"

                
                + "<button class=\"button\" "
                + "id=\"btnExport\" "
                + "type=\"button\" "
                + "onclick=\"Export()\" "
                + "value=\"Export\" "
                + "style=\"width:"+buttonWidth+"%\"> Print Data Table </button>\n"
                
                +"<!--\n"
                +"<a href=\""+aniscamsdiag01url+"Help.html\">"
                //+"<a href=\""+WebServerPath().substring(0, 22)+"/Help.html\">"
                + "<button class=\"button\" "
                //+ "id=\"btnExport\" "
                + "type=\"button\" "
                + "onclick=\"Export()\" "
                //+ "value=\"Export\" "
                + "style=\"width:"+buttonWidth+"%\"> Help </button>\n"
                + "</a>" 
                +"-->\n"
                
                
                +"<!--\n"
                + "<label for=\"myCheck\">Show Labels : </label> \n"
                + "<input type=\"checkbox\" id=\"myCheck\" onclick=\"ShowLabelsFunction()\">\n"                           
                +" -->\n"
                
//                + "<button class=\"button\" id = \"echartId2\" \n"
//               // + "<Sapphire: button id = \"print\" text = \"Print Chart\" img = \"WEB-CORE / images / gif / Export.gif\" "
//                + "onclick=\"GetImage()\"/> Print Charts\n"
//                + "</button>\n"
                
                + "<!-- <button class=\"button\" type=\"submit\" style=\"width:20%\" onclick=\"exportExcel()\">Download Images :  "+CamJobName()+"</button> -->\n"
                + "</div>\n"
                + "<br>\n";
        return h1;
    }
     
    public static String HTML_CamsMainDIV() {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("<div id=\"maincam"+String.valueOf(i)+"\" "
                    + "" + Echarts_Dimensions() + " "
                            + "class=\"chart\"></div>\n"
                            + "\n"
                            + "<!-- \n"
                    + "<p align=\"center\"><a href=\"#TopPage\">Go to Top | #Cam "+i+"# </a></p>\n"
                            + "--> \n");
            builder.append("<br>\n");
        }
        h1 = builder.toString();
        
        return h1;
    }
    
    public static String HTML_CamsImagesDIV() {
        String h1="";
        String h2 = "<div id = \"print\">\n";
        String h3="</div>";
        String h4="";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append(""
                    + "<div id = \"print\">\n"
                    + "<img src=\"\" id=\"printImg"+i+"\" style=\"height: 50%;width:90%;display: none;\" />\n"
                            + "</div>");
        }
        h1 = builder.toString();
        h4=h2+h1+h3;
        return h4;
    }    
    
    public static String HTML_CamsMainImportJS_Files() throws IOException {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("<script src=\""+CamJobName()+"/cams/cam"+String.valueOf(i)+".js\"></script>\n");                    
        }
        h1 = builder.toString();
        //String h2 = "<script src=\""+CamJobName()+"/"+CamJobName()+"_Table.js\"></script>";
        return h1;
    }    
    
    public static String HTML_CSS() {
        String h1 = "";
        h1 = "\n<link rel=\"stylesheet\" href=\""+LibPathServer_HTML_Windir()+"/css/mnit.css\">\n"
                + "<link rel=\"stylesheet\" href=\""+LibPathServer_HTML_Windir()+"/css/jquery-ui.css\">\n"
                + "<link rel=\"stylesheet\" href=\""+LibPathServer_HTML_Windir()+"/echarts_libs/reset.css\" />\n"
                + "<!--\n"
                + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n"
                + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n"
                + " -->";
        return h1;
    }
    
    public static String HTML_Head() throws IOException {
        String h1 = "";
        h1 = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<title>.:: Cams Diagramms : "+UserInfo.Get_UserName()+"_"+CamJobName()+" ::.</title>\n"
                + "<link rel=\"shortcut icon\" type=\"image/jpg\" href=\""+LibPathServer_HTML_Windir()+"/imgs/camsdiag.ico\"/>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + HTML_Head_MetaData()                
                + HTML_LibImports_Internal()
                + HTML_LibImports_External()
                + HTML_CSS()
                //+ HTML_scripts_ReadFilesTXT()
                
                + "</head>\n";
        return h1;
    }
        
    
    public static String DataTableFilter() {
    String h1="";
    
    h1= "\n<input type=\"text\" \nid=\"myInput\" \nonfocus=\"this.value=''\" \nonkeyup=\"myDataTableAllElements()\" \nplaceholder=\"Search ...\" \ntitle=\"Type in a name\">\n"
            //+ "<button onclick=\"document.getElementById(\"myInput\").value = ''\">X</button>";
            //+"<input type=\"reset\" value=\"Reset\" />";
//            +"   <button onclick=\n" +
//"            \"document.getElementById(\n" +
//"             'myInput').value = ''\">\n" +
//"      Click here to clear\n" +
//"  </button>\n"
    ;
    return h1;
    }
    
    
    public static String HTML_Body() throws IOException, URISyntaxException {
        String h1 = "";
        h1 = "\n<body>\n"
                + "<br>\n"
                + "<br>\n"
                + "\n<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">Top</button>\n\n"                
                +"<!-- CamsDiag Table Main Info -->\n"
                + "<table id=\"MainInfo\">\n"
                + "<tr>\n"
                + "<!-- \n"
                + "<td><img src=\""+LibPathServer_HTML_Windir()+"/imgs/bic_icon.png\" width=\"100\" height=\"157\" /><p><b>BIC Group S.A. &copy;</b></p></td>\n"
                + "--> \n"
                + "<td><img src=\""+LibPathServer_HTML_Windir()+"/imgs/camsdiag01.png\" width=\"100\" height=\"100\" /><p>Cams Charts &copy;</p></td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td colspan=2> <b>.:: Cams Diagrams ::.</b> </td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>CAMs Job Name : </b></td>\n"
                + "<td>"+CamJobName()
                //+ "<div id=\"output_job_name\"></div>"
                + "</td>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td><b>Number Of Cams : </b></td>\n"
                + "<td>"+NumberOfCams()
                //+"<div id=\"output_nof_cams\"></div>"
                + "</td>\n"
                + "</tr>\n"
                + ""
                + "<tr>\n"
                + "<td><b>Asm Name : </b></td>\n"
                + "<td><script type=\"text/javascript\">\n"
                + "document.write(AsmName)\n"
                + "</script></td>\n"
                + "</tr>\n"
                + "\n"
                + "<tr>\n"
                + "<td><b>Description : </b></td>\n"
                + "<td><script type=\"text/javascript\">\n"
                + "document.write(AsmDescription)\n"
                + "</script></td>\n"
                + "</tr>\n"
                + ""
                + "<tr>\n"
                + "<td><b>Date : </b></td>\n"
                + "<td><script type=\"text/javascript\">\n"
                + "document.write(dateCams+' - '+formatAMPM(new Date))\n"
                + "</script></td>\n"
                + "</tr>\n"
                + ""
                + "<tr>\n"
                + "<td><b>UserName : </b></td>\n"
                + "<td>"+UserInfo.Get_UserName()+"</td>\n"
                + "</tr>\n"   
                + "<tr>\n"
                + "<td><b>Computer Name : </b></td>\n"
                + "<td>"+UserInfo.Get_ComputerName()+"</td>\n"
                + "</tr>\n"                     
                + "<tr>\n"
                + "<td><b>Java Version: </b></td>\n"
                + "<td>"+UserInfo.Get_JavaVersion()+"</td>\n"
                + "</tr>\n"                
                + "</table>\n"
                +"<!-- END CamsDiag Table Main Info -->\n"
                + "<p id=\"TopPage\"></p>"
                + "<br>\n"
                + "<hr>\n"
                + "<br>\n"
                + HTML_Buttons()
                + HTML_CamAll_Visibility()
                + HTML_CamsMainDIV()
                + HTML_CamsMainImportJS_Files()
                + HTML_CamsJS_Import()
                + HTML_JSlibsBODY_Import()
                + DataTableFilter()
                //+ GetDataURL()
                +"\n<div id=\"dvTable\"></div>\n"
                + "<p align=\"center\"><a href=\"#TopPage\">Go to Top</a></p>"
                + "<p id=\"datatable\"></p>\n"
                + "<script  src=\"https://code.jquery.com/jquery-3.2.1.min.js\" "
                //+ "integrity=\"sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=\"   crossorigin=\"anonymous\""
                + "></script>\n"
                + "<!-- \n"
                + "<script>\n"
                + " $('#camatables').SetEditable({ $addButton: $('#addNewRow')});\n"
                + "</script>\n"
                + "-->\n"
                //+ HTML_CamsImagesDIV()
                //+ HTML_CanvasID()
                +"<!--\n"
                + "\n<input type=\"file\" class=\"button\" id=\"files\" name=\"files[]\" multiple />\n"
                + "<output id=\"list\"></output>\n"
                + "<br>\n"
                + "<div id=\"dropZone\" style=\"width: 200px; height: 200px; background-color: orange\"></div>\n"
                + "<br>\n"
                + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n"
                + "\n"
                + "<div class=\"dragArea\">\n"
                + "  <h3>Drag & Drop File Here</h3>\n"
                + "  <h4>Or Select File:</h4>\n"
                + "  <div>\n"
                + "    <input type=\"file\" id=\"imageFile\" />\n"
                + "  </div>\n"
                + "</div>\n"
                + "\n"
                + "<div class=\"resultImageWrapper\">\n"
                + "\n"
                + "</div>\n"
                + "-->\n"
                
                + HTML_footer()
                + "</body>\n"
                + "</html>";
        return h1;
    }   
    
    
    public static String HTML_CanvasID() {
    String h1="";
    
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("<canvas id=\"canvas"+i+"\"></canvas>\n<br>\n");
        }

        h1 = "<!--\n"+builder.toString()+"\n-->"; 
    
    return h1;
    }
    
    
    

    
}
