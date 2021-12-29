package theory.structural.bridge.withBridge;


/*
Here the Viewing Interface and the Resource Interface is connected

Changing the view to Artist and Album is very flexible by changing the resource.
* */
public class Main {

    public static void main(String[] args) {
        Resource artist = new ArtistResource();
        System.out.println("User is in Artist Menu");
        View fullScreenView = new FullScreenView(artist);
        View thumbNailView = new ThumbNailView(artist);
        fullScreenView.show();
        thumbNailView.show();

        System.out.println("User is in Album Menu");
        Resource album = new AlbumResource();
        fullScreenView.setResource(album);
        thumbNailView.setResource(album);
        fullScreenView.show();
        thumbNailView.show();


    }
}
