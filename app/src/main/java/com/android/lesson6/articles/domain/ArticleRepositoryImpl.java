package com.android.lesson6.articles.domain;

import com.android.lesson6.articles.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository {

    @Override
    public List<Article> getArticles() {
        ArrayList<Article> result = new ArrayList<>();

        result.add(new Article(R.string.first, R.drawable.first));
        result.add(new Article(R.string.second, R.drawable.second));
        result.add(new Article(R.string.third, R.drawable.third));
        return result;
    }
}
