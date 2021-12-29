package practice


import theory.creational.abstractFactory.withAbstractFactory.BackGround;
import theory.creational.abstractFactory.withAbstractFactory.DarkBackGround;

public class DarkTheme implements ThemeFactory {

    @Override
    public Button getButton() {
        return new RoundButton();
    }

    @Override
    public Font getFont() {
        return new Calibir();
    }

    @Override
    public BackGround getBackGround() {
        return new DarkBackGround();
    }
}
