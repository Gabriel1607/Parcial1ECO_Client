package com.example.parcial1_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSingleton extends Thread {

    //SINGLETON
    private static TCPSingleton onlyInstance;

    public static TCPSingleton getInstance(){
        if (onlyInstance == null){
            onlyInstance = new TCPSingleton();
            onlyInstance.start();
        }
return onlyInstance;
    }
   private TCPSingleton() {}
    //FIN SINGLETON
    private Socket socketcito;
    private BufferedWriter escritorcito;
    private BufferedReader lectorcito;
    @Override
    public void run(){
        try {
            //Paso 2: Enviar solicitud de conexion
            socketcito = new Socket("192.168.1.6",6969);
            //Paso 3: Cliente y server conectados
            System.out.println("Se ha conectado al servidor!!!");

            InputStream is = socketcito.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            lectorcito = new BufferedReader(isr);

            OutputStream os = socketcito.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            escritorcito = new BufferedWriter(osw);

            while(true) {
                System.out.println("Esperando mensaje....");
                String line = lectorcito.readLine();
                System.out.println("Recibido: " + line);


            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void sendMessage(String msg) {
        new Thread(
                ()->{
                    try {
                        escritorcito.write(msg+"\n");
                        escritorcito.flush();

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
