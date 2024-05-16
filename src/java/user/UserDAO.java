/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
public class UserDAO {

    private static final String LOGIN = "SELECT fullName, roleID FROM tblUser WHERE userID = ? AND password = ?";
    private static final String INSERT = "INSERT INTO tblUser(userID, fullName, password, roleID) VALUES (?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT userID WHERE userID = ?";
    private static final String GET_ALL = "SELECT userID, fullName, password, roleID FROM tblUser";
    private static final String SEARCH = "SELECT userID, fullName, password, roleID FROM tblUser WHERE fullName like ?";
    private static final String DELETE = "DELETE tblUser WHERE userID = ?";
    private static final String UPDATE = "UPDATE tblUser SET fullName = ?, roleID = ? WHERE userID = ? ";

    public UserDTO checkLogin(String userID, String password) {
        UserDTO user = null;
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                ResultSet rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, password, roleID);
                }
                rs.close();
                ptm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean Insert(UserDTO user) {
        boolean check = false;
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getRoleID());
                check = ptm.executeUpdate() > 0 ? true : false;
                conn.close();
                ptm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean checkDuplicate(String userID) {
        boolean check = false;
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                ResultSet rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<UserDTO> getAllUser() {
        List<UserDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(GET_ALL);
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    list.add(new user.UserDTO(userID, fullName, "***", roleID));

                }
                ptm.close();
                conn.close();
                rs.close();
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<UserDTO> searchUser(String search) {
        List<UserDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                ResultSet rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    list.add(new UserDTO(userID, fullName, "***", roleID));
                }
                ptm.close();
                rs.close();
            }
            conn.close();
        } catch (Exception e) {

        }
        return list;
    }

    public boolean deleteUser(String userID) {
        boolean check = false;
        try {
            Connection conn = DBUtils.getConnection();
            if (conn != null) {
                PreparedStatement ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
                ptm.close();
                conn.close();
            }
        } catch (Exception e) {

        }
        return check;
    }
    
    public boolean updateUser(UserDTO user){
        boolean check = false;
        try{
            Connection conn = DBUtils.getConnection();
            if(conn != null){
                PreparedStatement ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getUserID());
                check = ptm.executeUpdate() > 0 ? true:false;
                ptm.close();
            }
            conn.close();
        }catch (Exception e){
            
        }
        return check;
    }
}
