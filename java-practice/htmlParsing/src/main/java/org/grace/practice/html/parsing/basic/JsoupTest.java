package org.grace.practice.html.parsing.basic;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Arrays;

public class JsoupTest {

    public static void main(String[] args) {

/*        String s = "onset HPP (aged <=5 years at enrollment)  <b>infantile</b> there were rapid and sustained" ;
        //s= StringEscapeUtils.unescapeXml(s);
        System.out.println(s);

        System.out.println(cleanHtmlContent(s));*/

        String str = "id-INT, name-STRING, thomson.reuters";
        String[] parts = str.split("\\W+");

        //String[] parts = str.split("[\\s\\S]");



        System.out.println(parts.length);
        System.out.println(Arrays.toString(parts));

    }

    public static String cleanHtmlContent(String input) {
        Document doc = Jsoup.parseBodyFragment(input);
        return doc.body().html();
    }
}
