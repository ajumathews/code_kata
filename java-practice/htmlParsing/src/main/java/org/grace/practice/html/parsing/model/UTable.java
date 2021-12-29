package org.grace.practice.html.parsing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by U6018134 on 7/6/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UTable {
    private String type;
    private String title;
    private String content;
    private String footer;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }


    @Override
    public String toString() {
        return "UTable{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }
}
