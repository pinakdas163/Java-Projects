package com.pinakdas;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> teams;

    public League(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (teams.contains(team)) {
            return false;
        } else {
            teams.add(team);
            return true;
        }
    }

    public void showPoints() {
        Collections.sort(teams);
        System.out.println("Teams\t\t\t\t" + "Won  " + "Loss  " + "Tied");
        for (T team : teams) {
            System.out.println(team.getName() + "\t\t" + team.getWon() + "      " + team.getLoss() + "      " + team.getTied());
        }
    }
}
