/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.universitystructure;

import com.epam.melnik.java.exception.entity.person.ExternalStudent;
import com.epam.melnik.java.exception.entity.person.FullTimeStudent;
import com.epam.melnik.java.exception.entity.person.Student;
import com.epam.melnik.java.exception.entity.subject.EducationSubject;
import com.epam.melnik.java.exception.studentexception.logic.GradeLessMinException;
import com.epam.melnik.java.exception.studentexception.logic.GradeMoreMaxException;
import com.epam.melnik.java.exception.studentexception.technik.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.DoubleStream;

/**
 * Class make some functional(as
 *
 * @see University
 * @see Faculty
 * @see StudentGroup
 * @see Student
 * @see ExternalStudent
 * @see FullTimeStudent
 */
public class DeansOffice {

    public static final int MIN_GRADE = 0;
    public static final int MAX_GRADE = 10;

    private static final String EMPTY_STUDENT_LINK_MESSAGE = "Student is Null";
    private static final String EMPTY_EDUCATION_SUBJECT_LINK_MESSAGE = "EducationSubject is Null";
    private static final String EMPTY_AVERAGE_GRADE_LINK_MESSAGE = "AverageGrade is Null";
    private static final String EMPTY_GROUP_LINK_MESSAGE = "StudentGroup is Null";
    private static final String EMPTY_FACULTY_LINK_MESSAGE = "Faculty is Null";
    private static final String EMPTY_UNIVERSITY_LINK_MESSAGE = "University is Null";

    /**
     * Method searches average grade by all education subjects for one student
     *
     * @param student
     * @return double
     * @throws IllegalArgumentException         if @param student is null
     * @throws StudentHasNotAnySubjectException if @param student doesn't contain
     *                                          Map<String, Double> educationSubjectAverageGrades
     */
    public static double getAverageGradeByAllStudentEducationSubject(Student student)
            throws IllegalArgumentException, StudentHasNotAnySubjectException {

        double studentAverageGradeByAllSubject = 0;
        if (student != null) {
            Map<String, Double> studentAverageGrades =
                    student.getEducationSubjectAverageGrades();

            if (studentAverageGrades != null && studentAverageGrades.size() > 0) {

                studentAverageGradeByAllSubject =
                        studentAverageGrades
                                .values()
                                .stream()
                                .filter(Objects::nonNull)
                                .flatMapToDouble(DoubleStream::of)
                                .average().getAsDouble();
            } else {
                throw new StudentHasNotAnySubjectException();
            }
        } else {
            throw new IllegalArgumentException(EMPTY_STUDENT_LINK_MESSAGE);
        }

        return studentAverageGradeByAllSubject;
    }

    /**
     * Method searches average grade by given education subject in group for all students
     *
     * @param studentGroup
     * @param educationSubject
     * @return double
     * @throws IllegalArgumentException              if @param studentGroup or @param educationSubject is null
     * @throws EducationSubjectNameIsAbsentException if @param educationSubject doesn't have name or empty
     * @throws EmptyStudentGroupException            if @param studentGroup doesn't have any Student
     */
    public static double getAverageGradeByEducationSubjectInGroup(StudentGroup studentGroup,
                                                                  EducationSubject educationSubject)
            throws IllegalArgumentException, EducationSubjectNameIsAbsentException, EmptyStudentGroupException {

        double averageGradeByEducationSubjectInGroup = 0;
        if (studentGroup != null) {
            if (educationSubject != null) {
                String educationSubjectName = educationSubject.getSubjectName();
                if (educationSubjectName != null && !educationSubjectName.isEmpty()) {
                    List<Student> studentsInGroup = studentGroup.getGroupStudents();
                    if (studentsInGroup != null && !studentsInGroup.isEmpty()) {
                        averageGradeByEducationSubjectInGroup =
                                studentsInGroup.stream()
                                        .filter(student -> student != null
                                                && student.getEducationSubjectAverageGrades() != null
                                                && student.getEducationSubjectAverageGrades()
                                                .containsKey(educationSubjectName))
                                        .mapToDouble(student -> student
                                                .getEducationSubjectAverageGrades()
                                                .get(educationSubject.getSubjectName()))
                                        .average().getAsDouble();
                    } else {
                        throw new EmptyStudentGroupException();
                    }
                } else {
                    throw new EducationSubjectNameIsAbsentException();
                }
            } else {
                throw new IllegalArgumentException(EMPTY_EDUCATION_SUBJECT_LINK_MESSAGE);
            }
        } else {
            throw new IllegalArgumentException(EMPTY_GROUP_LINK_MESSAGE);
        }

        return averageGradeByEducationSubjectInGroup;
    }

