package org.grace.practice.concurrancy.simple;

public class WebCrawler implements Runnable {
   private CrawledSites crawledSites;

    public WebCrawler(CrawledSites crawledSites) {
        this.crawledSites = crawledSites;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){}
        System.out.println(crawledSites.next());
    }



}
