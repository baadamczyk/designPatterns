package pl.baadamczyk.designpatterns.structural.bridge;

public class PlayAction extends Action {


    public PlayAction(MediaFile mediaFile) {
        super(mediaFile);
    }

    @Override
    public String perform() throws FileTypeNotSupportedException {
        if(isFileTypeSupported()) {
            return mediaFile.getPlayerHeader();
        } else {
            throw new FileTypeNotSupportedException();
        }
    }
}
