package com.pinakdas;

public class Team<T extends Sport> implements Comparable<Team<T>> {
    private String name;
    private int played;
    private int won;
    private int tied;
    private int loss;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getTied() {
        return tied;
    }

    public int getLoss() {
        return loss;
    }

    public void matchResult(Team<T> team, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            this.won++;
        } else if (theirScore > ourScore) {
            this.loss++;
        } else {
            this.tied++;
        }
        this.played++;

        if (team != null) {
            team.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (3 * won) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
