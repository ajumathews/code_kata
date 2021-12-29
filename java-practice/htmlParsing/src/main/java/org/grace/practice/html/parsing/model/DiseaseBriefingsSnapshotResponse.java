package org.grace.practice.html.parsing.model;

import org.grace.jasper.model.complex.HtmlSection;

public class DiseaseBriefingsSnapshotResponse {
    private String id;
    private String name;
    private String level;
    private String content;
    private HtmlSection htmlSection;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HtmlSection getHtmlSection() {
        return htmlSection;
    }

    public void setHtmlSection(HtmlSection htmlSection) {
        this.htmlSection = htmlSection;
    }
}
