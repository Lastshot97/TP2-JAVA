

import java.io.PrintWriter;

public class Logger {
	// Attributes
	private final static int ALL = 0;
	private final static int DEBUG = 100;
	private final static int INFO = 500;
	private final static int IMPORTANT = 900;
	private final static int OFF = Integer.MAX_VALUE;
	
	private static int level;
	private static PrintWriter flotSortie;

	public Logger(){
		level = DEBUG;
		flotSortie = new PrintWriter(System.err);
	}
	
	public Logger(int level, PrintWriter pw){
		Logger.level = level;
		flotSortie = pw;
	}
	
	public static void log(int level, String message){
		if (level >= Logger.level){
			flotSortie.println(message);
			flotSortie.flush();
			flotSortie.close();
		} 
	}
}
