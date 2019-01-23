package Main;

import java.lang.reflect.Array;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.imaginaryPart=imaginaryPart;
        this.realPart=realPart;
    }

    public void conjuate(){
        imaginaryPart=imaginaryPart*(-1);
    }

    public  double getModulus(){
        return Math.sqrt(Math.pow(realPart,2)+Math.pow(imaginaryPart,2));
    }

    public double getRealPart() {
        return realPart;
    }

    public double getPhase(){
        return Math.atan(imaginaryPart/realPart);
    }

    public double[] getAsPolar(){
        double [] a= new double[2];
        a[0]=getModulus();
        a[1]=getPhase();
        return a;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return "Main.ComplexNumber[" +
                + realPart +
                "," + imaginaryPart +
                ']';
    }
}
