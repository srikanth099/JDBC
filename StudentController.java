package org.krishna.advance.studentAPI;

public class StudentController {

	public static void main(String[] args) {
		StudentRepository repository =new StudentRepositoryImp();
//		Connection connection =repository.getConnectionUtil();
//		if(connection!=null) {
//			System.out.println("working");
//		} else {
//			System.out.println("something went wrong");
//		}
		Student student=new Student();
       	student.setId(1);
		student.setName("Manasa");
		student.setCourse("J2EE");
     	student.setEmail("manasa@gmail.com");
//		System.out.println(repository.getStudentById(1));
//		System.out.println(repository.deleteStudentById(1));
     	System.out.println(repository.getStudentDetails());
	}

}
