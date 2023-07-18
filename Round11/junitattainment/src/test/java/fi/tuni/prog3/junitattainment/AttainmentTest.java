package fi.tuni.prog3.junitattainment;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AttainmentTest {

    @Test
    void attainmentBuilderCourseCode() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        assertEquals("CODE123", attainment.getCourseCode());
    }

    @Test
    void attainmentBuilderStudentNumber() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        assertEquals("999999", attainment.getStudentNumber());
    }

    @Test
    void attainmentBuilderGrade() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        assertEquals(5, attainment.getGrade());
    }

    @Test
    void GradeSixShouldReturnIllegalStateException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Attainment("CODE123", "999999", 6 ));
    }

    @Test
    void courseCodeNullShouldReturnIllegalStateException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Attainment(null, "999999", 6 ));
    }

    @Test
    void studentNumberNullShouldReturnIllegalStateException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Attainment("CODE123", null, 6 ));
    }

    @Test
    void attainmentToString() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        assertEquals("CODE123 999999 5", attainment.toString());
    }

    @Test
    void attainmentCompareToTwoSame() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        Attainment attainment2 = new Attainment("CODE123", "999999", 5 );
        //System.out.println(attainment.compareTo(attainment2));
        assertEquals(0, attainment.compareTo(attainment2));
    }

    @Test
    void attainmentCompareToStudentNumbers() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        Attainment attainment2 = new Attainment("CODE123", "99999", 5 );
        //System.out.println(attainment.compareTo(attainment2));
        assertEquals(1, attainment.compareTo(attainment2));
    }

    @Test
    void attainmentCompareToCoursesDifferent() {
        Attainment attainment = new Attainment("CODE123", "999999", 5 );
        Attainment attainment2 = new Attainment("CODE124", "999999", 5 );
        //System.out.println(attainment.compareTo(attainment2));
        assertEquals(-1, attainment.compareTo(attainment2));
    }

}