    /**
     * Method searches average grade by given education subject on faculty for all students
     *
     * @param faculty
     * @param educationSubject
     * @return double
     * @throws EducationSubjectNameIsAbsentException if @param educationSubject doesn't have name or empty
     * @throws EmptyFacultyException                 if @param faculty doesn't have any StudentGroup
     * @throws IllegalArgumentException              if @param faculty or @param educationSubject is null
     */
    public static double getAverageGradeByEducationSubjectOnFaculty(Faculty faculty,
                                                                    EducationSubject educationSubject)
            throws EmptyFacultyException, IllegalArgumentException, EducationSubjectNameIsAbsentException {

        double averageGradeByEducationSubjectOnFaculty = 0;
        if (faculty != null) {
            List<StudentGroup> groupsOnFaculty = faculty.getStudentGroups();
            if (groupsOnFaculty != null && !groupsOnFaculty.isEmpty()) {
                averageGradeByEducationSubjectOnFaculty = groupsOnFaculty.stream()
                        .mapToDouble(group -> {
                            double averageGradeByEducationSubjectInGroup = 0;
                            try {
                                averageGradeByEducationSubjectInGroup
                                        = getAverageGradeByEducationSubjectInGroup(group, educationSubject);
                            } catch (EmptyStudentGroupException e) {
                                e.printStackTrace();
                            }
                            return averageGradeByEducationSubjectInGroup;
                        })
                        .average().getAsDouble();
            } else {
                throw new EmptyFacultyException();
            }
        } else {
            throw new IllegalArgumentException(EMPTY_FACULTY_LINK_MESSAGE);
        }

        return averageGradeByEducationSubjectOnFaculty;
    }

    /**
     * Method searches average grade by given education subject in university for all students
     *
     * @param university
     * @param educationSubject
     * @return double
     * @throws EmptyUniversityException              if @param university doesn't have any Faculty
     * @throws IllegalArgumentException              if @param university or @param educationSubject is null
     * @throws EducationSubjectNameIsAbsentException if @param educationSubject doesn't have name or empty
     */
    public static double getAverageGradeByEducationSubjectInUniversity(University university,
                                                                       EducationSubject educationSubject)
            throws EmptyUniversityException, IllegalArgumentException, EducationSubjectNameIsAbsentException {

        double averageGradeByEducationSubjectInUniversity = 0;

        if (university != null) {
            List<Faculty> facultiesInUniversity = university.getFaculties();
            if (facultiesInUniversity != null && !facultiesInUniversity.isEmpty()) {
                averageGradeByEducationSubjectInUniversity = facultiesInUniversity.stream()
                        .mapToDouble(faculty -> {
                            double averageGradeByEducationSubjectOnFaculty = 0;
                            try {
                                averageGradeByEducationSubjectOnFaculty =
                                        getAverageGradeByEducationSubjectOnFaculty(faculty, educationSubject);
                            } catch (EmptyFacultyException e) {
                                e.printStackTrace();
                            }
                            return averageGradeByEducationSubjectOnFaculty;
                        })
                        .average().getAsDouble();
            } else {
                throw new EmptyUniversityException();
            }
        } else {
            throw new IllegalArgumentException(EMPTY_UNIVERSITY_LINK_MESSAGE);
        }

        return averageGradeByEducationSubjectInUniversity;
    }

    /**
     * Method adds average grade for student by given education subject
     *
     * @param student
     * @param educationSubject
     * @param averageGrade
     * @throws IllegalArgumentException              if @param student or @param educationSubject
     *                                               or @param averageGrade is null
     * @throws EducationSubjectNameIsAbsentException if @param educationSubject doesn't have name or empty
     * @throws GradeLessMinException                 if @param averageGrade has value less minimum value
     * @throws GradeMoreMaxException                 if @param averageGrade has value more maximum value
     */
    public static void addAverageGradeForEducationSubject(Student student,
                                                          EducationSubject educationSubject,
                                                          Double averageGrade)
            throws IllegalArgumentException,
            EducationSubjectNameIsAbsentException,
            GradeLessMinException, GradeMoreMaxException {

        if (student != null) {
            if (educationSubject != null) {
                if (averageGrade != null) {
                    String educationSubjectName = educationSubject.getSubjectName();
                    if (educationSubjectName != null && !educationSubjectName.isEmpty()) {
                        if (averageGrade >= MIN_GRADE && averageGrade <= MAX_GRADE) {
                            Map<String, Double> studentGrades = student.getEducationSubjectAverageGrades();
                            if (studentGrades == null) {
                                studentGrades = new HashMap<>();
                            }
                            studentGrades.put(educationSubjectName, averageGrade);
                            student.setEducationSubjectAverageGrades(studentGrades);
                        } else if (averageGrade < MIN_GRADE) {
                            throw new GradeLessMinException();
                        } else {
                            throw new GradeMoreMaxException();
                        }
                    } else {
                        throw new EducationSubjectNameIsAbsentException();
                    }
                } else {
                    throw new IllegalArgumentException(EMPTY_AVERAGE_GRADE_LINK_MESSAGE);
                }
            } else {
                throw new IllegalArgumentException(EMPTY_EDUCATION_SUBJECT_LINK_MESSAGE);
            }
        } else {
            throw new IllegalArgumentException(EMPTY_STUDENT_LINK_MESSAGE);
        }
    }
}
