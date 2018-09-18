package cs544.sh2;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {
	@Autowired
	private StudentDao studentdao;
//	private static SessionFactory sf = HibernateUtil.getSessionFactory();


	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

	@Transactional
	public Student getStudent(long studentid) {
		//Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.findById(studentid).orElse(new Student());
		//Hibernate.initialize(student.getCourselist());
		//tx.commit();
		return student;
	}
}
