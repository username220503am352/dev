package common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgSenderThread extends Thread {

    private final Socket socket;
    private final SocketInfo socketInfo;
    private final PrintWriter writer;
    private final Scanner sc = new Scanner(System.in);
    private boolean flag = true;


    public MsgSenderThread(SocketInfo socketInfo, Socket socket) throws IOException {
        this.socket = socket;
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        this.socketInfo = socketInfo;
    }

    @Override
    public void run() {
        try{
            while (flag){
                sendMsg();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socketInfo.destroy();
        }
    }

    private void sendMsg(){
        String inputMsg = sc.nextLine();
        writer.println(inputMsg);
        writer.flush();
    }

    public void destroy() {
        flag = false;
        writer.close();
    }
}