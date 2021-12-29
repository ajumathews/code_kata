package theory.behaviour.state;

public class GateClosedState implements GateState {

    private Gate gate;

    public GateClosedState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void cardValid() {
        System.out.println("Card is valid, Gate Opened from closed State ");
        gate.changeGateState(new GateOpenState(gate));
    }

    @Override
    public void cardInvalid() {
        System.out.println("Card is invalid, Gate Remains in closed State ");
    }

    @Override
    public void personCrossedTheGate() {
        System.out.println("Gate is closed, cant move");
    }

    @Override
    public void personCrossingTheGate() {
        System.out.println("Gate is closed, cant move");
    }
}
