package theory.creational.abstractFactory.withAbstractFactory;

public class DarkTheme implements Theme {

    @Override
    public BackGround getBackGround() {
        return new DarkBackGround();
    }

    @Override
    public Button getButton() {
        return new WhiteButton();
    }


}
