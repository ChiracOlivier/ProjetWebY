package com.myservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inscription")
public class Inscription extends HttpServlet {

  public static final String VUE = "/WEB-INF/inscription.jsp";
  public static final String CHAMP_EMAIL = "email";
  public static final String CHAMP_PASS = "motdepasse";
  public static final String CHAMP_CONF = "confirmation";
  public static final String CHAMP_NOM = "nom";
  public static final String ATT_ERREURS = "erreurs";
  public static final String ATT_RESULTAT = "resultat1";

  @Override
  public void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    /* Récupération des champs du formulaire. */
    String email = request.getParameter(CHAMP_EMAIL);
    String motDePasse = request.getParameter(CHAMP_PASS);
    String confirmation = request.getParameter(CHAMP_CONF);
    String nom = request.getParameter(CHAMP_NOM);
    String resultat1;
    Map<String, String> erreurs = new HashMap<>();

    /* Validation du champ email. */
    try {
      validationEmail(email);
    } catch (Exception e) {
      erreurs.put(CHAMP_EMAIL, e.getMessage());
    }

    /* Validation des champs mot de passe et confirmation. */
    try {
      validationMotsDePasse(motDePasse, confirmation);
    } catch (Exception e) {
      erreurs.put(CHAMP_PASS, e.getMessage());
    }

    /* Validation du champ nom. */
    try {
      validationNom(nom);
    } catch (Exception e) {
      erreurs.put(CHAMP_NOM, e.getMessage());
    }

    /* Initialisation du résultat global de la validation. */
    if (erreurs.isEmpty()) {
      resultat1 = "Succès de l'inscription.";
    } else {
      resultat1 = "Échec de l'inscription.";
    }

    /* Stockage du résultat et des messages d'erreur dans l'objet request */
    request.setAttribute(ATT_ERREURS, erreurs);
    request.setAttribute(ATT_RESULTAT, resultat1);

    this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
  }

  private void validationEmail(String email) throws Exception {
    if (email != null && email.trim().length() != 0) {
      if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
        throw new Exception("Merci de saisir une adresse mail valide.");
      }
    } else {
      throw new Exception("Merci de saisir une adresse mail.");
    }
  }

  private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
    if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
        && confirmation.trim().length() != 0) {
      if (!motDePasse.equals(confirmation)) {
        throw new Exception(
            "Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
      } else if (motDePasse.trim().length() < 8) {
        throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
      }
    } else {
      throw new Exception("Merci de saisir et confirmer votre mot de passe.");
    }
  }

  private void validationNom(String nom) throws Exception {
    if (nom != null && nom.trim().length() < 3) {
      throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
    }
  }


  public void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    /* Affichage de la page d'inscription */
    this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
  }
}
