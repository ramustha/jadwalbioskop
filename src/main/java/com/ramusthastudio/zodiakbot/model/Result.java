package com.ramusthastudio.zodiakbot.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Result {
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

  public Result setStatus(Object aStatus) {
    status = aStatus;
    return this;
  }
  public Result setCity(Object aCity) {
    city = aCity;
    return this;
  }
  public Result setDate(Object aDate) {
    date = aDate;
    return this;
  }
  public Result setCinemaDatas(List<Data> aCinemaDatas) {
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

