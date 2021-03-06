
 //*  @author Lesiak Ewa S18256

 

package zad2;

import java.util.*;
import java.io.BufferedReader;
import java.io.*;





public class CustomersPurchaseSortFind {
	List<Purchase> list;
	
	public CustomersPurchaseSortFind(){
		List<Purchase> purchase = new ArrayList<Purchase>();
		list = purchase;
	}
	
	public void readFile(String s){
		
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);
			while(br.read()!=-1){
				String line = br.readLine();
				String[] tab = line.split(";|\\r\\n|\\\\s");
				
				String id = "c" + tab[0];
				String name = tab[1];
				String item = tab[2];
				double quantity = Double.parseDouble(tab[3]);
				double price = Double.parseDouble(tab[4]);
				this.list.add(new Purchase(id, name, item, quantity, price));
			
			}
				} catch (IOException e) {
			System.out.print("błąd przy wczytywaniu pliku");
			e.printStackTrace();
		}
		
		
	}

	public void showSortedBy(String string) {
		
		System.out.println();
		if(string.equals("Nazwiska")){
			
			
			this.list.sort(null);
			System.out.println("Nazwiska");
			for(int i=0; i<list.size(); i++){
				System.out.println(list.get(i));
			}
		}
		if(string.equals("Koszty")){
			
			class Inner implements Comparable<Inner>{
				Purchase p;
				public Inner(Purchase pr){
					p = pr;
	 
 }
				@Override
				public int compareTo(Inner o1) {
					
					double koszt2 = o1.p.quantity*o1.p.price;
					double koszt1 = this.p.quantity * this.p.price;
					if((koszt2-koszt1)==0){
						int id1 =Integer.parseInt(this.p.id.substring(1)); 
						int id2 = Integer.parseInt(o1.p.id.substring(1));
						return id2-id1;
					}
					return(int) (koszt2 - koszt1);
					
				}
				@Override
				public String toString(){
				return p.toString();	
				}}
			
			ArrayList<Inner> last = new ArrayList<Inner>();
			for(int i =0; i< this.list.size(); i++){
				last.add(new Inner(this.list.get(i)));
			}
			last.sort(null);
			System.out.println("Koszty");
			for(Inner elt : last){
				System.out.println(elt + " (koszt: "+ elt.p.quantity*elt.p.price+ ")" );
			}
		}
			
		
	}

	public void showPurchaseFor(String str) {
		
		System.out.println();
		System.out.println("Klient " + str);
		for(int i = 0; i< this.list.size(); i++){
			if(this.list.get(i).id.equals(str)){
				System.out.println(this.list.get(i));
			}
		}
	}

	

	

	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

