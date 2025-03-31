package com.bridgelabz.javaIOStreams;
import java.io.*;

public class ByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "image.jpg";
        String outputImagePath = "output.jpg";

        try {
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image processing completed successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fileInput = new FileInputStream(imagePath);
             ByteArrayOutputStream byteOutput = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                byteOutput.write(buffer, 0, bytesRead);
            }
            return byteOutput.toByteArray();
        }
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream byteInput = new ByteArrayInputStream(imageBytes);
             FileOutputStream fileOutput = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = byteInput.read(buffer)) != -1) {
                fileOutput.write(buffer, 0, bytesRead);
            }
        }
    }
}

