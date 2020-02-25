Feature: Subscriber Database

  Background:
    Given The following Subscribers are in the database
    |1      |Dan  |
    |2      |Jim  |
    |3      |Harry|

  Scenario Outline: Adding a subscriber to the database
    Given "<Name>" subscribes with number <Num>
    And Number <Num> is not already taken
    When <Num> is added to the database
    Then <Num> is present in the database
    Examples:
      | Name | Num |
      | Mitch | 5   |
      | Lewis | 4   |

  Scenario Outline: Remove a subscriber from the database
    Given <Num> is <Presence1> in the database
    When <Num> is removed from the database
    Then <Num> is <Presence2> in the database
    Examples:
      | Presence1 | Num | Presence2   |
      | present   | 3   | not present |
      | not present| 12   | not present|

  Scenario Outline: Updating a current Subscriber
    Given <Num> is <Presence> in the database
    When <Num> <info> is updated
    Then <Num> <info> has changed
    Examples:
      | Presence |Num| info |
      | present  |1| number |
      | present  |3| name |
      | present  |3| phone|
      | not present |9| number|


