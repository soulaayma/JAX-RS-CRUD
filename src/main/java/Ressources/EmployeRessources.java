package Ressources;

import java.util.ArrayList;
import java.util.List;
import Entity.Employe;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("employes")
public class EmployeRessources {

    public static List<Employe> listemp = new ArrayList<Employe>();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String ajouterEmploye(Employe e) {

        if(listemp.add(e))
            return "Employe Ajoute";
        return "employe non ajoute";

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cin}")
    public Employe chercherEmploye(@PathParam(value = "cin")int cin) {
        Employe e = new Employe();
        for(int i=0;i<listemp.size();i++) {
            if(listemp.get(i).equals(cin))
                e = listemp.get(i);
        }
        return e;
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateEmployee (Employe e){
        Employe emp = chercherEmploye(e.getCin());
        if(emp != null){
            emp.setNom(e.getNom());
            emp.setPrenom(e.getPrenom());
            return "Update successful";
        }
        else return "Update failed";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employe> afficherListeEmploye() {
        return listemp;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cin}")
    public Boolean supprimerEmploye(@PathParam(value = "cin") int cin) {
        return listemp.remove(chercherEmploye(cin));
    }



}
