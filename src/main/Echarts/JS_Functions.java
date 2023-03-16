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
import static main.common.MainVars.LocalhostName;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class JS_Functions {
    
        public static void main(String args[]) throws Exception {
        CamsDiag_JS_FunctionsEveryChart();
    }/**/
    
        public static void CamsDiag_JS_FunctionsEveryChart() throws FileNotFoundException, IOException, Exception {
            File statText = new File(PathWebServer + "//" + mainFolder + "//"
                    + CamJobName() + "//" + CamJobName() + "_func.js");
            File statTextprod = new File(PathWebServer + "//" + mainFolder + "//"
                    + CamJobName() + "//" + CamJobName() + "_funcprod.js");
            FileOutputStream is = new FileOutputStream(statText);
            FileOutputStream isprod = new FileOutputStream(statTextprod);
            OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
            OutputStreamWriter oswprod = new OutputStreamWriter(isprod, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(""
                    //JS_Loading()                    
                    + "\n/*\n"
                    + JS_PointDrag()
                    + JS_DraggablePoints()
                    + "\n*/\n"
                    //+ JS_DraggablePoints_All_Together()
                    + JS_MyChartSetOptionsMain()
                    + JS_ChartsArray()
                    + JS_WindowsOnLoad()
                    + ArrowMouseEvents()
                    //+JS_DownloadImpByChart()
                    //+ JS_DownImgs()
                    + "\n///////////////////////////////////////\n\n"

                    //+ GetImageBase64string()
                    //+ GetCanvas_ExportPictures()    
                            
//                    + CanvasCTX()
//                    + ImageGetDataURL()
//                    + ImageToDataURL()
//                    + CanvasCharts()
                    
                    //+ JS_convertCanvasToImage()
                    //+ JS_createPDFObject()
                    //+ JS_DraggablePointCombo()
                    //+ JS_DraggablePoints()

                    //+ JS_Get_eChartCanvas()
                    //+ JS_Get_eChartImage()
                    //+ JS_Func_Canvas() 
                    //+ JS_canvas2image()
                    //+JS_CanvasFuncPrint()
                            
                    //+ JS_imgLoad()
                    //+ JS_PrintCanvasFunction()
                    
                    //+ JS_CanvasVars()
//+GetCanvas_ExportPictures()
//+GetImageBase64string()
                    //+ JS_RenderPDF()
                    //+JS_DownImgs()        
                    //+ ImageFinalToPrint()
                    + HTML2Canvas_Table_Print()  
                    + JS_GetCanvasURL()
                    + JS_jsPdfExport()
                    //+ JS_jsPdfExport()

                    //+ JS_MotionShaDiamEqualtoZero()
                    //+ JS_ConvertRender()
                           
                    //+ CamImagesPDFmake()
                    
                   // + JS_ExportButtonFunction()
            );
            w.close();
        }
        try (Writer w1 = new BufferedWriter(oswprod)) {
            w1.write("\n"
            + JS_GetCanvasURL()
            + JS_jsPdfExport_PRODVIEW()
            ); 
        w1.close();
        }         
        
        
        }
    
    
    
//    public static String CamJob_js_Uniq_ID() {
//        String h1 = "";
//        String h2 = UserInfo.Get_UserName();
//        String h3 = UserInfo.Get_ComputerName();
//        Integer h4 = NumberOfCams();
//
//        h1 = "function uniqueID() {\n"
//                + "var uniq1 = \""+h2+h3+"\"; \n"
//                + "var uniq2 = Math.floor(Math.random() * Date.now()); \n"
//                + "var uniq3 = uniq2.concat(uniq1); \n"
//                + "var uniq4 = uniq3.toString();"
//                + "return uniq4; \n"
//                + "}\n";
//
//        return h1;
//    }      
        
    

    public static String JS_MyChartSetOptionsMain() {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("option_cam" + i + " && myChart_Cam" + i + ".setOption(option_cam" + i + ", true);");
            builder.append("\n");
        }
        h1 = builder.toString();

        return h1;
    }

    
    
    public static String JS_convertCanvasToImage() {
        String h1 = "";
        String h2 = "function convertCanvasToImage() {\n";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\nhtml2canvas(document.getElementById('maincam"+i+"'), {\n" +
"	        onrendered: function(canvas) {\n" +
"	           ////document.body.appendChild(canvas);\n" +
"	            createPDFObject(canvas.toDataURL(\"image/png\"));\n" +
"	        }\n" +
"	});\n");
        }
        String h3 = "}\n";
        
       
        h1 = builder.toString();
                String h4=h2+h1+h3;
        return h4;
    }
    
    public static String JS_canvas2image() {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\nfunction convertCanvasToImage(canvas" + i + ") {\n"
                    + "var image" + i + " = new Image();\n"
                    + "image" + i + ".src = canvas" + i + ".toDataURL(\"image/png\");\n"
                    + "return image" + i + ";\n"
                    + "}\n"
                    //+ "//console.log('Image #" + i + " : '+img" + i + ");\n"
                    //+ "//console.log(convertCanvasToImage(canvas" + i + "));\n"
            );
        }
        h1 = builder.toString();
        return h1;
    }
    
    public static String JS_createPDFObject() {
        String h1 = "";
        String h2 = "function createPDFObject(imgData) {\n"
                +"//Default a4 paper\n"
                +"var doc = new jsPDF('p', 'pt',\"a3\");\n"
                +"doc.addImage(imgData, 5, 5, 600, 300, 'img');\n"
                +"doc.save('GCXDATA_PDF.pdf');}\n\n"
                ;
        
        return h2;
    }    
    
    public static String JS_DraggablePoints_All_Together() {
        String h1 = "";
        
        
        String settimeout01 = "setTimeout(function () {\n";
        StringBuilder builder08 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder08.append("    myChart_Cam"+i+".setOption({\n"
                    + "        graphic: data_cam"+i+".map(function (item, dataIndex) {\n"
                    + "            return {\n"
                    + "                type: 'circle',\n"
                    + "                position: myChart_Cam"+i+".convertToPixel('grid', item),\n"
                    + "                shape: {\n"
                    + "                    cx: 0,\n"
                    + "                    cy: 0,\n"
                    + "                    r: symbolSize\n"
                    + "                },\n"
                    + "                invisible: true,\n"
                    + "                draggable: true,\n"
                    + "                ondrag: function (dx, dy) {\n"
                    + "                    onPointDragging(dataIndex, [this.x, this.y]);\n"
                    + "                },\n"
                    + "                onmousemove: function () {\n"
                    + "                    showTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                onmouseout: function () {\n"
                    + "                    hideTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                z: 100\n"
                    + "            };\n"
                    + "        })\n"
                    + "    });\n");
        }
        String settimeout02="}, 0);\n";
        String SetTimeOut= settimeout01+builder08.toString()+settimeout02;
        /**************************************************/  
        String hh1="window.addEventListener('resize', updatePosition);\n";
        /**************************************************/         
        StringBuilder builder05 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
            builder05.append("myChart_Cam"+i+".on('dataZoom', updatePosition);\n");
        }
            String dataZoom=builder05.toString();
        /**************************************************/ 
        String updateposition01 = "\nfunction updatePosition() {\n";
        StringBuilder builder03 = new StringBuilder();
        StringBuilder builder04 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder03.append("myChart_Cam"+i+".setOption({\n"
                    + "graphic: data_cam"+i+".map(function (item, dataIndex) {\n"
                    + "return {\n"
                    + "position: myChart_Cam"+i+".convertToPixel('grid', item)\n"
                    + " };\n"
                    + "})\n"
                    + "});\n");
        }
        String updateposition03 = "}\n";
        
        String UpdatePosition= updateposition01
                +builder03.toString()
                +builder04.toString()
                +updateposition03;                
        /**************************************************/        
        String showTooltip01 = "\n"
                + "function showTooltip(dataIndex) {\n";
        StringBuilder builder02 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder02.append("myChart_Cam"+i+".dispatchAction({\n" +
"type: 'showTip',\n" +
"seriesIndex: 0,\n" +
"dataIndex: dataIndex\n" +
"});\n");
        }
        String showTooltip02 = "}\n";

        String showTooltip = showTooltip01 + builder02.toString() + showTooltip02;
        /**************************************************/
        String hideTooltip01 = "\n"
                + "function hideTooltip(dataIndex) {\n";
        StringBuilder builder01 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder01.append("myChart_Cam1.dispatchAction({\n" +
"type: 'hideTip'\n" +
"});\n");
        }
        String hideTooltip02 = "}\n";

        String hideTooltip = hideTooltip01 + builder01.toString() + hideTooltip02;
        /**************************************************/
        String onpoint01="function onPointDragging(dataIndex, pos) {\n";
        StringBuilder builder06 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder06.append("data_cam"+i+"[dataIndex] = myChart_Cam"+i+".convertFromPixel('grid', pos);\n");
        }        
        String onpoint02="// Update data\n";
        StringBuilder builder07 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder07.append("myChart_Cam" + i + ".setOption({\n"
                    + "series: [{\n"
                    + "id: 'cam" + i + "',\n"
                    + " data: data_cam" + i + "\n"
                    + "}]\n"
                            + "});\n");
        }       
        String onpoint03="}\n";
        
        String OnPoint=onpoint01
                +builder06.toString()
                +onpoint02
                +builder07.toString()
                +onpoint03;
        /**************************************************/ 
        h1 = SetTimeOut
                + hh1
                + dataZoom
                + UpdatePosition
                + showTooltip
                + hideTooltip
                + OnPoint;
        
        
 return h1;
    }  
  
    public static String JS_DraggablePoints() {

        String h1 = "";
        
        
        StringBuilder builder08 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder08.append("setTimeout(function () {\n"
                    + "    // Add shadow circles (which is not visible) to enable drag.\n"
                    + "    myChart_Cam" + i + ".setOption({\n"
                    + "        graphic: data_cam" + i + ".map(function (item, dataIndex) {\n"
                    + "            return {\n"
                    + "                type: 'circle',\n"
                    + "                position: myChart_Cam" + i + ".convertToPixel('grid', item),\n"
                    + "                shape: {\n"
                    + "                    cx: 0,\n"
                    + "                    cy: 0,\n"
                    + "                    r: symbolSize\n"
                    + "                },\n"
                    + "                invisible: true,\n"
                    + "                draggable: true,\n"
                    + "                ondrag: function (dx, dy) {\n"
                    + "                    onPointDragging(dataIndex, [this.x, this.y]);\n"
                    + "                },\n"
                    + "                onmousemove: function () {\n"
                    + "                    showTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                onmouseout: function () {\n"
                    + "                    hideTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                z: 100\n"
                    + "            };\n"
                    + "        })\n"
                    + "    });\n"
                    + "}, 0);\n");
        }

        String SetTimeOut = builder08.toString();      
        
        
        StringBuilder builder01 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder01.append("/*"
                    + "setTimeout(function () {\n"
                    + "    // Add shadow circles to Cam#"+i+" (which is not visible) to enable drag.\n"
                    + "    myChart_Cam"+i+".setOption({\n"
                    + "        graphic: data_cam"+i+".map(function (item, dataIndex) {\n"
                    + "            return {\n"
                    + "                type: 'circle',\n"
                    + "                position: myChart_Cam"+i+".convertToPixel('grid', item),\n"
                    + "                shape: {\n"
                    + "                    cx: 0,\n"
                    + "                    cy: 0,\n"
                    + "                    r: symbolSize\n"
                    + "                },\n"
                    + "                invisible: true,\n"
                    + "                draggable: true,\n"
                    + "                ondrag: function (dx, dy) {\n"
                    + "                    onPointDragging(dataIndex, [this.x, this.y]);\n"
                    + "                },\n"
                    + "                onmousemove: function () {\n"
                    + "                    showTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                onmouseout: function () {\n"
                    + "                    hideTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                z: 100\n"
                    + "            };\n"
                    + "        })\n"
                    + "    });\n"
                    + "}, 0);\n"
                            + "*/");
        }       
        
        String k1="window.addEventListener('resize', updatePosition);\n";
        
        StringBuilder builder02 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder02.append("myChart_Cam"+i+".on('dataZoom', updatePosition);\n");
        }
        
        StringBuilder builder03 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder03.append("function updatePosition() {\n"
                    + "    myChart_Cam"+i+".setOption({\n"
                    + "        graphic: data_cam"+i+".map(function (item, dataIndex) {\n"
                    + "            return {\n"
                    + "                position: myChart_Cam"+i+".convertToPixel('grid', item)\n"
                    + "            };\n"
                    + "        })\n"
                    + "    });\n"
                    + "}\n");
        }  
        
        StringBuilder builder04 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder04.append("function showTooltip(dataIndex) {\n"
                    + "    myChart_Cam"+i+".dispatchAction({\n"
                    + "        type: 'showTip',\n"
                    + "        seriesIndex: 0,\n"
                    + "        dataIndex: dataIndex\n"
                    + "    });\n"
                    + "}\n");
        }     
        
        StringBuilder builder05 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder05.append("function hideTooltip(dataIndex) {\n"
                    + "    myChart_Cam"+i+".dispatchAction({\n"
                    + "        type: 'hideTip'\n"
                    + "    });\n"
                    + "}\n");
        }       
        
        StringBuilder builder06 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder06.append("function onPointDragging(dataIndex, pos) {\n"
                    + "    data_cam"+i+"[dataIndex] = myChart_Cam"+i+".convertFromPixel('grid', pos);\n"
                    + "\n"
                    + "    // Update data\n"
                    + "    myChart_Cam"+i+".setOption({\n"
                    + "        series: [{\n"
                    + "                id: 'cam"+i+"',\n"
                    + "                data: data_cam"+i+"\n"
                    + "            }]\n"
                    + "    });\n"
                    + "}\n");
        }
        
        h1 = 
                SetTimeOut
                //builder01.toString()
                +k1
                +builder02.toString()
                +builder03.toString()
                +builder04.toString()
                +builder05.toString()
                +builder06.toString();
        
        return h1;
    }
    
    public static String JS_DraggablePointCombo() {
    
    String h1="";
    
    
           StringBuilder builder08 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder08.append("setTimeout(function () {\n"
                    + "    // Add shadow circles (which is not visible) to enable drag.\n"
                    + "    myChart_Cam" + i + ".setOption({\n"
                    + "        graphic: data_cam" + i + ".map(function (item, dataIndex) {\n"
                    + "            return {\n"
                    + "                type: 'circle',\n"
                    + "                position: myChart_Cam" + i + ".convertToPixel('grid', item),\n"
                    + "                shape: {\n"
                    + "                    cx: 0,\n"
                    + "                    cy: 0,\n"
                    + "                    r: symbolSize\n"
                    + "                },\n"
                    + "                invisible: true,\n"
                    + "                draggable: true,\n"
                    + "                ondrag: function (dx, dy) {\n"
                    + "                    onPointDragging(dataIndex, [this.x, this.y]);\n"
                    + "                },\n"
                    + "                onmousemove: function () {\n"
                    + "                    showTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                onmouseout: function () {\n"
                    + "                    hideTooltip(dataIndex);\n"
                    + "                },\n"
                    + "                z: 100\n"
                    + "            };\n"
                    + "        })\n"
                    + "    });\n"
                    + "}, 0);\n");
        }

        String SetTimeOut = builder08.toString();    
    
    
