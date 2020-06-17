package data;

import data.mock.MockArticleDAO;

public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		return new MockArticleDAO();
	}
}
