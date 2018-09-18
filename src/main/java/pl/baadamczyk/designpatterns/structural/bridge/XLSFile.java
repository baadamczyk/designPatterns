package pl.baadamczyk.designpatterns.structural.bridge;

public class XLSFile implements MediaFile{

    private String author;
    private String title;
    private int year;
    private String cover;
    private String type;

    private XLSFile(String author, String title, int year, String cover, String type) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.cover = cover;
        this.type = type;
    }

    public static XLSFile of(String author, String title, int year, String cover) {
        return new XLSFile(author, title, year, cover, "XLS");
    }


    @Override
    public String getPlayerHeader() {
        return null;
    }

    @Override
    public String getFileInfo() {
        return null;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
