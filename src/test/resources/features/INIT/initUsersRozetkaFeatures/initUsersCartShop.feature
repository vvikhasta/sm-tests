@init:user
Feature: Cart shop (init users)

  Scenario Outline: 1 - Adding Rozetka user
    Given user tries to log in with '<uLogin>' and '<password>'


    Examples:
      | uLogin | password |
      |        |          |