//        String settimeout01 = "setTimeout(function () {\n";
//        StringBuilder builder08 = new StringBuilder();
//        for (int i = 1; i <= NumberOfCams(); i++) {
//            builder08.append("    myChart_Cam"+i+".setOption({\n"
//                    + "        graphic: data_cam"+i+".map(function (item, dataIndex) {\n"
//                    + "            return {\n"
//                    + "                type: 'circle',\n"
//                    + "                position: myChart_Cam"+i+".convertToPixel('grid', item),\n"
//                    + "                shape: {\n"
//                    + "                    cx: 0,\n"
//                    + "                    cy: 0,\n"
//                    + "                    r: symbolSize\n"
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
//                    + "    });\n");
//        }
//        String settimeout02="}, 0);\n";
//        String SetTimeOut= settimeout01+builder08.toString()+settimeout02;   
    
        /**************************************************/  
        String hh1="window.addEventListener('resize', updatePosition);\n";
        /**************************************************/         
        StringBuilder builder05 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
            builder05.append("myChart_Cam"+i+".on('dataZoom', updatePosition);\n");
        }
            String dataZoom=builder05.toString();
        /**************************************************/ 
         StringBuilder builder03 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder03.append("function updatePosition() {\n"
                    + "    myChart_Cam"+i+".setOption({\n"
                    + "        graphic: data_cam"+i+".map(function (item, dataIndex) {\n"
                    + "            return {\n"
                    + "                position: myChart_Cam"+i+".convertToPixel('grid', item)\n"
                    + "            };\n"
                    + "        })\n"
                    + "    });\n"
                    + "}\n");
        }  
        
        StringBuilder builder04 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder04.append("function showTooltip(dataIndex) {\n"
                    + "    myChart_Cam"+i+".dispatchAction({\n"
                    + "        type: 'showTip',\n"
                    + "        seriesIndex: 0,\n"
                    + "        dataIndex: dataIndex\n"
                    + "    });\n"
                    + "}\n");
        }     
        
        StringBuilder builder15 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder15.append("function hideTooltip(dataIndex) {\n"
                    + "    myChart_Cam"+i+".dispatchAction({\n"
                    + "        type: 'hideTip'\n"
                    + "    });\n"
                    + "}\n");
        }       
        
        StringBuilder builder06 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder06.append("function onPointDragging(dataIndex, pos) {\n"
                    + "    data_cam"+i+"[dataIndex] = myChart_Cam"+i+".convertFromPixel('grid', pos);\n"
                    + "\n"
                    + "    // Update data\n"
                    + "    myChart_Cam"+i+".setOption({\n"
                    + "        series: [{\n"
                    + "                id: 'cam"+i+"',\n"
                    + "                data: data_cam"+i+"\n"
                    + "            }]\n"
                    + "    });\n"
                    + "}\n");
        }
        
        h1 = SetTimeOut
                +hh1                
                +dataZoom
                +builder03.toString()
                + builder04.toString()
                + builder15.toString()
                + builder06.toString();
        
    return h1;
    }
    
    public static String JS_Loading() {
        String h1 = "";

        StringBuilder builder01 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder01.append("myChart_Cam" + i + ".showLoading({\n"
                    + "      text: cam" + i + "label+' Chart is Loading\\nPlease Wait..',\n"
                    + "      color: '#c23531',\n"
                    + "      textColor: '#000',\n"
                    + "      maskColor: 'rgba(255, 255, 255, 0.2)',\n"
                    + "      zlevel: 1\n"
                    + "    });\n");
        }

        String h2 = "\nsetTimeout(() => {\n";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("myChart_Cam" + i + ".hideLoading();\n"
                    + "myChart_Cam" + i + ".setOption(option_cam" + i + ");\n");
        }
        String h3 = "}, 1500);\n\n";

        h1 = builder01.toString() + h2 + builder.toString() + h3;

        return h1;
    }

    public static String JS_PointDrag() {

        String h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("var zr" + i + " = myChart_Cam" + i + ".getZr();\n");
            builder.append("zr" + i + ".on('click', function (params) {\n"
                    + "    var pointInPixel = [params.offsetX, params.offsetY];\n"
                    + "    var pointInGrid = myChart_Cam" + i + ".convertFromPixel('grid', pointInPixel);\n"
                    + "\n"
                    + "    if (myChart_Cam" + i + ".containPixel('grid', pointInPixel)) {\n"
                    + "        data_cam" + i + ".push(pointInGrid);\n"
                    + "\n"
                    + "        myChart_Cam" + i + ".setOption({\n"
                    + "            series: [{\n"
                    + "                    id: 'cam" + i + "',\n"
                    + "                    data: data_cam" + i + ",\n"
                            + "formatter: function() {\n" +
"    return '<b>'+ this.point.name +'</b>: '+ Highcharts.numberFormat(this.percentage, 2) +' %';\n" +
"}"
                    + "                }]\n"
                    + "        });\n"
                    + "    }\n"
                    + "});\n");
            builder.append("zr" + i + ".on('mousemove', function (params) {\n"
                    + "    var pointInPixel = [params.offsetX, params.offsetY];\n"
                    + ""
                    + "    zr" + i + ".setCursorStyle(myChart_Cam" + i + ".containPixel('grid', pointInPixel) ? 'copy' : 'default');\n"
                    + "});\n");
        }
        h1 = builder.toString();
        return h1;

    }
    
    
    public static String JS_onResize() {
        String h1 = "";

        String jj1 = "\nwindow.onresize = function () {\n";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("echarts.init(document.getElementById(\"maincam" + i + "\")).resize();\n");
        }
        String jj2 = "}\n";

        h1 = jj1 + builder.toString() + jj2;
        return h1;
    }
    
    public static String JS_ChartsArray() {
        String h1 = "";
        String h2 = "\nvar chartArr = [];\n";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("chartArr.push(myChart_Cam" + i + ");\n");
        }

        String k1 = "chartArr.push(myChart);";

        String h3 = "\nwindow.onresize = function () {\n"
                + "for(var i = 0; i < chartArr.length; i ++) {\n"
                + "chartArr[i].resize();\n"
                + "}\n"
                + "}\n";

        h1 = h2 + builder.toString() + k1 + h3;
        return h1;
    }
    
    public static String JS_WindowsOnLoad() {
        String h1 = "";

        String kk1= "window.onLoad = function() {\n";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("var ctx"+i+" = document.getElementById(\"maincam"+i+"\").getContext(\"2d\");\n"
                    + "//window.myLineChart"+i+" = new Chart(ctx"+i+").Area(data_cam"+i+",{responsive : true});\n"
            );
        }
        String kk2="}\n";
        h1 = kk1+builder.toString()+kk2;
        return h1;
    }
    
    
    public static String JS_MultiArray2One(Integer t) {
        String h1 = "";
        
        h1 = "var array = datacam" + t + ";\n"
                + "var arrayNum =array.join(\",\").split(\",\");\n"
                + "var max = Math.max.apply(null,arrayNum);";
        
        
        return h1;
    }
    
    public static String JS_RenderPDF() {
        String h1 = "";

        String h2 = "var canvas = document.getElementById(\"maincam\");\n"
                + "var dataURL = canvas.toDataURL();\n";
        
        h1 = "      var downPdf = document.getElementById(\"renderPdf\");\n"
                + "      downPdf.onclick = function() {\n"
                + "          html2canvas(document.body, {\n"
                + "              onrendered:function(canvas) {\n"               
                + "                  var pageData = canvas.toDataURL('image/jpeg', 1.0);\n"
                + "                  //a4【595.28,841.89]\n"
                + "                  var pdf = new jsPDF('', 'pt', 'a4');\n"
                + "                  //dataUrl\n"
                + "                  pdf.addImage(pageData, 'JPEG', 0, 0, 595.28, 592.28/canvas.width * canvas.height );\n"
                + "                  pdf.save('content.pdf');\n"
                + "              }\n"
                + "          })\n"
                + "      }\n"
                + "\n";

        return h1;
    }

    public static String JS_CanvasVars() {
        String h1 = "";
        
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\nvar canvas"+i+" = document.getElementById(\"maincam"+i+"\");\n"
                + "//var dataURL"+i+" = canvas"+i+".toDataURL();\n");
        }        
        
        h1 = builder.toString();
        return h1;
    }
    
    
    public static String JS_Get_eChartCanvas() {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append(""
                    + "var getCanvas" + i + "= myChart_Cam" + i + ".getRenderedCanvas({\n"
                    + " pixelRatio: 2,\n"
                    + " backgroundColor: '#fff'\n"
                    + "});\n");
        }

        h1 = builder.toString();
        return h1;
    }
    
    public static String JS_Get_eChartImage() {
    String h1="";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append(""
                    + "    var imgB64" + i + " = new Image();\n"
                    + "    img" + i + ".src = myChart_Cam" + i + ".getDataURL({\n"
                    + "        type: 'png', \n"
                    + "        pixelRatio: 2,\n"
                    + "        backgroundColor: '#fff'\n"
                    + "    });\n"
                            + "console.log('Eikona" + i + " : '+imgB64" + i + ");");
        }

        h1 = builder.toString();    
   return h1; }
    
    public static String JS_Func_Canvas() {
        String h1 = "";

        
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "setTimeout(function() {\n"
                    + "$ (document) .ready (function () {\n"
                    + "$('#maincam" + i + "').hide();\n"
                    + "var canvas" + i + " = document.getElementById (\"canvas" + i + "\");\n"
                    + "var dataURL" + i + " = canvas" + i + ".toDataURL();\n"
                    + "console.log('Image Base64 = '+dataURL" + i + ");\n"
                    + "var fullQuality" + i + " = canvas" + i + ".toDataURL('image/png',1.0);\n"
                            + "/*\n"
                    + "var cw=canvas" + i + ".width;\n"
                    + "var ch=canvas" + i + ".height;\n"
                    + "var tempCanvas" + i + "=document.createElement(\"canvastemp" + i + "\");\n"
                    + "var tctx" + i + "=tempCanvas" + i + ".getContext(\"2d\");\n"
                            + "*/\n"
                            + ""
                            + ""
                    + "    canvas" + i + ".width = 3800;\n"
                    + "    canvas" + i + ".height = 903;\n"
                            + ""
                    + "    var ctx" + i + " = canvas" + i + ".getContext ('2d');\n"
                    + "ctx" + i + ".fillStyle = \"red\";\n"
                    + "//ctx" + i + ".fillRect(20, 20, 75, 50);\n"
                    + "\n"
                    + "ctx" + i + ".globalAlpha = 1;\n"
                    + "ctx" + i + ".scale(1, 1);\n"                       
                    + "    \n"
                            + "var offcanvas" + i + " = myChart_Cam" + i + ".getRenderedCanvas ({\n"
                    + "        pixelRatio: 2,\n"
                    + "        backgroundColor: '#fff'\n"
                    + "    });\n"
                                    + ""
                    + " var img"+i+" = new Image();\n"
                    + "    img"+i+".src = myChart_Cam" + i + ".getDataURL({\n"
                    + "        pixelRatio: 2,\n"
                    + "        backgroundColor: '#fff'\n"
                    + "    });\n"
                                    + ""
                    + "   ctx" + i + ".drawImage (offcanvas" + i + ", 0,0);\n\n"
                    + "    //ctx" + i + ".drawImage(offcanvas" + i + ", 0,0, img" + i + ".width, img" + i + ".height, 0,0, canvas" + i + ".width, canvas" + i + ".height);\n"
                    + "   //ctx" + i + ".drawImage (getCanvas" + i + ", 0,0);\n"
                    + "   //ctx" + i + ".drawImage (img" + i + ", 0,0);\n"                          
                            
                    + "});\n"
                    + "//this.drawImage(myChart_Cam" + i + ", option_cam" + i + ");\n"
                    + "}, 2000);\n\n"
                    + ""
                  + "    function resize() {\n"
                    + "        setTimeout(function() {\n"
                    + "            ctx" + i + ".resize()\n"
                    + "        }, 100)\n"
                    + "    }\n"
                            + ""
                    + "// use configuration item and data specified to show chart\n"
                    + " /*"
                    + "ctx" + i + ".setOption(option_cam" + i + ", true), $(function() {\n"
                    + "    function resize() {\n"
                    + "        setTimeout(function() {\n"
                    + "            ctx" + i + ".resize()\n"
                    + "        }, 100)\n"
                    + "    }\n"
                    + "    $(window).on(\"resize\", resize),\n "
                    + "$(\".sidebartoggler\").on(\"click\", resize)\n"
                    + "});\n"
                    + "*/"

            );
        }

        h1 = builder.toString();         
        
        return h1;
    }
    
    
    
    public static String JS_PrintCanvasFunction() {
    String h1="";
    
            StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("function draw_voucher_img"+i+"()\n" +
"{\n" +
"   var canvas_ar"+i+" = $(\"#canvas"+i+"\")[0];\n" +
"   var voucher"+i+" = canvas"+i+".toDataURL();\n" +
"   $(\"#voucher_img"+i+"\").attr(\"src\", voucher"+i+");\n" +
"};\n");
        }

        h1 = builder.toString();
    
   
    return h1;}

    public static String JS_imgLoad() {
        String h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\ndraw_voucher_img"+i+"();\n");
        }

        h1 = builder.toString();
        String h2="img.onload = function(){"+h1+"}\n";
    
    return h2;}
    
    public static String JS_CanvasFuncPrint() {
    String h1="";
            StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("$(function(){\n" +
"\n" +
"    var canvas"+i+"=document.getElementById(\"canvas"+i+"\");\n" +
"    var ctx"+i+"=canvas"+i+".getContext(\"2d\");\n" +
"\n/*" +
"    ctx.fillStyle=\"gold\";\n" +
"    ctx.strokeStyle=\"blue\";\n" +
"    ctx.lineWidth=5;\n" +
"    ctx.rect(50,50,100,100);\n" +
"    ctx.fill();\n" +
"    ctx.stroke();\n" +
"\n*/" +
"    function print_voucher(){\n" +
"        var win=window.open();\n" +
"        win.document.write(\"<br><img src='\"+canvas"+i+".toDataURL()+\"'/>\");\n" +
"        win.print();\n" +
"        win.location.reload();\n" +
"    }\n" +
"\n" +
"    $(\"#printVoucher\").click(function(){ print_voucher(); });\n" +
"\n" +
"\n" +
"}); // end $(function(){});\n");
        }

        h1 = builder.toString();
   return h1; }
    
    
    
    
    public static String JS_DownloadImpByChart() {
         String h1="";
         
         
         
            StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n\n// Export image\n"
                + "function downloadImpByChart"+i+"(maincam"+i+") {\n"
                + "  var myChart = myChart_Cam"+i+";\n"
                + "  var url = myChart.getConnectedDataURL({\n"
                + "         pixelRatio: 5, // ​​exported image resolution ratio, the default is 1\n"
                + "         backgroundColor: '#fff', //chart background color\n"
                + "         excludeComponents: [ // Tool components that are ignored when saving the chart, the toolbar is ignored by default\n"
                + "      'toolbox'\n"
                + "    ],\n"
                + "         Type: 'png' //Image type supports png and jpeg\n"
                + "  });\n"
                + "  var $a"+i+" = document.createElement('a"+i+"');\n"
                + "  var type = 'png';\n"
                + "  $a"+i+".download = myChart.getOption().title[0].text + '.' + type;\n"
                + "  $a"+i+".target = '_blank';\n"
                + "  $a"+i+".href = url;\n"
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
                + "    '![](' + url + ')'\n"
                + "    '</body>';\n"
                + "    var tab = window.open();\n"
                + "    tab.document.write(html);\n"
                + "  }\n"
                + "};\n" );}
        

         h1 = builder.toString();

        return h1;
    }
    
    public static String JS_DownImgs() {
              
        String kkk1 = ""
                + "\n\n/////////////////////////////////////////\n\n"
                + "//Images Functions"
                + "//Get chart data\n"
                + "function loadChartData() {\n";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append(" "
                    + "//var chart" + i + " = echarts.init(document.getElementById('maincam" + i + "'));\n"
                            + "var chart"+i+" = myChart_Cam"+i+";\n");
        }
        String pppp1 = "var imagesGetUrl = [];\n";
        StringBuilder builder2 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder2.append(" imagesGetUrl.push(chart" + i + ".getDataURL());\n");
        }                
        String kkk2="return imagesGetUrl;\n"+"}\n\n";
        
        
        String h1 = kkk1+builder1.toString()+pppp1+builder2.toString()+kkk2;
        
        //////////////////////////////////////////////////
        StringBuilder builder3 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder3.append("var myChart"+i+" = myChart_Cam"+i+";\n"
                    + "var canvas"+i+" = $(\"#maincam"+i+"\").find(\"canvas\")[0];\n");
        }
        ////////////////////////////////////////////////// 
        
        String pppp2 = "var imagesToUrl = [];\n";
        StringBuilder builder4 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder4.append(" imagesToUrl.push(chart" + i + ".ToDataURL());\n");
        }                
        String kkk3="return imagesToUrl;\n"+"}\n\n";
        
        
        String h11 = pppp2+builder4.toString()+kkk3;        
        
        
        
        
