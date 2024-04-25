import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FootballTeamComparableTest {

private static final int  ANY_NUMBER = 123;

@Test
  void shouldBePossibleToCompareTeams() {
    FootballTeam team = new FootballTeam(ANY_NUMBER);
    assertThat(team).isInstanceOf(Comparable.class);
  }

  @Test
  void teamsWithMoreMatchesWonShouldBeGreater() {
    FootballTeam team_2 = new FootballTeam(2);
    FootballTeam team_3 = new FootballTeam(3);
    assertThat(team_3.compareTo(team_2)).isGreaterThan(0);
  }

  @Test
  void teamsWithLessMatchesWonShouldBeLesser() {
    FootballTeam team_2 = new FootballTeam(2);
    FootballTeam team_3 = new FootballTeam(3);
    assertThat(team_2.compareTo(team_3)).isLessThan(0);
  }

  @Test
  void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
    FootballTeam teamA = new FootballTeam(2);
    FootballTeam teamB = new FootballTeam(2);
    assertThat(teamA.compareTo(teamB)).isEqualTo(0);
  }
}
