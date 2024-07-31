Feature: HW 9

#  Scenario: phone search
#  1. go to allo ua page
#  2. search for phone
#  3. check if this phone is present in DB
#  4.1. If phone IS in DB > check its price, if it changed > update price and fail test
#  4.2. If phone IS NOT in DB > store price, and fail test
#  MAKE IT PARAMETRZIED FOR 3 DIFFERENT PHONES: iPhone, Samsung, Xiaomi

  Scenario: Search some phone and check him
    Given I load allo page
    Given I search searchbox and enter value
    Given I press ENTER
    Given I click phone
    Given I search phone name
    Given I search phone price
    Given I check phone, compare him and change DB value
