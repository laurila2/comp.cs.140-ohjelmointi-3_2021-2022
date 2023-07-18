
import java.math.BigDecimal;
import java.math.RoundingMode;

public interface IShapeMetrics {

    double PI = getPI();

    private static double getPI() {

        BigDecimal bd = new BigDecimal(Double.toString(Math.PI));
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    String name();
    double area();
    double circumference();

}
