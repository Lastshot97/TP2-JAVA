

import java.io.PrintWriter;

public class Logger {
	// Attributes
	private final static int ALL = 0;
	private final static int DEBUG = 100;
	private final static int INFO = 500;
	private final static int IMPORTANT = 900;
	private final static int OFF = Integer.MAX_VALUE;
	
	private int level;
	private PrintWriter flotSortie;

	public Logger(){
		level = DEBUG;
		flotSortie = new PrintWriter(System.err);
	}
	
	public Logger(int level, PrintWriter pw){
		this.level = level;
		flotSortie = pw;
	}
	
	public void log(int level, String message){
		if (level >= this.level){
			flotSortie.println(message);
			flotSortie.flush();
			flotSortie.close();
		} 
	}
	
	public static void main(String[] args) {
		Logger log = new Logger();
		log.log(150, "le joueur 1 � gagn�");
	}

}
