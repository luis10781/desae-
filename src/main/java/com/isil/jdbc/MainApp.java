package com.isil.jdbc;

import javax.print.attribute.ResolutionSyntax;
import javax.xml.transform.Result;
import java.sql.*;

public class MainApp {
    public static void main (String[] args  )throws Exception
    {
        String jdbcUrl= "jdbc:mysql://localhost:3306/desa1";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(jdbcUrl, "root", "Luis107878781");

        Statement st = con.createStatement();

         // int filasAfectadas = st.executeUpdate("insert into Users values(5,'Juan','984444459', 'Vancouver')");

        //int filasAfectadas = st.executeUpdate("update Users set name='Christian' where name = 'Cueva'");

        //int filasAfectadas = st.executeUpdate("delete from Users where idUser=4");
        //System.out.println("Filas afectadas: " + filasAfectadas);


        PreparedStatement preparedStatement = con.prepareStatement("insert into Users values(?,?,?,?)");
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"Marta");
        preparedStatement.setString(3,"98782912");
        preparedStatement.setString(4,"Bogota");
        int filasAfectadas = preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);


        PreparedStatement preparedStatement2 = con.prepareStatement("select * FROM Users WHERE idUser=?");
        preparedStatement2.setInt(1,4);

        ResultSet rs = preparedStatement2.executeQuery();

        //ResultSet rs = st.executeQuery("select * from Users");

            while (rs.next()){
           System.out.println(rs.getString( "idUser") + " " +
                               rs.getString("name") + " " +
                              rs.getString( "phone") + " " +
                             rs.getString("city") + " " + "\n");

        }


    }

}
