@policy

Feature: validate policy details


  @test
  Scenario Outline: a user can fill up the details form
    Given i am on the details page
    When i fill the form and submit
              | <title>                |
              | <firstname>            |
              | <lastname>             |
              | <day>                  |
              | <month>                |
              | <year>                 |
              | <maritalstatus>        |
              | <occupation>           |
              | <MainTelephoneNumber>  |
              | <EmailAddress>         |
              | <Address>              |
    Then i should be on the quotes page
            Examples:
              | title  | firstname | lastname       | day | month  | year | maritalstatus     | occupation    | MainTelephoneNumber| EmailAddress              | Address                   |
              | Dr     | Tester    | TesterLast     | 5   | March  | 2000 | Married           | Test Engineer | 07412334467        | vketipisz@qmetric.co.uk   | EC2N 4AY, 110 Bishopsgate |
