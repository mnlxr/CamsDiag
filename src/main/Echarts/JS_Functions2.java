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
import static main.Echarts.HTML_functions.HTML_Body;
import static main.Echarts.HTML_functions.HTML_Head;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;

/**
 *
 * @author MManolas
 */
public class JS_Functions2 {

    public static void main(String args[]) throws Exception {
        FilesUploadDnDrop();
    }

    public static void CamsDiag_JS_Functions() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer + "\\" + mainFolder + "\\" + CamJobName() + ".html");
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    HTML_Head() + HTML_Body()
            );
            w.close();
        }
    }

    public static String FilesUploadDnDrop() {
        String h1 = "";
        h1 = "\n\nfunction handleFileSelect(evt) {\n"
                + "    var files = evt.target.files; // FileList object\n"
                + "\n"
                + "    // Loop through the FileList and render image files as thumbnails.\n"
                + "    for (var i = 0, f; f = files[i]; i++) {\n"
                + "\n"
                + "      // Only process image files.\n"
                + "      if (!f.type.match('image.*')) {\n"
                + "        continue;\n"
                + "      }\n"
                + "\n"
                + "      var reader = new FileReader();\n"
                + "\n"
                + "      // Closure to capture the file information.\n"
                + "      reader.onload = (function(theFile) {\n"
                + "        return function(e) {\n"
                + "          // Render thumbnail.\n"
                + "          var span = document.createElement('span');\n"
                + "          span.innerHTML = ['<img class=\"thumb\" src=\"', e.target.result,\n"
                + "                            '\" title=\"', escape(theFile.name), '\"/>'].join('');\n"
                + "          document.getElementById('list').insertBefore(span, null);\n"
                + "        };\n"
                + "      })(f);\n"
                + "\n"
                + "      // Read in the image file as a data URL.\n"
                + "      reader.readAsDataURL(f);\n"
                + "    }\n"
                + "  }\n"
                + "\n"
                + "  document.getElementById('files').addEventListener('change', handleFileSelect, false);\n\n";
        return h1;
    }

    public static String DnD_Images() {
        String h1 = "";
        h1 = "\n\nvar dropZone = document.getElementById('dropZone');\n"
                + "\n"
                + "// Optional.   Show the copy icon when dragging over.  Seems to only work for chrome.\n"
                + "dropZone.addEventListener('dragover', function(e) {\n"
                + "    e.stopPropagation();\n"
                + "    e.preventDefault();\n"
                + "    e.dataTransfer.dropEffect = 'copy';\n"
                + "});\n"
                + "\n"
                + "// Get file data on drop\n"
                + "dropZone.addEventListener('drop', function(e) {\n"
                + "    e.stopPropagation();\n"
                + "    e.preventDefault();\n"
                + "    var files = e.dataTransfer.files; // Array of all files\n"
                + "\n"
                + "    for (var i=0, file; file=files[i]; i++) {\n"
                + "        if (file.type.match(/image.*/)) {\n"
                + "            var reader = new FileReader();\n"
                + "\n"
                + "            reader.onload = function(e2) {\n"
                + "                // finished reading file data.\n"
                + "                var img = document.createElement('img');\n"
                + "                img.src= e2.target.result;\n"
                + "                document.body.appendChild(img);\n"
                + "            }\n"
                + "\n"
                + "            reader.readAsDataURL(file); // start reading the file data.\n"
                + "        }\n"
                + "    }\n"
                + "});\n\n";
        return h1;
    }
    
    
    public static String DnD_JQuery() {
    
    String h1="";
    h1="\n\n// Required for drag and drop file access\n" +
"jQuery.event.props.push('dataTransfer');\n" +
"$(function() {\n" +
"  var dropTimer;\n" +
"  var dropTarget = $('.dragArea');\n" +
"  var fileInput = $('#imageFile');\n" +
"  dropTarget.on(\"dragover\", function(event) {\n" +
"    dropTarget.addClass('over');\n" +
"    return false; // Required for drop to work\n" +
"  });\n" +
"  dropTarget.on('dragleave', function(event) {\n" +
"    dropTarget.removeClass('over');\n" +
"  });\n" +
"  handleDrop = function(files) {\n" +
"    dropTarget.removeClass('over');\n" +
"    var file;\n" +
"    // iterate through all dropped files\n" +
"    for (var i = 0; i < files.length; i++) {\n" +
"      file = files[i];\n" +
"      if (file.type.match('image.*')) {\n" +
"        resizeImage(file, 100, function(result) {\n" +
"          // we now need to append a new Image instead of reusing a single one\n" +
"          $('.resultImageWrapper').append(\n" +
"            $('<img>', {src: result})\n" +
"          )\n" +
"          $('.resultImageWrapper').show();\n" +
"        });\n" +
"      } else {\n" +
"        alert(\"That file wasn't an image.\");\n" +
"      }\n" +
"    }\n" +
"  };\n" +
"  dropTarget.on('drop', function(event) {\n" +
"    event.preventDefault(); // Or else the browser will open the file\n" +
"    handleDrop(event.dataTransfer.files);\n" +
"  });\n" +
"  fileInput.on('change', function(event) {\n" +
"    handleDrop(event.target.files);\n" +
"  });\n" +
"  resizeImage = function(file, size, callback) {\n" +
"    // no need for a FileReader, a blobURI is better\n" +
"    var image = new Image();\n" +
"    image.onload = function() {\n" +
"      var canvas = document.createElement(\"canvas\");\n" +
"      /*\n" +
"      if(image.height > size) {\n" +
"      	image.width *= size / image.height;\n" +
"      	image.height = size;\n" +
"      }\n" +
"      */\n" +
"      if (image.width > size) {\n" +
"        image.height *= size / image.width;\n" +
"        image.width = size;\n" +
"      }\n" +
"      var ctx = canvas.getContext(\"2d\");\n" +
"      canvas.width = image.width;\n" +
"      canvas.height = image.height;\n" +
"      ctx.drawImage(image, 0, 0, image.width, image.height);\n" +
"      callback(canvas.toDataURL(\"image/png\"));\n" +
"    };\n" +
"    image.src = URL.createObjectURL(file);\n" +
"\n" +
"  };\n" +
"});\n\n";
    return h1;
    }

}
