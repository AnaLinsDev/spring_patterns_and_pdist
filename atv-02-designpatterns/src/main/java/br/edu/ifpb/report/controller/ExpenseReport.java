package br.edu.ifpb.report.controller;

import br.edu.ifpb.report.database.DBConnector;
import br.edu.ifpb.report.database.PostgreSQLDatabaseConnector;

public class ExpenseReport extends ReportAbstract<PostgreSQLDatabaseConnector> {

    private DBConnector<PostgreSQLDatabaseConnector> connector ;

    @Override
    public void createDatabaseConnection() {
        System.out.println("Creating Database Connection...");
        connector.createConnection();
    }

    @Override
    public void executeQuery() {
        System.out.println("Executing Postgres Query...");
        String query = "SELECT * FROM expenses";
        connector.runQuery(query);
    }

    @Override
    public void convert() {
        System.out.println("Converting To XLS...");
    }

	@Override
	public DBConnector<PostgreSQLDatabaseConnector> getConnector() {
		if(connector == null) {
			connector = new PostgreSQLDatabaseConnector();
		}
		return connector;
	}
}
