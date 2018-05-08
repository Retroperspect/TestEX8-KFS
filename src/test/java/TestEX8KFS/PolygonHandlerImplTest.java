package TestEX8KFS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runners.Parameterized;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class PolygonHandlerImplTest {

    private PolygonHandlerImpl phi;
    @BeforeEach
    void setUp() {
        phi = new PolygonHandlerImpl();
    }

    @ParameterizedTest(name = "{0},{1},{2},[3},{4}")
    @CsvFileSource(resources = "/Testdata.csv",delimiter = ';')
    void calculateTriangleType(String id, String A, String B, String C, String Type) throws Exception {
        Polygon P = new Polygon();
        P.sides = new double[] {Double.parseDouble(A),Double.parseDouble(B),Double.parseDouble(C)};
        String Result = phi.CalculateTriangleType(P);
        assertEquals(Result,Type);
    }
}