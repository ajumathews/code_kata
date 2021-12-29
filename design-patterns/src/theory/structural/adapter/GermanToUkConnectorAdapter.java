package theory.structural.adapter;

public class GermanToUkConnectorAdapter implements UkConnectorInterface {

    public GermanConnectorInterface germanConnector;

    public GermanToUkConnectorAdapter(GermanConnector germanConnector) {
        this.germanConnector = germanConnector;
    }

    public void giveElectricityAsPerUkRegulation() {
        System.out.println("electricity flowing via german to UK Adapter");
        germanConnector.giveElectricityAsPerGermanRegulation();
    }

}
