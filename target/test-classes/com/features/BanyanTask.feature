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
        Then Enter panic password
        Then Wait action for "2" seconds BanyanTask
        Then assert login
        Then Wait action for "3" seconds BanyanTask
        Then Quit driver

        Examples:
            | Mobile     |
            | BanyanTask |

    @GridLoginVerify
    Scenario Outline: Login in to BanyanTask web and verify login using grid
        Given Launch chrome using grid node
        Then  Launch chrome browser for BanyanTask
        Then Enter Phone number for BanyanTask
        Then Then click countinue button BanyanTask
        Then Then click countinue button BanyanTask
        Then Enter otp
        Then Then click countinue button BanyanTask
        Then Enter panic password
        Then Wait action for "2" seconds BanyanTask
        Then assert login
        Then Wait action for "3" seconds BanyanTask
        Then Quit driver

        Examples:
            | Mobile     |
            | BanyanTask |


    @BrowerStackIntegration
    Scenario Outline: Login in to BanyanTask web and verify login using browserStack
        Given Access WebDriverManager For BanyanTask
        Then  Launch chrome browser using browserStack
        Then Enter Phone number for BanyanTask using browserStack
        Then Then click countinue button BanyanTask using browserStack
        Then Then click countinue button BanyanTask using browserStack
        Then Enter otp using browserStack
        Then Then click countinue button BanyanTask using browserStack
        Then Wait action for "2" seconds BanyanTask using browserStack
        Then assert login using browserStack
        Then Wait action for "3" seconds BanyanTask using browserStack
        Then assert project availabilty using browserStack
        Then assert task availability using browserStack
        Then Quit driver using browserStack

        Examples:
            | Mobile     | Launch       |
            | BanyanTask | BrowserStack |