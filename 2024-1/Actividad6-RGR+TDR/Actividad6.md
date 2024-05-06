# Actividad 6 : RGR + TDD

## Problema:
Vamos a jugar un poco al fútbol, ¿de acuerdo? Implementaremos una clase FootballTeam, para que
podamos comparar diferentes equipos y ver quién ocupa el primer lugar en la liga. Cada equipo lleva
un registro del número de juegos ganados.
Ahora tenemos que pensar en esto. Imaginemos las funcionalidades de la clase y los resultados
esperados. Todo lo que necesitamos es una idea aproximada, y algunas conjeturas sobre la
implementación. Los detalles vendrán más tarde – no necesitamos pensar demasiado en este
momento. Deberíamos tener al menos algunas ideas sobre pruebas, para poder hacer el primer
movimiento. Ok, pensemos en esto.
Entonces, en nuestro ejemplo tenemos dos equipos y necesitamos compararlos. Parece que puedo
usar una interfaz Comparable. Sí, este es un patrón común de Java para comparación… no necesito
pensar en nada extravagante aquí... Bueno... Ahora, si vamos a compararlos, cada equipo necesita
recordar el número de juegos que ha ganado, y el mecanismo de comparación los utilizará. Así que
una clase FootballTeam necesita un campo en el que guardar esta información, y este campo de
alguna manera debe ser accesible... Bien... y lo más importante es la comparación... Necesitamos
algunas pruebas aquí: necesitamos ver que los equipos con más victorias estén clasificados primero,
y necesitamos verificar qué sucede cuando dos equipos tienen el mismo número de victorias.
-- Tomek Dump of a Train of Thought (2011)
Como ves, algunos pensamientos sobre "API externa" se mezclan con pensamientos sobre
"implementación interna" aquí. Sí, supongo que esto no puede evitarse. De todos modos, esto
parece suficiente para comenzar.

## Tests: Usando la interfaz Comparable
### 1. shouldBePossibleToCompareTeams
Este test verifica si la clase FootballTeam implementa la interfaz Comparable. Se espera que la clase FootballTeam implemente Comparable para permitir la comparación entre equipos de fútbol basada en el número de partidos ganados.
```java
@Test
  void shouldBePossibleToCompareTeams() {
    FootballTeam team = new FootballTeam(ANY_NUMBER);
    assertThat(team).isInstanceOf(Comparable.class);
  }
```
### 2. teamsWithMoreMatchesWonShouldBeGreater

Este test verifica si un equipo con más partidos ganados debe considerarse "mayor" que otro equipo con menos partidos ganados. Se crean dos equipos, `team_2` con 2 partidos ganados y `team_3` con 3 partidos ganados. Se espera que `team_3.compareTo(team_2)` devuelva un valor mayor que 0, lo que indica que `team_3` es "mayor" que `team_2`.

```java
 @Test
void teamsWithMoreMatchesWonShouldBeGreater() {
  FootballTeam team_2 = new FootballTeam(2);
  FootballTeam team_3 = new FootballTeam(3);
  assertThat(team_3.compareTo(team_2)).isGreaterThan(0);
}
```
### 3. Test: teamsWithLessMatchesWonShouldBeLesser

Este test verifica si un equipo con menos partidos ganados debe considerarse "menor" que otro equipo con más partidos ganados. Se crean dos equipos, `team_2` con 2 partidos ganados y `team_3` con 3 partidos ganados. Se espera que `team_2.compareTo(team_3)` devuelva un valor menor que 0, lo que indica que `team_2` es "menor" que `team_3`.

```java
@Test
void teamsWithLessMatchesWonShouldBeLesser() {
  FootballTeam team_2 = new FootballTeam(2);
  FootballTeam team_3 = new FootballTeam(3);
  assertThat(team_2.compareTo(team_3)).isLessThan(0);
}
```
### 4. Test: teamsWithSameNumberOfMatchesWonShouldBeEqual

Este test verifica si dos equipos con el mismo número de partidos ganados deben considerarse "iguales". Se crean dos equipos, `teamA` y `teamB`, ambos con 2 partidos ganados. Se espera que `teamA.compareTo(teamB)` devuelva 0, lo que indica que `teamA` y `teamB` son "iguales" en términos de número de partidos ganados.

```java
 @Test
  void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
    FootballTeam teamA = new FootballTeam(2);
    FootballTeam teamB = new FootballTeam(2);
    assertThat(teamA.compareTo(teamB)).isEqualTo(0);
  } 
```
## Compilación de los tests
![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/2024-1/Actividad6-RGR+TDR/assets/Captura_Tests.png)
   