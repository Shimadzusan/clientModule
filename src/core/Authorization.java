package core;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import util.DataOperation;

@WebServlet("/Authorization")
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int counter = 0;
	DataOperation dataOperation = new DataOperation();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.counter++;
		System.out.println("..simple counter: " + counter);
		System.out.println("I am servlet_one ...method GET");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		String data = request.getParameter("facture");				//income data from js
		response.getWriter().write(data + " my note from web..");	//send data to js	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.counter++;
		System.out.println("..simple counter: " + counter);
		System.out.println("I am AuthorizationServlet ...method POST");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		String data = request.getParameter("webData");
		System.out.println(data);
		/*
		 * get data from web {"login":"4566","pass":"1111"}
		 * parse in servlet
		 * write to file accounts.csv
		 * */
		
		System.out.println(data.toString());
		JSONObject obj = new JSONObject(data.toString());
//		JSONArray obj = new JSONArray(data.substring(8).toString());
		System.out.println(obj.getString("login") + " * " + obj.getString("pass"));
//		System.out.println(obj.getString(0) + " * " + obj.getString(0));
		//C:\\Users\\user\\eclipse-workspace\\clientModule\\
		String s = dataOperation.readDataFromFile("resources\\accounts.csv");
		//C:\\Users\\user\\eclipse-workspace\\clientModule\\
		dataOperation.writeDataToFile("accounts.csv", s + (obj.getString("login") + ";" + obj.getString("pass")));
		
//		dataOperation.writeDataToFile("C:\\Users\\user\\eclipse-workspace\\clientModule\\accounts.csv", (obj.getString(0) + ";" + obj.getString(1)));
		System.out.println("AuthorizationServlet, data to accounts file added");
//		response.getWriter().write(data + " my note from web ...");	
//		response.getWriter().write(s);	
	}

}