//        String ooo1="var myChart1 = myChart_Cam1;"
//                + "var canvas1 = $(\"#maincam1\").find(\"canvas\")[0];";
        
            
        
        String jjj1 = "\n//Chart download\n"
                + "function exportsCharts() {\n"
                + "var images = loadChartData();\n"
                + "\n"
                + "    var url = apiPrefix + \"/downloadRunWholeCharts\";\n"
                + "    var form = $(\"<form></form>\").attr(\"action\", url).attr(\"method\", \"post\");\n"
                + "    form.append($(\"<input></input>\").attr(\"type\", \"hidden\").attr(\"name\", \"images\").attr(\"value\", images));\n"
                + "    form.appendTo('body').submit().remove();\n"
                + "}\n";

        
        
    return h1+h11+builder3.toString()+jjj1;}
    
    
    public static String CanvasCharts() {
        String h1 = "\n";
        String p1 = "\nvar canvasCharts = [];\n";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append(" canvasCharts.push($(\"#maincam"+i+"\").find(\"canvas\")[0]);\n");
        }
        String h11 = p1 + builder1.toString();
        return h11;
    }    
    
        public static String CanvasCTX() {
        String h1 = "\n";
        String p1 = "\nvar canvasIDs = [];\n";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("var canvas"+i+"=document.getElementById(\"canvas"+i+"\");\n"
                    + "var ctx"+i+"=canvas"+i+".getContext(\"2d\");\n"
                            + ""
                            + "canvasIDs.push(canvas"+i+"+ctx"+i+");\n");
        }
        String h11 = p1 + builder1.toString();
        return h11;
    }
    
    public static String ImageToDataURL() {
        String h1 = "\n";
        String p1 = "\nvar imagesToUrl = [];\n";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append(" imagesToUrl.push(myChart_Cam"+i+".ToDataURL());\n");
        }
        String h11 = p1 + builder1.toString();
        return h11;
    }
    
    public static String ImageGetDataURL() {
        String h1 = "\n";
        String p1 = "\nvar imagesGetUrl = [];\n";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append(" imagesGetUrl.push(myChart_Cam"+i+".GetDataURL());\n");
        }
        String h11 = p1 + builder1.toString();
        return h11;
    } 
    
   
    
    public static String JS_GetCanvasURL() {
        String h1 = "";
    
h1 = "var img = new Image();\n" +
"img.src = myChart.getDataURL({\n" +
"    pixelRatio: 2,\n" +
"    backgroundColor: '#fff'\n" +
"});\n";
        
        StringBuilder builder0001 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder0001.append("\n"
                    + "option_cam" + i + " && myChart_Cam" + i + ".setOption(option_cam" + i + ", true);"
                    //+ "myChart_Cam" + i + ".setOption(myChart_Cam" + i + ", true);"
                    + "\n"
                    + "var imgCanvasB64" + i + " = new Image();\n"
                    + "imgCanvasB64" + i + ".src = myChart_Cam" + i + ".getDataURL({\n"
                    //+ "imgCanvasB64" + i + ".src = myChart_Cam" + i + ".getConnectedDataURL({\n"
                    //getConnectedDataURL
                    + "    type: 'jpeg',\n"        
                    + "    pixelRatio: 2,\n"
                    + "    backgroundColor: '#fff',\n"
                    + "    excludeComponents: ['toolbox', 'dataZoom', 'legend', 'graphic', 'grid', 'title', 'yAxis']\n"
                    + "});\n"
//                    + "var heightb64" + i + " = (imgCanvasB64" + i + ".height)*0.2645833333;\n"
//                    + "var widthb64" + i + " = (imgCanvasB64" + i + ".width)*0.2645833333;\n"
                    + "var heightb64" + i + " = imgCanvasB64" + i + ".height;\n"
                    + "var widthb64" + i + " = imgCanvasB64" + i + ".width;\n"
//+"const canvasw" + i + " = document.getElementById('myChart_Cam" + i + "');\n" +
//"console.log(canvasw" + i + ".width); \n"                            
                            //+ "console.log(heightb64" + i + ");\n"
                    //+ "console.log(widthb64" + i + ");\n"
            //+ "console.log(imgCanvasB64" + i + ");\n\n"
            //+ "var canvasb64_" + i + " = document.getElementById('myChart_Cam" + i + "');\n"
            //+ "var dataURL" + i + " = canvasb64_" + i + ".toDataURL();\n"
            //+ "console.log('Image Chart : '+canvasb64_" + i + ");\n"
            );
        }
        
        String h2 = builder0001.toString();
        
        String h3 = "";
        
        h3= "//1 pixel = 0.2645833333 mm\n"
                + "//1157x0.2645833333\n"
                + "//600x0.2645833333\n"
                + "var chrtwidth = Math.floor(1157*0.2645833333);\n"
                + "var chrtheight = Math.floor(600*0.2645833333);\n";
        
        
        
        return h2;
    }
    
    
    
      public static String JS_jsPdfExport() throws IOException {
        String h1 = "";

        String pp1 = ""
                + "var currentDate = new Date()\n"
                + "var day = currentDate.getDate()\n"
                + "var month = currentDate.getMonth() + 1\n"
                + "var year = currentDate.getFullYear();\n"
                + "var today = new Date();\n"
                //+ "var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();\n"
                + "var date = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();\n"
                + "var time = today.getHours() + \":\" + today.getMinutes() + \":\" + today.getSeconds();\n"
                + "var dateTime = date+' - '+time;\n"
                + "var pagepdf = 'a4';\n"
                + "var pdfunits = 'mm';\n"
                + "var pdforient = 'l';\n"
                + "var jspdfImg = 'FAST';\n"
                + "var startXjspdf = 10;\n"
                + "var startYjspdf = 30;\n"
                //+ "var logocams = document.getElementById(\"logocams\").src; "
                + "var logocams = new Image()\n"
                + "logocams.src = '"+LocalhostName+"/MnIT_libs/imgs/camsdiag01.png';\n"
                //+ "var logobic = new Image()\n"
                //+ "logobic.src = '../MnIT_libs/imgs/bic_icon.png';\n"                
                + "var logoX = 270;\n"
                + "var logoY = 10;\n"
                + "var pdfchartscale = 0.75; \n"
                + "var startText1p = 145;\n"
                + "var endYtext1p = 100;\n"
                + "var cprtxt = '© All rights reserved, including cases of proprietary applications. "
                + "We retain sole power of disposal including all righty relating to copying and distribution.';"
                + "\n"

                //+ "   var can = document.getElementById('qr_code');\n"
                //+ "   var img = document.getElementById('imageid');\n"
                //+ "   var ctxqr = can[0].getContext('2d');\n"
                //+ "   ctx.drawImage(img, 10, 10);\n"
                //+ "   var encodedBase = can.toDataURL();\n"
                //+ "var b64qr = $('#qr_code img').attr('src');\n"
                //+ "var b64qr = qrcode;\n"
                //+ "console.log(b64qr);\n"
                + "function makePDF_" + CamJobName() + "(){\n"
                + "    var doc = new jsPDF(pdforient, pdfunits, pagepdf);\n"
                + "    doc.page=1;\n"
                + "    doc.setFontSize(18);\n"
                + "    doc.setFontStyle(\"normal\");\n"
                //+ "    doc.text('Assembly : '+AsmName, 10, 10);\n"
                //+ "    doc.text('Description : '+AsmDescription, 10, 16);\n"
                //+ "    doc.setLineWidth(0.4);\n"
                //+ "    doc.line(10, 20, 200, 20);\n"
                + "\nvar qrcode = new QRCode(\"qr_code\", {\n"
                + "    text: ''+window.location.href,\n"
                //+ "    text: 'mmanolas',\n"
                + "    width: 300,\n"
                + "    height: 300,\n"
                + "    colorDark : \"#000000\",\n"
                + "    colorLight : \"#ffffff\",\n"
                + "    correctLevel : QRCode.CorrectLevel.H\n"
                + "});\n"
                + "const qrDiv = document.getElementById('qr_code')\n" 
                + "var qrCode = new QRCode(\n"
                + "    qrDiv,\n"
                + "    {\n"
                + "        text: window.location.href,\n"
                + "        width: 150,\n"
                + "        height: 150,\n"              
                + "        onSuccess: (value) => {\n"
                + "            console.log('value',value);\n"
                + "        }\n"
                + "    }\n"
                + ");\n"
                + "const srcqr = qrDiv.children[0].toDataURL(\"image/png\");\n"
                + "//console.info(srcqr);\n"
                + "qrcode.clear();\n"
                + "    doc.addImage(logocams, 'png', 120, 10, 60, 60);\n"
                + "    doc.text('.:: CamsDiag ::. ', startText1p, 85, null, null, \"center\");"
                + "    doc.text('CAMs Job Name : '+AsmName, startText1p, endYtext1p, null, null, \"center\");\n"
                + "    doc.text('Description : '+AsmDescription, startText1p, endYtext1p+10, null, null, \"center\");\n"
                + "    doc.text('Total Charts : " + NumberOfCams() + "', startText1p, endYtext1p+(2*10), null, null, \"center\");\n"
                + "    //doc.text('User Name / Hostname : " + UserInfo.Get_UserName() + "/" + UserInfo.Get_ComputerName() + "', startText1p, endYtext1p+(3*10), null, null, \"center\");\n"
                //+ "    doc.text('Date : '+dateTime, startText1p, endYtext1p+(3*10), null, null, \"center\");\n"
                + "    doc.text('Date : '+dateCams+' - '+formatAMPM(new Date), startText1p, endYtext1p+(3*10), null, null, \"center\");\n"
                //dateCams+' - '+formatAMPM(new Date)
                + "    doc.setFontSize(8);\n"
                + "    doc.setFontStyle(\"normal\");\n"
                + "    var node = doc.outline.add(null, '" + CamJobName() + "', null);\n"
                //+ "    doc.text('('+window.location.href+')', startText1p, endYtext1p+(4*10), null, null, \"center\");\n"
                + "    doc.addImage(srcqr, 'png', 120, 140, 55, 55);\n"               
                + "    doc.addPage(pdforient, pdfunits, pagepdf);\n"
                //+ "    doc.text('Description : '+AsmDescription+' : '+cam" + i + "descl, startXjspdf, 16);\n"
                
                
                
                ;
               // + "    var width = doc.internal.pageSize.getWidth();\n"
                //+ "    var height = doc.internal.pageSize.getHeight();\n";

        
        
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("\n"
                    + "\n"
                    + "\n"
                    + "    doc.setFontSize(12);\n"
                    + "    doc.setFontStyle(\"normal\");\n"
                    + "    doc.text('CAMs Job Name : '+AsmName, startXjspdf, 10);\n"
                    + "    doc.text('Description : '/*+AsmDescription+' : '*/+cam" + i + "descl, startXjspdf, 16);\n"
                    + "    doc.text('C" + i + " : '+cam" + i + "label, startXjspdf, 22);\n"
                    + "    doc.setLineWidth(0.4);\n"
                    + "    doc.line(startXjspdf, 25, 290, 25);\n"
                    + "    var imgjsPDF" + i + "  = imgCanvasB64" + i + ";\n"
                    + "    //var width" + i + "cv = doc.internal.pageSize.getWidth();\n"
                    + "    //var height" + i + "cv = doc.internal.pageSize.getHeight();\n"
                    + "    //console.log(height" + i + "cv);\n"
                    + "    doc.addImage(imgCanvasB64" + i + ", 'PNG', -5, startYjspdf, 310,100, 'cam" + i + "label', jspdfImg);\n"
//                    + "    for(var i=0;i<cam"+i+"y.length;i++){\n"
//                    + "        cam"+i+"y[i] = cam"+i+"y[i]+\"mm\";   \n"
//                    + "    }\n"
//                    + "    for(var i=0;i<cam"+i+"x.length;i++){\n"
//                    + "        cam"+i+"x[i] = cam"+i+"x[i]+\"°\";   \n"
//                    + "    }\n"                            
                    + "    var txtinfo = 145;\n"
                    + "    doc.text('R(mm) : ['+cam"+i+"y+']', startXjspdf, txtinfo);\n"
                    + "    doc.text('Deg(°) : ['+cam"+i+"x+']', startXjspdf, txtinfo+5);\n"
                    + "    doc.text('Eccentric : '+Recc" + i + "+' mm', startXjspdf, txtinfo+10);\n"        
                    + "    doc.text('Rmax : '+max" + i + "element+' mm', startXjspdf, txtinfo+15);\n"
                    + "    doc.text('Rmin : '+min" + i + "element+' mm', startXjspdf, txtinfo+20);\n"        
                    + "    doc.addImage(logocams, 'png', logoX, logoY-5, 15, 15);\n"
                    + "    doc.setLineWidth(0.4);\n"
                    + "    doc.line(startXjspdf, 190, 290, 190);\n" 
                    + "    doc.setFontSize(8);\n"
                    + "    doc.setFontStyle(\"normal\");\n"                            
                    + "    doc.text(cprtxt, 150, 197, null, null, \"center\");\n"
                    + "    var pageCount" + i + " = doc.internal.getNumberOfPages();\n"
                    + "    var pcurrent = pageCount" + i + "-1;\n"
                    + "    doc.text(270,205, 'Page : ' + pcurrent+' / " + NumberOfCams() + "');\n"
                    + "    doc.text(10,205, 'Date : ' +dateCams+' - '+formatAMPM(new Date));\n" 
                    //+ "    doc.addImage(logobic, 'png', 135, 200, 3, 5);\n"
                    + "    doc.outline.add(node, cam" + i + "label+' ('+cam" + i + "descl+')', {pageNumber:" + i + "});\n"  
                    + "    doc.setDrawColor(255, 55, 40);"
                                  
                    + "    //doc.line(11, 60, 11, 140);\n"  
                    + "    //doc.line(71, 60, 71, 140);\n"        
                    + "    //doc.line(141, 60, 141, 140);\n"        
                    + "    //doc.line(211, 60, 211, 140);\n"        
                    + "    //doc.setLineWidth(0.2);\n"              
                    + "    doc.addPage(pdforient, pdfunits, pagepdf);\n"
//                    + "    doc.text('Assembly : '+AsmName, 10, 10);\n"
//                    + "    doc.text('Description : '+AsmDescription, 10, 16);\n"
//                    + "    doc.setLineWidth(0.4);\n"
//                    + "    doc.line(10, 20, 200, 20);\n"
                    //+ "    doc.save('" + CamJobName() + "');\n"
                    //+ "}\n"

                    + ""
//                    + "var doc = new jspdf.jsPDF({\n"
//                    + "    orientation: 'p',\n"
//                    + "    unit: 'pt',\n"
//                    + "    format: 'a4'\n"
//                    + "});\n"
//                    + "\n"
//                    + "doc.html(document.querySelector('#styledTable'), {\n"
//                    + "    callback: function (doc) {\n"
//                    + "        doc.save('file.pdf');\n"
//                    + "    },\n"
//                    + "    margin: [60, 60, 60, 60],\n"
//                    + "    x: 32,\n"
//                    + "    y: 32,\n"
//                    + "    html2canvas: {\n"
//                    + "        scale: 0.3, //this was my solution, you have to adjust to your size\n"
//                    + "        width: 1000 //for some reason width does nothing\n"
//                    + "    },\n"
//                    + "});"
            
            );
        }
        
        String pp2 = "\n"
                //+ "var pageCount = doc.internal.getNumberOfPages();\n"
                + "var pageCount = doc.internal.getNumberOfPages(); //Total Page Number\n"
                + "for(i = 0; i < pageCount; i++) { \n"
                + "  doc.setPage(i); \n"
                + "  let pageCurrent = doc.internal.getCurrentPageInfo().pageNumber; //Current Page\n"
                //+ "  doc.setFontSize(12);\n"
                //+ "  doc.text('page: ' + pageCurrent + '/' + pageCount, 10, doc.internal.pageSize.height - 10);\n"
                + "}\n"
                + "doc.deletePage(pageCount);\n"
                + "doc.setProperties({\n"
                + " title: AsmName,\n"
                + " subject: AsmDescription,\n"
                + " author: '" + UserInfo.Get_UserName() + "',\n"
                + " keywords: AsmName+' ::: Powered By : Apache Echarts',\n"
                + " creator: '" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + "'\n"
                + "});\n"
                + "doc.save('" + CamJobName() + "_" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + ".pdf');\n"
                + "}\n";
        
        
        
        String fpp1 = "\n"
                + "function footer(){\n"
                + "doc.text(150,285, 'page ' + doc.page);\n"
                + "doc.page ++;\n"
                + "};\n";
        
        
