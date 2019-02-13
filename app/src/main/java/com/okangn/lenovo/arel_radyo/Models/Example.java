package com.okangn.lenovo.arel_radyo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Example implements Serializable {
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
    @SerializedName("permalink")
    @Expose
    private String permalink;
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
    @SerializedName("thumb")
    @Expose
    private String thumb;
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


    public Example(String spermalink, String sthumb,String sstreamUrl) {
        permalink = spermalink;
        thumb = sthumb;
        streamUrl=sstreamUrl;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getReleaseTimestamp() {
        return releaseTimestamp;
    }

    public void setReleaseTimestamp(Integer releaseTimestamp) {
        this.releaseTimestamp = releaseTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTagedArtists() {
        return tagedArtists;
    }

    public void setTagedArtists(String tagedArtists) {
        this.tagedArtists = tagedArtists;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(String downloadable) {
        this.downloadable = downloadable;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenreSlush() {
        return genreSlush;
    }

    public void setGenreSlush(String genreSlush) {
        this.genreSlush = genreSlush;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    public String getArtworkUrlRetina() {
        return artworkUrlRetina;
    }

    public void setArtworkUrlRetina(String artworkUrlRetina) {
        this.artworkUrlRetina = artworkUrlRetina;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getWaveformData() {
        return waveformData;
    }

    public void setWaveformData(String waveformData) {
        this.waveformData = waveformData;
    }

    public String getWaveformUrl() {
        return waveformUrl;
    }

    public void setWaveformUrl(String waveformUrl) {
        this.waveformUrl = waveformUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getPlaybackCount() {
        return playbackCount;
    }

    public void setPlaybackCount(String playbackCount) {
        this.playbackCount = playbackCount;
    }

    public String getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(String downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getFavoritingsCount() {
        return favoritingsCount;
    }

    public void setFavoritingsCount(String favoritingsCount) {
        this.favoritingsCount = favoritingsCount;
    }

    public String getResharesCount() {
        return resharesCount;
    }

    public void setResharesCount(String resharesCount) {
        this.resharesCount = resharesCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getPlayed() {
        return played;
    }

    public void setPlayed(Boolean played) {
        this.played = played;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getReshared() {
        return reshared;
    }

    public void setReshared(Boolean reshared) {
        this.reshared = reshared;
    }
}
