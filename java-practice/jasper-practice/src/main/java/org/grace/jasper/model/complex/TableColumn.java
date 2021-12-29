package org.grace.jasper.model.complex;

import java.io.InputStream;
import java.util.concurrent.Future;

/**
 * Created by U6018134 on 6/21/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class TableColumn {

    private Object columnValue;
    private boolean isInternalHeader;
    private boolean isImage;
    private String imageUrl;
    private Future<InputStream> future;

    public Object getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(Object columnValue) {
        this.columnValue = columnValue;
    }

    public boolean isInternalHeader() {
        return isInternalHeader;
    }

    public void setInternalHeader(boolean internalHeader) {
        isInternalHeader = internalHeader;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
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
