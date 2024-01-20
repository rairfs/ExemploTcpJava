/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            Scanner teclado = new Scanner(System.in);
            
            while(true) {
                System.out.print("Envie sua mensagem:");
                String msg = teclado.nextLine();
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
    
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                System.out.println("[OK] ]");
                
                byte[] inBuf = new byte[100];
                
                System.out.println("Aguardando mensagem de resposta  ..................  ");
                
                is.read(inBuf);
                String inMsg = new String(inBuf);
                
                System.out.println("Mensagem recebida: " + inMsg);
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}