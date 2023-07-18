package fi.tuni.prog3.junitattainment;


public class Attainment implements Comparable<Attainment> {

    private final String courseCode;
    private final String studentNumber;
    private final int grade;

    public Attainment(String courseCode, String studentNumber, int grade) {
        if (courseCode != null && studentNumber != null && grade >= 0 && grade <= 5) {
            this.courseCode = courseCode;
            this.studentNumber = studentNumber;
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Invalid course code, student number or grade!");
        }
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public int getGrade() {
        return this.grade;
    }

    public String toString() {
        return String.format("%s %s %d", this.courseCode, this.studentNumber, this.grade);
    }

    public int compareTo(Attainment var1) {
        int var2 = this.studentNumber.compareTo(var1.studentNumber);
        if (var2 == 0) {
            var2 = this.courseCode.compareTo(var1.courseCode);
        }

        return var2;
    }
}
