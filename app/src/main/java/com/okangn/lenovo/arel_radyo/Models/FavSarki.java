package com.okangn.lenovo.arel_radyo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FavSarki implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("release_timestamp")
    @Expose
    private Integer releaseTimestamp;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("geo")
    @Expose
    private String geo;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("taged_artists")
    @Expose
    private String tagedArtists;
    @SerializedName("bpm")
    @Expose
    private String bpm;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("downloadable")
    @Expose
    private String downloadable;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("genre_slush")
    @Expose
    private String genreSlush;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("permalink_url")
    @Expose
    private String permalinkUrl;
    @SerializedName("artwork_url")
    @Expose
    private String artworkUrl;
    @SerializedName("artwork_url_retina")
    @Expose
    private String artworkUrlRetina;
    @SerializedName("background_url")
    @Expose
    private String backgroundUrl;
    @SerializedName("waveform_data")
    @Expose
    private String waveformData;
    @SerializedName("waveform_url")
    @Expose
    private String waveformUrl;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("stream_url")
    @Expose
    private String streamUrl;
    @SerializedName("preview_url")
    @Expose
    private String previewUrl;
    @SerializedName("download_url")
    @Expose
    private String downloadUrl;
    @SerializedName("playback_count")
    @Expose
    private String playbackCount;
    @SerializedName("download_count")
    @Expose
    private String downloadCount;
    @SerializedName("favoritings_count")
    @Expose
    private String favoritingsCount;
    @SerializedName("reshares_count")
    @Expose
    private String resharesCount;
    @SerializedName("comment_count")
    @Expose
    private String commentCount;
    @SerializedName("played")
    @Expose
    private Boolean played;
    @SerializedName("favorited")
    @Expose
    private Boolean favorited;
    @SerializedName("reshared")
    @Expose
    private Boolean reshared;


    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    public FavSarki(String spermalink, String sthumb) {
        permalink = spermalink;
        thumb = sthumb;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }


}


