Given a psikus implementacja
When performing a method cyfrokrad with argument 1234
Then the result length should be 3

When performing a method cyfrokrad with argument 5
Then the result should be null

When performing a method cyfrokrad with argument -5
Then the result should be null

When performing a method cyfrokrad with argument -123
Then the result should be negative

When performing a method cyfrokrad with argument 9999
Then the result should be an integer

When performing a method hultajchochla with argument 25
Then the result should be 52

When performing a method hultajchochla with argument 123456
Then the sum of digits should be 21
