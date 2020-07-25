package Classes;

public class FolderTable {

	private int id;
	private String cin;
	private String nomPrenom;
	
	public FolderTable() {
		id = 0;
		cin = "";
		nomPrenom = "";
	}

	public FolderTable(int id, String cin,  String nomPrenom) {
		this.id = id;
		this.cin = cin;
		this.nomPrenom = nomPrenom;
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
	
}
