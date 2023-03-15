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
import static main.Echarts.Echarts_SetOptions.CamChart_DatGUI;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.Cam_DatGui_js;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class JS_DatGui {
    
    
        public static void main(String args[]) throws Exception {
        DatGUI();
    }
    
    
        public static void DatGUI() throws IOException {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+Cam_DatGui_js);
        
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
//        w.write(Echarts_OptionsCamAll_p01());
//            for (int i = 1; i <= NumberOfCams(); i++) {
//                w.write(Echarts_OptionsCamAll_p02(i));                
//            }
int i = 0;
            w.write(
                    CamChart_DatGUI(i)
                    //DatGui_01()

            );
         w.close();
        }
    }
        
            public static String DatGui_01() {
        String h1 = "";
        
                StringBuilder builder2 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder2.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "series: {\n"
                            + "    //type: 'line',\n"
                            + "    label: {\n"
                            + "             show: config.Chart_Labels,\n"
                            + "       }\n"
                            + "   }\n"
                            + "});\n"
                    );
                }
                
                StringBuilder builder3 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder3.append("\n"
                            //+"myChart_Cam" + i + ".clear()"
                            + "myChart_Cam" + i + ".setOption({\n"
//                                    
                            + "graphic: {\n"
                            + "type: 'circle',\n"
                            + "style: {\n"
                            + "opacity: config.ShafText_Opacity,\n"
                            + "},\n"
                            + "textContent: {\n"
                            + "style: {\n"
                            + " opacity:  config.ShafText_Opacity,\n"
                            + "  }\n}\n"
                            + "}\n"
                            + "});\n"       
                                    
//                            + "/*"
//                            + "graphic: {\n"
//                            + "type: 'group',\n"
//                            + "style: {\n"
//                            + "opacity: config.ShafText_Opacity,\n"
//                            + "},\n"
//                            + "//}\n"
//                            + "*/"

                            
                            
                            
//                            + "graphic: {\n"
//                            + "//type: 'circle',\n"
//                            + "//style: {\n"
//                            + " //opacity:  config.ShafText_Opacity,\n"
//                                     +"invisible:  config.ShafText_Opacity,\n"
//                            + "//   },\n"
//                            + "//textContent: {\n"
//                            + "//style: {\n"
//                                    +"//invisible:  config.ShafText_Opacity,\n"
//                            + " //opacity:  config.ShafText_Opacity,\n"
//                            + "//   }	\n"
//                            + "//}\n"
//                                    + ""
//                                    + "//type: 'group',\n"
//                                    + "//{\n"
//                                    + "//invisible: config.ShafText_Opacity,\n"
//                                    + "//}"
//                            + "},"
//                            + "\n"
//                            //+ "console.log(\"Graphic01 Function\");\n"
                            
                    );
                }                
                
                
                StringBuilder builder4 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder4.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "series: {\n"
                            + "\n"
                            + "markArea: {\n"
                            + " animation: true,\n"
                            + " animationEasing: \"quarticIn\",\n"
                            + " z: -1,\n"
                            + "\n"
                            + "itemStyle: {\n"
                            + "normal: {\n"
                            + "color: bic_color,\n"
                            + "opacity: chart_opacity\n"
                            + "},\n"
                            + "emphasis: {\n"
                            + "color: shaftcolor_emp,\n"
                            + "opacity: chart_opacity\n"
                            + " }\n"
                            + " },\n"
                            + " label: {\n"
                            + " show: false,\n"
                            + " position: 'top',\n"
                            + " color: \"grey\",\n"
                            + " fontSize: 12\n"
                            + "  },\n"
                            + "    labelLayout: {\n"
                            + "    hideOverlap: true\n"
                            + " },\n"
                            + " data: [\n"
                            + "  [{\n"
                            + "   name: shaftdiam_label_cam1,\n"
                            + "    yAxis: 0\n"
                            + "     }, {\n"
                            + "       yAxis: 0\n"
                            + "      }]\n"
                            + "  ]\n"
                            + "},\n"

                            + "markLine: {\n"
                            + " symbol: \"none\",\n"
                            + " data: [\n"
                            + " {\n"
                            + "   silent: false,\n"
                            + "   lineStyle: {\n"
                            + "   type: \"dashed\",\n"
                            + "   // color: \"#FA3934\",\n"
                            + "    width: linestulemfasis - 3,\n"
                            + "   opacity: chart_opacity+0.3\n"
                            + "  },\n"
                            + " label: {\n"
                            + "  show: false,\n"
                            + "   position: 'middle',\n"
                             + " formatter: \"Shaft Diameter \"+diameterSymbol+\" :\\n\"+shaftdiam_cam" + i + " + ' mm',\n"
                            + "   fontSize: '15'\n"
                            + "   },\n"
                            + "  yAxis: shaftdiam_cam" + i + "\n"
                            + "}]},\n"                                   
                                    
                                    
                            + "},"
                            + "\n"
                                    //+ "console.log(\"Shaft Function\");\n"
                            + "});\n"
                    );
                }                
                
                
                StringBuilder builder5 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder5.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "series: {\n"
                            + "areaStyle: {\n"
                            + " color:  obj.Chart_Color,\n"
                            + "   },\n"
                            + "},"
                            + "\n"
                            + "});\n"
                    );
                }                  
                
                StringBuilder builder6 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder6.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "grid: {\n"
                            + "show: config.Grid,\n"
                            + "//containLabel: config.Grid,\n"
                            + "},\n"
                            + "});\n"
                    );
                }                 
                
                StringBuilder builder7 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder7.append("\n"

                            //+ "var myChart_Cam"+i+" = echarts.init(document.getElementById('maincam"+i+"'), config.Theme);"
                           + "myChart_Cam" + i + ".setOption({\n"
                            + "//this.initECharts();\n"
                            + "//this.maincam"+i+" = echarts.init(document.getElementById('maincam"+i+"'),'config.Theme');\n"                                   
//                            + "grid: {\n"
//                            + "show: config.Grid\n,"
//                            + "containLabel: config.Grid\n,"
//                            + "},\n"
                            + "});\n"
                    );
                }                
                
                
                StringBuilder builder8 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder8.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "series: {\n"
                            + "smooth: config.Smooth,\n"
                            + "//containLabel: config.Grid,\n"
                            + "},\n"
                            + "});\n"
                    );
                }                
                
                
                StringBuilder builder9 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder9.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "yAxis: {\n"
                            + "//interval: 90,\n"
                            + "        minorTick: {\n"
                            + "            show: config.Axis\n"
                            + "        },\n"
                            + "        minorSplitLine: {\n"
                            + "            show: config.Axis\n"
                            + "        },"
                            + "        splitLine: {\n"
                            + "            show: config.Axis,\n"
                            + "            lineStyle: {\n"
                            + "                type: 'solid',\n"
                            + "                color: '#ccc'\n"
                            + "            }\n"
                            + "        }"
                            + "},\n"
                            + "xAxis: {\n"
                            + "//interval: 90,\n"
                            + "        minorTick: {\n"
                            + "            show: config.Axis\n"
                            + "        },\n"
                            + "        minorSplitLine: {\n"
                            + "            show: config.Axis\n"
                            + "        },\n"
                            + "        splitLine: {\n"
                            + "            show: config.Axis,\n"
                            + "            lineStyle: {\n"
                            + "                type: 'solid',\n"
                            + "                color: '#ccc'\n"
                            + "            }\n"
                            + "        }"
                            + "},\n"
                            + "});\n"
                    );
                }               
                
                
                
                StringBuilder builder10 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder10.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + " title: {\n"
                            + "        show: config.Title,\n"
                            + "    }"
                            + "});\n"
                    );
                }               
                
                
                StringBuilder builder11 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder11.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + " legend: {\n"
                            + "        show: config.Legend,\n"
                            + "    }"
                            + "});\n"
                    );
                }                 
                
                
                StringBuilder builder12 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder12.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + " toolbox: {\n"
                            + "        show: config.Toolbox,\n"
                            + "    }"
                            + "});\n"
                    );
                }       
                
                
                StringBuilder builder13 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder13.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + " graphic: {\n"
                            + ""
                            //+ "{\n"
                            + "//id: 'CamCircleIn" + i + "',\n"
                            + "   type: 'circle',\n"
                            + "      style: {\n"
                            + "         opacity: config.ShafText_Opacity, \n"

                            + "      }\n"
                            //+ "}\n"
