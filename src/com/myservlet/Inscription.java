package com.myservlet;

import com.mybean.Utilisateur;
import com.mycompany.InscriptionForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {
  private static final String ATT_USER = "utilisateur";
  private static final String ATT_FORM = "form";
  private static final String VUE = "/WEB-INF/inscription.jsp";

  public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    /* Affichage de la page d'inscription */
    this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
  }

  public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    /* Préparation de l'objet formulaire */
    InscriptionForm form = new InscriptionForm();

    /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
    Utilisateur utilisateur = form.inscrireUtilisateur( request );

    /* Stockage du formulaire et du bean dans l'objet request */
    request.setAttribute( ATT_FORM, form );
    request.setAttribute( ATT_USER, utilisateur );

    this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
  }
}