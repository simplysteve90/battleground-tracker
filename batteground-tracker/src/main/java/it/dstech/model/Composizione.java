package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Composizione {
@Id
private String nome;
private double numero;

public Composizione() {
}

public String getNome() {
	return nome;
}

public double getNumero() {
	return numero;
}

public void setNumero(double numero) {
	this.numero = numero;
}

public void setNome(String nome) {
	this.nome = nome;
}

@Override
public String toString() {
	return "Composizione [nome=" + nome + "]";
}


}
