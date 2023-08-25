/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package no.hvl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {


    @Test
    public void testConvertFromUnitToMeters() {
        assertEquals(0.0254, App.convertFromUnitToMeters(1, "in"), 0.001);
        assertEquals(0.3048, App.convertFromUnitToMeters(1, "ft"), 0.001);
        assertEquals(1609.344, App.convertFromUnitToMeters(1, "mi"), 0.001);
        assertEquals(1, App.convertFromUnitToMeters(1, "m"));
        assertEquals(Double.NaN, App.convertFromUnitToMeters(1, "invalid"));
    }

    @Test
    public void testConvertToUnitFromMeters() {
        assertEquals(39.37007874015748, App.convertToUnitFromMeters(1, "in"), 0.0000001);
        assertEquals(3.280839895013123, App.convertToUnitFromMeters(1, "ft"), 0.0000001);
        assertEquals(0.0006213, App.convertToUnitFromMeters(1, "mi"), 0.0000001);
        assertEquals(1, App.convertToUnitFromMeters(1, "m"));
        assertEquals(Double.NaN, App.convertToUnitFromMeters(1, "invalid"));
    }


}
