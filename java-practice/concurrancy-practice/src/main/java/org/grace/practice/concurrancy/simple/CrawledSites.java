package org.grace.practice.concurrancy.simple;

import java.util.ArrayList;
import java.util.List;

public class CrawledSites {

    private List<String> crawledSites = new ArrayList<String>();
    private List<String> sitesToCrawl = new ArrayList<String>();

    public void add(String site) {

        synchronized (this) {
            if (!crawledSites.contains(site)) {
                sitesToCrawl.add(site);
            }
        }
    }


    public String next() {
        String site=null;
        if (sitesToCrawl.size() == 0) {
            return null;
        }

        synchronized (this) {
            if (sitesToCrawl.size() > 0)
                site = sitesToCrawl.get(0);
                crawledSites.add(site);
                sitesToCrawl.remove(0);
                return site;
        }
    }
}
