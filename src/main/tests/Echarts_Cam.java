/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

/**
 *
 * @author MManolas
 */
public class Echarts_Cam {

    public static String Echarts_Cam_JS02() {
        String h1 = "";
        h1 = "var AxisMin = 0;\n"
                + "\n"
                + "\n"
                + "/*Common Settings For All Cams*/\n"
                + "\n"
                + "var option = {\n"
                + "aria: {\n"
                + "    enabled: true,\n"
                + "    decal: {\n"
                + "        show: true\n"
                + "    }\n"
                + "},\n"
                + "    title: {\n"
                + "        text: CamDrwName, //Main title\n"
                + "        padding: 5,\n"
                + "        textStyle: {\n"
                + "            color: text_color,\n"
                + "            fontStyle: 'normal',\n"
                + "            fontWeight: 'bold',\n"
                + "            fontSize: 14,\n"
                + "            align: 'center'\n"
                + "        },\n"
                + "        subtext: CamDescription + \"\\nEccentric  : \" + Recc01 + \" mm\",\n"
                + "        subtextStyle: {\n"
                + "            padding: 5,\n"
                + "            color: text_color,\n"
                + "            fontSize: 13\n"
                + "        },\n"
                + "        itemGap: 10\n"
                + "    },\n"
                + "    legend: {\n"
                + "        type: \"scroll\",\n"
                + "        show: true,\n"
                + "        data: [CamDescription],\n"
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
                + "                lang: ['Data View', 'Close', 'Refresh'],\n"
                + "                backgroundColor: 'rgb(252, 184, 49)',\n"
                + "                textColor: '#222',\n"
                + "                buttonColor: '#c23531'\n"
                + "            },\n"
                + "            magicType: {show: true, type: ['line', 'bar']},\n"
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
                + "        interval: 30,\n"
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
                + "        max: AxisMax,\n"
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
                + "\n"
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
                + "    ],\n"
                + "\n"
                + "    series: [{\n"
                + "            data: DataCam,\n"
                + "            name: CamDescription,\n"
                + "            type: 'line',\n"
                + "            symbolSize: 10,\n"
                + "opacity: 0.8,\n"
                + "            markLine: {\n"
                + "                decal: true,\n"
                + "                symbol: \"none\",\n"
                + "                data: [\n"
                + "                    {\n"
                + "                        silent: false,\n"
                + "                        lineStyle: {\n"
                + "                            type: \"dashed\",\n"
                + "                            color: \"#FA3934\",\n"
                + "                            width: linestulemfasis - 3,\n"
                + "                            opacity: 0.8\n"
                + "                        },\n"
                + "                        label: {                            \n"
                + "                            formatter: ShaftDiameter + ' mm',\n"
                + "                            fontSize: '10'\n"
                + "                        },\n"
                + "                        yAxis: ShaftDiameter\n"
                + "                    }]},\n"
                + "\n"
                + "            markArea: {\n"
                + "                animation: true,\n"
                + "                animationEasing: \"quarticIn\",\n"
                + "                z: -1,\n"
                + "                \n"
                + "                itemStyle: {\n"
                + "                    normal: {\n"
                + "                        color: bic_color,\n"
                + "                        opacity: 0.8\n"
                + "                    },\n"
                + "                    emphasis: {\n"
                + "                        color: shaftcolor_emp,\n"
                + "                        opacity: 0.8\n"
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
                + "                            name: ShaftDiam_Label,\n"
                + "                            yAxis: 0\n"
                + "                        }, {\n"
                + "                            yAxis: ShaftDiameter\n"
                + "                        }]\n"
                + "                ]\n"
                + "            },\n"
                + "\n"
                + "            emphasis: {\n"
                + "                focus: 'series',                \n"
                + "                lineStyle: {\n"
                + "                    width: linestulemfasis + 3,\n"
                + "                    opacity: 0.8\n"
                + "                }\n"
                + "            },\n"
                + "            label: {\n"
                + "                show: true\n"
                + "            },\n"
                + "            lineStyle: {\n"
                + "                width: linestulemfasis,\n"
                + "                shadowColor: 'black',\n"
                + "                oppacity: 0.5,\n"
                + "                shadowBlur: 10,\n"
                + "                shadowOffsetY: 8,\n"
                + "                color: shaftcolor_emp\n"
                + "            },\n"
                + "            z: 0,\n"
                + "            areaStyle: {\n"
                + "                color: bic_color,\n"
                + "                origin: \"start\",\n"
                + "                offset: 0,\n"
                + "                opacity: 0.9\n"
                + "            }\n"
                + "        }]\n"
                + "};\n"
                + "\n"
                + "\n"
                + "function formatAxisPointerLabel(value)\n"
                + "{\n"
                + "    var label = value.value;\n"
                + "\n"
                + "    if (value.hasOwnProperty('axis'))\n"
                + "    {\n"
                + "        // this is only possible if the proposed solution is in place:\n"
                + "        if (value.axis.model.option.axisLabel.formatter)\n"
                + "        {\n"
                + "            label = value.axis.model.option.axisLabel.formatter.call({}, label);\n"
                + "        }\n"
                + "    }\n"
                + "    return label;\n"
                + "}\n"
                + "\n"
                + "myChart.setOption(option);\n";
        return h1;
    }

    
    
}
