package me.Kaleb.libs.parabola;

/**
 * Represents a Parabola equation
 *
 * @see ParabolaType
 */
public class Parabola {
  /**
   * The type of parabola the object represents
   */
  public ParabolaType type;
  /**
   * The first variable in the equation
   */
  public double value1;
  /**
   * The second variable in the equation
   */
  public double value2;
  /**
   * The third variable in the equation
   */
  public double value3;
  
  /**
   * Main constructor for {@link Parabola}
   *
   * @param type The type of parabola
   * @param value1 The first variable in the equation
   * @param value2 The second variable in the equation
   * @param value3 The third variable in the equation
   */
  public Parabola(ParabolaType type, double value1, double value2, double value3) {
    this.type = type;
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
  }
  
  /**
   * Function used to find a variable from a parabola<br/>
   * When entering values, enter them in the order that they appear in the equation<br/>
   * Example: Finding "<b>a</b>" from <b>vertex</b> form:<br/>
   * Equation: <code>12.5 = a(6-8)<sup>2</sup> + 9</code><br/>
   * Function call: <code>double aValue = findVariable({@link VertexVariable#A}, 12.5, 6, 8, 9);</code>
   *
   * @param variable The variable to find
   * @param value1 The first variable in the equation
   * @param value2 The second variable in the equation
   * @param value3 The third variable in the equation
   * @param value4 The fourth variable in the equation
   * @return The {@code variable}'s value
   */
  public static double findVariable(ParabolaType type, IVariables variable, double value1, double value2, double value3, double value4) {
    // x, y, and a are used in every parabola type
    // Declared once at top to avoid repetition
    double x;
    double y = value1; // y will always be the first double argument
    double a;
    
    // Change the solve type based on the parabola type
    switch (type) {
      case VERTEX:
        // Declare h, k to represent h, k in a vertex parabola equation
        double h;
        double k;
  
        // Change the variable to solve for
        if (variable == VertexVariable.A) {
          // Set x, h, k to the remaining double arguments
          x = value2;
          h = value3;
          k = value4;
    
          // Calculate and return a
          a = y / Math.pow(x - h, 2) - k;
          return a;
        }
        break;
      case STANDARD:
        // Declare b, c to represent b, c in a standard parabola equation
        double b;
        double c;
  
        // Change the variable to solve for
        switch ((StandardVariable) variable) {
          case A:
            // Set x, b, c to the remaining double arguments
            x = value2;
            b = value3;
            c = value4;
  
            // Calculate and return a
            a = (y - b * x - c) / Math.pow(x, 2);
            return a;
          case B:
            // Set x, a, c to the remaining double arguments
            x = value2;
            a = value3;
            c = value4;
  
            // Calculate and return b
            b = (y - a * Math.pow(x, 2) - c) / x;
            return b;
          case C:
            // Set x, a, b to the remaining double arguments
            x = value2;
            a = value3;
            b = value4;
  
            // Calculate and return c
            c = y - a * Math.pow(x, 2) - b * x;
            return c;
        }
        break;
      case FACTORED:
        // Declare r, s to represent r, s in a factored parabola equation
        double r;
        double s;
  
        // Change the variable to solve for
        if (variable == FactoredVariable.A) {
          // Set x, r, s to the remaining double arguments
          x = value2;
          r = value3;
          s = value4;
  
          // Calculate and return a
          a = y / ((x - r) * (x - s));
          return a;
        }
        break;
    }
    // This should never be reached, if it is however it will just return 0.0
    return 0.0;
  }
  
