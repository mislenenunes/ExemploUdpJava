package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            String msg = "Olá!!!";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");
            
            //Recebendo mensagem
            byte[] bufrecebendo = new byte[20];
            DatagramPacket packrecebendo = new DatagramPacket(bufrecebendo, bufrecebendo.length);

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(packrecebendo);
            System.out.println("[OK] ]");
            
            byte[] received_data = packrecebendo.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = packrecebendo.getAddress();
            int origin_port = packrecebendo.getPort();
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}