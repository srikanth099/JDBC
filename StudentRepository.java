package org.krishna.advance.studentAPI;

import java.sql.Connection;

import java.util.List;

public interface StudentRepository {
	public Connection getConnectionUtil();
	public String saveStudent(Student student);
	public String updateStudentById(Student student);
	public String deleteStudentById(int id);
	public Student getStudentById(int id);
	public List<Student> getStudentDetails();
}
