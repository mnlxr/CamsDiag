/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import static main.common.MainVars.CamsDiag_ImgsCnvs_js;

/**
 *
 * @author MManolas
 */
public class Js_ImagesCanvas {
  
    
    
        public static void main(String args[]) throws Exception {
        CamsDiag_ImagesCanvas();
    }    
    
    
    public static String GetDataURL() throws IOException {
        String h1 = "";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append(""+
                    
//                    "var img" + i + " = new Image();\n"
//                    + "img" + i + ".src = myChart_Cam" + i + ".getDataURL({\n"
//                    + "    type: 'png',\n"
//                    + "    pixelRatio: 5,\n"
//                    + "    backgroundColor: '#fff'\n"
//                    + "});\n\n"
//                    + ""
//                    + ""
                    
                    "\n"
                    + "var imgCam" + i + " = new Image();\n"
                    + "\n"
                    + "// get the chart instance data as url\n"
                    + "imgCam" + i + ".src = myChart_Cam" + i + ".getDataURL({\n"
                    + "  type: 'png', // can be jpeg or png\n"
                    + "  pixelRatio: 5, // image's ratio. default is 1\n"
                    + "  backgroundColor: '#fff', // hex color defining the background of the chart\n"
                    + "});\n\n"
                    //+ "console.log(imgCam" + i + ")\n"
                            //+ "console.log()"
                    
//                    + "const CamsDiagcanvas" + i + " = document.getElementById('#maincam" + i + "');\n"
//                    + "const dataURL" + i + " = CamsDiagcanvas" + i + ".toDataURL();\n"
//                            //+ "(\"image/png\").replace(\"image/png\", \"image/octet-stream\");\n"
//                    + "console.log(dataURL" + i + ");\n"
//                    + "const fullQuality" + i + " = CamsDiagcanvas" + i + ".toDataURL('image/png', 1.0);\n"
                    
//                    + "const CamsDiagcanvas" + i + " = document.getElementById('myChart_Cam" + i + "');\n"
//                    + "\n"
//                    + "    // Convert CamsDiagcanvas" + i + " to dataURL and log to console\n"
//                    + "    const dataURL" + i + " = CamsDiagcanvas" + i + ".toDataURL();\n"
//                    + "    console.log(dataURL" + i + ");\n"
//                    //+ "    // Logs data:image/png;base64,wL2dvYWwgbW9yZ...\n"
//                    + "\n"
//                    + "    // Convert to Base64 string\n"
//                    + "    const base64_cam" + i + " = getBase64StringFromDataURL(dataURL" + i + ");\n"
//                    + "    console.log(base64_cam" + i + ");\n\n"  
                            
                    /*
                    + "function loadImage" + i + "(src) {\n"
                    + "  return new Promise((resolve, reject) => {\n"
                    + "    const img" + i + " = new Image();\n"
                    + "    img" + i + ".onload = () => resolve(img);\n"
                    + "    img" + i + ".onerror = reject;\n"
                    + "    img" + i + ".src = src;\n"
                    + "  });\n"
                    + "}\n"
                    + "\n\n"
                    + "function getChartImage" + i + "(myChart_Cam" + i + ") {\n"
                    + "  return loadImage(myChart_Cam" + i + ".getDataURL());\n"
                    + "}\n\n"
                     */
                   // + "console.log('Canvas" + i + " : ', img" + i + ".src);\n\n\n"
                    //+ "console.log(\"Canvas\")\n"
                    
                    //+ "var imgTab" + i + " = window.open('');\n"
                    //+ "const imgTab" + i + ".document.write(`<img src='${img" + i + ".src}'/>`);\n"
                    
//+"console.log(base64Image);//Check console to see base64 encoded Image of Chart\n" +
//"window.open(base64Image);\n"
//+ "\"btnExport.addEventListener()"
            //+ "const btnExport = document.getElementById(\"export\");\n"
            //+ "btnExport.addEventListener(\"click\", async () => {\n"
            //+ "console.log(\"exporting...\");\n\n"
            );
                    };
            String hh1 = "  try {\n";
            StringBuilder builder11 = new StringBuilder();
            for (int k = 1; k <= NumberOfCams(); k++) {
                builder11.append(
                        "    const img" + k + " = await getChartImage(myChart_Cam" + k + ");\n"
                        + "    const dpr" + k + " = myChart_Cam" + k + ".getDevicePixelRatio();\n"
                        + "    doc.addImage(img" + k + ".src, \"PNG\", 0, 0, img" + k + ".width / dpr" + k + ", img" + k + ".height / dpr" + k + ");\n"
                );
            }
                    
            
        StringBuilder builder2 = new StringBuilder();
        builder2.append("const btnExport = document.getElementById(\"export\");\n"
                + "btnExport.addEventListener(\"click\", async () => {\n"
                + "console.log(\"exporting...\");\n\n"
        );

        StringBuilder builder3 = new StringBuilder();
        builder3.append(" const doc = new jspdf.jsPDF({\n"
                + "      unit: \"px\"\n"
                + "    });\n\n"
        );

        StringBuilder builder4 = new StringBuilder();
        builder4.append("    await doc.save(\"" + CamJobName() + ".pdf\", {\n"
                + "      returnPromise: true\n"
                + "    });\n"
                + "    console.log(\"exported\");\n"
                + "  } catch (e) {\n"
                + "    console.error(\"failed to export\", e);\n"
                + "  }\n"
        );             
            
                    //+ "    const doc = new jspdf.jsPDF({\n"
                    //+ "      unit: \"px\"\n"
                   // + "    });\n"

                    //+ "    doc.addImage(img" + i + ".src, \"PNG\", 0, 0, img" + i + ".width / dpr" + i + ", img" + i + ".height / dpr" + i + ");\n"
                    //+ "    doc.addPage();\n"
                    //+ "    doc.addImage(img2.src, \"PNG\", 0, 0, img1.width / dpr2, img1.height / dpr2);\n"

                   String hh2 = "\n});\n\n";
            //);
        //}

        
        String hall= builder1.toString() 
                //+ hh1 + builder11.toString() + builder2.toString() + builder3.toString() + builder4.toString() + hh2
                ;
        
      /*
        dataUrl = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
doc.addImage(dataUrl, 'png', 0, 0, 210, 297, undefined, 'FAST'); 
        */
        String kk1 = "";

        kk1 = "const { jsPDF } = require(\"jspdf\");\n"
                + "const doc = new jsPDF();\n"
                + "doc.setFontSize(30);\n"
                + "doc.text('" + CamJobName() + "', 8, 20);\n"
                //+ "doc.text('On-demand Catalog', 8, 30);"
                + "doc.addImage();\n";
        
        return hall;
    }
    
    

    public static void CamsDiag_ImagesCanvas() throws FileNotFoundException, IOException {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+ CamsDiag_ImgsCnvs_js);

        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write(GetDataURL()
            );
            w.close();
        }
    } 



}
