package theory.creational.abstractFactory.withAbstractFactory;

/*
Here Theme interface is the Abstract Factory which has two implementation
DarkThemes responsibility is to create the logically related Buttons and BackGround
and same for WhiteTheme.

This is more maintainable and flexible code.
*/


public class Main {

    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        System.out.println("Dark Theme Applied");
        System.out.println("Background : " + darkTheme.getBackGround().getBackGroundColor());
        System.out.println("Button : " + darkTheme.getButton().getButtonColor());

        Theme whiteTheme = new WhiteTheme();
        System.out.println("White Theme Applied");
        System.out.println("Background : " + whiteTheme.getBackGround().getBackGroundColor());
        System.out.println("Button : " + whiteTheme.getButton().getButtonColor());
    }
}
