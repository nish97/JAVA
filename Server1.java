/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author nish97
 */
public class Server1 {
    public static void main (String [] args)throws IOException{
        try (DatagramSocket ser = new DatagramSocket(3000)) {
            byte buf [] = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,1024);
            InetAddress ip = InetAddress.getLocalHost();
            int Cport = 8080;
            DatagramPacket ds ;
            String ch="";
            do
            {
                ser.receive(dp);
                String msg = new String(dp.getData(),0,dp.getLength());
                System.out.println("Client:"+msg);
                Scanner s = new Scanner(System.in);
                System.out.print("Server:");
                String reply = s.nextLine();
                ds = new DatagramPacket(reply.getBytes(), reply.length(), ip, Cport);
                ser.send(ds);
                System.out.println("Do you want to Continue(yes/no)");
                ch = s.next();
            }while(ch.equalsIgnoreCase("yes"));
            ch = "20";
            ds = new DatagramPacket(ch.getBytes(),ch.length(),ip,Cport);
            ser.send(ds);
            ser.close();
        }
    }
}
