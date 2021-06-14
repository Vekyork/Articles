package com.android.lesson6.articles.ui.details;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.lesson6.articles.R;
import com.android.lesson6.articles.domain.Article;
import com.android.lesson6.articles.ui.Observer;
import com.android.lesson6.articles.ui.Publisher;
import com.android.lesson6.articles.ui.PublisherHolder;

public class ArticleDetailsFragment extends Fragment implements Observer {

    private static final String ARG_Article = "ARG_Article";

    public static ArticleDetailsFragment newInstance(Article article) {
        ArticleDetailsFragment fragment = new ArticleDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_Article, article);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();

            publisher.subscribe(this);
        }
    }

    @Override
    public void onDetach() {
        if (publisher != null) {
            publisher.unsubscribe(this);
        }
        super.onDetach();
    }

    public ArticleDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView articleName = view.findViewById(R.id.article_name);
        ImageView articleCoat = view.findViewById(R.id.article_coat);

        assert getArguments() != null;
        Article article = getArguments().getParcelable(ARG_Article);

        articleName.setText(article.getName());
        articleCoat.setImageResource(article.getCoat());
    }

    @Override
    public void updateArticle(Article article) {
        Toast.makeText(requireContext(), article.getName(), Toast.LENGTH_LONG).show();
    }
}