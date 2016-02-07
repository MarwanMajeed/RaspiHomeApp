/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Properties;

/**
 *
 * @author Rossmann
 */
public class RSCommand {
    static Properties properties;
    
    RSCommand() 
    {
         try {
            properties = new Properties();
            BufferedInputStream stream = new BufferedInputStream(new FileInputStream("RaspiServ.properties"));
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static String send_data_Slave(String cmd, String IP) {
        String result = "";
        try {
            if (IP.length() > 0) {
                InetAddress ia = InetAddress.getByName(IP);
                int port = 4711;
                String s = cmd;
                byte[] data = s.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, ia, port);
                DatagramSocket toSocket = new DatagramSocket();
                toSocket.send(packet);

                toSocket.receive(packet);
                int len = packet.getLength();
                data = packet.getData();

                result = new String(data, 0, len);
            }
        } catch (IOException e) {
        }
        return result;
    }

    public static String GetData(int Adresse) {

        String ergebnis = send_data_Slave("", "");
        return ergebnis;
    }

}
