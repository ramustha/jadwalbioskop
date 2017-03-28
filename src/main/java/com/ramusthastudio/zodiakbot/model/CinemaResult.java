package com.ramusthastudio.zodiakbot.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CinemaResult {
  @SerializedName("status")
  private Object status;
  @SerializedName("kota")
  private Object city;
  @SerializedName("date")
  private Object date;
  @SerializedName("data")
  private List<Data> cinemaDatas = null;

  public Object getStatus() { return status; }
  public Object getCity() { return city; }
  public Object getDate() { return date; }
  public List<Data> getCinemaDatas() { return cinemaDatas; }

  public CinemaResult setStatus(Object aStatus) {
    status = aStatus;
    return this;
  }
  public CinemaResult setCity(Object aCity) {
    city = aCity;
    return this;
  }
  public CinemaResult setDate(Object aDate) {
    date = aDate;
    return this;
  }
  public CinemaResult setCinemaDatas(List<Data> aCinemaDatas) {
    cinemaDatas = aCinemaDatas;
    return this;
  }

  @Override public String toString() {
    return "Result{" +
        "status=" + status +
        ", city=" + city +
        ", date=" + date +
        ", datas=" + cinemaDatas +
        '}';
  }
}

