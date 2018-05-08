package TestEX8KFS;

import java.util.ArrayList;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.*;

class PolygonHandlerTest {

    PolygonHandler PH;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        PH = new PolygonHandlerImpl();
    }

    /*
    Standard tests
     */

    @org.junit.jupiter.api.Test
    void createPolygon() throws Exception {
        double[] sides = new double[]{1, 2, 2};
        Polygon P = PH.CreatePolygon(sides);
        assertTrue(sides == P.sides);
    }

    @org.junit.jupiter.api.Test
    void calculatePolygonType() throws Exception {

        double[] sides;
        Polygon P;
        String pType;

        //Triangle
        sides = new double[]{1, 2, 2};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Triangle");

        //Square
        sides = new double[]{1, 2, 3, 4};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Quadrilateral");

        //Pentagon
        sides = new double[]{1, 2, 3, 4, 5};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Pentagon");

        //Hexagon
        sides = new double[]{1, 2, 3, 4, 5, 6};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Hexagon");

        //Heptagon
        sides = new double[]{1, 2, 3, 4, 5, 6, 7};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Heptagon");

        //Octagon
        sides = new double[]{1, 2, 3, 4, 5, 6, 7, 8};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Octagon");

        //Nonagon
        sides = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Nonagon");

        //Decagon
        sides = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        P = PH.CreatePolygon(sides);
        pType = PH.CalculatePolygonType(P);
        assertTrue(pType == "Decagon");
    }

    @org.junit.jupiter.api.Test
    void calculateArea() throws Exception {

        double area;
        double[] sides;
        Polygon P;

        //Invalid
        sides = new double[]{5, 5};
        double[] finalSides = sides;
        assertThrows(Exception.class, () -> {
            Polygon finalP = PH.CreatePolygon(finalSides);});

        //Triangle
        sides = new double[]{5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 10.825);

        /*
        //Square
        sides = new double[] {5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 25);

        //Pentagon
        sides = new double[] {5, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 43.012);

        //Hexagon
        sides = new double[] {5, 5, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 64.952);

        //Heptagon
        sides = new double[] {5, 5, 5, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 90.848);

        //Octagon
        sides = new double[] {5, 5, 5, 5, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 120.711);

        //Nonagon
        sides = new double[] {5, 5, 5, 5, 5, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 154.546);

        //Decagon
        sides = new double[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        area = PH.CalculateArea(P);
        assertTrue(area == 192.355);
        */
    }

    @org.junit.jupiter.api.Test
    void removeSide() throws Exception {
        double[] sides;
        double[] expected;
        Polygon P;

        sides = new double[]{2, 3, 4, 5, 6};
        expected = new double[]{2, 3, 5, 6};
        P = PH.CreatePolygon(sides);

        Polygon New = PH.RemoveSide(2, P);

        assertArrayEquals(expected, New.sides);
    }

    @org.junit.jupiter.api.Test
    void calculateAnglesFromTriangle() throws Exception {
        double[] sides = new double[]{2, 4, 3.5};
        Polygon P = PH.CreatePolygon(sides);
        double[] angles = PH.CalculateAnglesFromTriangle(P);

        assertTrue(DoubleStream.of(angles).anyMatch(x -> x == 29.995));
        assertTrue(DoubleStream.of(angles).anyMatch(x -> x == 88.977));
        assertTrue(DoubleStream.of(angles).anyMatch(x -> x == 61.028));
    }

    @org.junit.jupiter.api.Test
    void comparePolygonByPerimeter() throws Exception {

        double[] sides;
        Polygon P;
        Polygon B;

        sides = new double[]{2, 3, 4, 5, 4};
        P = PH.CreatePolygon(sides);
        sides = new double[]{2.3, 3.1, 3.5, 5.5};
        B = PH.CreatePolygon(sides);
        Polygon Biggest = PH.ComparePolygonByPerimeter(P, B);
        assertTrue(Biggest == P && Biggest != null);
    }

    @org.junit.jupiter.api.Test
    void intersectPerimeterPolygon() throws Exception {
        double area;
        double[] sides;
        Polygon P;
        Polygon B;

        sides = new double[]{2, 3, 4, 8}; //17
        P = PH.CreatePolygon(sides);
        sides = new double[]{3, 4, 5, 3}; //15
        B = PH.CreatePolygon(sides);
        area = PH.IntersectPerimeterPolygon(P, B);

        assertTrue(area == 2);
    }

    @org.junit.jupiter.api.Test
    void unionPerimeterPolygon() throws Exception {
        double area;
        double[] sides;
        Polygon P;
        Polygon B;

        sides = new double[]{2, 3, 4, 8}; //17
        P = PH.CreatePolygon(sides);
        sides = new double[]{3, 4, 5, 3}; //15
        B = PH.CreatePolygon(sides);
        area = PH.UnionPerimeterPolygon(P, B);

        assertTrue(area == 32);
    }

    @org.junit.jupiter.api.Test
    void sortByArea() throws Exception {

        double[] sides;

        sides = new double[]{1, 2, 2};
        Polygon A = PH.CreatePolygon(sides);
        sides = new double[]{11, 22, 22};
        Polygon B = PH.CreatePolygon(sides);
        sides = new double[]{111, 222, 222};
        Polygon C = PH.CreatePolygon(sides);
        sides = new double[]{1111, 2222, 2222};
        Polygon D = PH.CreatePolygon(sides);
        sides = new double[]{11111, 22222, 22222};
        Polygon E = PH.CreatePolygon(sides);

        ArrayList<Polygon> list = new ArrayList<Polygon>();
        list.add(D);
        list.add(C);
        list.add(E);
        list.add(A);
        list.add(B);

        ArrayList<Polygon> sortedList = PH.SortByArea(list);

        assertAll(
                () -> assertTrue(sortedList.get(0) == A),
                () -> assertTrue(sortedList.get(1) == B),
                () -> assertTrue(sortedList.get(2) == C),
                () -> assertTrue(sortedList.get(3) == D),
                () -> assertTrue(sortedList.get(4) == E)
        );
    }

    @org.junit.jupiter.api.Test
    void sortByPerimeter() throws Exception {

        double[] sides;

        sides = new double[]{1, 2, 2};
        Polygon A = PH.CreatePolygon(sides);
        sides = new double[]{11, 22, 33, 44, 55};
        Polygon B = PH.CreatePolygon(sides);
        sides = new double[]{111, 222, 222};
        Polygon C = PH.CreatePolygon(sides);
        sides = new double[]{1111, 2222, 3333, 4444};
        Polygon D = PH.CreatePolygon(sides);
        sides = new double[]{11111, 22222, 33333, 44444, 55555};
        Polygon E = PH.CreatePolygon(sides);

        ArrayList<Polygon> list = new ArrayList<Polygon>();
        list.add(D);
        list.add(C);
        list.add(E);
        list.add(A);
        list.add(B);

        ArrayList<Polygon> sortedList = PH.SortByPerimeter(list);

        assertAll(
                () -> assertTrue(sortedList.get(0) == A),
                () -> assertTrue(sortedList.get(1) == B),
                () -> assertTrue(sortedList.get(2) == C),
                () -> assertTrue(sortedList.get(3) == D),
                () -> assertTrue(sortedList.get(4) == E)
        );
    }

    /*
    Boundary Analysis
     */

    @org.junit.jupiter.api.Test
    void BoundaryCreate() throws Exception {

        //Invalid with 2 or less sides
        double[] sides = {1, 2};
        double[] finalSides = sides;
        assertThrows(Exception.class, () -> {
            Polygon p = PH.CreatePolygon(finalSides);
        });

        //valid with 3 sides
        sides = new double[]{1, 3, 3};
        Polygon a = PH.CreatePolygon(sides);
        assertTrue(a.sides[0] == 1 && a.sides[1] == 3 && a.sides[2] == 3);

        //valid with 10 sides
        sides = new double[]{101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
        a = PH.CreatePolygon(sides);
        assertTrue(a.sides[0] == 101 && a.sides[1] == 102 && a.sides[2] == 103 && a.sides[3] == 104 && a.sides[4] == 105 && a.sides[5] == 106 && a.sides[6] == 107 && a.sides[7] == 108 && a.sides[8] == 109 && a.sides[9] == 110);

        //invalid with 11 sides
        sides = new double[]{101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111};
        double[] finalSides1 = sides;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.CreatePolygon(finalSides1);
        });
    }

    @org.junit.jupiter.api.Test
    void BoundaryRemoveSides() throws Exception {

        //invalid -1
        double[] sides = {7, 5, 5, 5, 5};
        Polygon P = PH.CreatePolygon(sides);
        Polygon finalP = P;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.RemoveSide(-1, finalP);
        });

        //valid 0
        sides = new double[]{7, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        Polygon removedSide = PH.RemoveSide(0, P);
        assertTrue(removedSide.sides.length == P.sides.length - 1);

        //valid side.count-1
        sides = new double[]{7, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        removedSide = PH.RemoveSide(P.sides.length - 1, P);
        assertTrue(removedSide.sides.length == P.sides.length - 1);

        //invalid side.count
        sides = new double[]{7, 5, 5, 5, 5};
        P = PH.CreatePolygon(sides);
        Polygon finalP1 = P;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.RemoveSide(finalP1.sides.length, finalP1);
        });
    }

    /*
    Equivalence classes
     */

    @org.junit.jupiter.api.Test
    void EquivalenceClassCreate() throws Exception {

        //valid with 5 sides
        double[] sides = new double[]{5, 5, 5, 5, 5};
        Polygon P = PH.CreatePolygon(sides);
        assertTrue(P.sides.length == 5);

        //invalid with 1 side
        sides = new double[]{5};
        double[] finalSides = sides;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.CreatePolygon(finalSides);
        });

        // valid with 525 as value
        sides = new double[]{525, 525, 525, 525};
        P = PH.CreatePolygon(sides);
        assertTrue(P.sides[0] == 525);

        // invalid with value of -5
        sides = new double[]{-5, 0, -525, 525};
        double[] finalSides1 = sides;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.CreatePolygon(finalSides1);
        });
    }

    @org.junit.jupiter.api.Test
    void EquivalenceClassType() throws Exception {

        // A side is bigger than the summation of other sides
        double[] sides = new double[]{1, 2, 3};
        double[] finalSides = sides;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.CreatePolygon(finalSides);
        });

        // any side is not bigger than the summation of other sides
        sides = new double[]{2, 2, 2};
        Polygon P = PH.CreatePolygon(sides);
        assertTrue(P.sides.length == 3);
    }

    @org.junit.jupiter.api.Test
    void EquivalenceClassCalculateAreaAndAngles() throws Exception {

        //with 3 sides. valid
        double[] sides = {2, 2, 2};
        Polygon P = PH.CreatePolygon(sides);
        double[] Angles = PH.CalculateAnglesFromTriangle(P);
        double Area = PH.CalculateArea(P);

        //with 4 sides. invalid
        sides = new double[]{6, 4, 6, 5};
        P = PH.CreatePolygon(sides);
        Polygon finalP = P;
        assertThrows(Exception.class, () -> {
            double[] angles = PH.CalculateAnglesFromTriangle(finalP);
        });
        assertThrows(AssertionError.class, () -> {
            double area = PH.CalculateArea(finalP);
        });

        //with 2 sides. invalid
        sides = new double[]{6, 5};
        double[] finalSides = sides;
        assertThrows(Exception.class, () -> {
            Polygon A = PH.CreatePolygon(finalSides);
        });

    }

    @org.junit.jupiter.api.Test
    void EquivalenceClassIntersectPerimeterPolygon() throws Exception {

        //A is bigger = valid
        double[] sides = {15, 15, 15};
        Polygon A = PH.CreatePolygon(sides);
        sides = new double[]{10, 10, 10};
        Polygon B = PH.CreatePolygon(sides);
        assertTrue(PH.IntersectPerimeterPolygon(A, B) == 15);

        //B is bigger = invalid
        sides = new double[]{10, 10, 10};
        A = PH.CreatePolygon(sides);
        sides = new double[]{15, 15, 15};
        B = PH.CreatePolygon(sides);

        Polygon finalA = A;
        Polygon finalB = B;
        assertThrows(Exception.class, () -> {
            double errorResult = PH.IntersectPerimeterPolygon(finalA, finalB);
        });


    }

    @org.junit.jupiter.api.Test
    void EquivalenceClassSortByArea() throws Exception {
        // All polygons are triangles
        ArrayList<Polygon> list = new ArrayList<Polygon>();
        double[] sides = {15, 15, 15};
        Polygon P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{10, 22, 15};
        P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{12, 12, 21};
        P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{20, 12, 11};
        P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{10, 13, 14};
        P = PH.CreatePolygon(sides);
        list.add(P);

        ArrayList<Polygon> sortedList = PH.SortByArea(list);

        // Not all polygons are triangles
        list = new ArrayList<Polygon>();
        sides = new double[]{10, 13, 15};
        P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{10, 22, 15, 22, 13};
        P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{10, 9, 11};
        P = PH.CreatePolygon(sides);
        list.add(P);
        sides = new double[]{10, 14, 12};
        P = PH.CreatePolygon(sides);
        list.add(P);

        ArrayList<Polygon> finalList = list;
        assertThrows(Exception.class, () -> {
            ArrayList<Polygon> ErrorList = PH.SortByArea(finalList);
        });
    }
}