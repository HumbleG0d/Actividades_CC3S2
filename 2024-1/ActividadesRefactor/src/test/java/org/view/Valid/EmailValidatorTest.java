import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.view.Interface.Validation;
import org.view.Valid.EmailValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorTest {
  private Validation emailValidator;
  @BeforeEach
  void setUp() {
   emailValidator = new EmailValidator();
  }

 @ParameterizedTest
 @ValueSource(strings = {"hola@gmail.com" , "pepe@hotmail.com" , "nose123@hola.pe"})
  void validEmailValues(String email) {
    assertTrue(emailValidator.valid(email));
  }

  @ParameterizedTest
  @ValueSource(strings = {"hola@" , "pepe@hotmail" , "nose123@hola"})
  void notValidEmailValues(String email) {
    assertFalse(emailValidator.valid(email));
  }

}
