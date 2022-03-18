package presencial.service;

import presencial.dao.IDao;
import presencial.modelo.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }
    public List<Odontologo> listarOdontologos(){
        return odontologoIDao.listar();
    }

}
