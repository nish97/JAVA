/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;

public class FtpServer {
       public static void main(String args[])throws IOException{
         ServerSocket ss = new ServerSocket(8010);
         Socket s = ss.accept();
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         PrintWriter p = new PrintWriter(s.getOutputStream(),true);
         DataInputStream in = new DataInputStream(System.in);
         boolean bo = true;
         while(bo){
            int i = Integer.parseInt(br.readLine());
	    System.out.println(i);
            String st;
            switch(i){
                case 1:{
                     st = br.readLine();
                     System.out.println("Input Filename from client is"+st);
                     DataInputStream inf = new DataInputStream(new FileInputStream(new File(st)));
                     st = br.readLine();
                     System.out.println("Output FileName from client is:"+st);
                     DataOutputStream outf = new DataOutputStream(new FileOutputStream(new File(st)));
                     st = inf.readLine();
                     while(st!=null){
                          outf.writeBytes(st);
                          st = inf.readLine();
                        }
                     System.out.println("File content has been sent to client");
                     break;
                }
                case 2:{
                     System.out.println("Enter the InputFileName from server to client");
                     st = in.readLine();
                     p.println(st);
                     System.out.println("Enter the output File name from server to client");
                     st = in.readLine();
                     p.println(st);
                     break;
                }
                case 3:{
                     bo=false;
                     break;
                } 
            }
         }
       }  
}
