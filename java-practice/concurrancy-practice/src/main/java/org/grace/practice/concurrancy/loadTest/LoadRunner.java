package org.grace.practice.concurrancy.loadTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadRunner implements Runnable {

    private String drugId;

    public LoadRunner(String drugId) {
        this.drugId = drugId;
    }

    public void run() {
        executeExportRequest();
    }


    private void executeExportRequest() {
        String exportUrl = "http://mwb.us-west-2.stable.dev.cortellis.int.clarivate.com:8320/ExportService/nextgendrugall/v1/export?idList=drugIdInput&dataset=nextgendrugall(breadth=\"extended\",depth=\"executive\")&exportFormat=PDF&multipleReportDelivery=&relatedDatasets=trial(breadth=\"basic\",depth=\"1000\"),patentFamily(breadth=\"extended\")&exportContent={\"sectionList\":[{\"id\":\"SNAPSHOT\"},{\"id\":\"drugSalesAndForecasts\"}]}\n";
        final String url = exportUrl.replace("drugIdInput", drugId);
        try {
            long startTime = System.currentTimeMillis();
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.getResponseCode();
            long timeTaken = System.currentTimeMillis() - startTime;
            System.out.println(drugId + "," + timeTaken);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class MainClass {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executorService = Executors.newFixedThreadPool(100);
/*        for(int i =0 ; i<10 ;i++){
            executorService.submit(new LoadRunner("95617"));
            executorService.submit(new LoadRunner("12135"));
            executorService.submit(new LoadRunner("8735"));
            executorService.submit(new LoadRunner("44699"));
            executorService.submit(new LoadRunner("75079"));

            executorService.submit(new LoadRunner("95617"));
            executorService.submit(new LoadRunner("12135"));
            executorService.submit(new LoadRunner("8735"));
            executorService.submit(new LoadRunner("44699"));
            executorService.submit(new LoadRunner("75079"));
        }*/

        for(int i =0 ; i<2 ;i++){
            executorService.submit(new LoadRunner("59692,61703"));
            executorService.submit(new LoadRunner("7871,64947"));
            executorService.submit(new LoadRunner("57196,7871"));
            executorService.submit(new LoadRunner("43021,16917"));
            executorService.submit(new LoadRunner("44699,31134"));
            executorService.submit(new LoadRunner("12406,12420"));
            executorService.submit(new LoadRunner("42857,12406"));
            executorService.submit(new LoadRunner("55014,17855"));
            executorService.submit(new LoadRunner("4503,42857"));


          



            executorService.submit(new LoadRunner("86050,4427"));
            executorService.submit(new LoadRunner("31134,67172"));
            executorService.submit(new LoadRunner("61703,54734"));
            executorService.submit(new LoadRunner("55195,44699"));
            executorService.submit(new LoadRunner("67172,2565"));
            executorService.submit(new LoadRunner("91255,41500"));
            executorService.submit(new LoadRunner("42998,43021"));

            
    



            executorService.submit(new LoadRunner("58903,42998"));
            executorService.submit(new LoadRunner("10298,58903"));
            executorService.submit(new LoadRunner("12420,59357"));
            executorService.submit(new LoadRunner("14658,54244"));
            executorService.submit(new LoadRunner("64947,4503"));
            executorService.submit(new LoadRunner("4427,9638"));
            executorService.submit(new LoadRunner("49317,14658"));
            executorService.submit(new LoadRunner("72124,12846"));

            
    



            executorService.submit(new LoadRunner("12846,55014"));
            executorService.submit(new LoadRunner("41500,72124"));
            executorService.submit(new LoadRunner("9638,55195"));
            executorService.submit(new LoadRunner("2565,57196"));
            executorService.submit(new LoadRunner("54734,54910"));
            executorService.submit(new LoadRunner("54244,59692"));
            executorService.submit(new LoadRunner("59357,91255"));
            executorService.submit(new LoadRunner("17855,49317"));

            
    


            executorService.submit(new LoadRunner("16917,86050"));
            executorService.submit(new LoadRunner("54910,47500"));
            executorService.submit(new LoadRunner("47500,10298"));
            executorService.submit(new LoadRunner("49317,14658"));
            executorService.submit(new LoadRunner("9638,55195"));
            executorService.submit(new LoadRunner("43021,16917"));
            executorService.submit(new LoadRunner("12846,55014"));
            executorService.submit(new LoadRunner("41500,72124"));
            executorService.submit(new LoadRunner("55195,44699"));

            
    



            executorService.submit(new LoadRunner("7871,64947"));
            executorService.submit(new LoadRunner("31134,67172"));
            executorService.submit(new LoadRunner("10298,58903"));
            executorService.submit(new LoadRunner("12420,59357"));
            executorService.submit(new LoadRunner("61703,54734"));
            executorService.submit(new LoadRunner("55014,17855"));
            executorService.submit(new LoadRunner("14658,54244"));
            executorService.submit(new LoadRunner("16917,86050"));
            executorService.submit(new LoadRunner("67172,2565"));


    



            executorService.submit(new LoadRunner("44699,31134"));
            executorService.submit(new LoadRunner("4427,9638"));
            executorService.submit(new LoadRunner("91255,41500"));
            executorService.submit(new LoadRunner("54244,59692"));
            executorService.submit(new LoadRunner("2565,57196"));
            executorService.submit(new LoadRunner("86050,4427"));
            executorService.submit(new LoadRunner("42998,43021"));
            executorService.submit(new LoadRunner("64947,4503"));

    


            executorService.submit(new LoadRunner("42857,12406"));
            executorService.submit(new LoadRunner("57196,7871"));
            executorService.submit(new LoadRunner("12406,12420"));
            executorService.submit(new LoadRunner("58903,42998"));
            executorService.submit(new LoadRunner("72124,12846"));
            executorService.submit(new LoadRunner("4503,42857"));
            executorService.submit(new LoadRunner("59357,91255"));


    



            executorService.submit(new LoadRunner("59692,61703"));
            executorService.submit(new LoadRunner("17855,49317"));
            executorService.submit(new LoadRunner("54734,54910"));
            executorService.submit(new LoadRunner("47500,10298"));
            executorService.submit(new LoadRunner("54910,47500"));


    


            executorService.submit(new LoadRunner("4503,42857"));
            executorService.submit(new LoadRunner("67172,2565"));
            executorService.submit(new LoadRunner("49317,14658"));
            executorService.submit(new LoadRunner("12420,59357"));
            executorService.submit(new LoadRunner("12846,55014"));
            executorService.submit(new LoadRunner("14658,54244"));
            executorService.submit(new LoadRunner("2565,57196"));
            executorService.submit(new LoadRunner("58903,42998"));
            executorService.submit(new LoadRunner("17855,49317"));


    



            executorService.submit(new LoadRunner("54910,47500"));
            executorService.submit(new LoadRunner("16917,86050"));
            executorService.submit(new LoadRunner("64947,4503"));
            executorService.submit(new LoadRunner("61703,54734"));
            executorService.submit(new LoadRunner("42857,12406"));
            executorService.submit(new LoadRunner("10298,58903"));
            executorService.submit(new LoadRunner("72124,12846"));
            executorService.submit(new LoadRunner("55195,44699"));
            executorService.submit(new LoadRunner("41500,72124"));
            executorService.submit(new LoadRunner("31134,67172"));


    



            executorService.submit(new LoadRunner("86050,4427"));
            executorService.submit(new LoadRunner("55014,17855"));
            executorService.submit(new LoadRunner("54734,54910"));
            executorService.submit(new LoadRunner("59692,61703"));
            executorService.submit(new LoadRunner("47500,10298"));
            executorService.submit(new LoadRunner("91255,41500"));
            executorService.submit(new LoadRunner("43021,16917"));
            executorService.submit(new LoadRunner("9638,55195"));
            executorService.submit(new LoadRunner("44699,31134"));
            executorService.submit(new LoadRunner("42998,43021"));


    



            executorService.submit(new LoadRunner("57196,64947"));
            executorService.submit(new LoadRunner("12406,12420"));
            executorService.submit(new LoadRunner("54244,59692"));
            executorService.submit(new LoadRunner("4427,9638"));
            executorService.submit(new LoadRunner("7871,64947"));
            executorService.submit(new LoadRunner("59357,91255"));
            executorService.submit(new LoadRunner("57196,7871"));
            executorService.submit(new LoadRunner("2565,12420"));
            executorService.submit(new LoadRunner("42857,59357"));
            executorService.submit(new LoadRunner("7871,4503"));
            executorService.submit(new LoadRunner("4503,12406"));
            executorService.submit(new LoadRunner("64947,12420"));


    


            executorService.submit(new LoadRunner("49317,14658"));
            executorService.submit(new LoadRunner("9638,55195"));
            executorService.submit(new LoadRunner("43021,16917"));
            executorService.submit(new LoadRunner("12846,55014"));
            executorService.submit(new LoadRunner("41500,72124"));
            executorService.submit(new LoadRunner("55195,44699"));
            executorService.submit(new LoadRunner("7871,64947"));
            executorService.submit(new LoadRunner("31134,67172"));
            executorService.submit(new LoadRunner("10298,58903"));
            executorService.submit(new LoadRunner("12420,59357"));


    



            executorService.submit(new LoadRunner("61703,54734"));
            executorService.submit(new LoadRunner("55014,17855"));
            executorService.submit(new LoadRunner("14658,54244"));
            executorService.submit(new LoadRunner("16917,86050"));
            executorService.submit(new LoadRunner("67172,2565"));
            executorService.submit(new LoadRunner("44699,31134"));
            executorService.submit(new LoadRunner("4427,9638"));
            executorService.submit(new LoadRunner("91255,41500"));
            executorService.submit(new LoadRunner("54244,59692"));
            executorService.submit(new LoadRunner("2565,57196"));


    



            executorService.submit(new LoadRunner("86050,4427"));
            executorService.submit(new LoadRunner("42998,43021"));
            executorService.submit(new LoadRunner("64947,4503"));
            executorService.submit(new LoadRunner("42857,12406"));
            executorService.submit(new LoadRunner("57196,7871"));
            executorService.submit(new LoadRunner("12406,12420"));
            executorService.submit(new LoadRunner("58903,42998"));


    



            executorService.submit(new LoadRunner("72124,12846"));
            executorService.submit(new LoadRunner("4503,42857"));
            executorService.submit(new LoadRunner("59357,91255"));
            executorService.submit(new LoadRunner("59692,61703"));
            executorService.submit(new LoadRunner("17855,49317"));
            executorService.submit(new LoadRunner("54734,54910"));
            executorService.submit(new LoadRunner("47500,10298"));
            executorService.submit(new LoadRunner("54910,47500"));


    


            executorService.submit(new LoadRunner("42857,12406"));
            executorService.submit(new LoadRunner("55195,44699"));
            executorService.submit(new LoadRunner("57196,7871"));
            executorService.submit(new LoadRunner("64947,4503"));
            executorService.submit(new LoadRunner("31134,67172"));
            executorService.submit(new LoadRunner("16917,86050"));
            executorService.submit(new LoadRunner("41500,72124"));
            executorService.submit(new LoadRunner("10298,58903"));
            executorService.submit(new LoadRunner("59692,61703"));
            executorService.submit(new LoadRunner("12406,12420"));


    



            executorService.submit(new LoadRunner("14658,54244"));
            executorService.submit(new LoadRunner("12846,55014"));
            executorService.submit(new LoadRunner("2565,57196"));
            executorService.submit(new LoadRunner("7871,64947"));
            executorService.submit(new LoadRunner("91255,41500"));
            executorService.submit(new LoadRunner("67172,2565"));
            executorService.submit(new LoadRunner("49317,14658"));
            executorService.submit(new LoadRunner("4503,42857"));
            executorService.submit(new LoadRunner("44699,31134"));
            executorService.submit(new LoadRunner("42998,43021"));


    



            executorService.submit(new LoadRunner("17855,49317"));
            executorService.submit(new LoadRunner("58903,42998"));
            executorService.submit(new LoadRunner("61703,54734"));
            executorService.submit(new LoadRunner("72124,12846"));
            executorService.submit(new LoadRunner("12420,59357"));
            executorService.submit(new LoadRunner("43021,16917"));


    


            executorService.submit(new LoadRunner("4427,9638"));
            executorService.submit(new LoadRunner("55014,17855"));
            executorService.submit(new LoadRunner("9638,55195"));
            executorService.submit(new LoadRunner("86050,4427"));
            executorService.submit(new LoadRunner("59357,91255"));
            executorService.submit(new LoadRunner("54244,59692"));
            executorService.submit(new LoadRunner("54734,54910"));
            executorService.submit(new LoadRunner("47500,10298"));
            executorService.submit(new LoadRunner("54910,47500"));


    



        }



        executorService.shutdown();

    }

}