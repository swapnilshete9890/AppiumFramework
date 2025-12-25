Feature: Calculator operations
  As a user
  I want to perform calculator operations
  So that correct results and errors are displayed

  Background:
    Given calculator app is launched

  Scenario: Addition of two numbers
    When I add two numbers
    Then result should be displayed

  Scenario: Multiplication of two numbers
    When I multiply two numbers
    Then result should be displayed

  Scenario: Division by zero
    When I divide a number by zero
    Then error message should be displayed
