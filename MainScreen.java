/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;
/**
 *
 * @author Stephen
 */
public class MainScreen extends javax.swing.JFrame {
    /**
     * Creates new form MainScreen
     */
private int uid;
private String address;
private int port;
private int gid;
private String username;

    MainScreen(int uid, String address, int port, int gid, String username) {
       initComponents();
        this.uid = uid;
        this.address = address;
        this.port = port;
        this.gid = gid;
        this.username = username;
    }

    private MainScreen() {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScoreBoard = new javax.swing.JButton();
        Leaderboard = new javax.swing.JButton();
        CreateNewGame = new javax.swing.JButton();
        OpenGames = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ScoreBoard.setText("Score Board");
        ScoreBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScoreBoardActionPerformed(evt);
            }
        });

        Leaderboard.setText("Leaderboard");
        Leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardActionPerformed(evt);
            }
        });

        CreateNewGame.setText("Create new game");
        CreateNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewGameActionPerformed(evt);
            }
        });

        OpenGames.setText("Open Games");
        OpenGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenGamesActionPerformed(evt);
            }
        });

        jLabel1.setText("MAIN MENU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScoreBoard)
                            .addComponent(Leaderboard)
                            .addComponent(CreateNewGame)
                            .addComponent(OpenGames))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(Leaderboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScoreBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateNewGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpenGames)
                .addGap(0, 103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewGameActionPerformed
       new TicTacToe(uid,address, port, gid, username);
    }//GEN-LAST:event_CreateNewGameActionPerformed

    private void LeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardActionPerformed
       Leaderboard lb = new Leaderboard(uid, gid, port, address, username);
       lb.setVisible(true);
       lb.pack();
       lb.setLocationRelativeTo(null);
       lb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
    }//GEN-LAST:event_LeaderboardActionPerformed

    private void ScoreBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScoreBoardActionPerformed
        ScoreBoard sb = new ScoreBoard(uid, gid, port, address, username);
        sb.setVisible(true);
        sb.pack();
        sb.setLocationRelativeTo(null);
        sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ScoreBoardActionPerformed

    private void OpenGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenGamesActionPerformed
        OpenGames og = new OpenGames(uid, gid, port, address, username);
        og.setVisible(true);
        og.pack();
        og.setLocationRelativeTo(null);
        og.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_OpenGamesActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateNewGame;
    private javax.swing.JButton Leaderboard;
    private javax.swing.JButton OpenGames;
    private javax.swing.JButton ScoreBoard;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
