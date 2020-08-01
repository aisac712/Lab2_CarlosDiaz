package lab.pkg2_carlosdiaz;

import java.awt.Color;

public class Empleado {
    private String nombre;
    private String apellido;
    private String color_f;
    private int edad;
    private char genero;
    private float altura;
    private float peso;
    private String titulo;
    private String cargo;
    private int salario;
    
    public Empleado(){
        
    }
    
    public Empleado(String Nombre){
        this.nombre=Nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String A){
        this.apellido=A;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setColor(String c){
        this.color_f=c;
    }
    public String getColor(){
        return color_f;
    }
    
    public void setEdad(int e){
        this.edad=e;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setGenero(char g){
        this.genero=g;
    }
    
    public char getGenero(){
        return genero;
    }
    
    public void setAltura(float a){
        this.altura=a;
    }
    
    public float getAltura(){
        return altura;
    }
    
    public void setPeso(float p){
        this.peso=p;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public void setTitulo(String t){
        this.titulo=t;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setCargo(String c){
        this.cargo=c;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void setSalario(int s){
        this.salario=s;
    }
    
    public int getSalario(){
        return salario;
    }
}
