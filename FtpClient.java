/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4a;

import java.io.*;
import java.net.*;
public class FtpClient {
    public static void main(String args[])throws IOException{
       Socket s = new Socket("localhost",8010);
       BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));
       PrintWriter p = new PrintWriter(s.getOutputStream());
       DataInputStream in = new DataInputStream(System.in);
       boolean bo= true ;
       while(bo){
          System.out.println("ENter the choice \n1.Getting the file content\n2.Sending the file content\n3.Exit");
          int i = Integer.parseInt(in.readLine());
          p.println(i);
          String st;
          switch(i){
              case 1:{
                   System.out.println("Enter the InputFileName from client to server");
                   st = in.readLine();
                   p.println(st);
                   break;
                 }
              case 2:{
                   st= br.readLine();
                   System.out.println("Input FIlename from Server is:"+st);
                   DataInputStream inf = new DataInputStream(new FileInputStream(new File(st)));
                   st = br.readLine();
                   System.out.println("Output Filename from Server is:"+st);
                   DataOutputStream outf = new DataOutputStream(new FileOutputStream(new File(st)));
                   st = inf.readLine();
                   while(st!=null){
                      outf.writeBytes(st);
                      st = inf.readLine();
                      System.out.println("File content has been sent to server");
                     }                           
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
