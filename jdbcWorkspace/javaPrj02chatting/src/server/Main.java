package server;

import common.SocketInfo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            System.out.println("클라이언트 대기중...");
            Socket socket = serverSocket.accept();
            System.out.println("연결된 소켓 : " + socket.getInetAddress());
            new SocketInfo(socket);
        }
    }

}