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
public class OpenGames extends javax.swing.JFrame {
    private int uid;
    private int gid;
    private int port;
    private String result;
    String address;
    String username;
    private TTTWebService proxy;
    private TTTWebService_Service link;
    String[] openGames;
    boolean myTurn;
    String playerType = "";
    int saveIndex = 0;
    /**
     * Creates new form OpenGames
     */
    public OpenGames() {
        initComponents();
    }

    OpenGames(int uid, int gid, int port, String address, String username) {
        initComponents();
        this.uid = uid;
        this.address = address;
        this.port = port;
        this.gid = gid;
        this.username = username;
        
        openGames = getOpenGames();
        for(int i = 0;i<openGames.length;i++){
            result += openGames[i];
        }
        OpenGames.setText(result);
    }

     public String[] getOpenGames()
    {
        String openg = proxy.showOpenGames();   
        if(!(openg.equalsIgnoreCase("ERROR-NOGAMES")))
        {
            String og[] = openg.split("\n");
            String result[] = new String[og.length];
            
                for(int i = 0; i < og.length; i++)
                {
                    String temp [] = og[i].split(",");
                    if(!(temp[1].equalsIgnoreCase(username)))
                    {
                         result[i] = temp[1];
                    }
                }
            return result;
        }

        String [] empty = new String[1];
        return empty;
    }
     
    public void joinGame(int index)
    {
        //create a new game
        link = new TTTWebService_Service(){};
        proxy = link.getTTTWebServicePort();
        saveIndex = index;
        String result = proxy.showOpenGames();
        
        String arr[] = result.split("\n");
        boolean found = false;
        String join = "0";
        
        String temp [] = arr[index].split(",");
        if((!(temp[1].equalsIgnoreCase(username))) && !found) // check available games, player cant join a game they started themself
        {
            found = true;

            gid = Integer.parseInt(temp[0]);

            join = proxy.joinGame(uid,gid);
            myTurn = false;
            playerType = "Player 2";
            Runnable p = new Player(gid,uid,myTurn,playerType,username, port, address);
            new Thread(p).start();
            //start();
        }
        if(join == "0" || found == false)
            JOptionPane.showMessageDialog(null, "Error: could not join any game");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        OpenGames = new javax.swing.JTextArea();
        MainMenu = new javax.swing.JButton();
        JoinGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Gid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OpenGames.setColumns(20);
        OpenGames.setRows(5);
        jScrollPane1.setViewportView(OpenGames);

        MainMenu.setText("Main Menu");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });

        JoinGame.setText("Join Game");
        JoinGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinGameActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter the Gid of the game you want to join:");

        Gid.setText("GID");

        jLabel2.setText("List of current open games:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(JoinGame)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MainMenu))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Gid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Gid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JoinGame)
                            .addComponent(MainMenu))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinGameActionPerformed
        
    }//GEN-LAST:event_JoinGameActionPerformed

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
            MainScreen ms = new MainScreen(uid,address, port, gid, username);
            ms.setVisible(true);
            ms.pack();
            ms.setLocationRelativeTo(null);
            ms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_MainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(OpenGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenGames().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Gid;
    private javax.swing.JButton JoinGame;
    private javax.swing.JButton MainMenu;
    private javax.swing.JTextArea OpenGames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}