/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4a;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;
public class Ex4a {

    private final String USER_AGENT="Mozilla/5.0";   
    public static void main(String[] args)throws Exception {
        Ex4a http = new Ex4a();
        System.out.println("Testing1-send htp get request");
        http.sendget();
        System.out.println("Testing2-send http post request");
        http.sendpost();
    }
    private void sendget()throws Exception{
        String url="http://www.google.com";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("USER_AGENT", USER_AGENT);
        int responsecode = con.getResponseCode();
        System.out.println("\nSENDING GET request to URL"+url);
        System.out.println("Responsecode:"+responsecode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputline;
        StringBuffer response = new StringBuffer();
        while((inputline=in.readLine())!=null){
          response.append(inputline);
        }
        in.close();
        System.out.println(response.toString());
    }
    private void sendpost()throws Exception{
        String url="https://www.javatpoint.com/DatagramSocket-and-DatagramPacket";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User_agent",USER_AGENT);
        con.setRequestProperty("Accept-language","en-us,en;q=0.5");
        String urlparameters = "?tab=wm#inbox/15cs33foe66cuef67";
        con.setDoOutput(true);
        try (DataOutputStream ur = new DataOutputStream(con.getOutputStream())) {
            ur.writeBytes(urlparameters);
            ur.flush();
        }
        int responsecode = con.getResponseCode();
        System.out.println("\nSENDING'POST'request to URL"+url);
        System.out.println("post parameters:"+urlparameters);
        System.out.println("responsecode:"+responsecode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputline;
        StringBuilder response = new StringBuilder();
        while((inputline=in.readLine())!=null){
           response.append(inputline);
        }
        in.close();
        System.out.println(response.toString());
    }   
    
}
