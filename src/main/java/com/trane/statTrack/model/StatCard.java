package com.trane.statTrack.model;

import com.trane.statTrack.util.Action;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatCard {
    private List<Action> actions;
    private List<Detail> actionDetails;
    private Map<Action, Detail> stats = new HashMap<>();


    public StatCard() {
        this.actions = Arrays.asList(Action.values());
        this.actionDetails = new ArrayList<>();
    }

    //Getters and Setters
    //Getters and Setters
    public List<Action> getAction() {
        return actions;
    }

    public void setAction(List<Action> action) {
        this.actions = action;
    }

    public List<Detail> getActionDetails() {
        return actionDetails;
    }

    public void setActionDetails(List<Detail> actionDetails) {
        this.actionDetails = actionDetails;
    }

    public Map<Action, Detail> getStats() {
        return stats;
    }

    public void setStats(
        Map<Action, Detail> stats) {
        this.stats = stats;
    }

    public static void StartGame() {
        StopWatch.createStarted();

    }


    public void addGoal() {
        if (stats == null) {
            System.out.println("BLOW UP!");
        }
        if (stats.get(Action.GOAL) == null) {
            stats.put(Action.GOAL, new Detail(Action.GOAL));
            Detail d = stats.get(Action.GOAL);
            d.tallyAction();
            System.out.println("First Goal!");
        }

        Detail d = stats.get(Action.GOAL);
        d.tallyAction();
        System.out.println("Another Goal!");
    }

    public void report() {
        System.out.printf("===================%n");
        System.out.printf("Actions: %s%n Details: %s%n", this.getAction(), actionDetails);
        System.out.printf("===================%n");
    }
}
