package com.example.hiromtask;

public class Task {
    String albumId, id, title, url, thumbnailUrl;

    public Task(String albumId, String id, String title, String url, String thumbnailUrl){
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }
    public String getAlbumId(){
        return albumId;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getImage(){
        return url;
    }
    public String getThumbnailImg(){
        return thumbnailUrl;
    }
}
