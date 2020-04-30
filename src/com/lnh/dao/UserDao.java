package com.lnh.dao;

import com.lnh.model.User;
import com.lnh.util.DBUtil;

import java.sql.*;

/**
 * @author 70888
 */
public class UserDao {
    public static Connection con=null;
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    public static boolean checkLogin(String username,String password){
        con= DBUtil.getConnection();
        String sql="select * from user where username=?";
        User user = null;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            rs=ps.executeQuery();
            if (rs.next()) {
                String pwd = rs.getString("password");
                if (pwd.equals(password)) {
                    user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setPhone(rs.getString("phone"));
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ps = null;
            }
        }
        return false;
    }
    public static void registe(String username,String password){
        con=DBUtil.getConnection();
        String sql="insert into user values (null,?,?,null)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
        int b=ps.executeUpdate();
        if(b>0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
                rs = null;
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
                ps = null;
            }
        }
    }

    public User getUserById(Long id) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("查询用户信息失败。");
            e.printStackTrace();
        } finally {
            DBUtil.release(rs, stmt, conn);
        }
        return user;
    }

    public boolean updateUser(User user) {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE user SET username = ?, password = ?, phone = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getPhone());
            stmt.setLong(4, user.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("查询用户信息失败。");
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.release(null, stmt, conn);
        }
        return true;
    }
}

