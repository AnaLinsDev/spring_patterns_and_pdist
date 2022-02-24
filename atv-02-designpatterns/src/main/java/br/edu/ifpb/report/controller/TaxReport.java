package br.edu.ifpb.report.controller;

import br.edu.ifpb.report.database.DBConnector;
import br.edu.ifpb.report.database.MysqlDatabaseConnector;


public class TaxReport extends ReportAbstract<MysqlDatabaseConnector>{

    private DBConnector<MysqlDatabaseConnector> connector ;
    
    @Override
    public void createDatabaseConnection() {
        System.out.println("Creating Database Connection...");
        connector.createConnection();
    }

    @Override
    public void executeQuery() {
        System.out.println("Executing MySQL Query...");
        String query = "SELECT * FROM taxes";
        connector.runQuery(query);
    }

    @Override
    public void convert() {
        System.out.println("Converting To PDF...");
    }

	@Override
	public DBConnector<MysqlDatabaseConnector> getConnector() {
		if(connector == null) {
			connector = new MysqlDatabaseConnector();
		}
		return connector;
	}
		
}
