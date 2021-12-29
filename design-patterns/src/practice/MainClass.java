package practice;

public class MainClass {

    public static void main(String[] args) {


        ThemeFactory darkThemeFactory = new DarkTheme();
        System.out.println(darkThemeFactory.getBackGround());
        System.out.println(darkThemeFactory.getButton());
        System.out.println(darkThemeFactory.getFont());




    }
}
