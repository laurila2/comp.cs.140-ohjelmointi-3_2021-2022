package Standinds;

import java.util.ArrayList;

public class Standings {

    private ArrayList<Team> all_teams = new ArrayList<Team>();

    public Standings(String filename) {
        Standings standings = new Standings(filename);
    }
    public Standings() {}

    public void readMatchData(String args) {
        String[] match_data = args.split("\\t");
        String[] scores = match_data[1].split("-");

        String teamNameA = match_data[0];
        String teamNameB = match_data[2];
        Integer goalsA = Integer.valueOf(scores[0]);
        Integer goalsB = Integer.valueOf(scores[1]);

        addMatchResult(teamNameA, goalsA, goalsB, teamNameB);
    }

    public void addMatchResult(String teamNameA, int goalsA, int goalsB, String teamNameB) {

        if (!all_teams.contains(teamNameA)) {
            Team A = new Team(teamNameA);
            all_teams.add(A);
        }
        else if (!all_teams.contains(teamNameB)) {
            Team B = new Team(teamNameB);
            all_teams.add(B);
        }

        for (Team team : all_teams) {
            if (teamNameA.equals(team.getName())) {
                Team A = team;
                if (goalsA > goalsB) {
                    A.addWin();
                    A.addPoints(3);
                } else if (goalsA == goalsB) {
                    A.addTie();
                    A.addPoints(1);
                } else {
                    A.addLoss();
                }
                A.addScored(goalsA);
                A.addAllowed(goalsB);
            }
            else if (teamNameB.equals(team.getName())) {
                Team B = team;
                if (goalsA > goalsB) {
                    B.addLoss();
                } else if (goalsA == goalsB) {
                    B.addTie();
                    B.addPoints(1);
                } else {
                    B.addWin();
                    B.addPoints(3);
                }
                B.addScored(goalsB);
                B.addAllowed(goalsA);
            }
        }
    }

    public ArrayList<Team> getTeams() {
        return this.all_teams;
    }

    public void printStandings() {
        for (Team name : all_teams) {
            System.out.format(name.getName() + "   ");
            System.out.format(name.getGames() + " ");
            System.out.format(name.getWins() + " " + name.getTies() + " " + name.getLosses() + " ");

            System.out.format(name.getScored() + "-" + name.getAllowed());
            System.out.format("  " + name.getPoints() );
            System.out.format("\n");
        }
    }


    public class Team {
            private String name;
            private int Wins = 0;
            private int Ties = 0;
            private int Losses = 0;
            private int Scored = 0;
            private int Allowed = 0;
            private int Points = 0;
            private int Games = 0;

            public Team(String name) {
                this.name = name;
            }

            public String getName() {
                return this.name;
            }

            public Integer getWins() {
                return this.Wins;
            }

            public Integer getTies() {
                return this.Ties;
            }

            public Integer getLosses() {
                return this.Losses;
            }

            public Integer getScored() {
                return this.Scored;
            }

            public Integer getAllowed() {
                return this.Allowed;
            }

            public Integer getPoints() {
                return this.Points;
            }

            public Integer getGames() {
                return this.Games;
            }

            public void addWin() {
                this.Wins++;
            }

            public void addTie() {
                this.Ties++;
            }

            public void addLoss() {
                this.Losses++;
            }

            public void addGames() {
                this.Games++;
            }

            public void addPoints(int points) {
                this.Points += points;
            }

            public void addAllowed(int allowed) {
                this.Allowed += allowed;
            }

            public void addScored(int scored) {
                this.Scored += scored;
            }
    }

    public static void main(String[] args) {
        Standings standings = new Standings();
        standings.addMatchResult("Tonga", 0, 3, "Cook Islands");
        standings.addMatchResult("Samoa", 3, 2, "American Samoa");
        standings.addMatchResult("Cook Islands", 1, 0, "Samoa");
        standings.addMatchResult("Tonga", 1, 2, "American Samoa");
        standings.addMatchResult("Tonga", 0, 3, "Samoa");
        standings.addMatchResult("American Samoa", 2, 0, "Cook Islands");
        standings.printStandings();
    }
}
