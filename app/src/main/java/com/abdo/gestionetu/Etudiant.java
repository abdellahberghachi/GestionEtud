package com.abdo.gestionetu;

/**
 * Created by user on 12/11/2016.
 */

public class Etudiant {

    private int id;
    private String nom;
    private String email;
    private int age ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Etudiant(String nom, String email, int age ) {
        this.nom = nom;
        this.email = email;
        this.age = age;
    }

    public Etudiant(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nom + " " + email+""+age;
    }

    public Etudiant() {
    }
}
