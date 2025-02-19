package com.example.teste12;

public class Media {
    public double nota1;
    public double nota2;
    public double nota3;

    public Media(double nota1, double nota2, double nota3){
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calculadorDeMedia(){
        return (nota1 + nota2 + nota3) / 3;
    }
}
