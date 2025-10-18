Feature: Multiple Login Attempts

  @regression
  Scenario Outline: Logging with valid and invalid creds
    Given User launches chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<username>" and Password as "<password>"
    And Click on Login
    Then check if user is loggedin
    #And close browser

    Examples: 
       #Valid username & password
      | username            | password  |
      | admin@yourstore.com | admin     |
       #Wrong case in password
      | admin@yourstore.com | Admin     |
       #Valid username, invalid password
      | admin@yourstore.com | wrongpass |
       #Wrong case in username
      | Admin@yourstore.com | admin     |
       #Invalid username, valid password
      | wrong@yourstore.com | admin     |
       #Both username & password invalid
      | wrong@yourstore.com | wrongpass |
       #Empty password
      | admin@yourstore.com |           |
       #Empty username
      |                     | admin     |
       #Both fields empty
      |                     |           |
       #Similar but incorrect password
      | admin@yourstore.com | admin123  |
       #All caps password
      | admin@yourstore.com | ADMIN     |
       #All caps username
      | ADMIN@YOURSTORE.COM | admin     |
       #Special character password
      | admin@yourstore.com | pass@123  |
       #Extremely short password
      | admin@yourstore.com | a         |
       #Very short username
      | a@b.com             | admin     |
