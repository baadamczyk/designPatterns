package pl.baadamczyk.designpatterns.structural.bridge;

public class MpegFile implements MediaFile {

    private String author;
    private String title;
    private int year;
    private String cover;
    private String type;

    private MpegFile(String author, String title, int year, String cover, String type) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.cover = cover;
        this.type = type;
    }

    public static MpegFile of(String author, String title, int year, String cover) {
        return new MpegFile(author, title, year, cover, "MPEG");
    }

    @Override
    public String getPlayerHeader() {
        String formatString = "Playing |%s|";
        return String.format(formatString, title);
    }

    @Override
    public String getFileInfo() {
        String formatString = "FileType: %s | Title: %s | Director: %s | Year: %s | Movie Poster: %s";
        return String.format(formatString, type, title, author, year, cover);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
