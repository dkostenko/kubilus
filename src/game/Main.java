/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import controller.LevelsController;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
/**
 *
 * @author macbook
 */
public class Main extends javax.swing.JFrame implements Runnable {

    private LevelsController levelsController;
    public static State state;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        levelsController = new LevelsController();
        
        this.setLayout(new BorderLayout());
        this.add(this.levelsController.getLevelView(), BorderLayout.WEST);
    }
    
    private void start() {
        state = State.gaming;
        turnOnController(Controller.MOUSE_ON_FIELD);
        new Thread(this).start();
    }
    
    
    private void stop() {
        this.levelsController.saveResult();
        this.timeLeft.setVisible(false);
    }
    
    
    private void turnOnController(Controller controller){
        Settings.setAvailableControl(controller);
        
        if(controller == Controller.PANEL_BUTTONS){
            goToTop.setEnabled(true);
            goToRight.setEnabled(true);
            goToBottom.setEnabled(true);
            goToLeft.setEnabled(true);
            changeBlock.setEnabled(true);
        } else {
            goToTop.setEnabled(false);
            goToRight.setEnabled(false);
            goToBottom.setEnabled(false);
            goToLeft.setEnabled(false);
            changeBlock.setEnabled(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goToTop = new javax.swing.JButton();
        goToLeft = new javax.swing.JButton();
        goToRight = new javax.swing.JButton();
        goToBottom = new javax.swing.JButton();
        changeBlock = new javax.swing.JButton();
        timeLeft = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("mainFrame"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        goToTop.setText("▲");
        goToTop.setName("goToTop"); // NOI18N
        goToTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToTopActionPerformed(evt);
            }
        });

        goToLeft.setText("◄");
        goToLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToLeftActionPerformed(evt);
            }
        });

        goToRight.setText("►");
        goToRight.setSize(new java.awt.Dimension(30, 30));
        goToRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToRightActionPerformed(evt);
            }
        });

        goToBottom.setText("▼");
        goToBottom.setSize(new java.awt.Dimension(30, 30));
        goToBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToBottomActionPerformed(evt);
            }
        });

        changeBlock.setText("Поменять блок");
        changeBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBlockActionPerformed(evt);
            }
        });

        timeLeft.setText("jLabel1");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(630, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(changeBlock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(goToLeft, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(goToTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(goToBottom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(goToRight, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(timeLeft, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(timeLeft)
                .add(68, 68, 68)
                .add(goToTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(goToLeft, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(goToRight, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(goToBottom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(changeBlock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToTopActionPerformed
        if(Settings.getAvailableControl() == Controller.PANEL_BUTTONS && state == State.gaming){
            this.levelsController.moveBlock(Direction.TOP);
        }
    }//GEN-LAST:event_goToTopActionPerformed

    private void goToLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToLeftActionPerformed
        if(Settings.getAvailableControl() == Controller.PANEL_BUTTONS && state == State.gaming){
            this.levelsController.moveBlock(Direction.LEFT);
        }
    }//GEN-LAST:event_goToLeftActionPerformed

    private void goToBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToBottomActionPerformed
        if(Settings.getAvailableControl() == Controller.PANEL_BUTTONS && state == State.gaming){
            this.levelsController.moveBlock(Direction.BOTTOM);
        }
    }//GEN-LAST:event_goToBottomActionPerformed

    private void goToRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToRightActionPerformed
        if(Settings.getAvailableControl() == Controller.PANEL_BUTTONS && state == State.gaming){
            this.levelsController.moveBlock(Direction.RIGHT);
        }
    }//GEN-LAST:event_goToRightActionPerformed

    private void changeBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBlockActionPerformed

        if(Settings.getAvailableControl() == Controller.PANEL_BUTTONS && state == State.gaming && evt.getModifiers() == MouseEvent.BUTTON1_MASK){
            this.levelsController.selectBlock();
        }
    }//GEN-LAST:event_changeBlockActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        if(Settings.getAvailableControl() == Controller.MOUSE_ON_FIELD && state == State.gaming && evt.getModifiers() == MouseEvent.BUTTON1_MASK){
            this.levelsController.selectBlock(evt.getPoint());
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        if(Settings.getAvailableControl() == Controller.MOUSE_ON_FIELD && state == State.gaming && evt.getModifiers() == MouseEvent.BUTTON1_MASK){
            this.levelsController.moveBlock(evt.getPoint());
        }
    }//GEN-LAST:event_formMouseReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if(Settings.getAvailableControl() == Controller.KEYBOARD){
            switch(evt.getKeyCode()){
                case KeyEvent.VK_UP:
                    this.levelsController.moveBlock(Direction.TOP);
                    break;
                case KeyEvent.VK_RIGHT:
                    this.levelsController.moveBlock(Direction.RIGHT);
                    break;
                case KeyEvent.VK_DOWN:
                    this.levelsController.moveBlock(Direction.BOTTOM);
                    break;
                case KeyEvent.VK_LEFT:
                    this.levelsController.moveBlock(Direction.LEFT);
                    break;
                case KeyEvent.VK_SPACE:
                    this.levelsController.selectBlock();
                    break;
            }
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Main game = new Main();
        game.setVisible(true);
        game.start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeBlock;
    private javax.swing.JButton goToBottom;
    private javax.swing.JButton goToLeft;
    private javax.swing.JButton goToRight;
    private javax.swing.JButton goToTop;
    private javax.swing.JLabel timeLeft;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.timeLeft.setText("Осталось: " + levelsController.update());
        
        long lastLoopTime = System.nanoTime();
        long lastFpsTime = 0;
        long now;
        long updateLength;

        while (state != State.downtime) {
            now = System.nanoTime();
            updateLength = now - lastLoopTime;
            lastLoopTime = now;
            lastFpsTime += updateLength;
            
            if(this.state == State.moving){
                this.levelsController.draw();
            }

            if (lastFpsTime >= 1000000000) {
                this.timeLeft.setText("Осталось: " + levelsController.update());
                lastFpsTime = 0;
            }
        }
        
        
        stop();
        
    }
}
