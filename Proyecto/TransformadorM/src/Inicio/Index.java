/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Clases.Entrada;
import Clases.Fecha;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Formatter;
import java.util.UUID;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Boris
 */
public class Index extends javax.swing.JFrame {

    /**
     * Creates new form Index
     */
    Entrada e=new Entrada();
    Fecha f=new Fecha();
    DecimalFormat obj=new DecimalFormat("###.##"); 
    DecimalFormat obj2=new DecimalFormat("###");
    String barra=File.separator;
    String crearubicacion=System.getProperty("user.dir")+barra+"Registro"+barra;
    
    public Index() {
        initComponents();
        this.setLocationRelativeTo(null);   
        this.codigo();
    }            
    
    public void codigo(){
        txtcodigo.setText(UUID.randomUUID().toString().toUpperCase().substring(0, 6));
    }
    public void Registrar(){
        String archivo=txtcodigo.getText()+".txt";
        File crearUbi=new File(crearubicacion);
        File crearArchi=new File(crearubicacion+archivo);
        
        if(txtcodigo.getText().equals(null)){
            JOptionPane.showMessageDialog(rootPane,"NO EXISTE ID");            
        }else{
            try {
                if(crearArchi.exists()){
                    JOptionPane.showMessageDialog(rootPane,"el ID YA ESTA REGISTRADO");            
                }else{
                    crearUbi.mkdirs();
                    Formatter crearforma=new Formatter(crearubicacion+archivo);
                    crearforma.format(salida.getText().toString());
                    crearforma.close();
                    JOptionPane.showMessageDialog(rootPane,"Registro Exitoso");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane,"Registro Incorrecto");
            }
        }
    }
   
