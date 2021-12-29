package theory.structural.bridge.withOutbridge;


/*
Here the Viewing classes has logic to show different resource.
If there are more resources we need to create more methods in the viewing classes
* */
public class Main {

    public static void main(String[] args) {
        ArtistResource artist = new ArtistResource();
        AlbumResource album = new AlbumResource();

        System.out.println("User is in Artist Menu");
        FullScreenView fullScreenView = new FullScreenView();
        ThumbNailView thumbNailView = new ThumbNailView();
        fullScreenView.showArtist(artist);
        thumbNailView.showArtist(artist);

        System.out.println("User is in Album Menu");
        fullScreenView.showAlbum(album);
        thumbNailView.showAlbum(album);



    }
}
