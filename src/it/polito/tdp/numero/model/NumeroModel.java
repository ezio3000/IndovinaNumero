package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;

public class NumeroModel {
	
	//codice proveniente dal main
	private final int NMAX = 100;
	private final int TMAX = 8;

	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	//fine codice proveniente dal main
	
	public int getTMAX() {
		return TMAX;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public void setInGioco(boolean inGioco) {
		this.inGioco = inGioco;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public NumeroModel() {
		inGioco=false;
	}
	
	/**
	 * Avvia nuova partita
	 */
	public void newGame() {
		inGioco = true;
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
	
	}
	
	public int tentativo(int t) {
		
		//controllo se la partita è in corso
		if(!inGioco) {
			throw new IllegalStateException("la partita è terminata");
		}
		
		//verifica se l'imput è nel range corretto
		if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Devi inserire un numero tra %d e %d",1,NMAX));			
		}
		
		/**
		 * metodo per effettuare un tentativo
		 * @param t il tentativo
		 * @return 1 se troppo alto, -1 se troppo basso, 0 se l'utente ha indovinato
		 */
		
		//gestione tentativo
		this.tentativiFatti++;
		if(this.tentativiFatti==this.TMAX) {
			this.inGioco=false;
		}
		
		if(t==this.segreto) {
			this.inGioco=false;
			return 0;					
		}
		
		if(t>this.segreto) {
			return 1;
		}
		return -1;
			
		}
		
	
	   public boolean tentativoValido(int t) {
		  if(t<1 || t>NMAX) {
			  return false;			  
		  } else {
			  return true;
		  }
		   
	   }

}
