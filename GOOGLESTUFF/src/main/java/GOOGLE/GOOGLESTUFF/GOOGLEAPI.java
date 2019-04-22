package GOOGLE.GOOGLESTUFF;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import geo.google.GeoAddressStandardizer;
import geo.google.datamodel.GeoAddress;
import geo.google.datamodel.GeoCoordinate;

public class GOOGLEAPI{
	
	public static String Location(double a, double b) throws ApiException, InterruptedException, IOException{
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBBqdKvyXB7h-pfQl0OolfxNThB3KZO_6g"
).build();
		//double a2 = Double.parseDouble(a);
		//double b2 = Double.parseDouble(b);
	    LatLng latlng = new LatLng(a, b);
	    GeocodingResult[] results = GeocodingApi.newRequest(context).latlng(latlng).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String Location = gson.toJson(results[0].formattedAddress);
		return Location;
	}
	
	/**
	public static String GOOGLEAPISTUFF(String address, String City, String State) throws ApiException, InterruptedException, IOException{
		String address2 = (address + " "+ City +" "+ State);
		//String address2 = (address + "Seattle WA");
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDyWlXPtOMcT2lsMylwTKGu0lhevkE_Io4"
).build();
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		   address2).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//results2 = gson.toJson(results[0].addressComponents);
		//System.out.println(gson.toJson(results[0].addressComponents));
		String lataddFrom = gson.toJson(results[0].geometry.location.lat);
		String lngaddFrom = gson.toJson(results[0].geometry.location.lng);
		String Coord = (lataddFrom+", "+lngaddFrom);
		return Coord;
	}**/
	
	
	
	public static String LatAPI(String address) throws ApiException, InterruptedException, IOException{
		String address2 = (address + "Seattle WA USA");
		//String address2 = (address);
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDyWlXPtOMcT2lsMylwTKGu0lhevkE_Io4"
).build();
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		   address2).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//results2 = gson.toJson(results[0].addressComponents);
		//System.out.println(gson.toJson(results[0].addressComponents));
		String lat= gson.toJson(results[0].geometry.location.lat);
		return lat;
	}
	
	public static String LngAPI(String address) throws ApiException, InterruptedException, IOException{
		String address2 = (address + "Seattle WA USA");
		//String address2 = (address);
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDyWlXPtOMcT2lsMylwTKGu0lhevkE_Io4"
).build();
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		   address2).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//results2 = gson.toJson(results[0].addressComponents);
		//System.out.println(gson.toJson(results[0].addressComponents));
		String lng= gson.toJson(results[0].geometry.location.lng);
		return lng;
	}
	
	public static String Test(String address, String post) throws ApiException, InterruptedException, IOException{
		//address = "22615 1st Ave";
		//post = "98121";
		String address2 = (address + "Seattle WA USA");
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDyWlXPtOMcT2lsMylwTKGu0lhevkE_Io4"
).build();
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		   address2).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//results2 = gson.toJson(results[0].addressComponents);
		//System.out.println(gson.toJson(results[0].addressComponents));
		String lng= gson.toJson(results[0].geometry.location.lat);
		return lng;
	}
	
	public static void main(String[] args) throws ApiException, InterruptedException, IOException{
		String lat = LatAPI("2615 1st Ave");
		String lng = LngAPI("2615 1st Ave");
		String test = Test("2615 1st Ave", "98121");
		//System.out.println("Spot is " + spot);
		System.out.println("bitch ass you at "+ lat + lng + " " + test );
	}
	
	/**
	
	public static void main(String[] args) throws ApiException, InterruptedException, IOException{
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		String spot = Location(a, b);
		//System.out.println("Spot is " + spot);
		System.out.println("bitch ass you at "+ spot);
	}
	
	/**
	//This code below is only to verify that the function above will work and produce addFrom, when addTo is given to it
    public static void main(String[] args) throws ApiException, InterruptedException, IOException
    {
    	String addto = "1435 14TH STREET NE";
    	String city = "Auburn";
    	String state = "WA";
    	//String addto = args[0]+args[1]+args[2]+args[3]+args[4]+args[5];
    	String Result = GOOGLEAPISTUFF(addto, city, state);
        System.out.println(Result);
    }
    /**
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ApiException 
    
    public static void main(String[] args ) throws ApiException, InterruptedException, IOException{
	GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCiNoDpre_XOIgY4dW1_8-IRu4H70-GXrA").build();
	String addto = args[0]+args[1]+args[2]+args[3]+args[4]+args[5];
	GeocodingResult[] results =  GeocodingApi.geocode(context,
	   addto).await();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	//results2 = gson.toJson(results[0].addressComponents);
	System.out.println(gson.toJson(results[0].geometry.location.lat));//prints out lat only
    }*/
}