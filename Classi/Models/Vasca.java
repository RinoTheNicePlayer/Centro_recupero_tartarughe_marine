package Classi.Models;

public class Vasca {
	private int idVasca;
	private String codiceVasca;
	
	public Vasca(int idVasca, String codiceVasca) {
		this.idVasca = idVasca;
		this.codiceVasca = codiceVasca;
	}
	
	public int getIdVasca() {
		return idVasca;
	}

	public void setIdVasca(int idVasca) {
		this.idVasca = idVasca;
	}

	public String getCodiceVasca() {
		return codiceVasca;
	}

	public void setCodiceVasca(String codiceVasca) {
		this.codiceVasca = codiceVasca;
	}

	
}
