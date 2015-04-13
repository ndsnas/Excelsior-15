package com.example.navi.excelsior_15;

import java.util.Date;

/**
 * Created by Navi on 3/4/2015.
 */
public class Movie {
    private String thumbnailUrl;



    public Movie() {
    }

    public Movie(String thumbnailUrl) {

        this.thumbnailUrl = thumbnailUrl;

    }



    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


}