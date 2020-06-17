package TransferObject;

/**
 * Klasse ArticleDTO stellt ein Transferobjekt dar
 * 
 * @author Gruppe A05
 */

public class ArticleDTO {

	int id, quantity;
	String name;
	double price;
	
	public ArticleDTO (int id, int quantity, String name, double price) {
		this.id = id;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getID() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	
	
}
