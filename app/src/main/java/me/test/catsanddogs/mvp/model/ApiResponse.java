package me.test.catsanddogs.mvp.model;

import java.util.List;

public class ApiResponse {
    public static class ImageDescription {
        public final String url;
        public final String title;
        public ImageDescription(String url, String title) {
            this.url = url;
            this.title = title;
        }
    }
    public final String message;
    public final List<ImageDescription> data;

    public ApiResponse(String message, List<ImageDescription> data) {
        this.message = message;
        this.data = data;
    }
}
