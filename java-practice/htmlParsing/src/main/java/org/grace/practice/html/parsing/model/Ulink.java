package org.grace.practice.html.parsing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by U6018134 on 7/5/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ulink {

    private String linkType;
    private String linkID;
    private String name;
    private String title;
    private String content;



    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkID() {
        return linkID;
    }

    public void setLinkID(String linkID) {
        this.linkID = linkID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Ulink{" +
                "linkType='" + linkType + '\'' +
                ", linkID='" + linkID + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