//                                    +"type: 'circle',\n"
//                                    + "style: {\n"
//                                    + "opacity: config.ShafText_Opacity,\n"
//                                    + "},\n"
                                    + ""
                                    + ""
                                    + ""
                            + "    }"
                            + "});\n"
                    );
                }                  
                
                
                StringBuilder builder14 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder14.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + " series: {\n"
                            + "        symbolSize: config.Symbol_Size,\n"
                            + "    }"
                            + "});\n"
                    );
                }      
                
                StringBuilder builder15 = new StringBuilder();
                for (int i = 1; i <= NumberOfCams(); i++) {
                    builder15.append("\n"
                            
                            + "myChart_Cam" + i + ".setOption({\n"
                            + " markArea: {\n"
                            + "        symbolSize: config.Symbol_Size,\n"
                            + "    }"
                            + "});\n"
                    );
                }                 
                
                
                
                String h2="function opacity01() {\n"
                        +builder3.toString()
                        + "\n}\n";
                
                String hShaft = "function shaft01() {\n"
                        +builder4.toString()
                        + "\n}\n";
                
                 String objColorChart = "function chartColor01() {\n"
                        +builder5.toString()
                        + "\n}\n";
                 
                 String configGrid = "function gridShow() {\n"
                        +builder6.toString()
                        + "}\n";   
                 
                 String configTheme = "function themes01() {\n"
                        +builder7.toString()
                        + "\n}\n";  
                 
                 String configSmooth = "function smooth01() {\n"
                        +builder8.toString()
                        + "\n}\n";                  
                
                 String configAxis = "function axis01() {\n"
                        +builder9.toString()
                        + "\n}\n";                 
                 
                 String confiTitle = "function title01() {\n"
                        +builder10.toString()
                        + "\n}\n";  
                 
                 String confiLegend = "function legend01() {\n"
                        +builder11.toString()
                        + "\n}\n";                  
                 
                 String confiToolbox = "function toolbox01() {\n"
                        +builder12.toString()
                        + "\n}\n";                 
                 
                String confiOpacity01 = "function opacity02() {\n"
                        +builder13.toString()
                        + "\n}\n"; 
                
                String confiSymbolSize = "function symbolSize01() {\n"
                        +builder14.toString()
                        + "\n}\n";
                
                String markareaMotionDwell = "function motiondwell() {\n"
                        + ""
                        + "\n}\n";
        
        h1 = 
                "//<script>\n"
                + "var config = {\n"
                + "Chart_Labels: showLabels,\n"
                + "distance: 20,\n"
                + "ShafText_Opacity: chart_opacity,\n"
                //+ "ShafText_Opacity: true,\n"
                + "ShafText_Opacity2: chart_opacity,\n"
                + "//ShafText_Opacity: true,\n"
                + "Shaft_Area: true,\n"
                + "Grid: true,\n"
                + "Theme: CamsDiag_theme,\n"
                + "Smooth: true,\n"
                + "Axis: true,\n"
                + "Title: false,\n"
                + "Legend: true,\n"
                + "Toolbox: true,\n"
                + "Symbol_Size: symbolSize,\n"
                + "Motion_Area: true\n"
                + "};\n"
                + "\n"
                + ""
                +h2
                +hShaft
                +objColorChart
                +configGrid
                +configTheme
                +configSmooth
                +configAxis
                +confiTitle
                +confiLegend
                +confiToolbox
                +confiOpacity01
                +confiSymbolSize
                + "function update() {\n"
                +builder2.toString()
                + "}\n"
                + ""
                + ""
                + ""
                + "var obj = {\n"
                + "     Username: '"+UserInfo.Get_UserName().toLowerCase()+"' ,\n"
                + "     'Computer Name': '"+UserInfo.Get_ComputerName()+"' ,\n"
                + "	'Date': dateCams,\n"
                + "	'CAM Job Name ': AsmName,\n"
                + "	'Number of Cams ': CamsDiag_NofCams,	\n"
                + "	'Show Labels ': true, \n"
                + "      Chart_Color: bic_color, \n"
                //+ "     'Opacity': chart_opacity, \n"
                + "     'Show Shaft Area': true, \n"
                + "     //'Chart Theme' : ['string_1', 'string_2', 'string_3']\n"
                + "};\n"
                + "\n"
                + "var gui = new dat.GUI();\n"
                + "\n"
                + "//gui.open();\n"
                + "var MainInfo = gui.addFolder('Cams Diag - Main Info');\n"
                + "MainInfo.add(obj, \"Username\"); \n"
                + "MainInfo.add(obj, \"Computer Name\");    \n"
                + "MainInfo.add(obj, \"Date\");  \n"
                + "MainInfo.add(obj, \"CAM Job Name \"); \n"
                + "MainInfo.add(obj, \"Number of Cams \"); \n"
                //+ "f2.add(obj, \"Labels\");\n"
                + "\n"
                + "var Actions = gui.addFolder('Echarts Options')\n"
                + "//Actions.add(obj, \"Chart Theme\");\n"
                + "//Actions.add(obj, \"Show Labels \");\n"
                + "Actions.add(config, \"Chart_Labels\").onChange(update);\n"
                + "Actions.addColor(obj, \"Chart_Color\").onChange(chartColor01);\n"
                //+ "Actions.add(config, \"ShafText_Opacity\").onChange(opacity01);\n"
                + "Actions.add(config, \"ShafText_Opacity\",0,1).onChange(opacity01, opacity02);\n"
                + "//Actions.add(config, \"ShafText_Opacity2\",0,1).onChange(opacity02);\n"
                + "Actions.add(config, \"Shaft_Area\").onChange(shaft01);\n"
                + "Actions.add(config, \"Grid\").onChange(gridShow);\n"
                + "//Actions.add(config, \"Theme\", ['dark', 'essos', "
                + "'infographic', "
                + "'macarons', "
                + "'MnIT', 'roma', "
                + "'shine', 'vintage', 'walden', 'westeros']).onChange(themes01);\n"
                + "//Actions.add(config, \"Smooth\").onChange(smooth01);\n"
                 + "Actions.add(config, \"Axis\").onChange(axis01);\n"
                + "Actions.add(config, \"Title\").onChange(title01);\n"
                + "Actions.add(config, \"Legend\").onChange(legend01);\n"
                + "Actions.add(config, \"Toolbox\").onChange(toolbox01);\n"
                 + "Actions.add(config, \"Symbol_Size\",0,60).onChange(symbolSize01);\n"
                + "Actions.add(config, \"Mark_Area\").onChange(motiondwell);\n"
                + "\n"
                + "//</script>\n";
        

        
        return h1;
    }
    
}
