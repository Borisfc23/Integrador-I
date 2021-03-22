/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Boris
 */
public class ArrayUsuario {
    ArrayList<Usuario>v;

    public ArrayUsuario() {
        v=new ArrayList<Usuario>();
    }
    public Usuario buscar(String id){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getId().equals(id)){
                return v.remove(i);                
            }
        }
        return null;
    }
    public Usuario buscarContra(String id,String contra){
        for(int i=0;i<v.size();i++){
            if(v.get(i).getContra().equals(contra) && v.get(i).getId().equals(id)){
                return v.remove(i);                
            }
        }
        return null;
    }
    public void adicionar(Usuario e){
        v.add(e);
    }
    
    int tamaño(){
        return v.size();
    }
    
    public Usuario obtener(int pos){
        return v.get(pos);
    }
    public void cargarUsuario(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("Usuarios.txt"));
            String linea;
            while((linea=br.readLine())!=null){
                StringTokenizer st=new StringTokenizer(linea,"/");
                String id=st.nextToken().trim();
                String contra=st.nextToken().trim();                
                Usuario a=new Usuario(id, contra);
                adicionar(a);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    public void grabarUsuario(){
        try {
            PrintWriter pw=new PrintWriter(new FileWriter("Usuarios.txt"));
            String linea;
            for(int i=0;i<v.size();i++){
                linea=obtener(i).getId()+"/"+obtener(i).getContra();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        }
    }
}
