#Author: hiqatech@gmail.com
#Keywords Summary : YouTube Web Tests

Feature: YouTube Web Tests

  @Smoke
  Scenario:YouTubeWeb - I can find and play my music
    Given I navigate to the "https://www.youtube.com/" page
    And I am on the "Main" page
    And I enter "Dash Berlin - With you" as the "search_field" element
    When I select the "search_submit" element
    Then I select the "play_that" element
    And I wait "24" sec/s

    #And I have fun :)
