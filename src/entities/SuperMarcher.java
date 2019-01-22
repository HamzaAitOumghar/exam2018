package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperMarcher {

	private Map<String, IssusSecour> issus;

	private int nombreDeRayon;

	public SuperMarcher(int nombreDeRayon, String... issus) throws Exception {

		this.nombreDeRayon = nombreDeRayon;
		this.issus = new HashMap<>();

		for (String i : issus) {
			String issu = i.split(":")[0];
			int numeroRayon = Integer.valueOf(i.split(":")[1]);

			if (numeroRayon > this.nombreDeRayon) {
				throw new Exception("numero de rayon n'existe pas ");
			}

			IssusSecour issusSecour = new IssusSecour(numeroRayon,issu);
			this.issus.put(issu, issusSecour);

		}

	}
	
	public void fermer(String keyIssus){
		this.issus.get(keyIssus).setStateIssus(new StateFermer());
	}

	public String selectIssueFrom(int idRayon) throws Exception {

		if (idRayon > this.nombreDeRayon) {
			throw new Exception("numero de rayon n'existe pas ");
		}

		List<IssusSecour> _issus = new ArrayList<>(this.issus.values());

		// triage par meilleur distance

		Collections.sort(_issus, new Comparator<IssusSecour>() {

			@Override
			public int compare(IssusSecour o1, IssusSecour o2) {
				return o1.distanceFromRayon(idRayon) - o2.distanceFromRayon(idRayon);
			}

		});
		
		// triage par nombre de personne

		Collections.sort(_issus, new Comparator<IssusSecour>() {

			@Override
			public int compare(IssusSecour o1, IssusSecour o2) {
				// TODO Auto-generated method stub
				return o1.getNbrPersonne() - o2.getNbrPersonne();
			}
		});
		

		for(IssusSecour issusSecour : _issus){
			if(issusSecour.getStateIssus() instanceof StateOuvert){
				return issusSecour.getIdIssus();
			}
		}
		
		throw new Exception("tous les issus sont fermeé ! !");
		

	}

	public Map<String, IssusSecour> getIssus() {
		return issus;
	}

	public void setIssus(Map<String, IssusSecour> issus) {
		this.issus = issus;
	}

	public int getNombreDeRayon() {
		return nombreDeRayon;
	}

	public void setNombreDeRayon(int nombreDeRayon) {
		this.nombreDeRayon = nombreDeRayon;
	}

}
