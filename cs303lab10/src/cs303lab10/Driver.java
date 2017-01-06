package cs303lab10;

import java.io.BufferedReader;
import java.io.FileReader;

public class Driver {

	public static void main(String[] args){
		System.out.println("HashGet");
		given();
		System.out.println();
		System.out.println("LinearGet");
		linear();
		System.out.println();
		System.out.println("QuadraticGet");
		quadratic();
		System.out.println();
		System.out.println("RedBlackTree");
		redBlack();
	}
	
	public static void given(){
		HashMap t = new HashMap(100);
		
		BufferedReader br = null;
		String line = "";
		String split = ",";
		String[][] table = new String[16][];//table for output
		table[0] = new String[] {"key", "value", "time"};
	 
		try {
			br = new BufferedReader(new FileReader("UPC.csv"));
			while ((line = br.readLine()) != null) {
	 
				String[] value = line.split(split);
	 
				String description = "";
				for (int i = 1; i < value.length; i++){
					if (!value[i].equals("")){
						String s = value[i].trim();
						description += s + " ";
					}
				}
				
				t.hashPut((long) Double.parseDouble(value[0]), description);
	 
			}
			
			br.close();
	 
			br = new BufferedReader(new FileReader("input.dat"));
			//read in upc's from input.dat
			long time = 0;
			int c = 1;
			while ((line = br.readLine()) != null) {
				
				long start = System.nanoTime();
				String s = t.hashGet(Integer.parseInt(line));
				long end = System.nanoTime();
				time += (end-start);
				table[c] = new String[] {line, s, (new Long(end-start)).toString()};
				c++;
				
			}
			//print table of values
			for (Object[] row : table) {
			    System.out.format("%15s%60s%15s\n", row);
			}
			System.out.println("total time for search : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void linear(){
		
		HashMap t = new HashMap(100000000);
		
		BufferedReader br = null;
		String line = "";
		String split = ",";
		String[][] table = new String[16][];//table for output
		table[0] = new String[] {"key", "value", "time"};
	 
		try {
			//read in csv
			br = new BufferedReader(new FileReader("UPC.csv"));
			while ((line = br.readLine()) != null) {
	 
				String[] value = line.split(split);
	 
				String description = "";
				
				for (int i = 1; i < value.length; i++){
					if (!value[i].equals("")){
						String s = value[i].trim();
						description += s + " ";
					}
				}
				
				t.linearProbePut((long) Double.parseDouble(value[0]), description);
	 
			}
			
			br.close();
	 
			br = new BufferedReader(new FileReader("input.dat"));
			//read in upc's from input.dat
			long time = 0;
			int c = 1;
			while ((line = br.readLine()) != null) {
				
				long start = System.nanoTime();
				String s = t.linearProbeGet(Integer.parseInt(line));
				long end = System.nanoTime();
				time += (end-start);
				//add output to table
				table[c] = new String[] {line, s, (new Long(end-start)).toString()};
				c++;
				
			}
			//print table of values
			for (Object[] row : table) {
			    System.out.format("%15s%60s%15s\n", row);
			}
			System.out.println("total time for search : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void quadratic(){
		
		HashMap t = new HashMap(10000000);
		
		BufferedReader br = null;
		String line = "";
		String split = ",";
		String[][] table = new String[16][];//table for output
		table[0] = new String[] {"key", "value", "time"};
	 
		try {
			//read in csv
			br = new BufferedReader(new FileReader("UPC.csv"));
			while ((line = br.readLine()) != null) {
	 
				String[] value = line.split(split);
	 
				String description = "";
				
				for (int i = 1; i < value.length; i++){
					if (!value[i].equals("")){
						String s = value[i].trim();
						description += s + " ";
					}
				}
				
				t.quadraticPut((long) Double.parseDouble(value[0]), description);
	 
			}
			
			br.close();
	 
			br = new BufferedReader(new FileReader("input.dat"));
			//read in upc's from input.dat
			long time = 0;
			int c = 1;
			while ((line = br.readLine()) != null) {
				
				long start = System.nanoTime();
				String s = t.quadraticGet(Integer.parseInt(line));
				long end = System.nanoTime();
				time += (end-start);
				//add output to table
				table[c] = new String[] {line, s, (new Long(end-start)).toString()};
				c++;
				
			}
			//print table of values
			for (Object[] row : table) {
			    System.out.format("%15s%60s%15s\n", row);
			}
			System.out.println("total time for search : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void redBlack(){
		
		RBTree<Long, String> t = new RBTree<>();
		
		BufferedReader br = null;
		String line = "";
		String split = ",";
		String[][] table = new String[16][];//table for output
		table[0] = new String[] {"key", "value", "time"};
	 
		try {
			//read in csv
			br = new BufferedReader(new FileReader("UPC.csv"));
			while ((line = br.readLine()) != null) {
	 
				String[] value = line.split(split);
	 
				String description = "";
				
				for (int i = 1; i < value.length; i++){
					if (!value[i].equals("")){
						String s = value[i].trim();
						description += s + " ";
					}
				}
				
				t.rBInsert((long) Double.parseDouble(value[0]), description);
	 
			}
			
			br.close();
	 
			br = new BufferedReader(new FileReader("input.dat"));
			//read in upc's from input.dat
			long time = 0;
			int c = 1;
			while ((line = br.readLine()) != null) {
				
				long start = System.nanoTime();
				RBNode<Long, String> node = t.search((long)Double.parseDouble(line));
				long end = System.nanoTime();
				time =+ (end-start);
				//add output to table
				table[c] = new String[] {node.key.toString(), node.value, (new Long(end-start)).toString()};
				c++;
				
			}
			//print table of values
			for (Object[] row : table) {
			    System.out.format("%15s%60s%15s\n", row);
			}
			
			System.out.println("total time for search : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

