package main.repotisory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.entities.ForeignPhone;
import main.entities.HomePhone;
import main.entities.OldPhone;
import main.entities.Phone;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class RepositoryImpl implements IRepository {

	private static String SELLECT_PHONE_SQL = "select * from Phone;";
	private static String SEARCH_PHONE_BASEON_PRICE = "select * from Phone where price > ? and price < ?;";

	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet resultSet = null;

	public RepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param object
	 * @return boolean
	 * @TODO add new phone record into database
	 */
	@Override
	public boolean addNew(Phone phone) {
		try {
			connection = JDBCConnection.getConnection();
			stmt = connection.prepareStatement(SELLECT_PHONE_SQL, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			resultSet = stmt.executeQuery();
			resultSet.moveToInsertRow();
			connection.setAutoCommit(false);
			resultSet.updateString(1, phone.getId());
			resultSet.updateString(2, phone.getName());
			resultSet.updateDouble(3, phone.getScreenSize());
			resultSet.updateString(4, phone.getChipset());
			resultSet.updateInt(5, phone.getRam());
			resultSet.updateInt(6, phone.getStorage());
			resultSet.updateDouble(7, phone.getPrice());
			resultSet.updateString(8, phone.getManufacture());
			if (phone instanceof HomePhone) {
				HomePhone hPhone = (HomePhone) phone;
				resultSet.updateInt(9, hPhone.getWarranty());
				resultSet.updateInt(10, hPhone.getRange());
			} else if (phone instanceof ForeignPhone) {
				ForeignPhone fPhone = (ForeignPhone) phone;
				resultSet.updateString(11, fPhone.getCountry());
				resultSet.updateDouble(14, fPhone.getPriceWarranty());
			} else if (phone instanceof OldPhone) {
				OldPhone oPhone = (OldPhone) phone;
				resultSet.updateInt(12, oPhone.getStatus());
				resultSet.updateInt(13, oPhone.getBodyStatus());
				resultSet.updateDouble(14, oPhone.getPriceWarranty());
			}
			resultSet.insertRow();
			connection.commit();
			resultSet.moveToCurrentRow();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @return boolean
	 * @TODO check if stoven is existed
	 */
	@Override
	public boolean checkDuplicateId(String id) {
		try {
			connection = JDBCConnection.getConnection();
			stmt = connection.prepareStatement("select id  from Phone where id = ?");
			stmt.setString(1, id);
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @return boolean
	 * @TODO delete phone
	 */
	@Override
	public boolean delete(String id) {
		try {
			connection = JDBCConnection.getConnection();
			stmt = connection.prepareStatement("delete from Phone where id=?;");
			stmt.setString(1, id);
			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param name
	 * @return
	 * @TODO search object from database base on name
	 */
	@Override
	public List<Phone> search(Double min, Double max) {
		List<Phone> phones = new ArrayList<>();
		try {
			connection = JDBCConnection.getConnection();
			stmt = connection.prepareStatement(SEARCH_PHONE_BASEON_PRICE);
			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			resultSet = stmt.executeQuery();
			Phone phone;
			while (resultSet.next()) {
				if (resultSet.getString(1).startsWith("CH")) {
					phone = new HomePhone(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
							resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getDouble(7),
							resultSet.getString(8), resultSet.getInt(9), resultSet.getInt(10));
					phones.add(phone);
				} else if (resultSet.getString(1).startsWith("XT")) {
					phone = new ForeignPhone(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
							resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getDouble(7),
							resultSet.getString(8), resultSet.getString(11), resultSet.getDouble(14));
					phones.add(phone);
				} else if (resultSet.getString(1).startsWith("OD")) {
					phone = new OldPhone(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
							resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getDouble(7),
							resultSet.getString(8), resultSet.getInt(12), resultSet.getInt(13),
							resultSet.getDouble(14));
					phones.add(phone);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phones;
	}

}