String h11 = pp1 + builder1.toString() + pp2;
        return h11;
    }
    

      public static String JS_jsPdfExport_PRODVIEW() throws IOException {
        String h1 = "";

        String pp1 = "\n"
                + "var currentDate = new Date()\n"
                + "var day = currentDate.getDate()\n"
                + "var month = currentDate.getMonth() + 1\n"
                + "var year = currentDate.getFullYear();\n"
                + "var today = new Date();\n"
                //+ "var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();\n"
                + "var date = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();\n"
                + "var time = today.getHours() + \":\" + today.getMinutes() + \":\" + today.getSeconds();\n"
                + "var dateTime = date+' - '+time;\n"
                + "var pagepdf = 'a4';\n"
                + "var pdfunits = 'mm';\n"
                + "var pdforient = 'l';\n"
                + "var jspdfImg = 'FAST';\n"
                + "var startXjspdf = 10;\n"
                + "var startYjspdf = 30;\n"
                //+ "var logocams = document.getElementById(\"logocams\").src; "
                + "var logocams = new Image()\n"
                //+ "//logocams.src = '"+aniscamsdiag01url+"charts/MnIT_libs/imgs/camsdiag01.png';\n"
                + "logocams.src = '" + CamJobName() + "/camsdiag01.png';\n"
                //+ "var logobic = new Image()\n"
                //+ "//logobic.src = '"+aniscamsdiag01url+"charts/MnIT_libs/imgs/bic_icon.png';\n"
                //+ "logobic.src = '" + CamJobName() + "/bic_icon.png';\n"                
                + "var logoX = 270;\n"
                + "var logoY = 10;\n"
                + "var pdfchartscale = 0.75; \n"
                + "var startText1p = 145;\n"
                + "var endYtext1p = 100;\n"
                + "var cprtxt = '© All rights reserved, including cases of proprietary applications. "
                + "We retain sole power of disposal including all righty relating to copying and distribution.';"
                + "\n"

                //+ "   var can = document.getElementById('qr_code');\n"
                //+ "   var img = document.getElementById('imageid');\n"
                //+ "   var ctxqr = can[0].getContext('2d');\n"
                //+ "   ctx.drawImage(img, 10, 10);\n"
                //+ "   var encodedBase = can.toDataURL();\n"
                //+ "var b64qr = $('#qr_code img').attr('src');\n"
                //+ "var b64qr = qrcode;\n"
                //+ "console.log(b64qr);\n"
                + "function makePDF_" + CamJobName() + "_prod(){\n"
                + "    var doc = new jsPDF(pdforient, pdfunits, pagepdf);\n"
                + "    doc.page=1;\n"
                + "    doc.setFontSize(18);\n"
                + "    doc.setFontStyle(\"normal\");\n"
                //+ "    doc.text('Assembly : '+AsmName, 10, 10);\n"
                //+ "    doc.text('Description : '+AsmDescription, 10, 16);\n"
                //+ "    doc.setLineWidth(0.4);\n"
                //+ "    doc.line(10, 20, 200, 20);\n"
                + "\nvar qrcode = new QRCode(\"qr_code\", {\n"
                + "    text: ''+window.location.href,\n"
                //+ "    text: 'mmanolas',\n"
                + "    width: 300,\n"
                + "    height: 300,\n"
                + "    colorDark : \"#000000\",\n"
                + "    colorLight : \"#ffffff\",\n"
                + "    correctLevel : QRCode.CorrectLevel.H\n"
                + "});\n"
                + "const qrDiv = document.getElementById('qr_code')\n" 
                + "var qrCode = new QRCode(\n"
                + "    qrDiv,\n"
                + "    {\n"
                + "        text: window.location.href,\n"
                + "        width: 150,\n"
                + "        height: 150,\n"              
                + "        onSuccess: (value) => {\n"
                + "            console.log('value',value);\n"
                + "        }\n"
                + "    }\n"
                + ");\n"
                + "const srcqr = qrDiv.children[0].toDataURL(\"image/png\");\n"
                + "//console.info(srcqr);\n"
                + "qrCode.clear();\n"
                + "    doc.addImage(logocams, 'png', 120, 10, 60, 60);\n"
                + "    doc.text('.:: CamsDiag ::. ', startText1p, 85, null, null, \"center\");"
                + "    doc.text('CAMs Job Name : '+AsmName, startText1p, endYtext1p, null, null, \"center\");\n"
                + "    doc.text('Descriptiion : '+AsmDescription, startText1p, endYtext1p+10, null, null, \"center\");\n"
                + "    doc.text('Total Charts : " + NumberOfCams() + "', startText1p, endYtext1p+(2*10), null, null, \"center\");\n"
                + "    //doc.text('User Name / Hostname : " + UserInfo.Get_UserName() + "/" + UserInfo.Get_ComputerName() + "', startText1p, endYtext1p+(3*10), null, null, \"center\");\n"
                //+ "    doc.text('Date : '+dateTime, startText1p, endYtext1p+(3*10), null, null, \"center\");\n"
                + "    doc.text('Date : '+dateCams+' - '+formatAMPM(new Date), startText1p, endYtext1p+(3*10), null, null, \"center\");\n"
                //dateCams+' - '+formatAMPM(new Date)
                + "    doc.setFontSize(8);\n"
                + "    doc.setFontStyle(\"normal\");\n"
                + "    var node = doc.outline.add(null, '" + CamJobName() + "', null);\n"
                //+ "    doc.text('('+window.location.href+')', startText1p, endYtext1p+(4*10), null, null, \"center\");\n"
                + "    doc.addImage(srcqr, 'png', 120, 140, 55, 55);\n"               
                + "    doc.addPage(pdforient, pdfunits, pagepdf);\n"
                //+ "    doc.text('Description : '+AsmDescription+' : '+cam" + i + "descl, startXjspdf, 16);\n"
                
                
                
                ;
               // + "    var width = doc.internal.pageSize.getWidth();\n"
                //+ "    var height = doc.internal.pageSize.getHeight();\n";

        
        
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("\n"
                    + "\n"
                    + "\n"
                    + "    doc.setFontSize(12);\n"
                    + "    doc.setFontStyle(\"normal\");\n"
                    + "    doc.text('CAMs Job Name : '+AsmName, startXjspdf, 10);\n"
                    + "    doc.text('Description : '/*+AsmDescription+' : '*/+cam" + i + "descl, startXjspdf, 16);\n"
                    + "    doc.text('C" + i + " : '+cam" + i + "label, startXjspdf, 22);\n"
                    + "    doc.setLineWidth(0.4);\n"
                    + "    doc.line(startXjspdf, 25, 290, 25);\n"
                    + "    var imgjsPDF" + i + "  = imgCanvasB64" + i + ";\n"
                    + "    //var width" + i + "cv = doc.internal.pageSize.getWidth();\n"
                    + "    //var height" + i + "cv = doc.internal.pageSize.getHeight();\n"
                    + "    //console.log(height" + i + "cv);\n"
                    + "    doc.addImage(imgCanvasB64" + i + ", 'PNG', -5, startYjspdf, 310,100, 'cam" + i + "label', jspdfImg);\n"
//                    + "    for(var i=0;i<cam"+i+"y.length;i++){\n"
//                    + "        cam"+i+"y[i] = cam"+i+"y[i]+\"mm\";   \n"
//                    + "    }\n"
//                    + "    for(var i=0;i<cam"+i+"x.length;i++){\n"
//                    + "        cam"+i+"x[i] = cam"+i+"x[i]+\"°\";   \n"
//                    + "    }\n"                            
                    + "    var txtinfo = 145;\n"
                    + "    doc.text('R(mm) : ['+cam"+i+"y+']', startXjspdf, txtinfo);\n"
                    + "    doc.text('Deg(°) : ['+cam"+i+"x+']', startXjspdf, txtinfo+5);\n"
                    + "    doc.text('Eccentric : '+Recc" + i + "+' mm', startXjspdf, txtinfo+10);\n"        
                    + "    doc.text('Rmax : '+max" + i + "element+' mm', startXjspdf, txtinfo+15);\n"
                    + "    doc.text('Rmin : '+min" + i + "element+' mm', startXjspdf, txtinfo+20);\n"        
                    + "    doc.addImage(logocams, 'png', logoX, logoY-5, 15, 15);\n"
                    + "    doc.setLineWidth(0.4);\n"
                    + "    doc.line(startXjspdf, 190, 290, 190);\n" 
                    + "    doc.setFontSize(8);\n"
                    + "    doc.setFontStyle(\"normal\");\n"                            
                    + "    doc.text(cprtxt, 150, 197, null, null, \"center\");\n"
                    + "    var pageCount" + i + " = doc.internal.getNumberOfPages();\n"
                    + "    var pcurrent = pageCount" + i + "-1;\n"
                    + "    doc.text(270,205, 'Page : ' + pcurrent+' / " + NumberOfCams() + "');\n"
                    + "    doc.text(10,205, 'Date : ' +dateCams+' - '+formatAMPM(new Date));\n" 
                    //+ "    doc.addImage(logobic, 'png', 135, 200, 3, 5);\n"
                    + "    doc.outline.add(node, cam" + i + "label+' ('+cam" + i + "descl+')', {pageNumber:" + i + "});\n"  
                    + "    doc.setDrawColor(255, 55, 40);"
                                  
                    + "    //doc.line(11, 60, 11, 140);\n"  
                    + "    //doc.line(71, 60, 71, 140);\n"        
                    + "    //doc.line(141, 60, 141, 140);\n"        
                    + "    //doc.line(211, 60, 211, 140);\n"        
                    + "    //doc.setLineWidth(0.2);\n"              
                    + "    doc.addPage(pdforient, pdfunits, pagepdf);\n"
//                    + "    doc.text('Assembly : '+AsmName, 10, 10);\n"
//                    + "    doc.text('Description : '+AsmDescription, 10, 16);\n"
//                    + "    doc.setLineWidth(0.4);\n"
//                    + "    doc.line(10, 20, 200, 20);\n"
                    //+ "    doc.save('" + CamJobName() + "');\n"
                    //+ "}\n"

                    + ""
//                    + "var doc = new jspdf.jsPDF({\n"
//                    + "    orientation: 'p',\n"
//                    + "    unit: 'pt',\n"
//                    + "    format: 'a4'\n"
//                    + "});\n"
//                    + "\n"
//                    + "doc.html(document.querySelector('#styledTable'), {\n"
//                    + "    callback: function (doc) {\n"
//                    + "        doc.save('file.pdf');\n"
//                    + "    },\n"
//                    + "    margin: [60, 60, 60, 60],\n"
//                    + "    x: 32,\n"
//                    + "    y: 32,\n"
//                    + "    html2canvas: {\n"
//                    + "        scale: 0.3, //this was my solution, you have to adjust to your size\n"
//                    + "        width: 1000 //for some reason width does nothing\n"
//                    + "    },\n"
//                    + "});"
            
            );
        }
        
        String pp2 = "\n"
                //+ "var pageCount = doc.internal.getNumberOfPages();\n"
                + "var pageCount = doc.internal.getNumberOfPages(); //Total Page Number\n"
                + "for(i = 0; i < pageCount; i++) { \n"
                + "  doc.setPage(i); \n"
                + "  let pageCurrent = doc.internal.getCurrentPageInfo().pageNumber; //Current Page\n"
                //+ "  doc.setFontSize(12);\n"
                //+ "  doc.text('page: ' + pageCurrent + '/' + pageCount, 10, doc.internal.pageSize.height - 10);\n"
                + "}\n"
                + "doc.deletePage(pageCount);\n"
                + "doc.setProperties({\n"
                + " title: AsmName,\n"
                + " subject: AsmDescription,\n"
                + " author: '" + UserInfo.Get_UserName() + "',\n"
                + " keywords: AsmName+' ::: Powered By : Apache Echarts',\n"
                + " creator: '" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + "'\n"
                + "});\n"
                + "doc.save('" + CamJobName() + "_" + UserInfo.Get_ComputerName() + "_" + UserInfo.Get_UserName() + ".pdf');\n"
                + "}\n";
        
        
        
        String fpp1 = "\n"
                + "function footer(){\n"
                + "doc.text(150,285, 'page ' + doc.page);\n"
                + "doc.page ++;\n"
                + "};\n";
        
        
