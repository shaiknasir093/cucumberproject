Feature: Login

  Background: Common steps before executing each scenario
    Given User launches chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"

  #@sanity @regression
  #Scenario: Successful Login with valid credentials
    #And User enters Email as "admin@yourstore.com" and Password as "admin"
    #And Click on Login
    #And wait for five seconds
    #Then Page Title should be "Dashboard / nopCommerce administration"
   # And close browser

  @sanity
  Scenario: Successful Login with valid credentials
    #Given User launches edge browser
   # When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    And wait for five seconds
    Then Page Title should be "Dashboard / nopCommerce administration"
    #And close browser

  @regression
  Scenario Outline: Logging with valid and invalid creds
    And User enters Email as "<username>" and Password as "<password>"
    And Click on Login
    And wait for five seconds
    Then Page Title should be "<page title>"
    #And close browser

    Examples: 
      | username            | password | page title                              |
      | admin@yourstore.com | admin    | Dashboard / nopCommerce administration2  |
      | admin@yourstore.com | admin    | Dashboard / nopCommerce administration2 |
      | admin@yourstore.com | admin2   | Dashboard / nopCommerce administration2 |
