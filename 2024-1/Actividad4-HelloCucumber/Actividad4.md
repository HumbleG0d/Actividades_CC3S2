# Actividad : Gherkin y Cucumber

## Escenarios agregados:

1.  Escenario de espera sin comer pepinos:
    ```gherkin
    Scenario: Wait without eating cucumbers
      Given I have eaten 0 cukes
      When I wait 1 hour
      Then my belly should not growl
    ```
2. Escenario de comer menos de 10 pepinos en 2 horas:
    ```gherkin
    Scenario: Eat less than 10 cucumbers and wait
      Given I have eaten 5 cukes
      When I wait 2 hour
      Then my belly should not growl
    ```
3. Escenario de comer extamente 10 pepinos:
    ```gherkin
    Scenario: Eat exactly 10 cucumbers
      Given I have eaten 10 cukes
      When I wait 2 hour
      Then my belly should not growl
    ```
 4. Escenario de comer más de 10 pepinos pero esperar menos de 2 horas
    ```gherkin
    Scenario: Eat more than 10 cucumbers and wait less than 2 hours
      Given I have eaten 15 cukes
      When I wait 1 hour
      Then my belly should not growl
    ```
5. Escenario de comer más de 10 pepinos y esperar mas de 2 horas
    ```gherkin
    Scenario: Eat more than 10 cucumbers and wait more than 2 hours
      Given I have eaten 30 cukes
      When I wait 3 hour
      Then my belly should growl
    ```