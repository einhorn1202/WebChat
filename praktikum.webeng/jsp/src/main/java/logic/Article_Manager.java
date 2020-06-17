package logic;

import java.util.ArrayList;
import java.util.List;
import data.ArticleDAO;
import data.DAOFactory;
import transfer.Article;

public class Article_Manager implements ArticleDAO {
	
	//Instanzvariablen
	private ArticleDAO articleDAO;
	
	public Article_Manager() {
		this.articleDAO = DAOFactory.getArticleDAO();
		
		articleDAO.add(new Article(0,"TestArtikel01",10,7));
        articleDAO.add(new Article(0,"TestArtikel02",20,6));
        articleDAO.add(new Article(0,"TestArtikel03",30,5));
        articleDAO.add(new Article(0,"TestArtikel04",40,4));
        articleDAO.add(new Article(0,"TestArtikel05",50,3));
        articleDAO.add(new Article(0,"TestArtikel06",60,2));
	}

	@Override
	public Article get(int id) {
		return articleDAO.get(id);
	}

	@Override
	public ArrayList<Article> getAll() {
		return articleDAO.getAll();
	}

	@Override
	public void add(Article t) {
		articleDAO.add(t);
	}

	@Override
	public void update(Article t) {
		articleDAO.update(t);
	}

	@Override
	public void delete(Article t) {
		articleDAO.delete(t);
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	public void incrementQuantity(Article a , int val ){
		int quantity = a.getQuantity();
		a.setQuantity(val+quantity);
	}
	
	public void decrementQuantity(Article a , int val ){
		int quantity = a.getQuantity();
		a.setQuantity(val+quantity);
	}
}
