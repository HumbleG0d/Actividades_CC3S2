package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

class WordTest {
    @Test
    // Verificamos que si adivinamos una letra correctamente en la posición correcta, se devuelva CORRECT.
    void oneCorrectLetter() {
        //Arrange
        var word = new Word("A");
        //Act
        var score = word.guess("A");
        //Assert
        assertThat(score.letter()).isEqualTo(CORRECT);
    }

    @Test
    // Verificamos que si adivinamos una letra incorrecta, se devuelva INCORRECT.
    void oneIncorrectLetter() {
        //Arrange
        var word = new Word("AC");
        //Act
        var score = word.guess("AB");
        //Assert
        assertThat(score.letter()).isEqualTo(INCORRECT);
    }

    @Test
    // Verificamos que si adivinamos todas las letras correctamente en las posiciones correctas, se devuelva CORRECT para cada letra.
    void allCorrectLetters() {
        //Arrange
        String WORD = "AVOID";
        var word = new Word(WORD);
        //Act
        var score = word.guess(WORD);
        //Assert
        assertThat(score.letter()).isEqualTo(CORRECT);

    }
    @Test
    // Verificamos que si no adivinamos todas las letras correctamente en las posiciones correctas, se devuelva INCORRECT para cada letra.
    void allIncorrectLetters() {
        //Arrange
        String WORD = "AVOID";
        var word = new Word(WORD);
        //Act
        var score = word.guess("BEGIN");
        //Assert
        assertThat(score.letter()).isEqualTo(INCORRECT);
    }

    @Test
    void partCorrectLetters() {
        //Arrange
        String WORD = "AVOID";
        var word = new Word(WORD);
        //Act
        var score = word.guess("AVOIL");
        //Assert
        assertThat(score.letter()).isEqualTo(PART_CORRECT);
    }
}
