package org.acme;

public class Conteudo {

    public Integer id;

    public String nome;

    public Integer valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Conteudo [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
    }
    
}
