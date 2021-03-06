/*
 * InfoFrame.java
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

import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 * This class creates a message display for the jQuantum computer simulator.
 *
 * @author  Andreas de Vries
 * @version $Id: InfoFrame.java,v 1.4 2008-02-22 10:16:23 vriesa Exp $
 */
public class InfoFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = -1082511041;
    
    /** Creates new information frame.
     *  @param message the message to be displayed
     *  @param title the title of this frame
     *  @param width the width of this frame
     *  @param height the height of this frame
     */
    public InfoFrame(String message, String title, int width, int height) {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
            if ( UIManager.getSystemLookAndFeelClassName().equals( "javax.swing.plaf.metal.MetalLookAndFeel" ) ) {
                UIManager.setLookAndFeel( "com.sun.java.swing.plaf.motif.MotifLookAndFeel" );
            }
        } catch ( Exception e ) {
        }    
        setTitle(title);
        initComponents();
        JLabel outputArea = new javax.swing.JLabel(message);
        outputArea.setPreferredSize(new java.awt.Dimension(width, height));
        getContentPane().add(outputArea, java.awt.BorderLayout.CENTER);
        pack();
        setLocation( 50, 50);
        setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        logoLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        closePanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        logoLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jquantum/icons/jQLogoKlein.gif")));
        logoLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        logoLabel.setPreferredSize(new java.awt.Dimension(171, 67));
        getContentPane().add(logoLabel, java.awt.BorderLayout.NORTH);

        leftPanel.setPreferredSize(new java.awt.Dimension(20, 100));
        getContentPane().add(leftPanel, java.awt.BorderLayout.WEST);

        rightPanel.setPreferredSize(new java.awt.Dimension(20, 100));
        getContentPane().add(rightPanel, java.awt.BorderLayout.EAST);

        closeButton.setText("OK");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        closePanel.add(closeButton);

        getContentPane().add(closePanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoFrame("This is a longer Text ...", "Title", 250, 50);
            }
        });
    }
    // */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel closePanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
    
}
