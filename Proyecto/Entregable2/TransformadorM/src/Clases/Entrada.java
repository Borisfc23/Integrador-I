/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


/**
 *
 * @author Boris
 */
public class Entrada {
           
    private String codigo;
    private String nombre;
    private int voltajep;
    private double voltajes1;
    private double intensidad1;    
    private int formaNucleo;
    private int coeficientechapa;
    private double x[]={1.6, 2.8, 2.5, 2.8, 2.8, 3.2, 3.5, 3.2, 2.8, 3.8};
    private double y[]={1.9, 1.5, 1.8, 2.8, 2.8, 2.5, 3.5, 3.5, 4, 5, 4};

    public Entrada() {
    }

    public Entrada(String codigo, String nombre, int voltajep, double voltajes1, double intensidad1, int formaNucleo, int tipoTrafo,int coeficientechapa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.voltajep = voltajep;
        this.voltajes1 = voltajes1;
        this.intensidad1 = intensidad1;        
        this.formaNucleo = formaNucleo;                
        this.coeficientechapa=coeficientechapa;
    }

    public int getCoeficientechapa() {
        return coeficientechapa;
    }

    public void setCoeficientechapa(int coeficientechapa) {
        this.coeficientechapa = coeficientechapa;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVoltajep() {
        return voltajep;
    }

    public void setVoltajep(int voltajep) {
        this.voltajep = voltajep;
    }

    public double getVoltajes1() {
        return voltajes1;
    }

    public void setVoltajes1(double voltajes1) {
        this.voltajes1 = voltajes1;
    }

    public double getIntensidad1() {
        return intensidad1;
    }

    public void setIntensidad1(double intensidad1) {
        this.intensidad1 = intensidad1;
    }

    public int getFormaNucleo() {
        return formaNucleo;
    }

    public void setFormaNucleo(int formaNucleo) {
        this.formaNucleo = formaNucleo;
    }
  
    public int MostrarFormNucleo(){
        int forma=0;
        if(formaNucleo==0){
            forma=0;
        }
        else if(formaNucleo==1){
            forma=1;
        }
        return forma;
    }
    
    public double CalculoPotenciaAparente(){
        double p;
        p=voltajes1*intensidad1;
        return p;
    }
    
    public double CalculoSeccionNucleo(double p){
        double sn=0;
        switch(coeficientechapa){
            case 0:
                sn=(Math.sqrt(p))*0.7;break;
            case 1:
                sn=(Math.sqrt(p))*0.8;break;
            case 2:
                sn=(Math.sqrt(p))*0.9;break;
            case 3:
                sn=(Math.sqrt(p))*1;break;                
        }        
        return sn;
    }
    
    public double NumeroEspirasPrimario(double sn){
        double nespiraP=0;
        switch(voltajep){
            case 0:
                nespiraP=(220*10000)/(50*sn*4.44);break;
            case 1:
                nespiraP=(10000*110)/(60*sn*10000*4.44);break;                
        }
        return nespiraP;
    }
        
    public double NumeroEspirasSecundario1(double sn,double voltajes1){
        double nespiraS=0;
        switch(voltajep){
            case 0:
                nespiraS=voltajes1*10000/(50*sn*4.44);break;
            case 1:
                nespiraS=voltajes1*10000/(60*sn*4.44);break;                
        }
        return nespiraS;
    }
     public double Densidad(double p){
        double d=0;
        if(p<50){
            d=4;
        }
        else if(p>=50 && p<=100){
            d=3.5;
        }
        else if(p>=101 && p<=200){
            d=3;
        }
        else if(p>=201 && p<=500){
            d=2.5;
        }
        else if(p>=501 && p<=1000){
            d=2;
        }
        else if(p>=1001 && p<=1500){
            d=1.5;
        }
        return d;
    }
     
    public double IntensidadPrimario(double p){
        double ip=0;
        switch(voltajep){
            case 0:
                ip=p/220;break;
            case 1:
                ip=p/110;break;
        }
        return ip;
    }
   
    public double SeccionPrimario(double ip,double d){
        double sp;
        sp=ip/d;
        return sp;
    }
    public double SeccionSecundario1(double d){
        double sp;
        sp=intensidad1/d;
        return sp;
    }
    
    public String MedidaChapa(double sn){
        String med="";       
            if(sn<=3.04){
                med="1.6 x 1.9";
            }
            else if(sn>3.04 && sn<=4.20){
                med="2.8 x 1.5";
            }
            else if(sn>4.20 && sn<=4.50){
                med="2.5 x 1.8";
            }
            else if(sn>4.50 && sn<=6.16){
                med="2.2 x 2.8";
            }
            else if(sn>6.16 && sn<=7){
                med="2.5 x 2.8";
            }
            else if(sn>7 && sn<=9.80){
                med="2.8 x 3.5";
            }
            else if(sn>9.80 && sn<=11.20){
                med="3.2 x 3.5";
            }
            else if(sn>11.20 && sn<=12.80){
                med="3.2 x 4";
            }
            else if(sn>12.80 && sn<=14){
                med="2.8 x 5";
            }
            else if(sn>14 && sn<15.2){
                med="3.8 x 4";
            }        
        return med;
    }
    public double CantChapas(double sn){
        double n=0;
        
        for(int i=1;i<11;i++){
            if(sn>=x[i-1]*y[i-1]  &&sn<=x[i]*y[i]){
              n=y[i]*10/0.5;
            }
        }
        return n;
    }
    public double SeccionNueva(double sn){
        double perimetro=0;
        
        for(int i=1;i<11;i++){
            if(sn>=x[i-1]*y[i-1]  &&sn<=x[i]*y[i]){
              perimetro=x[i]*2+y[i]*2;
              i=10;
            }
        }
        return perimetro;
    }
    
    public double LargoPrimarioEspira(double nespiraP,double perimetro){
        double l;
        l=(nespiraP*perimetro)/100;
        return l;
    }
}
