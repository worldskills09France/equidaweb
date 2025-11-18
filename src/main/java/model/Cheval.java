package model;

import java.time.LocalDate;

public class Cheval {

    private int id;
    private String nom;
    private LocalDate dateNaissance;
    private String sire;
    private Race race;
    private Robe robe;
    private Proprietaire proprietaire;
    private Cheval papa;
    private Cheval maman;
    private String photo;

    public Cheval() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public Robe getRobe() {
		return robe;
	}

	public void setRobe(Robe robe) {
		this.robe = robe;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Cheval getPapa() {
		return papa;
	}

	public void setPapa(Cheval papa) {
		this.papa = papa;
	}

	public Cheval getMaman() {
		return maman;
	}

	public void setMaman(Cheval maman) {
		this.maman = maman;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
