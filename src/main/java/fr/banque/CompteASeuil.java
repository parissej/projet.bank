package fr.banque;

import java.security.InvalidParameterException;

public class CompteASeuil extends Compte implements IComptASeuil {

	private double seuil; // min du solde

	public CompteASeuil(int unNumero, double unSoldeInitial, double pSeuil) throws InvalidParameterException {
		super(unNumero, unSoldeInitial);
		this.setSeuil(pSeuil);
		if (unSoldeInitial < pSeuil) {
			throw new InvalidParameterException("Le solde initial doit être plus grand que le seuil !");
		}

	}

	public CompteASeuil() throws InvalidParameterException {
		this(0, 0, 0);
	}

	@Override
	public double getSeuil() {
		return this.seuil;
	}

	@Override
	public void setSeuil(double pSeuil) {
		this.seuil = pSeuil;
	}

	@Override
	public String toString() {
		return super.toString() + ", seuil = " + this.getSeuil();
	}

	/**
	 * Fait les vérifications en fonction de la valeur du seuil. On ne peut retirer
	 * M du solde S si et seulement si on a S-M > Seuil.
	 */
	@Override
	public void retirer(double unMontant) {
		if (this.getSolde() - unMontant > this.getSeuil()) {
			super.retirer(unMontant);
		}

	}

}
