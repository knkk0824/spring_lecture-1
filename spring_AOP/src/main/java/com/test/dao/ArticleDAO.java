package com.test.dao;

import com.test.domain.Article;

public interface ArticleDAO {
	void insert(Article article);
	Article selectById(Integer id);
}
