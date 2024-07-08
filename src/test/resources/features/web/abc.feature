@3poweblogin

Feature: 3PO Web Login

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the 3PO login page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I entered valid Credentials "<userId>" "<passWord>"



    Examples:
      | TC | ScenarioDescription        | ScenarioType | reportName |  | landingPage | reportAuthor    | landingPageSuccess | userId  | passWord    |
      | 1  | 3PO valid credential login | Positive     | 3PO Login  |  | 3poURL      | Akshay Deshmukh |                    | Shubham | Testing@123 |