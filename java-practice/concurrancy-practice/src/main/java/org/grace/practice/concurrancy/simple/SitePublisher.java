package org.grace.practice.concurrancy.simple;

public class SitePublisher implements Runnable{
    private CrawledSites crawledSites;

    public SitePublisher(CrawledSites crawledSites) {
        this.crawledSites = crawledSites;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++)
        crawledSites.add("site :"+i);
    }
}
