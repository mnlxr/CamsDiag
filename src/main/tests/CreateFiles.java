/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

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

/**
 *
 * @author MManolas
 */
public class CreateFiles {

    public static void main(String args[]) throws Exception {
        CamsDiag_Create_MainHTML();
        CamsDiag_Create_MainJobJS_File();
        CamsDiag_Create_CamJobNameTXT();
        CamsDiag_Create_CamJobNameTXT_General();
        CamsDiag_Create_NofCamsTXT();
        CamsDiag_Create_CamsDiag_ParametersFile();
        CamsDiag_Create_CamAll_File();

    }



    public static String CamChart_HTML_CamAll_Visibility() {
    String h1 = "";
        if (NumberOfCams()==1) {
            h1="\n<!-- <div id=\"mainAll\" style=\"width: 100%;height:130mm;\" class=\"chart\"></div> -->\n";
        } else {
            h1 = "\n<div id=\"mainAll\" style=\"width: 100%;height:130mm;\" class=\"chart\"></div>\n";
        }
    return h1;}
    
    public static String CamChart_HTML_div_MainCam() {
        String h1 = "";
        String h2 = "";
        for (int nofcams = 1; nofcams <= NumberOfCams(); nofcams++) {
            h2 = String.valueOf(nofcams);
            h1 = "\n <br>\n<div id=\"maincam" + h2 + "\" style=\"width: 100%;height:130mm;\" class=\"chart\"></div>\n";
        }
        return h1;
    }

    public static String Create_Main_HTML_Part01() throws IOException {
        String h1 = "";
        h1 = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>.:: Cams Diagramms ::.</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        \n"
                + "<!-- jsPdf -->\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/2.3.4/jspdf.plugin.autotable.min.js\"></script>\n"
                + "\n"
                + "<!-- pdfmake -->\n"
                + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.js\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js\"></script>\n"
                + "\n"
                + "        <script src=\"lib/echarts/echarts.js\"></script>\n"
                + "        <script src=\"lib/echarts/echarts.common.js\"></script>\n"
                + "        <script src=\"lib/echarts/echarts.esm.js\"></script>\n"
                + "        <script src=\"lib/echarts/extension/dataTool.js\"></script>        \n"
                + "        <script src=\"lib/echarts/themes/MnIT.js\"></script> \n"
                + "        <script src=\"lib/echarts/themes/walden.js\"></script> \n"
                + "        <script src=\"lib/echarts/jquery-3.2.1.min.js\"></script>\n"
                + "        <script src=\"lib/echarts/jquery-ui.js\"></script>        \n"
                +"       <!--  <script src=\"lib/testHelper.js\"></script> -->\n"
                + "        <!--\n"
                + "        <script src=\"cams/cam_CommonSettings.js\"></script> -->\n"
                + "        <script src=\"lib/mnit/mnit_info.js\"></script>\n"
                + "        <script src=\"" + CamJobName() + "/" + CamJobName() + ".js\"></script>\n"
                + "        \n"
                + "        <script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n"
                + "        <script src=\"http://s1.bdstatic.com/r/www/cache/efe/esl/2-1-6/esl.js\"></script>\n"
                + "        <script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n"
                + "        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>\n"
                + "        <script src=\"//cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js\"></script>\n"
                + "         <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/pure/1.0.1/pure-min.css\">\n"
                + "         <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js\"></script>  \n"
                + "         <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js\"></script> \n"
                + "         <link href=\"//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/jqueryui-editable/css/jqueryui-editable.css\" rel=\"stylesheet\"/>\n"
                + "         <script src=\"//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/jqueryui-editable/js/jqueryui-editable.min.js\"></script>\n"
                + "\n"
                + "        \n"
                + "        \n"
                + "        <link rel=\"stylesheet\" href=\"lib/css/mnit.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"lib/css/jquery-ui.css\">\n"
                + "        \n"
                + "<script>\n"
                + "  jQuery \n"
                + "    .ajax({\n"
                + "      url: '" + CamJobName() + "/CamsDiag_NofCams.txt',\n"
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
                + "      url: '" + CamJobName() + "/CamsDiag_JobName.txt',\n"
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
                + "</script>  \n"
                + "\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <br>\n"
                + "        <table id=\"MainInfo\">            \n"
                + "            <tr>\n"
                + "                <td><img src=\"lib/imgs/bic_icon.png\" width=\"100\" height=\"157\" /><p><b>BIC Group S.A. &copy;</b></p></td>\n"
                + "                <td><img src=\"lib/imgs/camsdiag01.png\" width=\"100\" height=\"100\" /><p>Cams Charts &copy;</p></td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td colspan=2> <b>.:: Cams Diagrams ::.</b> </td>\n"
                + "            </tr>            \n"
                + "            <tr>\n"
                + "                <td><b>CAMs Job Name : </b></td>\n"
                + "                <td><div id=\"output_job_name\"></div></td>\n"
                + "            </tr>    \n"
                + "            <tr>\n"
                + "                <td><b>Number Of Cams : </b></td>\n"
                + "                <td><div id=\"output_nof_cams\"></div></td>\n"
                + "            </tr>             \n"
                + "        </table>\n"
                + "        <br>\n"
                + "        <hr>\n"
                + "      <br>\n"
                + "      <!-- \n"
                + "        <script src=\"cams/cam_Data.js\"></script>\n"
                + "       <script src=\"cams/cam_CommonSettings.js\"></script>\n"
                + "      -->\n"
                //+"<div class=\"btn-group\">\n" +
                + "<div>\n"
                + "<a href=\"" + CamJobName() + "/" + CamJobName() + ".js\" target=\"_blank\" onclick=\"document.location='" + CamJobName() + "/" + CamJobName() + ".js'\"><button class=\"button\" type=\"submit\" style=\"width:20%\">View RAW Data</button></a>\n"
                + "<a href=\"#datatable\"><button class=\"button\" type=\"submit\" style=\"width:20%\">Data Table for " + CamJobName() + "</button></a>\n"
                + "<button class=\"button\" type=\"submit\" style=\"width:20%\" onclick=\"exportExcel()\">Download Images :  " + CamJobName() + "</button>\n"
                + "</div>\n"
                + "<br>";
        return h1;
    }

