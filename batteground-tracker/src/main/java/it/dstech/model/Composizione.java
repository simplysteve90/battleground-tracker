package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Composizione {
@Id
private String nome;

public Composizione() {
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}


}
