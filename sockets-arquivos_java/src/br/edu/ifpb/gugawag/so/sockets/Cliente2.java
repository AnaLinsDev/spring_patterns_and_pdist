package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {

    public static void main(String[] args) throws IOException {
        System.out.println("== Cliente ==");


        Socket socket = new Socket("127.0.0.1", 7001);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        while (true) {
            System.out.println("Escreva o commando: ");
            Scanner teclado = new Scanner(System.in);
            String command = teclado.nextLine() ;
            dos.writeUTF(command);
            try {
                switch (command){

                    case "readdir":
                        String mensagem = dis.readUTF();
                        System.out.println(mensagem);
                        break;

                    case "rename":
                        System.out.println("Arquivo original: ");
                        dos.writeUTF(teclado.nextLine());

                        System.out.println("Novo nome do arquivo: ");
                        dos.writeUTF(teclado.nextLine());
                        break;

                    case "create":
                        System.out.println("Nome do novo arquivo: ");
                        dos.writeUTF(teclado.nextLine());
                        break;

                    case "remove":
                        System.out.println("Escolha o nome: ");
                        dos.writeUTF(teclado.nextLine());
                        break;

                    default: System.out.println("Escolha outr comando como : readdir rename create remove" );
            }
            }catch (Exception e){
                System.out.println("Ocorreu um erro !!");
            }
        }

    }
}
