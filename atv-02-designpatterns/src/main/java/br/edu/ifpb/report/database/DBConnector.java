package br.edu.ifpb.report.database;

public interface DBConnector<DB> {

	public void createConnection();
	public void runQuery(String query);

}