String h11 = pp1 + builder1.toString() + pp2;
        return h11;
    }
    
 

    
    
    
    public String ImageFinalToPrint() throws IOException  {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append(""
                    + "\nvar canvas" + i + " = $(\"#maincam" + i + "\").find(\"canvas\")[" + (i-1) + "];\n"
                    + "var img" + i + " = canvas" +  i + ".toDataURL(\n"
                    + "{\n"
                    + " type: ('png', 1), \n"
                    + " pixelRatio: 4,\n"
                    + " backgroundColor: '#fff'\n"
                    + "}"
                    + ");\n"
                            + "console.log(img" + i + ");\n"
                                    + "console.log(canvas" + i + ");\n"
                            + ""
//                            + "\nvar canvasR" + i + " = document.getElementById('myCanvas" + i + "');\n" +
//"var context" + i + " = canvasR" + i + ".getContext('2d');\n"
                            + ""
                            + ""
//                    + "var img"+i+" = new Image();\n"
//                    + "var myCanvas" + i + " = document.getElementsByTagName(\"canvas\")[0];\n"
//                    +"var ctx" + i + " = myCanvas" + i + ".getContext(\"2d\");\n"       
//                    + "//ctx" + i + ".drawImage(this, 0, 0); \n"
//                    + "var dataURL" + i + " = myCanvas" + i + ".toDataURL(\"image/png\");\n"        
                            
                            
//                    + "img" + i + ".setAttribute('crossOrigin', 'anonymous');\n"
//                    + "img" + i + ".src = imageUrl;\n"
//                    + "img" + i + ".onload = function() {\n"
//                    + "    var myCanvas" + i + " = document.getElementsByTagName(\"canvas\")[0];\n"
//                    + "    var ctx" + i + " = myCanvas" + i + ".getContext(\"2d\");\n"
//                    + "    ctx" + i + ".drawImage(this, 0, 0); \n"
//                    + "    var dataURL" + i + " = myCanvas" + i + ".toDataURL(\"image/jpeg, 0.5\");\n"
//                    + "    console.log(dataURL" + i + ");\n"
//                    + "};\n"
            );
        }
                String canvasAll = ""
                        + "\nvar canvasAll = $(\"#mainAll\").find(\"canvas\")[0];\n"
                + "var imageAll = canvasAll.toDataURL(\n"
                + "{\n"
                + " type: ('png', 0.5), \n"
                + " pixelRatio: 0.5,\n"
                + " backgroundColor: '#fff'\n"
                + "}"
                + ");\n";
