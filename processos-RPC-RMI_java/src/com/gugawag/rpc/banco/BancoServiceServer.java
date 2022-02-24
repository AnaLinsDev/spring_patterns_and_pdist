package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta("1", (double) 100));
        contas.add(new Conta("2", (double) 200));
        contas.add(new Conta("3", (double) 300));
        contas.add(new Conta("4", (double) 400));
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        for (Conta c : contas) {
            if( c.getNumero().equals(numero) ){
                return c.getSaldo();
            }
        }
        return 0;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public String criarConta(String numero, Double saldo) throws RemoteException {
        for (Conta c : contas) {
            if( c.getNumero().equals(numero) ){
                return "Conta já existe :c";
            }
        }
        contas.add(new Conta(numero, saldo));
        return "Conta criada com sucesso !";
    }

    @Override
    public List<String> pesquisarContas() throws RemoteException {
        List<String> contasString = new ArrayList<>();

        for (Conta c : contas) {
            contasString.add(c.toString());
        }

        return contasString;
    }

    @Override
    public String removerrConta(String numero) throws RemoteException {
        for (Conta c : contas) {
            if( c.getNumero().equals(numero) ){
                contas.remove(c);
                return "Removido com Sucesso";
            }
        }
        return "Ocorreu um problema :c";
    }


}
