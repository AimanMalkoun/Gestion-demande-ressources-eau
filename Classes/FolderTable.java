package Classes;


public class FolderTable {

	private int id;
	private String cin;
	private String nomPrenom;
	private String typeDemande;
	private String idDossierYear;

	

	public FolderTable(int id, String idDossierYear, String typeDemande, String cin,  String nomPrenom) {
		this.id = id;
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.typeDemande = typeDemande;
		this.idDossierYear = idDossierYear;
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

	public String getDateDepot() {
		return idDossierYear;
	}

	public void setDateDepot(String dateDepot) {
		this.idDossierYear = dateDepot;
	}

	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}
	
}
