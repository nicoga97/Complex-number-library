package Main;

import Main.ComplexMatrix;
import Main.ComplexNumber;
import Main.MathComplexException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ComplexMatrixTest {


    @Test
    void isHermitian() {
        ComplexMatrix a=new ComplexMatrix(2,2);
        a.set(0,0,new ComplexNumber(7,0));
        a.set(1,0,new ComplexNumber(6,-5));
        a.set(0,1,new ComplexNumber(6,5));
        a.set(1,1,new ComplexNumber(-3,0));
        assertTrue(a.isHermitian());
    }

    @Test
    void transpose() {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,-4));
        a.set(1,0,new ComplexNumber(7,3));
        a.set(2,0,new ComplexNumber(4.2,-8.1));
        a.set(3,0,new ComplexNumber(0,-3));
        ComplexMatrix b =new ComplexMatrix(1,4);
        b.set(0,0,new ComplexNumber(6,-4));
        b.set(0,1,new ComplexNumber(7,3));
        b.set(0,2,new ComplexNumber(4.2,-8.1));
        b.set(0,3,new ComplexNumber(0,-3));
        a.transpose();
        assertEquals(a,b);
    }

    @Test
    void conjugate() {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,-4));
        a.set(1,0,new ComplexNumber(7,3));
        a.set(2,0,new ComplexNumber(4.2,-8.1));
        a.set(3,0,new ComplexNumber(0,-3));
        ComplexMatrix b =new ComplexMatrix(4,1);
        b.set(0,0,new ComplexNumber(6,4));
        b.set(1,0,new ComplexNumber(7,-3));
        b.set(2,0,new ComplexNumber(4.2,8.1));
        b.set(3,0,new ComplexNumber(0,3));
        a.conjugate();
        assertEquals(a,b);
    }

    @Test
    void adjoint() {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,-4));
        a.set(1,0,new ComplexNumber(7,3));
        a.set(2,0,new ComplexNumber(4.2,-8.1));
        a.set(3,0,new ComplexNumber(0,-3));
        ComplexMatrix b =new ComplexMatrix(1,4);
        b.set(0,0,new ComplexNumber(6,4));
        b.set(0,1,new ComplexNumber(7,-3));
        b.set(0,2,new ComplexNumber(4.2,8.1));
        b.set(0,3,new ComplexNumber(0,3));
        a.adjoint();
        assertEquals(a,b);
    }

    @Test
    void inverse() {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,-4));
        a.set(1,0,new ComplexNumber(7,3));
        a.set(2,0,new ComplexNumber(4.2,-8.1));
        a.set(3,0,new ComplexNumber(0,-3));
        ComplexMatrix b =new ComplexMatrix(4,1);
        b.set(0,0,new ComplexNumber(-6,4));
        b.set(1,0,new ComplexNumber(-7,-3));
        b.set(2,0,new ComplexNumber(-4.2,8.1));
        b.set(3,0,new ComplexNumber(0,3));
        a.inverse();
        assertEquals(a,b);
    }

    @Test
    void isVector() {
        ComplexMatrix a =new ComplexMatrix(4,1);
        a.set(0,0,new ComplexNumber(6,-4));
        a.set(1,0,new ComplexNumber(7,3));
        a.set(2,0,new ComplexNumber(4.2,-8.1));
        a.set(3,0,new ComplexNumber(0,-3));
        assertTrue(a.isVector());
    }

    @Test
    void norm() throws MathComplexException {
        ComplexMatrix a =new ComplexMatrix(3,1);
        a.set(0,0,new ComplexNumber(3,0));
        a.set(1,0,new ComplexNumber(-6,0));
        a.set(2,0,new ComplexNumber(2,0));
        assertEquals(a.norm(),new ComplexNumber(7,0));

    }


}