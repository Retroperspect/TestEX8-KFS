package TestEX8KFS;
import java.util.ArrayList;

public interface PolygonHandler {


    /**
     * Creates a polygon from array of doubles. This array will determine the sides of the polygon
     *
     * @param sides The values that determines the length of the sides
     * @return new polygon object
     * @throws Exception if sides cannot make up a polygon.
     */
    public Polygon CreatePolygon(double[] sides) throws Exception;

    /**
     * Calculates the Polygon type.
     *
     * @param p The polygon which type is being calculated
     * @return A string which represent the type of the polygon.
     * @throws Exception If polygon is invalid
     */
    public String CalculatePolygonType(Polygon p) throws Exception;

    /**
     * This Method, calculates the area of the given polygon
     *
     * @param p which is the polygon that the area is being calculated from
     * @return A double value which represent the area in squaremeters
     * @throws Exception If polygon object is invalid or not determinerable without angles.
     */
    public double CalculateArea(Polygon p) throws Exception;

    /**
     * This method will remove one of the sides of the polygon
     *
     * @param index The side which will be removed
     * @param p     The polygon which the side will be removed form
     * @return A new polygon with a side removed.
     * @throws Exception If side cannot be removed (outofindex) or Polygon is invalid.
     */
    public Polygon RemoveSide(int index, Polygon p) throws Exception;

    /**
     * This methods, calculated the angles from a polygon which is limited to a triangle
     *
     * @param p Which is the polygon which the angles is being calculated from
     * @return An array of double values which represent the angles in degree's
     * @throws Exception If the polygon is not a triangle.
     */
    public double[] CalculateAnglesFromTriangle(Polygon p) throws Exception;


    /**
     * This method will compare 2 polygons perimeter.
     *
     * @param a The first polygon for comparrison
     * @param b The second polygon for comparrison
     * @return The polygon with the largest perimeter
     * @throws Exception If polygon is invalid
     */
    public Polygon ComparePolygonByPerimeter(Polygon a, Polygon b) throws Exception;


    //Substract + Addition

    /**
     * This method will intersect a polygon perimeter with another polygon
     *
     * @param a The polygon which will get intersected
     * @param b The polygon which will be intersecting
     * @return A double value that represents the intersection between the 2 polygons perimeter
     * @throws Exception If polygon is invalid
     */
    public double IntersectPerimeterPolygon(Polygon a, Polygon b) throws Exception;

    /**
     * This method will union a polygons perimeter with another
     *
     * @param a The first polygon to be unioned
     * @param b The second polygon to be unioned
     * @return A double value that represents the unionen between the 2 polygons perimeter
     * @throws Exception If polygon is invalid
     */
    public double UnionPerimeterPolygon(Polygon a, Polygon b) throws Exception;

    /**
     * This method will sort an arraylist of polygon by their perimeter.
     *
     * @param polygonArrayList Which is the array that needs to be sorted
     * @return A new Array that is sorted, lowest area first.
     * @throws Exception If polygons within the array is invalid or non comparable (ie. cannot calculate area because of missing angles in a square).
     */
    public ArrayList<Polygon> SortByArea(ArrayList<Polygon> polygonArrayList) throws Exception;

    /**
     * This method will sort an arraylist of polygons by their total value of aggregated side length's
     *
     * @param polygonArrayList The array which will get sorted
     * @return A new Arraylist which has been sorted, lowest perimeter first.
     * @throws Exception If polygons within the array is invalid or non comparable.
     */
    public ArrayList<Polygon> SortByPerimeter(ArrayList<Polygon> polygonArrayList) throws Exception;


}
