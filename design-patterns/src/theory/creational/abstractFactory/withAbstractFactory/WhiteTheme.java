package theory.creational.abstractFactory.withAbstractFactory;

public class WhiteTheme implements Theme {

    @Override
    public BackGround getBackGround() {
        return new WhiteBackGround();
    }

    @Override
    public Button getButton() {
        return new DarkButton();
    }


}
