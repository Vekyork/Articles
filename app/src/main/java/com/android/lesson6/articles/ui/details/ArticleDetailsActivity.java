package com.android.lesson6.articles.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.lesson6.articles.R;
import com.android.lesson6.articles.domain.Article;

public class ArticleDetailsActivity extends AppCompatActivity {

    public static final String ARG_Article = "ARG_Article";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        if (savedInstanceState == null) {

            Article article = getIntent().getParcelableExtra(ARG_Article);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, ArticleDetailsFragment.newInstance(article))
                    .commit();

        }
    }
}