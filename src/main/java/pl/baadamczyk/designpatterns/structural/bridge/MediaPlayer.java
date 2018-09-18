package pl.baadamczyk.designpatterns.structural.bridge;

// The point in bridge pattern is that I can pass any file type to any Action and it will work (ex. I can pass both FLAC and MPEG to 'Play' action)
public class MediaPlayer {

    private static volatile MediaPlayer playerInstance;

    private MediaPlayer() throws ReflectiveOperationException {
        if(playerInstance != null) {
            throw new ReflectiveOperationException();
        }
    }

    public static MediaPlayer getInstance() throws ReflectiveOperationException {
        if(playerInstance == null) playerInstance = new MediaPlayer();

        return playerInstance;
    }


    public String play(MediaFile file) throws FileTypeNotSupportedException {
        return new PlayAction(file).perform();
    }

    public String showFileInfo(MediaFile file) throws FileTypeNotSupportedException {
        return new ShowInfoAction(file).perform();
    }
}