  /**
   * Use this to convert from one equation form to another
   * When entering values, enter them in the order that they appear in the equation<br/>
   * Example: Converting from <b>standard</b> form to <b>vertex</b> form:<br/>
   * Equation: <code>y = 12x<sup>2</sup> + 9x - 4</code><br/>
   * Function call: <code>String newEquation = findVariable({@link ParabolaType#STANDARD}, {@link ParabolaType#VERTEX}, 12, 9, 4);</code>
   *
   * @param to The resulting {@link ParabolaType}
   * @return The converted equation
   */
  public Parabola convert(ParabolaType to) {
    // a is used in every parabola type and is declared first in every proper function call
    // Set once at the top to avoid repetition
    double a = value1;
  
    if (type == ParabolaType.STANDARD) {
      // Set b and c to the two remaining arguments
      double b = value2;
      double c = value3;
      switch (to) {
        case FACTORED:
          // Always use quadratic equation
          // Declare r, s to represent r, s in a factored equation
          double r;
          double s;
        
          // Calculate discriminant
          double discriminant = Math.sqrt(Math.pow(-b, 2) - 4 * a * c);
          // Calculate denominator
          double denominator = 2 * a;
          // Calculate numerator if -b + discriminant
          double numeratorPlus = -b + discriminant;
          // Calculate numerator if -b - discriminant
          double numeratorMinus = -b - discriminant;
        
          // Calculate roots (r, s)
          r = numeratorPlus / denominator;
          s = numeratorMinus / denominator;
  
          // Return the new parabola
          return new Parabola(to, a, r, s);
        case VERTEX:
          double h;
          double k;
        
          b /= a; // Factor out a(x^2 + (b/a)x) + c
        
          h = b / 2; // Get h from factored equation (which is b/2) (a bit of math done which to show visual which doesn't need to be done in code) a(x-b/2)^2 (other part)
          h = -h; // Invert h because of the - in x-h a(x-h)^2 (other part)
        
          k = -Math.pow(h, 2); // Square the newly calculated h a(x-h)^2 + h^2 + c
          k *= a; // Distribute a into the new h a(x-h)^2 + ah^2 + c
          k += c; // Add c to get k a(x-h)^2 + k
          
          // Return the new parabola
          return new Parabola(to, a, h, k);
        case STANDARD:
          // This should never be reached, if it is however it will just return itself
          return this;
      }
    } else if (type == ParabolaType.VERTEX) {
      // Set h and k to the two remaining arguments
      double h = value2;
      double k = value3;
    
      switch (to) {
        case STANDARD:
          // Declare b, c to represent b, c in a standard equation
          double b;
          double c;
          
          // Expand
          b = a * -h * 2;
          c = Math.pow(-h, 2) + k;
  
          // Return the new parabola
          return new Parabola(to, a, b, c);
        case FACTORED:
          // Convert from vertex to standard, then from standard to factored
          Parabola parabola = this.convert(ParabolaType.STANDARD);
          return parabola.convert(ParabolaType.FACTORED);
        case VERTEX:
          // This should never be reached, if it is however it will just return itself
          return this;
      }
    } else if (type == ParabolaType.FACTORED) {
      // Set r and s to the two remaining arguments
      double r = value2;
      double s = value3;
      
      switch (to) {
        case STANDARD:
          // Declare b, c to represent b, c in a standard equation
          double b;
          double c;
          
          // Expand
          b = r + s;
          c = r * s;
          
          // Return the new parabola
          return new Parabola(to, a, b, c);
        case VERTEX:
          // Convert from factored to standard, then from standard to vertex
          Parabola parabola = this.convert(ParabolaType.STANDARD);
          return parabola.convert(ParabolaType.VERTEX);
        case FACTORED:
          // This should never be reached, if it is however it will just return itself
          return this;
      }
    }
    // This should never be reached, so if it is for some reason, it will return null
    return null;
  }
  
  /**
   * Output parabola as an equation
   *
   * @return The equation
   */
  @Override
  public String toString() {
    switch (type) {
      case STANDARD:
        // Return the equation in standard form
        return value1 + "x^2 " + (value2 > 0 ? "+ " + value2 : "") + "x " + (value3 > 0 ? "+ " + value3 : value3);
      case VERTEX:
        // Return the equation in vertex form
        return value1 + "(x " + (value2 > 0 ? "- " + value2 : "+ " + -value2) + ")^2 " + (value3 > 0 ? "+ " + value3 : value3);
      case FACTORED:
        // Return the equation in factored form
        return value1 + "(x " + (value2 > 0 ? "- " + value2 : "+ " + -value2) + ")(x " + (value3 > 0 ? "- " + value3 : "+ " + -value3) + ")";
    }
    return null;
  }
  
  /**
   * Enum used for converting from one parabola form to another
   *
   * @see #convert
   */
  public enum ParabolaType {
    STANDARD,
    VERTEX,
    FACTORED
  }
  
  /**
   * Enum used for "Find variable from Standard form"
   *
   * @see #findVariable
   */
  public enum StandardVariable implements IVariables {
    A,
    B,
    C
  }
  
  /**
   * Enum used for "Find variable from Vertex form"
   *
   * @see #findVariable
   */
  public enum VertexVariable implements IVariables {
    A
  }
  
  /**
   * Enum used for "Find variable from Factored form"
   *
   * @see #findVariable
   */
  public enum FactoredVariable implements IVariables {
    A
  }
  
  /**
   * Marker interface for variable enums for {@link #findVariable}
   *
   * @see StandardVariable
   * @see VertexVariable
   * @see FactoredVariable
   */
  private interface IVariables {}
}
