package com.bridgelabz.javaIOStreams;
import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/bridgelabz/javaIOStreams/studentsData.bin";

        // Store student details in a binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(1568);
            dos.writeUTF("Yagyata Sharma");
            dos.writeDouble(4.35);

            dos.writeInt(2021);
            dos.writeUTF("Loveleen Goyal");
            dos.writeDouble(4.25);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }

        // Retrieve student details from the binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}
