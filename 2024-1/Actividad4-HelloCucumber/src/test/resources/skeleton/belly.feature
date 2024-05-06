Feature: BellyFeature

  Scenario: Eaten many cukes and growl
    Given I have eaten 27 cukes
    When I wait 2 hour
    Then my belly should growl

  Scenario: Eaten many cukes and growl
    Given I have eaten 9 cukes
    When I wait 1 hour
    Then my belly should not growl

  Scenario: Wait without eating cucumbers
    Given I have eaten 0 cukes
    When I wait 1 hour
    Then my belly should not growl

  Scenario: Eat less than 10 cucumbers and wait
    Given I have eaten 5 cukes
    When I wait 2 hour
    Then my belly should not growl

  Scenario: Eat exactly 10 cucumbers and wait
    Given I have eaten 10 cukes
    When I wait 2 hour
    Then my belly should not growl

  Scenario: Eat more than 10 cucumbers and wait less than 2 hours
    Given I have eaten 15 cukes
    When I wait 1 hour
    Then my belly should not growl

  Scenario: Eat more than 10 cucumbers and wait more than 2 hours
    Given I have eaten 30 cukes
    When I wait 3 hour
    Then my belly should growl
