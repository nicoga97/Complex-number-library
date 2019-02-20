package Main;

import Main.ComplexNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    @Test
    void conjuate() {
        ComplexNumber a = new ComplexNumber(2,5);
        ComplexNumber b = new ComplexNumber(2,-5);
        a.conjugate();
        assertEquals(a,b);
    }

    @Test
    void getModulus() {
        ComplexNumber a = new ComplexNumber(4,3);
        double d =a.getModulus();
        assertEquals(5, d);
    }

    @Test
    void getRealPart() {
        ComplexNumber a = new ComplexNumber(0,3);
        assertEquals(0, a.getRealPart());
    }

    @Test
    void getPhase() {
        ComplexNumber a = new ComplexNumber(1,1);
        assertEquals(a.getPhase(), (Math.PI / 4));
    }

    @Test
    void getAsPolar() {
        ComplexNumber a = new ComplexNumber(-1,1);
        double[] b =a.getAsPolar();
        assertTrue(b[0]==Math.sqrt(2) && b[1]==(-(Math.PI)/4));
    }

}