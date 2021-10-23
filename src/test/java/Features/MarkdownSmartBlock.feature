Feature: To test Mark down smart block
  This is to test MarkdownSmartBlock of https://experience-stg.sourcesync.io/114 with two scenario
  Scenario Outline: Verify the mark down smart block using height, text style, text color
    Given Execute "<activation>" and play and click "<timeLineText>"
    And I see Smart block text
    And I verify the block height is "<height>"
    And I verify the text is "<textStyle>"
    Then  I verify the text color is "<color>"
    Examples:
      | activation | timeLineText      | height | textStyle | color   |
      | 114        | Get Ready Lyrics  | 100px    | h1      | #ab4642 |


