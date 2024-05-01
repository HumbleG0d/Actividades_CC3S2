# Actividad5: Introdución al TDD
TDD es un complemento perfecto para el desarrollo ágil. TDD nos ayuda a mejorar nuestro diseño y
probar que nuestra lógica es correcta. Todo lo que hacemos tiene como objetivo entregar software
funcional a nuestros usuarios, sin defectos, lo más rápido posible. TDD es una excelente manera de
lograr esto.
El flujo de trabajo que usaremos es típico para un proyecto TDD ágil:
1. Elija una historia de usuario priorizada por impacto.
2. Piensa un poco en el diseño al que aspiras.
3. Usa TDD para escribir la lógica de la aplicación en la parte central
4. Usa TDD para escribir código para conectar la parte central una base de datos.
5. Usa TDD para escribir código para conectarse a un punto final de API.
   Este proceso se repite. Forma el ritmo de escribir la lógica de la aplicación central bajo una prueba
   unitaria, luego hacer crecer la aplicación hacia afuera, conectándola a puntos finales de API,
   interfaces de usuario, bases de datos y servicios web externos. 

## Usemos TDD para programar para el juego Wordz
Wordz es un juego de palabras en el que los jugadores intentan adivinar una palabra secreta de 5 letras. Los
jugadores pueden adivinar una letra a la vez. Si adivinan una letra que está en la palabra secreta, se
muestra la letra en la palabra. Si adivinan una letra que no está en la palabra, se muestra un mensaje
de error. Los jugadores tienen un número limitado de intentos para adivinar la palabra secreta. Si
adivinan la palabra antes de quedarse sin intentos, ganan. Si no adivinan la palabra antes de quedarse
sin intentos, pierden.

### Historia de usuario
1. Como jugador, quiero poder adivinar letras en una palabra secreta para que pueda adivinar la palabra
secreta y ganar el juego.

  * Empezamos con una prueba unitaria que nos arroje un puntuación por cada letra correcta que se adivine.
```java
    @Test
    void oneCorrectLetter() {
       
        var word = new Word("A");
       
        var score = word.guess("A");
       
        assertThat(score.letter()).isEqualTo(CORRECT);
    }
  ```
  * Luego, escribimos el código necesario para que la prueba pase.
```java
    public class Word {
        private final String word;
       
        public Word(String word) {
            this.word = word;
        }
       
        public Score guess(String letter) {
            return new Score(CORRECT);
        }
    }
```
```java
public class Score {
    private final String correct;

    private Letter result = Letter.INCORRECT ;

    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter() {
        return result;
    }

    public void assess(int position, String attempt) {
        // Si la letra es correcta, se mantiene el valor de result.
       if (correct.charAt(position) == attempt.
               charAt(position)) {
          result = Letter.CORRECT;
       }
    }
}
```
```java
public enum Letter {
   CORRECT, PART_CORRECT, INCORRECT
}
```
  * Escribimos una prueba unitaria para que el código nos arroje un puntuación por cada letra incorrecta que se adivine.
```java
    @Test
    void oneIncorrectLetter() {
       
        var word = new Word("A");
       
        var score = word.guess("B");
       
        assertThat(score.letter()).isEqualTo(INCORRECT);
    }
```
* En la anteior prueba si hacemos pasar como parametro "AC" en vez de "A" y "AB" en vez de "B" , la prueba fallara.
![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/2024-1/Actividad5-TDD/assets/Captura_INCORRECT.png)

* Para que la prueba unitaria pase tenemos que cambiar la logica del metodo asses de la clase Score.
```java
     public void assess(int position, String attempt) {
   // Si la letra es correcta, se mantiene el valor de result.
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
* Escribimos una prueba unitaria para que el código nos arroje una puntuación por la palabra adivinada.
```java
   @Test
   void allCorrectLetters() {
      //Arrange
      String WORD = "AVOID";
      var word = new Word(WORD);
      //Act
      var score = word.guess(WORD);
      //Assert
      assertThat(score.letter()).isEqualTo(CORRECT);
   }
```
* Escribimos una prueba unitaria para verificar si la palabra no fue adivinada.
```java
   @Test
   void allIncorrectLetters() {
      
      String WORD = "AVOID";
      var word = new Word(WORD);
      
      var score = word.guess("BEGIN");
      
      assertThat(score.letter()).isEqualTo(INCORRECT);
   }
```

* Escribimos una prueba unitaria para que el código nos arroje una puntuación si la palabra fue parcialmente adivinada.
```java
   @Test
   void allCorrectLetters() {
      //Arrange
      String WORD = "AVOID";
      var word = new Word(WORD);
      //Act
      var score = word.guess(WORD);
      //Assert
      assertThat(score.letter()).isEqualTo(PART_CORRECT);
   }
```
Observamos que la prueba unitaria falla.
![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/2024-1/Actividad5-TDD/assets/Captura_PART_CORRECT.png)

* Para que la prueba unitaria pase tenemos que cambiar la logica del metodo asses de la clase Score.
```java
   public void assess(int position, String attempt) {
      // Si la letra es correcta, se mantiene el valor de result.
      for (int i = position; i < attempt.length(); i++) {
         if (correct.charAt(i) == attempt.
                 charAt(i)) {
            result = Letter.CORRECT;
         } else if (correct.charAt(i) != attempt.charAt(i) && (i == 4)){
            result = Letter.PART_CORRECT;
         } else {
            result = Letter.INCORRECT;
            break;
         }
      }
   }
```
Finalmente, todas las pruebas unitarias pasan.
![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/2024-1/Actividad5-TDD/assets/Captura_TEST_PASSED.png)

