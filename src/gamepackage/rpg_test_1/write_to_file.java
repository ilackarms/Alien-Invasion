package gamepackage.rpg_test_1;

import java.util.Formatter;

public class write_to_file extends MainActivity
{
	public String Test_String;
	private Formatter x;

	
	
	public void OpenFile(){
		try{
		x = new Formatter("Save.txt");
		}
		catch (Exception e){
			MainActivity.appendTextAndScroll("Error writing file.\n");
		}
	
	}
	
	public void save_player()
	{
		String format="%d";
		int args = 5;
		x.format(format,args);
	}
	
	public void close_file()
	{
		x.close();
	}

}
