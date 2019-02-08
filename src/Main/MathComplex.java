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

    public static ComplexMatrix matrixAddition(ComplexMatrix a,ComplexMatrix b) throws MathComplexException {
        if(a.rowLenght()==b.rowLenght() && a.columnLenght()==b.columnLenght()){
            ComplexMatrix response=new ComplexMatrix(a.rowLenght(),a.columnLenght());
            for (int row=0;row<response.rowLenght();row++){
                for(int column=0;column<response.columnLenght();column++){
                    response.set(row,column,complexAdd(a.get(row,column),b.get(row,column)));
                }
            }
            return response;
        }else{
            throw new MathComplexException("The given matrices do not have the same dimensions");
        }
    }

    public static ComplexMatrix matrixScalarMultiplication(ComplexMatrix a, ComplexNumber b){
        ComplexMatrix response=new ComplexMatrix(a.rowLenght(),a.columnLenght());
        for (int row=0;row<a.rowLenght();row++){
            for(int column=0;column<a.columnLenght();column++){
                response.set(row,column,complexMultiplication(a.get(row,column),b));
            }
        }
        return response;
    }

    public static ComplexMatrix matrixMultiplication(ComplexMatrix a,ComplexMatrix b) throws MathComplexException {
        if(a.columnLenght()==b.rowLenght()){
            ComplexMatrix answer=new ComplexMatrix(a.rowLenght(),b.columnLenght());
            for (int row=0;row<answer.rowLenght();row++){
                for(int column=0;column<answer.columnLenght();column++){
                    answer.set(row,column,matrixByIndexMultiplication(a,b,row,column));
                }
            }
            return answer;
        }else{
            throw new MathComplexException("The given matrices do not have the correct dimensions to make a matrix multiplication");
        }
    }

    private static ComplexNumber matrixByIndexMultiplication(ComplexMatrix a,ComplexMatrix b, int r, int c){
        ComplexNumber answer=new ComplexNumber(0,0);
        for (int row=r ;row<a.columnLenght();row++){
            for(int column=c;column<b.rowLenght();column++){
                answer=complexAdd(answer,complexMultiplication(a.get(row,column),b.get(column,row)));
            }
        }
        return answer;
    }

}
