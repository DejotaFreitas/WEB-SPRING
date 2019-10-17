package drawrokanimes.model;

import javax.persistence.Embeddable;

//esse dados ficam incluidos na tabela que add
//@Embedded
//private Perfil perfil;

@Embeddable
public class Perfil {

	private String corDeFundo;
	private String tamanhoFonte;

	public String getCorDeFundo() {
		return corDeFundo;
	}

	public void setCorDeFundo(String corDeFundo) {
		this.corDeFundo = corDeFundo;
	}

	public String getTamanhoFonte() {
		return tamanhoFonte;
	}

	public void setTamanhoFonte(String tamanhoFonte) {
		this.tamanhoFonte = tamanhoFonte;
	}

}
