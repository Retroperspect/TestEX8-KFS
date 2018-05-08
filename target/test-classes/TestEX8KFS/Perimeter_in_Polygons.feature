Feature: Perimeter in polygons

  Scenario: Perimeter of Triangle
    Given A Triangle with sides 25,25,25
    When I ask for the Perimeter of the triangle
    Then I should be told 75