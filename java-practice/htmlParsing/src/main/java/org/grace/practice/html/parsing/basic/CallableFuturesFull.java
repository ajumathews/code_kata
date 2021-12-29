package org.grace.practice.html.parsing.basic;

import org.grace.jasper.model.complex.HtmlContent;
import org.grace.jasper.model.complex.HtmlTable;
import org.grace.jasper.model.complex.TableColumn;
import org.grace.jasper.model.complex.TableRow;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.*;

public class CallableFuturesFull {


            public void downloadImages(List<HtmlContent> htmlContents) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        RestTemplate template = new RestTemplate();

        int count=0;
        for(HtmlContent content : htmlContents){
            if(content.getContentType().equalsIgnoreCase("IMAGE")){
                Callable worker = new MyCallable(content.getImageUrl(),new RestTemplate());
                Future future = executorService.submit(worker);
                content.setFuture(future);
                count++;
            } else if(content.getContentType().equalsIgnoreCase("TABLE")){

                HtmlTable table = (HtmlTable) content.getHtmlContent();
                for (TableRow tableRow : table.getTableRows()) {
                    for (TableColumn tableColumn : tableRow.getTableColumns()) {
                        if (tableColumn.isImage()) {
                            Callable worker = new MyCallable(tableColumn.getImageUrl(),new RestTemplate());
                            Future future = executorService.submit(worker);
                            tableColumn.setFuture(future);
                            count++;
                        }
                    }
                }

            }

        }

        System.out.println("Downloading "+count);



        executorService.shutdown();


        for(HtmlContent content : htmlContents){
            if(content.getContentType().equalsIgnoreCase("IMAGE")){
                try {
                    content.setHtmlContent((InputStream) content.getFuture().get());
                }catch (InterruptedException e){}
                catch (ExecutionException e){}
            } else if(content.getContentType().equalsIgnoreCase("TABLE")){

                HtmlTable table = (HtmlTable) content.getHtmlContent();
                for (TableRow tableRow : table.getTableRows()) {
                    for (TableColumn tableColumn : tableRow.getTableColumns()) {
                        if (tableColumn.getFuture() != null) {
                            try {
                                tableColumn.setColumnValue(tableColumn.getFuture().get());
                            }catch (ExecutionException e){}
                            catch (InterruptedException e){}
                        }
                    }
                    }
                }

            }

        }

}
