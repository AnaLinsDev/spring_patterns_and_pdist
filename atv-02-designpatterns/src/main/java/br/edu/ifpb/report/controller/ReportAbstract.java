package br.edu.ifpb.report.controller;

import br.edu.ifpb.report.database.DBConnector;

public abstract class ReportAbstract<DB> {
	
    public final void generate() {
        createDatabaseConnection();
        executeQuery();
        convert();
    }

    public abstract DBConnector<DB> getConnector() ;
    
    public abstract void createDatabaseConnection();
    public abstract void executeQuery();
    public abstract void convert();

}