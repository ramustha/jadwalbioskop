
package com.ramusthastudio.zodiakbot.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResultMovies {
  @SerializedName("poster_path")
  private String posterPath;
  @SerializedName("adult")
  private boolean adult;
  @SerializedName("overview")
  private String overview;
  @SerializedName("release_date")
  private String releaseDate;
  @SerializedName("genre_ids")
  private final List<Integer> genreIds = null;
  @SerializedName("id")
  private int id;
  @SerializedName("original_title")
  private String originalTitle;
  @SerializedName("original_language")
  private String originalLanguage;
  @SerializedName("title")
  private String title;
  @SerializedName("backdrop_path")
  private String backdropPath;
  @SerializedName("popularity")
  private double popularity;
  @SerializedName("vote_count")
  private int voteCount;
  @SerializedName("video")
  private boolean video;
  @SerializedName("vote_average")
  private double voteAverage;

  public String getPosterPath() { return posterPath; }
  public boolean isAdult() { return adult; }
  public String getOverview() { return overview; }
  public String getReleaseDate() { return releaseDate; }
  public List<Integer> getGenreIds() { return genreIds; }
  public int getId() { return id; }
  public String getOriginalTitle() { return originalTitle; }
  public String getOriginalLanguage() { return originalLanguage; }
  public String getTitle() { return title; }
  public String getBackdropPath() { return backdropPath; }
  public double getPopularity() { return popularity; }
  public int getVoteCount() { return voteCount; }
  public boolean isVideo() { return video; }
  public double getVoteAverage() { return voteAverage; }

  @Override public String toString() {
    return "Result{" +
        "posterPath='" + posterPath + '\'' +
        ", adult=" + adult +
        ", overview='" + overview + '\'' +
        ", releaseDate='" + releaseDate + '\'' +
        ", genreIds=" + genreIds +
        ", id=" + id +
        ", originalTitle='" + originalTitle + '\'' +
        ", originalLanguage='" + originalLanguage + '\'' +
        ", title='" + title + '\'' +
        ", backdropPath='" + backdropPath + '\'' +
        ", popularity=" + popularity +
        ", voteCount=" + voteCount +
        ", video=" + video +
        ", voteAverage=" + voteAverage +
        '}';
  }
}