    public static String Create_Main_HTML_Part03() throws IOException {
        String h1 = "";
        h1 = "        \n"
                + "        <br>  \n"
                + "        <script src=\"" + CamJobName() + "/CamsDiag_Parameters.js\"></script>        \n"
                + "        <br>        \n"
                +"        <script src=\"" + CamJobName() + "/Cam_All.js\"></script>        \n"
                + "        <!-- comment\n"
                + "        <a href=\"" + CamJobName() + "/" + CamJobName() + ".js\" target=\"_blank\" onclick=\"document.location='" + CamJobName() + "/" + CamJobName() + ".js'\"><button class=\"button\" type=\"submit\">Edit Data</button></a>\n"
                + "         -->\n"
                + "<!-- <a href=\"" + CamJobName() + "/" + CamJobName() + ".js\" target=\"_blank\" onclick=\"document.location='" + CamJobName() + "/" + CamJobName() + ".js'\"><button class=\"button\" type=\"submit\">View RAW Data</button></a>\n-->"
                + "<br>\n"
                + "<br>\n"
                + "<script type=\"text/javascript\">  \n"
                + "        function PrintTablePDF() {\n"
                + "            var pdf = new jsPDF('p', 'pt', 'a4');\n"
                + "    pdf.setFont(\"Verdana\", \"bold\");\n"
                + "pdf.setFontStyle('normal');"
                + "    pdf.setFontSize(10);\n"
                + "    pdf.text(10, 10, '.:: CamsDiag Data Table Report ::.');"
                + "pdf.setProperties({\n"
                + "    title: '" + CamJobName() + "CamsDiag',\n"
                + "    subject: '" + CamJobName() + "',\n"
                + "    author: 'Manolis Manolas | manolis.manolas@bicworld.com',\n"
                + "    keywords: 'cams, diagamms, charts',\n"
                + "    creator: 'CamsDiag - BIC Violex S.A.'\n"
                + "});"
                + "pdf.cellInitialize();"
                + "            // source can be HTML-formatted string, or a reference\n"
                + "            // to an actual DOM element from which the text will be scraped.\n"
                + "            source = $('#dataCamTablePDF')[0];\n"
                + "\n"
                + "            // we support special element handlers. Register them with jQuery-style \n"
                + "            // ID selector for either ID or node name. (\"#iAmID\", \"div\", \"span\" etc.)\n"
                + "            // There is no support for any other type of selectors \n"
                + "            // (class, of compound) at this time.\n"
                + "            specialElementHandlers = {\n"
                + "                // element with id of \"bypass\" - jQuery style selector\n"
                + "                '#bypassme': function(element, renderer) {\n"
                + "                    // true = \"handled elsewhere, bypass text extraction\"\n"
                + "                    return true\n"
                + "                }\n"
                + "            };\n"
                + "            margins = {\n"
                + "                top: 80,\n"
                + "                bottom: 60,\n"
                + "                left: 40,\n"
                + "                width: 522\n"
                + "            };\n"
                + "            // all coords and widths are in jsPDF instance's declared units\n"
                + "            // 'inches' in this case\n"
                + "            pdf.fromHTML(\n"
                + "                    source, // HTML string or DOM elem ref.\n"
                + "                    margins.left, // x coord\n"
                + "                    margins.top, {// y coord\n"
                + "                        'width': margins.width, // max width of content on PDF\n"
                + "                        'elementHandlers': specialElementHandlers\n"
                + "                    },\n"
                + "            function(dispose) {\n"
                + "                // dispose: object with X, Y of the last line add to the PDF \n"
                + "                //          this allow the insertion of new lines after html\n"
                + "                pdf.save('" + CamJobName() + "_DataTable.pdf');\n"
                + "            }\n"
                + "            , margins);\n"
                + "        }"
                + "</script>"
                + "<br>\n"
                + "<button onclick=\"javascript:PrintTablePDF()\">PDF</button>  \n"
                + "<br>"
                + "<div id=\"dataCamTablePDF\">\n"
                + "<p id=\"datatable\"></p>\n"
                + "\n<table id=\"camTable\" class=\"camsdiagTable\"></table>\n\n"
                + "</div>\n"
                + "<footer  id=\"footer\">\n"
                + "<hr>\n"
                + "<p>© All rights reserved by Bic Group S.A., including cases of proprietary applications. \n"
                + "        We retain sole power of disposal including all righty relating to copying and distribution.</p>\n"
                + "<p>BIC Violex S.A. - Developer : <a href=\"mailto:manolis.manolas@bicworld.com\">M.Manolas</a> - 2021 </p>\n"
                + "</footer>\n"
                + "    </body>\n"
                + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js\"></script>\n"
                + "<script src=\"lib/others/mindmup-editabletable.js\"></script>"
                + "<script>\n"
                + "$('#camTable').editableTableWidget({editor: $('<textarea>')});\n"
                + "</script>\n"
                + "</html>\n"
                + "";
        return h1;
    }

