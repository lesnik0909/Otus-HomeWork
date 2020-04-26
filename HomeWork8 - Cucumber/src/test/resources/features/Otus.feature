Feature: Otus
  @Test
  Scenario: Open Otus and check title page
    Given Open main page
    Then Check main page

  @Test
  Scenario: Open LK and check login
    Given Open main page
    When Open page LK and login
    Then Check error message

  @Test
  Scenario: Choose course and check title page
    Given Open main page
    When Open choose course page
    Then Open testing course page and check title

  @Test
  Scenario: Open course page and return home page
    Given Open main page
    When Open course page and return home page
    Then Check main page

  @Test
  Scenario: Open and close login page
    Given Open main page
    When Open and close login page
    Then Check main page

