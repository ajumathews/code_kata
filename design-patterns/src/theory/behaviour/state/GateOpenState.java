package theory.behaviour.state;

public class GateOpenState implements GateState {

    private Gate gate;

    public GateOpenState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void cardValid() {
        System.out.println("Card is valid, Gate Opened from closed State ");
    }

    @Override
    public void cardInvalid() {
        System.out.println("Card is invalid, Gate is closed from open State ");
        gate.changeGateState(new GateClosedState(gate));
    }

    @Override
    public void personCrossedTheGate() {
        System.out.println("Person Moved through Gate, Gate is closed from open State");
        gate.changeGateState(new GateClosedState(gate));
    }

    @Override
    public void personCrossingTheGate() {
        System.out.println("Person Moving through Gate, Gate should be in open State");

    }
}
