package com.trane.statTrack.model;

import com.trane.statTrack.util.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Detail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //  private final
  private String name;
  private List<String> timestamps = new ArrayList<>();
  private int count = 0;

  //Constructors
  public Detail(Action action) {
    this.name = action.name();
  }

  //getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
        Objects.equals(id, detail.id) &&
        Objects.equals(timestamps, detail.timestamps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timestamps, count);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Detail{");
    sb.append(name).append(": " + count);
    sb.append("times: %s ");
    sb.append(timestamps);
    return sb.toString();
  }

  public void tallyAction() {
    count += 1;
    timestamps.add("Now");
  }

} //class
