package TestEX8KFS;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.DoubleStream;

public class PolygonHandlerImpl implements PolygonHandler {
    /**
     * Creates a polygon from array of doubles. This array will determine the sides of the polygon
     *
     * @param sides The values that determines the length of the sides
     * @return new polygon object
     * @throws Exception if sides cannot make up a polygon.
     */
    @Override
    public Polygon CreatePolygon(double[] sides) throws Exception {
        if (sides.length < 3) throw new Exception("invalid less than 3");
        if (sides.length > 10) throw new Exception("invalid greater than 10");
        if (!possibleSides(sides)) throw new Exception("invalid side length");
        Polygon P = new Polygon();
        P.sides = sides;
        return P;
    }

    private boolean possibleSides(double[] sides) {
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] >= DoubleStream.of(sides).sum() / 2) return false;
            if (sides[i] < 0) return false;
        }
        return true;
    }

    /**
     * Calculates the Polygon type.
     *
     * @param p The polygon which type is being calculated
     * @return A string which represent the type of the polygon.
     * @throws Exception If polygon is invalid
     */
    @Override
    public String CalculatePolygonType(Polygon p) throws Exception {
        String type = "error";
        if (p.sides.length < 3) throw new Exception("Invalid Polygon that has less than 3 sides");
        if (p.sides.length == 3) return "Triangle";
        if (p.sides.length == 4) return "Quadrilateral";
        if (p.sides.length == 5) return "Pentagon";
        if (p.sides.length == 6) return "Hexagon";
        if (p.sides.length == 7) return "Heptagon";
        if (p.sides.length == 8) return "Octagon";
        if (p.sides.length == 9) return "Nonagon";
        if (p.sides.length == 10) return "Decagon";
        if (p.sides.length > 10) throw new Exception("Invalid Polygon that has more than 10 sides");
        return type;
    }

    /**
     * This Method, calculates the area of the given polygon
     *
     * @param p which is the polygon that the area is being calculated from
     * @return A double value which represent the area in squaremeters
     * @throws Exception If polygon object is invalid or not determinerable without angles.
     */
    @Override
    public double CalculateArea(Polygon p) throws AssertionError {
        if (p.sides.length != 3) throw new AssertionError("Not a triangle");
        double S = (p.sides[0] + p.sides[1] + p.sides[2]) / 2;
        double Value = Math.sqrt(S * (S - p.sides[0]) * (S - p.sides[1]) * (S - p.sides[2]));
        DecimalFormat df = new DecimalFormat("#.###");
        String temp = df.format(Value);
        return Double.parseDouble(temp);
    }

    /**
     * This method will remove one of the sides of the polygon
     *
     * @param index The side which will be removed
     * @param p     The polygon which the side will be removed form
     * @return A new polygon with a side removed.
     * @throws Exception If side cannot be removed (outofindex) or Polygon is invalid.
     */
    @Override
    public Polygon RemoveSide(int index, Polygon p) throws Exception {
        double[] newSides = new double[p.sides.length - 1];
        boolean swapped = false;
        for (int i = 0; i < p.sides.length; i++) {
            if (i == index) {
                swapped = true;
                i++;
                if (i >= p.sides.length) break;
            }
            if (swapped) {
                newSides[i - 1] = p.sides[i];
            } else {
                newSides[i] = p.sides[i];
            }
        }
        Polygon d = CreatePolygon(newSides);
        return d;
    }

    /**
     * This methods, calculated the angles from a polygon which is limited to a triangle
     *
     * @param p Which is the polygon which the angles is being calculated from
     * @return An array of double values which represent the angles in degree's
     * @throws Exception If the polygon is not a triangle.
     */
    @Override
    public double[] CalculateAnglesFromTriangle(Polygon p) throws Exception {
        if (p.sides.length != 3) throw new Exception("NOPE");
        DecimalFormat df = new DecimalFormat("#.###");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        double alpha = Math.acos((Math.pow(p.sides[1], 2) + Math.pow(p.sides[2], 2) - Math.pow(p.sides[0], 2)) / (2 * p.sides[1] * p.sides[2]));
        alpha = alpha * (180 / Math.PI);
        String Alpha = df.format(alpha);
        double bravo = Math.acos((Math.pow(p.sides[0], 2) + Math.pow(p.sides[2], 2) - Math.pow(p.sides[1], 2)) / (2 * p.sides[0] * p.sides[2]));
        bravo = bravo * (180 / Math.PI);
        String Bravo = df.format(bravo);
        double charlie = Math.acos((Math.pow(p.sides[0], 2) + Math.pow(p.sides[1], 2) - Math.pow(p.sides[2], 2)) / (2 * p.sides[0] * p.sides[1]));
        charlie = charlie * (180 / Math.PI);
        String Charlie = df.format(charlie);
        double[] total = new double[]{Double.parseDouble(Alpha), Double.parseDouble(Bravo), Double.parseDouble(Charlie)};
        return total;
    }

    /**
     * This method will compare 2 polygons perimeter.
     *
     * @param a The first polygon for comparrison
     * @param b The second polygon for comparrison
     * @return The polygon with the largest perimeter
     * @throws Exception If polygon is invalid
     */
    @Override
    public Polygon ComparePolygonByPerimeter(Polygon a, Polygon b) throws Exception {
        double A = DoubleStream.of(a.sides).sum();
        double B = DoubleStream.of(b.sides).sum();
        if (A > B) return a;
        if (B > A) return b;
        return a;
    }

    /**
     * This method will intersect a polygon perimeter with another polygon
     *
     * @param a The polygon which will get intersected
     * @param b The polygon which will be intersecting
     * @return A double value that represents the intersection between the 2 polygons perimeter
     * @throws Exception If polygon is invalid
     */
    @Override
    public double IntersectPerimeterPolygon(Polygon a, Polygon b) throws Exception {
        double A = DoubleStream.of(a.sides).sum();
        double B = DoubleStream.of(b.sides).sum();
        if ((A - B) < 0) throw new Exception();
        return A - B;
    }

    /**
     * This method will union a polygons perimeter with another
     *
     * @param a The first polygon to be unioned
     * @param b The second polygon to be unioned
     * @return A double value that represents the unionen between the 2 polygons perimeter
     * @throws Exception If polygon is invalid
     */
    @Override
    public double UnionPerimeterPolygon(Polygon a, Polygon b) throws Exception {
        double A = DoubleStream.of(a.sides).sum();
        double B = DoubleStream.of(b.sides).sum();
        return A + B;
    }

    /**
     * This method will sort an arraylist of polygon by their perimeter.
     *
     * @param polygonArrayList Which is the array that needs to be sorted
     * @return A new Array that is sorted, lowest area first.
     * @throws Exception If polygons within the array is invalid or non comparable (ie. cannot calculate area because of missing angles in a square).
     */
    @Override
    public ArrayList<Polygon> SortByArea(ArrayList<Polygon> polygonArrayList) throws Exception {
        /*
        DecimalFormat df = new DecimalFormat("#.###");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        */
        for (Polygon polygon : polygonArrayList) {
            if (polygon.sides.length != 3) throw new Exception("Not a triangle");
        }
        polygonArrayList.sort(new Comparator<Polygon>() {
            @Override
            public int compare(Polygon o1, Polygon o2) {
                return Double.compare(CalculateArea(o1), CalculateArea(o2));
            }
        });
        /*
        ArrayList<Polygon> newList = new ArrayList<>();
        Polygon smallestPolygon = polygonArrayList.get(0);
        boolean running = true;
        while (running)
        {
            for (int i = 0; i < polygonArrayList.size(); i++) {
                for (Polygon polygon : polygonArrayList)
                {
                    if (CalculateArea(polygon) < CalculateArea(smallestPolygon)) smallestPolygon = polygon;
                }
                polygonArrayList.remove(smallestPolygon);
                polygonArrayList.add(polygonArrayList.get(i));
                polygonArrayList.set(i,smallestPolygon);
            }
            smallestPolygon = polygonArrayList.get(0);
            for (Polygon polygon : polygonArrayList)
            {
                if (CalculateArea(smallestPolygon) < CalculateArea(polygon))
                {
                    smallestPolygon = polygon;
                    running = false;
                }
                else
                {
                    running = true;
                    break;
                }
            }
        }
        */
        return polygonArrayList;
    }

    /**
     * This method will sort an arraylist of polygons by their total value of aggregated side length's
     *
     * @param polygonArrayList The array which will get sorted
     * @return A new Arraylist which has been sorted, lowest perimeter first.
     * @throws Exception If polygons within the array is invalid or non comparable.
     */
    @Override
    public ArrayList<Polygon> SortByPerimeter(ArrayList<Polygon> polygonArrayList) throws Exception {
        /*
        for (Polygon polygon : polygonArrayList)
        {
            if (polygon.sides.length != 3) throw new Exception("Not a triangle");
        }
        */
        polygonArrayList.sort(new Comparator<Polygon>() {
            @Override
            public int compare(Polygon o1, Polygon o2) {
                return Double.compare(calculatePerimeter(o1), calculatePerimeter(o2));
            }
        });
        return polygonArrayList;
    }

    public double calculatePerimeter(Polygon p) {
        return DoubleStream.of(p.sides).sum();
    }

    public String CalculateTriangleType(Polygon polygon) throws Exception {
        double[] s = polygon.sides;
        int type = 0;
        if (!(s[0]+s[1] > s[2] && s[0]+s[2] > s[1] && s[1]+s[2] > s[0] && s[0] > 0 && s[1] > 0 && s[2] > 0)) {
            return "Error";
        }

        if (s[0] == s[1] && s[1] == s[2]) {
            type = 2;
        } else if (s[0] == s[1] || s[1] == s[2] || s[0] == s[2]) {
            type = 1;
        } else {
            type = 0;
        }

        switch (type){
            case 0:
                return "Scalene";
            case 1:
                return "Isoleces";
            case 2:
                return "Equileteral";
            default: return "error";
        }

    }
}
