package com.android.lesson6.articles.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.lesson6.articles.domain.Article;
import com.android.lesson6.articles.domain.ArticleRepository;
import com.android.lesson6.articles.domain.ArticleRepositoryImpl;
import com.android.lesson6.articles.ui.PublisherHolder;
import com.android.lesson6.articles.R;
import com.android.lesson6.articles.ui.Publisher;

import java.util.List;

public class ArticleListFragment extends Fragment {

    public interface OnArticleClicked {
        void onArticleClicked(Article article);
    }

    private ArticleRepository articleRepository;

    private OnArticleClicked onArticleClicked;

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnArticleClicked) {
            onArticleClicked = (OnArticleClicked) context;
        }

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        onArticleClicked = null;
        publisher = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        articleRepository = new ArticleRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout articlesList = view.findViewById(R.id.article_list_container);

        List<Article> articles = articleRepository.getArticles();

        for (Article article: articles) {

            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_article, articlesList, false);

            itemView.setOnClickListener(v -> {
                if (onArticleClicked != null) {
                    onArticleClicked.onArticleClicked(article);
                }

                if (publisher != null) {
                    publisher.notify(article);
                }
            });

            TextView articleName = itemView.findViewById(R.id.article_name);
            articleName.setText(article.getName());

            articlesList.addView(itemView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
