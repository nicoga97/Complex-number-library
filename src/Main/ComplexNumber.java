package Main;

import java.util.Objects;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.imaginaryPart=imaginaryPart;
        this.realPart=realPart;
    }

    public void conjugate(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.realPart, realPart) == 0 &&
                Double.compare(that.imaginaryPart, imaginaryPart) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }
}
