#Author: hiqatech@gmail.com
#Keywords Summary : Cucumber sentences examples ,
# this scenario will not pass ,
# just show the possibilities ,
# there are some other variations but really need to be used


Feature: YouTube Search Tests

  @Smoke
  Scenario:YouTube - I can find and play my music
    Given I navigate to the Home page

    And I "enter" "Dash Berlin - With you" into the "search_field"
    And I "type" "Dash Berlin - With you" into the "search_field"

    And I "enter" "CurrentDate-30" into the "search_field"
    And I "type" "CurrentDate+30" into the "search_field"

    And I "enter" "TimeStamp" into the "search_field"

    When I "click" the "search_submit"
    When I "select" the "search_submit"
    When I "hover" the "search_submit"
    When I "clear" the "search_submit"
    When I "accept" the "alert"
    When I "dismiss" the "alert"

    And I wait "4" sec/s for "something to happen"

    Then I should see the "search_result1_title"
    Then I should not see the "search_result1_title"

    And I takes screenshot as "evidence1"

    And The "search_result1_title" element "text" should "equal" "Dash Berlin - With you"
    And The "search_result1_title" element "value" should "equal" "Dash Berlin - With you"
    And The "search_result1_title" element "href" should "equal" "Dash Berlin - With you"
    And The "search_result1_title" element "placeholder" should "equal" "Dash Berlin - With you"

    And The "search_result1_title" element "text" should "contain" "With you"
    And The "search_result1_title" element "value" should "contain" "With you"
    And The "search_result1_title" element "href" should "contain" "With you"
    And The "search_result1_title" element "placeholder" should "contain" "With you"

    And The "search_result1_title" element "text" should not "equal" "Dash Berlin - With you"
    And The "search_result1_title" element "value" should not "equal" "Dash Berlin - With you"
    And The "search_result1_title" element "href" should not "equal" "Dash Berlin - With you"
    And The "search_result1_title" element "placeholder" should "equal" "Dash Berlin - With you"

    And The "search_result1_title" element "text" should not "contain" "With you"
    And The "search_result1_title" element "value" should not "contain" "With you"
    And The "search_result1_title" element "href" should not "contain" "With you"
    And The "search_result1_title" element "placeholder" should not "contain" "With you"

    And The "_checkbox" element status should be "checked"
    And The "_checkbox" element status should be "checked"
    And The "_radiobutton" element status should be "selected"
    And The "_radiobutton" element status should be "selected"

    And I switch to the "2" window

    And I am on the "Search" page

    And I click the "news" "text" from the "options_dropdown"
    And I click the "news" "text" from the "menu" options of the "menu_options" dropdown

    And I navigate to the "search_result1_title" element link

    And I select the "CurrentDate-10" date in the "<string>" datepicker
    And I select the "CurrentDate+10" date in the "<string>" datepicker

    And I hit "enter" on the keyboard
    And I hit "pageup" on the keyboard
    And I hit "pagedown" on the keyboard
    And I hit "arrowup" on the keyboard
    And I hit "arrowdown" on the keyboard
    And I hit "esc" on the keyboard
    And I hit "F1" on the keyboard

    And I upload the "downloaded.xml" file to the "upload_button"
    And I upload the "downloaded.xml" file to the "upload_button" element with keys

    And I rename the "downloaded.xml" file to the "downloaded-1.xml"
    And I should find the "downloaded.xml" in the downloads
    And I delete the "downloaded.xml" file

    And I store the "search_result1_title" element text as "Text1"
    And The "search_result1_title" element "text" should "contain" "Text1"
    And I "enter" "Text1" into the "search_field"








