/**
 *
 *  @author Lesiak Ewa S18256
 *
 */

package zad2;
import java.io.Serializable;
import java.util.Comparator;

public class Purchase implements Comparable<Purchase> {
	String id;
	String name;
	String item;
	double quantity;
	double price;
	
	public Purchase(String id, String name, String item, double quantity, double price){
		this.id = id;
		this.name=name;
		this.item=item;
		this.quantity=quantity;
		this.price=price;
	}
	
	
	public String toString(){
		String s = ";";
		return id + s+ name + s + item +s + quantity + s + price;
		
	}


	
	

	@Override
	public int compareTo(Purchase p2) {
		
		if(this.name.compareTo(p2.name)==0){
			int wynik =Integer.parseInt(this.id.substring(1)) - Integer.parseInt(p2.id.substring(1));	
		return wynik;}
		return this.name.compareTo(p2.name);
	}
	
	
	
}
