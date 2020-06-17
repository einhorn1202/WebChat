package TransferObject;

import java.util.ArrayList;

/**
 * Klasse ShoppingCartDTO stellt ein 
 * @author GruppeA05
 *
 */
public class ShoppingCartDTO{
    
	ArrayList<ArticleDTO> shoppingCartList;
	double total;
	
	public ShoppingCartDTO(){
		this.shoppingCartList = new ArrayList<ArticleDTO>();
		this.total = 0d;
	}

	public void setShoppingCart(ArrayList<ArticleDTO> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}

	public ArrayList<ArticleDTO> getShoppingCartList() {
		return this.shoppingCartList;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return this.total;
	}
	
}
