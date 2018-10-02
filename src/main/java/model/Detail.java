package model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Detail {

  String timeStamp;
  String description;

  public Detail(String timeStamp, String description) {
    this.timeStamp = timeStamp;
    this.description = description;

  }

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
public static String timeStamp() {
  String time = new SimpleDateFormat("HH.mm.ss").format(new Date());
  return time;
}
}
