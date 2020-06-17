package BusinessLogic;

import java.util.ArrayList;

import DataAccessLayer.WebShopDAO;
import TransferObject.ArticleDTO;

public class Manager_Article {
	
	ArrayList<ArticleDTO> articleList;
	ArticleDTO article;
	WebShopDAO dao;
	
	public Manager_Article() {
		
		this.dao = new WebShopDAO();
		this.article = dao.getArticle();
		this.articleList = dao.getArticleList();
	}


	public void setArticle(ArticleDTO article) {
		this.article = article;
		dao.setArticle(article);
	}
	
	public void setArticleList(ArrayList<ArticleDTO> articleList) {
		this.articleList = articleList;
		this.dao.setArticleList(articleList);
	}
	
	public ArticleDTO getArticle() {
		return this.article;
	}
	
	public ArrayList<ArticleDTO> getArticleList() {
		return this.articleList;
	}

	public void incrementQuantity(ArticleDTO article){
		int quantity = article.getQuantity();
		article.setQuantity(++quantity);
		dao.setArticleList(this.getArticleList());
	}
	
	public void decrementQuantity(ArticleDTO article){
		int quantity = this.article.getQuantity();
		article.setQuantity(--quantity);
		dao.setArticleList(this.getArticleList());
	}
}
