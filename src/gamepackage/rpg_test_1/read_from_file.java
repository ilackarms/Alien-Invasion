package gamepackage.rpg_test_1;

import java.io.File;
import java.util.Scanner;

public class read_from_file extends MainActivity
{
	private Scanner s;
	
	public void open_file()
	{
		try {
			s = new Scanner(new File("Save.txt"));
		}
		
		catch (Exception e){
			MainActivity.appendTextAndScroll("Error reading file");
		}
		
		
	}

	
	public void ReadFile()
	{
		while (s.hasNext()){
			String a = s.next();
			String b = s.next();
			String c = s.next();
			MainActivity.appendTextAndScroll(a+" "+b+" "+c+"\n");
		}
	}
	
	
	
}
