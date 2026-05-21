package clinicavet.service;

import clinicavet.dao.ConsultaDao;
import clinicavet.model.Consulta;

public class ConsultaService {
    private final ConsultaDao consultaDao;

    public ConsultaService(ConsultaDao consultaDao) {
        this.consultaDao = consultaDao;
    }

    public void salvar(Consulta consulta) {
        if (consulta.getId() == null) {
            consultaDao.inserir(consulta);
            return;
        }
        consultaDao.atualizar(consulta);
    }
}
