# Actividades de desarrollo de software

## Actividad 1
1. Explica el siguiente gráfico en términos de SUT y DOC para pruebas unitarias
![](https://github.com/HumbleG0d/Actividades_CC3S2/tree/main/2024-1/Actividad1-Testing/assets/Captura.png)
   - Tenemos la clase Test , esta clase es la encargada de realizar las pruebas unitarias a la clase que se quiere probar, supongamos que esta clase tiene un un método getA(valor), esté métedo vendria a ser el SUT que toma una entrada(input) y retorna una salida(output). El método getA(valor) tiene un DOC(métodos que interactuan con el SUT) , supongamos que sea el método getB(valor) que es el encargado de retornar el valor de la variable b, que es un atributo de la clase Test.
    Resuminendo: El gráfico muestra el testing de la clase Test , donde el SUT es un método de dicha clase y el DOC es un método que interactua con el SUT.
 
  
2. Imaginemos algún servicio financiero (clase FinancialService) que, en función del último pago del cliente y su tipo (cualquiera que sea), calcula algún "bonus".
   ```
   public class FinancialService {
    .... // definition of fields and other methods omitted
    public BigDecimal calculateBonus(long clientId, BigDecimal payment) {
       Short clientType = clientDAO.getClientType(clientId);
       BigDecimal bonus = calculator.calculateBonus(clientType, payment);
       clientDAO.saveBonusHistory(clientId, bonus);
       return bonus;
    }
   }
     ```
    Identifica el SUT y sus colaboradores (DOC) y describe los tipos de interacción que ocurren dentro del método calculateBonus() importantes para la prueba.
    
    - SUT: calculateBonus(long clientId, BigDecimal payment)
    - DOC: 
        - clientDAO.getClientType(clientId)
        - calculator.calculateBonus(clientType, payment)
        - clientDAO.saveBonusHistory(clientId, bonus)
    - Descripción: 
        - clientDAO.getClientType(clientId): Este método se encarga de obtener el tipo de cliente a partir de su id.
        - calculator.calculateBonus(clientType, payment): Este método se encarga de calcular el bonus en función del tipo de cliente y el pago.
        - clientDAO.saveBonusHistory(clientId, bonus): Este método se encarga de guardar el historial de bonus del cliente.


3. Sea la abstracción POO siguiente:
   ![](https://github.com/HumbleG0d/Actividades_CC3S2/tree/main/2024-1/Actividad1-Testing/assets/Captura2.png)
    ¿Como crees que serían las pruebas de los trabajos y la de los gerentes? ¿Por qué preocuparse por las interacciones indirectas?
    
   - Las pruebas de los trabajos y los gerentes serían pruebas unitarias, donde se probarían los métodos de las clases workers y Manager. 
   - Es importante preocuparse por las interacciones indirectas porque estas pueden afectar el comportamiento de los métodos que se están probando. Por ejemplo, si el método de un trabajador depende de un método de un gerente, es importante probar que el método del gerente funciona correctamente para asegurarse de que el método del trabajador también funcione correctamente.


4. Completa en la actividad dada en el repositorio el código fuente para pasar las pruebas.

     ```
   @Test 
   void constructorShouldSetAmountAndCurrency() {
        //Arrange
        int amount = 10; // Cantidad de dinero
        String currency = "USD"; // Moneda

        //Act
        var money = new Money(amount , currency); // Crear objeto Money

        //Assert
        assertThat(money.getCurrency()).as("Currency should be set").isEqualTo(currency); // Verificar que la moneda sea la misma
        assertThat(money.getAmount()).as("Amount should be set").isEqualTo(amount); // Verificar que la cantidad sea la misma
    }
    ```

5.  ¿Cuál es la diferencia entre una prueba unitaria y otros tipos de pruebas, como las pruebas de integración o las pruebas de aceptación?

    - Las pruebas unitarias prueban unidades individuales de código, como métodos o funciones, de forma aislada. Las pruebas de integración prueban cómo interactúan varias unidades de código entre sí. Las pruebas de aceptación prueban si el software cumple con los requisitos del cliente.


