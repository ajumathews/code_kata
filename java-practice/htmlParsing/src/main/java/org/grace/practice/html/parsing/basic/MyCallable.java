package org.grace.practice.html.parsing.basic;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<InputStream> {
    private String url;
    private RestTemplate chemistryServiceTemplate;

    public MyCallable(String url,RestTemplate chemistryServiceTemplate) {
        this.url = url;
        this.chemistryServiceTemplate=chemistryServiceTemplate;
    }

    @Override
    public InputStream call() {
        //return new ByteArrayInputStream(getImageFromUrlTemplate(url));
       return getImageFromUrl(url);
    }



    private InputStream getImageFromUrl(String imageUrl) {
      //  System.out.println("Start Downloading "+ imageUrl);
        if (!imageUrl.endsWith(".swf")) {

            ByteArrayOutputStream bis = new ByteArrayOutputStream();
            InputStream is = null;


            try {
                URL url = new URL(imageUrl);
                //URL url = new URL("http://diylogodesigns.com/blog/wp-content/uploads/2017/07/java-logo-vector-768x768.png");
                //is = new BufferedInputStream(url.openStream());
                is = url.openStream();

                int n;
                byte[] bytebuff = new byte[8*1024];
                while ((n = is.read(bytebuff)) > 0) {
                    bis.write(bytebuff, 0, n);
                }
                is.close();
                bis.close();
            } catch (FileNotFoundException e) {
                //System.out.println(e.toString());
                return null;
            } catch (IOException e) {
                //System.out.println(e.toString());
                return null;
            }
       //     System.out.println("End Downloading "+ imageUrl);
            return new ByteArrayInputStream(bis.toByteArray());
        }

        return null;
    }


    private byte[] getImageFromUrlTemplate(String imageUrl) {
       // System.out.println("Start Downloading "+ imageUrl);
        if (!imageUrl.endsWith(".swf")) {


            HttpHeaders headers = new HttpHeaders();
            HttpEntity requestEntity = new HttpEntity(headers);

            try {
                ResponseEntity<byte[]> response = chemistryServiceTemplate.exchange(imageUrl, HttpMethod.GET, requestEntity, byte[].class, new Object[0]);
          //      System.out.println("End Downloading "+ imageUrl);
                return response.getBody();
            } catch (HttpStatusCodeException var5) {
                return null;
            } catch (HttpMessageNotReadableException | RestClientException var6) {
                return null;
            }

        }

        return null;
    }

}
