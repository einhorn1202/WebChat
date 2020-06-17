package BusinessLogic;

import DataAccessLayer.WebShopDAO;
import TransferObject.ArticleDTO;
import TransferObject.ShoppingCartDTO;

public class Manager_ShoppingCart {
		
		ShoppingCartDTO shoppingCart;
		WebShopDAO dao;
		
		public Manager_ShoppingCart() {
			this.dao = new WebShopDAO();
			this.shoppingCart = this.dao.getShoppingCart();
		}
		
		public ShoppingCartDTO getShoppingCart() {
			return this.shoppingCart;
		}
		
		public void setShoppingCart(ShoppingCartDTO shoppingCart) {
			this.shoppingCart = shoppingCart;
			dao.setShoppingCart(shoppingCart);
		}
		
		public double getTotal() {
			return this.shoppingCart.getTotal();
		}
		
		public void addArticleShoppingCart(ArticleDTO article) {
			this.shoppingCart.getShoppingCartList().add(article);
			this.shoppingCart.setTotal(this.shoppingCart.getTotal() + article.getPrice());
			this.dao.setShoppingCart(this.shoppingCart);
		}
		
		public void removeArticleShoppingCart(ShoppingCartDTO shoppingCart , ArticleDTO article) {
			this.shoppingCart.getShoppingCartList().remove(article);
			this.shoppingCart.setTotal(this.shoppingCart.getTotal() - article.getPrice());
			this.dao.setShoppingCart(shoppingCart);
		}
		
		public void clearShoppingCart() {
			this.shoppingCart.getShoppingCartList().clear();
			this.shoppingCart.setTotal(0d);
			this.dao.setShoppingCart(shoppingCart);
		}
}