    public static void CamsDiag_Create_MainHTML() throws FileNotFoundException, IOException, Exception {
        File statText = new File(Create_CamJobFolder() + ".html");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(Create_Main_HTML_Part01()
            );
            w.write(CamChart_HTML_CamAll_Visibility()
                    //+"Cam_All.js"
            );
            String h1 = "", h2 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                h2 = String.valueOf(NumberOfCams);
                w.write(
                        h1 = "\n<br>\n<div id=\"maincam" + h2 + "\" style=\"width: 100%;height:130mm;\" class=\"chart\"></div>\n"
                      //  + "<canvas id=\"canvas" + h2 + "\"></canvas>"
                );
            }
            w.write(Create_Main_HTML_Part03()
            );
            w.close();
        }
    }

    public static void CamsDiag_Create_NofCamsTXT() throws FileNotFoundException, IOException, Exception {
        File statText = new File(CamJobName() + "//CamsDiag_NofCams.txt");
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = String.valueOf(NumberOfCams())
            );
            w.close();
        }
    }

    public static void CamsDiag_Create_CamJobNameTXT_General() throws FileNotFoundException, IOException, Exception {
        File statText = new File("CamsDiag_JobName.txt");
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = CamJobName()
            );
            w.close();
        }
    }

    public static void CamsDiag_Create_CamJobNameTXT() throws FileNotFoundException, IOException, Exception {
        File statText = new File(CamJobName() + "//CamsDiag_JobName.txt");
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = CamJobName()
            );
            w.close();
        }
    }

    public static void CamsDiag_Create_MainJobJS_File() throws FileNotFoundException, IOException, Exception {
        File statText = new File(CamJobName() + "//" + CamJobName() + ".js");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write("var AsmName = \"ASM00001\";\n"
                    + "var AsmDescription = \"Description Assy Machine #1\";"
            +"\n//////////////////////////////////////////////\n");
            
            String h1 = "", h2 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                h2 = String.valueOf(NumberOfCams);
                w.write(
                        h1 = "\n//////////////////////////////////////////////\n"
                        + "var cam" + h2 + "label = \"CDMD" + h2 + "\";\n"
                        + "var cam" + h2 + "x = [0, 90, 160, 240, 310, 360];\n"
                        + "var cam" + h2 + "y = [43, 43, 52.5, 52.5, 43, 43];\n"
                        + "var cam" + h2 + "descl = \"CAM Description #" + h2 + "\";\n"
                        + "var cam" + h2 + "diameter = 30;\n"
                );
            }

            w.close();
        }
    }

    
    public static void CamsDiag_Create_CamAll_File() throws FileNotFoundException, IOException, Exception {
        File statText = new File(CamJobName() + "//Cam_All.js");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write("\nvar myChart = echarts.init(document.getElementById('mainAll', 'walden'));\n"
                    + "var symbolSize = 10;\n"
                    +"var AxisCamAllYmax=150\n"
//                    + "array.reduce(function(max, arr) { \n"
//                    + "    return Math.max(max, arr[0]); \n"
//                    + "}, -Infinity)\n"
                    + "var option = {\n"
                    + "\n"
                    + "//    aria: {\n"
                    + "//        enabled: true,\n"
                    + "//       decal: {\n"
                    + "//           show: true\n"
                    + "//       }\n"
                    + "//   },\n"
                    + "    title: {\n"
                    + "\n"
                    + "        text: AsmName, //Main title\n"
                    + "        textStyle: {\n"
                    + "            color: '#767676', //colour\n"
                    + "            fontStyle: 'normal', //style\n"
                    + "            fontWeight: 'bold', //Thickness\n"
                    + "            //fontFamily:'Arial',   //Font\n"
                    + "            fontSize: 14, //size\n"
                    + "            align: 'center'   //Horizontal alignment\n"
                    + "        },\n"
                    + "        subtext: AsmDescription, //subtitle\n"
                    + "        subtextStyle: {//Corresponding style\n"
                    + "            color: '#767676',\n"
                    + "            fontSize: 14\n"
                    + "        },\n"
                    + "        itemGap: 10\n"
                    + "    },\n" 
                    + "    legend: {\n"
                    + "        type: \"scroll\",\n"
                    + "        show: true,\n"
                    + "        data: [\n");
                    
            String ser3 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                ser3 = String.valueOf(NumberOfCams);
                w.write("cam"+ser3+"label,\n");
            }            
            
                    //+ "            cam1label, cam2label, cam3label\n"
                    
                    w.write("        ],\n"
                    + "        lineStyle: {\n"
                    + "            shadowOffsetY: 1.5,\n"
                    + "            color: \"#767676\"\n"
                    + "        },\n"
                    + "        textStyle: {\n"
                    + "            fontStyle: \"normal\",\n"
                    + "            borderDashOffset: 2,\n"
                    + "            textShadowBlur: 1\n"
                    + "\n"
                    + "        },\n"
                    + "        icon: \"roundRect\"\n"
                    + "\n"
                    + "    },"
                            + ""
                            + "\n"
                            +"                visualMap: {\n" +
"                    top: 'middle',\n" +
"                    right: 10,\n" +
"                    color: ['red', 'yellow'],\n" +
"                    calculable: true\n" +
"                },"
                    + "    toolbox: {\n" 
                    + "                itemSize:25,\n"
                    + "        feature: {             \n"
                    + "            mark : {show: true},\n"
                    + "            dataView: {show: true, \n"
                    + "                readOnly: false, \n"
                    + "                title: 'Data View', \n"
                    + "                lang: ['Data View', 'Close', 'Refresh'], \n"
                    + "                backgroundColor: 'rgb(252, 184, 49)', \n"
                    + "                textColor: '#222',\n"
                    + "                buttonColor : '#c23531'\n"
                    + "            },\n"
                    + "        magicType: {show: true, type: ['line','bar']},\n"
                    + "            saveAsImage: {\n"
                    + "                backgroundColor: '#FFF',\n"
                    + "                excludeComponents: ['toolbox'],\n"
                    + "                show: true,\n"
                    + "                type: 'png'\n"
                    + "                //excludeComponents  = ['toolbox'],\n"
                    + "                //name: title + Date.parse(new Date())/1000\n"
                    + "            },\n"
                    + "            dataZoom: {show: true},\n"
                    + "            restore: {show: true}\n"
                    + "        }\n"
                    + "    },\n"
                    + "    tooltip: {\n"
                    + "        trigger: 'axis',\n"
                    + "        //formatter: '<br/><b>{a}</b><br/>x,y = ({b}{c})',         \n"
                    + "        axisPointer: {\n"
                    + "            type: 'cross',\n"
                    + "            //axis: 'y',\n"
                    + "            animation: true,\n"
                    + "            lineStyle: {\n"
                    + "                color: '#767676',\n"
                    + "                shadowBlur: 4,\n"
                    + "                shadowColor: '#000',\n"
                    + "                shadowOffsetX: 3,\n"
                    + "                shadowOffsetY: 3\n"
                    + "            }\n"
                    + "        },\n"
                    + "        position: 'center',\n"
                    + "        label: {\n"
                    + "            backgroundColor: '#6a7985'\n"
                    + "        }\n"
                    + "    },\n"
                    + "    grid: {\n"
                    + "        left: '3%',\n"
                    + "        right: '4%',\n"
                    + "        bottom: '10%',\n"
                    + "        top: '20%',\n"
                    + "        containLabel: true,\n"
                    + "        show: true\n"
                    + "    },\n"
                    + "    xAxis: {\n"
                    + "        type: 'value',\n"
                    + "        id: '1',\n"
                    + "        scale: true,\n"
                    + "        boundaryGap: true,\n"
                    + "        splitNumber: 10,\n"
                    + "        min: 0,\n"
                    + "        max: 360,\n"
                    + "        interval: 10,\n"
                    + "        axisTick: {\n"
                    + "            inside: true,\n"
                    + "            show: true,\n"
                    + "            alignWithLabel: true\n"
                    + "        },\n"
                    + "        axisLine: {\n"
                    + "            symbol: ['none', 'arrow'],\n"
                    + "            lineStyle: {\n"
                    + "                color: 'black'\n"
                    + "            },\n"
                    + "            symbolOffset: 10,\n"
                    + "            show: true\n"
                    + "        },\n"
                    + "        splitLine: {\n"
                    + "            show: true,\n"
                    + "            lineStyle: {\n"
                    + "                type: 'solid',\n"
                    + "                color: '#ccc'\n"
                    + "            }\n"
                    + "        },\n"
                    + "        minorTick: {\n"
                    + "            show: true\n"
                    + "        },\n"
                    + "        minorSplitLine: {\n"
                    + "            show: true\n"
                    + "        },\n"
                    + "        axisLabel: {\n"
                    + "            formatter: \"{value} °\"\n"
                    + "        }\n"
                    + "    },\n"
                    + "    yAxis: {\n"
                    + "        type: 'value',\n"
                    + "        id: '2',\n"
                    + "        min: 0,\n"
                    + "        max: AxisCamAllYmax,\n"
                    + "        interval: 10,\n"
                    + "        boundaryGap: true,\n"
                    + "        splitNumber: 10,\n"
                    + "        axisTick: {\n"
                    + "            inside: true,\n"
                    + "            show: true,\n"
                    + "            alignWithLabel: true\n"
                    + "        },\n"
                    + "        axisLine: {\n"
                    + "            symbol: ['none', 'arrow'],\n"
                    + "            lineStyle: {\n"
                    + "                color: 'black'\n"
                    + "            },\n"
                    + "            symbolOffset: 10,\n"
                    + "            show: true\n"
                    + "        },\n"
                    + "        splitLine: {\n"
                    + "            show: true,\n"
                    + "            lineStyle: {\n"
                    + "                type: 'solid',\n"
                    + "                color: '#ccc'\n"
                    + "            }\n"
                    + "        },\n"
                    + "        axisLabel: {\n"
                    + "            formatter: \"{value} mm\"\n"
                    + "        }\n"
                    + "    },\n"
                    + "    calculable: true,\n"
                    + "                dataZoom: [\n"
                    + "                    //{\n"
                    + "//                        show: true,\n"
                    + "//                        realtime: true,\n"
                    + "//                        xAxisIndex: [0],\n"
                    + "//                        start: 0,\n"
                    + "//                        end: 360\n"
                    + "//                    },\n"
                    + "                    {\n"
                    + "                        show: true,\n"
                    + "                        realtime: true,\n"
                    + "                        yAxisIndex: [0],\n"
                    + "                        start: 0,\n"
                    + "                        end: 120\n"
                    + "                    },\n"
                    + "                    {\n"
                    + "                        type: 'inside',\n"
                    + "                        realtime: true,\n"
                    + "                        xAxisIndex: [0],\n"
                    + "                        start: 0,\n"
                    + "                        end: 360\n"
                    + "                    },\n"
                    + "                    {\n"
                    + "                        type: 'inside',\n"
                    + "                        realtime: true,\n"
                    + "                        yAxisIndex: [0],\n"
                    + "                        start: 30,\n"
                    + "                        end: 120\n"
                    + "                    }\n"
                    + "                    \n"
                    + "                ],\n"
//                            + "    visualMap: {\n"
//                            + "        type: 'continuous',\n"
//                            +"        dimension: 0,\n"
//                            +"        name: \"Deg \",\n"
//                            +"        orient: 'horizontal',\n"
//                            + "        min: 0,\n"
//                            + "        max: 360, \n"
//                            + "        left: 'center',\n"
//                            + "        bottom: 25,\n"
//                            + "        inRange:{\n"
//                            + "            color:[\"white\", \"red\"]\n"
//                            + "        }\n"
//                            + "    },"
                            
                            
                            
//                    + "    visualMap: [\n"
//                    + "        {\n"
//                    + "            type: 'continuous',\n"
//                    + "            name: \"Deg \",\n"
//                    + "            //backgroundColor: \"#eee\",\n"
//                    + "            left: 'center',\n"
//                    + "            //left: 'center',\n"
//                    + "            orient: 'horizontal',\n"
//                    + "            //orient: 'vertical',\n"
//                    + "            itemWidth: 20,\n"
//                    + "            itemHeight: 600,\n"
//                    + "            bottom: 25,\n"
//                            +" dimension: 1,\n" +
//"    seriesIndex: 0,\n"
//                    + "   padding: [\n"
//                    + "        10,\n"
//                    + "        30,\n"
//                    + "        0,\n"
//                    + "        40\n"
//                    + "    ],            \n"
//                    //+ "            dimension: 0,\n"
//                    + "            calculable: true,\n"
//                    + "            splitNumber: 7,\n"
//                    + "            text: [\n"
//                    + "                \"Deg Max  \",\n"
//                    + "                \"Deg Min  \"\n"
//                    + "            ],\n"
//                    + "            min: 0,\n"
//                    + "            max: 360,\n"
//                    + "            //precision: 2,\n"
//                    + "            inRange: {\n"
//                    + "                opacity: [1, 1], \n"
//                    + "                label: \"Warning\",\n"
//                    + "            },\n"
//                    + "            controller: {\n"
//                    + "                inRange: {\n"
//                    + "                    //color: [bic_color,shaftcolor_emp]\n"
//                    + "                },\n"
//                    + "                outOfRange: {\n"
//                    + "                    color: '#888'\n"
//                    + "                }\n"
//                    + "            },\n"
//                    + "            outOfRange: {\n"
//                    + "                opacity: [0.2, 0.2] // Using opacity when label color specified\n"
//                    + "            }\n"
//                    + "        }\n"
//                    + "    ],\n"
                            + "\n"
                            + "\n"
                            + "\n"
                            
//                            + " visualMap: [{\n" +
//"            left: 'right',\n" +
//"            top: '10%',\n" +
//"            dimension: 0,\n" +
//"            min: 0,\n" +
//"            max: 360,\n" +
//"            itemWidth: 30,\n" +
//"            itemHeight: 120,\n" +
//"            calculable: true,\n" +
//"            //precision: 0.1,\n" +
//"            text: ['Deg ：PM2.5'],\n" +
//"            textGap: 30,\n" +
//"            inRange: {\n" +
//"                symbolSize: [10, 70]\n" +
//"            },\n" +
//"            outOfRange: {\n" +
//"                symbolSize: [10, 70],\n" +
//"                color: ['rgba(255,255,255,0.4)']\n" +
//"            },\n" +
//"            controller: {\n" +
//"                inRange: {\n" +
//"                    color: ['#c23531']\n" +
//"                },\n" +
//"                outOfRange: {\n" +
//"                    color: ['#999']\n" +
//"                }\n" +
//"            }\n" +
//"        },],\n"
                    + "series: [");
            String ser1 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                ser1 = String.valueOf(NumberOfCams);
                w.write("        {\n" +
"            name: cam"+ser1+"label,\n" +
"            type: 'line',\n" +
"            seriesLayoutBy: 'row',\n" +
"            symbolSize: symbolSize,\n" +
"            //stack: true,\n" +
"            areaStyle: {},\n" +
"            emphasis: {\n" +
"                focus: 'series',                \n" +
"                lineStyle: {\n" +
"                    width: linestulemfasis + 3,\n" +
"                    opacity: 0.8\n" +
"                }\n" +
"            },\n" +
"            markArea: {\n" +
"                itemStyle: {\n" +
"                    // normal: {\n" +
"                    //     color: 'red'\n" +
"                    // },\n" +
"                    emphasis: {\n" +
"                        color: '#767676'\n" +
"                    }\n" +
"                },\n" +
"                label: {\n" +
"\n" +
"                    show: true,\n" +
"                    position: 'top',\n" +
"                    color: \"black\",\n" +
"                    fontSize: 12\n" +
"                },\n" +
"                labelLayout: {\n" +
"                    hideOverlap: false\n" +
"                },\n" +
"                data: [\n" +
"                    [{\n" +
"                            //name: shaftdiam_label_cam"+ser1+",\n" +
"                            yAxis: 0\n" +
"                        }, "
        + "{\n" +
"                            yAxis: cam"+ser1+"diameter\n" +
"                        }]\n" +
"                ]\n" +
"            },\n" +
"            z: 1,\n" +
"            label: {\n" +
"                show: true\n" +
"            },\n" +
"            lineStyle: {\n" +
"                width: linestulemfasis,\n" +
"                shadowColor: 'black',\n" +
"                oppacity: 0.5,\n" +
"                shadowBlur: 5,\n" +
"                shadowOffsetY: 2,\n" +
"                color: shaftcolor_emp\n" +
"            },\n" +
"            data: datacam"+ser1+"\n" +
"        },\n");
            }
            
            w.write("]\n"
                    + "};\n"
                    + "function onDrag() {\n"
                    + "    var height = chart.getHeight();\n"
                    + "    var splitNumber = height < 200\n"
                    + "            ? 2\n"
                    + "            : height < 300\n"
                    + "            ? 4\n"
                    + "            : null;\n"
                    + "    console.log(height, splitNumber);\n"
                    + "    chart.setOption({\n"
                    + "        yAxis: {splitNumber: splitNumber}\n"
                    + "    });\n"
                    + "    chart.resize();\n"
                    + "}\n"
                    + "\n\n\n"
                    + "myChart.showLoading({\n" +
"      text: 'loading',\n" +
"      color: '#c23531',\n" +
"      textColor: '#000',\n" +
"      maskColor: 'rgba(255, 255, 255, 0.2)',\n" +
"      zlevel: 0\n" +
"    });;\n" +
"setTimeout(() => {\n" +
"  myChart.hideLoading();\n" +
"  myChart.setOption(option);\n" +
"}, 1000);\n"
                    + ""
                    + "myChart.setOption(option);\n");
 w.close();
        }
    }    
    
    
    public static String Create_CamJobFolder() throws IOException {
        String dir = CamJobName();

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }

    public static void CamsDiag_Create_JS_Parameters() throws FileNotFoundException, IOException, Exception {
        File statText = new File(Create_CamJobFolder() + ".html");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    Create_Main_HTML_Part01()
            );
            String h1 = "", h2 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                h2 = String.valueOf(NumberOfCams);
                w.write(
                        h1 = "\n<br>\n<div id=\"maincam" + h2 + "\" style=\"width: 100%;height:130mm;\" class=\"chart\"></div>\n"
                );
            }
            w.write(
                    Create_Main_HTML_Part03()
            );
            w.close();
        }

    }

    public static void CamsDiag_Create_CamsDiag_ParametersFile() throws FileNotFoundException, IOException, Exception {
        File statText = new File(CamJobName() + "//CamsDiag_Parameters.js");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write("var showLabels = false;\n\n"
                    + "/***\n"
                    + " *      ____           _   _       _      _____ ____ ___ _____ \n"
                    + " *     |  _ \\  ___    | \\ | | ___ | |_   | ____|  _ \\_ _|_   _|\n"
                    + " *     | | | |/ _ \\   |  \\| |/ _ \\| __|  |  _| | | | | |  | |  \n"
                    + " *     | |_| | (_) |  | |\\  | (_) | |_   | |___| |_| | |  | |  \n"
                    + " *     |____/ \\___/   |_| \\_|\\___/ \\__|  |_____|____/___| |_|  \n"
                    + " *                                                             \n"
                    + " */"
                    + ""
                    + "");
            String h1 = "", h2 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                h2 = String.valueOf(NumberOfCams);
                w.write(
                        h1
                        = "\n/***********************************************/"
                        + "\n\n/*Cam #" + h2 + "*/\n"
                        + "var myChart_Cam" + h2 + " = echarts.init(document.getElementById('maincam" + h2 + "'), 'walden');\n"
                        + "var shaftdiam_cam" + h2 + " = cam" + h2 + "diameter;\n"
                        + "var shaftdiam_label_cam" + h2 + " = \"Shaft Diameter : \" + shaftdiam_cam" + h2 + " + \" mm\";\n"
                        + "var AxisMax_cam" + h2 + " = Math.max.apply(null, cam" + h2 + "y) + 30;\n"
                        + "var AxisMin_cam" + h2 + " = 0;\n"
                        + "var Recc" + h2 + " = Math.max.apply(null, cam" + h2 + "y) - Math.min.apply(null, cam" + h2 + "y);\n"
                        + "//////////////////////////////////////////////\n"
                        + "var points" + h2 + " = [];\n"
                        + "//////////////////////////////////////////////\n"
                        + "var mycanvas" + h2 + " = $(\"#maincam" + h2 + "\").find(\"canvas\")[" + h2 + "];\n"
                        + "//////////////////////////////////////////////\n"
                        + "var data_cam" + h2 + " = [];\n"
                        + "for (i = 0; i < cam" + h2 + "x.length; i++)\n"
                        + "{ data_cam" + h2 + ".push([cam" + h2 + "x[i], cam" + h2 + "y[i]]);}\n"
                        + "var datacam" + h2 + " = data_cam" + h2 + ";\n"
                        + "// Costumize the options and data of the chart.\n"
                        + "var option_cam" + h2 + " = {\n"
                        + " title: {\n"
                        + "        text: cam" + h2 + "label + \" - C" + h2 + "\\n\" + cam" + h2 + "descl, //Main title\n"
                        + "        padding: 10,\n"
                        + "        textStyle: {\n"
                        + "            color: text_color,\n"
                        + "            fontStyle: 'normal',\n"
                        + "            fontWeight: 'bold',\n"
                        + "            fontSize: 14,\n"
                        + "            align: 'center'\n"
                        + "        },\n"
                        + "        subtext: \"\\nEccentric  : \" + Recc" + h2 + " + \" mm\",\n"
                        + "        subtextStyle: {\n"
                        + "            padding: 15,\n"
                        + "            color: text_color,\n"
                        + "            fontSize: 13\n"
                        + "        },\n"
                        + "        itemGap: 5\n"
                        + "    },\n"
                        + "    legend: {\n"
                        + "        type: \"scroll\",\n"
                        + "        show: true,\n"
                        + "        data: [cam" + h2 + "descl],\n"
                        + "        lineStyle: {\n"
                        + "            shadowOffsetY: 1.5,\n"
                        + "            color: text_color\n"
                        + "        },\n"
                        + "        textStyle: {\n"
                        + "            fontStyle: \"normal\",\n"
                        + "            borderDashOffset: 2,\n"
                        + "            textShadowBlur: 1\n"
                        + "        },\n"
                        + "        icon: \"roundRect\"\n"
                        + "    },\n"
                        + "    toolbox: {\n"
                        + "        itemSize: 20,\n"
                        + "        feature: {\n"
                        + "            mark: {show: true},\n"
                        + "            dataView: {show: true,\n"
                        + "                readOnly: false,\n"
                        + "                title: 'Data View',\n"
                        + "                lang: [cam" + h2 + "label + \" Data : \", 'Close', 'Refresh'],\n"
                        + "                backgroundColor: 'rgb(252, 184, 49)',\n"
                        + "                textColor: '#222',\n"
                        + "                buttonColor: '#c23531'           \n"
                        + "            },\n"
                        + "            magicType: {\n"
                        + "                show: true, \n"
                        + "                type: ['line', 'bar'],\n"
                        + "            barMaxWidth:'20%'\n"
                        + "        },\n"
                        + "            saveAsImage: {\n"
                        + "                backgroundColor: '#FFF',\n"
                        + "                excludeComponents: ['toolbox'],\n"
                        + "                show: true,\n"
                        + "                type: 'png'\n"
                        + "            },\n"
                        + "            dataZoom: {show: true},\n"
                        + "            restore: {show: true}\n"
                        + "        }\n"
                        + "    },\n"
                        + "    tooltip: {\n"
                        + "        trigger: 'axis',\n"
                        + "        confine: true,\n"
                        + "        formatter: function (params) {\n"
                        + "            params = params[0];\n"
                        + "            var val = '<li style=\"list-style:none\">' + params.marker + \" \" +\n"
                        + "                    '&nbsp;&nbsp;' + 'R(mm) = ' + params.value[1] + ' mm, Deg = ' + params.value[0] + ' °' + '</li>';\n"
                        + "            return val;\n"
                        + "        },\n"
                        + "\n"
                        + "        axisPointer: {\n"
                        + "            type: 'cross',\n"
                        + "            //axis: 'y',\n"
                        + "            animation: true,\n"
                        + "            lineStyle: {\n"
                        + "                color: text_color,\n"
                        + "                shadowBlur: 4,\n"
                        + "                shadowColor: '#000',\n"
                        + "                shadowOffsetX: 3,\n"
                        + "                shadowOffsetY: 3\n"
                        + "            }\n"
                        + "        },\n"
                        + "        position: 'center',\n"
                        + "        label: {\n"
                        + "            backgroundColor: '#6a7985'\n"
                        + "\n"
                        + "        }\n"
                        + "    },    \n"
                        + "    grid: {\n"
                        + "        left: '3%',\n"
                        + "        right: '4%',\n"
                        + "        bottom: '10%',\n"
                        + "        top: '20%',\n"
                        + "        containLabel: true,\n"
                        + "        show: true\n"
                        + "    },\n"
                        + "    xAxis: {\n"
                        + "        type: 'value',\n"
                        + "        id: 'cam" + h2 + "X',\n"
                        + "        scale: true,\n"
                        + "        data: datacam" + h2 + ",\n"
                        + "        boundaryGap: false,\n"
                        + "        splitNumber: 10,\n"
                        + "        min: 0,\n"
                        + "        max: 360,\n"
                        + "        interval: 10,\n"
                        + "        axisTick: {\n"
                        + "            inside: true,\n"
                        + "            show: true,\n"
                        + "            alignWithLabel: true\n"
                        + "        },\n"
                        + "        axisLine: {\n"
                        + "            symbol: ['none', 'arrow'],\n"
                        + "            lineStyle: {\n"
                        + "                color: 'black'\n"
                        + "            },\n"
                        + "            symbolOffset: 10,\n"
                        + "            show: true\n"
                        + "        },\n"
                        + "        splitLine: {\n"
                        + "            show: true,\n"
                        + "            lineStyle: {\n"
                        + "                type: 'solid',\n"
                        + "                color: '#ccc'\n"
                        + "            }\n"
                        + "        },\n"
                        + "        minorTick: {\n"
                        + "            show: true\n"
                        + "        },\n"
                        + "        minorSplitLine: {\n"
                        + "            show: true\n"
                        + "        },\n"
                        + "        axisLabel: {\n"
                        + "            formatter: \"{value} °\"\n"
                        + "        }\n"
                        + "    },\n"
                        + "    yAxis: {\n"
                        + "        type: 'value',\n"
                        + "        id: 'cam" + h2 + "Y',\n"
                        + "        min: 0,\n"
                        + "        max: AxisMax_cam" + h2 + ",\n"
                        + "        interval: 10,\n"
                        + "        boundaryGap: false,\n"
                        + "        data: datacam" + h2 + ",\n"
                        + "        splitNumber: 10,\n"
                        + "        axisTick: {\n"
                        + "            inside: true,\n"
                        + "            show: true,\n"
                        + "            alignWithLabel: true\n"
                        + "        },\n"
                        + "        axisLine: {\n"
                        + "            symbol: ['none', 'arrow'],\n"
                        + "            lineStyle: {\n"
                        + "                color: 'black'\n"
                        + "            },\n"
                        + "            symbolOffset: 10,\n"
                        + "            show: true\n"
                        + "        },\n"
                        + "        splitLine: {\n"
                        + "            show: true,\n"
                        + "            lineStyle: {\n"
                        + "                type: 'solid',\n"
                        + "                color: '#ccc'\n"
                        + "            }\n"
                        + "        },\n"
                        + "        minorTick: {\n"
                        + "            show: true\n"
                        + "        },\n"
                        + "        minorSplitLine: {\n"
                        + "            show: true\n"
                        + "        },\n"
                        + "        axisLabel: {\n"
                        + "            formatter: \"{value} mm\"\n"
                        + "        }\n"
                        + "    },\n"
                        + "    calculable: true,\n"
                        + "    dataZoom: [\n"
                        + "        {\n"
                        + "            type: 'inside',\n"
                        + "            realtime: true,\n"
                        + "            xAxisIndex: [0],\n"
                        + "            start: 0,\n"
                        + "            end: 360\n"
                        + "        },\n"
                        + "        {\n"
                        + "            type: 'inside',\n"
                        + "            realtime: true,\n"
                        + "            yAxisIndex: [0],\n"
                        + "            start: 0,\n"
                        + "            end: 120\n"
                        + "        }\n"
                        + "    ],    \n"
                        + "    series: [{\n"
                        + "            id: 'cam" + h2 + "',\n"
                        + "            data: data_cam" + h2 + ",\n"
                        + "            name: cam" + h2 + "descl,\n"
                        + "            type: 'line',\n"
                        + "            //stack: 'all',\n"
                        + "            symbolSize: symbolSize,\n"
                        + "            smooth: false,\n"
                        + "            opacity: chart_opacity,\n"
                        + "            markLine: {\n"
                        + "                symbol: \"none\",\n"
                        + "                data: [\n"
                        + "                    {\n"
                        + "                        silent: false,\n"
                        + "                        lineStyle: {\n"
                        + "                            type: \"dashed\",\n"
                        + "                           // color: \"#FA3934\",\n"
                        + "                            width: linestulemfasis - 3,\n"
                        + "                            opacity: chart_opacity\n"
                        + "                        },\n"
                        + "                        label: {\n"
                        + "                            formatter: shaftdiam_cam" + h2 + " + ' mm',\n"
                        + "                            fontSize: '10'\n"
                        + "                        },\n"
                        + "                        yAxis: shaftdiam_cam" + h2 + "\n"
                        + "                    }]},\n"
                        + "\n"
                        + "            markArea: {\n"
                        + "                animation: true,\n"
                        + "                animationEasing: \"quarticIn\",\n"
                        + "                z: -1,\n"
                        + "\n"
                        + "                itemStyle: {\n"
                        + "                    normal: {\n"
                        + "                        color: bic_color,\n"
                        + "                        opacity: chart_opacity\n"
                        + "                    },\n"
                        + "                    emphasis: {\n"
                        + "                        color: shaftcolor_emp,\n"
                        + "                        opacity: chart_opacity\n"
                        + "                    }\n"
                        + "                },\n"
                        + "                label: {\n"
                        + "                    show: false,\n"
                        + "                    position: 'top',\n"
                        + "                    color: \"black\",\n"
                        + "                    fontSize: 12\n"
                        + "                },\n"
                        + "                labelLayout: {\n"
                        + "                    hideOverlap: true\n"
                        + "                },\n"
                        + "                data: [\n"
                        + "                    [{\n"
                        + "                            name: shaftdiam_label_cam" + h2 + ",\n"
                        + "                            yAxis: 0\n"
                        + "                        }, {\n"
                        + "                            yAxis: shaftdiam_cam" + h2 + "\n"
                        + "                        }]\n"
                        + "                ]\n"
                        + "            },\n"
                        + "\n"
                        + "            emphasis: {\n"
                        + "                focus: 'series',\n"
                        + "                lineStyle: {\n"
                        + "                    width: linestulemfasis + 3,\n"
                        + "                    opacity: chart_opacity\n"
                        + "                }\n"
                        + "            },\n"
                        + "            label: {\n"
                        + "                show: showLabels\n"
                        + "            },\n"
                        + "            lineStyle: {\n"
                        + "                width: linestulemfasis,\n"
                        + "                shadowColor: 'black',\n"
                        + "                oppacity: 0.5,\n"
                        + "                shadowBlur: 5,\n"
                        + "                shadowOffsetY: 2,\n"
                        + "                color: shaftcolor_emp\n"
                        + "            },\n"
                        + "            z: 0,\n"
                        + "            areaStyle: {\n"
                        + "                color: bic_color,\n"
                        + "                origin: \"start\",\n"
                        + "                offset: 0,\n"
                        + "                opacity: 0.75\n"
                        + "            }\n"
                        + "        }]\n"
                        + "};\n"
                        + "\n"
                        + "\n"
                        + "////////////////////////////////////////////////////\n"
                        + "//End Of Charts\n"
                        + "////////////////////////////////////////////////////\n\n"
                );
            }

            w.write(
                    "\n//Functions \n\n");

            /////////////////////////////////////
            w.write("\n//Table Cam X,Y Values and labels\n");
            String hhz = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                hhz = String.valueOf(NumberOfCams);
                w.write(""
                        + "const tblcam" + hhz + "x = cam" + hhz + "x;\n"
                        + "const tblcam" + hhz + "y = cam" + hhz + "y;\n"
                        + "let txt" + hhz + "x = \"\";\n"
                        + "let txt" + hhz + "y = \"\";\n"
                        + "tblcam" + hhz + "x.forEach(tbldatacam" + hhz + "x);\n"
                        + "\n"
                        + "tblcam" + hhz + "y.forEach(tbldatacam" + hhz + "y);\n"
                        + "\n"
                        + "var c" + hhz + "xtbl;\n"
                        + "cam" + hhz + "x.forEach(function(value) { \n"
                        + "c" + hhz + "xtbl=value;\n"
                        + "console.log(value);\n"
                        + "});\n"
                        + "var camArray" + hhz + "x=cam" + hhz + "x.toString();\n"
                        + "var camArray" + hhz + "y=cam1y.toString();\n"
                        + "\nfunction Cam" + hhz + "_X_Values() {\n"
                        + "var text=\"\";\n"
                        + "var text, fLen, i;\n"
                        + "fLen = cam" + hhz + "x.length;\n"
                        + "for (i = 0; i < fLen; i++) {\n"
                        + "  text += cam" + hhz + "x[i]+\"<br>\";\n"
                        + "}\n"
                        + "return text;\n"
                        + "}\n"
                        + "\n"
                        + "function Cam" + hhz + "_Y_Values() {\n"
                        + "var text=\"\";\n"
                        + "var text, fLen, i;\n"
                        + "fLen = cam" + hhz + "y.length;\n"
                        + "for (i = 0; i < fLen; i++) {\n"
                        + "  text += cam" + hhz + "y[i]+\"<br>\";\n"
                        + "}\n"
                        + "return text;\n"
                        + "}\n\n"
                        //+"document.getElementById(\"ct"+ hhz + "x\").innerHTML = txt"+ hhz + "x;\n"                                
                        //+"document.getElementById(\"ct"+ hhz + "y\").innerHTML = txt"+ hhz + "y;\n"  

                        + "function tbldatacam" + hhz + "x(value, index, array) {\n"
                        + "  txt" + hhz + "x += value " + "\n"
                        + "+ \"<br>\""
                        + ";\n"
                        + "}\n"
                        + "function tbldatacam" + hhz + "y(value, index, array) {\n"
                        + "  txt" + hhz + "y += value " + "\n"
                        + "+ \"<br>\""
                        + ";\n"
                        + "}\n"
                );
            }

            w.write("\nfunction TableCam() {\n"
                    + "\n"
                    + "// Target the Table you want to insert the Data to\n"
                    + "var results = document.getElementById('camTable');\n"
                    + "results.innerHTML +=\n"
                    + "\"\\\n"
                    + "<thead>\\n\\\n"
                    + "<tr>\\n\\\n"
                    + "<th>Label</th>\\n\\\n"
                    + "<th>Cam Drw Name</th>\\n\\\n"
                    + "<th>Cam Description</th>\\n\\\n"
                    + "<th>Shaft Diameter (mm)</th>\\n\\\n"
                    + "<th>R (mm)</th>\\n\\\n"
                    + "<th>Deg (°)</th>\\n\\\n"
                    + "<th>Eccentric (mm)</th>\\n\\\n"
                    + "</tr>\\n\\\n"
                    + "</thead>\""
                    + ";\n\n");

            String hhr = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                hhr = String.valueOf(NumberOfCams);
                w.write("\n"
                        + "results.innerHTML += \"\\\n"
                        + "<tbody>\\n\\\n"
                        + "<tr>\\n\\\n"
                        + "            <td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">[\" + \"C" + hhr + "\" + \"]</td>\" +\n"
                        + "            \"<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">\" + cam" + hhr + "label + \"</td>\" +\n"
                        + "            \"<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">\" + cam" + hhr + "descl + \"</td>\" +\n"
                        + "            \"<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">\" + cam" + hhr + "diameter + \"</td>\" +\n"
                        + "            \"<td>\" + cam" + hhr + "x.toString() + \"</td>\" +\n"
                        + "            \"<td>\" + cam" + hhr + "y.toString() + \"</td>\" +\n"
                        //"            \"<td>\" + Cam"+hhr+"_X_Values() + \"</td>\" +\n" +
                        //"            \"<td>\" + Cam"+hhr+"_Y_Values() + \"</td>\" +\n" +
                        +"            \"<td>\" + Recc" + hhr + " + \"</td>\" +\n"
                               
                        + "            +\"</tr>\""
                        + "\n"
                        + "\"<\\body>\""
                        + ";"
                );
            }
            w.write("}\n\n");

            w.write("\nwindow.onload=TableCam;\n");

            /*Show Loading Function*/
            String jkjk = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                jkjk = String.valueOf(NumberOfCams);
                w.write("\nmyChart_Cam" + jkjk + ".showLoading({\n"
                        + "      text: 'loading',\n"
                        + "      color: '#c23531',\n"
                        + "      textColor: '#000',\n"
                        + "      maskColor: 'rgba(255, 255, 255, 0.2)',\n"
                        + "      zlevel: 0\n"
                        + "    });;\n"
                        + "setTimeout(() => {\n"
                        + "  myChart_Cam" + jkjk + ".hideLoading();\n"
                        + "  myChart_Cam" + jkjk + ".setOption(option_cam" + jkjk + ");\n"
                        + "}, 1000);\n"
                        + "\n");
            }

            /*Function o export Images*/
            String popo = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                popo = String.valueOf(NumberOfCams);
                w.write(""
                        //+"\"var mycanvas\" + h2 + \" = $(\\\"#maincam\" + h2 + \"\\\").find(\\\"canvas\\\")[\" + h2 + \"];\\n\"  "
                        + "$(\"#exportExcel\").click(function () {\n"
                        + "var mycanvas" + popo + " = $(\"#maincam" + popo + "\").find(\"canvas" + popo + "\")[0];\n"
                        + " \n"
                        + "    var image" + popo + " = mycanvas" + popo + ".toDataURL(\"image/jpeg\");\n"
                        + " \n"
                        + "    var $a = document.createElement('a" + popo + "');\n"
                        + "    $a" + popo + ".setAttribute(\"href\", image);\n"
                        + "    $a" + popo + ".setAttribute(\"download2222\", \"\");\n"
                        + "    $a" + popo + ".click();\n"
                        + " \n"
                        + "    window.location.href=imagea" + popo + "; // it will save locally\n"
                        + "});");
            }

            /**
             * Save Images Function
             */
            String lolo = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                lolo = String.valueOf(NumberOfCams);
                w.write("// Export image\n"
                        + "function downloadImpByChart(chartId) {\n"
                        + //var myChart_Cam1 = echarts.init(document.getElementById('maincam1'), 'walden');                    
                        "  var myChart_Cam" + lolo + " = echarts.getInstanceByDom(document.getElementById(chartId));\n"
                        + "  var url" + lolo + " = myChart_Cam" + lolo + ".getConnectedDataURL({\n"
                        + "         pixelRatio: 5, \n"
                        + "         backgroundColor: '#fff', \n"
                        + "         excludeComponents: [ \n"
                        + "      'toolbox'\n"
                        + "    ],\n"
                        + "         Type: 'png' //Image type supports png and jpeg\n"
                        + "  });\n"
                        + "  var $a" + lolo + " = document.createElement('a" + lolo + "');\n"
                        + "  var type = 'png';\n"
                        + "  $a" + lolo + ".download = myChart_Cam" + lolo + ".getOption().title[0].text + '.' + type;\n"
                        + "  $a" + lolo + ".target = '_blank';\n"
                        + "  $a" + lolo + ".href = url" + lolo + ";\n"
                        + "  // Chrome and Firefox\n"
                        + "  if (typeof MouseEvent === 'function') {\n"
                        + "    var evt = new MouseEvent('click', {\n"
                        + "      view: window,\n"
                        + "      bubbles: true,\n"
                        + "      cancelable: false\n"
                        + "    });\n"
                        + "    $a.dispatchEvent(evt);\n"
                        + "  }\n"
                        + "  // IE\n"
                        + "  else {\n"
                        + "    var html = ''\n"
                        + "    '<body style=\"margin:0;\">'\n"
                        + "    '![](' + url" + lolo + " + ')'\n"
                        + "    '</body>';\n"
                        + "    var tab = window.open();\n"
                        + "    tab.document.write(html);\n"
                        + "  }\n"
                        + "};\n"
                        + "/////////////////////////////////////////\n");
            }

