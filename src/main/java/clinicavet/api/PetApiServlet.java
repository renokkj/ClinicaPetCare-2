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

            String idParam = req.getParameter("id");

            // BUSCAR PET POR ID
            if (idParam != null) {

                Long id = Long.parseLong(idParam);

                Pet pet = petDao.buscarPorId(id).orElse(null);

                if (pet == null) {

                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

                    out.print("{\"erro\":\"Pet nao encontrado\"}");

                    return;
                }

                String json = "{"
                        + "\"id\":" + pet.getId() + ","
                        + "\"nome\":\"" + pet.getNome() + "\","
                        + "\"especie\":\"" + pet.getEspecie() + "\","
                        + "\"raca\":\"" + pet.getRaca() + "\""
                        + "}";

                out.print(json);

            }

            // LISTAR TODOS
            else {

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
                            .append("\"");

                    json.append("}");

                    if (i < pets.size() - 1) {

                        json.append(",");
                    }
                }

                json.append("]");

                out.print(json.toString());
            }

        } catch (Exception e) {

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            out.print("{\"erro\":\"Erro interno da API\"}");
        }
    }
}