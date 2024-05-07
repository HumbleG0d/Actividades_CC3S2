# Ritmo-TDD
## Refactorización
-   Vamos a refactorizar el metodo `asses` de la clase `Score`.
```java 
public void assess(int position, String attempt) {
    for (int i = position; i < attempt.length(); i++) {
       if (correct.charAt(i) == attempt.
               charAt(i)) {
          result = Letter.CORRECT;
       } else {
          result = Letter.INCORRECT;
          break;
       }
    }
}
```
***Refactorizado*** 
```java
public void assess(String attempt) {
  for (char current: attempt.toCharArray()) {
    results.add(scoreFor(current) );
    position++;
    }
  }
    
  private boolean occursInWord(char current) {
     return correct.contains(String.valueOf(current));
  }
    
  private boolean isCorrectLetter(char currentLetter) {
      return correct.charAt(position) == currentLetter;
 }
    
 private Letter scoreFor(char current) {
    if (isCorrectLetter(current)) {
        return Letter.CORRECT;}
    if (occursInWord(current)) {
        return Letter.PART_CORRECT;
    }
    return Letter.INCORRECT;
}
```
- Ahora refactorizamos los test.
```java
@Test
    void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertThat(score.letter()).isEqualTo(CORRECT);
    }
```
***Refactorizado***
```java
@Test
    void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForGuess(score, CORRECT);
    }
```
```java
private void assertScoreForGuess(Score score,
                                     Letter... expectedScores) {
        for (int position = 0;
             position < expectedScores.length;
             position++) {
            Letter expected =
                    expectedScores[position];
            assertThat(score.letter(position))
                    .isEqualTo(expected);
        }
    }
```
- Ejecución de los test.
  ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/2024-1/Actividad5-TDD/assets/Captura_PASSED.png)
