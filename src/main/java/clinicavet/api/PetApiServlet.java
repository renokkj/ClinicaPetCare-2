package clinicavet.api;

import clinicavet.dao.PetDao;
import clinicavet.dao.impl.PetDaoMysql;
import clinicavet.model.Pet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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

                    out.print("""
                        {
                          "status":"error",
                          "message":"Pet nao encontrado"
                        }
                    """);

                    return;
                }

                String json = """
                    {
                      "status":"success",
                      "timestamp":"%s",
                      "data":{
                        "id":%d,
                        "nome":"%s",
                        "especie":"%s",
                        "raca":"%s"
                      }
                    }
                    """.formatted(
                        LocalDateTime.now(),
                        pet.getId(),
                        pet.getNome(),
                        pet.getEspecie(),
                        pet.getRaca()
                );

                out.print(json);

            }

            // LISTAR TODOS
            else {

                List<Pet> pets = petDao.listarTodos();

                StringBuilder petsJson = new StringBuilder();

                petsJson.append("[");

                for (int i = 0; i < pets.size(); i++) {

                    Pet pet = pets.get(i);

                    petsJson.append("""
                        {
                          "id":%d,
                          "nome":"%s",
                          "especie":"%s"
                        }
                        """.formatted(
                            pet.getId(),
                            pet.getNome(),
                            pet.getEspecie()
                    ));

                    if (i < pets.size() - 1) {
                        petsJson.append(",");
                    }
                }

                petsJson.append("]");

                String jsonFinal = """
                    {
                      "status":"success",
                      "timestamp":"%s",
                      "total":%d,
                      "data":%s
                    }
                    """.formatted(
                        LocalDateTime.now(),
                        pets.size(),
                        petsJson
                );

                out.print(jsonFinal);
            }

        } catch (Exception e) {

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            out.print("""
                {
                  "status":"error",
                  "message":"Erro interno da API"
                }
            """);
        }
    }
}