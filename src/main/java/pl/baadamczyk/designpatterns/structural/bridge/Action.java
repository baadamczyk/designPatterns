package pl.baadamczyk.designpatterns.structural.bridge;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class Action {

    private List<String> supportedFileTypes = Lists.newArrayList("FLAC", "MPEG");
    protected MediaFile mediaFile;

    public Action(MediaFile mediaFile) {
        this.mediaFile = mediaFile;
    }

    protected boolean isFileTypeSupported() {
        for (String type : supportedFileTypes) {
            if (type.equals(mediaFile.getType())) return true;
        }

        return false;
    }

    public abstract String perform() throws FileTypeNotSupportedException;
}
