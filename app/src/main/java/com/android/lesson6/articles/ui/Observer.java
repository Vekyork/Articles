package com.android.lesson6.articles.ui;

import com.android.lesson6.articles.domain.Article;

public interface Observer {

    void updateArticle(Article article);
}
