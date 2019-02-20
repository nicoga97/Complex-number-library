package Main;

public class MathComplex {

    /**
     * Make addition of two complex numbers.
     * @param a Complex number to make the addition.
     * @param b Complex number to make the addition.
     * @return Result of the addition of the two complex numbers.
     */
    public static ComplexNumber complexAdd(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getRealPart()+b.getRealPart(),a.getImaginaryPart()+b.getImaginaryPart());
    }

    /**
     * Make subtraction of two complex numbers.
     * @param a Complex number to make the subtraction.
     * @param b Complex number to make the subtraction.
     * @return Result of the subtraction of the two complex numbers.
     */
    public static ComplexNumber complexSubstraction(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getRealPart()-b.getRealPart(),a.getImaginaryPart()-b.getImaginaryPart());
    }

    /**
     * Make multiplication of two complex numbers.
     * @param a Complex number to make the multiplication.
     * @param b Complex number to make the multiplication.
     * @return Result of the multiplication of the two complex numbers.
     */
    public static ComplexNumber complexMultiplication(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber((a.getRealPart()*b.getRealPart())-(a.getImaginaryPart()*b.getImaginaryPart()),((a.getRealPart()*b.getImaginaryPart())+(b.getRealPart()*a.getImaginaryPart())));
    }
    /**
     * Make division of two complex numbers.
     * @param a Complex number to make the division.
     * @param b Complex number to make the division.
     * @return Result of the division of the two complex numbers.
     */
    public static ComplexNumber complexDivision(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(((a.getRealPart()*b.getRealPart())+(a.getImaginaryPart()*b.getImaginaryPart()))/(Math.pow(b.getImaginaryPart(),2)+Math.pow(b.getRealPart(),2)),((b.getRealPart()*a.getImaginaryPart())-(a.getRealPart()*b.getImaginaryPart()))/(Math.pow(b.getRealPart(),2)+Math.pow(b.getImaginaryPart(),2)));
    }

    /**
     * Make addition of two complex Matrices.
     * @param a First adding up
     * @param b Second adding up
     * @return Answer of the addition of A and B.
     * @throws MathComplexException
     */
    public static ComplexMatrix matrixAddition(ComplexMatrix a,ComplexMatrix b) throws MathComplexException {
        if(a.rowLength()==b.rowLength() && a.columnLength()==b.columnLength()){
            ComplexMatrix response=new ComplexMatrix(a.rowLength(),a.columnLength());
            for (int row = 0; row<response.rowLength(); row++){
                for(int column = 0; column<response.columnLength(); column++){
                    response.set(row,column,complexAdd(a.get(row,column),b.get(row,column)));
                }
            }
            return response;
        }else{
            throw new MathComplexException("The given matrices do not have the same dimensions");
        }
    }

    /**
     * Make a complex matrix multiplication with an scalar complex number.
     * @param a Complex Matrix
     * @param b Scalar complex number
     * @return Answer of the scalar multiplication of a and b.
     */
    public static ComplexMatrix matrixScalarMultiplication(ComplexMatrix a, ComplexNumber b){
        ComplexMatrix response=new ComplexMatrix(a.rowLength(),a.columnLength());
        for (int row = 0; row<a.rowLength(); row++){
            for(int column = 0; column<a.columnLength(); column++){
                response.set(row,column,complexMultiplication(a.get(row,column),b));
            }
        }
        return response;
    }

    /**
     * Multiply two complex matrices.
     * @param a Multiplicand of the operation.
     * @param b Multiplying of the operation.
     * @return Complex matrix result of the multiplication of a and b.
     * @throws MathComplexException
     */
    public static ComplexMatrix matrixMultiplication(ComplexMatrix a,ComplexMatrix b) throws MathComplexException {
        if(a.columnLength()==b.rowLength()){
            ComplexMatrix answer=new ComplexMatrix(a.rowLength(),b.columnLength());
            for (int row = 0; row<answer.rowLength(); row++){
                for(int column = 0; column<answer.columnLength(); column++){
                    answer.set(row,column,matrixByIndexMultiplication(a,b,row,column));
                }
            }
            return answer;
        }else{
            throw new MathComplexException("The given matrices do not have the correct dimensions to make a matrix multiplication");
        }
    }

    /**
     * @param a Multiplicand of the operation.
     * @param b Multiplying of the operation.
     * @param r Row of index multiplication.
     * @param c Column of index multiplication.
     * @return Complex number result of the multiplication in the given indexes.
     */
    private static ComplexNumber matrixByIndexMultiplication(ComplexMatrix a,ComplexMatrix b, int r, int c){
        ComplexNumber answer=new ComplexNumber(0,0);
        for (int i = 0; i<a.columnLength(); i++){
                 answer=complexAdd(answer,complexMultiplication(a.get(r,i),b.get(i,c)));
        }
        return answer;
    }

    /**
     * Multiplies a complex matrix n*n with a vector n
     * @param a Complex matrix of n*n
     * @param b Complex vector of n
     * @return Action operation between a and b.
     * @throws MathComplexException
     */
    public static  ComplexMatrix action(ComplexMatrix a,ComplexMatrix b) throws MathComplexException {
        if(a.columnLength()!=a.rowLength()){
            throw new MathComplexException("The given matrix must be a square one.");
        }else if(a.rowLength()!=b.rowLength() || !b.isVector()){
            throw new MathComplexException("b must be a complex vector with same row lenght of matrix a");
        }else{
            return matrixMultiplication(a,b);
        }
    }

    /**
     * Returns inner product of two vectors
     * @param a Vector
     * @param b Vector
     * @return Complex number result of inner product of a and b.
     * @throws MathComplexException
     */
    public static ComplexNumber innerProduct(ComplexMatrix a,ComplexMatrix b) throws MathComplexException {
        if(a.rowLength()!=b.rowLength()|| !a.isVector() || !b.isVector()){
            throw new MathComplexException("The given objects must be vectors and must have same length");
        }else{
            a.transpose();
            return matrixMultiplication(a,b).get(0,0);
        }
    }

    /**
     * Return the tensor product between two complex matrices.
     * @param a complex matrix
     * @param b complex matrix
     * @return tensor product between a and b.
     */
    public static ComplexMatrix tensorProduct(ComplexMatrix a, ComplexMatrix b){
        ComplexMatrix answer= new ComplexMatrix(a.rowLength()*b.rowLength(),a.columnLength()*b.columnLength());
        for (int row1 = 0; row1 < a.rowLength(); row1++) {
            for (int column1 = 0; column1 < a.columnLength(); column1++) {
                for (int row2 = 0; row2 < b.rowLength(); row2++) {
                    for (int column2 = 0; column2 < b.columnLength(); column2++) {
                        answer.set(row1*b.rowLength()+row2,column1*b.columnLength()+column2,MathComplex.complexMultiplication(a.get(row1,column1),b.get(row2,column2)));
                    }
                }
            }
        }
        return answer;
    }

}
