# Complex Number Library
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0d716c0965bc489a9a8d5eee07a9570c)](https://www.codacy.com/app/nicoga97/Complex-number-library?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=nicoga97/Complex-number-library&amp;utm_campaign=Badge_Grade)

This is a java library in which you can find most of complex numbers, vectors and  matrix operations.
## Running tests
To run automated tests just type:
```
mvn test
```
##### ComplexExercisesTest
Here you can find 4 different tests representing 
cuantic an probabilistic experiments.
- **marbleExperimentWithBooleanMatrix:** This test represent  a simple system described by a graph together with some toy marbles.
Imagine the identical marbles as being placed on the vertices of a graph. The state of a system is described by how many marbles are on each vertex.At the end of this
test we will see the state of the system after 4 clicks.

- **marbleExperimentWithComplexNumbers:** This test represent the same as bellow but now instead of dealing with a bunch of marbles moving about, we shall
work with a single marble. The state of the system will tell us the probabilities of the marble being on each vertex.We will work with complex numbers. At the end of this test we will see the state of the
system after 1 click.

- **slitExperiment:** This test represent the classical probabilistic double-slit experiment but in this case we will make use of tree slits and at the end of the test we will see
the final state of the system after 2 clicks.

- **complexSlitExperiment:** this experiment represent the same as bellow but using only two slits and a quantic system.

##### QuantumOperationTest
- **complexAmplitudeProbabilityObservation:** This test the ability of quantumOperations class to calculate the probability of a particle be found in a specific position.
- **amplitudeOfTransition:** This test the ability of quantumOperations class to calculate the amplitude of transition between two complex amplitudes.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* [**Nicolas Garcia**](https://github.com/nicoga97) - *Initial work* 



