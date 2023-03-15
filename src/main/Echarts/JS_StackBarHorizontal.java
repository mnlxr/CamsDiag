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
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.Cam_StackBar_js;

/**
 *
 * @author MManolas
 */
public class JS_StackBarHorizontal {

    public static void main(String args[]) throws Exception {
        StBar_Ph();
    }

    public static void StBar_Ph() throws IOException {
        File statText = new File(PathWebServer + "//" + mainFolder + "//" + CamJobName() + "//" + Cam_StackBar_js);

        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
//        w.write(Echarts_OptionsCamAll_p01());
//            for (int i = 1; i <= NumberOfCams(); i++) {
//                w.write(Echarts_OptionsCamAll_p02(i));                
//            }
            w.write(StBarChart()
            );
            w.close();
        }
    }

    public static String StBarChart() {
        String h1 = "";
        h1 = ""
                + "/*Cam StackBar*/\n"
                + "var myChart_StBarCam = echarts.init(document.getElementById('maincambar'), CamsDiag_theme);\n"
                + "var mainDesc = mainMachineDesc;\n"
                + "bar_option = {\n"
                + "    tooltip: {\n"
                + "        trigger: 'axis',\n"
                + "        axisPointer: {            // Use axis to trigger tooltip\n"
                + "            type: 'shadow'        // 'shadow' as default; can also be 'line' or 'shadow'\n"
                + "        }\n"
                + "    },\n"
                + "    legend: {\n"
                + "        data: [mainDesc]\n"
                + "    },\n"
                + "    grid: {\n"
                + "        left: '3%',\n"
                + "        right: '4%',\n"
                + "        bottom: '3%',\n"
                + "        containLabel: true\n"
                + "    },\n"
                + "    xAxis: {\n"
                + "        type: 'value'\n"
                + "    },\n"
                + "    yAxis: {\n"
                + "        type: 'category',\n"
                + "        data: ['Machine']\n"
                + "    },\n"
                + "    series: [\n"
                + "        {\n"
                + "            name: 'Direct',\n"
                + "            type: 'bar',\n"
                + "            stack: 'total',\n"
                + "            label: {\n"
                + "                show: true\n"
                + "            },\n"
                + "            emphasis: {\n"
                + "                focus: 'series'\n"
                + "            },\n"
                + "            data: [0, 90, 180, 270, 360]\n"
                + "        }\n"
                + "    ]\n"
                + "};\n"
                + "////////////////////////////////////////////////////\n"
                + "//End Of Chart1\n"
                + "////////////////////////////////////////////////////\n";

        return h1;
    }

}
