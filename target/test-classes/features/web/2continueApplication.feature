@2continueApplication

Feature: Continue Application Journey

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the Continue application login page "<ScenarioDescription>""<reportName>""<continueLandingPage>""<reportAuthor>""<landingPageSuccess>"
    And I enter valid continue credentials "<emailAddress>" "<refNumber>"
    And I enter valid application OTP "<continueOTP>"


    Examples:
      | TC | ScenarioDescription          | ScenarioType | reportName                   |  | continueLandingPage | reportAuthor    | emailAddress                    | refNumber | continueOTP |
      | 1  | Continue application journey | Positive     | Continue application journey |  | continueApplication | Itumeleng Phale | fire-add@n9ftmnyu.mailosaur.net |           |             |