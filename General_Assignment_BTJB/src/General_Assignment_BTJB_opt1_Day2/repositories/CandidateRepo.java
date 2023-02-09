package General_Assignment_BTJB_opt1_Day2.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import General_Assignment_BTJB_opt1_Day2.models.Candidate;
import General_Assignment_BTJB_opt1_Day2.models.CandidateDTO;
import General_Assignment_BTJB_opt1_Day2.models.ExperienceCandidate;
import General_Assignment_BTJB_opt1_Day2.models.FresherCandidate;
import General_Assignment_BTJB_opt1_Day2.models.InternCandidate;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class CandidateRepo implements ICandidateRepo {

	private static String SELLECT_CANDIDATE_SQL = "select CandidateId,FullName,BirthDate,Phone,"
			+ "Email,ExpInYear,ProSkill,GraduationDate,GraduationRank,Education,Majors,"
			+ "Semester,UniversityName,CandidateTypeId from Candidate";
	private static String FIND_CANDIDATE_BY_ID = "select CandidateId,FullName,BirthDate,Phone,"
			+ "Email,ExpInYear,ProSkill,GraduationDate,GraduationRank,Education,Majors,"
			+ "Semester,UniversityName,CandidateTypeId from Candidate where CandidateId=?";
	private static String SELLECT_CANDIDATE_NAME_SQL = "select FullName from Candidate";
	private static String SELLECT_LAX_CANDIDATE_ID = "select max(CandidateId) from Candidate;";
//	private static final String INSERT_CANDIDATE = "insert into Candidate (FullName,BirthDate,Phone,Email,ExpInYear,ProSkill,GraduationDate,GraduationRank,Education,Majors,Semester,UniversityName,CandidateTypeId) values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
	PreparedStatement stmt = null;
	ResultSet rs = null;

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @return Candidate list Get all candidate from database
	 */
	@Override
	public List<Candidate> sellectAllCandidate() {
		List<Candidate> candidates = new ArrayList<>();
		Candidate candidate = null;
		try {
			stmt = BaseRepository.getConnection().prepareStatement(SELLECT_CANDIDATE_SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(14) == 1) {
					candidate = new ExperienceCandidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(14), rs.getInt(6), rs.getString(7));
					candidates.add(candidate);
				} else if (rs.getInt(14) == 2) {
					candidate = new FresherCandidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(14), rs.getString(8), rs.getString(9), rs.getString(10));
					candidates.add(candidate);
				} else {
					candidate = new InternCandidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(14), rs.getString(11), rs.getString(12), rs.getString(13));
					candidates.add(candidate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidates;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param CandidateDTO Insert candidate info into database by Candidate DTO
	 */
	@Override
	public void insertCandidate(CandidateDTO candidate) {
		try {
			stmt = BaseRepository.getConnection().prepareStatement(SELLECT_CANDIDATE_SQL,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = stmt.executeQuery();
			resultSet.moveToInsertRow();
			resultSet.updateString(2, candidate.getFullName());
			resultSet.updateString(3, candidate.getBirthDate());
			resultSet.updateString(4, candidate.getPhone());
			resultSet.updateString(5, candidate.getEmail());
			resultSet.updateInt(6, candidate.getExpInYear());
			resultSet.updateString(7, candidate.getProSkill());
			resultSet.updateString(8, candidate.getGraduationDate());
			resultSet.updateString(9, candidate.getGraduationRank());
			resultSet.updateString(10, candidate.getEducation());
			resultSet.updateString(11, candidate.getMajors());
			resultSet.updateString(12, candidate.getSemester());
			resultSet.updateString(13, candidate.getUniversityName());
			resultSet.updateInt(14, candidate.getCandidateTypeId());
			resultSet.insertRow();
			resultSet.moveToCurrentRow();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @return All CandidateFullName Get all candidate full name from database
	 */
	@Override
	public StringBuffer sellectAllCandidateName() {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			stmt = BaseRepository.getConnection().prepareStatement(SELLECT_CANDIDATE_NAME_SQL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				stringBuffer.append(rs.getString(1) + ",");
			}
			stringBuffer.deleteCharAt(stringBuffer.length() - 1);
			System.out.println(stringBuffer);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return stringBuffer;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @param attribute
	 * @param value     Update candidate on each attribute base on candidate id
	 */
	@Override
	public void updateCandidate(Integer id, String attribute, String value) {

		try {
			Connection connection = BaseRepository.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery(SELLECT_CANDIDATE_SQL);
			while (resultSet.next()) {
				if (resultSet.getInt("CandidateId") == id) {
					if (attribute.equals("ExpInYear")) {
						resultSet.updateInt(attribute, Integer.parseInt(value));
					} else {
						resultSet.updateString(attribute, value);
					}
					resultSet.updateRow();
				}
			}
		} catch (Exception e) {
			System.out.println("Error at updateCandidate in CandidateRepo");
			e.printStackTrace();
		}
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @return CandidateId Get candidate id for method add new Certificate
	 *         referrences to candidate by candidate id
	 */
	@Override
	public Integer getLastCandidateId() {
		try {
			stmt = BaseRepository.getConnection().prepareStatement(SELLECT_LAX_CANDIDATE_ID);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @return Get candidate info by candidate id
	 */
	@Override
	public Candidate findCandidateById(Integer id) {
		Candidate candidate = null;
		try {
			stmt = BaseRepository.getConnection().prepareStatement(FIND_CANDIDATE_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(14) == 1) {
					candidate = new ExperienceCandidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(14), rs.getInt(6), rs.getString(7));

				} else if (rs.getInt(14) == 2) {
					candidate = new FresherCandidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(14), rs.getString(8), rs.getString(9), rs.getString(10));
				} else {
					candidate = new InternCandidate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(14), rs.getString(11), rs.getString(12), rs.getString(13));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidate;
	}

}
