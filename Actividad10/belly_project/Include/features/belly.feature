Feature: Característica del Estómago
    Scenario: comer muchos pepinos y gruñir
        Given que he comido 42 pepinos
        When espero 2 horas
        Then mi estómago debería gruñir

    Scenario: comer pocos pepinos y no gruñir
        Given que he comido 10 pepinos
        When espero 2 horas
        Then mi estómago no debería gruñir

    Scenario: comer muchos pepinos y esperar menos de una hora
        Given que he comido 50 pepinos
        When espero media hora
        Then mi estómago no debería gruñir

    Scenario: comer pepinos y esperar en minutos
        Given que he comido 30 pepinos
        When espero 90 minutos
        Then mi estómago debería gruñir

    Scenario: comer pepinos y esperar en diferentes formatos
        Given que he comido 25 pepinos
        When espero "dos horas y treinta minutos"
        Then mi estómago debería gruñir