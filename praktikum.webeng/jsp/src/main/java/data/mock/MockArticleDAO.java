package data.mock;

import java.util.ArrayList;
import java.util.List;
import data.ArticleDAO;
import transfer.Article;

public class MockArticleDAO implements ArticleDAO {
    
    private static ArrayList<Article> articles = new ArrayList<>();
     
     
    
	@Override
    public Article get(int id) {
    	Article a = null;
    	try 
    	{
    		  a = articles.get(id);
    	}
		catch(IndexOutOfBoundsException e) {
			System.out.println("MockArticleDAO::get: indexOutOfBounds");
		}

    	return a;
    }
     
    @Override
    public ArrayList<Article> getAll() {
        return articles;
    }
     
    @Override
    public void add(Article article) {
    	articles.add(article);
    	article.setId(articles.size()-1);
    }
     
    @Override
    public void update(Article article) {
    	Article a = articles.get(article.getId());
    	a.setName(article.getName());
    	a.setPrice(article.getPrice());
    	a.setQuantity(article.getQuantity());
    }
     
    @Override
    public void delete(Article article) {
    	articles.remove(article);
    }
}
