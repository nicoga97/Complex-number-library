package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexMatrixTest {

    @Test
    void transpose() {
    }

    @Test
    void conjugate() {
    }

    @Test
    void adjoint() {
    }

    @Test
    void get() {
    }

    @Test
    void inverse() {
    }

    @Test
    void isVector() {
    }

    @Test
    void norm() {
    }

    @Test
    void isHermitian() {
        ComplexMatrix a=new ComplexMatrix(2,2);
        a.set(0,0,new ComplexNumber(7,0));
        a.set(1,0,new ComplexNumber(6,-5));
        a.set(0,1,new ComplexNumber(6,-5));
        a.set(0,1,new ComplexNumber(-3,0));
        assertTrue(a.isHermitian());
    }
}