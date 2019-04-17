package service;

import java.io.*;

import java.util.Scanner;

import dao.DAO;

public class Servcises implements DAO {

		/* ADD Method */
		
	public int add(String id,String name,String age) {
		int i=0;
		try {
			
			String eId=id;
			String eName=name;
			String eAge=age;
			String filepath= "readwrite.txt";
			
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw); 
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(eId+","+eName+","+eAge);
			pw.flush();
			pw.close();
			
			System.out.println("Record Saved....!");
			return ++i;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Record Not Saved");
			return i;
		}
		
	}

			/* Delete Method */
	
	
	public int delete(String removeTerm) {

		String filepath = "readwrite.txt";
		String tempFile = "temp.txt";
		String ID = "";
		String name ="";
		String age = "";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		try {
			
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				ID = x.next();
				name = x.next();
				age = x.next();
				
				if (!ID.equals(removeTerm)) {
					
					pw.println(ID+","+name+","+age);
					
					
				}
				x.close();
				pw.flush();
				pw.close();
				oldFile.delete();
				File dump = new File(filepath);
				newFile.renameTo(dump);
				System.out.println("Record Deleted....!");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}

		/*Update Method*/
	
	
	public int update(String editTerm, String newID, String newName, String newAge) {
	
		String tempFile = "temp.txt";
		String filepath = "readwrite.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String ID = "";
		String name = "";
		String age = "";
		
		try {
			

			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				ID = x.next();
				name = x.next();
				age = x.next();
				if(ID.equals(editTerm)) {
					
					pw.println(newID + "," +  newName + "," + newAge);
				}
				else
				{
					pw.println(ID + "," + name + "," +age);
				}
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump  = new File(filepath);
			newFile.renameTo(dump);
			System.out.println("Record Updated.....!");
			
		} catch (Exception e) {

			System.out.println("Record Not Updated");
		}
		
		return 0;
	}

		/* Search Method */
	
	
	public int search(String searchTerm) {

		boolean found = false;
		String fielpath = "readwrite.txt";
		String ID = "";
		String name1 ="";
		String age = "";

		try {
			
			Scanner x;
			x = new Scanner(new File(fielpath));
			x.useDelimiter("[,\n]");
			
			while (x.hasNext() && !found) {
				
				ID = x.next();
				name1 = x.next();
				age = x.next();
				
				if (ID.equals(searchTerm)) {
					
					found = true;
				}
				if (found) {
					System.out.println("Record Found....!");
					System.out.println("ID:"+ID+" Name:"+name1+" Age:"+age);
					
				}
				else {
					System.out.println("Record Not Found....!");
				}
			}
			x.close();
			
			
		} catch (Exception e) {
			
		}
		
		return 0;
	}



}

