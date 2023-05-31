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
import static main.CamReqs.MainInfo.NumberOfCams;
import static main.Echarts.JS_MachineMotionText.CheckMachineMotionCam_Slice_Array;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_Common_js;
import main.info.UserInfo;
import static main.pros.EchartsProperties.ReadProp_EchartsBICColor;
import static main.pros.EchartsProperties.ReadProp_EchartsChartsOpacity1;
import static main.pros.EchartsProperties.ReadProp_EchartsLabels;
import static main.pros.EchartsProperties.ReadProp_EchartsLineWidth;
import static main.pros.EchartsProperties.ReadProp_EchartsSymbolSize;
import static main.pros.EchartsProperties.ReadProp_EchartsTextColor;
import static main.pros.EchartsProperties.ReadProp_EchartsTheme;

/**
 *
 * @author MManolas
 */
public class JS_CommonApp {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        CommonVars();
    }
    
    /**
     *
     * @throws IOException
     */
    public static void CommonVars() throws IOException {

        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+CamsDiag_Common_js);
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(JS_CommonVars());
            w.write(CheckMachineMotionCam_Slice_Array());
            
        }
    }
    
    /**
     *
     * @return
     */
    public static String JS_GetCurrentDate() {
        String h1 = "";
        h1 = "var today = new Date();\n"
                + "var dd = String(today.getDate()).padStart(2, '0');\n"
                + "var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!\n"
                + "var yyyy = today.getFullYear();\n"
                + "\n"
                + "today = dd + '/' + mm + '/' + yyyy;\n"
                + "";
                //+ "document.write(today);\n";
        return h1;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String JS_CommonVars() throws IOException {
    String h1="";
        h1 = "var showLabels = " + ReadProp_EchartsLabels() + ";\n"
                + "//var showLabels=true;\n"
                + "//var showLabels = ShowLabelsFunction();\n"
                + "var symbolSize = " + ReadProp_EchartsSymbolSize() + ";\n"
                + "var CamsDiag_theme = \"" + ReadProp_EchartsTheme() + "\";\n"
                + "//Available Themes : dark, essos, infographic, macarons, MnIT, roma, shine, vintage, walden, westeros\n "
                + "var CamsDiag_JobName = \"" + CamJobName() + "\";\n"
                + "var CamsDiag_NofCams = " + NumberOfCams() + ";\n"
                + JS_GetCurrentDate() + "\n"
                + "var dateCams = today;\n"
                + "var imgexport = \"png\"; \n"
                + JS_GetTime() + "\n"
                + "var chart_opacity = " + ReadProp_EchartsChartsOpacity1() + ";\n"
                + "//var text_color = \"" + ReadProp_EchartsTextColor() + "\";\n"
                + "//var bic_color = " + ReadProp_EchartsBICColor() + ";\n"
                + "var linestulemfasis = " + ReadProp_EchartsLineWidth() + ";\n"
                + "\n"
               // + DnD_JQuery()
                //+ FilesUploadDnDrop()
                //+ DnD_Images()
                + CheckBoxLabels()
                + "\nvar AvailThemes = [\"dark\", \"essos\", \"infographic\", \"macarons\", \"MnIT\", \"roma\", \"shine\", \"vintage\",\"walden\", \"westeros\"];\n"
                + "\n\n\n\n"
                + JS_HTML_Render()
//                + "/*\n"
//                + JS_htmlRenderJSpdf()
//                + "*/\n"
                ;
        
    
    
    return h1;
    }    
    
    /**
     *
     * @return
     */
    public static String JS_GetTime() {
        String h1 = "";
        h1 = "function formatAMPM(date) {\n"
                + "  var hours = date.getHours();\n"
                + "  var minutes = date.getMinutes();\n"
                + "  var ampm = hours >= 12 ? 'pm' : 'am';\n"
                + "  hours = hours % 12;\n"
                + "  hours = hours ? hours : 12; // the hour '0' should be '12'\n"
                + "  minutes = minutes < 10 ? '0'+minutes : minutes;\n"
                + "  var strTime = hours + ':' + minutes + ' ' + ampm;\n"
                + "  return strTime;\n"
                + "}\n"
                + "formatAMPM(new Date)";
        return h1;
    }
    
    /**
     *
     * @return
     */
    public static String CheckBoxLabels() {
        String h1 = "";
        h1 = "\n\nfunction ShowLabelsFunction() {\n"
                + "  var checkBox = document.getElementById(\"myCheck\");\n"
                + "  var text = document.getElementById(\"text\");\n"
                + "  if (checkBox.checked == true){\n"
                + "    //text.style.display = \"block\";\n"
                + "     showLabels=true;\n"
                + "  } else {\n"
                + "     //text.style.display = \"none\";\n"
                + "showLabels=false;\n"
                + "  }\n"
                + "}";
        return h1;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String JS_htmlRenderJSpdf() throws IOException {
    String h1 = "";
    
        h1 = "function exportImage(images) {\n"
                + "  const canvas = mergeCanvas(images);\n"
                + "  canvas.toBlob(blob => {\n"
                + "    saveAs(blob, \"exports-captcha.png\");\n"
                + "  });\n"
                + "}\n";
        
        String h2 = "";
        
        h2 = "function exportHtml(images) {\n"
                + "  const canvas = mergeCanvas(images);\n"
                + "  const imageUrl = canvas.toDataURL(\"image/png\", 1);\n"
                + "  var blob = new Blob(\n"
                + "    [\n"
                + "      `<!DOCTYPE html>\n"
                + "  <html>\n"
                + "    <head>\n"
                + "      <title>" + CamJobName() + "</title>\n"
                + "      <meta charset=\"UTF-8\" />\n"
                + "    </head>\n"
                + "    <body>\n"
                + "      <img src=\"${imageUrl}\" alt=\"" + CamJobName() + "\">\n"
                + "    </body>\n"
                + "  </html>\n"
                + "  `\n"
                + "    ],\n"
                + "    { type: \"text/html;charset=utf-8\" }\n"
                + "  );\n"
                + "  saveAs(blob, \"" + CamJobName() + "0001.html\");\n"
                + "}\n";
    
        
        String h3 = "";

        String pp1 = "var pagepdf = 'a4';\n"
                + "var pdfunits = 'mm';\n"
                + "var pdforient = 'l';\n"
                + "var jspdfImg = 'FAST';\n"
                + "var startXjspdf = 10;\n";

        String pp2 = "\n"
                + "doc.setProperties({\n"
                + " title: AsmName,\n"
                + " subject: AsmDescription,\n"
                + " author: '" + UserInfo.Get_UserName() + "',\n"
                + " keywords: AsmName+' ::: Powered By : Apache Echarts',\n"
                + " creator: '" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + "'\n"
                + "});\n"
                + "doc.save('" + CamJobName() + "_" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + ".pdf');\n"
                + "\n";

        h3 = "function exportPdf(images) {\n"
                + pp1
                + "  const doc = new JSPDF();\n"
                + "  const canvas = mergeCanvas(images);\n"
                + "  const imageUrl = canvas.toDataURL(\"image/png\", 1);\n"
                + "    doc.text('Assembly : '+AsmName, startXjspdf, 10);\n"
                + "    doc.text('Description : '+AsmDescription, startXjspdf, 16);\n"
                + "    doc.setLineWidth(0.4);\n"
                + "    doc.line(startXjspdf, 30, 290, 30);\n"
                + "  doc.addImage(imageUrl, \"png\", 0, 20);\n"
                + pp2
                + "}\n";

        String h4 = "";

        h4 = "\n"
                + "function mergeCanvas(images) {\n"
                + "  var canvas = document.createElement(\"canvas\");\n"
                + "  var [maxH, maxW] = images.reduce(\n"
                + "    (ac, image) => {\n"
                + "      ac[0] = ac[0] + image.getHeight();\n"
                + "      if (image.getWidth() > ac[1]) ac[1] = image.getWidth();\n"
                + "      return ac;\n"
                + "    },\n"
                + "    [0, 0]\n"
                + "  );\n"
                + "  canvas.width = maxW;\n"
                + "  canvas.height = maxH;\n"
                + "\n"
                + "  var context = canvas.getContext(\"2d\");\n"
                + "  var top = 0,\n"
                + "    left = 0;\n"
                + "  images.forEach(image => {\n"
                + "    const [w, h] = [image.getWidth(), image.getHeight()];\n"
                + "    context.drawImage(image.getRenderedCanvas(), left, top, w, h);\n"
                + "    top += h;\n"
                + "  });\n"
                + "  return canvas;\n"
                + "}\n";

        
        String h5 = "";

        h5 = "document.getElementById(\"export-pdf\").onclick = () =>\n"
                + "  exportPdf([";

        String h6 = "]);\n";
        //+ "  exportPdf([myChart, myChart2]);\n";
StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("myChart_Cam"+i+","
            );    
        }
    
        String h7 = builder1.toString();
        String h8 = h7.substring(0, h7.length()-1);
        String h9 = h5+h8+h6;
        
        String h11 = "";

        h11 = "document.getElementById(\"export-html\").onclick = () =>\n"
                + "  exportHtml([";        
        
        String h12 = "";
        
        h12 = "document.getElementById(\"export-image\").onclick = () =>\n"
                + "  exportImage([";
        
        String h13 = h11+h8+h6;
        String h14 = h12+h8+h6;
        
        
        String hall = h1+h2+h3+h4+h9+h13+h14+"\n\n";
        
    return hall;
    
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String JS_HTML_Render() throws IOException {
        String h1 = "";

        String pp1 = "\n"
                + "var pagepdf = 'a4';\n"
                + "var pdfunits = 'mm';\n"
                + "var pdforient = 'l';\n"
                + "var jspdfImg = 'FAST';\n"
                + "var startXjspdf = 10;\n"
                + "\n"
                + "var pdfchartscale = 0.75; \n";

        String pp2 = "\n"
                + "doc.setProperties({\n"
                + " title: AsmName,\n"
                + " subject: AsmDescription,\n"
                + " author: '" + UserInfo.Get_UserName() + "',\n"
                + " keywords: AsmName+' ::: Powered By : Apache Echarts',\n"
                + " creator: '" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + "'\n"
                + "});\n"
                //+ "/doc.save('" + CamJobName() + "_" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + ".pdf');\n"
                //+ "}\n"
                + "";
        
        String hh1 = "\n$(\"#exportButton\").click(function(){ \n";
        String hh2 = "\n});\n";
        
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "html2canvas($(\"#maincam" + i + "\"), {\n"
                    + "    onrendered: function(canvas) {\n"
                    + "    var  dataURL" + i + "=canvas.toDataURL('image/png');\n"
                    + "    console.log('cam" + i + " = '+dataURL" + i + ");\n"
                    + "    var doc = new jsPDF(pdforient, pdfunits, pagepdf);\n"
                    + "    doc.page=1;\n"
                    + "    doc.setFontSize(12);\n"
                    + "    doc.setFontStyle(\"normal\");\n"
                    + "    doc.text('Assembly : '+AsmName, startXjspdf, 10);\n"
                    + "    doc.text('Description : '+AsmDescription+' : '+cam" + i + "descl, startXjspdf, 16);\n"
                    + "    doc.text('Chart #" + i + " : '+cam" + i + "label, startXjspdf, 22);\n"
                    + "    doc.setLineWidth(0.4);\n"
                    + "    doc.line(startXjspdf, 30, 290, 30);\n"
                    + "    doc.addImage(dataURL" + i + ", 'png', 0, 0);\n"
                    + pp2
                    
                    + "    doc.save(\"cam" + i + "abel.pdf\");\n"
                    + "  }\n"
                    + "});\n"
            
            );}        
        

        
        h1 = "";

        return pp1 + hh1 +builder.toString() + hh2;
    }
    
    
}
