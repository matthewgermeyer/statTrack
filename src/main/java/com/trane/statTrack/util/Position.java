package com.trane.statTrack.util;

public enum Position {
  GOALKEEPER("GoalKeeper", "#b36859"),
  DEFENDER("Defender","#5976b3"),
  MIDFIELDER("Midfielder","#2ECC40"),
  FORWARD("Forward","#FF4136");

  private final String name;
  private final String hexCode;

  Position(String name, String hexCode) {
    this.name = name;
    this.hexCode = hexCode;
  }

  public String getName() {
    return name;
  }

  public String getHexCode() {
    return hexCode;
  }
}

