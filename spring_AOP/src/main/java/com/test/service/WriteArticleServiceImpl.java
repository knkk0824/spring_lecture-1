package com.test.service;

import com.test.dao.ArticleDAO;
import com.test.domain.Article;
import com.test.domain.NewArticleRequest;

public class WriteArticleServiceImpl implements WriteArticleService {
	
	private ArticleDAO articleDao;
	public void setArticleDao(ArticleDAO articleDao){
		this.articleDao=articleDao;
	}
	
	public WriteArticleServiceImpl(){}
	public WriteArticleServiceImpl(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public void write(NewArticleRequest newArticleReq) {
		System.out.println("WriteArticleServiceImpl.write() 호출됨");
		Article article = toArticle(newArticleReq);
		articleDao.insert(article);		
	}
	private Article toArticle(NewArticleRequest newArticleReq) {
		return new Article(
				newArticleReq.getWriterName(),
				newArticleReq.getTitle(),
				newArticleReq.getContent());
	}

}
