package Controller;

import Data.usuariosDAO;
import Model.usuariosJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginSV", value = "/loginSV")
public class loginSV extends HttpServlet {
    usuariosJB usuariosJB=new usuariosJB();
    usuariosDAO usuariosDAO=new usuariosDAO();

    int usuario;

    String email;
    String contraseña;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        switch (accion) {
            case "regresar":
                req.setAttribute("empleado", usuariosJB);
                System.out.println("Lo regreso a la pagina principal" + usuariosJB.getNombre());
                req.getRequestDispatcher("views/IndexEmpleado.jsp").forward(req, resp);

                break;

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}