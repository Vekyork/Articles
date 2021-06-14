package com.android.lesson6.articles.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.lesson6.articles.R;
import com.android.lesson6.articles.domain.Article;
import com.android.lesson6.articles.ui.details.ArticleDetailsActivity;
import com.android.lesson6.articles.ui.details.ArticleDetailsFragment;
import com.android.lesson6.articles.ui.list.ArticleListFragment;

public class MainActivity extends AppCompatActivity implements ArticleListFragment.OnArticleClicked, PublisherHolder {

    private final Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onArticleClicked(Article article) {

        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (isLandscape) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.articles_details_fragment, ArticleDetailsFragment.newInstance(article))
                    .commit();

        } else {
            Intent intent = new Intent(this, ArticleDetailsActivity.class);
            intent.putExtra(ArticleDetailsActivity.ARG_Article, article);
            startActivity(intent);
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}