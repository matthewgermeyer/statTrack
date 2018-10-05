package com.trane.statTrack.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Detail {

  String timeStamp;
  String description;

  //Constructors 2
  public Detail(String description) {
    this.timeStamp = timeStamp();
    this.description = description;
  }

  public Detail() {}


  //getters and setters
  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  //Overriden methods
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Detail detail = (Detail) o;
    return Objects.equals(timeStamp, detail.timeStamp) &&
        Objects.equals(description, detail.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeStamp, description);
  }


  public static String timeStamp() {
  String time = new SimpleDateFormat("HH.mm.ss").format(new Date());
  return time;
}
}
