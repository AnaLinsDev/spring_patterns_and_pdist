package br.edu.ifpb.padroes.storewebv3.command;

import java.util.ArrayList;
import java.util.List;


public class CommandFila {

    private List<Command> history = new ArrayList<>();

    public void add(Command c) {
    	int size = history.size();
        history.add(size + 1, c);
    }

    public Command rem() {
        return history.remove(0);
    }
    
    public List<Command> get_history(){
    	return history;
    }

    public boolean isEmpty() {
    	return history.isEmpty(); 
    }
}

