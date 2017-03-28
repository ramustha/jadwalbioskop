package com.ramusthastudio.zodiakbot.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {
  @SerializedName("movie")
  private Object movie;
  @SerializedName("poster")
  private Object poster;
  @SerializedName("genre")
  private Object genre;
  @SerializedName("duration")
  private Object duration;
  @SerializedName("jadwal")
  private List<Schedule> schedule = null;

  public Object getMovie() { return movie; }
  public Object getPoster() { return poster; }
  public Object getGenre() { return genre; }
  public Object getDuration() { return duration; }
  public List<Schedule> getSchedule() { return schedule; }

  public Data setMovie(Object aMovie) {
    movie = aMovie;
    return this;
  }
  public Data setPoster(Object aPoster) {
    poster = aPoster;
    return this;
  }
  public Data setGenre(Object aGenre) {
    genre = aGenre;
    return this;
  }
  public Data setDuration(Object aDuration) {
    duration = aDuration;
    return this;
  }
  public Data setSchedule(List<Schedule> aSchedule) {
    schedule = aSchedule;
    return this;
  }

  @Override public String toString() {
    return "Data{" +
        "movie=" + movie +
        ", poster=" + poster +
        ", genre=" + genre +
        ", duration=" + duration +
        ", schedule=" + schedule +
        '}';
  }
}
