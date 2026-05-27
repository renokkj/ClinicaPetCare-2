package clinicavet.command.home;

import clinicavet.command.AbstractCommand;

import clinicavet.dao.ConsultaDao;
import clinicavet.dao.PetDao;
import clinicavet.dao.TutorDao;

import clinicavet.dao.impl.ConsultaDaoMysql;
import clinicavet.dao.impl.PetDaoMysql;
import clinicavet.dao.impl.TutorDaoMysql;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexHomeCommand extends AbstractCommand {

    private final PetDao petDao = new PetDaoMysql();
    private final ConsultaDao consultaDao = new ConsultaDaoMysql();
    private final TutorDao tutorDao = new TutorDaoMysql();

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {

        request.setAttribute(
                "totalPets",
                petDao.listarTodos().size()
        );

        request.setAttribute(
                "totalConsultas",
                consultaDao.listarTodos().size()
        );

        request.setAttribute(
                "totalTutores",
                tutorDao.listarTodos().size()
        );

        return "/WEB-INF/views/home/index.jsp";
    }
}
