package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import transfer.Article;


public interface ArticleDAO {
    
    Article get(int id);
     
    ArrayList<Article> getAll();
     
    void add(Article t);
     
    void update(Article t);
     
    void delete(Article t);
}
