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
import static main.MnIT_Main.CheckMachineMotionCamAll;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.Cam_All_js;

/**
 *
 * @author MManolas
 */
public class JS_CamAll {

    public static void main(String args[]) throws Exception {
        CamParametersChartALL();
    }

    public static void CamParametersChartALL() throws IOException {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+CamJobName() + "//"+Cam_All_js);
        
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
           // w.write(Echarts_FindMAX());
           w.write("const arrDataCam = [ ");
            for (int i = 1; i <= NumberOfCams(); i++) {
                w.write("cam"+i+"y, ");
            }
            w.write(" ];\n"
                    + "const maxCamAll = Math.max(...[].concat(...arrDataCam));\n"
                    + "\n"
                    + "const minCamAll = Math.min(...[].concat(...arrDataCam));\n");
           
           
        w.write(Echarts_OptionsCamAll_p01());        
            for (int i = 1; i <= NumberOfCams(); i++) {
                w.write(Echarts_OptionsCamAll_p02(i));                
            }
            w.write(Echarts_OptionsCamAll_p03()

            );
         w.close();
        }
    }

    public static String Echarts_OptionsCamAll_p01() {
        String h1 = "";
        h1 = "\n"
                + "var myChart = echarts.init(document.getElementById('mainAll'), CamsDiag_theme);\n"
                //+ "var myChart = echarts.init(document.getElementById('mainAll'), CamsDiag_theme);\n"
                + "var CamDrwName = AsmName;\n"
                + "var CamDescription = AsmDescription;\n"
                + "var MaxMotionMachine=110;\n"
                + "var MaxValueYaxis=maxCamAll;\n"
                + "var MaxValueYaxisZoom=maxCamAll+30;\n"
                + "var option = {\n"
                + "\n"
                + "textStyle: {\n"
                + "    fontFamily: 'Tahoma'\n"
                + "  },"
                + "//    aria: {\n"
                + "//        enabled: true,\n"
                + "//        decal: {\n"
                + "//            show: true\n"
                + "//        }\n"
                + "//    },\n"
                + "title: {\n"
                + "text: CamDrwName,\n"
                + "        padding: 5,\n"
                + "        left: 5,\n"
                + "        bottom: 5,\n"
                + "itemGap: 10,\n"
                + "        textStyle: {\n"
                + "            color: '#151515',\n"
                + "            fontStyle: 'normal',\n"
                + "            fontWeight: 'bold',\n"
                + "            fontSize: 14,\n"
                + "            align: 'center',\n"
                + ""
                
                + "        },\n"
                + "        subtext: CamDescription,\n"
                + "        subtextStyle: {\n"
                + "            padding: 12,\n"
                + "            color: text_color,\n"
                + "            fontSize: 10\n"
                + "        },\n"
                + "},\n"
                + "legend: {\n"
                + "        type: \"scroll\",\n"
                + "        show: true,\n"
                + "        selector: true,\n"
                + "       // selectorLabel: {\n"
                + "      //  color: 'yellow',\n"
                + "      //  borderColor: 'green',\n"
                + "       // backgroundColor: 'blue'\n"
                + "       //  },\n"
                + "       // emphasis: {\n"
                + "      //  selectorLabel: {\n"
                + "       // backgroundColor: 'red'\n"
                + "       // }\n"
                + "       // },\n"
                + "         //pageButtonPosition: 'start',\n"             
                //+ "        data: [cam" + t + "descl],\n"
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
                + "},\n"
                + "/*\n"
                + "    title: {\n"
                + "        text: CamDrwName,\n"
                + "        textStyle: {\n"
                + "            color: '#767676', //colour\n"
                + "            fontStyle: 'normal', //style\n"
                + "            fontWeight: 'bold', //Thickness\n"
                + "            fontFamily:'Arial',   //Font\n"
                + "            fontSize: 14, //size\n"
                + "            align: 'center'\n"
                + "        },\n"
                + "        subtext: CamDescription,\n"
                + "        subtextStyle: {\n"
                + "            color: '#767676',\n"
                + "            fontSize: 14\n"
                + "        },\n"
                + "        itemGap: 10\n"
                + "    },\n"
                +"*/"
                + "    toolbox: {\n"
                + "  itemSize:20,\n"
                + "  orient: 'vertical',\n"
                + "  left: 5,\n"
                + "  top: 50,\n"
                + "        feature: {             \n"
                + "            mark : {show: true},\n"
                + "            dataView: {show: true, \n"
                + "                readOnly: false, \n"
                + "                title: 'Data View : "+NumberOfCams()+" Charts' , \n"
                + "                lang: ['Data View : "+NumberOfCams()+" Charts ', 'Close', 'Refresh Data'], \n"
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
                + "            },\n"
                + "            dataZoom: {show: true},\n"
                + "            restore: {show: true}\n"
                + "        }\n"
                + "    },\n"
                + "    tooltip: {\n"
                + "        trigger: 'axis',\n"
                + "        //formatter: '<br/><b>{a}</b><br/>x,y = ({b}{c})',\n"
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
                + "        id: 'All1',\n"
                + "        //scale: true,\n"
                + "        boundaryGap: true,\n"
                + "        splitNumber: 10,\n"
                + "        min: 0,\n"
                + "        max: 360,\n"
                + "        interval: 30,\n"
                + "        gridindex: 0, \n"
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
                + "        id: 'All2',\n"
                + "        min: 0,\n"
                + "        max: MaxValueYaxisZoom,\n"
                + "         //max: arrDataCam+30,\n"
                + "        interval: 10,\n"
                + "        boundaryGap: true,\n"
                + "        splitNumber: 10,\n"
                + "        axisTick: {\n"
                + "            inside: true,\n"
                + "            show: false,\n"
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
                + "         show: false,\n"                
                + "            formatter: \"{value} mm\"\n"
                + "        }\n"
                + "    },\n"
                + "    calculable: true,\n"
                + "    dataZoom: [\n"
                + "                    {\n"
                + "                        //type: 'slider,\'"
                + "                        show: true,\n"
                + "                        realtime: true,\n"
                + "                        yAxisIndex: [0],\n"
                + "                        //startValue: minCamAll,\n"
                + "                        startValue: 0,\n"
                + "                        end: MaxValueYaxisZoom\n"
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
                + "                        start: 0,\n"
                + "                        end: MaxValueYaxisZoom\n"
                + "                    }\n"
                + "                    \n"
                + "                ],\n"
                + "    visualMap: "
                + "[\n"
                + "        {\n"
                +"             show: true,\n"
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
                + "                \"Deg Max "+"\u00B0"+"\",\n"
                + "                \"Deg Min "+"\u00B0"+"\",\n"
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
                + "/////////////////////\n"
                + "//Series\n"
                + "series: [\n";

        return h1;
    }

    public static String Echarts_OptionsCamAll_p03() {
        String h1 = "";
        h1 = "]\n};\n"
                + "//Functions\n"
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
                + "\n"
                + "//Show Loading\n"
                + "myChart.showLoading({\n"
                + "      text: 'Please Wait..',\n"
                + "      color: '#c23531',\n"
                + "      textColor: '#000',\n"
                + "      maskColor: 'rgba(255, 255, 255, 0.2)',\n"
                + "      zlevel: 0\n"
                + "    });;\n"
                + "setTimeout(() => {\n"
                + "  myChart.hideLoading();\n"
                + "  myChart.setOption(option);\n"
                + "}, 1000);\n\n"
                + "/*\n"
                + "var chart1 = testHelper.create(echarts, 'mainAll', {\n"
                + "               title: [\n"
                + "                    CamDrwName,\n"
                + "                    CamDescription\n"
                + "                ],\n"
                + "                option: option,\n"
                + "                width: 50,\n"
                + "                //buttons: [{text: 'btn-txt', onclick: function () {}}],\n"
                + "                //recordCanvas: true,\n"
                + "            });\n"
                + "*/\n"
                + ""
                + "myChart.setOption(option, true);\n"
                + "//chart1.setOption(option);";
        return h1;
    }

    public static String Echarts_OptionsCamAll_p02(Integer t) {
        String h1 = "";
        h1 =  "        {\n"
                + "            name: cam" + t + "label,\n"
                + "            type: 'line',\n"
                + "            seriesLayoutBy: 'row',\n"
                + "            symbolSize: symbolSize,\n"
                + "            //stack: true,\n"
                + "            areaStyle: {},\n"
                + "            emphasis: {\n"
                + "                focus: 'series',                \n"
                + "                lineStyle: {\n"
                + "                    width: 4,\n"
                + "                    opacity: 0.8\n"
                + "                }\n"
                + "            },\n"
                + ""
                + ""
                + CheckMachineMotionCamAll()
                + ""
//                + "/*\n"
//                + "            markArea: {\n"
//                + "                itemStyle: {\n"
//                + "                     normal: {\n"
//                + "                         color: bic_color\n"
//                + "                     },\n"
//                + "                    emphasis: {\n"
//                + "                        color: '#767676'\n,"
//                + "                        opacity: 0.4"
//                + "                    }\n"
//                + "                },\n"
//                + "                label: {\n"
//                + "\n"
//                + "                    show: false,\n"
//                + "                    position: 'top',\n"
//                + "                    color: '#272626',\n"
//                + "                    fontSize: 12\n"
//                + "                },\n"
//                + "                labelLayout: {\n"
//                + "                    hideOverlap: false\n"
//                + "                },\n"
//                + "            emphasis: {\n"
//                + "                color: shaftcolor_emp,\n"
//                + "                focus: 'series',\n"
//                + "                 opacity: 0.5,"
//                + "                lineStyle: {\n"
//                + "                    width: linestulemfasis + 3,\n"
//                + "                    opacity: 0.4\n"
//                + "                }\n"
//                + "            },\n"
//                + "                data: [\n"
//                + "                    [{\n"
//                + "                            name: shaftdiam_label_cam"+t+",\n"
//                + "                            yAxis: 0\n"
//                + "                        }, {\n"
//                + "                           yAxis: cam"+t+"diameter\n"
//                + "                        }]\n"
//                + "                ]\n"
//                + "            },\n"
//                + "*/\n"
                + "            z: 1,\n"
                + "            label: {\n"
                + "                show: true\n"
                + "            },\n"
                + "            lineStyle: {\n"
                + "                width: linestulemfasis,\n"
                + "                shadowColor: 'grey',\n"
                + "                oppacity: 0.7,\n"
                + "                shadowBlur: 3,\n"
                + "                shadowOffsetY: 2,\n"
                + "//              color: shaftcolor_emp\n"
                + "            },\n"
                + "            areaStyle: {\n"
                + "                //color: bic_color,\n"
                + "                origin: \"start\",\n"
                + "                offset: 0,\n"
                + "                opacity: 0.8\n"
                + "            },\n"
                + "            data: data_cam" + t + "\n"
                + "        },\n";
        return h1;
    }

    public static String CamsAll_Max_Element(Integer t) {
    String h1="";
    String h2,h3 = "";
    h2 = "const arrDataCam = [";
        for (int i = 1; i <= NumberOfCams(); i++) {
            h1 = "cam" + i+"y";
        }
    h3 = "];\n";
    String hall = h2+h1+h3;
    return hall;
    }
    
    public static String Echarts_FindMAX() {

        String h1="",h2="",h3="",h4 = "";

        h1 = 

                //CamsAll_Max_Element(t)+"\n"
                //+ "const arrDataCam = " + CamsAll_Max_Element() + ";\n"
                 "\n"
                + "const maxCamAll = Math.max(...[].concat(...arrDataCam));\n"
                + "\n"
                + "const minCamAll = Math.min(...[].concat(...arrDataCam));\n"
                + "\n"
                //+ "console.log(max);\n"
                //+ "\n"
                //+ "console.log(min);"
                ;

        return h1;
    }
    
    
    public static String JS_WonResize() {
        String h1 = "";
        h1 = "\nvar chartArr = [];\n"
                + "chartArr.push(myChart);\n"
                
                + "\n"
                + "window.onresize = function () {\n"
                + "                         //Loop through each chart\n"
                + "            for(var i = 0; i < chartArr.length; i ++) {\n"
                + "                chartArr[i].resize();\n"
                + "            }\n"
                + "        }\n";
        return h1;
    }
}
