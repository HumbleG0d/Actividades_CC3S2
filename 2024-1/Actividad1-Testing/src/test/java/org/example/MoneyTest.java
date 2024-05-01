package org.example;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyTest {
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
}