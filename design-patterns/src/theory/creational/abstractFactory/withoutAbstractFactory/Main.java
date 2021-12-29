package theory.creational.abstractFactory.withoutAbstractFactory;

/*
If we want to build different Themes for an Application.

in Dark Theme - Dark BackGround
                Light Buttons
In White Theme - White BackGround
                Dark Buttons

Here the Object DarkBackground and LightButtons are related. Both should be created when dark theme is applied

same in the case of White Theme.

Here all the creation logic is done at the client side and error prone.
For this we can use an abstract Factory pattern where it will have a theory.creational.factory which will create logically grouped objects
*/


public class Main {

    public static void main(String[] args) {

        System.out.println("Applying White Theme");
        BackGround whiteBackGround = new WhiteBackGround();
        Button darkButton = new DarkButton();
        System.out.println("Background Color: " + whiteBackGround.getBackGroundColor());
        System.out.println("Button Color: " + darkButton.getButtonColor());


        System.out.println("Applying Dark Theme");
        BackGround darkBackGround = new DarkBackGround();
        Button whiteButton = new WhiteButton();
        System.out.println("Background Color: " + darkBackGround.getBackGroundColor());
        System.out.println("Button Color: " + whiteButton.getButtonColor());
    }
}
