package com.epam.melnik.java.exception.entity.universitystructure;

import com.epam.melnik.java.exception.entity.person.ExternalStudent;
import com.epam.melnik.java.exception.entity.person.Student;
import com.epam.melnik.java.exception.entity.person.StudentStatus;
import com.epam.melnik.java.exception.entity.subject.Biology;
import com.epam.melnik.java.exception.entity.subject.EducationSubject;
import com.epam.melnik.java.exception.entity.subject.Literature;
import com.epam.melnik.java.exception.entity.subject.Mathematics;
import com.epam.melnik.java.exception.studentexception.logic.GradeLessMinException;
import com.epam.melnik.java.exception.studentexception.logic.GradeMoreMaxException;
import com.epam.melnik.java.exception.studentexception.technik.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class DeansOfficeTest {

    private EducationSubject math;
    private EducationSubject biology;
    private EducationSubject literature;
    private Student testedStudent;

    @Before
    public void setUp() throws Exception {

        math = new Mathematics();
        math.setSubjectName("Math");
        biology = new Biology();
        biology.setSubjectName("Biology");
        literature = new Literature();
        literature.setSubjectName("Literature");

        testedStudent = new ExternalStudent();
        testedStudent.setStatus(StudentStatus.EXTERNAL);
        testedStudent.setSecondName("Test");
    }

    @Test
    public void getAverageByAllStudentEducationSubject() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 5.5);
        studentGrades.put(biology.getSubjectName(), 6.5);
        studentGrades.put(literature.getSubjectName(), 7.5);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);

        try {
            assertEquals(6.5,
                    DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent),
                    0.01);
        } catch (StudentHasNotAnySubjectException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageByAllStudentEducationSubjectWithNullStudent()
            throws StudentHasNotAnySubjectException {

        DeansOffice.getAverageGradeByAllStudentEducationSubject(null);
    }

    @Test(expected = StudentHasNotAnySubjectException.class)
    public void getAverageByAllStudentEducationSubjectWithAbsentGrades()
            throws StudentHasNotAnySubjectException {

        DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent);
    }

    @Test(expected = StudentHasNotAnySubjectException.class)
    public void getAverageByAllStudentEducationSubjectWithEmptyGrades()
            throws StudentHasNotAnySubjectException {

        testedStudent.setEducationSubjectAverageGrades(new HashMap<>());
        DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent);
    }

    @Test
    public void getAverageByAllStudentEducationSubjectWithOneNullSubjectGrades() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 5.5);
        studentGrades.put(biology.getSubjectName(), null);
        studentGrades.put(literature.getSubjectName(), 7.5);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);

        try {
            assertEquals(6.5,
                    DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent),
                    0.01);
        } catch (StudentHasNotAnySubjectException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageByAllStudentEducationSubjectWithAllNullSubjectGrades() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), null);
        studentGrades.put(biology.getSubjectName(), null);
        studentGrades.put(literature.getSubjectName(), null);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);

        try {
            assertEquals(0,
                    DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent),
                    0.01);
        } catch (StudentHasNotAnySubjectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAverageByAllStudentEducationSubjectWithNullSubjectName() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 5.5);
        studentGrades.put(null, 6.5);
        studentGrades.put(literature.getSubjectName(), 7.5);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);

        try {
            assertEquals(6.5,
                    DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent),
                    0.01);
        } catch (StudentHasNotAnySubjectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAverageByAllStudentEducationSubjectWithEmptySubjectName() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 5.5);
        studentGrades.put("", 6.5);
        studentGrades.put(literature.getSubjectName(), 7.5);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);

        try {
            assertEquals(6.5,
                    DeansOffice.getAverageGradeByAllStudentEducationSubject(testedStudent),
                    0.01);
        } catch (StudentHasNotAnySubjectException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAverageGradeForEducationSubjectWithNullStudent() {

        DeansOffice.addAverageGradeForEducationSubject(null, math, 2.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAverageGradeForEducationSubjectWithNullEducationSubject() {

        DeansOffice.addAverageGradeForEducationSubject(testedStudent, null, 2.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAverageGradeForEducationSubjectWithNullAverageGrade() {

        DeansOffice.addAverageGradeForEducationSubject(testedStudent, math, null);
    }

    @Test(expected = EducationSubjectNameIsAbsentException.class)
    public void addAverageGradeForEducationSubjectWithEducationSubjectNameNull() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 2.5);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);
        DeansOffice.addAverageGradeForEducationSubject(testedStudent, new Biology(), 5.5);
    }

    @Test(expected = EducationSubjectNameIsAbsentException.class)
    public void addAverageGradeForEducationSubjectWithEmptyEducationSubjectName() {

        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 2.5);
        testedStudent.setEducationSubjectAverageGrades(studentGrades);
        biology.setSubjectName("");
        DeansOffice.addAverageGradeForEducationSubject(testedStudent, biology, 5.5);
    }

    @Test(expected = GradeLessMinException.class)
    public void addAverageGradeForEducationSubjectWithAverageGradeLessMin() {

        DeansOffice.addAverageGradeForEducationSubject(testedStudent, biology, -5.5);
    }

    @Test(expected = GradeMoreMaxException.class)
    public void addAverageGradeForEducationSubjectWithAverageGradeMoreMax() {

        DeansOffice.addAverageGradeForEducationSubject(testedStudent, biology, 55.5);
    }

    @Test
    public void addAverageGradeForEducationSubjectWithAverageGradesNull() {

        DeansOffice.addAverageGradeForEducationSubject(testedStudent, biology, 5.5);

        Student student = new ExternalStudent();
        student.setStatus(StudentStatus.EXTERNAL);
        student.setSecondName("Test");
        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(biology.getSubjectName(), 5.5);
        student.setEducationSubjectAverageGrades(studentGrades);

        assertEquals(student, testedStudent);
    }

    @Test
    public void addAverageGradeForEducationSubject() {

        Map<String, Double> testedStudentGrades = new HashMap<>();
        testedStudentGrades.put(math.getSubjectName(), 5.5);
        testedStudent.setEducationSubjectAverageGrades(testedStudentGrades);

        DeansOffice.addAverageGradeForEducationSubject(testedStudent, biology, 5.5);

        Student student = new ExternalStudent();
        student.setStatus(StudentStatus.EXTERNAL);
        student.setSecondName("Test");
        Map<String, Double> studentGrades = new HashMap<>();
        studentGrades.put(math.getSubjectName(), 5.5);
        studentGrades.put(biology.getSubjectName(), 5.5);
        student.setEducationSubjectAverageGrades(studentGrades);

        assertEquals(student, testedStudent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageGradeByEducationSubjectInGroupWithStudentGroupNull()
            throws EmptyStudentGroupException {

        DeansOffice.getAverageGradeByEducationSubjectInGroup(null, math);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageGradeByEducationSubjectInGroupWithEducationSubjectNull()
            throws EmptyStudentGroupException {

        DeansOffice.getAverageGradeByEducationSubjectInGroup(new StudentGroup(), null);
    }

    @Test(expected = EducationSubjectNameIsAbsentException.class)
    public void getAverageGradeByEducationSubjectInGroupWithEducationSubjectNameNull()
            throws EmptyStudentGroupException {

        EducationSubject educationSubject = new Mathematics();
        DeansOffice.getAverageGradeByEducationSubjectInGroup(new StudentGroup(), educationSubject);
    }

    @Test(expected = EducationSubjectNameIsAbsentException.class)
    public void getAverageGradeByEducationSubjectInGroupWithEmptyEducationSubjectName()
            throws EmptyStudentGroupException {

        EducationSubject educationSubject = new Mathematics();
        educationSubject.setSubjectName("");
        DeansOffice.getAverageGradeByEducationSubjectInGroup(new StudentGroup(), educationSubject);
    }

    @Test(expected = EmptyStudentGroupException.class)
    public void getAverageGradeByEducationSubjectInGroupWithListStudentsNull()
            throws EmptyStudentGroupException {

        StudentGroup studentGroup = new StudentGroup();
        DeansOffice.getAverageGradeByEducationSubjectInGroup(studentGroup, math);
    }

    @Test(expected = EmptyStudentGroupException.class)
    public void getAverageGradeByEducationSubjectInGroupWithEmptyListStudents()
            throws EmptyStudentGroupException {

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupStudents(new ArrayList<>());
        DeansOffice.getAverageGradeByEducationSubjectInGroup(studentGroup, math);
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageGradeByEducationSubjectInGroupWithAllStudentsNull()
            throws EmptyStudentGroupException {

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupStudents(Arrays.asList(new Student[]{null, null}));
        DeansOffice.getAverageGradeByEducationSubjectInGroup(studentGroup, math);
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageGradeByEducationSubjectInGroupWithNullGradesForAllStudent()
            throws EmptyStudentGroupException {

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupStudents(Arrays.asList(new Student[]{new ExternalStudent(), new ExternalStudent()}));
        DeansOffice.getAverageGradeByEducationSubjectInGroup(studentGroup, math);
    }

    @Test
    public void getAverageGradeByEducationSubjectInGroup()
            throws EmptyStudentGroupException {

        StudentGroup studentGroup = new StudentGroup();
        List<Student> students = new ArrayList<>();
        Student firstStudent = new ExternalStudent();
        Map<String, Double> firstStudentGrades = new HashMap<>();
        firstStudentGrades.put(math.getSubjectName(), 5.5);
        firstStudent.setEducationSubjectAverageGrades(firstStudentGrades);
        students.add(firstStudent);
        Student secondStudent = new ExternalStudent();
        studentGroup.setGroupStudents(students);
        students.add(secondStudent);

        assertEquals(5.5,
                DeansOffice.getAverageGradeByEducationSubjectInGroup(studentGroup, math), 0.01);
    }

    @Test
    public void getAverageGradeByEducationSubjectOnFaculty() throws
            EmptyFacultyException {

        Student firstStudent = new ExternalStudent();
        Map<String, Double> firstStudentGrades = new HashMap<>();
        firstStudentGrades.put(math.getSubjectName(), 5.5);
        firstStudent.setEducationSubjectAverageGrades(firstStudentGrades);

        Student secondStudent = new ExternalStudent();
        Map<String, Double> secondStudentGrades = new HashMap<>();
        secondStudentGrades.put(math.getSubjectName(), 6.5);
        secondStudent.setEducationSubjectAverageGrades(secondStudentGrades);

        List<Student> studentsInFirstGroup = new ArrayList<>();
        studentsInFirstGroup.add(firstStudent);
        studentsInFirstGroup.add(secondStudent);

        StudentGroup firstStudentGroup = new StudentGroup();
        firstStudentGroup.setGroupStudents(studentsInFirstGroup);

        Student thirdStudent = new ExternalStudent();
        Map<String, Double> thirdStudentGrades = new HashMap<>();
        thirdStudentGrades.put(math.getSubjectName(), 2.5);
        thirdStudent.setEducationSubjectAverageGrades(thirdStudentGrades);

        Student fourthStudent = new ExternalStudent();
        Map<String, Double> fourthStudentGrades = new HashMap<>();
        fourthStudentGrades.put(math.getSubjectName(), 7.5);
        fourthStudent.setEducationSubjectAverageGrades(fourthStudentGrades);

        List<Student> studentsInSecondGroup = new ArrayList<>();
        studentsInSecondGroup.add(thirdStudent);
        studentsInSecondGroup.add(fourthStudent);


        StudentGroup secondStudentGroup = new StudentGroup();
        secondStudentGroup.setGroupStudents(studentsInSecondGroup);

        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(firstStudentGroup);
        studentGroups.add(secondStudentGroup);

        Faculty faculty = new Faculty();
        faculty.setStudentGroups(studentGroups);

        assertEquals(5.5,
                DeansOffice.getAverageGradeByEducationSubjectOnFaculty(faculty, math), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageGradeByEducationSubjectOnFacultyWithFacultyNull()
            throws EmptyFacultyException {

        DeansOffice.getAverageGradeByEducationSubjectOnFaculty(null, math);
    }

    @Test(expected = EmptyFacultyException.class)
    public void getAverageGradeByEducationSubjectOnFacultyWithGroupsOnFacultyNull()
            throws EmptyFacultyException {

        Faculty faculty = new Faculty();
        DeansOffice.getAverageGradeByEducationSubjectOnFaculty(faculty, math);
    }

    @Test(expected = EmptyFacultyException.class)
    public void getAverageGradeByEducationSubjectOnFacultyWithGroupsOnFacultyEmpty()
            throws EmptyFacultyException {

        Faculty faculty = new Faculty();
        faculty.setStudentGroups(new ArrayList<>());
        DeansOffice.getAverageGradeByEducationSubjectOnFaculty(faculty, math);
    }

    @Test
    public void getAverageGradeByEducationSubjectInUniversity() throws EmptyUniversityException {

        Student firstStudent = new ExternalStudent();
        Map<String, Double> firstStudentGrades = new HashMap<>();
        firstStudentGrades.put(math.getSubjectName(), 5.5);
        firstStudent.setEducationSubjectAverageGrades(firstStudentGrades);

        Student secondStudent = new ExternalStudent();
        Map<String, Double> secondStudentGrades = new HashMap<>();
        secondStudentGrades.put(math.getSubjectName(), 6.5);
        secondStudent.setEducationSubjectAverageGrades(secondStudentGrades);

        List<Student> studentsInFirstGroup = new ArrayList<>();
        studentsInFirstGroup.add(firstStudent);
        studentsInFirstGroup.add(secondStudent);

        StudentGroup firstStudentGroup = new StudentGroup();
        firstStudentGroup.setGroupStudents(studentsInFirstGroup);

        Student thirdStudent = new ExternalStudent();
        Map<String, Double> thirdStudentGrades = new HashMap<>();
        thirdStudentGrades.put(math.getSubjectName(), 2.5);
        thirdStudent.setEducationSubjectAverageGrades(thirdStudentGrades);

        Student fourthStudent = new ExternalStudent();
        Map<String, Double> fourthStudentGrades = new HashMap<>();
        fourthStudentGrades.put(math.getSubjectName(), 7.5);
        fourthStudent.setEducationSubjectAverageGrades(fourthStudentGrades);

        List<Student> studentsInSecondGroup = new ArrayList<>();
        studentsInSecondGroup.add(thirdStudent);
        studentsInSecondGroup.add(fourthStudent);


        StudentGroup secondStudentGroup = new StudentGroup();
        secondStudentGroup.setGroupStudents(studentsInSecondGroup);

        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(firstStudentGroup);
        studentGroups.add(secondStudentGroup);

        Faculty faculty = new Faculty();
        faculty.setStudentGroups(studentGroups);

        University university = new University();
        List<Faculty> facultiesInUniversity = new ArrayList<>();
        facultiesInUniversity.add(faculty);
        facultiesInUniversity.add(faculty);
        university.setFaculties(facultiesInUniversity);

        assertEquals(5.5,
                DeansOffice.getAverageGradeByEducationSubjectInUniversity(university, math), 0.01);

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageGradeByEducationSubjectInUniversityWithUniversityNull
            () throws EmptyUniversityException {

        DeansOffice.getAverageGradeByEducationSubjectInUniversity(null, math);
    }

    @Test(expected = EmptyUniversityException.class)
    public void getAverageGradeByEducationSubjectInUniversityWithEmptyFacultiesInUniversity
            () throws EmptyUniversityException {

        University university = new University();
        university.setFaculties(new ArrayList<>());
        DeansOffice.getAverageGradeByEducationSubjectInUniversity(university, math);
    }

    @Test(expected = EmptyUniversityException.class)
    public void getAverageGradeByEducationSubjectInUniversityWithFacultiesInUniversityNull
            () throws EmptyUniversityException {

        University university = new University();
        DeansOffice.getAverageGradeByEducationSubjectInUniversity(university, math);
    }
}