package org.grace.jasper.model.complex;

import java.io.InputStream;
import java.util.concurrent.Future;

/**
 * Created by U6018134 on 6/20/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class HtmlContent {
    private String contentType;
    private Object htmlContent;
    private String title;
    private String imageUrl;
    private Future<InputStream> future;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public Object getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(Object htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Future<InputStream> getFuture() {
        return future;
    }

    public void setFuture(Future<InputStream> future) {
        this.future = future;
    }
}


