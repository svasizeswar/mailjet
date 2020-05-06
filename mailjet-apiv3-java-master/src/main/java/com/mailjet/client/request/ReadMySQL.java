package com.mailjet.client.request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadMySQL {
	
	private static final String url = "jdbc:mysql://sgp86.siteground.asia:3306/exemplif_client_backup?serverTimezone=UTC"; 
	
	//private static final String url = "jdbc:mysql://localhost:3306/test"; 
	
	private static final String user = "exemplif_vasi";
	
	private static final String password = "vasi@eswar1"; 
	
	// JDBC variables for opening and managing connection 
	private static Connection con; 
	
	private static Statement preparedStatement; 
	
	//private static ResultSet rs = null; 
	public JSONArray agencyLeads() {   
		
		JSONArray agencyArray = new JSONArray();

		String query = "select id, FirstName, LastName, Company, Email from AgencyLeads"; 
		try { // opening database connection to 
			 con = DriverManager.getConnection(url, user, password); 
			 preparedStatement = con.createStatement(); // executing SELECT 
	  
			 ResultSet rs = preparedStatement.executeQuery(query);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String first = rs.getString("FirstName");
		         String last = rs.getString("LastName");
		         String email = rs.getString("Email");
		         String Company = rs.getString("Company");
		         
		         String name = first+" "+last;
		         
		         JSONObject propObjects = new JSONObject();
		         propObjects.put("name", name);
		         propObjects.put("firstname", first);
		         propObjects.put("lastname", last);
		         propObjects.put("company", Company);
		         
		         JSONObject agencyObjects = new JSONObject();
		         agencyObjects.put("Email", email);
		         agencyObjects.put("Name", name);
		         agencyObjects.put("IsExcludedFromCampaigns", "false");
		         agencyObjects.put("Properties", propObjects);
		         
		         agencyArray.put(agencyObjects);

		       
		      }
		      rs.close();
 
				 
   
 	    } 
		catch (Exception sqlEx) { 
			
				sqlEx.printStackTrace(); 
			
		} finally {
				//try { con.close(); } catch(SQLException se) {   } 
				try { preparedStatement.close(); } catch(SQLException se) { /*can't do anything */ } 
		}
		
		return agencyArray;
	}
	
}

		
 