package com.pinakdas;

public class Base {
    public static void main(String[] args) {
        Team<Football> liverpool = new Team<>("Liverpool F.C.");
        Team<Football> manchesterUtd = new Team<>("MCR Utd F.C.");
        Team<Football> arsenal = new Team<>("Arsenal F.C.");
        Team<Football> manchesterCity = new Team<>("MCR City F.C");
        Team<Football> chelsea = new Team<>("Chelsea F.C.");
        League<Team<Football>> footballLeague = new League<>("English Premier League");
        footballLeague.addTeam(liverpool);
        footballLeague.addTeam(manchesterCity);
        footballLeague.addTeam(manchesterUtd);
        footballLeague.addTeam(arsenal);
        footballLeague.addTeam(chelsea);

        arsenal.matchResult(liverpool, 2, 2);
        arsenal.matchResult(manchesterUtd, 1, 3);
        arsenal.matchResult(manchesterCity, 1, 0);
        arsenal.matchResult(chelsea, 0, 0);
        footballLeague.showPoints();

        League<Team<Cricket>> cricketLeague = new League<>("Indian Premier League");
        Team<Cricket> kkr = new Team<>("Kolkata Knight Riders");
        Team<Cricket> bangalore = new Team<>("Bangalore Royal Challengers");
        Team<Cricket> mumbai = new Team<>("Mumbai Indians");
        cricketLeague.addTeam(kkr);
        cricketLeague.addTeam(bangalore);
        cricketLeague.addTeam(mumbai);
    }
}
