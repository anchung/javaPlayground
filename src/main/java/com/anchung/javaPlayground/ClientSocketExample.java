package com.anchung.javaPlayground;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketExample {
    public static void main(String[] args) {
        try(Socket socket = new Socket("www.google.com", 80)) {
            socket.setSoTimeout(5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            //pw.print("GET / HTTP/1.0\r\n");
            //pw.println();

            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();

            FileWriter fw = new FileWriter("/tmp/google.html", false);
            fw.append(sb);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
