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
import java.io.File;
import java.io.RandomAccessFile;

public class TailN {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        TailN tailN = new TailN();
        File file = new File("C:\\Data\\CamsDiag\\DataBackUp\\mmanolas\\a9\\TEMP_a9\\a9.js");
        tailN.readFromLast(file);

        System.out.println("Execution Time : " + (System.currentTimeMillis() - startTime));

    }

    public void readFromLast(File file) throws Exception {
        int lines = 10;
        int readLines = 0;
        StringBuilder builder = new StringBuilder();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            long fileLength = file.length() - 1;
            // Set the pointer at the last of the file
            randomAccessFile.seek(fileLength);

            for (long pointer = fileLength; pointer >= 0; pointer--) {
                randomAccessFile.seek(pointer);
                char c;
                // read from the last, one char at the time
                c = (char) randomAccessFile.read();
                // break when end of the line
                if (c == '\n') {
                    readLines++;
                    if (readLines == lines)
                        break;
                }
                builder.append(c);
                fileLength = fileLength - pointer;
            }
            // Since line is read from the last so it is in reverse order. Use reverse
            // method to make it correct order
            builder.reverse();
            System.out.println(builder.toString());
        }

    }
}
