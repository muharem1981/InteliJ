#Author: hiqatech@gmail.com
#Keywords Summary : YouTube Home Tests

Feature: YouTube Home Tests

  @Regression
  Scenario:YouTube - I can find videos with Zurich
    Given I navigate to the Home page
    And I "enter" "Svensson and Gielen" into the "search_field"
    When I "click" the "search_submit"
    When I "click" the "search_result_2_title"
    And I wait "5" sec/s for "play"