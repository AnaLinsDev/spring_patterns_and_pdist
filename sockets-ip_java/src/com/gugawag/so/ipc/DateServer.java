package com.gugawag.so.ipc;

/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.21
 *
 * @author Silberschatz, Gagne, and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Ninth Edition
 * Copyright John Wiley & Sons - 2013.
 */
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class DateServer{
	public static void main(String[] args)  {
		try {

			ServerSocket sock = new ServerSocket(6013);

			System.out.println("=== Servidor iniciado ===\n");

			while (true) {
				Socket client = sock.accept();
				System.out.println("Servidor recebeu comunicação do ip: " + client.getInetAddress() + "-" + client.getPort());
				System.out.println("Ana Júlia Oliveira Lins - 20191370002");

				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

				try {
					DataOutputStream dos = new DataOutputStream(client.getOutputStream());
					DataInputStream dis = new DataInputStream(client.getInputStream());

					while (true) {
						String mensagemRecebida = dis.readUTF();
						System.out.println("mensagemRecebida: " + mensagemRecebida);
						if (mensagemRecebida.equals("ifconfig")) {
							dos.writeUTF("IP server : " + sock.getInetAddress().getLocalHost());
						}else{
							dos.writeUTF("Tente novamente :)");
						}

					}

				}
				catch (Exception e) {
					pout.println(" Ocorreu um erro, tente novamente !!! ");
				}

				InputStream in = client.getInputStream();
				BufferedReader bin = new BufferedReader(new InputStreamReader(in));

				String line = bin.readLine();
				System.out.println("O cliente me disse:" + line);

				// fechar o socket e volta no loop para escutar novas conexões
				client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
