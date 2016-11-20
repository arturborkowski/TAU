Given a calculator
When set arguments to 2 and -5
Then adding should return -3

When set arguments to 5 and -5
Then adding should return 0

When set arguments to 2 and 6
Then subtracting should return -4

When set arguments to 13 and 3
Then subtracting should return 10

When set arguments to 2 and 3
Then subtracting should return -1

When set arguments to 7 and 3
Then subtracting should return 4

When set arguments to 7 and 3
Then multiplying should return 21

When set arguments to -7 and 3
Then multiplying should return -21

When set arguments to -7 and 0
Then multiplying should return 0

When set arguments to -10 and 2
Then division should return -5

When set arguments to -7 and -7
Then division should return 1

When set arguments to -7 and 0
Then division should return 0

When set arguments to -7 and 0
Then comparison should return false

When set arguments to 7 and 0
Then comparison should return true

When set arguments to 0 and 0
Then comparison should return false

