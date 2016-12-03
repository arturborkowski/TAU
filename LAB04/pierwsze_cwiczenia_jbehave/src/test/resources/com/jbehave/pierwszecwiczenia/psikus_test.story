Given a psikus implementacja
When performing a method cyfrokrad with argument 1234
Then the result length should be 3

When performing a method cyfrokrad with argument 5
Then the result should not be returned

When performing a method cyfrokrad with argument -5
Then the result should not be returned

When performing a method cyfrokrad with argument 0
Then the result should not be returned

When performing a method cyfrokrad with argument 9999
Then the returned type should be an integer

When performing a method cyfrokrad with argument -123
Then the returned value should be negative

When performing a method hultajchochla with argument 25
Then the result should be 52

When performing a method hultajchochla with argument 123456
Then the sum of digits should be 21

When performing a method hultajchochla with argument 9909
Then the sum of digits should be 27

When performing a method hultajchochla with argument 1
Then the error message should be generated

When performing a method nieksztaltek with argument 345
Then the changed value should be 845

When performing a method nieksztaltek with argument 1
Then the changed value should be 1

When performing a method nieksztaltek with argument -127
Then the changed value should be -121

When performing a method nieksztaltek with argument 226
Then the changed value should be 229

When performing a method nieksztaltek with argument 6666
Then the sum of changed digits should be 27
