package Entity;

import java.util.Objects;

public class Employe {
    private int cin;
    private String nom;
    private String prenom;

    public Employe(){
        super();
    }

    public Employe(int cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return cin==employe.cin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin);
    }


}
