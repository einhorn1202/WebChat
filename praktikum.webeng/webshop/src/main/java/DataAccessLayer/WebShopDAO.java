package DataAccessLayer;
import java.util.ArrayList;

import TransferObject.ArticleDTO;
import TransferObject.ShoppingCartDTO;

public class WebShopDAO {

	ArrayList<ArticleDTO> articleList;
	ArticleDTO article;
	ShoppingCartDTO shoppingCart;

	public WebShopDAO(){
		
		shoppingCart = new ShoppingCartDTO();
		
		this.articleList = new ArrayList<ArticleDTO>();
		
		this.articleList.add(new ArticleDTO(1, 100, "Biene", 19.99));
		this.articleList.add(new ArticleDTO(2, 200, "Hummel", 3.50));
		this.articleList.add(new ArticleDTO(3, 300, "Wespe", 7.99));
		this.articleList.add(new ArticleDTO(4, 400, "Hornisse", 9.99));

		this.article = new ArticleDTO(5, 200, "Krokodil", 19.99);
	}
	
	public ArrayList<ArticleDTO> getArticleList() {
		return this.articleList;
	}
	
	public void setArticleList(ArrayList<ArticleDTO> articleList) {
		this.articleList = articleList;
	}

	public ArticleDTO getArticle(){
		return this.article;
	}
	
	public void setArticle(ArticleDTO article){
		this.article = article;
	}
	
	public ShoppingCartDTO getShoppingCart() {
		return this.shoppingCart;
	}
	
	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
