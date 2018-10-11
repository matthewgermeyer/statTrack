package com.trane.statTrack.util;

public enum Action {
    PASS("Passes: ", "#2ECC40"),
    SHOT("Shots: ", "#FF4136"),
    GOAL("Goals: ", "#FF4136"),
    SKILL("Skills: ", "#2ECC40"),
    TAKEON("Take Ons: ", "#2ECC40"),
    KEYPASS("Key Passes: ", "#2ECC40"),
    SAVE("Saves: ", "#b36859"),
    MISTAKE("Mistakes: ", "#FF4136");

    private final String representation;
    private final String hex;

    Action(String representation, String hex) {
        this.representation = representation;
        this.hex = hex;
    }

    public String getRepresentation() {
        return representation;
    }

    public String getHex() {
        return hex;
    }
}
