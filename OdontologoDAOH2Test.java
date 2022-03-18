import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import presencial.Main;
import presencial.dao.IDao;
import presencial.dao.OdontologoDAOH2;
import presencial.modelo.Odontologo;
import presencial.service.OdontologoService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class OdontologoDAOH2Test {
    private static IDao<Odontologo> odontologoIDao = new OdontologoDAOH2();
    Logger logger = Logger.getLogger(OdontologoDAOH2Test.class);
    @Test
    public void listarTodosLosOdontologos(){

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
        //creamos odontologos
        Odontologo odontologo = new Odontologo("robin", "batman", 100);
        odontologoService.guardarOdontologo(odontologo);
        logger.info("Agregando odontologo");

        Odontologo odontologo1 = new Odontologo("mujer", "maravilla", 104);
        odontologoService.guardarOdontologo(odontologo1);
        logger.info("Agregando odontologo");


        List<Odontologo> odontologos = odontologoIDao.listar();
        logger.info("Imprimiendo test, lista de odontologos: ");
        System.out.println(odontologos);

        Assert.assertTrue(odontologos.size() > 0);
    }
}
