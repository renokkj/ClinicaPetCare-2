package clinicavet.api;

import clinicavet.dao.PetDao;
import clinicavet.dao.impl.PetDaoMysql;
import clinicavet.model.Pet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/pets")
public class PetApiServlet extends HttpServlet {

    private final PetDao petDao = new PetDaoMysql();

    @Override
protected void doGet(HttpServletRequest req,
                     HttpServletResponse resp)
        throws ServletException, IOException {

    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");

    PrintWriter out = resp.getWriter();

    try {

        List<Pet> pets = petDao.listarTodos();

        StringBuilder json = new StringBuilder();

        json.append("[");

        for (int i = 0; i < pets.size(); i++) {

            Pet pet = pets.get(i);

            json.append("{");

            json.append("\"id\":")
                    .append(pet.getId())
                    .append(",");

            json.append("\"nome\":\"")
                    .append(pet.getNome())
                    .append("\",");

            json.append("\"especie\":\"")
                    .append(pet.getEspecie())
                    .append("\",");

            json.append("\"raca\":\"")
                    .append(pet.getRaca())
                    .append("\",");

            json.append("\"sexo\":\"")
                    .append(pet.getSexo())
                    .append("\",");

            json.append("\"cor\":\"")
                    .append(pet.getCor())
                    .append("\",");

            json.append("\"peso\":")
                    .append(pet.getPeso())
                    .append(",");

            json.append("\"porte\":\"")
                    .append(pet.getPorte())
                    .append("\",");

            json.append("\"castrado\":")
                    .append(pet.isCastrado())
                    .append(",");

            json.append("\"statusVacinal\":\"")
                    .append(pet.getStatusVacinal())
                    .append("\",");

            json.append("\"tutorId\":")
                    .append(pet.getTutorId());

            json.append("}");

            if (i < pets.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        out.print(json);

    } catch (Exception e) {

        resp.setStatus(
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR
        );

        out.print("{\"erro\":\"Erro interno ao listar pets\"}");
        }
    }
}