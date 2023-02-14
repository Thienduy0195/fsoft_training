package product_management.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product_management.entities.Laptop;
import product_management.entities.LaptopMacbook;
import product_management.entities.LaptopWindows;

public class RepoImpl implements IRepo {

	PreparedStatement stmt = null;
	ResultSet rs = null;

	private static String SELLECT_LAPTOP_SQL = "select * from Laptop;";
	private static String UPDATE_PRICE_SQL = "update Laptop set price = price * (1-?) where brand = ?;";
	private static String DELETE_SQL = "delete from Laptop where brand='Dell' and SUBSTRING(ram,1,1) < 8;";

	public RepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addNew(Laptop laptop) {
		try {
			stmt = ConnectionJDBC.getConnection().prepareStatement(
					"select " + laptop.getAttributeName() + " from Laptop;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = stmt.executeQuery();
			resultSet.moveToInsertRow();
			if (laptop instanceof LaptopWindows) {
				LaptopWindows l = (LaptopWindows) laptop;
				resultSet.updateInt(1, l.getTypeId());
				resultSet.updateString(2, l.getLaptopId());
				resultSet.updateString(3, l.getName());
				resultSet.updateString(4, l.getBrand());
				resultSet.updateString(5, l.getRam());
				resultSet.updateString(6, l.getSsd());
				resultSet.updateString(7, l.getResolution());
				resultSet.updateString(8, l.getCpu());
				resultSet.updateString(9, l.getImportDate());
				resultSet.updateInt(10, l.getPrice());
				resultSet.updateString(11, l.getTouchScreen());
				resultSet.updateString(12, l.getNumpad());
			} else {
				LaptopMacbook l = (LaptopMacbook) laptop;
				resultSet.updateInt(1, l.getTypeId());
				resultSet.updateString(2, l.getLaptopId());
				resultSet.updateString(3, l.getName());
				resultSet.updateString(4, l.getBrand());
				resultSet.updateString(5, l.getRam());
				resultSet.updateString(6, l.getSsd());
				resultSet.updateString(7, l.getResolution());
				resultSet.updateString(8, l.getCpu());
				resultSet.updateString(9, l.getImportDate());
				resultSet.updateInt(10, l.getPrice());
				resultSet.updateString(11, l.getMacType());
				resultSet.updateString(12, l.getCpuType());
				resultSet.updateString(13, l.getMacTypeCharge());
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
			stmt = ConnectionJDBC.getConnection().prepareStatement("select laptopId from Laptop where laptopId = ?");
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
	public List<Laptop> sellectAll() {
		List<Laptop> laptops = new ArrayList<>();
		Laptop laptop = null;
		try {
			stmt = ConnectionJDBC.getConnection().prepareStatement(SELLECT_LAPTOP_SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					laptop = new LaptopWindows(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getInt(10), rs.getString(11), rs.getString(12));
					laptops.add(laptop);
				} else if (rs.getInt(1) == 2) {
					laptop = new LaptopMacbook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getInt(10), rs.getString(13), rs.getString(14), rs.getString(15));
					laptops.add(laptop);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return laptops;
	}

	@Override
	public boolean updatePrice(Double discount, String brand) {
		boolean updateRow;
		try {
			stmt = ConnectionJDBC.getConnection().prepareStatement(UPDATE_PRICE_SQL);
			stmt.setDouble(1, discount);
			stmt.setString(2, brand);
			updateRow = stmt.executeUpdate() > 0;
			return updateRow;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete() {
		boolean updateRow;
		try {
			stmt = ConnectionJDBC.getConnection().prepareStatement(DELETE_SQL);
			updateRow = stmt.executeUpdate() > 0;
			return updateRow;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
