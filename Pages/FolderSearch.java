package Pages;

import javafx.beans.property.SimpleStringProperty;

public class FolderSearch {
	
	private SimpleStringProperty folderId = new SimpleStringProperty("");
	private SimpleStringProperty cin = new SimpleStringProperty("");
	private SimpleStringProperty nomDemandeur = new SimpleStringProperty("");
	
	public FolderSearch()
	{
		this("", "", "");
	}

	public FolderSearch(String folderId, String cin, String nomDemandeur)
	{
		this.setCIN(cin);
		this.setFolderId(folderId);
		this.setNomDemandeur(nomDemandeur);
	}
	
	public FolderSearch(FolderSearch folderSearch)
	{
		cin.set(folderSearch.getCIN());
		folderId.set(folderSearch.getFolderId());
		nomDemandeur.set(folderSearch.getNomDemandeur());	
	}
	
	public String getFolderId() {
		return folderId.get();
	}

	public String getCIN() {
		return cin.get();
	}

	public String getNomDemandeur() {
		return nomDemandeur.get();
	}

	public void setFolderId(String folderId) {
		this.folderId.set(folderId);
	}

	public void setCIN(String cin) {
		this.cin.set(cin);
	}

	public void setNomDemandeur(String nomDemandeur) {
		this.nomDemandeur.set(nomDemandeur);
	}

}
