package Classes;

import java.sql.Date;

public class FolderTable {

	private int id;
	private String cin;
	private String nomPrenom;
	private String typeDemande;
	private Date dateDepot;
	

	public FolderTable(int id, Date dateDepot, String typeDemande, String cin,  String nomPrenom) {
		this.id = id;
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.typeDemande = typeDemande;
		this.dateDepot = dateDepot;
	}

	//getters
	public int getId() {
		return id;
	}

	public String getCin() {
		return cin;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	//setters
	public void setId(int id) {
		this.id = id;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getTypeDemande() {
		return typeDemande;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}
	
}
