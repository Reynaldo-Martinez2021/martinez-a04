package baseline;

public class WebsiteInfo {
    /*
     * UCF COP3330 Fall 2021 Assignment 4 Solutions
     * Copyright 2021 Reynaldo Martinez
     */

    private String nameOfWebsite;
    private String authorName;
    private boolean wantsCssFolder;
    private boolean wantsJavaScriptFolder;

    public String getNameOfWebsite() {
        return nameOfWebsite;
    }

    public void setNameOfWebsite(String nameOfWebsite) {
        this.nameOfWebsite = nameOfWebsite;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean getCssAnswer() {
        return wantsCssFolder;
    }

    public void setWantsCssFolder(String cssFolder) {
        this.wantsCssFolder = cssFolder.contains("y") || cssFolder.contains("Y");
    }

    public boolean getJavascriptAnswer() {
        return wantsJavaScriptFolder;
    }

    //take in a string and check if string is y or no
    public void setJavascriptFolder(String javascriptFolder) {
        this.wantsJavaScriptFolder = javascriptFolder.contains("y") || javascriptFolder.contains("Y");
    }
}