/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author nish97
 */
public class Client {
    public static void main (String [] args)throws IOException{
        try (DatagramSocket cli = new DatagramSocket(8080)) {
            byte buf [] = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,1024);
            InetAddress ip = InetAddress.getLocalHost();
            int Sport = 3000;
            DatagramPacket ds ;
            String ch="";
            String e="";
            do{
                Scanner s = new Scanner(System.in);
                System.out.print("Client:");
                String reply = s.nextLine();
                ds = new DatagramPacket(reply.getBytes(), reply.length(), ip, Sport);
                cli.send(ds);
                cli.receive(dp);
                String msg = new String(dp.getData(),0,dp.getLength());
                System.out.println("Server:"+msg);
                System.out.println("Do you want to reply(yes/no)");
                ch = s.next();
                cli.receive(dp);
                e = new String(dp.getData(),0,dp.getLength());
                if(e.equals("20")){
                System.out.println("Server is Offline...");
                ch = " ";
                }
            }while(ch.equalsIgnoreCase("yes"));    
            cli.close();
        }
    }
}
