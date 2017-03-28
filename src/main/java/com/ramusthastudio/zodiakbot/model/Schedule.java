package com.ramusthastudio.zodiakbot.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Schedule {
  @SerializedName("bioskop")
  private Object theater;
  @SerializedName("bioskop")
  private List<Object> scheduleTimes = null;
  @SerializedName("harga")
  private Object price;

  public Object getTheater() { return theater; }
  public List<Object> getScheduleTimes() { return scheduleTimes; }
  public Object getPrice() { return price; }

  public Schedule setTheater(Object aTheater) {
    theater = aTheater;
    return this;
  }
  public Schedule setScheduleTimes(List<Object> aScheduleTimes) {
    scheduleTimes = aScheduleTimes;
    return this;
  }
  public Schedule setPrice(Object aPrice) {
    price = aPrice;
    return this;
  }

  @Override public String toString() {
    return "Schedule{" +
        "theater=" + theater +
        ", scheduleTimes=" + scheduleTimes +
        ", price=" + price +
        '}';
  }
}