////////////////////////////////////////////////////
            String pipi = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                pipi = String.valueOf(NumberOfCams);
                w.write("\nvar Cam_img" + pipi + " = new Image();\n"
                        + "Cam_img" + pipi + ".src = myChart_Cam" + pipi + ".getDataURL({\n"
                        + "        pixelRatio: 2,\n"
                        + "        backgroundColor: '#fff'\n"
                        + "    });\n");
            }
////////////////////////////////////////////////////  
            String pipi1 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                pipi1 = String.valueOf(NumberOfCams);
                w.write(""
                        //+ "\n$('#maincam" + pipi1 + "').hide();\n"
                        + "\n$('#maincam" + pipi1 + "').show();\n"
                        + "var canvasR" + pipi1 + " = document.getElementById (\"canvas" + pipi1 + "\");\n"
                        + "canvasR" + pipi1 + ".width = 800;\n"
                        + "canvasR" + pipi1 + ".height = 600;\n"
                        + "var ctx" + pipi1 + " = canvasR" + pipi1 + ".getContext ('2d');\n"
                        + "var offcanvas" + pipi1 + "= myChart_Cam" + pipi1 + ".getRenderedCanvas({\n"
                        + "        pixelRatio: 2,\n"
                        + "        backgroundColor: '#fff'\n"
                        + "    });\n"
                        + "ctx" + pipi1 + ".drawImage (offcanvas" + pipi1 + ", 0,0);\n"
                        + "ctx" + pipi1 + ".font = \"12px Arial\";\n"
                        + "ctx" + pipi1 + ".fillText(\"Hello World\", 5, 20);"
                //+ "ctxIm" + pipi1 + ".drawImage (Cam_img" + pipi1 + ", 0,0);\n"
                );
            }
