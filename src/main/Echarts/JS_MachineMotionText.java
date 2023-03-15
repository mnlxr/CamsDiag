/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Echarts;

import static main.CamReqs.MainInfo.NumberOfCams;
import main.MnIT_Main;
import static main.MnIT_Main.machineMotionCB;

/**
 *
 * @author MManolas
 */
public class JS_MachineMotionText {
    
    
    public static String MachineMotionOptionCam01(Integer t) {
        String h1 = "";
        h1 = "markArea: {\n"
                + "z:0,\n"
                + "label: {\n"
                + "show: true,\n"
                + "position: 'inside',\n"
                + "color: \"black\",\n"
                + "fontSize: 15\n"
                + "},		   \n"
                + "data: [ \n"
                + "[{\n"
                + "name: MachineMotion,\n"
                + "xAxis: MotionArray[0][0],\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'red',\n"
                + "opacity: chart_opacity\n"
                + "},\n"
                + "xAxis: MotionArray[0][1],\n"
                + "//yAxis: maxMotion,\n"
                + "yAxis: checkShaftDiam(),\n"
                + "},\n"
                + "], \n"
                + "[{\n"
                + "name: MachineDwell,\n"
                + "xAxis: DwellArray[0][0],\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'green',\n"
                + "opacity: chart_opacity,\n"
                + "},					\n"
                + "xAxis: DwellArray[0][1],\n"
                + "//yAxis: maxMotion,\n"
                + "yAxis: checkShaftDiam(),\n"
                + "}], 				\n"
                + ""
                //+ "/*\n"
                + "[{\n"
                + "name: MachineMotion,\n"
                + "xAxis: MotionArray[1][0]\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'red',\n"
                + "opacity: chart_opacity\n"
                + "},					\n"
                + "xAxis: MotionArray[1][1],\n"
                + "//yAxis: maxMotion,\n"
                + "yAxis: checkShaftDiam(),\n"
                + "}] \n"
                //+ "*/\n"
                + "\n"
                + "]\n"
                + "},\n"
                ;
    
    return h1;}
    
public static String MachineMotionOptionCam02(Integer t) {
        String h1 = "";
        h1 = "markArea: {\n"
                + "z:0,\n"
                + "label: {\n"
                + "show: true,\n"
                + "position: 'inside',\n"
                + "color: \"black\",\n"
                + "fontSize: 15\n"
                + "},		   \n"
                + "data: [ \n"
                + ""
                + "[{\n"
                + "name: MachineDwell,\n"
                + "xAxis: DwellArray[0][0],\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'green',\n"
                + "opacity: chart_opacity,\n"
                + "},\n"
                + "xAxis: DwellArray[0][1],\n"
                + "//yAxis: maxMotion,\n"
                + "yAxis: checkShaftDiam(),\n"
                + "}],\n"
                + ""
                + "[{\n"
                + "name: MachineMotion,\n"
                + "xAxis: MotionArray[0][0],\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'red',\n"
                + "opacity: chart_opacity\n"
                + "},\n"
                + "xAxis: MotionArray[0][1],\n"
                + "//yAxis: maxMotion,\n"
                + "yAxis: checkShaftDiam(),\n"
                + "},\n"
                + "], \n"
                + ""
                + ""
                + "[{\n"
                + "name: MachineDwell,\n"
                + "xAxis: DwellArray[1][0],\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'green',\n"
                + "opacity: chart_opacity,\n"
                + "},\n"
                + "xAxis: DwellArray[1][1],\n"
                + "//yAxis: maxMotion,\n"
                + "yAxis: checkShaftDiam(),\n"
                + "}],\n"
                + ""
                + ""
                + ""
                + ""
                + "\n"
                + "]\n"
                + "},\n"
                ;
    
    return h1;}    
    
    
    public static String MachineCamAll(){
    String h1="";
        h1 = h1 = "markArea: {\n"
                + "z:0,\n"
                + "label: {\n"
                + "show: true,\n"
                + "position: 'inside',\n"
                + "color: \"black\",\n"
                + "fontSize: 15\n"
                + "},		   \n"
                + "data: [ \n"
                + "[{\n"
                + "name: MachineMotion,\n"
                + "xAxis: MotionArray[0][0],\n"
                + "yAxis: MaxMotionMachine\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'red',\n"
                + "opacity: chart_opacity\n"
                + "},\n"
                + "xAxis: MotionArray[0][1],\n"
                + "//yAxis: maxMotion,\n"
                + "},\n"
                + "], \n"
                + "[{\n"
                + "name: MachineDwell,\n"
                + "xAxis: DwellArray[0][0],\n"
                + "yAxis: MaxMotionMachine\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'green',\n"
                + "opacity: chart_opacity,\n"
                + "},					\n"
                + "xAxis: DwellArray[0][1],\n"
                + "//yAxis: maxMotion,\n"
                + "}], 				\n"
                + "[{\n"
                + "name: MachineMotion,\n"
                + "xAxis: 250,\n"
                + "yAxis: MaxMotionMachine\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'red',\n"
                + "opacity: chart_opacity\n"
                + "},					\n"
                + "xAxis: 360,\n"
                + "//yAxis: maxMotion,\n"
                + "}] \n"
                + "\n"
                + "]\n"
                + "},\n";
    return h1;
    }
    
    
    public static String MachineMotionArray() {
        String h1 = "";
        h1 = "//var lenMotion = MachineMotionArray.length;\n"
                + "//var lenDwell = MachineDwellArray.length;\n"
                + "//console.log(MachineMotionArray.length);\n"
                //+ "currentIndexNext= (currentIndexNext+1)%lenMotion;\n"
                //+ "currentIndexPrev= (currentIndexPrev+lenMotion-1)%lenMotion;\n"
                ;
        return h1;
    }
    
