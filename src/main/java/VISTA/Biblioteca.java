/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import CONTROL.ControlEstanteria;
import MODELO.CLASIFICACION.LibroDeTexto;
import MODELO.CLASIFICACION.Novela;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leo
 */
public class Biblioteca extends javax.swing.JFrame {

    /**
     * Creates new form Biblioteca
     */

    DefaultTableModel model = new DefaultTableModel();

    // Estanterías
    ControlEstanteria<Novela> estanteriaNovelas = new ControlEstanteria();
    ControlEstanteria<LibroDeTexto> estanteriaLibrosTexto = new ControlEstanteria();

    public Biblioteca() {
        initComponents();
        mostrarTabla();
    }

    public void mostrarTabla(){

        // Agregando novelas a la estantería
        estanteriaNovelas.agregarLibro(new Novela("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, 9788478884454L, "Fantasía"));
        estanteriaNovelas.agregarLibro(new Novela("Cien años de soledad", "Gabriel García Márquez", 1967, 9780307350428L, "Realismo mágico"));
        estanteriaNovelas.agregarLibro(new Novela("1984", "George Orwell", 1949, 9788420674220L, "Distopía"));
        estanteriaNovelas.agregarLibro(new Novela("Matar a un ruiseñor", "Harper Lee", 1960, 9788498383186L, "Ficción social"));
        estanteriaNovelas.agregarLibro(new Novela("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, 9788424117386L, "Parodia"));
        estanteriaNovelas.agregarLibro(new Novela("En busca del tiempo perdido", "Marcel Proust", 1913, 9788420412140L, "Novela psicológica"));
        estanteriaNovelas.agregarLibro(new Novela("Orgullo y prejuicio", "Jane Austen", 1813, 9788497644881L, "Romance"));
        estanteriaNovelas.agregarLibro(new Novela("Ulises", "James Joyce", 1922, 9788489644362L, "Modernismo"));
        estanteriaNovelas.agregarLibro(new Novela("Los juegos del hambre", "Suzanne Collins", 2008, 9788427202122L, "Ciencia ficción"));
        estanteriaNovelas.agregarLibro(new Novela("Crónica de una muerte anunciada", "Gabriel García Márquez", 1981, 9780307474729L, "Ficción latinoamericana"));
        estanteriaNovelas.agregarLibro(new Novela("El gran Gatsby", "F. Scott Fitzgerald", 1925, 9788497932072L, "Ficción moderna"));
        estanteriaNovelas.agregarLibro(new Novela("Moby-Dick", "Herman Melville", 1851, 9788467028435L, "Aventura"));
        estanteriaNovelas.agregarLibro(new Novela("Los pilares de la Tierra", "Ken Follett", 1989, 9788497594758L, "Histórica"));
        estanteriaNovelas.agregarLibro(new Novela("El retrato de Dorian Gray", "Oscar Wilde", 1890, 9788491052052L, "Ficción gótica"));
        estanteriaNovelas.agregarLibro(new Novela("El guardián entre el centeno", "J.D. Salinger", 1951, 9788499890944L, "Literatura juvenil"));
        estanteriaNovelas.agregarLibro(new Novela("Los hombres me explican cosas", "Rebecca Solnit", 2014, 9788417081643L, "Ensayo"));
        estanteriaNovelas.agregarLibro(new Novela("La naranja mecánica", "Anthony Burgess", 1962, 9788433960059L, "Ficción distópica"));
        estanteriaNovelas.agregarLibro(new Novela("La sombra del viento", "Carlos Ruiz Zafón", 2001, 9788408043643L, "Misterio"));
        estanteriaNovelas.agregarLibro(new Novela("Los miserables", "Victor Hugo", 1862, 9788499897943L, "Histórica"));
        estanteriaNovelas.agregarLibro(new Novela("Rayuela", "Julio Cortázar", 1963, 9788437601720L, "Ficción experimental"));
        estanteriaNovelas.agregarLibro(new Novela("La carretera", "Cormac McCarthy", 2006, 9788433974025L, "Postapocalíptica"));
        estanteriaNovelas.agregarLibro(new Novela("Las uvas de la ira", "John Steinbeck", 1939, 9788445074699L, "Realismo"));
        estanteriaNovelas.agregarLibro(new Novela("Crimen y castigo", "Fyodor Dostoevsky", 1866, 9788420674206L, "Novela psicológica"));
        estanteriaNovelas.agregarLibro(new Novela("La Odisea", "Homero", 1800, 9788491050706L, "Épica"));
        estanteriaNovelas.agregarLibro(new Novela("La isla del tesoro", "Robert Louis Stevenson", 1883, 9788426103302L, "Aventura"));
        estanteriaNovelas.agregarLibro(new Novela("Los detectives salvajes", "Roberto Bolaño", 1998, 9788433969755L, "Narrativa latinoamericana"));
        estanteriaNovelas.agregarLibro(new Novela("Siddhartha", "Hermann Hesse", 1922, 9788499897448L, "Filosófica"));
        estanteriaNovelas.agregarLibro(new Novela("La insoportable levedad del ser", "Milan Kundera", 1984, 9788483832242L, "Filosofía existencial"));
        estanteriaNovelas.agregarLibro(new Novela("Los renglones torcidos de Dios", "Tori Kiersten", 1979, 9786070735154L, "Psicológica"));
        estanteriaNovelas.agregarLibro(new Novela("El amor en los tiempos del cólera", "Gabriel García Márquez", 1985, 9788420471833L, "Romance"));
        estanteriaNovelas.agregarLibro(new Novela("El alquimista", "Paulo Coelho", 1988, 9780062511409L, "Autoayuda"));
        estanteriaNovelas.agregarLibro(new Novela("Memorias de Adriano", "Marguerite Yourcenar", 1951, 9788435008082L, "Histórica"));
        estanteriaNovelas.agregarLibro(new Novela("La ladrona de libros", "Markus Zusak", 2005, 9788498383704L, "Ficción histórica"));
        estanteriaNovelas.agregarLibro(new Novela("El nombre de la rosa", "Umberto Eco", 1980, 9788432217523L, "Misterio"));
        estanteriaNovelas.agregarLibro(new Novela("Pedro Páramo", "Juan Rulfo", 1955, 9786074211479L, "Realismo mágico"));


        model.addColumn("Titulo");
        model.addColumn("Autor");
        model.addColumn("Año");
        model.addColumn("ISBN");


        for (int i = 0; i < estanteriaNovelas.getListaLibros().length; i++) {
            model.addRow(new Object[]{
                    estanteriaNovelas.obtenerUnLibro(i).getTitulo(),
                    estanteriaNovelas.obtenerUnLibro(i).getAutor(),
                    estanteriaNovelas.obtenerUnLibro(i).getAnioPublicacion(),
                    estanteriaNovelas.obtenerUnLibro(i).getISBN()
            });
        }

        tblLibrosEstante.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spnAnio = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnISBN = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnOrdNum_AnioPublic = new javax.swing.JButton();
        btnOrdNum_ISBN = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnOrdString_Titulo = new javax.swing.JButton();
        btnOrdString_Autor = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrosEstante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 167, 54));

        jPanel3.setBackground(new java.awt.Color(204, 167, 54));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Titulo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Autor");

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Año");

        spnAnio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("ISBN");

        spnISBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Agregar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnAnio)
                    .addComponent(spnISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtAutor)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(455, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spnISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton4)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Insertar & Eliminar", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 167, 54));

        btnOrdNum_AnioPublic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrdNum_AnioPublic.setText("Año de Publicación");
        btnOrdNum_AnioPublic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdNum_AnioPublicActionPerformed(evt);
            }
        });

        btnOrdNum_ISBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrdNum_ISBN.setText("ISBN");
        btnOrdNum_ISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdNum_ISBNActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Ordenar Por:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdNum_AnioPublic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrdNum_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(655, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnOrdNum_AnioPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdNum_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Num Ord", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 167, 54));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Ordenar por:");

        btnOrdString_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrdString_Titulo.setText("Titulo");

        btnOrdString_Autor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrdString_Autor.setText("Autor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnOrdString_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOrdString_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(587, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addGap(52, 52, 52)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOrdString_Autor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnOrdString_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("String Ord", jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 167, 54));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Asc & Desc", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 167, 54));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tab4", jPanel7);

        jPanel8.setBackground(new java.awt.Color(204, 167, 54));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tab5", jPanel8);

        jPanel9.setBackground(new java.awt.Color(204, 167, 54));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tab6", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));

        tblLibrosEstante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLibrosEstante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdNum_AnioPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdNum_AnioPublicActionPerformed

        model.setRowCount(0);

        estanteriaNovelas.deBurbuja("anioPublicacion"); // "anioPublicacion
        for (int i = 0; i < estanteriaNovelas.getListaLibros().length; i++) {
            model.addRow(new Object[]{
                    estanteriaNovelas.obtenerUnLibro(i).getTitulo(),
                    estanteriaNovelas.obtenerUnLibro(i).getAutor(),
                    estanteriaNovelas.obtenerUnLibro(i).getAnioPublicacion(),
                    estanteriaNovelas.obtenerUnLibro(i).getISBN()
            });
        }

    }//GEN-LAST:event_btnOrdNum_AnioPublicActionPerformed

    private void btnOrdNum_ISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdNum_ISBNActionPerformed


        model.setRowCount(0);

        estanteriaNovelas.deBurbuja("ISBN");
        for (int i = 0; i < estanteriaNovelas.getListaLibros().length; i++) {
            model.addRow(new Object[]{
                    estanteriaNovelas.obtenerUnLibro(i).getTitulo(),
                    estanteriaNovelas.obtenerUnLibro(i).getAutor(),
                    estanteriaNovelas.obtenerUnLibro(i).getAnioPublicacion(),
                    estanteriaNovelas.obtenerUnLibro(i).getISBN()
            });
        }

    }//GEN-LAST:event_btnOrdNum_ISBNActionPerformed

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
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrdNum_AnioPublic;
    private javax.swing.JButton btnOrdNum_ISBN;
    private javax.swing.JButton btnOrdString_Autor;
    private javax.swing.JButton btnOrdString_Titulo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnISBN;
    private javax.swing.JTable tblLibrosEstante;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
