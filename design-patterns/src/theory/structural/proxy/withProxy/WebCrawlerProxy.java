package theory.structural.proxy.withProxy;

public class WebCrawlerProxy {

    private WebCrawler webCrawler;

    public String getPageContent() {
        if(webCrawler == null){
            webCrawler = new WebCrawler();
        }
        return webCrawler.getPageContent();
    }
}
