package com.example.cryptowave.utils.practice

fun main() {
    val studentOne = Student(
        name = "sai kumar",
        id = "23C91A66H9",
        course = Course.BTech
    )
    println("before adding attendance sai kumar has ${studentOne.attendancePercentage}% of course ${studentOne.course.name}")
    val staffOne = Staff(
        name = "Sai",
        id = "H9",
        type = StaffType.TeachingStaff
    )
    staffOne.markStudentAttendance(studentOne)
    staffOne.markStudentAttendance(studentOne)

    println("after adding attendance sai kumar has ${studentOne.attendancePercentage}%")

}

class Student(
    override val name: String,
    val id: String,
    var attendancePercentage: Int = 0,
    val course: Course
) : Person(
    name
) {
    fun markAttendance() {
        attendancePercentage++
    }

    fun introduceYourSelf() {
        println("Hello my name is $name am pursuing $course and I have attendance $attendancePercentage%")
    }

}

open class Person(
    open val name: String
)

open class Staff(
    val name: String,
    val id: String,
    val type: StaffType
) {
    fun markStudentAttendance(student: Student) {
        student.markAttendance()
    }
}

sealed class StaffType() {
    data object NonTeachingStaff: StaffType()
    data object TeachingStaff: StaffType()
}

sealed class Course(val name: String) {
    data object BTech: Course("B.Tech")
    data object BPharmacy: Course("B.Pharmacy")
}