    public static String MachineMotionArrayUser() {
        String h1 = "";
        h1 = "var MachineMotionArray = [0,90,180,360];\n"
                +"var MachineDwellArray = [90,180];\n";
        return h1;
    }
    
    public static String MachineMotionArrayUser02() {
        String h1 = "";
        h1 = "var MachineMotionArray = [90,180];\n"
                +"var MachineDwellArray = [0,90,180,360];\n";
        return h1;
    }    
    
    public static String CheckMachineMotionCam_Slice_Array() {
        String h1 = JS_Motion_SliceFunctionArray();
        String h2 = JS_Dwell_SliceFunctionArray();
        String h3 = JS_Populate();
        String h4 = JS_IterateMotionDwell();
        String h5= JS_MotionDwellLength();
        String h6 = JS_MarkArea_Motion();
        String h7 = JS_MarkArea_p001_Motion();
        String h8 = JS_MarkArea_p001_Dwell();
        //String shft001 = JS_MotionShaDiamEqualtoZero()
        String j1 = "";
        if (machineMotionCB.isSelected()) {
            j1 = h1
                    +h2
                    +h3
                    +h4
                    +h5
                    +h6
                    //+h7
                    //+h8
                    ;
        } else {
            j1 = "";
        }
        return j1;
    }    
    
    
    public static String Check_CBox_MarkArea_Option(Integer t) {
    String h1="";
        if (MnIT_Main.CB_motion.getSelectedIndex() == 0) {
            h1 = MachineMotionOptionCam01(t);
        } else if(MnIT_Main.CB_motion.getSelectedIndex() == 1){
            h1 = MachineMotionOptionCam02(t);
        }
    return h1;
    }
    
    public static String Check_CBox_Vars_Option() {
    String h1="";
        if (MnIT_Main.CB_motion.getSelectedIndex() == 0) {
            h1 = MachineMotionArrayUser();
        } else if(MnIT_Main.CB_motion.getSelectedIndex() == 1){
            h1 = MachineMotionArrayUser02();
        }
    return h1;
    }    
    
    
    
    
    public static String JS_Motion_SliceFunctionArray() {
        String h1 = "";
        h1 = "function sliceIntoChunks(arr, chunkSize) {\n"
                + "    const res = [];\n"
                + "    for (let i = 0; i < arr.length; i += chunkSize) {\n"
                + "        const chunk = arr.slice(i, i + chunkSize);\n"
                + "        res.push(chunk);\n"
                + "    }\n"
                + "    return res;\n"
                + "}\n"
                + "\n"
                + "var arrMotion01 = MachineMotionArray;\n"
                + "console.log(sliceIntoChunks(arrMotion01, 2));\n"
                + "var MotionArray=sliceIntoChunks(arrMotion01, 2);\n";
        
        return h1;    
    }
    
    public static String JS_Dwell_SliceFunctionArray() {
        String h1 = "";
        h1 = ""
                /*
                + "function sliceIntoChunks(arr, chunkSize) {\n"
                + "    const res = [];\n"
                + "    for (let i = 0; i < arr.length; i += chunkSize) {\n"
                + "        const chunk = arr.slice(i, i + chunkSize);\n"
                + "        res.push(chunk);\n"
                + "    }\n"
                + "    return res;\n"
                + "}\n"
                    */
                + "\n"
                + "var arrDwell = MachineDwellArray;\n"
                + "console.log(sliceIntoChunks(arrDwell, 2));\n"
                + "var DwellArray=sliceIntoChunks(arrDwell, 2);\n";
        
        return h1;    
    }    
   
