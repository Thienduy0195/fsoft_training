package main.repositoris;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.entities.Beneficiary;
import main.entities.Diasease;
import main.entities.Disaster;
import main.entities.Indigent;

public class RepoImpl implements IRepo {

	PreparedStatement stmt = null;
	ResultSet resultSet = null;
	Connection con = null;

	private static String SELLECT_ALL_SQL = "select * from Beneficiary;";
	private static String SELLECT_TO_UPDATE_SQL = "select * from Beneficiary b where b.address in (select address from Beneficiary where datediff(year, birthdate, getdate())<16) and benefitDate > getdate();";
	private static String UPDATE_BY_ID_SQL = "update Beneficiary set benefitDate = dateadd(day,?,benefitDate) where id = ?;";
	private static String DELETE_SQL = "delete from Beneficiary where address is null or phone is null;";

	public RepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addNew(Beneficiary beneficiary) {
		try {
			stmt = ConnectionJDBC.getConnection().prepareStatement(
					"select " + beneficiary.getAttribute() + " from Beneficiary;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = stmt.executeQuery();
			resultSet.moveToInsertRow();
			if (beneficiary instanceof Diasease) {
				Diasease l = (Diasease) beneficiary;
				resultSet.updateInt(1, l.getTypeId());
				resultSet.updateString(2, l.getId());
				resultSet.updateString(3, l.getName());
				resultSet.updateString(4, l.getBirthdate());
				resultSet.updateString(5, l.getAddress());
				resultSet.updateString(6, l.getPhone());
				resultSet.updateString(7, l.getBenefitDate());
				resultSet.updateInt(8, l.getBenefit());
				resultSet.updateString(9, l.getIllness());
				resultSet.updateString(10, l.getSickDate());
			} else if (beneficiary instanceof Disaster) {
				Disaster l = (Disaster) beneficiary;
				resultSet.updateInt(1, l.getTypeId());
				resultSet.updateString(2, l.getId());
				resultSet.updateString(3, l.getName());
				resultSet.updateString(4, l.getBirthdate());
				resultSet.updateString(5, l.getAddress());
				resultSet.updateString(6, l.getPhone());
				resultSet.updateString(7, l.getBenefitDate());
				resultSet.updateInt(8, l.getBenefit());
				resultSet.updateString(9, l.getDisasterType());
				resultSet.updateString(10, l.getImpactDate());
				resultSet.updateInt(11, l.getTotalDamage());
			} else {
				Indigent l = (Indigent) beneficiary;
				resultSet.updateInt(1, l.getTypeId());
				resultSet.updateString(2, l.getId());
				resultSet.updateString(3, l.getName());
				resultSet.updateString(4, l.getBirthdate());
				resultSet.updateString(5, l.getAddress());
				resultSet.updateString(6, l.getPhone());
				resultSet.updateString(7, l.getBenefitDate());
				resultSet.updateInt(8, l.getBenefit());
				resultSet.updateInt(9, l.getIncome());
				resultSet.updateInt(10, l.getDependantAmount());
			}
			resultSet.insertRow();
			resultSet.moveToCurrentRow();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean checkDuplicateId(String id) {
		try {
			stmt = ConnectionJDBC.getConnection().prepareStatement("select id from Beneficiary where id = ?;");
			stmt.setString(1, id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Beneficiary> selectAll() {
		List<Beneficiary> beneficiaries = new ArrayList<>();
		try {
			con = ConnectionJDBC.getConnection();
			stmt = con.prepareStatement(SELLECT_ALL_SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				if (resultSet.getInt(1) == 1) {
					Diasease beneficiary = new Diasease();
					beneficiary.setTypeId(resultSet.getInt(1));
					beneficiary.setId(resultSet.getString(2));
					beneficiary.setName(resultSet.getString(3));
					beneficiary.setBirthdate(resultSet.getString(4));
					beneficiary.setAddress(resultSet.getString(5));
					beneficiary.setPhone(resultSet.getString(6));
					beneficiary.setBenefitDate(resultSet.getString(7));
					beneficiary.setBenefit(resultSet.getInt(8));
					beneficiary.setIllness(resultSet.getString(9));
					beneficiary.setSickDate(resultSet.getString(10));
					beneficiaries.add(beneficiary);
				} else if (resultSet.getInt(1) == 2) {
					Disaster beneficiary = new Disaster();
					beneficiary.setTypeId(resultSet.getInt(1));
					beneficiary.setId(resultSet.getString(2));
					beneficiary.setName(resultSet.getString(3));
					beneficiary.setBirthdate(resultSet.getString(4));
					beneficiary.setAddress(resultSet.getString(5));
					beneficiary.setPhone(resultSet.getString(6));
					beneficiary.setBenefitDate(resultSet.getString(7));
					beneficiary.setBenefit(resultSet.getInt(8));
					beneficiary.setDisasterType(resultSet.getString(11));
					beneficiary.setImpactDate(resultSet.getString(12));
					beneficiary.setTotalDamage(resultSet.getInt(13));
					beneficiaries.add(beneficiary);
				} else if (resultSet.getInt(1) == 3) {
					Indigent beneficiary = new Indigent();
					beneficiary.setTypeId(resultSet.getInt(1));
					beneficiary.setId(resultSet.getString(2));
					beneficiary.setName(resultSet.getString(3));
					beneficiary.setBirthdate(resultSet.getString(4));
					beneficiary.setAddress(resultSet.getString(5));
					beneficiary.setPhone(resultSet.getString(6));
					beneficiary.setBenefitDate(resultSet.getString(7));
					beneficiary.setBenefit(resultSet.getInt(8));
					beneficiary.setIncome(resultSet.getInt(14));
					beneficiary.setDependantAmount(resultSet.getInt(15));
					beneficiaries.add(beneficiary);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				con.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return beneficiaries;
	}

	@Override
	public boolean update(String id, Integer day) {
		boolean checkUpdate = false;
		try {
			con = ConnectionJDBC.getConnection();
			stmt = con.prepareStatement(UPDATE_BY_ID_SQL);
			stmt.setInt(1, day);
			stmt.setString(2, id);
			checkUpdate = stmt.executeUpdate() > 0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkUpdate;
	}

	@Override
	public List<Beneficiary> selectToUpdate() {
		List<Beneficiary> beneficiaries = new ArrayList<>();
		try {
			con = ConnectionJDBC.getConnection();
			stmt = con.prepareStatement(SELLECT_TO_UPDATE_SQL, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt(1) == 1) {
					Diasease beneficiary = new Diasease();
					beneficiary.setTypeId(resultSet.getInt(1));
					beneficiary.setId(resultSet.getString(2));
					beneficiary.setName(resultSet.getString(3));
					beneficiary.setBirthdate(resultSet.getString(4));
					beneficiary.setAddress(resultSet.getString(5));
					beneficiary.setPhone(resultSet.getString(6));
					beneficiary.setBenefitDate(resultSet.getString(7));
					beneficiary.setBenefit(resultSet.getInt(8));
					beneficiary.setIllness(resultSet.getString(9));
					beneficiary.setSickDate(resultSet.getString(10));
					beneficiaries.add(beneficiary);
				} else if (resultSet.getInt(1) == 2) {
					Disaster beneficiary = new Disaster();
					beneficiary.setTypeId(resultSet.getInt(1));
					beneficiary.setId(resultSet.getString(2));
					beneficiary.setName(resultSet.getString(3));
					beneficiary.setBirthdate(resultSet.getString(4));
					beneficiary.setAddress(resultSet.getString(5));
					beneficiary.setPhone(resultSet.getString(6));
					beneficiary.setBenefitDate(resultSet.getString(7));
					beneficiary.setBenefit(resultSet.getInt(8));
					beneficiary.setDisasterType(resultSet.getString(11));
					beneficiary.setImpactDate(resultSet.getString(12));
					beneficiary.setTotalDamage(resultSet.getInt(13));
					beneficiaries.add(beneficiary);
				} else if (resultSet.getInt(1) == 3) {
					Indigent beneficiary = new Indigent();
					beneficiary.setTypeId(resultSet.getInt(1));
					beneficiary.setId(resultSet.getString(2));
					beneficiary.setName(resultSet.getString(3));
					beneficiary.setBirthdate(resultSet.getString(4));
					beneficiary.setAddress(resultSet.getString(5));
					beneficiary.setPhone(resultSet.getString(6));
					beneficiary.setBenefitDate(resultSet.getString(7));
					beneficiary.setBenefit(resultSet.getInt(8));
					beneficiary.setIncome(resultSet.getInt(14));
					beneficiary.setDependantAmount(resultSet.getInt(15));
					beneficiaries.add(beneficiary);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				con.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return beneficiaries;
	}

	@Override
	public List<Beneficiary> delete() {
		try {
			con = ConnectionJDBC.getConnection();
			stmt = con.prepareStatement(DELETE_SQL);
			stmt.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		List<Beneficiary> beneficiaries = selectToUpdate();
		return beneficiaries;
	}

}
