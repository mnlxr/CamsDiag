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
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.Cam_Polar_js;

/**
 *
 * @author MManolas
 */
public class JS_Polar {
    
    
        public static void main(String args[]) throws Exception {
        Polar_Rth();
    }
    
    
        public static void Polar_Rth() throws IOException {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+Cam_Polar_js);
        
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
//        w.write(Echarts_OptionsCamAll_p01());
//            for (int i = 1; i <= NumberOfCams(); i++) {
//                w.write(Echarts_OptionsCamAll_p02(i));                
//            }
            w.write(PolarCoordinates()

            );
         w.close();
        }
    }
        
            public static String PolarCoordinates() {
        String h1 = "";
        String r = "";
        String th="";
        //Math.sqrt(x)
        String polarFunctionTEmp = "//Function Polar 2 Cart\n"
                        + "function cartesian2Polar(x, y){\n"
                        + "    distance = Math.sqrt(x*x + y*y)\n"
                        + "    radians = Math.atan2(y,x) //This takes y first\n"
                        + "    degrees = radians * (180/Math.PI)\n"
                        + "    //polarCoor = { distance:distance, radians:radians }\n"
                        + "    polarCoor = { distance:distance, degrees:degrees }\n"
                        + "    return polarCoor\n"
                        + "}\n"
                       
                + "\n";
        
                StringBuilder builder0 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder0.append("\n"
//                            //+ "var PolarDataCam" + i + " = data_cam" + i + ";\n"
//                            //+ "var PolarDataCamAll = data_cam" + i + ";\n"
//                            + "//PolarDataCam" + i + ".forEach(function(entry) {\n"
//                            + " // console.log(entry);\n"
//                            + "//});\n"
//                            + "\n"
//                            + ""
//                            + "//for(var i=0;i<cam" + i + "x.length;i++){\n"
//                            + "//   var  CPcam" + i + "x[i]=3+cam" + i + "x[i];\n"                                    
//                            + "//}"
//                            + "\nconsole.table(data_cam" + i + ");\n"
                            
                            + ""
//                            + "function cartesian2PolarCam" + i + "(x, y){\n"
//                            + "    distance = Math.sqrt(x*x + y*y)\n"
//                            + "    radians = Math.atan2(y,x) //This takes y first\n"
//                            + "    degrees = radians * (180/Math.PI)\n"
//                            + "    //polarCoor = { distance:distance, radians:radians }\n"
//                            + "    polarCoor = { distance:distance, degrees:degrees }\n"
//                            + "    return polarCoor}\n"
//                            + ""
                            //+ "var PolarCamData" + i + " = data_cam" + i + ";\n"
//                            + "for (let i = 0; i < PolarCamData" + i + ".length; i++) {\n"
//                            + "    // get the size of the inner array\n"
//                            + "    var innerArrayLength" + i + " = PolarCamData" + i + "[i].length;\n"
//                            + "    // loop the inner array\n"
//                            + "    for (let j = 0; j < innerArrayLength" + i + "; j++) {\n"
//                            + "       //console.log('[' + i + ',' + j + '] = ' + PolarCamData" + i + "[i][j]);\n"
//                            //+ "        console.log('[' + i + ',' + j + '] = ' + innerArrayLength" + i + "[i][j]);\n"                                    
//                            + "\n"
//                            + "var DistanceCam" + i + " = Math.sqrt((PolarCamData" + i + "[i]*PolarCamData" + i + "[i]) + (PolarCamData" + i + "[j]*PolarCamData" + i + "[j]));\n"
//                            + "var RadianCam" + i + " = Math.atan2(PolarCamData" + i + "[j],PolarCamData" + i + "[i]);\n"
//                            + "var DegreesCam" + i + " = RadianCam" + i + " * (180/Math.PI);\n"
//                            //+ "PolarCamData" + i + " = [];\n"
//                            //+ "PolarCamData" + i + " =  PolarCamData" + i + ".push(DistanceCam" + i + ",DegreesCam" + i + ");\n"
//                            + "    }\n"
//                            + "}\n"
//                            //+ "console.table(innerArrayLength" + i + ");\n"
//                            + "console.table(PolarCamData" + i + ");\n"
                            //+ "console.log(DistanceCam" + i + ");\n"
                            //+ "console.log(RadianCam" + i + ");\n"
                            + "var PolarCamData" + i + " =[];\n"
                            //+ "var DistanceCAM" + i + " = 0;\n"
                            //+ "var RadiansCAM" + i + " = 0;\n"
                            //+ "var DegressCAM" + i + " = 0;\n"
                            + "for (i = 0; i < cam" + i + "x.length; i++)\n"
                            + "{ \n"
//                            + "PolarCamData" + i + ".push([cam" + i + "x[i], cam" + i + "y[i]]);\n"
                            //+ "DistanceCAM" + i + "[i] = Math.sqrt((cam" + i + "x[i]*cam" + i + "x[i])+(cam" + i + "y[i]*cam" + i + "y[i]));\n"
                            //+ "RadiansCAM" + i + "[i] = Math.atan2(cam" + i + "y[i],cam" + i + "x[i]);\n"
                            //+ "DegressCAM" + i + "[i] = RadiansCAM" + i + "*(180/Math.PI);\n"
                            //+ "PolarCamData" + i + " = [];\n"
//                            + "PolarCamData" + i + ".push([DistanceCAM" + i + "[i], DegressCAM" + i + "[i]]);\n"
//                            + "PolarCamData" + i + ".push([Math.sqrt((cam" + i + "x[i]*cam" + i + "x[i])+(cam" + i + "y[i]*cam" + i + "y[i]))], "
//                            + "(Math.atan2(cam" + i + "y[i],cam" + i + "x[i]))*(180/Math.PI));\n"
                            + "PolarCamData" + i + ".push([Math.sqrt((cam" + i + "x[i]*cam" + i + "x[i])+(cam" + i + "y[i]*cam" + i + "y[i])), cam" + i + "x[i]]);\n"                                    
                                    + ""
                            + ""
                            + "}\n"
                                    
                            
//                            + "PolarCamData" + i + ".forEach(activity => {\n"
//                            + "//let percentage = ((activity[1] / 24) * 100).toFixed();\n"
//                            + "let Pdistance" + i + " = Math.sqrt(activity[1]*activity[1])+(activity[2]*activity[2]);\n"
//                            + "let Pradians" + i + " = Math.atan2(activity[2],activity[1]);\n"
//                            + "let Pdegrees" + i + " = Pradians" + i + " * (180/Math.PI);\n"
//                            + "//var CampolarCoor" + i + " = { Pdistance" + i + ":Pdistance" + i + ", Pdegrees" + i + ":Pdegrees" + i + " }"
//                            + "//activity[2] = percentage + '%';\n"
//                            + "//activity[2] = CampolarCoor" + i + ";\n"
//                            + "PolarCamData" + i + " = [];\n"
//                            + "PolarCamData" + i + " = PolarCamData" + i + ".push(Pdistance" + i + ",Pdegrees" + i + ")\n"
//                            + "});"
                            + "//console.table(PolarCamData" + i + ");\n"
                    );
                }
                
StringBuilder builder1 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder1.append(
                    "data_cam" + i + "+"
                    );}                
 
        String j1="var PolarDataCamAll = "+builder1.toString()+";";
        
        h1 = 
                "//Converting Cartesian to Polar \n"
                + polarFunctionTEmp
                + builder0.toString()  
                +j1.substring(0, j1.length()-2)+";\n"
                + "//END\n";
        

        
        return h1;
    }
    
}
