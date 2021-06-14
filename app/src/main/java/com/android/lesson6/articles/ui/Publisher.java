package com.android.lesson6.articles.ui;

import com.android.lesson6.articles.domain.Article;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notify(Article article) {
        for (Observer observer: observers) {
            observer.updateArticle(article);
        }
    }
}
