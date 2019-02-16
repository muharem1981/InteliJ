#Author: hiqatech@gmail.com
#Keywords Summary : YouTube Search Tests

Feature: YouTube Search Tests

  @Smoke
  Scenario:YouTube - I can find and play my music
    Given I navigate to the "Home" page
    And I am on the "Main" page
    And I "enter" "Dash Berlin - With you" into the "search_field" element
    When I "select" the "search_submit" element
    Then I "select" the "play_that" element
    And I wait "24" sec/s

    #And I have fun :)
