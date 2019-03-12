package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuantumOperationsTest {

    @Test
    void complexAmplitudeProbabilityObservation() throws MathComplexException {
        ComplexMatrix matrix=new ComplexMatrix(4,1);
        matrix.set(0,0,new ComplexNumber( -3,-1));
        matrix.set(1,0,new ComplexNumber( 0,-2));
        matrix.set(2,0,new ComplexNumber( 0,1));
        matrix.set(3,0,new ComplexNumber( 2,0));
        assertEquals(QuantumOperations.complexAmplitudeProbabilityObservation(matrix,2),0.05263157894736841);
    }

    @Test
    void amplitudeOfTransition() throws MathComplexException {
        ComplexMatrix a=new ComplexMatrix(2,1);
        a.set(0,0,new ComplexNumber( 0,-1));
        a.set(1,0,new ComplexNumber( 1,0));
        ComplexMatrix b=new ComplexMatrix(2,1);
        b.set(0,0,new ComplexNumber( 1,0));
        b.set(1,0,new ComplexNumber( 0,-1));
        assertEquals(QuantumOperations.amplitudeOfTransition(a,b),new ComplexNumber(0,-0.9999999999999998));
    }
}