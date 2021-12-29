package practice;

import theory.creational.abstractFactory.withAbstractFactory.BackGround;

public interface ThemeFactory {

    public Button getButton();

    public Font getFont();

    public BackGround getBackGround();

}
