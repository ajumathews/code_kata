package theory.structural.proxy.withoutProxy;

public class WebCrawler {

    private String pageContent;

    public WebCrawler() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {

        }
        this.pageContent = "Page Content";
    }

    public String getPageContent() {
        return pageContent;
    }
}
