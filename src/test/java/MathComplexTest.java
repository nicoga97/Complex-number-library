import Main.ComplexMatrix;
import Main.ComplexNumber;
import Main.MathComplex;
import Main.MathComplexException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MathComplexTest {

    @Test
    void complexAdd() {
        ComplexNumber a = new ComplexNumber(3, -1);
        ComplexNumber b = new ComplexNumber(1, 4);
        ComplexNumber answ = new ComplexNumber(4, 3);
        Assertions.assertTrue(MathComplex.complexAdd(a, b).equals(answ));
    }

    @Test
    void complexSubstraction() {
        ComplexNumber a = new ComplexNumber(3, -1);
        ComplexNumber b = new ComplexNumber(1, 4);
        ComplexNumber answ = new ComplexNumber(2, -5);
        assertTrue(MathComplex.complexSubstraction(a, b).equals(answ));
    }

    @Test
    void complexMultiplication() {
        ComplexNumber a = new ComplexNumber(3, -2);
        ComplexNumber b = new ComplexNumber(1, 2);
        ComplexNumber answ = new ComplexNumber(7, 4);
        assertTrue(MathComplex.complexMultiplication(a, b).equals(answ));
    }

    @Test
    void complexDivision() {
        ComplexNumber a = new ComplexNumber(-2, 1);
        ComplexNumber b = new ComplexNumber(1, 2);
        ComplexNumber answ = new ComplexNumber(0, 1);
        assertTrue(MathComplex.complexDivision(a, b).equals(answ));
    }


    @Test
    void matrixAddition() throws MathComplexException {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,-4));
        a.set(1,0,new ComplexNumber(7,3));
        a.set(2,0,new ComplexNumber(4.2,-8.1));
        a.set(3,0,new ComplexNumber(0,-3));
        ComplexMatrix b =new ComplexMatrix(4,1);
        b.set(0,0,new ComplexNumber(16,2.3));
        b.set(1,0,new ComplexNumber(0,-7));
        b.set(2,0,new ComplexNumber(6,0));
        b.set(3,0,new ComplexNumber(0,-4));
        ComplexMatrix c =new ComplexMatrix(4,1);
        c.set(0,0,new ComplexNumber(22,-1.7000000000000002));
        c.set(1,0,new ComplexNumber(7,-4));
        c.set(2,0,new ComplexNumber(10.2,-8.1));
        c.set(3,0,new ComplexNumber(0,-7));
        assertEquals(MathComplex.matrixAddition(a,b),c);
    }

    @Test
    void matrixScalarMultiplication() {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,3));
        a.set(1,0,new ComplexNumber(0,0));
        a.set(2,0,new ComplexNumber(5,1));
        a.set(3,0,new ComplexNumber(4,0));
        ComplexNumber b= new ComplexNumber(3,2);
        ComplexMatrix c =new ComplexMatrix(4,1);
        c.set(0,0,new ComplexNumber(12,21));
        c.set(1,0,new ComplexNumber(0,0));
        c.set(2,0,new ComplexNumber(13,13));
        c.set(3,0,new ComplexNumber(12,8));
        assertEquals(MathComplex.matrixScalarMultiplication(a,b),c);
    }

    @Test
    void matrixMultiplication() throws MathComplexException {
        ComplexMatrix a =new ComplexMatrix(3,3);
        a.set(0,0,new ComplexNumber(3,2));
        a.set(1,0,new ComplexNumber(1,0));
        a.set(2,0,new ComplexNumber(4,-1));
        a.set(0,1,new ComplexNumber(0,0));
        a.set(1,1,new ComplexNumber(4,2));
        a.set(2,1,new ComplexNumber(0,0));
        a.set(0,2,new ComplexNumber(5,-6));
        a.set(1,2,new ComplexNumber(0,1));
        a.set(2,2,new ComplexNumber(4,0));
        ComplexMatrix b =new ComplexMatrix(3,3);
        b.set(0,0,new ComplexNumber(5,0));
        b.set(1,0,new ComplexNumber(0,0));
        b.set(2,0,new ComplexNumber(7,-4));
        b.set(0,1,new ComplexNumber(2,-1));
        b.set(1,1,new ComplexNumber(4,5));
        b.set(2,1,new ComplexNumber(2,7));
        b.set(0,2,new ComplexNumber(6,-4));
        b.set(1,2,new ComplexNumber(2,0));
        b.set(2,2,new ComplexNumber(0,0));
        ComplexMatrix c =new ComplexMatrix(3,3);
        c.set(0,0,new ComplexNumber(26,-52));
        c.set(1,0,new ComplexNumber(9,7));
        c.set(2,0,new ComplexNumber(48,-21));
        c.set(0,1,new ComplexNumber(60,24));
        c.set(1,1,new ComplexNumber(1,29));
        c.set(2,1,new ComplexNumber(15,22));
        c.set(0,2,new ComplexNumber(26,0));
        c.set(1,2,new ComplexNumber(14,0));
        c.set(2,2,new ComplexNumber(20,-22));
        assertTrue(MathComplex.matrixMultiplication(a,b).equals(c));
    }

    @Test
    void action() throws MathComplexException {
        ComplexMatrix a =new ComplexMatrix(2,2);
        a.set(0,0,new ComplexNumber(5,0));
        a.set(1,0,new ComplexNumber(3,3));
        a.set(0,1,new ComplexNumber(-7,-4));
        a.set(1,1,new ComplexNumber(-7,0));
        ComplexMatrix b =new ComplexMatrix(2,1);
        b.set(0,0,new ComplexNumber(5,0));
        b.set(1,0,new ComplexNumber(3,-4));
        ComplexMatrix c =new ComplexMatrix(2,1);
        c.set(0,0,new ComplexNumber(-12,16));
        c.set(1,0,new ComplexNumber(-6,43));
        assertEquals(MathComplex.action(a,b),c);
    }

    @Test
    void innerProduct() throws MathComplexException {
        ComplexMatrix a =new ComplexMatrix(3,1);
        a.set(0,0,new ComplexNumber(5,0));
        a.set(1,0,new ComplexNumber(3,0));
        a.set(2,0,new ComplexNumber(-7,0));
        ComplexMatrix b =new ComplexMatrix(3,1);
        b.set(0,0,new ComplexNumber(6,0));
        b.set(1,0,new ComplexNumber(2,0));
        b.set(2,0,new ComplexNumber(0,0));
        ComplexNumber c =new ComplexNumber(36,0);
        assertTrue(MathComplex.innerProduct(a,b).equals(c));
    }

    @Test
    void tensorProduct() {
        ComplexMatrix a =new ComplexMatrix(2,1);
        a.set(0,0,new ComplexNumber(2,0));
        a.set(1,0,new ComplexNumber(3,0));
        ComplexMatrix b =new ComplexMatrix(3,1);
        b.set(0,0,new ComplexNumber(4,0));
        b.set(1,0,new ComplexNumber(6,0));
        b.set(2,0,new ComplexNumber(3,0));
        ComplexMatrix c =new ComplexMatrix(6,1);
        c.set(0,0,new ComplexNumber(8,0));
        c.set(1,0,new ComplexNumber(12,0));
        c.set(2,0,new ComplexNumber(6,0));
        c.set(3,0,new ComplexNumber(12,0));
        c.set(4,0,new ComplexNumber(18,0));
        c.set(5,0,new ComplexNumber(9,0));
        assertTrue(MathComplex.tensorProduct(a,b).equals(c));
    }


}
