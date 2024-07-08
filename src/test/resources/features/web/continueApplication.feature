@continueApplication

Feature: Continue Application Journey

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the Continue application login page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I entered valid login data "<emailAddress>" "<refNumber>"


    Examples:
      | TC | ScenarioDescription        | ScenarioType | reportName |  | landingPage | reportAuthor    | landingPageSuccess | emailAddress  | refNumber    |
      | 1  | Continue application journey | Positive     | Continue application login  |  | continueApplication      | Akshay Deshmukh |                    | akshay.desmukh@vcontractor | RNJGRULS72 |