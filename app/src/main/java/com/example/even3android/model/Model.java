package com.example.even3android.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//a class which connects to the flight simulator (the FlightGear app) with ip/port and sends commands of movement it gets from ViewModel.
public class Model {
    private BlockingQueue<String> queueCommands=new LinkedBlockingQueue<String>();
    //function which get ip and port and connects to FlightGear and then take command from queue and sends to FlightGear app
    public void connect(String ip,String port) throws IOException {
        Thread thread = new Thread(){
            public void run(){
                InetAddress inetAddress= null;
                try {
                    inetAddress = InetAddress.getByName(ip);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                int portInt=Integer.parseInt(port);
                Socket fg= null;
                try {
                    //connects to the flight simulator with ip/port
                    fg = new Socket(inetAddress, portInt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PrintWriter out= null;
                try {
                    out = new PrintWriter(fg.getOutputStream(),true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        // take() blocks, so no busy waiting
                        out.print(queueCommands.take());
                        out.flush();
                    } catch (Exception e) {}
                }
            }
        };
        thread.start();
    }
    //add to queue a command of movement
    public void addCommand(String newCommand) {
        queueCommands.add(newCommand);
    }

}

