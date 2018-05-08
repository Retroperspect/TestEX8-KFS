Feature: Triangles Area

Scenario: A Equaleteral Triangle
Given A Triangle with sides 25,25,25
When I ask the area
Then I should be told "270.633"


Scenario: A Different Triangle
Given A Triangle with sides 684,534,792
When I ask the area
Then I should be told "179901.922"

Scenario: Angle of that a Triangle
Given A Triangle with sides 25,25,25
When I ask the Angles
Then I should be given "60.0,60.0,60.0"