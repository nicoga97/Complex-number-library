package Main;

public class ComplexMatrix {

    private ComplexNumber[][] matrix;

    /**
     * Complex matrix constructor
     *
     * @param rows    Number of  rows of the new complex matrix
     * @param columns Number of  columns of the new complex matrix
     */
    public ComplexMatrix(int rows, int columns) {
        matrix = new ComplexNumber[rows][columns];
    }

    /**
     * Complex matrix constructor
     * @param matrix Static Matrix with complex numbers in it.
     */
    public ComplexMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    public ComplexMatrix(ComplexMatrix a){
        matrix=new ComplexNumber[a.rowLength()][a.columnLength()];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = new ComplexNumber(a.get(row,column));
            }
        }
    }
    /**
     * Transpose de complex matrix.
     */
    public void transpose() {
        ComplexNumber[][] t = new ComplexNumber[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                t[column][row] = matrix[row][column];
            }
        }
        matrix = t;
    }

    /**
     * Conjugate the complex matrix.
     */
    public void conjugate() {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column].conjugate();
            }
        }
    }


    /**
     * Make the adjoint form of the complex matrix.
     */
    public void adjoint() {
        transpose();
        conjugate();
    }

    /**
     * Gets an specific element of the complex matrix.
     *
     * @param row    Row where is the element.
     * @param column Column where is the element.
     * @return The complex number that is in the given entry.
     */
    public ComplexNumber get(int row, int column) {
        return matrix[row][column];
    }

    public int columnLength() {
        return matrix[0].length;
    }

    public int rowLength() {
        return matrix.length;
    }

    public void set(int row, int column, ComplexNumber c) {
        matrix[row][column] = c;
    }

    /**
     * Makes the inverse form of the complex matrix.
     */
    public void inverse() {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column].inverse();
            }
        }
    }

    /**
     * Returns if the matrix is a vector
     * @return True if the matrix is a vector.
     */
    public boolean isVector() {
        if ((rowLength() == 1 || columnLength() == 1) && columnLength() != rowLength()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gives the norm of the vector.
     * @return The norm of the vector.
     * @throws MathComplexException
     */
    public double norm() throws MathComplexException {
        if (isVector()) {
            ComplexNumber norm = new ComplexNumber(0,0);
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    norm=MathComplex.complexAdd(norm,new ComplexNumber(Math.pow(matrix[row][column].getRealPart(),2),Math.pow(matrix[row][column].getImaginaryPart(),2)));
                }
            }
            double result=Math.sqrt(norm.getRealPart()+norm.getImaginaryPart());
            norm.setRealPart(Math.sqrt(norm.getRealPart()));

            return result;
        }else{
            throw new MathComplexException("The matrix is not a vector.");
        }
    }

    /**
     * Answers if the matrix is an hermitian one.
     * @return true if the matrix is hermitian, false if not.
     */
    public boolean isHermitian(){
        ComplexMatrix a = new ComplexMatrix(this);
        a.adjoint();

        return this.equals(a);
    }

    /**
     * Returns if the matrix is unitary or not.
     * @return true if the matrix is unitary, false if not.
     * @throws MathComplexException
     */
    public boolean isUnitary() throws MathComplexException {
        if(columnLength()!=rowLength()){
            return false;
        }else{
            ComplexMatrix a = new ComplexMatrix(this);
            a.adjoint();
            ComplexMatrix i =MathComplex.matrixMultiplication(this,a);
            if(i.equals(MathComplex.matrixMultiplication(a,this))){
                for (int row = 0; row < i.rowLength(); row++) {
                    for (int column = 0; column < i.columnLength(); column++) {
                        if((row==column && !i.get(row, column).equals(new ComplexNumber(1, 0)))|| (row!=column && !i.get(row, column).equals(new ComplexNumber(0, 0)))){
                            return false;
                        }
                    }
                }
                return true;
            }else{return false;}
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                str = str + matrix[row][column].toString();
                if (column == matrix[row].length - 1) {
                    str = str + "\n";
                } else {
                    str = str + " , ";
                }
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ComplexMatrix) {
            if(((ComplexMatrix) o).columnLength()!=columnLength() || ((ComplexMatrix) o).rowLength()!=rowLength()){
                return false;
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    if (!matrix[row][column].equals(((ComplexMatrix) o).get(row, column))) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }


}
