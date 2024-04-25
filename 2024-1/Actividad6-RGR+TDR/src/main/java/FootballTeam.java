public class FootballTeam implements Comparable<FootballTeam> {
    private final int gasmesWon;
    public FootballTeam(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("Not possible to have taken negative games won, you cheater! Go of");
        }
        this.gasmesWon = gamesWon;
    }
    public int getGamesWon() {
        return  gasmesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
      return Integer.compare(gasmesWon, otherTeam.gasmesWon);
    }
}
