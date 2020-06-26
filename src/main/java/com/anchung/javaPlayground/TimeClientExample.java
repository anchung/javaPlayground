package com.anchung.javaPlayground;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClientExample {
    public static void main(String[] args) {
//        try(Socket socket = new Socket("www.google.com", 80)) {
        try(Socket socket = new Socket("localhost", 13)) {
            socket.setSoTimeout(5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            System.out.println("Server Time: " + sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
