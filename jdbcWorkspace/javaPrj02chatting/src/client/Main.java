package client;

import common.SocketInfo;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 12345);

        SocketInfo socketInfo = new SocketInfo(socket);



    }

}