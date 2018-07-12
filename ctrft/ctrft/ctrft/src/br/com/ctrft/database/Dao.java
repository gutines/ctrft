package br.com.ctrft.database;

public interface Dao {
		
	public void startEntityManager();
	
	public void clearEntityManager();
	
	public void commit();

	
}
