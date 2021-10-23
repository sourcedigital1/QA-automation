Feature: To test checkout functionality of given activation id
  This is the activation URL: https://experience-stg.sourcesync.io/44
  Scenario Outline: Verify checkout and of given activation id
    Given Execute "<activation>" and check and click "<timeLineText>"
    And I click Add to cart button
    And I clicked View in cart button
    And I clicked Checkout button
    And I clicked Proceed button
    Then I should see billing page
    Examples:
      | activation | timeLineText                     |
      | 44         | Color Tattoo Cream Eyeshadow Pot |

