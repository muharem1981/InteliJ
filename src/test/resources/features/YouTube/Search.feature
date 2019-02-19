#Author: hiqatech@gmail.com
#Keywords Summary : YouTube Search Tests

Feature: YouTube Search Tests

  @Smoke
  Scenario:YouTube - I can find and play my music
    Given I navigate to the Home page
    And I "enter" "Dash Berlin - With you" into the "search_field" element
    When I "click" the "search_submit" element
    Then I should see the "search_result1_image" element
    Then I "click" the "search_result1_title" element
    And I wait "24" sec/s for "play"

    #And I have fun :)
