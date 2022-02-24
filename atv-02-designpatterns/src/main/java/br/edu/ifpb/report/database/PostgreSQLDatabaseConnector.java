package br.edu.ifpb.report.database;

public class PostgreSQLDatabaseConnector implements DBConnector<PostgreSQLDatabaseConnector>{
	
	
    public void createConnection() {
        System.out.println("Create postgres connetion");
    }

    public void runQuery(String query) {
        System.out.println("Run SQL query");
    }

}
