
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>
</head>
<body>
<form method="post" action="inscription.jsp">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>"
               size="20" maxlength="60"/>
        <span class="erreur">${erreurs['email']}</span>
        <br/>

        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20"/>
        <span class="erreur">${erreurs['motdepasse']}</span>
        <br/>

        <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20"
               maxlength="20"/>
        <span class="erreur">${erreurs['confirmation']}</span>
        <br/>

        <label for="nom">Nom d'utilisateur</label>
        <input type="text" id="nom" name="nom" value="<c:out value="${param.nom}"/>" size="20"
               maxlength="20"/>
        <span class="erreur">${erreurs['nom']}</span>
        <br/>

        <input type="submit" value="Inscription" class="sansLabel"/>
        <br/>
        <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat1}</p>
    </fieldset>
</form>
</body>
</html>
