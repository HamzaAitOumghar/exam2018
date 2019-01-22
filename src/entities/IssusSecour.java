package entities;

public class IssusSecour {

	private String idIssus;
	private int numeroRayon;
	private int nbrPersonne;
	private State stateIssus;
	
	

	public IssusSecour(int numeroRayon,String idIssus) {
		super();
		this.idIssus=idIssus;
		this.numeroRayon = numeroRayon;
		this.stateIssus = new StateOuvert();
		this.nbrPersonne=0;
	}



	public int distanceFromRayon(int numRayon){
		return Math.abs(numRayon-this.numeroRayon);
	}



	public int getNumeroRayon() {
		return numeroRayon;
	}



	public void setNumeroRayon(int numeroRayon) {
		this.numeroRayon = numeroRayon;
	}



	public int getNbrPersonne() {
		return nbrPersonne;
	}



	public void setNbrPersonne(int nbrPersonne) {
		this.nbrPersonne = nbrPersonne;
	}



	public State getStateIssus() {
		return stateIssus;
	}



	public void setStateIssus(State stateIssus) {
		this.stateIssus = stateIssus;
	}



	public String getIdIssus() {
		return idIssus;
	}



	public void setIdIssus(String idIssus) {
		this.idIssus = idIssus;
	} 
	
	
	
	
	
	

	
	

}
