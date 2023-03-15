/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Echarts;

import static main.CamReqs.MainInfo.NumberOfCams;
import static main.Echarts.JS_MachineMotionText.JS_MotionShaDiamEqualtoZero;
import static main.MnIT_Main.CheckMachineMotion;
import static main.MnIT_Main.CheckMachineMotionCam;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class Echarts_SetOptions {

    public static String CamChartSetOptions(Integer t) {
        String h1 = "";
        h1 = CamChart_Variables(t)
                + "////////////////////////////////////////////////////\n"
                + "//Start Of eChart" + t + "\n"
                + "////////////////////////////////////////////////////\n"
                + "var option_cam" + t + " = {\n"
                //+ CamChart_BackGroundColor()
                + CamChart_Graphic(t)
                + CamChart_Toolbox(t)
                + CamChart_Title(t)
                + CamChart_TextStyle()
                + CamChart_Legend(t)
                + CamChart_Tooltip(t)
                + CamChart_xAxis(t)
                + CamChart_yAxis(t)
                + CamChart_Grid()
                + CamChart_dataZoom(t)
                + "calculable: true,\n"
                //No Sense for One Charts VisualMap
                //+ CamChart_VisualMap()
                + CamChart_Series(t)
                + "};\n"
                + "////////////////////////////////////////////////////\n"
                + "//End Of eChart" + t + "\n"
                + "////////////////////////////////////////////////////\n";
        return h1;
    }

    public static String CamChart_Variables(Integer t) {
        String h1 = "";
        h1 = "\n"
                + "/*Cam #" + t + "*/\n"
                //+ "var showLabels = false;\n"
                //+ "var symbolSize = 20;\n "
                + "var myChart_Cam" + t + " = echarts.init(document.getElementById('maincam" + t + "'), CamsDiag_theme);\n"
                + "var shaftdiam_cam" + t + " = cam" + t + "diameter;\n"
                + "var shaftdiam_cam" + t + "yAxis = cam" + t + "diameter/2;\n"
                + "var shaftdiam_label_cam" + t + " = \"Shaft Diameter : \" + shaftdiam_cam" + t + " + \" mm\";\n"
                + "var AxisMax_cam" + t + " = Math.max.apply(null, cam" + t + "y) + 30;\n"
                + "var AxisMax" + t + " = Math.max.apply(null, cam" + t + "y);\n"
                + "var AxisMin" + t + " = Math.min.apply(null, cam" + t + "y);\n"
                + "var AxisMin_cam" + t + " = 0;\n"
                + "var Recc" + t + " = Math.max.apply(null, cam" + t + "y) - Math.min.apply(null, cam" + t + "y);\n"
                + "var Recc" + t + " = Recc" + t + ".toFixed(2);\n"
                + "//////////////////////////////////////////////\n"
                + "var points" + t + " = [];\n"
                + "//////////////////////////////////////////////\n"
                + "var mycanvas" + t + " = $(\"#maincam" + t + "\").find(\"canvas\")[0];\n"
                + "//////////////////////////////////////////////\n"
                + "var data_cam" + t + " = [];\n"
                + "for (i = 0; i < cam" + t + "x.length; i++)\n"
                + "{ data_cam" + t + ".push([cam" + t + "x[i], cam" + t + "y[i]]);}\n"
                + "var datacam" + t + " = data_cam" + t + ";\n"
                + "//////////////////////////////////////////////\n"
                + "var data_camY" + t + " = [];\n"
                + "for (i = 0; i < cam" + t + "y.length; i++)\n"
                + "{ data_camY" + t + ".push([cam" + t + "y[i], cam" + t + "y[i]]);}\n"
                + "var datacamY" + t + " = data_camY" + t + ";\n"
                + "//////////////////////////////////////////////\n"
                //+ "//var max_of_Cam" + t + "R = Math.max.apply(Math, data_cam" + t + ");\n"
                + "var crc" + t + "x = 50;\n"
                + "var crc" + t + "y = 550;\n"
                + "//var crc" + t + "x = 1100;\n"
                + "//var crc" + t + "y = 60;\n"
                + "var max" + t + "element = Math.max.apply(Math, cam" + t + "y);\n"
                + "var min" + t + "element = Math.min.apply(Math, cam" + t + "y);\n"
                + "var Degmax" + t + "element = Math.max.apply(Math, cam" + t + "x);\n"
                + "var Degmin" + t + "element = Math.min.apply(Math, cam" + t + "x);\n"
                + "var crc" + t + "_in = cam" + t + "diameter/3;\n"
                + "var crc" + t + "_out = max" + t + "element/3;\n"
                + "var arrow_cw = '\\u21BB'+' CW';\n"
                + "var arrow_ccw = '\\u21BA'+' CCW';\n"
                + "var diameterSymbol = '\\u2300';\n"
                + "var MachineMotion='Machine Main Motion';\n"
                + "var MachineDwell='Machine Dwell';\n"
                + "var maxMotion=8;\n"
                + "var MaxMotionMachine=110;\n"
                + "var MaxValueYaxis=120;\n"
                + "var LabelChart" + t + "x = cam" + t + "x.length; \n"
                + "var LabelChart" + t + "y = cam" + t + "y.length; \n"
                + "const adjustedLabel" + t + "x = cam" + t + "x.map((_, i) => LabelChart" + t + "x[i % cam" + t + "x.length])\n"
                + "const adjustedLabel" + t + "y = cam" + t + "y.map((_, i) => LabelChart" + t + "y[i % cam" + t + "y.length])\n"
                + "\n"
                //+ "console.log(adjustedLabel" + t + "x)\n"
                //+ "console.log(adjustedLabel" + t + "y)\n"
                //+ "console.log(LabelChart" + t + "x);\n"
                + CamChart_WaterMark(t)
                + CheckMachineMotion() //+ "//////////////////////////////////////////////\n"
                + JS_MotionShaDiamEqualtoZero(t)
                ;
        return h1;
    }

    public static String CamChart_Title(Integer t) {
        String h1 = "";
        h1 = "title: {\n"
                + "    text: cam" + t + "label + \" - C" + t + "\\n\" + cam" + t + "descl,\n"
                + "    padding: 10,\n"
                + "    show: true,\n"
                + "    textStyle: {\n"
                + "         color: text_color,\n"
                + "         fontStyle: 'normal',\n"
                + "         fontWeight: 'bold',\n"
                + "         fontSize: 14,\n"
                + "         align: 'center'\n"
                + "    },\n"
                + "    subtext: \"Eccentric  : \" + Recc" + t + " + \" mm\""
                + "+\"\\nRmax : \"+max" + t + "element+\" mm\\nRmin : \"+min" + t + "element+\" mm\",\n"
                + "    subtextStyle: {\n"
                + "       padding: 15,\n"
                + "       color: text_color,\n"
                + "       fontSize: 13\n"
                + "   },\n"
                + "itemGap: 5\n"
                + "},\n";
        return h1;
    }

    public static String CamChart_Legend(Integer t) {
        String h1 = "";
        h1 = "legend: {\n"
                + "   type: \"scroll\",\n"
                + "   show: true,\n"
                + "   data: [cam" + t + "descl],\n"
                + "   lineStyle: {\n"
                + "     shadowOffsetY: 1.5,\n"
                + "     color: text_color\n"
                + "     },\n"
                + "   textStyle: {\n"
                + "   fontStyle: \"normal\",\n"
                + "   borderDashOffset: 2,\n"
                + "   textShadowBlur: 1\n"
                + "   },\n"
                + "   icon: \"roundRect\"\n"
                + "},\n";
        return h1;
    }

    public static String CamChart_Toolbox(Integer t) {
        String h1 = "";
        h1 = "toolbox: {\n"
                + "   itemSize: 20,\n"
                + "   right: 50,\n"
                + "   show: true,\n"
                + "   feature: {\n"
                + "   mark: {show: true},\n"
                + "   dataView: {show: true,\n"
                + "   readOnly: false,\n"
                + "   title: 'Data View',\n"
                + "   lang: [cam" + t + "label + \" Data : \", 'Close', 'Refresh Data'],\n"
                + "   backgroundColor: 'rgb(252, 184, 49)',\n"
                + "   textColor: '#222',\n"
                + "   buttonColor: '#c23531'           \n"
                + "   },\n"
                + "   magicType: {\n"
                + "     show: true, \n"
                + "     type: ['line', 'bar'],\n"
                + "     barMaxWidth:'20%'\n"
                + "     },\n"
                + "   saveAsImage: {\n"
                + "     backgroundColor: '#FFF',\n"
                + "     excludeComponents: ['toolbox', 'dataZoom', 'legend', 'graphic', 'grid', 'axis'],\n"
                + "     show: true,\n"
                + "     type: imgexport\n"
                + "     },\n"
                + "   dataZoom: {show: true},\n"
                + "   restore: {show: true}\n"
                + "   }\n"
                + "},\n";

        return h1;
    }

    public static String CamChart_Tooltip(Integer t) {
        String h1 = "";
        h1 = "tooltip: {\n"
                + "   trigger: 'axis',\n"
                + "   confine: true,\n"
                + "   //snap: true,\n"
                //    + "formatter: function (params) {\n"
                //    + "return 'R : ' + params.data[0].toFixed(2) + '<br>Deg : ' + params.data[1].toFixed(2);\n"
                //    + "},\n"
                //    + "formatter: '{b0}: {c0}<br />{b1}: {c1}<br />{d} {d0}',\n"
                //    + "function (params" + t + ") {\n"
                //    + "param" + t + " = params" + t + "[0];\n"
                //    + "var val" + t + " = '<li style=\"list-style:none\">' + params" + t + ".marker + \" \" +\n"
                //    + "'&nbsp;&nbsp;' + 'R(mm) = ' + params" + t + ".value[1] + ' mm, Deg = ' + params" + t + ".value[0] + ' °' + '</li>';\n"
                //    + "return val" + t + ";\n"
                //    + "},\n"                
                + "   formatter: function (params) {\n"
                + "   params = params[0];\n"
                + "   var val = '<li style=\"list-style:none\">' + params.marker + \" \" +\n"
                + "   '&nbsp;&nbsp;' + 'R(mm) = ' + params.value[1] + ' mm, Deg = ' + params.value[0] + ' °' + '</li>';\n"
                + "   return val;\n"
                + "},\n"
                + "\n"
                + "   axisPointer: {\n"
                + "   type: 'cross',\n"
                + "   axis: 'y',\n"
                + "   axis: 'x',\n"
                + "   lineStyle: {\n"
                + "    color: text_color,\n"
                + "    shadowBlur: 4,\n"
                + "    shadowColor: '#000',\n"
                + "    shadowOffsetX: 3,\n"
                + "    shadowOffsetY: 3\n"
                + "}\n"
                + "    },\n"
                + "    position: 'center',\n"
                + "    label: {\n"
                + "    backgroundColor: '#6a7985'\n"
                + "\n"
                + "}\n"
                + "},\n";
        return h1;
    }

    public static String CamChart_Dataset_ecStat_regression(Integer t) {
        String h1 = "";
        h1 = "dataset: [{\n"
                + "   source: data_cam" + t + "\n"
                + "    }, {\n"
                + "    transform: {\n"
                + "    type: 'ecStat:regression',\n"
                + "config: {\n"
                + "   //config: { method: 'polynomial', order: 3 }"
                + "   method: 'exponential',\n"
                + "   // 'end' by default\n"
                + "   // formulaOn: 'start'\n"
                + "   }\n"
                + "}\n"
                + "}],\n";
        return h1;
    }
    
    public static String CamChart_Grid() {
        String h1 = "";
        h1 = "grid: {\n"
                + " left: '5%',\n"
                + " right: '5%',\n"
                + " bottom: '10%',\n"
                + " top: '20%',\n"
                + " containLabel: true,\n"
                + " show: true\n"
                + "},\n";
        return h1;
    }

    public static String CamChart_TextStyle() {
        String h1 = "";
        h1 = "textStyle: {\n"
                + "    fontFamily: 'sans-serif'\n"
                + "  },\n";
        return h1;
    }

    public static String CamChart_dataZoom(Integer t) {
        String h1 = "";
        h1 = "dataZoom: [\n"
                + "/*\n"
                + "{\n"
                + "   type: 'inside',\n"
                + "   realtime: true,\n"
                + "   xAxisIndex: [0],\n"
                + "   start: 0,\n"
                + "   end: 360\n"
                + "},\n"
                //+ "/*\n"
                
                + "{\n"
                + "   type: 'inside',\n"
                + "   realtime: true,\n"
                + "   yAxisIndex: [0],\n"
                + "   start: 0,\n"
                + "    end: 120\n"
                + "        },\n"
                + "*/\n"
                //+ "*/\n"
                + "    {\n"
                + "      show: true,\n"
                + "      type: 'slider',\n"
                + "      //top: '90%',\n"
                + "       //left: '97%',\n"
                + "       yAxisIndex: [0],\n"
                + "      //startValue: shaftdiam_cam" + t + ",\n"
                + "      startValue: AxisMin" + t + "-5,\n"
                //AxisMin" + t + "
                + "      endValue: AxisMax" + t + "+5\n"
                + "    },\n"
                /*
                + "   {\n"
                + "     show: true,\n"
                + "     realtime: true,\n"
                + "     yAxisIndex: [0],\n"
                + "     startValue: shaftdiam_cam" + t + ",\n"
                + "     end: AxisMax" + t + "+5\n"
                + "    },\n"
                */
                + "/*\n"
                + "{\n"
                + "show: true,\n"
                + "type: 'slider',\n"
                + "},\n"
                + "*/\n"
                + "    ],\n";
        return h1;
    }
    
    
    public static String CamChart_VisualMap() {
        String h1 = "";
        h1 = "visualMap: "
                + "[\n"
                + "        {\n"
                + "             show: true,\n"
                + "            type: 'continuous',\n"
                + "            name: \"Deg \",\n"
                + "            //backgroundColor: \"#eee\",\n"
                + "            left: 'center',\n"
                + "            //left: 'center',\n"
                + "            orient: 'horizontal',\n"
                + "            //orient: 'vertical',\n"
                + "            itemWidth: 20,\n"
                + "            itemHeight: 600,\n"
                + "            bottom: 15,\n"
                + "            calculable: true,\n"
                + "   padding: [\n"
                + "        10,\n"
                + "        30,\n"
                + "        0,\n"
                + "        40\n"
                + "    ],            \n"
                + "            dimension: 0,\n"
                + "            calculable: true,\n"
                + "            splitNumber: 10,\n"
                + "            text: [\n"
                + "                \"Deg Max " + "\u00B0" + "\",\n"
                + "                \"Deg Min " + "\u00B0" + "\",\n"
                + "            ],\n"
                + "            min: 0,\n"
                + "            max: 360,\n"
                + "            //precision: 2,\n"
                + "            inRange: {\n"
                + "                opacity: [1, 1], // Using opacity when label color specified\n"
                + "                label: \"Warning\",\n"
                + "            },\n"
                + "            controller: {\n"
                + "                inRange: {\n"
                + "                    color: [bic_color,'#ccc']\n"
                + "                },\n"
                + "                outOfRange: {\n"
                + "                    color: '#888'\n"
                + "                }\n"
                + "            },\n"
                + "            outOfRange: {\n"
                + "                opacity: [0.2, 0.2] // Using opacity when label color specified\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "/////////////////////\n";
        return h1;
    }

    public static String CamChart_xAxis(Integer t) {
        String h1 = "";

        h1 = "xAxis: {\n"
                + "  type: 'value',\n"
                + "  id: 'cam" + t + "X',\n"
                + "  scale: false,\n"
                + "  data: datacam" + t + ",\n"
                + "  boundaryGap: false,\n"
                + "  splitNumber: 10,\n"
                + "  min: 0,\n"
                + "  max: 360,\n"
                + "  interval: 90,\n"
                + "  axisTick: {\n"
                + "     inside: true,\n"
                + "     show: true,\n"
                + "     alignWithLabel: true\n"
                + "  },\n"
                + "  axisLine: {\n"
                + "     symbol: ['none', 'arrow'],\n"
                + "     lineStyle: {\n"
                + "     color: 'black'\n"
                + "     },\n"
                + "  symbolOffset: 90,\n"
                + "  show: true\n"
                + "},\n"
                + "  splitLine: {\n"
                + "   show: true,\n"
                + "   lineStyle: {\n"
                + "    type: 'solid',\n"
                + "    color: '#ccc'\n"
                + " }\n"
                + "},\n"
                + " minorTick: {\n"
                + "   show: true\n"
                + "},\n"
                + " minorSplitLine: {\n"
                + "   show: true\n"
                + "},\n"
                + "  axisLabel: {\n"
                + "   formatter: \"{value} °\"\n"
                + "}\n"
                + "},\n";

        return h1;
    }

    public static String CamChart_yAxis(Integer t) {
        String h1 = "";
        
        StringBuilder builder1 = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder1.append("shaftdiam_cam" + i + "/2"
            );
        }     
        
        h1 = "yAxis: {\n"
                + " //show: false,\n"
                + "  type: 'value',\n"
                + "  id: 'cam" + t + "Y',\n"
                + "  scale: false,\n"
                + "  min: shaftdiam_cam" + t + "yAxis,\n"
                + "  max: AxisMax_cam" + t + ",\n"
                + "  interval: 30,\n"
                + "  boundaryGap: false,\n"
                + "  data: datacam1,\n"
                + "  splitNumber: 10,\n"
                + "  axisTick: {\n"
                + "   inside: true,\n"
                + "   show: true,\n"
                + "   alignWithLabel: true\n"
                + "},\n"
                + "  axisLine: {\n"
                + "    symbol: ['none', 'arrow'],\n"
                + "      lineStyle: {\n"
                + "           color: 'black'\n"
                + "      },\n"
                + "  symbolOffset: 10,\n"
                + "    show: false\n"
                + " },\n"
                + "  splitLine: {\n"
                + "   show: true,\n"
                + "   lineStyle: {\n"
                + "       type: 'solid',\n"
                + "       color: '#ccc'\n"
                + " }\n"
                + "},\n"
                + " minorTick: {\n"
                + " show: true\n"
                + "},\n"
                + "  minorSplitLine: {\n"
                + "  show: true\n"
                + "},\n"
                + "  axisLabel: {\n"
                + "  formatter: \"{value} mm\",\n"
                + "     show: false\n"
                + "  }\n"
                + "},\n";
        return h1;
    }

    public static String CamChart_Series_Scatter(Integer t) {
        String h1 = "";
        h1 = "    series: [{\n"
                + "        name: 'scatter',\n"
                + "        type: 'scatter'\n"
                + "    }, {\n"
                + "        name: 'line',\n"
                + "        type: 'line',\n"
                + "        datasetIndex: 1,\n"
                + "        symbolSize: 0.1,\n"
                + "        symbol: 'circle',\n"
                + "        label: { show: true, fontSize: 16 },\n"
                + "        labelLayout: { dx: -50 },\n"
                + "        encode: { label: 2, tooltip: 1 }\n"
                + "    }]\n";
        return h1;
    }
    
    public static String CamChart_Series_Polar(Integer t) {
        String h1 = "";
        h1 = "    series: [{\n"
                + "        coordinateSystem: 'polar',\n"
                + "        name: 'line',\n"
                + "        type: 'line',\n"
                + "        data: data_cam" + t + "\n"
                + "    }]\n";
        return h1;
    }    
    
    public static String CamChart_Polar_AngleAxis() {
        String h1 = "";
        h1 = "    angleAxis: {\n"
                + "        type: 'value',\n"
                + "        startAngle: 0\n"
                + "    },\n";
        return h1;
    }

    public static String CamChart_Polar_Options() {
        String h1 = "";
        h1 = "polar: {},\n"
                + "radiusAxis: {},\n";
        return h1;
    }  
    
    public static String CamChart_WaterMark(Integer t) {
        String h1 = "";
        h1 = "var waterMarkText = cam" + t + "label;\n"
                + "\n"
                + "var canvas" + t + "wm = document.createElement('canvas');\n"
                + "var ctx = canvas" + t + "wm.getContext('2d');\n"
                + "canvas" + t + "wm.width = canvas" + t + "wm.height = 150;\n"
                + "ctx.textAlign = 'center';\n"
                + "ctx.textBaseline = 'middle';\n"
                + "ctx.globalAlpha = 0.08;\n"
                + "ctx.font = '20px Tahoma';\n"
                + "ctx.translate(50, 50);\n"
                + "ctx.rotate(-Math.PI / 4);\n"
                + "ctx.fillText(waterMarkText, 0, 0);\n";
        return h1;
    }
    
    public static String CamChart_BackGroundColor(Integer t) {
        String h1 = "";
        h1 = "    backgroundColor: {\n"
                + "        type: 'pattern',\n"
                + "        image: canvas" + t + "wm,\n"
                + "        repeat: 'repeat'\n"
                + "    },\n";
        return h1;
    }   
    
    public static String CamChart_Series(Integer t) {
        String h1 = "";
        h1 = "    series: [{\n"
                + "            id: 'cam" + t + "',\n"
                + "            data: data_cam" + t + ",\n"
                + "            name: cam" + t + "descl,\n"
                + "            type: 'line',\n"
                + "            stack: 'all',\n"
                + "            symbolSize: symbolSize,\n"
                + "            smooth: false,\n"
                + "            opacity: chart_opacity,\n"
                + CamChart_Series_MarkLine(t)
                + "\n"
                + CamChart_Series_MarkArea(t)
                + "\n"
                + CheckMachineMotionCam(t)
                + "            emphasis: {\n"
                + "                focus: 'series',\n"
                + "                lineStyle: {\n"
                + "                    width: linestulemfasis + 3,\n"
                + "                    opacity: chart_opacity\n"
                + "                }\n"
                + "            },\n"
                + "            label: {\n"
                + "                //show: showLabels,\n"
                + "                 show: false\n"
                + "                //show: config.Labels\n"
                + "            },\n"
                + "            lineStyle: {\n"
                + "                width: linestulemfasis,\n"
                + "                shadowColor: 'black',\n"
                + "                oppacity: 0.5,\n"
                + "                shadowBlur: 5,\n"
                + "                shadowOffsetY: 2,\n"
                + "                color: shaftcolor_emp\n"
                + "            },\n"
                + "            z: 90,\n"
                + "            areaStyle: {\n"
                + "                color: bic_color,\n"
                + "                origin: \"start\",\n"
                + "                offset: 0,\n"
                + "                opacity: 0.75\n"
                + "            }\n"
                + "        }]\n";
        return h1;
    }

    public static String CamChartDatGUI_ShaftArea(Integer t) {
        String h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + "series: {\n"
                    + "\n"
                    + CamChartDatGUI_MarkArea(i)
                    + CamChartDatGUI_MarkLine(i)
                    + "},"
                    + "\n"
                    + "});\n"
            );
        }

        h1 = "function shaft01() {\n"
                + builder.toString()
                + "}\n";

        return h1;
    }

    public static String CamChartDatGUI_MarkLine(Integer t) {
        String h1 = "";
        h1 = "markLine: {\n"
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
                + "   formatter: \"Shaft Diameter \"+diameterSymbol+\" :\\n\"+shaftdiam_cam" + t + " + ' mm',\n"
                + "   fontSize: '15'\n"
                + "   },\n"
                + "  yAxis: shaftdiam_cam" + t + "\n"
                + "}]},\n";
        return h1;
    }

    public static String CamChartDatGUI_MarkArea(Integer t) {
        String h1 = "";
        h1 = "markArea: {\n"
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
                + "   name: shaftdiam_label_cam" + t + ",\n"
                + "    yAxis: 0\n"
                + "     }, {\n"
                + "       yAxis: 0\n"
                + "      }]\n"
                + "  ]\n"
                + "},\n";

        return h1;
    }

    public static String CamChart_Series_MarkLine(Integer t) {
        String h1 = "";
        h1 = "markLine: {\n"
                + "   symbol: \"none\",\n"
                + "   data: [\n"
                + "   {\n"
                + "      silent: false,\n"
                + "      lineStyle: {\n"
                + "      type: \"dashed\",\n"
                + "      // color: \"#FA3934\",\n"
                + "      width: linestulemfasis - 3,\n"
                + "      opacity: chart_opacity+0.3\n"
                + "   },\n"
                + "     label: {\n"
                + "      show: false,\n"
                + "     position: 'middle',\n"
                + "     formatter: \"Shaft Diameter \"+diameterSymbol+\" :\\n\"+shaftdiam_cam" + t + " + ' mm',\n"
                + "     fontSize: '15'\n"
                + "     },\n"
                + "     yAxis: shaftdiam_cam" + t + "\n"
                + "    }]},\n";
        return h1;
    }

    public static String CamChart_Series_MarkArea(Integer t) {
        String h1 = "";
        h1 = "markArea: {\n"
                + "animation: true,\n"
                + "animationEasing: \"quarticIn\",\n"
                + "z: -1,\n"
                + "\n"
                + "itemStyle: {\n"
                + "           normal: {\n"
                + "           color: bic_color,\n"
                + "           opacity: chart_opacity\n"
                + "           },\n"
                + "emphasis: {\n"
                + "           color: shaftcolor_emp,\n"
                + "           opacity: chart_opacity\n"
                + "           }\n"
                + "          },\n"
                + "label: {\n"
                + "        show: false,\n"
                + "        position: 'top',\n"
                + "        color: \"grey\",\n"
                + "        fontSize: 12\n"
                + "        },\n"
                + "labelLayout: {\n"
                + "              hideOverlap: true\n"
                + "               },\n"
                + "data: [\n"
                + "[{\n"
                + "      name: shaftdiam_label_cam" + t + ",\n"
                + "      yAxis: shaftdiam_cam" + t + "yAxis\n"
                + "}, {\n"
                + "      yAxis: shaftdiam_cam" + t + "\n"
                + "    }]\n"
                + "]\n"
                + "},\n";
        return h1;
    }

    public static String CamChart_Graphic01(Integer t) {
        String h1 = "";

        h1 = "graphic: [\n"
                + "{\n"
                + "\n"
                + "//invisible: true,\n"
                + ""
                + "elements: [\n"
                + "{\n"
                + "id: 'CamCircleOut" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    cursor: 'hand',\n"
                + "    draggable: true,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "    cx: crc" + t + "x,\n"
                + "    cy: crc" + t + "y,\n"
                + "    r:  crc" + t + "_out,\n"
                + "    //r: 10,\n"
                + "},\n"
                + "style: {\n"
                + "//fill: 'rgba(0, 140, 250, 0.5)',\n"
                + "fill: 'white',\n"
                + "opacity: chart_opacity, \n"
                + "//stroke: 'rgba(0, 50, 150, 0.5)',\n"
                + "stroke: 'black',\n"
                + "lineWidth: 2,\n"
                + "},\n"
                + ""
                + "textContent: {\n"
                + "    z: 100,\n"
                + "    x: crc" + t + "x+30,\n"
                + "    y: crc" + t + "y,\n"
                + " style: {\n"
                + "    text: arrow_cw,\n"
                + "    //text: ChangeArrow(),\n"
                + "    //text:  function (params) {\n"
                + "//return arrow_ccw;\n"
                + "//},\n"
                + "    fill: 'black',\n"
                + "    opacity: chart_opacity,\n"
                + "    font: 'bold 30px sans-serif'\n"
                + "}\n"
                + "},\n"
                + "//textConfig: {\n"
                + "//position: 'center'\n"
                + "//}\n"
                + ""
                + "},\n"
                + ""
                + ""
                + "\n"
                + "///*\n"
                + "{\n"
                + "id: 'CamCircleIn" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "     cx: crc" + t + "x,\n"
                + "      cy: crc" + t + "y,\n"
                + "     r: crc" + t + "_in,\n"
                + "         //r: max" + t + "element, \n"
                + "      },\n"
                + "      style: {\n"
                + "        //fill: 'rgba(0, 140, 150, 0.5)',\n"
                + "         fill: 'white',\n"
                + "         opacity: chart_opacity, \n"
                + "        //stroke: 'rgba(0, 50, 150, 0.5)',\n"
                + "         stroke: 'black',\n"
                + "        lineWidth: 2,\n"
                + "      }\n"
                + "},\n"
                + "//*/\n"
                + "/*\n"
                + "{\n"
                + "id: 'CamCam" + t + "',\n"
                + "   type: 'bezierCurve',\n"
                + "   z: 100,\n"
                + "$action: 'merge',\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "  x1: 10,\n"
                + "   y1: 10,\n"
                + "   x2: 100,\n"
                + "   y2: 10,\n"
                + "  cpx1: 60,\n"
                + "   cpy1: 100"
                + "      },\n"
                + "  style: {\n"
                + "  //fill: 'rgba(0, 140, 150, 0.5)',\n"
                + "  fill: 'blue',\n"
                + "  opacity: chart_opacity, \n"
                + "  stroke: 'rgba(0, 50, 150, 0.5)',\n"
                + "  lineWidth: 2,\n"
                + "}\n"
                + "},\n"
                + "*/\n"
                + ""
                + "//Label Cam\n"
                + "{\n"
                + "   type: 'group',\n"
                + "   rotation: Math.PI / 4,\n"
                + "   bounding: 'raw',\n"
                + "   right: 30,\n"
                + "   bottom: 30,\n"
                + "   z: 100,\n"
                //+ "$action: 'remove',\n"
                + "   //invisible: true,\n"
                + "   children: [\n"
                + "   {\n"
                + "      type: 'rect',\n"
                + "      left: 'center',\n"
                + "      top: 'center',\n"
                + "   $action: 'merge',\n"
                + "   z: 100,\n"
                + "   shape: {\n"
                + "   width: 400,\n"
                + "   height: 30\n"
                + "   },\n"
                + "   style: {\n"
                + "   fill: 'rgba(0,0,0,0.3)'\n"
                + "   }\n"
                + "   },\n"
                + "   {\n"
                + "       type: 'text',\n"
                + "       left: 'center',\n"
                + "       top: 'center',\n"
                + "       z: 100,\n"
                + "       style: {\n"
                + "       fill: '#fff',\n"
                + "       text: 'C" + t + "',\n"
                + "       font: 'bold 15px sans-serif'\n"
                + "              }\n"
                + "    }\n"
                + "          ]\n"
                + "},\n"
                + ""
                + "],\n"
                + "\n"
                //                + "{\n"
                //                + "            type: 'group',\n"
                //                + "            rotation: Math.PI / 4,\n"
                //                + "            bounding: 'raw',\n"
                //                + "            right: 100,\n"
                //                + "            bottom: 100,\n"
                //                + "            z: 100,\n"
                //                + "            children: [\n"
                //                + "                {\n"
                //                + "                    type: 'rect',\n"
                //                + "                    left: 'center',\n"
                //                + "                    top: 'center',\n"
                //                + "                    z: 100,\n"
                //                + "                    shape: {\n"
                //                + "                        width: 400,\n"
                //                + "                        height: 20\n"
                //                + "                    },\n"
                //                + "                    style: {\n"
                //                + "                        fill: 'rgba(0,0,0,0.3)'\n"
                //                + "                    }\n"
                //                + "                },\n"
                //                + "                {\n"
                //                + "                    type: 'text',\n"
                //                + "                    left: 'center',\n"
                //                + "                    top: 'center',\n"
                //                + "                    z: 100,\n"
                //                + "                    style: {\n"
                //                + "                        fill: '#fff',\n"
                //                + "                        text: 'C" + t + "',\n"
                //                + "                        font: 'bold 12px sans-serif'\n"
                //                + "                    }\n"
                //                + "                }\n"
                //                + "            ],}\n"
                + ""
                + "\n"
                + "        },],\n";

        String labelCam = "";
        labelCam = "\n//Label Cam\n"
                + "{\n"
                + "   type: 'group',\n"
                + "   rotation: Math.PI / 4,\n"
                + "   bounding: 'raw',\n"
                + "   right: 30,\n"
                + "   bottom: 30,\n"
                + "   z: 100,\n"
                + "   //$action: 'merge',\n"
                + "   //invisible: true,\n"
                + "   children: [\n"
                + "   {\n"
                + "      type: 'rect',\n"
                + "      left: 'center',\n"
                + "      top: 'center',\n"
                + "   $action: 'merge',\n"
                + "   z: 100,\n"
                + "   shape: {\n"
                + "   width: 400,\n"
                + "   height: 30\n"
                + "   },\n"
                + "   style: {\n"
                + "   fill: 'rgba(0,0,0,0.3)'\n"
                + "   }\n"
                + "   },\n"
                + "   {\n"
                + "       type: 'text',\n"
                + "       left: 'center',\n"
                + "       top: 'center',\n"
                + "       z: 100,\n"
                + "       style: {\n"
                + "       fill: '#fff',\n"
                + "       text: 'C" + t + "',\n"
                + "       font: 'bold 15px sans-serif'\n"
                + "              }\n"
                + "    }\n"
                + "          ]\n"
                + "},\n";
        
String ShaftCircles="";
ShaftCircles = "children: [\n"
                + "//elements: [\n"
                + "{\n"
                + "   id: 'CamCircleOut" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "   cursor: 'hand',\n"
                + "   draggable: true,\n"
                + "        shape: {\n"
                + "          cx: crc" + t + "x,\n"
                + "          cy: crc" + t + "y,\n"
                + "          r: crc" + t + "_out,\n"
                + "        },\n"
                + "        style: {\n"
                + "         opacity: chart_opacity, \n"
                + "         //fill: 'rgba(0, 140, 250, 0.5)',\n"
                + "          fill: 'white',\n"
                + "         //stroke: 'rgba(0, 50, 150, 0.5)',\n"
                + "         stroke: 'black',\n"
                + "          lineWidth: 2,\n"
                + "        },\n"
                + "textContent: {\n"
                + "    z: 100,\n"
                + "    x: crc" + t + "x+30,\n"
                + "    y: crc" + t + "y,\n"
                + "style: {\n"
                + "    text: arrow_cw,\n"
                + "    fill: 'black',\n"
                + "    opacity: chart_opacity,\n"
                + "    font: 'bold 30px sans-serif'\n"
                + "}\n"
                + "},\n"
                + "},\n"
                + ""
                + "{\n"
                + "id: 'CamCircleIn" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "     cx: crc" + t + "x,\n"
                + "      cy: crc" + t + "y,\n"
                + "     r: crc" + t + "_in,\n"
                + "         //r: max1element, \n"
                + "      },\n"
                + "      style: {\n"
                + "        //fill: 'rgba(0, 140, 150, 0.5)',\n"
                + "         fill: 'white',\n"
                + "         opacity: chart_opacity, \n"
                + "        //stroke: 'rgba(0, 50, 150, 0.5)',\n"
                + "         stroke: 'black',\n"
                + "        lineWidth: 2,\n"
                + "      }\n"
                + "},\n"
                + ""
                + "\n"
                + "";
        
        
        String h2 = "";
        h2 = "  graphic: [{\n"
                + "//type: 'group',\n"
                + "id: 'GroupCam" + t + "',\n"

                + ""

                + "}],\n";

        String smallcircle = "\n{\n"
                + "id: 'CamCircleIn" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "     cx: crc" + t + "x,\n"
                + "      cy: crc" + t + "y,\n"
                + "     r: crc" + t + "_in,\n"
                + "      },\n"
                + "      style: {\n"
                + "         fill: 'white',\n"
                + "         opacity: chart_opacity, \n"
                + "         stroke: 'black',\n"
                + "        lineWidth: 2,\n"
                + "      }\n"
                + "},\n";
        
        String bigcircle = "{\n"
                + "id: 'CamCircleOut" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    cursor: 'hand',\n"
                + "    draggable: true,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "    cx: crc" + t + "x,\n"
                + "    cy: crc" + t + "y,\n"
                + "    r:  crc" + t + "_out,\n"
                + "    //r: 10,\n"
                + "},\n"
                + "style: {\n"
                + "fill: 'white',\n"
                + "opacity: chart_opacity, \n"
                + "stroke: 'black',\n"
                + "lineWidth: 2,\n"
                + "},\n"
                + "textContent: {\n"
                + "    z: 100,\n"
                + "    x: crc" + t + "x+30,\n"
                + "    y: crc" + t + "y,\n"
                + " style: {\n"
                + "    text: arrow_cw,\n"
                + "    fill: 'black',\n"
                + "    opacity: chart_opacity,\n"
                + "    font: 'bold 30px sans-serif'\n"
                + "}\n"
                + "},\n"
                + "//textConfig: {\n"
                + "//position: 'center'\n"
                + "//}\n"
                + "},\n";
        
        
        String graphic = "";

        graphic = "graphic: [\n"
                + "{\n"
                + "invisible: false,\n"
                + "elements: [\n"
                + labelCam
                + "\n"
                + smallcircle
                + "\n"
                + bigcircle
                +"\n"
                + "],\n"
                + "},],\n";
        
        
        return graphic;
    }

    /*Dat GUI Settings*/
    public static String CamChart_DatGUI(Integer t) {
        String h1 = "";
        h1 = CamChart_DatGUI_config()
                + CamChart_DatGUI_obj()
                + "/****************/\n"
                + CamChartDatGUI_Labels(t)
                + CamChartDatGUI_Title(t)
                + CamChartDatGUI_Legend(t)
                + CamChartDatGUI_Toolbox(t)
                + CamChartDatGUI_Grid(t)
                + CamChartDatGUI_Axis(t)
                + CamChartDatGUI_SymbolSize(t)
                + CamChartDatGUI_ChartColor(t)
                + CamChartDatGUI_Theme(t)
                + CamChartDatGUI_ShaftArea(t)
                + CamChartDatGUI_LineWidth(t)
                + CamChartDatGUI_Graphic(t)
                + CamChartDatGUI_WaterMark(t)
                + CamChartDatGUI_Smooth(t)
                + "var gui = new dat.GUI();\n"
                + "var MainInfo = gui.addFolder('Cams Diag - Main Info');\n"
                + "MainInfo.add(obj, \"Username\"); \n"
                + "MainInfo.add(obj, \"Computer Name\");    \n"
                + "MainInfo.add(obj, \"Date\");  \n"
                + "MainInfo.add(obj, \"CAM Job Name \"); \n"
                + "MainInfo.add(obj, \"Number of Cams \"); \n"
                + "/****************/\n"
                + "var Actions = gui.addFolder('Echarts Options')\n"
                + "Actions.add(config, \"Chart_Labels\").onChange(show_labels01);\n"
                + "Actions.add(config, \"Smooth\").onChange(smooth01);\n"
                + "Actions.add(config, \"LineWidth\",0,30).onChange(linewidth01);\n"
                + "Actions.addColor(obj, \"Chart_Color\").onChange(chartColor01);\n"
                + "Actions.add(config, \"Grid\").onChange(gridShow);\n"
                + "Actions.add(config, \"Axis\").onChange(axis01);\n"
                + "Actions.add(config, \"Title\").onChange(title01);\n"
                + "Actions.add(config, \"Legend\").onChange(legend01);\n"
                + "Actions.add(config, \"Toolbox\").onChange(toolbox01);\n"
                + "Actions.add(config, \"Symbol_Size\",0,60).onChange(symbolSize01);\n"
                + "Actions.add(config, \"Shaft_Area\").onChange(shaft01);\n"
                + "//Actions.add(config, \"ShafText_Opacity\",0,1).onChange(opacity02);\n"
                + "Actions.add(config, \"Graphics\").onChange(opacity03);\n"
                + "//Actions.add(config, \"Theme\", AvailThemes).onChange(themes01);\n"
                + "Actions.add(config, \"Watermark\").onChange(watermark01);\n";
        return h1;
    }

    public static String CamChart_DatGUI_config() {
        String h1 = "";
        h1 = "var config = {\n"
                + "Chart_Labels: showLabels,\n"
                + "distance: 20,\n"
                + "ShafText_Opacity: chart_opacity,\n"
                //+ "ShafText_Opacity: true,\n"
                + "ShafText_Opacity2: chart_opacity,\n"
                + "//ShafText_Opacity: true,\n"
                + "Shaft_Area: true,\n"
                + "Grid: true,\n"
                + "Theme: 'walden',\n"
                + "Smooth: true,\n"
                + "Axis: true,\n"
                + "Title: true,\n"
                + "Legend: true,\n"
                + "Toolbox: true,\n"
                + "Symbol_Size: symbolSize,\n"
                + "LineWidth: linestulemfasis, \n"
                + "Graphics: true,\n"
                + "Watermark: true,\n"
                + "};\n";
        return h1;
    }

    public static String CamChart_DatGUI_obj() {
        String h1 = "";
        h1 = "var obj = {\n"
                + "     Username: '" + UserInfo.Get_UserName().toLowerCase() + "' ,\n"
                + "     'Computer Name': '" + UserInfo.Get_ComputerName() + "' ,\n"
                + "	'Date': dateCams,\n"
                + "	'CAM Job Name ': AsmName,\n"
                + "	'Number of Cams ': CamsDiag_NofCams,	\n"
                + "	'Show Labels ': true, \n"
                + "      Chart_Color: bic_color, \n"
                //+ "     'Opacity': chart_opacity, \n"
                + "     'Show Shaft Area': true, \n"
                + "     //'Chart Theme' : ['string_1', 'string_2', 'string_3']\n"
                + "};\n";
        return h1;
    }

    public static String CamChartDatGUI_Labels(Integer t) {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
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
        h1 = "function show_labels01() {\n"
                + builder.toString()
                + "}\n";

        return h1;
    }

    public static String CamChartDatGUI_SymbolSize(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + " series: {\n"
                    + "        symbolSize: config.Symbol_Size,\n"
                    + "    }"
                    + "});\n"
            );
        }
        h1 = "function symbolSize01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_Toolbox(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + " toolbox: {\n"
                    + "        show: config.Toolbox,\n"
                    + "    }"
                    + "});\n"
            );
        }
        h1 = "function toolbox01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }
    
    public static String CamChartDatGUI_Smooth(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                            + "myChart_Cam" + i + ".setOption({\n"
                            + "series: {\n"
                            + "smooth: config.Smooth,\n"
                            + "},\n"
                            + "});\n"
            );
        }
        h1 = "function smooth01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }    

    public static String CamChartDatGUI_WaterMark(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + CamChart_BackGroundColor(i)
                    + "});\n"
            );
        }
        h1 = "function watermark01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }    
    
    public static String CamChartDatGUI_Legend(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + " legend: {\n"
                    + "        show: config.Legend,\n"
                    + "    }"
                    + "});\n"
            );
        }
        h1 = "function legend01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_Title(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + " title: {\n"
                    + "        show: config.Title,\n"
                    + "    }"
                    + "});\n"
            );
        }
        h1 = "function title01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_LineWidth(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + "series: {\n"
                    + "lineStyle: {\n"
                    + "   width: config.LineWidth,\n"
                    + "}\n"
                    + "},"
                    + "});\n"
            );
        }
        h1 = "function linewidth01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_Axis(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
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
        h1 = "function axis01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_Grid(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + "grid: {\n"
                    + "show: config.Grid,\n"
                    + "},\n"
                    + "});\n"
            );
        }
        h1 = "function gridShow() {\n"
                + builder.toString()
                + "}\n";

        return h1;
    }

    public static String CamChartDatGUI_ChartColor(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
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
        h1 = "function chartColor01() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_Theme(Integer t) {
        String h1 = "";
        h1 = "";

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "//var myChart_Cam" + i + "Theme = echarts.init(document.getElementById('maincam" + i + "'), config.Theme);\n"
                    + "//myChart_Cam" + i + ".dispose();\n"
                    + "//CamsDiag_theme"
                    + "//echarts.registerTheme(config.Theme);\n"
                    + "//var myChart_Cam" + i + " = echarts.init(document.getElementById('maincam" + i + "'), config.Theme);\n"
                    + "//var chart" + i + "Theme = myChart_Cam" + i + ".init(dom, config.Theme)\n"
                    + "//echarts.dispose(this.myChart_Cam" + i + ");\n"
                    + "//echarts.registerTheme(config.Theme);\n"
            //+ "var myChart_Cam"+i+" = echarts.init(document.getElementById('maincam"+i+"'), config.Theme);"
            //+ "myChart_Cam" + i + ".setOption({\n"
            //+ "//this.initECharts();\n"
            // + "//this.maincam" + i + " = echarts.init(document.getElementById('maincam" + i + "'),'config.Theme');\n"
            //                            + "grid: {\n"
            //                            + "show: config.Grid\n,"
            //                            + "containLabel: config.Grid\n,"
            //                            + "},\n"
            //+ "});\n"
            );
        }
        h1 = "function themes01() {\n"
                + builder.toString()
                //+"echarts.registerTheme('config.Theme');"
                + "\n}\n";

        return h1;
    }

    public static String CamChartDatGUI_Graphic(Integer t) {
        String h1 = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= NumberOfCams(); i++) {
            builder.append("\n"
                    + "myChart_Cam" + i + ".setOption({\n"
                    + "graphic: [\n"
                    + "{\n"
                    + "invisible: true,\n"
                    + "elements: [\n"
                    + Graphic_LabelCam(i)
                    + "\n"
                    //+ GraphicDatGUI_SmallCircle(i)
                    + Graphic_SmallCircle(i)
                    + "\n"
                    //+ GraphicDatGUI_BigCircle(i)
                    + Graphic_BigCircle(i)
                    + "\n"
                    + "],\n"
                    + "},],\n"
                    + "});\n"
                    //+ "   $action: 'merge',\n"
//                    + "myChart_Cam" + i + ".setOption({\n"
//                    + "graphic: [{\n"
//                     +Graphic_LabelCam(t)
//                    +GraphicDatGUI_BigCircle(t)
//                    +GraphicDatGUI_SmallCircle(t)
                            
//                    + "//id: 'GroupCam" + i + "',\n"
//                    + "//type: 'circle',\n"
//                    + "//children: [\n"
//                    + "//elements: [\n"
//                    + "  style: {\n"
//                    + "      opacity: config.ShafText_Opacity, \n"
//                    + "   },\n"
//                    + ""
////                    + "textContent: {\n"
////                    + "      opacity: config.ShafText_Opacity, \n"
////                    + "}"
//                    + "//]\n"
//                    + "//],\n"
//                    + " }]\n"
//                    + "});\n"
            );
        }
        
        h1 = "function opacity03() {\n"
                + builder.toString()
                + "\n}\n";

        return h1;
    }
    
    public static String Graphic_LabelCam(Integer t) {
        String labelCam = "";
        
        labelCam = "\n//Label Cam\n"
                + "{\n"
                + "   type: 'group',\n"
                + "   rotation: Math.PI / 4,\n"
                + "   bounding: 'raw',\n"
                + "   right: 30,\n"
                + "   bottom: 30,\n"
                + "   z: 100,\n"
                + "   //$action: 'merge',\n"
                + "   //invisible: true,\n"
                + "   children: [\n"
                + "   {\n"
                + "      type: 'rect',\n"
                + "      left: 'center',\n"
                + "      top: 'center',\n"
                + "   $action: 'merge',\n"
                + "   z: 100,\n"
                + "   shape: {\n"
                + "   width: 400,\n"
                + "   height: 30\n"
                + "   },\n"
                + "   style: {\n"
                + "   fill: 'rgba(0,0,0,0.3)'\n"
                + "   }\n"
                + "   },\n"
                + "   {\n"
                + "       type: 'text',\n"
                + "       left: 'center',\n"
                + "       top: 'center',\n"
                + "       z: 100,\n"
                + "       style: {\n"
                + "       fill: '#fff',\n"
                + "       text: 'C" + t + "',\n"
                + "       font: 'bold 15px sans-serif'\n"
                + "              }\n"
                + "    }\n"
                + "          ]\n"
                + "},\n";
        return labelCam;
    }
    
    public static String Graphic_SmallCircle(Integer t) {
        String smallcircle = "\n{\n"
                + "id: 'CamCircleIn" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "     cx: crc" + t + "x,\n"
                + "      cy: crc" + t + "y,\n"
                + "     r: crc" + t + "_in,\n"
                + "      },\n"
                + "      style: {\n"
                + "         fill: 'white',\n"
                + "         opacity: chart_opacity, \n"
                + "         stroke: 'black',\n"
                + "        lineWidth: 2,\n"
                + "      }\n"
                + "},\n";

        return smallcircle;
    }

    public static String GraphicDatGUI_SmallCircle(Integer t) {
        String smallcircle = "\n{\n"
                + "id: 'CamCircleIn" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "     cx: crc" + t + "x,\n"
                + "      cy: crc" + t + "y,\n"
                + "     r: 0,\n"
                + "      },\n"
                + "      style: {\n"
                + "         fill: 'white',\n"
                + "         opacity: chart_opacity, \n"
                + "         stroke: 'black',\n"
                + "        lineWidth: 0,\n"
                + "      }\n"
                + "},\n";

        return smallcircle;
    }

    public static String Graphic_BigCircle(Integer t) {
        String bigcircle = "{\n"
                + "id: 'CamCircleOut" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    cursor: 'hand',\n"
                + "    draggable: true,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "    cx: crc" + t + "x,\n"
                + "    cy: crc" + t + "y,\n"
                + "    r:  crc" + t + "_out,\n"
                + "    //r: 10,\n"
                + "},\n"
                + "style: {\n"
                + "fill: 'white',\n"
                + "opacity: chart_opacity, \n"
                + "stroke: 'black',\n"
                + "lineWidth: 2,\n"
                + "},\n"
                + "textContent: {\n"
                + "    z: 100,\n"
                + "    x: crc" + t + "x+30,\n"
                + "    y: crc" + t + "y,\n"
                + " style: {\n"
                + "    text: arrow_cw,\n"
                + "    fill: 'black',\n"
                + "    opacity: chart_opacity,\n"
                + "    font: 'bold 30px sans-serif'\n"
                + "}\n"
                + "},\n"
                + "//textConfig: {\n"
                + "//position: 'center'\n"
                + "//}\n"
                + "},\n";
        return bigcircle;
    }

    public static String GraphicDatGUI_BigCircle(Integer t) {
        String bigcircle = "{\n"
                + "id: 'CamCircleOut" + t + "',\n"
                + "   type: 'circle',\n"
                + "   z: 100,\n"
                + "    cursor: 'hand',\n"
                + "    draggable: true,\n"
                + "    //invisible: true,\n"
                + "   shape: {\n"
                + "    cx: crc" + t + "x,\n"
                + "    cy: crc" + t + "y,\n"
                + "    r:  0,\n"
                + "    //r: 10,\n"
                + "},\n"
                + "style: {\n"
                + "fill: 'white',\n"
                + "opacity: chart_opacity, \n"
                + "stroke: 'white',\n"
                + "lineWidth: 0,\n"
                + "},\n"
                + "textContent: {\n"
                + "    z: 100,\n"
                + "    x: crc" + t + "x+30,\n"
                + "    y: crc" + t + "y,\n"
                + " style: {\n"
                + "    text: '',\n"
                + "    fill: 'white',\n"
                + "    opacity: chart_opacity,\n"
                + "    font: 'bold 30px sans-serif'\n"
                + "}\n"
                + "},\n"
                + "//textConfig: {\n"
                + "//position: 'center'\n"
                + "//}\n"
                + "},\n";
        return bigcircle;
    }

    public static String CamChart_Graphic(Integer t) {
        String h1 = "";

        h1 = "graphic: [\n"
                + "{\n"
                + "invisible: false,\n"
                + "elements: [\n"
                + Graphic_LabelCam(t)
                + "\n"
                //+ Graphic_SmallCircle(t)
                + "\n"
                //+ Graphic_BigCircle(t)
                + "\n"
                + "],\n"
                + "},],\n";
        return h1;
    }
    
    
}
