
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author mehari
 */
public class NoteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader Breader = new BufferedReader(new FileReader(new File(path)));
        String title = Breader.readLine();
        String contents = Breader.readLine();
        
        Note myNote = new Note();
        myNote.setTitle(title);
        myNote.setContents(contents);
        request.setAttribute("note", myNote);
        
      if(request.getParameter("edit") == null) {
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
      
        return;
      } else{
             getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
      
        return;
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("edit") != null) {
        String edittedTitle = request.getParameter("title");
        String edittedContents = request.getParameter("contents");
        
        Note edittedNote = new Note();
        edittedNote.setTitle(edittedTitle);
        edittedNote.setContents(edittedContents);
        request.setAttribute("note", edittedNote);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(edittedTitle);
        pw.println(edittedContents);
       
       
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
        }
        
        
    }

}
