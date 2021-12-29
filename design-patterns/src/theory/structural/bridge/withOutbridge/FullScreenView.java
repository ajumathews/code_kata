package theory.structural.bridge.withOutbridge;

public class FullScreenView {

    public void showArtist(ArtistResource resource) {
        System.out.println("Full Screen View");
        System.out.println(resource.getImage());
        System.out.println(resource.getTitle());
    }

    public void showAlbum(AlbumResource resource) {
        System.out.println("Full Screen View");
        System.out.println(resource.getImage());
        System.out.println(resource.getTitle());
    }

}
