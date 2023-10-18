/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import CONTROL.ControlEstanteria;

import CONTROL.ListaEnlazadaDoble;
import MODELO.CLASIFICACION.Novela;
import CONTROL.Nodo;
import MODELO.Libro;
import MODELO.Persona_2;
import MODELO.Proceso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CONTROL.*;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Leo
 */
public class Avance2Form extends javax.swing.JFrame {

    /**
     * Creates new form Biblioteca
     */
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    DefaultTableModel model = new DefaultTableModel();
    ControlEstanteria<Novela> estanteriaNovelas = new ControlEstanteria();
    ListaEnlazadaDoble<Novela> listalibro = new ListaEnlazadaDoble();
    PersonaColaPrioridadLinkedList colaPersonas = new PersonaColaPrioridadLinkedList();

    public Avance2Form() {

        initComponents();
        datosPruebaEnTabla();
        guardarEnFichero(estanteriaNovelas);
        llenaListaEnlazadaDoble();


        tblLibrosEstante.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent presionar){
                JTable tabla = (JTable) presionar.getSource();
                Point point = presionar.getPoint();
                int row = tabla.rowAtPoint(point);
                if (presionar.getClickCount() == 1) {
                    txtFrase.setText(tblLibrosEstante.getValueAt(tblLibrosEstante.getSelectedRow(),0).toString());
                }
            }
        });
    }

    public void guardarEnFichero(ControlEstanteria estanteria) {

        try (PrintWriter pw = new PrintWriter(new File("src/main/java/estanteriaNovelas.json"))) {

            pw.write(gson.toJson(estanteria.getListaLibros()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rellenarTabla() {
        Libro[] novelas = estanteriaNovelas.getListaLibros();
        for (int i = 0; i < novelas.length; i++) {
            Novela novela = (Novela) novelas[i];
            model.addRow(new Object[]{
                novela.getTitulo(),
                novela.getAutor(),
                novela.getAnioPublicacion(),
                novela.getISBN(),
                novela.getGenero()
            });
        }
    }

    public void rellenarTabla2(ListaEnlazadaDoble lista) {
        model.setRowCount(0);
        Nodo actual = lista.getCabeza();
        while (actual != null) {
            Novela novela = actual.getNovela();
            model.addRow(new Object[]{
                novela.getTitulo(),
                novela.getAutor(),
                novela.getAnioPublicacion(),
                novela.getISBN(),
                novela.getGenero()
            });
            actual = actual.getSiguiente();
        }
    }

    public void llenaListaEnlazadaDoble() {
        for (int row = 0; row < model.getRowCount(); row++) {
            String tempTitulo = model.getValueAt(row, 0).toString();
            String tempAutor = model.getValueAt(row, 1).toString();
            int tempAño = Integer.parseInt(model.getValueAt(row, 2).toString());
            long tempIsbn = Long.parseLong(model.getValueAt(row, 3).toString());
            String tempGenero = model.getValueAt(row, 4).toString();

            Novela tempNovela = new Novela(tempTitulo, tempAutor, tempAño, tempIsbn, tempGenero);
            if (!listalibro.contieneNovela(tempNovela)) {
                listalibro.insertarOrdenado(tempNovela);
            }
        }
    }

    public void datosPruebaEnTabla() {

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
        model.addColumn("Genero");

        rellenarTabla();

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
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnEliminarLibro = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxBuscarLibros = new javax.swing.JComboBox<>();
        txtBuscarLibros = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        btnAgregarLibro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnOrdNum_AnioPublic = new javax.swing.JButton();
        btnOrdNum_ISBN = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnOrdString_Titulo = new javax.swing.JButton();
        btnOrdString_Autor = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAscDes = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtAnio2Filter = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGenro2Filter = new javax.swing.JTextField();
        btnBuscar2Filter = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnEliminarLibroPre1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtEliminarLibrosPre1 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtAnioPre1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTituloPre1 = new javax.swing.JTextField();
        txtAutorPre1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtISBNPre1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtGeneroPre1 = new javax.swing.JTextField();
        btnAgregarLibroPre1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtNombrePre2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtEdadPre2 = new javax.swing.JTextField();
        btnAgregarPersona = new javax.swing.JButton();
        btnAtenderPersona = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtF_tiempoTareaManual = new javax.swing.JTextField();
        btn_tiempoTareaManual = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtF_generarNtareasAleatorias = new javax.swing.JTextField();
        btn_generarNtareasAleatorias = new javax.swing.JButton();
        btn_detenerProcesos = new javax.swing.JButton();
        btn_continuarProcesos = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtF_segundoPorProceso = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtFrase = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCola = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtConsonante = new javax.swing.JTextField();
        txtVocales = new javax.swing.JTextField();
        txtValores = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibrosEstante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 167, 54));

        jTabbedPane3.setBackground(new java.awt.Color(204, 167, 54));

        jPanel16.setBackground(new java.awt.Color(204, 167, 54));

        jTabbedPane2.setBackground(new java.awt.Color(255, 204, 102));

        jPanel3.setBackground(new java.awt.Color(204, 167, 54));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Añadir Libro");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Eliminar Libro");

        btnEliminarLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarLibro.setText("Eliminar");
        btnEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibroActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Buscar por:");

        cbxBuscarLibros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxBuscarLibros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titulo", "Autor", "ISBN", "Genero", "Año" }));
        cbxBuscarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBuscarLibrosActionPerformed(evt);
            }
        });

        txtBuscarLibros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarLibros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarLibrosKeyTyped(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(204, 167, 54));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Año");

        txtAnio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Titulo");

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Autor");

        txtISBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("ISBN");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Genero");

        txtGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAgregarLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarLibro.setText("Agregar");
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtISBN)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAutor)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarLibro))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(369, 369, 369))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbxBuscarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxBuscarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(btnEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Insertar & Eliminar", jPanel3);

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
                .addContainerGap(740, Short.MAX_VALUE))
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
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Num Ord", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 167, 54));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Ordenar por:");

        btnOrdString_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrdString_Titulo.setText("Titulo");
        btnOrdString_Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdString_TituloActionPerformed(evt);
            }
        });

        btnOrdString_Autor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrdString_Autor.setText("Autor");
        btnOrdString_Autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdString_AutorActionPerformed(evt);
            }
        });

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
                .addContainerGap(672, Short.MAX_VALUE))
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
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("String Ord", jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 167, 54));

        btnAscDes.setText("Asc & Desc");
        btnAscDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscDesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btnAscDes, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(744, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnAscDes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Asc & Desc", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 167, 54));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Año");

        txtAnio2Filter.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAnio2Filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnio2FilterKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Genero");

        txtGenro2Filter.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtGenro2Filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGenro2FilterKeyTyped(evt);
            }
        });

        btnBuscar2Filter.setText("Buscar");
        btnBuscar2Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2FilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGenro2Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnio2Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(137, 137, 137)
                .addComponent(btnBuscar2Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(513, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnBuscar2Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtGenro2Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtAnio2Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("2 Filtros Busqueda", jPanel7);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane3.addTab("Primer Avance", jPanel16);

        jPanel8.setBackground(new java.awt.Color(204, 167, 54));

        jTabbedPane1.setBackground(new java.awt.Color(255, 204, 102));

        jPanel9.setBackground(new java.awt.Color(255, 204, 102));

        jPanel14.setBackground(new java.awt.Color(255, 204, 102));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Añadir Libro");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Eliminar Libro");

        btnEliminarLibroPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarLibroPre1.setText("Eliminar");
        btnEliminarLibroPre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibroPre1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Escribir titulo del libro:");

        txtEliminarLibrosPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEliminarLibrosPre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEliminarLibrosPre1KeyTyped(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 204, 102));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Año");

        txtAnioPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Titulo");

        txtTituloPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTituloPre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloPre1ActionPerformed(evt);
            }
        });

        txtAutorPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Autor");

        txtISBNPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setText("ISBN");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("Genero");

        txtGeneroPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAgregarLibroPre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarLibroPre1.setText("Agregar");
        btnAgregarLibroPre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroPre1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtISBNPre1)
                            .addComponent(txtAnioPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGeneroPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarLibroPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAutorPre1)
                        .addComponent(txtTituloPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTituloPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtAnioPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtAutorPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtISBNPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtGeneroPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarLibroPre1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(369, 369, 369))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarLibroPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEliminarLibrosPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEliminarLibrosPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnEliminarLibroPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(137, Short.MAX_VALUE))))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13)
                .addGap(37, 37, 37)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 43, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Pregunta1", jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 204, 102));

        jLabel35.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel35.setText("Ingrese nombre");

        txtNombrePre2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel36.setText("Ingrese edad");

        txtEdadPre2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        btnAgregarPersona.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnAgregarPersona.setText("Agregar persona");
        btnAgregarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPersonaActionPerformed(evt);
            }
        });

        btnAtenderPersona.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnAtenderPersona.setText("Atender persona");
        btnAtenderPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderPersonaActionPerformed(evt);
            }
        });

        jButton1.setText("Cargar tabla libros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel35))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombrePre2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdadPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtenderPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(427, 427, 427))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtNombrePre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPersona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEdadPre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtenderPersona))
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(72, 72, 72))
        );

        jTabbedPane1.addTab("Pregunta2", jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 204, 102));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setText("Simulacion de procesamiento");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setText("Tiempo de tarea:");

        btn_tiempoTareaManual.setText("Añadir tarea");
        btn_tiempoTareaManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tiempoTareaManualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_tiempoTareaManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(27, 27, 27)
                        .addComponent(txtF_tiempoTareaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtF_tiempoTareaManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tiempoTareaManual)
                .addGap(19, 19, 19))
        );

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setText("Cantidad de Tareas:");

        btn_generarNtareasAleatorias.setText("jButton2");
        btn_generarNtareasAleatorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarNtareasAleatoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_generarNtareasAleatorias, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtF_generarNtareasAleatorias, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtF_generarNtareasAleatorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_generarNtareasAleatorias)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btn_detenerProcesos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_detenerProcesos.setText("Detener");
        btn_detenerProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detenerProcesosActionPerformed(evt);
            }
        });

        btn_continuarProcesos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_continuarProcesos.setText("Continuar");
        btn_continuarProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_continuarProcesosActionPerformed(evt);
            }
        });

        jLabel34.setText("Segundos por proceso:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(btn_detenerProcesos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_continuarProcesos))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(txtF_segundoPorProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtF_segundoPorProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_detenerProcesos)
                            .addComponent(btn_continuarProcesos))))
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pregunta3", jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 204, 102));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Titulo Seleccionado");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setText("Frase");
        jLabel22.setToolTipText("");

        txtFrase.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Frase");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setText("Cola");

        txtCola.setEditable(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Consonantes");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Vocales");
        jLabel27.setToolTipText("");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setText("Valores");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setText("Pila");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel29.setText("Pila");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel30.setText("Pila");

        txtConsonante.setEditable(false);
        txtConsonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsonanteActionPerformed(evt);
            }
        });

        txtVocales.setEditable(false);

        txtValores.setEditable(false);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jButton2.setText("Cargar tabla libros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIngresar)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton2)))
                .addGap(109, 109, 109)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCola, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel30)))
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtConsonante)
                                    .addComponent(txtVocales)
                                    .addComponent(txtValores, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)))
                .addGap(88, 88, 88))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtVocales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtConsonante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 59, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtFrase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pregunta4", jPanel13);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane3.addTab("Segundo Avance", jPanel8);

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

        tblLibrosEstante.setBackground(new java.awt.Color(204, 181, 66));
        tblLibrosEstante.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblLibrosEstante.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jScrollPane1.setViewportView(tblLibrosEstante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdNum_AnioPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdNum_AnioPublicActionPerformed

        model.setRowCount(0);

        estanteriaNovelas.deBurbuja("anioPublicacion"); // "anioPublicacion
        rellenarTabla();

    }//GEN-LAST:event_btnOrdNum_AnioPublicActionPerformed

    private void btnOrdNum_ISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdNum_ISBNActionPerformed

        model.setRowCount(0);

        estanteriaNovelas.deBurbuja("ISBN");
        rellenarTabla();

    }//GEN-LAST:event_btnOrdNum_ISBNActionPerformed

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed

        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String genero = txtGenero.getText();
        String anioStr = txtAnio.getText();
        String isbnStr = txtISBN.getText();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa al menos un carácter en el campo de título.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa al menos un carácter en el campo de autor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa al menos un carácter en el campo de género.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (anioStr.length() != 4 || !anioStr.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Ingresa un año válido (4 dígitos numéricos).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un año válido (número entero).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long ISBN;
        try {
            ISBN = Long.parseLong(isbnStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un ISBN válido (número entero).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Novela nuevaNovela = new Novela(titulo, autor, anio, ISBN, genero);
        estanteriaNovelas.agregarLibro(nuevaNovela);

        model.addRow(new Object[]{
            nuevaNovela.getTitulo(),
            nuevaNovela.getAutor(),
            nuevaNovela.getAnioPublicacion(),
            nuevaNovela.getISBN(),
            nuevaNovela.getGenero()
        });


    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void cbxBuscarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBuscarLibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxBuscarLibrosActionPerformed

    private void btnEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroActionPerformed

        int filaSeleccionada = tblLibrosEstante.getSelectedRow();
        long isbn = Long.parseLong(tblLibrosEstante.getValueAt(filaSeleccionada, 3).toString());

        estanteriaNovelas.removerLibro(estanteriaNovelas.obtenerUnLibro(isbn));

        model.removeRow(filaSeleccionada);

    }//GEN-LAST:event_btnEliminarLibroActionPerformed

    private void btnOrdString_TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdString_TituloActionPerformed

        model.setRowCount(0);

        estanteriaNovelas.porSeleccion_String("titulo");
        rellenarTabla();
    }//GEN-LAST:event_btnOrdString_TituloActionPerformed

    private void btnOrdString_AutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdString_AutorActionPerformed

        model.setRowCount(0);

        estanteriaNovelas.deBurbuja("autor");
        rellenarTabla();
    }//GEN-LAST:event_btnOrdString_AutorActionPerformed

    private void txtBuscarLibrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarLibrosKeyTyped
        //busqueda secuencial
        String atributo = cbxBuscarLibros.getSelectedItem().toString();
        String valor = txtBuscarLibros.getText();

        if (atributo.equals("ISBN")) {
            model.setRowCount(0);

            Libro[] encontrado = estanteriaNovelas.busquedaSecuencial(atributo, valor);

            for (int i = 0; i < encontrado.length; i++) {
                Novela novela = (Novela) encontrado[i];
                model.addRow(new Object[]{
                    novela.getTitulo(),
                    novela.getAutor(),
                    novela.getAnioPublicacion(),
                    novela.getISBN(),
                    novela.getGenero()
                });
            }
        }

        if (atributo.equals("Titulo")) {

            model.setRowCount(0);

            Libro[] encontrado = estanteriaNovelas.busquedaSecuencial(atributo, valor);

            for (int i = 0; i < encontrado.length; i++) {
                Novela novela = (Novela) encontrado[i];
                model.addRow(new Object[]{
                    novela.getTitulo(),
                    novela.getAutor(),
                    novela.getAnioPublicacion(),
                    novela.getISBN(),
                    novela.getGenero()
                });
            }
        }

        if (atributo.equals("Autor")) {

            model.setRowCount(0);

            Libro[] encontrado = estanteriaNovelas.busquedaSecuencial(atributo, valor);

            for (int i = 0; i < encontrado.length; i++) {
                Novela novela = (Novela) encontrado[i];
                model.addRow(new Object[]{
                    novela.getTitulo(),
                    novela.getAutor(),
                    novela.getAnioPublicacion(),
                    novela.getISBN(),
                    novela.getGenero()
                });
            }
        }
        if (atributo.equals("Genero")) {

            model.setRowCount(0);

            Libro[] encontrado = estanteriaNovelas.busquedaSecuencial(atributo, valor);

            for (int i = 0; i < encontrado.length; i++) {
                Novela novela = (Novela) encontrado[i];
                model.addRow(new Object[]{
                    novela.getTitulo(),
                    novela.getAutor(),
                    novela.getAnioPublicacion(),
                    novela.getISBN(),
                    novela.getGenero()
                });
            }
        }
        if (atributo.equals("Año")) {

            model.setRowCount(0);

            Libro[] encontrado = estanteriaNovelas.busquedaSecuencial(atributo, valor);

            for (int i = 0; i < encontrado.length; i++) {
                Novela novela = (Novela) encontrado[i];
                model.addRow(new Object[]{
                    novela.getTitulo(),
                    novela.getAutor(),
                    novela.getAnioPublicacion(),
                    novela.getISBN(),
                    novela.getGenero()
                });
            }
        }


    }//GEN-LAST:event_txtBuscarLibrosKeyTyped

    private void btnAscDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscDesActionPerformed
        //burbuja ascendente seleccion descendente
        model.setRowCount(0);

        estanteriaNovelas.ordenarNovelaPorGeneroYAnioPublicacion();
        rellenarTabla();


    }//GEN-LAST:event_btnAscDesActionPerformed

    private void txtAnio2FilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnio2FilterKeyTyped

    }//GEN-LAST:event_txtAnio2FilterKeyTyped

    private void txtGenro2FilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGenro2FilterKeyTyped

        String Genero = txtGenro2Filter.getText();

        model.setRowCount(0);

        Libro[] encontradoGenero = estanteriaNovelas.busquedaSecuencial("Genero", Genero);

        for (int i = 0; i < encontradoGenero.length; i++) {
            Novela novela = (Novela) encontradoGenero[i];
            model.addRow(new Object[]{
                novela.getTitulo(),
                novela.getAutor(),
                novela.getAnioPublicacion(),
                novela.getISBN(),
                novela.getGenero()
            });
        }

    }//GEN-LAST:event_txtGenro2FilterKeyTyped

    private void btnBuscar2FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2FilterActionPerformed

        String Año = txtAnio2Filter.getText();
        String Genero = txtGenro2Filter.getText();

        if (Genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa al menos un carácter en el campo de género.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Año.length() != 4) {
            JOptionPane.showMessageDialog(this, "El año debe tener exactamente 4 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        model.setRowCount(0);

        // Realiza una búsqueda secuencial por género
        Libro[] generosEncontradosLibro = estanteriaNovelas.busquedaSecuencial("Genero", Genero);
        Novela[] encontradoGenero = new Novela[generosEncontradosLibro.length];
        for (int i = 0; i < generosEncontradosLibro.length; i++) {
            encontradoGenero[i] = (Novela) generosEncontradosLibro[i];
        }

        // Realiza una búsqueda binaria por año
        Libro[] encontradoAño = estanteriaNovelas.busquedaBinariaSeleccion("Año", Año);

        for (int i = 0; i < encontradoGenero.length; i++) {
            for (int j = 0; j < encontradoAño.length; j++) {
                if (encontradoGenero[i].equals(encontradoAño[j])) {
                    Novela novela = (Novela) encontradoGenero[i];
                    model.addRow(new Object[]{
                        novela.getTitulo(),
                        novela.getAutor(),
                        novela.getAnioPublicacion(),
                        novela.getISBN(),
                        novela.getGenero()
                    });
                }
            }
        }

    }//GEN-LAST:event_btnBuscar2FilterActionPerformed

    private void btnEliminarLibroPre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroPre1ActionPerformed
        // TODO add your handling code here:
        String titulo = txtEliminarLibrosPre1.getText();
        listalibro.borrarPorTitulo(titulo);
        rellenarTabla2(listalibro);

    }//GEN-LAST:event_btnEliminarLibroPre1ActionPerformed

    private void txtEliminarLibrosPre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEliminarLibrosPre1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEliminarLibrosPre1KeyTyped

    private void btnAgregarLibroPre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroPre1ActionPerformed
        // TODO add your handling code here:
        try {

            String titulo = txtTituloPre1.getText();
            String autor = txtAutorPre1.getText();
            String genero = txtGeneroPre1.getText();
            String añoStr = txtAnioPre1.getText();
            String isbnStr = txtISBNPre1.getText();

            if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || añoStr.isEmpty() || isbnStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (añoStr.length() != 4 || !añoStr.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Ingresa un año válido (4 dígitos numéricos).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int año;
            try {
                año = Integer.parseInt(añoStr);
                if (año < 0) {
                    JOptionPane.showMessageDialog(this, "Ingresa un año válido (mayor o igual a 0).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingresa un año válido (número entero).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            long isbn;
            try {
                isbn = Long.parseLong(isbnStr);
                if (isbn < 0) {
                    JOptionPane.showMessageDialog(this, "Ingresa un ISBN válido (mayor o igual a 0).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingresa un ISBN válido (número entero).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Novela nov = new Novela(titulo, autor, año, isbn, genero);

            if (!listalibro.contieneNovela(nov)) {
                listalibro.insertarOrdenado(nov);
            }
            // Limpiar los campos del formulario
            txtAnioPre1.setText("");
            txtTituloPre1.setText("");
            txtAutorPre1.setText("");
            txtGeneroPre1.setText("");
            txtISBNPre1.setText("");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        rellenarTabla2(listalibro);
    }//GEN-LAST:event_btnAgregarLibroPre1ActionPerformed

    private void txtTituloPre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloPre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloPre1ActionPerformed

    private void txtConsonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsonanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsonanteActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
       
        String frase = txtFrase.getText(); // Obtenemos el titulo clikeado
        
        ColaCaracteres cola = new ColaCaracteres();
        ConsonantesVocales comprobar = new ConsonantesVocales();
        
        PilaCaracteres consonantes = new PilaCaracteres();
        PilaCaracteres vocales = new PilaCaracteres();
        PilaCaracteres valores= new PilaCaracteres();
        
////////////////////////////////////// Rellenado de Cola ///////////////////////

        for (int i = 0; i < frase.length(); i++) {
            
            char c = frase.charAt(i);

            if (c != ' ') {
                cola.encolar(c);
            } 
        }
        
//////////////////////////////// Desencolar y apilado //////////////////////////

        String fraseCola = "";
        
        while (cola.getFrente() != null) {
            
            char c = cola.desencolar(); // aprovecho el desencolar para derivar y comprobar los caracteres a sus respectivas PILAS 
            fraseCola += c;
            
            if (comprobar.isConsonant(c) && !comprobar.isVowel(c)) {
                
                consonantes.apilar(c);
                
            }else if (comprobar.isVowel(c)) {
                
                vocales.apilar(c);
                
            }else{
                
                valores.apilar(c);
                
            }            
             System.out.print(c);
        }
//////////////////////////////// Desapilado ////////////////////////////////////

        String fraseConsonantes = "";
        String fraseVocales = "";
        String fraseValores = "";
        
        for (int i = 0; i < fraseCola.length(); i++) {
            
            if (consonantes.getCima()!=null) {
                fraseConsonantes +=consonantes.desapilar();
            }
            if (vocales.getCima()!=null) {
                fraseVocales += vocales.desapilar();
            }
            if (valores.getCima()!=null) {
                fraseValores += valores.desapilar();
            }
        }
//////////////////////////////// Mostrar Datos en los texField /////////////////

        txtCola.setText(fraseCola);
        txtConsonante.setText(fraseConsonantes);
        txtVocales.setText(fraseVocales);
        txtValores.setText(fraseValores);
    }//GEN-LAST:event_btnIngresarActionPerformed



    ColaDeProcesos simulacion = new ColaDeProcesos();

    private void btn_detenerProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detenerProcesosActionPerformed

        simulacion.setContinuar(false);
        //simulacion.switchProcesado(0);

    }//GEN-LAST:event_btn_detenerProcesosActionPerformed

    private void btn_continuarProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_continuarProcesosActionPerformed

        simulacion.setContinuar(true);
        simulacion.switchProcesado(Integer.parseInt(txtF_segundoPorProceso.getText()));

        // simular los procesos en la tabla tblLibrosEstante
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (simulacion.getContinuar()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    model.setRowCount(0);

                    Proceso[] array = simulacion.imprimir();

                    // borrar columnas y colocar solo las que necesitamos
                    model.setColumnCount(0);
                    model.addColumn("Nombre");
                    model.addColumn("Tiempo Restante");


                    //añadir a la tabla el nombre y el tiempo de cada proceso
                    for (int i = 0; i < array.length; i++) {

                        model.addRow(new Object[]{
                            "Proceso "+array[i].getNombre(),
                            array[i].getTiempoRestante()
                        });
                    }


                }
            }
        }).start();

    }//GEN-LAST:event_btn_continuarProcesosActionPerformed

    private void btn_tiempoTareaManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tiempoTareaManualActionPerformed

        simulacion.agregarProceso(new Proceso(Integer.parseInt(txtF_tiempoTareaManual.getText())));

        model.setRowCount(0);

        Proceso[] array = simulacion.imprimir();

        model.setColumnCount(0);
        model.addColumn("Nombre");
        model.addColumn("Tiempo Restante");

        for (int i = 0; i < array.length; i++) {
            model.addRow(new Object[]{
                "Proceso "+ array[i].getNombre(),
                array[i].getTiempoRestante()
            });

        }

    }//GEN-LAST:event_btn_tiempoTareaManualActionPerformed

    private void btn_generarNtareasAleatoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarNtareasAleatoriasActionPerformed

        // se generan n tareas aleatorias por lo que le pasemos por parametro
        int n = Integer.parseInt(txtF_generarNtareasAleatorias.getText());
        for (int i = 0; i < n; i++) {
            simulacion.agregarProceso(new Proceso((int) (Math.random() * 5) + 1)); // podriamos pasale por parametro el intervalo de tiempo
        }

        model.setRowCount(0);

        Proceso[] array = simulacion.imprimir();

        model.setColumnCount(0);
        model.addColumn("Nombre");
        model.addColumn("Tiempo Restante");

        for (int i = 0; i < array.length; i++) {
            model.addRow(new Object[]{
                "Proceso "+ array[i].getNombre(),
                array[i].getTiempoRestante()
            });

        }

    }//GEN-LAST:event_btn_generarNtareasAleatoriasActionPerformed

    private void btnAgregarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPersonaActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombrePre2.getText();
        int edad = Integer.parseInt(txtEdadPre2.getText());

        colaPersonas.insertarPersona(new Persona_2(nombre, edad));

        txtNombrePre2.setText("");
        txtEdadPre2.setText("");
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Persona");
        model.addColumn("Edad");

        String personasString = colaPersonas.mostrarPersonas();

        String[] personasArray = personasString.split(";");

        for (String persona : personasArray) {
            String[] datosPersona = persona.split(" ");
            model.addRow(datosPersona);
        }
    }//GEN-LAST:event_btnAgregarPersonaActionPerformed

    private void btnAtenderPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderPersonaActionPerformed
        // TODO add your handling code here:
        colaPersonas.atenderPersona();

        model.setRowCount(0);

        model.setColumnCount(0);
        model.addColumn("Persona");
        model.addColumn("Edad");

        String personasString = colaPersonas.mostrarPersonas();

        String[] personasArray = personasString.split(";");

        for (String persona : personasArray) {
            String[] datosPersona = persona.split(" ");
            model.addRow(datosPersona);
        }
    }//GEN-LAST:event_btnAtenderPersonaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        model.setColumnCount(0);
        datosPruebaEnTabla();
        guardarEnFichero(estanteriaNovelas);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        model.setColumnCount(0);
        datosPruebaEnTabla();
        guardarEnFichero(estanteriaNovelas);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Avance2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avance2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avance2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avance2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Avance2Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnAgregarLibroPre1;
    private javax.swing.JButton btnAgregarPersona;
    private javax.swing.JButton btnAscDes;
    private javax.swing.JButton btnAtenderPersona;
    private javax.swing.JButton btnBuscar2Filter;
    private javax.swing.JButton btnEliminarLibro;
    private javax.swing.JButton btnEliminarLibroPre1;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnOrdNum_AnioPublic;
    private javax.swing.JButton btnOrdNum_ISBN;
    private javax.swing.JButton btnOrdString_Autor;
    private javax.swing.JButton btnOrdString_Titulo;
    private javax.swing.JButton btn_continuarProcesos;
    private javax.swing.JButton btn_detenerProcesos;
    private javax.swing.JButton btn_generarNtareasAleatorias;
    private javax.swing.JButton btn_tiempoTareaManual;
    private javax.swing.JComboBox<String> cbxBuscarLibros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tblLibrosEstante;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAnio2Filter;
    private javax.swing.JTextField txtAnioPre1;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtAutorPre1;
    private javax.swing.JTextField txtBuscarLibros;
    private javax.swing.JTextField txtCola;
    private javax.swing.JTextField txtConsonante;
    private javax.swing.JTextField txtEdadPre2;
    private javax.swing.JTextField txtEliminarLibrosPre1;
    private javax.swing.JTextField txtF_generarNtareasAleatorias;
    private javax.swing.JTextField txtF_segundoPorProceso;
    private javax.swing.JTextField txtF_tiempoTareaManual;
    private javax.swing.JTextField txtFrase;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtGeneroPre1;
    private javax.swing.JTextField txtGenro2Filter;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtISBNPre1;
    private javax.swing.JTextField txtNombrePre2;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTituloPre1;
    private javax.swing.JTextField txtValores;
    private javax.swing.JTextField txtVocales;
    // End of variables declaration//GEN-END:variables
}
