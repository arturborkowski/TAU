Given a calculator with arguments 2 and 5
When perform adding
Then result should be 7

When perform subtracting
Then result should be -3

Given a calculator
When set arguments to 2 and -5
Then adding should return -3

When set arguments to 2 and 6
Then subtracting should return -4

When set arguments to 13 and 3
Then subtracting should return 10

When set arguments to 2 and 3
Then subtracting should return -1

When set arguments to 7 and 3
Then subtracting should return 4

