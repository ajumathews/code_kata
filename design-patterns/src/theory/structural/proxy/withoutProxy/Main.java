package theory.structural.proxy.withoutProxy;

/*
Here the creation of WebCrawler is an expensive task. So if we want to invoke the creation only when
someone request the getPageContent method


* */

public class Main {
    public static void main(String[] args) {
        WebCrawler webCrawler1 = new WebCrawler();
        WebCrawler webCrawler2 = new WebCrawler();
        System.out.println("Object Creation Done");
        System.out.println(webCrawler2.getPageContent());
    }
}
