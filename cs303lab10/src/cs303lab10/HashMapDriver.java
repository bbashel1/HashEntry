package cs303lab10;

import java.util.Scanner;

public class HashMapDriver {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("HashMap size = ?: ");
		String ret = s.next();
		HashMap hm = null;
		try {
			int size = Integer.parseInt(ret);
			hm = new HashMap(size);
			System.out.println("New hashmap of size "+Integer.toString(size)+" created.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		while (!ret.equalsIgnoreCase("exit")) {
			System.out.println("'get' or 'put'? : ");
			ret = s.next();
			if (ret.equalsIgnoreCase("get")) {
				int key = -1;
				try {
					System.out.println("Integer Key = ?: ");
					ret = s.next();
					key = Integer.parseInt(ret);
					//System.out.println("String Data = ?: ");
					//ret = s.next();
					//String data = ret;
					//HashEntry he = hm.get(key);
					//System.out.println("returned HashElement with Key = "+Integer.toString(key)+" and value = '"+he.value+"'");
					
				} catch (Exception e) {
					System.out.println("No HashElement with Key = "+Integer.toString(key));
				}
			} else if ( ret.equalsIgnoreCase("put")) {
				try {
					System.out.println("Integer Key = ?: ");
					ret = s.next();
					int key = Integer.parseInt(ret);
					System.out.println("String value = ?: ");
					ret = s.next();
					String value = ret;
					hm.quadraticPut(key, value);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			} else if (ret.equalsIgnoreCase("exit")) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Could not understand input. Try again.");
			}
			System.out.println();
			
		}
		s.close();
		
	}
}
