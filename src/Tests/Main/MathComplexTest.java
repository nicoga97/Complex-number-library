package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathComplexTest {

    @Test
    void complexAdd() {
        ComplexNumber a =new ComplexNumber(3,-1);
        ComplexNumber b =new ComplexNumber(1,4);
        ComplexNumber answ =new ComplexNumber(4,3);
        assertTrue(MathComplex.complexAdd(a,b).equals(answ));
    }

    @Test
    void complexSubstraction() {
        ComplexNumber a =new ComplexNumber(3,-1);
        ComplexNumber b =new ComplexNumber(1,4);
        ComplexNumber answ =new ComplexNumber(2,-5);
        assertTrue(MathComplex.complexSubstraction(a,b).equals(answ));
    }

    @Test
    void complexMultiplication() {
        ComplexNumber a =new ComplexNumber(3,-2);
        ComplexNumber b =new ComplexNumber(1,2);
        ComplexNumber answ =new ComplexNumber(7,4);
        assertTrue(MathComplex.complexMultiplication(a,b).equals(answ));
    }

    @Test
    void complexDivision() {
        ComplexNumber a =new ComplexNumber(-2,1);
        ComplexNumber b =new ComplexNumber(1,2);
        ComplexNumber answ =new ComplexNumber(0,1);
        assertTrue(MathComplex.complexDivision(a,b).equals(answ));
    }
}