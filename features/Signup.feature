Feature: Sign up for website

  @test
  Scenario: User sign up for website
    Given User Open URL
    And   Validate that website opened correctly
    Then Click on Signin
    Then Scroll Down
    And  validate Signin Page
    And  Enter Email address
    Then Click on create an account
    And User Fill his Title
    And user fill his Customer firstname
    And user fill his Customer lastname
    And user fill his password
    Then Scroll Down
    And user fill his Date Of Birth
    Then Scroll Down
    And user fill his company
    And user fill his Address
    And user fill his Address second line
    And user fill his city
   And user fill his state
    And user fill his postal code
    Then Scroll Down
    And user fill his info
    And user fill his phone
    Then Scroll Down
    And user fill his MobileNumber
    And user fill his alias
    And Click on Register
    Then Validate Login
    And Signout
    And Validate Signing out
    Then Close website