package theory.structural.proxy.withProxy;

/*
Here instead of the main object we create the theory.structural.proxy objects which are light weight
The heavy main object is instantiated only when you require the method


* */

public class Main {
    public static void main(String[] args) {
        WebCrawlerProxy proxy1 = new WebCrawlerProxy();
        WebCrawlerProxy proxy2 = new WebCrawlerProxy();

        System.out.println("Proxy Object created");
        System.out.println(proxy1.getPageContent());
    }
}
