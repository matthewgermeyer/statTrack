package com.trane.statTrack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Detail extends BaseEntity {
  private String name;
  private List<String> timestamps = new ArrayList<>();
  private static int count = 0;

  //Constructors
  public Detail(Action action) {
    super();
    this.name = action.name();
  }

  //getters and setters
  public List<String> getTimestamps() {
    return timestamps;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTimestamps(List<String> timestamps) {
    this.timestamps = timestamps;
  }

  public int getCount() {
    return count;
  }

  //Overriden Methods
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Detail detail = (Detail) o;
    return count == detail.count &&
        Objects.equals(name, detail.name) &&
        Objects.equals(timestamps, detail.timestamps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, timestamps, count);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Detail{");
    sb.append(name).append(": " + count);
    sb.append("times: %s ");
    sb.append(timestamps);
    return sb.toString();
  }

  //functionality
  public void tallyAction() {
    count += 1;
    timestamps.add("Now");
  }

} //class
