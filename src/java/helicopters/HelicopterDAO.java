/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopters;

import ConnectSQL.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class HelicopterDAO {

    private static final String GET_ALL = "SELECT * FROM tblHelicopters";
    private static final String SEARCH = "SELECT helicopterID, helicopterName, description, price, image FROM tblHelicopters WHERE helicopterID like ? OR helicopterName like ?";
    private static final String DELETE = "DELETE tblHelicopters WHERE helicopterID = ?";
    private static final String INSERT = "INSERT INTO tblHelicopters(helicopterID, helicopterName, description, price, image) VALUES (?,?,?,?,?)";

    public List<HelicopterDTO> getAllList() {
        List<HelicopterDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(GET_ALL);
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    String helicopterID = rs.getString("helicopterID");
                    String helicopterName = rs.getString("helicopterName");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String imamge = rs.getString("image");
                    list.add(new HelicopterDTO(helicopterID, helicopterName, description, price, imamge));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HelicopterDTO> getHeliByIDandName(String search) {
        List<HelicopterDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, search);
                ptm.setString(2, search);
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    String helicopterID = rs.getString("helicopterID");
                    String helicopterName = rs.getString("helicopterName");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String image = rs.getString("image");
                    list.add(new HelicopterDTO(helicopterID, helicopterName, description, price, image));
                }
                ptm.close();
                rs.close();
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteHelicopter(String HeliID) {
        boolean check = false;
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, HeliID);
                check = ptm.executeUpdate() > 0 ? true : false;
                ptm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean insertHelicopter(HelicopterDTO heli) {
        boolean check = false;
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, heli.getHelicopterID());
                ptm.setString(2, heli.getHelicopterName());
                ptm.setString(3, heli.getDescription());
                ptm.setFloat(4, heli.getPrice());
                ptm.setString(5, heli.getImage());
                check = ptm.executeUpdate() > 0 ? true : false;
                ptm.close();
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
