package presencial.dao;

import presencial.modelo.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/parcialBackEnd6";
    private final static String DB_USER ="ro";
    private final static String DB_PASSWORD = "dri";

    public OdontologoDAOH2() {
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        //Conectarnos al driver
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Crear sentencia SQL
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (nombre, apellido, numeroMatricula) VALUES(?,?,?)");
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3,odontologo.getNumeroMatricula());

            //Ejecutar sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            //Levantar driver
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Crear sentencia SQL
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            //Ejecutar sentencia SQL
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Integer numeroMatricula = rs.getInt("numeromatricula");
                Integer id = rs.getInt("id");
                odontologos.add(new Odontologo(nombre, apellido, numeroMatricula, id));
            }
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return odontologos;
    }
}
