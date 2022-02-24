package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class Servidor2 {

    public static void main(String[] args) throws IOException {
        System.out.println("== Servidor ==");

        ServerSocket serverSocket = new ServerSocket(7001);
        Socket socket = serverSocket.accept();

        String basePath = new File("").getAbsolutePath();
        String path = basePath + "\\assets\\diretorio" ;

        File raiz = new File(path);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());



        while (true) {
            System.out.println("Cliente: " + socket.getInetAddress() + " -> Conectado");
            File[] arquivos = raiz.listFiles();

            String mensagem = dis.readUTF();
            try {
                switch (mensagem.toLowerCase()) {

                    case "readdir":
                        System.out.println("Cliente: " + socket.getInetAddress() + " -> Read");
                        List<String> arquivAux = new ArrayList<>();

                        for (File file : arquivos) {
                            arquivAux.add(file.getName());
                        }

                        dos.writeUTF("Arquivos: " + arquivAux.toString());
                        break;

                    case "rename":
                        System.out.println("Cliente: " + socket.getInetAddress() + " -> Rename");
                        String oldNameR = dis.readUTF() + ".txt";
                        String newNameR = dis.readUTF() + ".txt";

                        File oldFileName = new File(path + "/" + oldNameR);
                        File newFileName = new File(path + "/" + newNameR);

                        if (newFileName.exists())
                            throw new java.io.IOException("file exists");

                        oldFileName.renameTo(newFileName);

                        break;

                    case "create":
                        System.out.println("Cliente: " + socket.getInetAddress() + " -> Create");
                        String newArquivo = dis.readUTF() + ".txt";

                        File fileCreate = new File(path + "/" + newArquivo);
                        fileCreate.createNewFile();
                        break;

                    case "remove":
                        System.out.println("Cliente: " + socket.getInetAddress() + " -> Remove");
                        String nameRem = dis.readUTF() + ".txt";

                        File fileRem = new File( path + "/" + nameRem );
                        fileRem.delete();
                        break;

                    default:
                        System.out.println("Escolha outro comando como : readdir rename create remove");
                }
            }catch (Exception e){
                System.out.println("Ocorreu um erro !!");
            }
        }

    }
}
