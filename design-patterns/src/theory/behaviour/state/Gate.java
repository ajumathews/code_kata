package theory.behaviour.state;

public class Gate {

    private GateState gateState;

    public void changeGateState(GateState gateState) {
        this.gateState = gateState;
    }

    public void cardValid() {
        gateState.cardValid();
    }

    public void cardInvalid() {
        gateState.cardInvalid();
    }

    public void personCrossingTheGate() {
        gateState.personCrossingTheGate();
    }

    public void personCrossedTheGate() {
        gateState.personCrossedTheGate();
    }


}
