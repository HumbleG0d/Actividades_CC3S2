import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FootballTeamTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 10})
    void constructorShouldSetGamesWonParameterized(int nbOfGamesWon) {
        FootballTeam team = new FootballTeam(nbOfGamesWon);
        assertThat(team.getGamesWon())
                .as("number of games won")
                .isEqualTo(nbOfGamesWon);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    void constructorShouldSetGamesWonParameterizedNegative(int nbOfGamesWon) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new FootballTeam(nbOfGamesWon));
    }
}



