package practice;

import theory.creational.abstractFactory.withAbstractFactory.BackGround;
import theory.creational.abstractFactory.withAbstractFactory.WhiteBackGround;

public class WhiteTheme implements ThemeFactory {
    @Override
    public Button getButton() {
        return new SquareButton();
    }

    @Override
    public Font getFont() {
        return new TImesNew();
    }

    @Override
    public BackGround getBackGround() {
        return new WhiteBackGround();
    }
}
