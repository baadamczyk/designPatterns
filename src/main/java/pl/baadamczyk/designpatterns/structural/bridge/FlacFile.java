package pl.baadamczyk.designpatterns.structural.bridge;


public class FlacFile implements MediaFile {

    private String author;
    private String title;
    private int year;
    private String cover;
    private String type;

    private FlacFile(String author, String title, int year, String cover, String type) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.cover = cover;
        this.type = type;
    }

    public static FlacFile of(String author, String title, int year, String cover) {
        return new FlacFile(author, title, year, cover, "FLAC");
    }

    @Override
    public String getPlayerHeader() {
        String formatString = "Playing |%s| by |%s|";
        return String.format(formatString, title, author);
    }

    @Override
    public String getFileInfo() {
        String formatString = "FileType: %s | Artist: %s | Song: %s | Year: %s | Album Cover: %s";
        return String.format(formatString, type, author, title, year, cover);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
