package GOOGLE.GOOGLESTUFF;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class FileIO {
	
	public static String[][] importCSV(String fileName) throws IOException{
        LinkedList<String[]> linkedList = new LinkedList<>();
        String[][] result;
            
		File Street_Network_Database = new File(fileName);		
		
		BufferedReader br;
		FileReader fr;
        String regex = "\t";
		
		fr = new FileReader(Street_Network_Database);
		br = new BufferedReader(fr);

		String Parking_Lot_Info_Line;
                        
        br.readLine(); //deals with the title row
		while (( Parking_Lot_Info_Line = br.readLine()) != null) {
			String[] line = Parking_Lot_Info_Line.split(regex);
            linkedList.add(line);  
        }			
        result = linkedList.toArray(new String[linkedList.size()][]);
		
        return result;		
	}

}
