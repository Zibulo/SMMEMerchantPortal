@merchantDatedTransactions

Feature: View Merchant Dated Transactions

  Scenario Outline: "<ScenarioDescription>"
    Given I can login to SMME site "<ScenarioType>" "<userName>" "<passWord>" "<appChannel>"
    When I get a valid response "<ExpectedResponseCode>"
    Then I can View Merchant Dated Transactions "<ScenarioType>" "<userId>" "<fromDate>" "<toDate>"
    And I get a valid response "<ExpectedResponseCode>"
    Then  I can logoff to SMME site "<ScenarioType>" "<userId>"
    When I get a valid response "<ExpectedResponseCode>"




    Examples:
      | TC | ScenarioDescription              | ScenarioType | userName        | passWord         | appChannel | fromDate   | toDate     | ExpectedResponseCode |
      | 1  | Merchant Dashboard View by dates | Positive     | VPS360199273438 | UGFzc3dvcmQxMjMh | Web        | 2020-03-01 | 2020-03-31 | 200                  |