////////////////////////////////////////////////////  

//                    w.write("results.innerHTML += \"\\\n"
//                    + "<tbody>\\n\\\n"
//                    + "<tr>\\n\\\n"+"\" +\n");
//
//            String hhr = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hhr = String.valueOf(NumberOfCams);            
//            w.write("\""+
//                    "<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">[\" + cam" + hhr + " + \"]</td>\" +\n"
//                    + "            \"<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">\" + cam" + hhr + "label + \"</td>\" +\n"
//                    + "            \"<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">\" + cam" + hhr + "descl + \"</td>\" +\n"
//                    + "            \"<td rowspan=\\\"\" + cam" + hhr + "x.length + \"\\\">\" + cam" + hhr + "diameter + \" mm</td>\" +\n"
//                    + "            \"<td>\" + Cam" + hhr + "_X_Values() + \"</td>\" +\n"
//                    + "            \"<td>\" + Cam" + hhr + "_Y_Values() + \"</td>\" +            \n"
//                    + "            \"<td>\" + Recc" + hhr + " + \"</td>\" +\n"
//                    + "            +\"</tr>\"+\n"
//                   
//            );}
//            
//            w.write("\"</tbody>\";\n"
//                    + "}\n\n");
//            w.write("window.onload=TableCam;\n");
//            
//            
//            
//            
////            w.write(
////                    "\nfunction TableCam(){\n"
////                    + "var results=document.getElementById('cam');\n"
////                    + "results.innerHTML += \"\n"
////                    + "<thead>\n\n"
////                    + "<tr>\n\n"
////                    + "<th>Label</th>\n\n"
////                    + "<th>Cam Drw Name</th>\n\n"
////                    + "<th>Cam Description</th>\n\n"
////                    + "<th>Shaft Diameter</th>\n\n"
////                    + "<th>R (mm)</th>\n\n"
////                    + "<th>Deg (°)</th>\n\n"
////                    + "<th>Eccentric (mm)</th>\n\n"
////                    + "</tr>\n\n"
////                    + "</thead>\";"
////                    + "\n"
////                    + "results.innerHTML += \n"
////                    + "<tbody>\n\n"
////                    + "<tr>\n\\"
////            );
////            
////            String hhk = "";
////            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
////                hhk = String.valueOf(NumberOfCams);
////                w.write(
////                        "<td rowspan=\"\"+cam1x.length+\"\">[\"+cam1+\"]</td>\"+\n"
////                        + "\"<td rowspan=\"\"+cam" + hhk + "x.length+\"\">\"+cam" + hhk + "label+\"</td>\"+\n"
////                        + "\"<td rowspan=\"\"+cam" + hhk + "x.length+\"\">\"+cam" + hhk + "descl+\"</td>\"+\n"
////                        + "\"<td rowspan=\"\"+cam" + hhk + "x.length+\"\">\"+cam" + hhk + "diameter+\" mm</td>\"+\n"
////                        + "\"<td>\"+Cam" + hhk + "_X_Values()+\"</td>\"+\n"
////                        + "\"<td>\"+Cam" + hhk + "_Y_Values()+\"</td>\"+\n"
////                        + "\"<td>\"+Recc" + hhk + "+\"</td>\"\n"
////                        + "\"<td>\"+cam" + hhk + "diameter+\"</td>\"\n"
////                );
////            }
////            
////            w.write("+\"</tr>\n\n"
////                    + "</tbody>\"\n\n\n");            
//            
//            
//            
//            
//////////////////////////////////
//            w.write("setTimeout(function () {\n"
//                    + "// Add shadow circles (which is not visible) to enable drag.\n");                    
//            String hh0 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh0 = String.valueOf(NumberOfCams);
//                w.write(                            
//                    "\nmyChart_Cam" + hh0 + ".setOption({\n"
//                    + "        graphic: datacam" + hh0 + ".map(function (item, dataIndex) {\n"
//                    + "            return {\n"
//                    + "                type: 'circle',\n"
//                    + "                position: myChart_Cam" + hh0 + ".convertToPixel('grid', item),\n"
//                    + "                shape: {\n"
//                    + "                    cx: 0,\n"
//                    + "                    cy: 0,\n"
//                    + "                    r: symbolSize / 2\n"
//                    + "                },\n"
//                    + "                invisible: true,\n"
//                    + "                draggable: true,\n"
//                    + "                ondrag: function (dx, dy) {\n"
//                    + "                    onPointDragging(dataIndex, [this.x, this.y]);\n"
//                    + "                },\n"
//                    + "                onmousemove: function () {\n"
//                    + "                    showTooltip(dataIndex);\n"
//                    + "                },\n"
//                    + "                onmouseout: function () {\n"
//                    + "                    hideTooltip(dataIndex);\n"
//                    + "                },\n"
//                    + "                z: 100\n"
//                    + "            };\n"
//                    + "        })\n"
//                    + "    });\n");}
//                            
//                            
//                    w.write("}, 0);\n");
//
//            w.write("\nwindow.addEventListener('resize', updatePosition);\n");
//            String hh1 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh1 = String.valueOf(NumberOfCams);
//                w.write(
//                        "myChart_Cam" + hh1 + ".on('dataZoom', updatePosition);\n\n"
//                );
//            }
//
//            ///////////////////////////////////////
//            w.write("//Function Update Position\n"
//                    + "\nfunction updatePosition() {\n");
//            String hh2 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh2 = String.valueOf(NumberOfCams);
//                w.write(
//                        "    myChart_Cam" + hh2 + ".setOption({\n"
//                        + "        graphic: datacam" + hh2 + ".map(function (item, dataIndex) {\n"
//                        + "            return {\n"
//                        + "                position: myChart_Cam" + hh2 + ".convertToPixel('grid', item)\n"
//                        + "            };\n"
//                        + "        })\n"
//                        + "    });\n"
//                );
//            }
//            w.write("\n}\n");
//            
//            
//            ///////////////////////////////////////
//            w.write("//Function Show Tooltip\n"
//                    + "\nfunction showTooltip(dataIndex) {\n");
//            String hh3 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh3 = String.valueOf(NumberOfCams);
//                w.write(
//                        
//                        "myChart_Cam" + hh3 + ".dispatchAction({\n"
//                        + "        type: 'showTip',\n"
//                        + "        seriesIndex: 0,\n"
//                        + "        dataIndex: dataIndex\n"
//                        + "    });\n\n");
//            }
//            w.write("\n}\n");
//            
//            ///////////////////////////////////////
//            w.write("//Function Hide Tooltip\n"
//                    + "\nfunction hideTooltip(dataIndex) {\n");
//            String hh4 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh4 = String.valueOf(NumberOfCams);
//                w.write(
//                        //"\nfunction hideTooltip(dataIndex) {\n"
//                        "myChart_Cam" + hh4 + ".dispatchAction({\n"
//                        + "        type: 'hideTip'\n"
//                        + "    });\n");
//            }
//            w.write("\n}\n");
//
//            
//            ///////////////////////////////////////
//            w.write("//Function On Point Dragging\n"
//                    + "\nfunction onPointDragging(dataIndex, pos) {\n");
//            String hh5 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh5 = String.valueOf(NumberOfCams);
//                w.write(
//                        //"\nfunction onPointDragging(dataIndex, pos) {\n"+
//                        "datacam" + hh5 + "[dataIndex] = myChart_Cam" + hh5 + ".convertFromPixel('grid', pos);\n");
//            }
//            w.write("\n}\n");
//            
//            
//            
//            w.write("\n"
//                    + "// Update data\n");
//            String hh6 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh6 = String.valueOf(NumberOfCams);
//                w.write("myChart_Cam" + hh6 + ".setOption({\n"
//                        + "        series: [{\n"
//                        + "                id: 'cam" + hh6 + "',\n"
//                        + "                data: data_cam" + hh6 + "\n"
//                        + "            }]\n"
//                        + "    });\n\n"
//                );
//            }
//            
//             String hh8 = "";
//            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
//                hh8 = String.valueOf(NumberOfCams);
//                w.write("/*\n"
//                        +"//Add Points to Cam #" + hh8 + "\n"
//                +"var zr" + hh8 + " = myChart_Cam" + hh8 + ".getZr();\n"
//                +"zr" + hh8 + ".on('click', function (params) {\n"
//                +"var pointInPixel" + hh8 + " = [params.offsetX, params.offsetY];\n"
//                +"var pointInGrid" + hh8 + " = myChart_Cam" + hh8 + ".convertFromPixel('grid', pointInPixel" + hh8 + ");\n"
//                        +"\n"
//                        +"if (myChart_Cam" + hh8 + ".containPixel('grid', pointInPixel" + hh8 + ")) {\n"
//                        +"data.push(pointInGrid" + hh8 + ");\n"
//                        + "myChart_Cam" + hh8 + ".setOption({\n"
//                    + "series: [{\n"
//                    + "id: 'cam" + hh8 + "',\n"
//                    + "data: dataCam" + hh8 + "\n"
//                    + "}]\n"
//                    + "});\n"
//                    + "}\n"
//                    + "});\n"
//                    + "\n" 
//                    +"zr" + hh8 + ".on('mousemove', function (params) {\n" 
//                    + "var pointInPixel" + hh8 + " = [params.offsetX, params.offsetY];\n"
//                    +"zr" + hh8 + ".setCursorStyle(myChart_Cam" + hh8 + ".containPixel('grid', pointInPixel" + hh8 + ") ? 'copy' : 'default');\n"
//                    + "});\n"
//                    + "\n"
//                    + "\n"
//                    + "\n"
//                    + "\n" 
//                            +"*/\n"
//                        + "//Render the chart on page, using the former data and options.\n"
//                );}
//            
////w.close();
            String hh7 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                hh7 = String.valueOf(NumberOfCams);
                w.write(
                        "option_cam" + hh7 + " && myChart_Cam" + hh7 + ".setOption(option_cam" + hh7 + ");\n"
                        + "/*end of Cam #" + hh7 + "*/"
                        + "\n/***********************************************/\n"
                );
            }

            w.close();
        }
    }

    public static String TableTest() {
        String h1 = "";

        String hh7 = "";
        for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
            hh7 = String.valueOf(NumberOfCams);
            h1 = "var data = [\n"
                    + "	{firstname: \"John\", lastname: \"Smith\", address: \"New York\"},\n"
                    + "	{firstname: \"Claire\", lastname: \"Temple\", address: \"Racoon City\"}\n"
                    + "];\n"
                    + " \n"
                    + "function populateTable(){\n"
                    + "	var table = \"\" ;\n"
                    + " \n"
                    + "		for(var i in data){\n"
                    + "			table += \"<tr>\";\n"
                    + "			table += \"<td>\" \n"
                    + "					+ data[i].firstname +\"</td>\" \n"
                    + "					+ \"<td>\" + data[i].lastname +\"</td>\" \n"
                    + "					+ \"<td>\" + data[i].address +\"</td>\" ;\n"
                    + "			table += \"</tr>\";\n"
                    + "		}\n"
                    + " \n"
                    + "	document.getElementById(\"result\").innerHTML = table;\n"
                    + " \n"
                    + "}\n";
        }

        return h1;
    }

}
