package Main;

public class ComplexMatrix {

    private ComplexNumber[][] matrix;

    /**
     * Complex matrix constructor
     * @param rows Number of  rows of the new complex matrix
     * @param columns Number of  columns of the new complex matrix
     */
    public ComplexMatrix(int rows,int columns) {
        matrix= new ComplexNumber[rows][columns];
    }

    /**
     * Complex matrix constructor
     * @param matrix Static Matrix with complex numbers in it.
     */
    public ComplexMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Transpose de complex matrix.
     */
    public void transpose(){
        ComplexNumber[][] t= new ComplexNumber[matrix[0].length][matrix.length];
        for (int row=0;row<matrix.length;row++){
            for(int column=0;column<matrix[row].length;column++){
                t[column][row]=matrix[row][column];
            }
        }
        matrix=t;
    }

    /**
     * Conjugate the complex matrix.
     */
    public void conjugate(){
        for (int row=0;row<matrix.length;row++){
            for(int column=0;column<matrix[row].length;column++){
                matrix[row][column].conjugate();
            }
        }
    }


    /**
     * Make the adjoint form of thr complex matrix.
     */
    public void adjoint(){
        transpose();
        conjugate();
    }

    /**
     * Gets an specific element of the complex matrix.
     * @param row Row where is the element.
     * @param column Column where is the element.
     * @return The complex number that is in the given entry.
     */
    public ComplexNumber get(int row,int column){
        return matrix[row][column];
    }

    public int columnLenght(){
        return matrix[0].length;
    }

    public int rowLenght(){
        return matrix.length;
    }

    public void set(int row,int column,ComplexNumber c){
        matrix[row][column]=c;
    }

    /**
     * Makes the inverse form of the complex matrix.
     */
    public void inverse(){
        for (int row=0;row<matrix.length;row++){
            for(int column=0;column<matrix[row].length;column++){
                matrix[row][column].inverse();
            }
        }
    }

    @Override
    public String toString() {
        String str= "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                str=str + matrix[row][column].toString();
                if(column==matrix[row].length-1){
                    str=str + "\n";
                }else{str=str+" , ";}
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ComplexMatrix) {
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    if(!matrix[row][column].equals(((ComplexMatrix) o).get(row,column))){
                       return false;
                    }
                }
            }
            return true;
        }else {return false;}
    }



}
