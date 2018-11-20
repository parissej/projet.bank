package fr.banque;

public class Client {

	private String nom, prenom;
	private int age, numeroClient;
	private Compte[] comptes = new Compte[5];

	public Client() {
		this(0, "TEST", "Test", 0);
	}

	public Client(int unNumero, String unNom, String unPrenom, int unAge) {
		this.setAge(unAge);
		this.setNom(unNom);
		this.setPrenom(unPrenom);
		this.setNumero(unNumero);
	}

	public int getAge() {
		return this.age;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNumero(int numero) {
		this.numeroClient = numero;
	}

	public int getNumero() {
		return this.numeroClient;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Compte[] getComptes() {
		return this.comptes;
	}

	public Compte getCompte(int unNumero) {
		return this.getComptes()[unNumero];
	}

	public void setCompte(int unNumero, Compte unCompte) {
		this.getComptes()[unNumero] = unCompte;
	}

	/**
	 * @param unCompte à ajouter
	 * @return true si le compte à été ajouté, false sinon
	 */
	public boolean ajouterComptes(Compte unCompte) {

		for (int i = 0; i < this.getComptes().length; i++) {
			if (this.getCompte(i) == null) {
				this.setCompte(i, unCompte);
				return true;
			}
		}
		return false;
	}

	public String toStringComptes() {
		String toString = "";

		for (Compte compte : this.comptes) {
			if (compte != null) {
				toString += compte.toString() + "\n";
			}
		}

		return toString;

	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : [" + this.getNumero() + "] " + this.getNom() + " "
				+ this.getPrenom() + " (" + this.getAge() + " ans)";
	}

	public void afficher() {
		System.out.println(this.toString());
		for (Compte compte : this.comptes) {
			if (compte != null) {
				compte.afficher();
			}
		}
	}

	public void ajouter(double unMontant, Compte unCompte) {
		unCompte.ajouter(unMontant);
	}

	public void retirer(double unMontant, Compte unCompte) {
		unCompte.retirer(unMontant);
	}

}
