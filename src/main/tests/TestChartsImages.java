///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package main.tests;
//
//import com.sun.xml.internal.ws.util.StringUtils;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//import javax.imageio.ImageIO;
//
///**
// *
// * @author MManolas
// */
//public class TestChartsImages {
//    //public void Test() {
////@RequestMapping(value = "/downloadRunWholeCharts", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
//public void downloadConditionCharts(HttpServletRequest req, HttpServletResponse res, @RequestParam List<String> images) {
//    ServletOutputStream out = null;a
//    try {
//        String fileName = "Overall analysis result-" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".xlsx";
//        String sheetName = "Overall analysis result";
//        BigExcelWriter writer = ExcelUtil.getBigWriter(req.getRealPath("/files") + "/" + fileName, sheetName);
//
//        Drawing patriarch = writer.getSheet().createDrawingPatriarch();
//        short startRow = 0;
//        int endRow = 40;
//        for (int i = 0; i <images.size(); i++) {
//            if (i% 2 == 1) {
//                continue;
//            }
//            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//            BufferedImage bufferImg = null;
//
//            String requestRealPath = req.getRealPath("/files") + "/";
//            String imagePath = convertImagePath(images.get(i) + "," + images.get(i + 1), requestRealPath, System.currentTimeMillis() + "", "png");//Base64 to Png
//            if (!StringUtils.isEmpty(imagePath)) {
//                File jpgFile = convertImagePngToJpg(new File(imagePath));//PNG image to Jpg
//                bufferImg = ImageIO.read(jpgFile);
//                ImageIO.write(bufferImg, "jpg", byteArrayOut);
//                if (i != 0) {
//                    startRow = (short) (endRow + 5);
//                    endRow = startRow + 40;
//                }
//                XSSFClientAnchor anchor1 = new XSSFClientAnchor(0, 0, 255, 255, (short) 1, startRow, (short) 20, endRow);
//                anchor1.setAnchorType(ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE);
//                patriarch.createPicture(anchor1, writer.getWorkbook().addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
//            }
//        }
//        out = res.getOutputStream();
//        res.reset();//Clear the output stream
//        res.setContentType("application/vnd.ms-excel;charset=utf-8");
//       //response.setContentType("multipart/form-data;charset=UTF-8");You can also set UTF-8 explicitly, or not set it in the test.
//        res.setHeader("Content-Disposition", "attachment; fileName=" + fileName + ";filename*=utf-8"" + URLEncoder.encode(fileName, "UTF-8"));
//        res.addHeader("Pargam", "no-cache");
//        res.addHeader("Cache-Control", "no-cache");
//        writer.flush(out, false);
//        IoUtil.close(out);
//    } catch (IOException e) {
//        logger.error("Analysis result chart downloading is abnormal" + e.getMessage());
//    } finally {
//        IoUtil.close(out);
//    }
//    logger.info("Analysis result chart download end");
//   //return JsonUtils.toJson(new ResponseMap(200, "downloaded successfully"));
//}
//    
//    //}
//}