    public static String JS_MotionDwellLength() {
    String h1="";
    h1 = ""
            + "var dwellarraylength = DwellArray.length;\n"
             + "var motionarraylength = MotionArray.length;\n"
            + "console.log(dwellarraylength);\n"
            + "console.log(motionarraylength);\n"
            + "\n\n"
            + "function getDwellItems() {\n"
            + "if(dwellarraylength == 1)\n"
            + "{var dweel01 = DwellArray[0][0];\n"
            + " var dwell02 = DwellArray[0][1];\n}"
            + "\n}\n";
    return h1;
    }
    
    
    public static String JS_Populate() {
        String h1 = "";
        h1 = "\n\n"
                + "function populateMotion(){\n"
                + "    for(i=0;i<MotionArray.length;i++)\n"
                + "    {\n"
                + "        for(j=0;j<MotionArray[i].length;j++)\n"
                + "        {\n"
                + "             console.log(MotionArray[i][j]);\n"
                + "        }\n"
                + "    }\n"
                + "}\n\n"
                + ""
                + "function populateDwell(){\n"
                + "    for(i=0;i<DwellArray.length;i++)\n"
                + "    {\n"
                + "        for(j=0;j<DwellArray[i].length;j++)\n"
                + "        {\n"
                + "             console.log(DwellArray[i][j]);\n"
                + "        }\n"
                + "    }\n"
                + "}\n\n";
        return h1;
    }
    
    public static String JS_MarkArea_Motion() {
        String h1 = "";
        h1 = "\n\n\n"
                + "if(dwellarraylength == 1)\n"
                + "{\n"
                + "var dwellStart = DwellArray[0][0];\n"
                + "var dwellEnd = DwellArray[0][1];\n"
                + "}\n\n\n"
                + ""
                + "if(motionarraylength == 1)\n"
                + "{\n"
                + "var motionStart = MotionArray[0][0];\n"
                + "var motionEnd = MotionArray[0][1];\n"
                + "}\n\n\n"
                ;
        return h1;
    }
    
    public static String JS_MarkArea_p001_Motion() {
        String h1 = "";
        h1 = "var motionText01 = \n\"\n"
                + "[{\n"
                + "name: MachineMotion,\n"
                + "xAxis: motionStart,\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'red',\n"
                + "opacity: chart_opacity\n"
                + "},\n"
                + "xAxis: motionEnd,\n"
                + "yAxis: AxisMin3-2,\n"
                + "},\n"
                + "],\n"
                + ""
                + "\"";
        return h1;
    }
    
    public static String JS_MarkArea_p001_Dwell() {
        String h1 = "";
        h1 = ""
                + "var dwellText01 = \n\"\n"
                + "[{\n"
                + "name: MachineDwell,\n"
                + "xAxis: dwellStart,\n"
                + "}, {\n"
                + "itemStyle: {\n"
                + "color: 'green',\n"
                + "opacity: chart_opacity,\n"
                + "},\n"
                + "xAxis: dwellEnd,\n"                
                + "yAxis: AxisMin3-2,\n"
                + "}],\n"
                + "\"";
        return h1;
    }
    
    public static String JS_IterateMotionDwell() {
        String h1 = "";
        h1 = //"let studentsData = [['Jack', 24], ['Sara', 23],];\n"
                ""
                + "\n"
                + "for (let i of DwellArray) {\n"
                + "  for (let j of i) {\n"
                + "    console.log(j);\n"
                + "  }\n"
                + "}\n\n"
                + "for (let i of MotionArray) {\n"
                + "  for (let j of i) {\n"
                + "    //console.log(j);\n"
                + "  }\n"
                + "}\n\n"                ;
        return h1;
    }
    
    
    public static String JS_MotionShaDiamEqualtoZero(Integer t){
    
        String h1 = "";
        String camdiameter = "";
        
       //camdiameter = "cam"+t+"diameter";
       
        h1 = "\n\n"
                + "function checkShaftDiam() {\n"
                //+ "  var cam"+t+"diameter=3\n"
                + "  if (cam"+t+"diameter === 0) {\n"
                + "    return AxisMin" + t + "+2;\n"
                + "  } else{\n"
                + "  \n"
                + "    return AxisMin" + t + "-2;\n"
                + "  }  \n"
                + "}\n";
        
//        StringBuilder builder0001 = new StringBuilder();
//        for (int i = 1; i <= NumberOfCams(); i++) {
//            builder0001.append("\n\n"
//                    + "function checkShaftDiam"+i+"() {\n"
//                //+ "  return p1 * p2;\n"
//                + "var checkshft"+i+" = cam"+i+"diameter; \n"
//                + "if(checkshft"+i+" === 0){\n"
//                + "var axisvis"+i+" = \"AxisMin+2\"; \n"
//                + "return axisvis"+i+";\n"
//                + "} else {\n"
//                + "var axisvis"+i+" = \"AxisMin-2\"; \n"
//                + "return axisvis"+i+";\n"
//                + "}"
//                + "");
//        }
//        
//        String h2 = builder0001.toString();        
        
//        if (camdiameter) {
//            
//        } else {
//        }
        
        
        return h1;
        
    }
    
    
}
