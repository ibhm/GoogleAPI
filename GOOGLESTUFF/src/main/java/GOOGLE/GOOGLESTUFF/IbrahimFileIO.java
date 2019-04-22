package GOOGLE.GOOGLESTUFF;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import com.google.maps.errors.ApiException;

import GOOGLE.GOOGLESTUFF.*;

public class IbrahimFileIO {
		
		public static void main(String[] args) throws IOException, ApiException, InterruptedException{
		//remember to change this to be private again
		String[][] file = FileIO.importCSV("Street_Network_Database.txt");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Street_Network_Database_new3.txt", true)));		
		//pw.print(file[0][0]+"\t"+file[0][1]+"\t"+file[0][6]+"\t"+"FROM\tTO\n");
 

		
		for(int i = 34034;  i < 34034; i++)
		{
			String[] line = file[i];
			
			//
			int legal = Integer.parseInt(line[13]);
			int streetType = Integer.parseInt(line[6]);
			String city = line[25];
			String ignore = line[24];
			if(streetType < 9 & legal == 1){
				if ((city.equals("SEATAC"))==false){
				 	if((ignore.equals("I5 SB"))==false){
				
				String stName = line[24];  //street name
				 
				//all of the below is literally JUST to get the address range
				Double fromAddress1 = Double.parseDouble(line[16]); 
				Double toAddress1 = Double.parseDouble(line[17]);
				Double fromAddress2 = Double.parseDouble(line[18]);
				Double toAddress2 = Double.parseDouble(line[19]);
				
				Double minAddressFrom = Math.min(fromAddress1, fromAddress2);
				Double maxAddressFrom = Math.max(fromAddress1, fromAddress2);
				
				Double addressTo = Math.max(toAddress1, toAddress2);
				Double addressFrom = minAddressFrom == 0 ? maxAddressFrom : minAddressFrom;
				
				//below code only because GOOGLEAPISTUFF only accepts Strings, and address must end without a decimal point
				int ToINT = addressTo.intValue();
				int FromINT = addressTo.intValue();
				
				String To = String.valueOf(ToINT);
				String From = String.valueOf(FromINT);
				
				//String addTo = addressTo.toString()+" "+stName;
				//String addFrom = addressFrom.toString()+" "+stName;
				
				String addTo = To+" "+stName;
				String addFrom = From+" "+stName;
				//String addFrom = addressFrom.toString()+" "+stName;
				/**
				//*** IBRAHIM's STUFF NEEDS TO CHANGE THE BELOW TWO LINES ***
				//*** Addresses in the following form:
				// "Number StreetName" 
				String from = GOOGLEAPI.Geocode(addTo, line[25], line[26]);
				String to = GOOGLEAPI.Geocode(addFrom,line[25], line[26]);
				
				//String from = "a";
				//String to = "b";
				//pw.append(line[0]+"\t"+line[1]+"\t"+line[6]+"\t"+from+"\t"+to+"\n");**/
					}
				}
			}
		}
		pw.close();
	}
}
