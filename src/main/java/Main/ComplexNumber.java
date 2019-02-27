package Main;

import java.util.Objects;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    /**
     * Complex number object constructor.
     *
     * @param realPart      Real part of the complex number.
     * @param imaginaryPart Imaginary part of the complex number.
     */
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
        this.realPart = realPart;
    }

    public ComplexNumber(ComplexNumber a) {
        this.imaginaryPart = a.getImaginaryPart();
        this.realPart = a.getRealPart();
    }

    /**
     * Conjugate the complex number.
     */
    public void conjugate() {
        if (imaginaryPart != 0) {
            imaginaryPart = imaginaryPart * (-1);
        }
    }

    /**
     * Calculate the modulus of the complex number.
     *
     * @return The modulus of the complex number.
     */
    public double getModulus() {
        return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
    }

    /**
     * Give the real part of the complex number.
     *
     * @return Real part of the complex number.
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Calculates the phase of a complex number.
     *
     * @return Phase of the complex number.
     */
    public double getPhase() {
        return Math.atan(imaginaryPart / realPart);
    }

    public double[] getAsPolar() {
        double[] a = new double[2];
        a[0] = getModulus();
        a[1] = getPhase();
        return a;
    }

    /**
     * Changes the real part of the complex number.
     *
     * @param realPart New real part value for the complex number.
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     * Gives the imaginary part of a complex number.
     *
     * @return Imaginary part of the complex  number.
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Changes the imaginary  part of the complex number.
     *
     * @param imaginaryPart New imaginary part value for the complex number.
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Apply the inverse form on the complex number.
     */
    public void inverse() {
        if (realPart != 0) {
            realPart = -realPart;
        }
        if (imaginaryPart != 0) {
            imaginaryPart = -imaginaryPart;
        }
    }

    @Override
    public String toString() {
        if (imaginaryPart > 0) {
            return
                    realPart +
                            " +" + imaginaryPart +
                            'i';
        } else if(imaginaryPart == 0){
            return
                    realPart+"";
        } else{
            return
                    realPart +
                            " " + imaginaryPart +
                            'i';
        }
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
