@main
Feature: SM login

  Scenario Outline: 4 - SM login verification using SO
    * User opens login page
    * User logs in with <userName> and <Password>
    * User submited input data
    * User sees I autorize page

    Examples:
      | userName                     | Password  |
      | 123654_206003@savvymoney.com | 12345678q |
