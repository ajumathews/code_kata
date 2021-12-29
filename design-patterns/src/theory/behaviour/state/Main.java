package theory.behaviour.state;

public class Main {

    public static void main(String[] args) {
        Gate gate = new Gate();
        gate.changeGateState(new GateClosedState(gate));
        gate.cardValid();
        gate.personCrossingTheGate();
        gate.personCrossedTheGate();

        gate.cardInvalid();
        gate.personCrossingTheGate();


    }
}
