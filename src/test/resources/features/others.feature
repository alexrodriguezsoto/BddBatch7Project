Feature: Others page tests

  @regression @US2001
  Scenario: Disabled button is working as expected
    Given I open url of homepage
    When I click nav button "Others"
    Then Verify buttons is disabled