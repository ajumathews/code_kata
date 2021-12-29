package org.practice;

public enum JobPortal {
    NAUKRI("www.naukri.com"),
    LINKEDIN("www.linkedin.com"),
    MONSTER("www.monster.com");

    private String url;

    JobPortal(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}


class Main {
    public static void main(String[] args) {

        System.out.println(JobPortal.LINKEDIN.getUrl());



    }
}