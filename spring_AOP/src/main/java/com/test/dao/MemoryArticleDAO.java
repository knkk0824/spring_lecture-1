package com.test.dao;

import java.util.HashMap;
import java.util.Map;

import com.test.domain.Article;

public class MemoryArticleDAO implements ArticleDAO {
	
	private int articleNo = 0;
	private Map<Integer, Article> articleMap = new HashMap<Integer, Article>();
	
	@Override
	public void insert(Article article) {
		System.out.println("MemoryArticleDao.insert() 호출됨");
		articleNo++;
		article.setId(articleNo);
		articleMap.put(articleNo, article);

	}

	@Override
	public Article selectById(Integer id) {
		return articleMap.get(id);
	}

}