//        h1 = "var img = new Image();\n"
//                + "img.setAttribute('crossOrigin', 'anonymous');\n"
//                + "img.src = imageUrl;\n"
//                + "img.onload = function() {\n"
//                + "    var myCanvas = document.getElementsByTagName(\"canvas\")[0];\n"
//                + "    var ctx = myCanvas.getContext(\"2d\");\n"
//                + "    ctx.drawImage(this, 0, 0); \n"
//                + "    var dataURL = myCanvas.toDataURL(\"image/jpeg, 0.5\");\n"
//                + "    console.log(dataURL);\n"
//                + "};\n";

String tablehtml = "/*\n"
        + "\nvar tableImg = $(\"#dvTable\").find(\"canvas\")[0];\n"
                + "var ImgUserDataTable = tableImg.toDataURL(\n"
                + "{\n"
                + " type: ('png', 1), \n"
                + " pixelRatio: 5,\n"
                + " backgroundColor: '#fff',\n"
                + "}"
                + ");\n"
        + "*/\n";

        return builder.toString()+canvasAll+tablehtml;
    }
    
    
    public static String JS_ConvertRender() {
        String h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "/*\n"
                    + "const Canvas" + i + " = require('maincam" + i + "');\n"
                    + "const echarts" + i + " = require('echarts');\n"
                    + "echarts" + i + ".setCanvasCreator(function () {\n"
                    + "    return Canvas" + i + ".createCanvas(100, 100)\n"
                    + "})\n"
                    + "// ...\n"
                    + "function renderChart" + i + "(datacam" + i + ") {\n"
                    + "  const option" + i + " = JSON.parse(datacam" + i + ");\n"
                    + "  const chart" + i + " = echarts.init(Canvas" + i + ".createCanvas(400, 400), {}, {\n"
                    + "    devicePixelRatio: 2\n"
                    + "  })\n"
                    + "  chart.setOption(option_cam" + i + ");\n"
                    + "  return chart" + i + ".getDom().toBuffer();\n"
                    + "}\n\n"
                            + "*/"
            );
        }

        h1 = builder.toString();
        
        return h1;
    }
    
    
    public static String JS_ExportButtonFunction() throws IOException {
        String h1 = "\n\n";
        h1 = "\n\n$(\"#exportButton\").click(function(){\n"
                + "var pdf = new jsPDF(\"l\", \"mm\", \"a3\");\n";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "var divHeight" + i + " = $('#maincam" + i + "').height();\n"
                    + "var divWidth" + i + " = $('#maincam" + i + "').width();\n"
                    + "pdf.addImage(canvas" + i + ", 'png', 10, 10);\n"
                    + "pdf.addPage();\n");
        }
        String ooo1 = "pdf.addImage(imageAll, 'png', 10, 10);\n";
        String pp1 = "pdf.setProperties({\n"
                + "	title: \"" + UserInfo.Get_UserName().toLowerCase() + "_" + CamJobName() + "\",\n"
                + "	subject: \"" + CamJobName() + " - Cams Diagramms\",		\n"
                + "	author: \"" + UserInfo.Get_UserName().toLowerCase() + "\",\n"
                + "	keywords: \"CamsDiag, Cams, Charts, " + CamJobName() + "\",\n"
                + "	creator: \"Developer; Manolis Manolas\",\n"
                + "\n"
                + "});";
        
        String k1 = ""
                + "pdf.save(\"" + UserInfo.Get_UserName().toLowerCase() + "_" + CamJobName() + ".pdf\");\n"
                + "});\n";

        return h1 + builder.toString() +ooo1+pp1+ k1;
    }
    
    /*
    chart = echarts.init(chart_dom);

chart_img = chart.getDataURL()


<img v-if="print_mode" class="print-only" :src="chart_img"></img>
    */
    
    
    
    public static String GetImageBase64string() {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("var objB64" + i + " = document.getElementById(\"maincam" + i + "\");\n"
                    + "var myB64Chart" + i + " = echarts.init(objB64" + i + ");\n"
                    + "myB64Chart" + i + ".getDataURL({\n"
                            + " type: 'png',\n"
                            + " pixelRatio: 5,\n"
                            + " backgroundColor: '#fff'\n"
                            + "});\n");
        }
        
        String func1 = builder.toString();
        
        String Array1="\nvar chartsB64str = [];\n";
        StringBuilder builder2 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder2.append("chartsB64str.push(myB64Chart" + i + ");\n");            
        }
        
        String func2 = Array1+builder2.toString();
        
        h1 = func1+func2;

        String consolelog="console.log('rrrrr'+myB64Chart1);\n";
        
        return h1;
    }
    
    public static String GetCanvas_ExportPictures() {
        String h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\nvar canvas" + i + " = $(\"#maincam" + i + "\").find(\"canvas\")[0];\n"
                    + "var image" + i + " = canvas" + i + ".toDataURL(\n"
                            + "{\n" +
" type: ('png', 1.0), \n" +
" pixelRatio: 2,\n" +
" backgroundColor: '#fff'\n" +
"}\n"
                           // + "console.log(image" + i + ")"
                            + ");\n");
        }
        
        String canvasAll = "\nvar canvasAll = $(\"#mainAll\").find(\"canvas\")[0];\n"
                + "var imageAll = canvasAll.toDataURL(\n"
                + "{\n"
                + " type: ('png', 1.0), \n"
                + " pixelRatio: 2,\n"
                + " backgroundColor: '#fff'\n"
                + "}"
                + ");\n";
        
        String func = builder.toString()+canvasAll;
        
        StringBuilder builder1 = new StringBuilder();
        String v1 = "\nvar images64 = [];\n";
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("images64.push(image"+i+");\n");
        }
        
        
        String v2 = "\nvar canvas64 = [];\n";
        StringBuilder builder2 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder2.append("canvas64.push(canvas"+i+");\n");
        }        
        
        String func2 = v2+builder2.toString();
        
        h1 = func+v1+builder1.toString()+func2;
        
        String consolelog="console.log('images : '+canvas1);\nconsole.log('vanvas : '+image1)";
        
        
        return h1;
    }
    
    
    public static String HTML2Canvas_Table_Print() throws IOException{
        String h1 = "";
        String pp1 = "\npdf.setProperties({\n"
                + "	title: \"" + UserInfo.Get_UserName().toLowerCase() + "_" + CamJobName() + "_DataTable\",\n"
                + "	subject: \"" + CamJobName() + " - Cams Diagramms\",		\n"
                + "	author: \"" + UserInfo.Get_UserName().toLowerCase() + "\",\n"
                + "	keywords: \"CamsDiag, Cams, Charts, " + CamJobName() + "\",\n"
                + "	creator: \"Developer; Manolis Manolas\"\n"
//                + "///////////////////////////////////////////\n"
//                + "//Dept: \"M&IT-GR\",\n"
//                + "//Company: \"BIC Violex S.A.\",\n"
//                + "//CopyRight: \"All rights reserved by BicViolex S.A., including cases of proprietary applications. We retain sole power of disposal including all righty relating to copying and distribution. \",\n"
//                + "//Software: \" CamsDiag\",\n"

//                + "\n"
                + "});\n";
        h1 = "\n\n$('#printDataTable').click(function() {\n"
                + "\n"
                + "var divHeight = $('#dvTable').height();\n"
                + "var divWidth = $('#dvTable').width();\n"
                + "var ratio = divHeight / divWidth;\n"
//                + "var scaleFactor = Math.floor(600 / 118);\n"
                + "var w = document.getElementById(\"dvTable\").offsetWidth;\n"
                + "var h = document.getElementById(\"dvTable\").offsetHeight;\n"
                + "html2canvas(document.getElementById(\"dvTable\"), {\n"
                + "height: divHeight,\n"
                + "width: divWidth,\n"
                + "//dpi: 300, // Set to 300 DPI\n"
                + "//scale: 1, // Adjusts your resolution\n"
                + "onrendered: function(canvas) {\n"
//                + "var width = canvas.width;\n"
//                + "var height = canvas.height;\n"
//                + "var millimeters = {};\n"
//                + "millimeters.width = Math.floor(width * 0.264583);\n"
//                + "millimeters.height = Math.floor(height * 0.264583);\n"
                + "var img = canvas.toDataURL(\"image/png\");\n"
                + "var pdf = new jsPDF('l', 'px', 'a3');\n"
                + "\n"
                + "var width = pdf.internal.pageSize.getWidth();\n"
                + "var height = pdf.internal.pageSize.getHeight();\n"
                + "height = ratio * width;\n"
//                + "//var pdf = new jsPDF('p', 'pt', 'a3');\n"
//                + "//var pdf = new jsPDF('p', 'pt', [canvas.width, canvas.height]);\n"
//                + "//var pdfWidth = pdf.internal.pageSize.getWidth();\n"
//                + "//var pdfHeight = pdf.internal.pageSize.getHeight();\n"
//                + "//pdf.deletePage(1);\n"
//                + "//pdf.addPage(millimeters.width, millimeters.height);\n"
//                + "//pdf.addImage(img, 'png', 0, 0, w, h);\n"
//                + "//pdf.addPage(millimeters.width, millimeters.height);\n"
//                + "//pdf.addImage(img, 'PNG', 0, 0, pdfWidth, pdfHeight);\n"
                + "pdf.addImage(img, 'png', 0, 0, width-10, height-10);\n"
//                + "//pdf.addImage(img, 'png', 0, 0,w,h);\n"
                + pp1
                + "pdf.save('" + CamJobName() + "_Data.pdf');\n"
                + "}\n"
                + "});\n"
                + "});\n\n";
        
        String j2 = "\nfunction Export() {\n"
                + "html2canvas(document.getElementById('dvTable'), {\n"
                + "onrendered: function (canvas) {\n"
                + "var data = canvas.toDataURL();\n"
                + "var docDefinition = {\n"
                + "info: {\n"
                + "title: '" + UserInfo.Get_UserName().toLowerCase() + "_" + CamJobName() + "_UserDataTable',\n"
                + "author: 'Manolis Manolas',\n"
                + "subject: '" + CamJobName() + " - Cams Diagramms',\n"
                + "keywords: 'CamsDiag, Cams, Charts, " + CamJobName() + "',\n"
                + "},\n"
                + "content: [{\n"
                + "        image: data,\n"
                + "        width: 550\n"
                + "        //height: 'auto'\n"
                + "}]\n"
                + "};\n"
                + "pdfMake.createPdf(docDefinition).download(\"" + CamJobName() + "_UserData.pdf\");\n"
                + "}\n"
                + "});\n"
                + "}\n\n";
        
        
        //return h1+j2;
        return j2;
    }
    
    
    public static String CamImagesPDFmake() throws IOException {
        String h1 = "";
        h1 = "function CamImagesToPDF() {\n";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("//html2canvas(document.getElementById('maincam" + i + "'),\n");
        }
        String j1 = "{\n"
                + "//onrendered: function (canvas) {\n";
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("//var dataImg" + i + " = canvas.toDataURL();\n");
        }
        String k1 = "var docDefinition = {\n"
                + "info: {\n"
                + "title: '" + UserInfo.Get_UserName().toLowerCase() + "_" + CamJobName() + "_Cams Diagrams',\n"
                + "author: 'Manolis Manolas',\n"
                + "subject: '" + CamJobName() + " - Cams Diagramms',\n"
                + "keywords: 'CamsDiag, Cams, Charts, " + CamJobName() + "',\n"
                + "},\n"
                + "content: [\n"
                + "{\n"
                + "text: '" + CamJobName() + "',\n"
                + "style: 'header',\n"
                + "alignment: 'center'\n"
                + "},\n";
        StringBuilder builder2 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder2.append("{\n"
                    + " image: img" + i + ",\n"
                    + " width: 550\n"
                    + " //height: 'auto'\n"
                    + "},\n"
                    + ""

            );
        }        
        String p1="]\n"
                + "};\n"
                + "pdfMake.createPdf(docDefinition).download(\"" + CamJobName() + "_Cams.pdf\");\n"
                + "//}\n"
                + "};\n"
                + "}\n";

        String ReurnFunct = h1+builder.toString()+j1+builder1.toString()+k1+builder2.toString()+p1;
        
 return ReurnFunct;}
    
    public static String JS_getFullCanvasDataURL() {
        String h1 = "";
        h1 = "\n\ngetFullCanvasDataURL(divId){\n"
                + "                                 //Use the first canvas as a benchmark.\n"
                + "                var baseCanvas = $(\"#\"+divId).find(\"canvas\").first()[0];\n"
                + "                if(!baseCanvas){\n"
                + "                    return false;\n"
                + "                };\n"
                + "                var width = baseCanvas.width;\n"
                + "                var height = baseCanvas.height;\n"
                + "                var ctx = baseCanvas.getContext(\"2d\");\n"
                + "                                 / / Traverse, add the subsequent canvas to the first one\n"
                + "                $(\"#\"+divId).find(\"canvas\").each(function(i,canvasObj){\n"
                + "                    if(i>0){\n"
                + "                        var canvasTmp = $(canvasObj)[0];\n"
                + "                        ctx.drawImage(canvasTmp,0,0,width,height);\n"
                + "                    }\n"
                + "                });\n"
                + "                                 / / Get the base64 bit url\n"
                + "                return baseCanvas.toDataURL();\n"
                + "            }\n";
        return h1;
    }
    
    
    public static String ArrowMouseEvents() {
        String h1 = "";
        String h2 =" var txt1 = arrow_ccw;\n"
                    + " var txt2 = arrow_cw;\n";
        StringBuilder builder2 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder2.append("\n"
//                    + " function ChangeArrow() {\n"
//                     + "myChart_Cam" + i + ".on('click', function (params) {\n"
//                    + "//window.open('https://www.google.com/s?wd=' + encodeURIComponent(params.name));\n"
//                            + "if(params.componentType == \"graphic\"){\n"
//                                +"return txt2;\n"
//                            + "}\n"
//                    + "});"
//                    
//                    + "}\n"
//                    + ""
//                             + ""
                    + "myChart_Cam" + i + ".on('click', function (params) {\n"
                    + "//window.open('https://www.google.com/s?wd=' + encodeURIComponent(params.name));\n"
                            + "//console.log(params);\n"
                            + "if(params.componentType == \"graphic\"){\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + "  graphic:  {\n"
                    + "  textContent: {\n"
                    + " style: {\n"
                    + "    text: txt1,\n"
                    + "}\n"
                    + "}"
//                            + "{\n"
//                    + "  return txt1;\n"
//                    + "  },\n"
                    + "}\n"
                    + "});\n"
                                //+"return txt1;\n"
                            + ""
                            + "}\n"
                    + "});"
                    
//                    + "myChart_Cam" + i + ".on('click', function (params) {\n"
//                            + "var cw = arrow_cw;\n"
//                            + "var ccw = arrow_ccw;\n"
//                    + "if(params.componentType == \"graphic\"){\n"
//                    + "//alert(\"clicked\"+params.value+\"x-axis label\");\n"
//                            + "+console.log(arrow_cw);\n"
//                            +"\n"
//                    + "}else{"
//                            +"\n"
//                            +"console.log(arrow_ccw);\n"
//                    + "//alert(\"Click ed\"+params.name+\"line\");\n"
//                    + "}\n"
//                    + "});\n"
                    
                    /*
myChart.on('dblclick', params => {
  if (params.componentType === 'title') {
    console.log('title is double-clicked!')
  }
})                    
                    */
                    
                    
//                + "myChart_Cam"+i+".on('click', params => {\n"
//                + "  	if(params.targetType === 'axisLabel'){\n"
//                + "      console.log(params.value);    	\n"
//                + "    }\n"
//                + "  })"

            );
        }         
        
        return h2+builder2.toString();
    }
    
    
}
