package presencial;

import org.apache.log4j.Logger;
import presencial.dao.OdontologoDAOH2;
import presencial.modelo.Odontologo;
import presencial.service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);
        String DB_JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:~/parcialBackEnd6;INIT=RUNSCRIPT FROM 'create.sql'";
        String DB_USER ="ro";
        String DB_PASSWORD = "dri";
        Connection connection = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        //Servicio
        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());
        //creamos odontologo
        Odontologo odontologo = new Odontologo("Rodrigo", "Cabrera", 23);
        odontologoService.guardarOdontologo(odontologo);
        logger.info("Agregando odontologo");

        Odontologo odontologo1 = new Odontologo("pedro", "picapiedra", 100);
        odontologoService.guardarOdontologo(odontologo1);
        logger.info("Agregando odontologo");

        logger.info("Imprimiendo lista de odontologos");
        System.out.println(odontologoService.listarOdontologos());
    }
}
