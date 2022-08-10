package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MsgReaderThread extends Thread {

    private final Socket socket;
    private final SocketInfo socketInfo;
    private final BufferedReader reader;
    private boolean flag = true;

    public MsgReaderThread(SocketInfo socketInfo, Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        this.socketInfo = socketInfo;
    }

    @Override
    public void run() {
        try{
            while (flag){
                readMsg();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socketInfo.destroy();
        }
    }

    private void readMsg() throws IOException {
        String msg = null;
        msg = reader.readLine();
        System.out.println(socket.getInetAddress().getHostAddress() + " : " + msg);
    }

    public void destroy() {
        try {
            flag = false;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}