    public void borraImgen(){
        ImageIcon imagen=new ImageIcon("");
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(imagennucleo.getWidth(), imagennucleo.getHeight(), Image.SCALE_DEFAULT));
        imagennucleo.setIcon(icono);
    }
    public void Borrar(){
        txtnombre.setText("");        
        txtvoltajes1.setText("");
        txtvoltajes2.setText("");
        txtvoltajes3.setText("");
        txtvoltajes4.setText("");
        txtampere1.setText("");
        txtampere2.setText("");
        txtampere3.setText("");
        txtampere4.setText("");        
        salida.setText("");
        borraImgen();                
    }
    public void Calcular(){        
        String medidanucleo;
        int voltajep,coef;
        double voltajes1,intensidad1,potenciaAp,seccionNucleo,numEspirasP,numEspirasS1,intensidadP,
                seccionp,d,seccions1,cantchapas,seccionnueva,largo;
        
        voltajes1=Double.parseDouble(txtvoltajes1.getText());
        intensidad1=Double.parseDouble(txtampere1.getText());
        voltajep=cmbvoltajep.getSelectedIndex();        
        coef=cmbcoef.getSelectedIndex();
        e.setCoeficientechapa(coef);
        e.setVoltajes1(voltajes1);
        e.setIntensidad1(intensidad1);
        e.setVoltajep(voltajep);
        
       
        potenciaAp=e.CalculoPotenciaAparente();
        seccionNucleo=e.CalculoSeccionNucleo(potenciaAp);                
        numEspirasP=e.NumeroEspirasPrimario(seccionNucleo);
        numEspirasS1=e.NumeroEspirasSecundario1(seccionNucleo, voltajes1);
        intensidadP=e.IntensidadPrimario(potenciaAp);
        d=e.Densidad(potenciaAp);
        seccionp=e.SeccionPrimario(intensidadP,d );
        seccions1=e.SeccionSecundario1(d);
        medidanucleo=e.MedidaChapa(seccionNucleo);
        cantchapas=e.CantChapas(seccionNucleo);
        seccionnueva=e.SeccionNueva(seccionNucleo);
        largo=e.LargoPrimarioEspira(numEspirasP, seccionnueva);
        
        salida.append("Codigo: "+txtcodigo.getText()+"\n"+
                "Nombre: "+txtnombre.getText()+"\n"+
                "Fecha: "+f.Fecha()+" Hora: "+f.Hora()+
                "\n"+"\n"+"Nucleo"+"\n"+
                "Potencia Aparente: "+potenciaAp+
                "Seccion: "+obj.format(seccionNucleo)+" cm2"+"\n"+
                "Medidas: "+medidanucleo+"\n"+
                "Cantidad de Chapas: "+obj.format(cantchapas)+"\n"
                        +"\n"+"Devanado Primario \n"+
                "N° Espiras Primario: "+obj2.format(numEspirasP)+"\n"+                       
                 /*"Longitud de Espira : "+obj2.format(largo)+"\n"+ */
                "Intensidad: "+obj.format(intensidadP)+"\n"+
                        "Seccion Primaria: "+obj.format(seccionp)+"\n"
                        +"\n"                
                        +"Devanado Secundario \n"+
                "N° Espiras Secundario(1): "+obj2.format(numEspirasS1)+"\n"+
                "Seccion Secundaria(1): "+obj.format(seccions1)+"\n");
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtvoltajes1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtampere1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtvoltajes2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtampere2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtvoltajes3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtampere3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtvoltajes4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtampere4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmbformanucleo = new javax.swing.JComboBox<>();
        btncalcular = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        cmbvoltajep = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cmbcoef = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        imagennucleo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/NucAnular.jpg"))); // NOI18N

        jLabel26.setText("jLabel26");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondo.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("Codigo : ");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("TRANSFORMADOR MONOFASICO");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Datos del Cliente");

        jLabel2.setText("Nombre :");

        txtcodigo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Datos de Entrada del Transformador");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Devanado Primario");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Devanado Secundario");

        jLabel12.setText("V");

        jLabel13.setText("1");

        jLabel14.setText("V");

        jLabel15.setText("A");

        jLabel4.setText("2");

        jLabel5.setText("V");

        jLabel16.setText("A");

        jLabel17.setText("3");

        jLabel18.setText("V");

        jLabel19.setText("A");

        jLabel20.setText("4");

        jLabel21.setText("V");

        jLabel22.setText("A");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("Forma del Nucleo");

        cmbformanucleo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acorazado", "Sin Acorazado" }));
        cmbformanucleo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbformanucleoItemStateChanged(evt);
            }
        });

        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        cmbvoltajep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "220", "110" }));

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 0));
        jLabel28.setText("Datos de Salida del Tranformador");

        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane1.setViewportView(salida);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Coeficiente Chapa");

        cmbcoef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.7", "0.8", "0.9", "1" }));

        jButton1.setText("AWG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Chapas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel9)
                                .addGap(37, 37, 37)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btncalcular))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(cmbvoltajep, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel12)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12)
                                .addComponent(txtvoltajes1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel14)
                                .addGap(12, 12, 12)
                                .addComponent(txtampere1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel20)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtvoltajes4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabel21)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtampere4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel22))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(cmbcoef, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(106, 106, 106)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtvoltajes2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabel5)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtampere2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel16))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtvoltajes3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabel18)
                                            .addGap(12, 12, 12)
                                            .addComponent(txtampere3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel19)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbformanucleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imagennucleo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(100, 100, 100))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel11))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel1)
                            .addGap(418, 418, 418)
                            .addComponent(jButton2)
                            .addGap(6, 6, 6)
                            .addComponent(jButton1))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btncalcular))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnlimpiar))
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbvoltajep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtvoltajes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtampere1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtvoltajes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtampere2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbcoef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtvoltajes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtampere3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel20))
                    .addComponent(txtvoltajes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel21))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtampere4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)))
                .addGap(6, 6, 6)
                .addComponent(cmbformanucleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imagennucleo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        this.Calcular();        
    }//GEN-LAST:event_btncalcularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().open(new java.io.File("src/Imagen/tabla.pdf"));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Desktop.getDesktop().open(new java.io.File("src/Imagen/tablaChapa.pdf"));
        } catch (Exception e) {
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbformanucleoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbformanucleoItemStateChanged
        int img=cmbformanucleo.getSelectedIndex();
        switch(img){
            case 0:
                ImageIcon imagen=new ImageIcon("src/Imagen/ConAcor.jpg");
                Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(imagennucleo.getWidth(), imagennucleo.getHeight(), Image.SCALE_DEFAULT));
                imagennucleo.setIcon(icono);
                
                break;
            case 1:
               /* ImageIcon imagen2=new ImageIcon(this.getClass().getResource("/Imagen/SinAcor.JPG"));
                imagennucleo.setIcon(imagen2);break;*/
                ImageIcon imagen2=new ImageIcon("src/Imagen/SinAcor.jpg");
                Icon icono2=new ImageIcon(imagen2.getImage().getScaledInstance(imagennucleo.getWidth(), imagennucleo.getHeight(), Image.SCALE_DEFAULT));
                imagennucleo.setIcon(icono2);
        }           
    }//GEN-LAST:event_cmbformanucleoItemStateChanged

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        this.Borrar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.Registrar();
        this.Borrar();
        this.codigo();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cmbcoef;
    private javax.swing.JComboBox<String> cmbformanucleo;
    private javax.swing.JComboBox<String> cmbvoltajep;
    private javax.swing.JLabel imagennucleo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea salida;
    private javax.swing.JTextField txtampere1;
    private javax.swing.JTextField txtampere2;
    private javax.swing.JTextField txtampere3;
    private javax.swing.JTextField txtampere4;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtvoltajes1;
    private javax.swing.JTextField txtvoltajes2;
    private javax.swing.JTextField txtvoltajes3;
    private javax.swing.JTextField txtvoltajes4;
    // End of variables declaration//GEN-END:variables
}
