package cl.security.controller;

import cl.security.database.DataBaseUtil;

public class ThreadProcessFile implements Runnable{
	
	private IControllerFileStrategy strategy;
	
	DataBaseUtil dbUtil;
	
	public ThreadProcessFile(IControllerFileStrategy pf) {
		this.strategy = pf;
	}
	
	@Override
	public void run() {
		
		dbUtil = new DataBaseUtil();
		
		dbUtil.dropTableIfExists(strategy.getFileName());
		dbUtil.createTable(strategy.getFileName(), strategy.getHeader());
		dbUtil.insertInto(strategy.getFileName(), strategy.getDataAsList());
		
	}

}
