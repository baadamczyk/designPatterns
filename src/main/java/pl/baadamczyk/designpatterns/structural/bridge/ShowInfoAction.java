package pl.baadamczyk.designpatterns.structural.bridge;

public class ShowInfoAction extends Action {

    public ShowInfoAction(MediaFile mediaFile) {
        super(mediaFile);
    }

    @Override
    public String perform() throws FileTypeNotSupportedException {
        if(isFileTypeSupported()) {
            return mediaFile.getFileInfo();
        } else {
            throw new FileTypeNotSupportedException();
        }
    }
}
