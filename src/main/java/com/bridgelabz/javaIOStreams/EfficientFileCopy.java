package com.bridgelabz.javaIOStreams;

import java.io.*;

public class EfficientFileCopy {
    private static final int BUFFER_SIZE = 4096; //4KB

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String bufferedDestination = "CopyBuffered.txt";
        String fileStreamDestination = "CopyFileStream.txt";

        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedDestination);
            System.out.println("Buffered Stream Time: " + bufferedTime + " ns");

        long fileStreamTime = copyUsingFileStream(sourceFile, fileStreamDestination);
            System.out.println("File Stream Time: " + fileStreamTime + " ns");
    }
    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return System.nanoTime() - startTime;
    }

    private static long copyUsingFileStream(String source, String destination) {
        long startTime = System.nanoTime();
        try(FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}
