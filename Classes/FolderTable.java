package Classes;

public class FolderTable {

	private int id;
	private String cin;
	private String nomPrenom;
	private String typeDemande;
	
	public FolderTable() {
		id = 0;
		cin = "";
		nomPrenom = "";
	}

	public FolderTable(int id, String typeDemande, String cin,  String nomPrenom) {
		this.id = id;
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.typeDemande = typeDemande;
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

	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}
	
}
