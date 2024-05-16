Feature: Weather in cities

  Scenario Outline: Check data weather for cities
    Given Request current weather for "<city>", "<lang>"
    Then Data are "<name>", "<tz_id>", "<country>"
    Examples:
      | city    | lang | name    | tz_id          | country |
      | Minsk   | ru   | Minsk   | Europe/Minsk   | Belarus |
      | Riga    | en   | Riga    | Europe/Riga    | Latvia  |
      | Warsaw  | en   | Warsaw  | Europe/Warsaw  | Poland  |
      | Vilnius | eng  | Vilnius | Europe/Vilnius | Poland  |


  Scenario Outline: Check weather negative scenario with disabled API key
    Given Request negative for city "<city>" with disabled API key
    Then Error Response is <statusCode>
    Examples:
      | city  | statusCode |
      | Minsk | 2008       |

  Scenario Outline: Check weather negative scenario without query
    Given Request negative without query
    Then Error Response is <statusCode>
    Examples:
      |  | statusCode |
      |  | 1003       |
#
  Scenario Outline: Check weather negative scenario with No location found matching
    Given Request negative for non existent city "<city>"
    Then Error Response is <statusCode>
    Examples:
      | city   | statusCode |
      | Vilnus | 1006       |
