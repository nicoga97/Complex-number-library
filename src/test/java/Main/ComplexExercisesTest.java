package Main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComplexExercisesTest {
    @Test
    void marbleExperimentWithBooleanMatrix() throws MathComplexException {
        System.out.println("---------------Marble experiment with boolean matrix test----------------\n");
        ComplexMatrix a =new ComplexMatrix(6,6);
        for (int row = 0; row < a.rowLength(); row++) {
            for (int column = 0; column < a.columnLength(); column++) {
                a.set(row,column,new ComplexNumber(0,0));
            }
        }
        a.set(2,1,new ComplexNumber(1,0));
        a.set(2,5,new ComplexNumber(1,0));
        a.set(3,3,new ComplexNumber(1,0));
        a.set(4,2,new ComplexNumber(1,0));
        a.set(5,0,new ComplexNumber(1,0));
        a.set(5,4,new ComplexNumber(1,0));
        System.out.println("Adjacency matrix\n");
        System.out.println(a);
        ComplexMatrix state =new ComplexMatrix(6,1);
        state.set(0,0,new ComplexNumber(6,0));
        state.set(1,0,new ComplexNumber(2,0));
        state.set(2,0,new ComplexNumber(1,0));
        state.set(3,0,new ComplexNumber(5,0));
        state.set(4,0,new ComplexNumber(3,0));
        state.set(5,0,new ComplexNumber(10,0));
        System.out.println("Initial State\n");
        System.out.println(state);
        for(int i=0;i<4;i++){
            state=MathComplex.action(a,state);
        }
        System.out.println("Final state after 4 clicks.\n");
        System.out.println(state);
        System.out.println("----------------------------Test Finished-------------------------------\n");

    }

    @Test
    void marbleExperimentWithComplexNumbers() throws MathComplexException {
        System.out.println("---------------Marble experiment with complex matrix test----------------\n");
        ComplexMatrix a =new ComplexMatrix(3,3);
        for (int row = 0; row < a.rowLength(); row++) {
            for (int column = 0; column < a.columnLength(); column++) {
                a.set(row,column,new ComplexNumber(0,0));
            }
        }
        a.set(0,0,new ComplexNumber( 1/Math.sqrt(2),0));
        a.set(0,1,new ComplexNumber(1/Math.sqrt(2),0));
        a.set(1,0,new ComplexNumber(1/Math.sqrt(2),-1));
        a.set(1,1,new ComplexNumber(1/Math.sqrt(2),1));
        a.set(2,2,new ComplexNumber(0,-1));

        System.out.println("Adjacency matrix\n");
        System.out.println(a);
        ComplexMatrix state =new ComplexMatrix(3,1);
        state.set(0,0,new ComplexNumber(1/ Math.sqrt(3),0));
        state.set(1,0,new ComplexNumber(1/ Math.sqrt(15),2));
        state.set(2,0,new ComplexNumber(Math.sqrt((double)2/5),0));


        System.out.println("Initial State\n");
        System.out.println(state);
        state=MathComplex.action(a,state);

        System.out.println("Final state after 1 clicks.\n");
        System.out.println(state);
        System.out.println("----------------------------Test Finished-------------------------------\n");

    }
}
