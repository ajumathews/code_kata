package org.grace.practice.html.parsing.basic;

import org.apache.tools.ant.Executor;
import org.grace.jasper.model.complex.TableColumn;
import org.grace.jasper.model.complex.TableRow;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFutures {


    public void downloadImages(List<TableRow> tableRows) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        RestTemplate restTemplate=new RestTemplate();


        for (TableRow tableRow : tableRows) {
            for (TableColumn tableColumn : tableRow.getTableColumns()) {
                if (tableColumn.isImage()) {
                    Callable worker = new MyCallable(tableColumn.getImageUrl(),restTemplate);
                    Future future = executorService.submit(worker);
                    tableColumn.setFuture(future);
                }
            }
        }


        executorService.shutdown();


        for (TableRow tableRow : tableRows) {

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
