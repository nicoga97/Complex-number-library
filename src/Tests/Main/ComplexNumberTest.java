package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    @org.junit.jupiter.api.Test
    void conjuate() {
        ComplexNumber a = new ComplexNumber(2,5);
        ComplexNumber b = new ComplexNumber(2,-5);
        a.conjugate();
        assertEquals(a,b);
    }

    @org.junit.jupiter.api.Test
    void getModulus() {
        ComplexNumber a = new ComplexNumber(4,3);
        double d =a.getModulus();
        assertTrue(d==5);
    }

    @org.junit.jupiter.api.Test
    void getRealPart() {
        ComplexNumber a = new ComplexNumber(0,3);
        assertTrue(a.getRealPart()==0);
    }

    @org.junit.jupiter.api.Test
    void getPhase() {
        ComplexNumber a = new ComplexNumber(1,1);
        assertTrue(a.getPhase()==(Math.PI/4));
    }

    @org.junit.jupiter.api.Test
    void getAsPolar() {
        ComplexNumber a = new ComplexNumber(-1,1);
        double[] b =a.getAsPolar();
        assertTrue(b[0]==Math.sqrt(2) && b[1]==(-(Math.PI)/4));
    }


}