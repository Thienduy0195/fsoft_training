package General_Assignment_BTJB_opt1_Day2.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import General_Assignment_BTJB_opt1_Day2.models.Certificated;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class CertificateRepo implements ICertificateRepo {

	private static final String INSERT_CERTIFICATE = "select * from Certificate;";
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public CertificateRepo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param certificate Add new Certificate
	 */
	@Override
	public void saveCertificate(Certificated certificate) {
		try {
			stmt = BaseRepository.getConnection().prepareStatement(INSERT_CERTIFICATE, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();
			rs.moveToInsertRow();
			rs.updateString(2, certificate.getCertificatedName());
			rs.updateString(3, certificate.getCertificatedRank());
			rs.updateString(4, certificate.getCertificatedDate());
			rs.updateInt(5, certificate.getCandidateId());
			rs.insertRow();
			rs.moveToCurrentRow();
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

}
