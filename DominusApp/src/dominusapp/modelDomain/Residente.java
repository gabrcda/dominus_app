/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominusapp.modelDomain;

import java.time.LocalDate;

/**
 *
 * @author gabri
 */
public class Residente {
    private int cdResidente;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String blocoApt;
    private int numeroApt;
    private String senha;

    public Residente(int cdResidente, String nome, String cpf, String email, LocalDate dataNascimento, String blocoApt, int numeroApt, String senha) {
        this.cdResidente = cdResidente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.blocoApt = blocoApt;
        this.numeroApt = numeroApt;
        this.senha = senha;
    }
    
    public Residente(){
        
    }

    public int getCdResidente() {
        return cdResidente;
    }

    public void setCdResidente(int cdResidente) {
        this.cdResidente = cdResidente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBlocoApt() {
        return blocoApt;
    }

    public void setBlocoApt(String blocoApt) {
        this.blocoApt = blocoApt;
    }

    public int getNumeroApt() {
        return numeroApt;
    }

    public void setNumeroApt(int numeroApt) {
        this.numeroApt = numeroApt;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
