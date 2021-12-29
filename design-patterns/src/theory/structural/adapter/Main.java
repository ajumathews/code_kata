package theory.structural.adapter;

public class Main {

    public static void main(String[] args) {

        System.out.println("Getting power from Uk Connector");
        UkConnector ukConnector = new UkConnector();
        ukConnector.giveElectricityAsPerUkRegulation();


        System.out.println("Connecting German Connector to UK Connector via an German to UK adapter");
        GermanConnector germanConnector = new GermanConnector();
        GermanToUkConnectorAdapter germanToUkConnectorAdapter = new GermanToUkConnectorAdapter(germanConnector);
        germanToUkConnectorAdapter.giveElectricityAsPerUkRegulation();

    }
}
