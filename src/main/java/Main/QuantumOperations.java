package Main;

import java.util.ArrayList;

public class QuantumOperations {

    /**
     * This calculates the probability of a particle be found on a specific position.
     * @param ket Ket vector in which is going to the complex amplitude.
     * @param position position in which will be calculate the probability.
     * @return the probability of the particle to be in the given position.
     * @throws MathComplexException
     */
    public static double complexAmplitudeProbabilityObservation(ComplexMatrix ket, int position) throws MathComplexException {
        if(ket.isVector()){
            return ((ket.get(position,0).norm())/Math.pow(ket.norm(),2));
        }else{
            throw new MathComplexException("The Ket must be a complex vector");
        }
    }

    /**
     * Calculates the amplitude of transition of two kets.
     * @param a complex matrix which starts the transition.
     * @param b complex matrix which goes the transition
     * @return amplitude of transition
     * @throws MathComplexException
     */
    public static ComplexNumber amplitudeOfTransition(ComplexMatrix a, ComplexMatrix b) throws MathComplexException {
        if(a.isVector() && b.isVector()){
            return MathComplex.complexDivision(MathComplex.innerProduct(a,b),new ComplexNumber(a.norm()*b.norm(),0));
        }else{
            throw new MathComplexException("The Kets must be a complex vectors");
        }
    }


    /**
     * Calculates the mean  value between an observable and a ket
     * @param observable
     * @param ket
     * @return
     * @throws MathComplexException
     */
    public static ComplexNumber meanValue(ComplexMatrix observable, ComplexMatrix ket) throws MathComplexException {
        if(!ket.isVector()){
            throw new MathComplexException("The ket must be a vector");
        }
        if(!observable.isHermitian()){
            throw new MathComplexException("The observable must be hermitian");
        }
        ComplexMatrix action= MathComplex.action(observable,ket);
        action.conjugate();
        return MathComplex.innerProduct(action,ket);
    }


    /**
     * Calculate the vereince between a observable and a ket
     * @param observable observable  complex matrix.
     * @param ket ket vector.
     * @return the verience
     * @throws MathComplexException
     */
    public static ComplexNumber variance(ComplexMatrix observable, ComplexMatrix ket) throws MathComplexException {
        ComplexNumber meanValue= meanValue(observable,ket);
        ComplexMatrix identityMatrix= MathComplex.generateIdentityMatrix(observable.columnLength());
        ComplexMatrix res=MathComplex.matrixSubstraction(observable,MathComplex.matrixScalarMultiplication(identityMatrix,meanValue));;
        res=MathComplex.matrixMultiplication(res,res);

        return meanValue;
    }





}
