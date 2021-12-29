package org.grace.practice.concurrancy.simple;

public class MainCrawler {

    public static void main(String[] args) throws InterruptedException{
        CrawledSites crawledSites = new CrawledSites();
        WebCrawler webCrawler = new WebCrawler(crawledSites);
        SitePublisher sitePublisher = new SitePublisher(crawledSites);

        Thread publisher = new Thread(sitePublisher);
        Thread crawler = new Thread(webCrawler);


        publisher.start();
        crawler.start();

        publisher.join();
        crawler.join();

    }
}
