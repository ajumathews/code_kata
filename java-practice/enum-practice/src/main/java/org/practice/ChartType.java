package org.practice;

public enum ChartType {
    COMPANY,
    REGION
}

class ChartTypeRunner {
    public static void main(String[] args) throws Exception {
        String chartType = "COMPANY";
        switch (ChartType.valueOf(chartType)) {
            case COMPANY:
                System.out.println("in Company");
                break;

            case REGION:
                System.out.println("in Region");
                break;
        }
    }

}
