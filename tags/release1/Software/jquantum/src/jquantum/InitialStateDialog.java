/*
 * InitialStateDialog.java - Dialog class of the jQuantum computer simulator
 *
 * Copyright (C) 2004-2008 Andreas de Vries
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses
 * or write to the Free Software Foundation,Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA 02110-1301  USA
 */
package jquantum;
//import java.util.Locale;
import java.util.Properties;
import javax.swing.*;
/**
 * This class enables a dialog frame to set the initial state of a quantum circuit.
 * @author  Andreas de Vries
 * @version 1.3
 */
public class InitialStateDialog extends javax.swing.JDialog {
    private static final long serialVersionUID = -979511435;
    //private String language;
    private Properties bundle;
    /** Flag indicating whether the cancel button has been pressed.*/
    public boolean cancelButtonClicked;
    private String toggleTip;
    /** The array of the qubit values. */
    private int[] qubits;
    private int[] row;

    /** Creates new form InitialStateDialog */
    public InitialStateDialog(java.awt.Frame parent, boolean modal, Properties bundle,
           int[] qubits, int xRegisterSize
    ) {
        super(parent, modal);
        this.bundle = bundle;
        this.cancelButtonClicked = false;
        this.qubits = qubits;        
        this.toggleTip = bundle.getProperty("InitialStateDialog.toggleTip");
        
        try {
           UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
           if ( UIManager.getSystemLookAndFeelClassName().equals( "javax.swing.plaf.metal.MetalLookAndFeel" ) ) {
              UIManager.setLookAndFeel( "com.sun.java.swing.plaf.motif.MotifLookAndFeel" );
           }
        } catch ( Exception e ) {
           //System.err.println( "Look & Feel Error: " + e.toString() );
        }
        
        initComponents();
        questionLabel.setText(bundle.getProperty("InitialStateDialog.questionLabel.text"));
        okButton.setText(bundle.getProperty("okButton.text"));
        cancelButton.setText(bundle.getProperty("cancelButton.text"));

        row = new int[2];
        row[0] = xRegisterSize;
        row[1] = qubits.length - xRegisterSize;
        int max = row[0];
        if ( row[1] > max )  max = row[1];
 
        qubitPanel = new javax.swing.JPanel[2][ max ];
        qubitLabel = new javax.swing.JLabel();
        qubitToggleButton = new JToggleButton[2][ max ];
        for ( int i = 0; i < row.length; i++ ) {          
          for ( int j = 0; j < row[i]; j++ ) {
            qubitPanel[i][j] = new javax.swing.JPanel();

            if ( j == 0 ) {
              qubitLabel = new javax.swing.JLabel();
              if ( i == 0 ) { // first row represents the x-register
                qubitLabel.setText("|x>  =  |");
              } else { // there is only one further row: the y-register
                qubitLabel.setText("|y>  =  |");
              }
              qubitPanel[i][j].add(qubitLabel);
            }

            qubitToggleButton[i][j] = new JToggleButton();
            qubitToggleButton[i][j].setPreferredSize(new java.awt.Dimension(60, 50));
            qubitToggleButton[i][j].setToolTipText(toggleTip);
            if ( i == 0 ) {
               qubitToggleButton[i][j].setText( ""+qubits[j] );
               if (qubits[j] == 1) qubitToggleButton[i][j].setSelected(true);
            } else {
               qubitToggleButton[i][j].setText( ""+qubits[row[0] + j] );
               if (qubits[row[0] + j] == 1) qubitToggleButton[i][j].setSelected(true);
            }
            
            qubitToggleButton[i][j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    qubitToggleButtonActionPerformed(evt);
                }
            });

            qubitToggleButton[i][j].addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
				public void keyPressed(java.awt.event.KeyEvent evt) {
                    qubitToggleButtonKeyPressed(evt);
                }
            });

            qubitPanel[i][j].add(qubitToggleButton[i][j]);

            if ( j == row[i] - 1 ) {
              qubitLabel = new javax.swing.JLabel();
              qubitLabel.setText(">");
              qubitPanel[i][j].add(qubitLabel);
            }

            if ( i == 0) {
              xPanel.add(qubitPanel[i][j]);
            } else {
              yPanel.add(qubitPanel[i][j]);
            }
          }
        }
        
        pack();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width  - getSize().width )/2,
                    (screenSize.height - getSize().height)/2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        headPanel = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        xPanel = new javax.swing.JPanel();
        yPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        questionLabel.setText("Input the initial qubit state:");
        headPanel.add(questionLabel);

        getContentPane().add(headPanel, java.awt.BorderLayout.NORTH);

        inputPanel.setLayout(new java.awt.BorderLayout());

        inputPanel.setBorder(new javax.swing.border.EtchedBorder());
        xPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        inputPanel.add(xPanel, java.awt.BorderLayout.NORTH);

        yPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        inputPanel.add(yPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(inputPanel, java.awt.BorderLayout.CENTER);

        okButton.setText(" OK ");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(okButton);

        cancelButton.setText(" Cancel ");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void qubitToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JToggleButton toggleButton = (JToggleButton) evt.getSource();
        if ( toggleButton.getText().equals("0") ) {
            toggleButton.setText("1");
        } else {
            toggleButton.setText("0");
        }
    }

    private void qubitToggleButtonKeyPressed(java.awt.event.KeyEvent evt) {                                          
        if( evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            setValues();
        }
    }                                         

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancelButtonClicked = true;
        setVisible(false);
        removeAll();
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setValues();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Returns the qubit values.
     * @return the qubit values
     */
    public int[] getQubits() {
        return qubits;
    }

    private void setValues() {
        cancelButtonClicked = false;
        try {
            
          for ( int i = 0; i < row.length; i++ ) {
              int setOff = i*row[0];
              for ( int j = 0; j < row[i]; j++ ) {
                //qubits[j + setOff] = Integer.parseInt( qubitTextField[i][j].getText() );
                qubits[j + setOff] = Integer.parseInt( qubitToggleButton[i][j].getText() );
                if ( qubits[j + setOff] < 0 || qubits[j + setOff] > 1 ) {
                    throw new Exception();
                }
              }
          }
          setVisible(false);
        } catch ( Exception e ) {
            String message = bundle.getProperty("InitialStateDialog.errorMessage");
            JOptionPane.showMessageDialog(null, message);
        }
    }
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        cancelButtonClicked = true;
        setVisible(false);
        removeAll();
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     *  primarily for test purposes.
     */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               String language = "en"; //java.util.Locale.getDefault().getLanguage();
               java.util.Properties bundle = new java.util.Properties();
               try {
                  System.out.print("Try to load " + "/jquantum/Bundle_" + language + ".xml ...");
                  bundle.loadFromXML(getClass().getResourceAsStream("/jquantum/Bundle_" + language + ".xml"));
                  System.out.println(" successfully!");
               } catch(java.io.IOException ioe) {
                  try {
                     bundle.loadFromXML(getClass().getResourceAsStream("/jquantum/Bundle_en.xml"));
                  } catch (java.io.IOException ioe2) {
                     ioe2.printStackTrace();
                  }
               }
               int[] qubits = {0,1,0,0, 0,1};
               new InitialStateDialog(new javax.swing.JFrame(), true, bundle, qubits, 4).setVisible(true);
               System.exit(0);
            }
        });
    }
    // */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel headPanel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JPanel xPanel;
    private javax.swing.JPanel yPanel;
    // End of variables declaration//GEN-END:variables
    private JLabel qubitLabel;
    private JPanel[][] qubitPanel;
    private JToggleButton[][] qubitToggleButton;
    
}
