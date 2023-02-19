package main.repotisory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.entities.GoodStudent;
import main.entities.NormalStudent;
import main.entities.Student;

public class RepositoryImpl implements IRepository {

	private static String SELLECT_STUDENT_SQL = "select * from Student;";

	Connection connection = null;
	PreparedStatement stmt = null;
	Statement statement;
	ResultSet rs = null;

	public RepositoryImpl() {
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param student
	 * @return boolean
	 * @TODO insert student in database
	 */
	@Override
	public boolean addNew(Student student) {
		try {
			connection = JDBCConnection.getConnection();
			stmt = connection.prepareStatement(SELLECT_STUDENT_SQL, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();
			rs.moveToInsertRow();
			connection.setAutoCommit(false);
			rs.updateString(1, student.getFullName());
			rs.updateString(2, student.getDoB());
			rs.updateString(3, student.getSex());
			rs.updateString(4, student.getPhoneNumber());
			rs.updateString(5, student.getUniversityName());
			rs.updateString(6, student.getGradeLevel());
			if (student instanceof GoodStudent) {
				GoodStudent studentG = (GoodStudent) student;
				rs.updateDouble(7, studentG.getGpa());
				rs.updateString(8, studentG.getBestRewardName());
			} else if (student instanceof NormalStudent) {
				NormalStudent studentN = (NormalStudent) student;
				rs.updateInt(9, studentN.getEnglishScore());
				rs.updateDouble(10, studentN.getEntryTestScore());
			}
			rs.insertRow();
			connection.commit();
			rs.moveToCurrentRow();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
				rs.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @return Student List
	 * @TODO get all student from database
	 */
	@Override
	public List<Student> sellectAll() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		try {
			connection = JDBCConnection.getConnection();
			stmt = connection.prepareStatement(SELLECT_STUDENT_SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(9) == 0) {
					student = new GoodStudent(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getString(8));
					students.add(student);
				} else {
					student = new NormalStudent(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getInt(9), rs.getDouble(10));
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

}
