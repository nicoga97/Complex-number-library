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
    @Test
    void slitExperiment() throws MathComplexException {
        System.out.println("---------------3 Slit experiment test----------------\n");
        ComplexMatrix a =new ComplexMatrix(11,11);
        for (int row = 0; row < a.rowLength(); row++) {
            for (int column = 0; column < a.columnLength(); column++) {
                a.set(row,column,new ComplexNumber(0,0));
            }
        }
        a.set(1,0,new ComplexNumber( (double) 1/3,0));
        a.set(2,0,new ComplexNumber( (double)1/3,0));
        a.set(3,0,new ComplexNumber( (double)1/3,0));
        a.set(4,1,new ComplexNumber( (double)1/3,0));
        a.set(5,1,new ComplexNumber( (double)1/3,0));
        a.set(6,1,new ComplexNumber( (double)1/3,0));
        a.set(6,2,new ComplexNumber( (double)1/3,0));
        a.set(7,2,new ComplexNumber( (double)1/3,0));
        a.set(8,2,new ComplexNumber( (double)1/3,0));
        a.set(8,3,new ComplexNumber( (double)1/3,0));
        a.set(9,3,new ComplexNumber( (double)1/3,0));
        a.set(10,3,new ComplexNumber( (double)1/3,0));
        a.set(4,4,new ComplexNumber( 1,0));
        a.set(5,5,new ComplexNumber( 1,0));
        a.set(6,6,new ComplexNumber( 1,0));
        a.set(7,7,new ComplexNumber( 1,0));
        a.set(8,8,new ComplexNumber( 1,0));
        a.set(9,9,new ComplexNumber( 1,0));
        a.set(10,10,new ComplexNumber( 1,0));


        System.out.println("Probability matrix in initial state\n");
        System.out.println(a);
        for(int i=0;i<2;i++){
           a=MathComplex.matrixMultiplication(a,a);
        }
        System.out.println("Probability matrix after 2 clicks\n");
        System.out.println(a);
        ComplexMatrix state =new ComplexMatrix(11,1);
        state.set(0,0,new ComplexNumber(1,0));
        state.set(1,0,new ComplexNumber(0,0));
        state.set(2,0,new ComplexNumber(0,0));
        state.set(3,0,new ComplexNumber(0,0));
        state.set(4,0,new ComplexNumber(0,0));
        state.set(5,0,new ComplexNumber(0,0));
        state.set(6,0,new ComplexNumber(0,0));
        state.set(7,0,new ComplexNumber(0,0));
        state.set(8,0,new ComplexNumber(0,0));
        state.set(9,0,new ComplexNumber(0,0));
        state.set(10,0,new ComplexNumber(0,0));


        System.out.println("Initial bullet State\n");
        System.out.println(state);
        for(int i=0;i<3;i++){
            state=MathComplex.action(a,state);
        }

        System.out.println("Final state after 2 clicks.\n");
        System.out.println(state);
        System.out.println("----------------------------Test Finished-------------------------------\n");

    }
    @Test
    void complexSlitExperiment() throws MathComplexException {
        System.out.println("---------------2 complex  Slit experiment test----------------\n");
        ComplexMatrix a =new ComplexMatrix(8,8);
        for (int row = 0; row < a.rowLength(); row++) {
            for (int column = 0; column < a.columnLength(); column++) {
                a.set(row,column,new ComplexNumber(0,0));
            }
        }
        a.set(1,0,new ComplexNumber( 1/Math.sqrt(2),0));
        a.set(2,0,new ComplexNumber( 1/Math.sqrt(2),0));
        a.set(3,1,new ComplexNumber( -1/Math.sqrt(6),1/Math.sqrt(6)));
        a.set(4,1,new ComplexNumber( -1/Math.sqrt(6),-1/Math.sqrt(6)));
        a.set(5,1,new ComplexNumber( 1/Math.sqrt(6),-1/Math.sqrt(6)));
        a.set(5,2,new ComplexNumber( -1/Math.sqrt(6),1/Math.sqrt(6)));
        a.set(6,2,new ComplexNumber( -1/Math.sqrt(6),-1/Math.sqrt(6)));
        a.set(7,2,new ComplexNumber( 1/Math.sqrt(6),-1/Math.sqrt(6)));
        a.set(3,3,new ComplexNumber( 1,0));
        a.set(4,4,new ComplexNumber( 1,0));
        a.set(5,5,new ComplexNumber( 1,0));
        a.set(6,6,new ComplexNumber( 1,0));
        a.set(7,7,new ComplexNumber( 1,0));



        System.out.println("Probability complex matrix in initial state\n");
        System.out.println(a);
        a=MathComplex.matrixMultiplication(a,a);

        System.out.println("Probability matrix after 2 clicks, in position 5,0 whe can see the interference\n");
        System.out.println(a);

        System.out.println("----------------------------Test Finished-------------------------------\n");

    }
}
