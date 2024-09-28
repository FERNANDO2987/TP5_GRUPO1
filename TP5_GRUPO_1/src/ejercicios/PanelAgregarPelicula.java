package ejercicios;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PanelAgregarPelicula extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private DefaultListModel<Pelicula> listModel;
    private JComboBox<Categoria> cmbGenero;
    private static int peliculaID = 1;

    /**
     * Create the panel.
     */
    public PanelAgregarPelicula() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("ID");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 3;
        gbc_lblNewLabel.gridy = 2;
        add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel(String.valueOf(Pelicula.devuelveProximoID()));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 7;
        gbc_lblNewLabel_2.gridy = 2;
        add(lblNewLabel_2, gbc_lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 3;
        gbc_lblNewLabel_1.gridy = 4;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 7;
        gbc_textField.gridy = 4;
        add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblGenero = new JLabel("Genero");
        GridBagConstraints gbc_lblGenero = new GridBagConstraints();
        gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
        gbc_lblGenero.anchor = GridBagConstraints.WEST;
        gbc_lblGenero.gridx = 3;
        gbc_lblGenero.gridy = 6;
        add(lblGenero, gbc_lblGenero);

        // Combo Box
        cmbGenero = new JComboBox<>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 7;
        gbc_comboBox.gridy = 6;
        add(cmbGenero, gbc_comboBox);

        // Agregar categor�as al combobox
        Categoria cat1 = new Categoria(1, "Terror");
        Categoria cat2 = new Categoria(2, "Acci�n");
        Categoria cat3 = new Categoria(3, "Suspenso");
        Categoria cat4 = new Categoria(4, "Rom�ntica");
        cmbGenero.addItem(cat1);
        cmbGenero.addItem(cat2);
        cmbGenero.addItem(cat3);
        cmbGenero.addItem(cat4);

        JButton btnNewButton = new JButton("Aceptar");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridwidth = 4;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 3;
        gbc_btnNewButton.gridy = 8;
        add(btnNewButton, gbc_btnNewButton);

        // Validar
        btnNewButton.addActionListener(e -> {
            if (validarYGuardar()) { 
                
                Pelicula nuevaPelicula = new Pelicula(Pelicula.devuelveProximoID(), textField.getText(), (Categoria) cmbGenero.getSelectedItem());

                // Agregar la pel�cula
                if (listModel != null) {
                    listModel.addElement(nuevaPelicula);
                }

                // Mostrar mensaje
                JOptionPane.showMessageDialog(this, "Pel�cula agregada exitosamente!", "Confirmaci�n", JOptionPane.INFORMATION_MESSAGE);

             // Incrementar el ID para la pr�xima pel�cula
				peliculaID++;
				lblNewLabel_2.setText(String.valueOf(peliculaID)); 
                // Limpiar los campos
                textField.setText("");
                cmbGenero.setSelectedIndex(0);
            }
        });
    }

    // M�todo de validaci�n 
    private boolean validarYGuardar() {
        if (textField == null || cmbGenero == null) {
            JOptionPane.showMessageDialog(this, "Error: los componentes no se han inicializado correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String nombrePelicula = textField.getText();
        Categoria selectedGenero = (Categoria) cmbGenero.getSelectedItem();

        if (nombrePelicula == null || nombrePelicula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la pel�cula no puede estar vac�o.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (selectedGenero == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un g�nero v�lido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public DefaultListModel<Pelicula> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<Pelicula> listModel) {
        this.listModel = listModel;
    }
}
