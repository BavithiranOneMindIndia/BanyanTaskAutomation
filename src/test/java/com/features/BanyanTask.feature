Feature: Testing BanyanTask web
    Verifing scenarios for BanyanTask web


    @LoginVerify
    Scenario Outline: Login in to BanyanTask web and verify login
        Given Access WebDriverManager For BanyanTask
        Then  Launch chrome browser for BanyanTask
        Then Enter Phone number for BanyanTask
        Then Then click countinue button BanyanTask
        Then Then click countinue button BanyanTask
        Then Enter otp
        Then Then click countinue button BanyanTask
        Then assert login
        Then Quit driver

        Examples:
            | Mobile     |
            | BanyanTask |