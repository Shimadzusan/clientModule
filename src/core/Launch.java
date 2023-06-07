package core;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONObject;

import util.DataOperation;

public class Launch {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("..debug clientModule v 1.4");
		
		DataOperation dataOperation = new DataOperation();
		String s = dataOperation.readDataFromFile("resultGlassdoor.csv");
//		System.out.println(s);
		
		String x = "webData={\"login\":\"4566\",\"pass\":\"1111\"}";
		System.out.println(x.substring(8));
		
		JSONObject obj = new JSONObject(x.substring(8));
		System.out.println(obj.getString("login") + " * " + obj.getString("pass"));

	}

}
