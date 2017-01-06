package cs303lab10;

public class HashMap {
	public int size;
	HashEntry[] he;
	
	public HashMap(int size){
		this.size = size;
		he = new HashEntry[this.size];
	}
	
	/////////////////////////////////////////////////////
	/**
	 * HashFunction for putting
	 * @param key
	 * @return index
	 */
	public void hashPut(long key, String value){
		HashEntry h = new HashEntry(key, value);
		int index =(int) key % this.size;
		if(he[index]== null || he[index].key == h.key){
			he[index]= h;
		}
		else{
			int nIndex = (7 * index + 1) % this.size;
			
		while (he[index] != null && he[index].key !=h.key) {
			nIndex = (7*index+1) % this.size;
		}
			he[nIndex]= h;
	}
}
	
	/**
	 * HashFunction for getting
	 * @param key
	 * @return index
	 */
	public String hashGet(long key){

		int index = (int)(key % this.size);
		
		if (he[index] == null){
			return null;
		}
		else if (he[index].key == key){
			return he[index].value;
		}
		else {
			int nIndex = (7 * index + 1) % this.size;
			while (he[nIndex] != null && he[nIndex].key != key){
				nIndex = (7 * nIndex + 1) % this.size;
			}
				return he[nIndex].value;
		}
	}
	///////////////////////////////////////////////////////////
	
	////////////////////////LINEAR/////////////////////////////
	/**
	 * LinearProbe for putting
	 * @param key
	 * @return index
	 */
	public void linearProbePut(long key, String value){
		HashEntry h = new HashEntry(key, value);
		int index = (int)(key % this.size);
		
		if (he[index] == null || he[index].key == h.key){
			he[index] = h;
		}
		else {
			int offset = 1;
			int nIndex = index;
			while (he[nIndex] != null && he[nIndex].key != h.key){
				nIndex = nIndex + offset % this.size;
				offset++;
			}
			he[nIndex] = h;
		}
	}
	/**
	 * LinearProbe for getting
	 * @param key
	 * @return index
	 */
	public String linearProbeGet(long key){

		int index = (int)(key % this.size);
		
		if (he[index] == null){
			return null;
		}
		else if (he[index].key == key){
			return he[index].value;
		}
		else {
			int offset = 1;
			int nIndex = index;
			while (he[nIndex] != null && he[nIndex].key != key){
				nIndex = (nIndex + offset) % this.size;
				offset++;
			}
			return he[nIndex].value;
		}
	}
	/////////////////////////////////////////////
	public void quadraticPut(long key, String value){
		HashEntry h = new HashEntry(key, value);
		int index = (int)(key % this.size);
		
		if(he[index]== null || he[index].key ==h.key){
			he[index] = h;
		}
		else{
			int offset = 1;
			int nIndex = index;
			while (he[nIndex] != null && he[nIndex].key != h.key){
				nIndex = (nIndex + (int)Math.pow(offset,2)) % this.size;
				offset++;
			}
			he[nIndex] = h;
		}
	}
	public String quadraticGet(long key){
		int index = (int)(key % this.size);
		if(he[index] == null){
			return null;
		}
		else if(he[index].key == key){
			return he[index].value;
		}
		else{
			int offset = 1;
			int nIndex = index;
			while(he[nIndex] != null && he[nIndex].key != key){
				nIndex = (nIndex + (int)Math.pow(offset,2)) %this.size;
				offset++;
			}
			return he[nIndex].value;
		}
		
	}

	
	
}