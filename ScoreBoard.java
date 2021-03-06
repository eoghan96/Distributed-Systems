/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import javax.swing.JFrame;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;


/**
 *
 * @author Stephen
 */
public class ScoreBoard extends javax.swing.JFrame {
  private TTTWebService proxy;
  private TTTWebService_Service link;
  private int uid;
  private int gid;
  private int port;
  private String address;
  private String username;
    /**
     * Creates new form ScoreBoard
     */
    public ScoreBoard(int uid, int gid, int port, String address, String username) {
        initComponents();
        this.uid = uid;
        this.address = address;
        this.port = port;
        this.gid = gid;
        this.username = username;
        getScoreboard();
    }

    private ScoreBoard() {
        initComponents(); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void getScoreboard(){
        initComponents();
        link = new TTTWebService_Service(){};
        proxy = link.getTTTWebServicePort();
        
        String result;
        result = proxy.showAllMyGames(uid);
        String arr []= result.split("\n");
        String otherUser = "";
        int wins = 0;
        int losses = 0;
        int draws = 0;
        if(!(result.equalsIgnoreCase("ERROR-NOGAMES")))
        {
            for(int i = 0; i < arr.length; i++)
            {
                String temp [] = arr[i].split(",");

                if(Integer.parseInt(temp[0]) == gid)
                {
                    if(username.equalsIgnoreCase(temp[1]))
                    {
                        otherUser = temp[2];
                    }
                    else
                        otherUser = temp[1];
                }
            }
        
        String table = proxy.leagueTable();
        arr = table.split("\n");
        
            for(int j = 0; j < arr.length; j++)
            {
                String temp [] = arr[j].split(",");
                if(temp[1].equalsIgnoreCase(username) && temp[2].equalsIgnoreCase(otherUser))
                {
                    if(Integer.parseInt(temp[3]) == 1)
                    {
                        wins ++;
                    }
                    else if(Integer.parseInt(temp[3]) == 2)
                    {
                        losses ++;
                    }
                    else if(Integer.parseInt(temp[3]) == 3)
                    {
                        draws ++;
                    }
                }
                  if(temp[1].equalsIgnoreCase(otherUser) && temp[2].equalsIgnoreCase(username))
                {
                    if(Integer.parseInt(temp[3]) == 1)
                    {
                        losses ++;
                    }
                    else if(Integer.parseInt(temp[3]) == 2)
                    {
                        wins ++;
                    }
                    else if(Integer.parseInt(temp[3]) == 3)
                    {
                        draws ++;
                    }
                }
            
            }
        }
        
        TextArea.setText("History: Win: " + wins + " / Loss: " + losses + " / Draw: " + draws);
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
        TextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        MainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        jLabel1.setText("Scoreboard:");

        MainMenu.setText("Main Menu");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(MainMenu)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MainMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MainMenu;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
