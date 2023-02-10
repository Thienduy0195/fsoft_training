package product_management.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import product_management.entities.Laptop;
import product_management.entities.LaptopMacbook;
import product_management.entities.LaptopWindows;

public class RepoImpl implements IRepo {

	PreparedStatement stmt = null;
	ResultSet rs = null;

//	private static String SELLECT_LAPTOP_SQL = "select * from Laptop;";

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

}
