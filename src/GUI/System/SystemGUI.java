/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.System;

import Application.Controller;
import Application.LoginController;
import GUI.Frames.ArrangementFrame;
import GUI.Frames.BookingFrame;
import GUI.Frames.CateringFrame;
import GUI.Frames.CreateFrame;
import GUI.Frames.EmployeeFrame;
import GUI.Frames.JobsFrame;
import GUI.Frames.MenuFrame;
import GUI.Frames.ServiceFrame;

import java.sql.SQLException;

/**
 *
 * @author LPNielsen
 */
public class SystemGUI extends javax.swing.JFrame {
    Controller control = new Controller();
    LoginGUI lg;
    
    /**
     * Creates new form SystemGUI
     */
    public SystemGUI() {
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

        desktop = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuFileLogOut = new javax.swing.JMenuItem();
        jMenuFileExit = new javax.swing.JMenuItem();
        jMenuManage = new javax.swing.JMenu();
        jMenuManageEmp = new javax.swing.JMenuItem();
        jMenuManageJob = new javax.swing.JMenuItem();
        jMenuManageMenu = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jMenuViewBook = new javax.swing.JMenuItem();
        jMenuViewCat = new javax.swing.JMenuItem();
        jMenuViewArr = new javax.swing.JMenuItem();
        jMenuCreate = new javax.swing.JMenu();
        jMenuCreateOpen = new javax.swing.JMenuItem();
        jMenuService = new javax.swing.JMenu();
        jMenuServiceOpen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test");
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );

        jMenuFile.setText("File");

        jMenuFileLogOut.setText("Log Out");
        jMenuFileLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileLogOutActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuFileLogOut);

        jMenuFileExit.setText("Exit");
        jMenuFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuFileExit);

        jMenuBar.add(jMenuFile);

        jMenuManage.setText("Management");

        jMenuManageEmp.setText("Employee");
        jMenuManageEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuManageEmpActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        jMenuManage.add(jMenuManageEmp);

        jMenuManageJob.setText("Jobs");
        jMenuManageJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuManageJobActionPerformed(evt);
            }
        });
        jMenuManage.add(jMenuManageJob);

        jMenuManageMenu.setText("Menu");
        jMenuManageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuManageMenuActionPerformed(evt);
            }
        });
        jMenuManage.add(jMenuManageMenu);

        jMenuBar.add(jMenuManage);

        jMenuView.setText("View");

        jMenuViewBook.setText("Booking");
        jMenuViewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuViewBookActionPerformed(evt);
            }
        });
        jMenuView.add(jMenuViewBook);

        jMenuViewCat.setText("Catering");
        jMenuViewCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuViewCatActionPerformed(evt);
            }
        });
        jMenuView.add(jMenuViewCat);

        jMenuViewArr.setText("Arrangement");
        jMenuViewArr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuViewArrActionPerformed(evt);
            }
        });
        jMenuView.add(jMenuViewArr);

        jMenuBar.add(jMenuView);

        jMenuCreate.setText("Create");

        jMenuCreateOpen.setText("Open");
        jMenuCreateOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCreateOpenActionPerformed(evt);
            }
        });
        jMenuCreate.add(jMenuCreateOpen);

        jMenuBar.add(jMenuCreate);

        jMenuService.setText("Service");

        jMenuServiceOpen.setText("Open");
        jMenuServiceOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuServiceOpenActionPerformed(evt);
            }
        });
        jMenuService.add(jMenuServiceOpen);

        jMenuBar.add(jMenuService);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuFileExitActionPerformed

    private void jMenuManageEmpActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jMenuManageEmpActionPerformed
        // TODO add your handling code here:
        EmployeeFrame e = new EmployeeFrame(control);
        desktop.add(e);
        e.setVisible(true);
    }//GEN-LAST:event_jMenuManageEmpActionPerformed

    private void jMenuManageJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuManageJobActionPerformed
        // TODO add your handling code here:
        JobsFrame j = new JobsFrame();
        desktop.add(j);
        j.setVisible(true);
    }//GEN-LAST:event_jMenuManageJobActionPerformed

    private void jMenuViewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuViewBookActionPerformed
        // TODO add your handling code here:
        BookingFrame b = new BookingFrame();
        desktop.add(b);
        b.setVisible(true);
    }//GEN-LAST:event_jMenuViewBookActionPerformed

    private void jMenuViewCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuViewCatActionPerformed
        // TODO add your handling code here:
        CateringFrame c = new CateringFrame();
        desktop.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_jMenuViewCatActionPerformed

    private void jMenuViewArrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuViewArrActionPerformed
        // TODO add your handling code here:
        ArrangementFrame arr = new ArrangementFrame();
        desktop.add(arr);
        arr.setVisible(true);
    }//GEN-LAST:event_jMenuViewArrActionPerformed

    private void jMenuCreateOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCreateOpenActionPerformed
        // TODO add your handling code here:
        CreateFrame cr = new CreateFrame(control);
        desktop.add(cr);
        cr.setVisible(true);
    }//GEN-LAST:event_jMenuCreateOpenActionPerformed

    private void jMenuManageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuManageMenuActionPerformed
        // TODO add your handling code here:
        MenuFrame mf = new MenuFrame();
        desktop.add(mf);
        mf.setVisible(true);
    }//GEN-LAST:event_jMenuManageMenuActionPerformed

    private void jMenuFileLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileLogOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        LoginGUI g = new LoginGUI(new LoginController(),new SystemGUI());
        g.setVisible(true);
    }//GEN-LAST:event_jMenuFileLogOutActionPerformed

    private void jMenuServiceOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuServiceOpenActionPerformed
        // TODO add your handling code here:
        ServiceFrame s = new ServiceFrame();
        desktop.add(s);
        s.setVisible(true);
    }//GEN-LAST:event_jMenuServiceOpenActionPerformed

    public void adminView(){
        jMenuManage.setEnabled(true);
    }
    public void empView(){
        jMenuManage.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCreate;
    private javax.swing.JMenuItem jMenuCreateOpen;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuFileExit;
    private javax.swing.JMenuItem jMenuFileLogOut;
    private static javax.swing.JMenu jMenuManage;
    private javax.swing.JMenuItem jMenuManageEmp;
    private javax.swing.JMenuItem jMenuManageJob;
    private javax.swing.JMenuItem jMenuManageMenu;
    private javax.swing.JMenu jMenuService;
    private javax.swing.JMenuItem jMenuServiceOpen;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JMenuItem jMenuViewArr;
    private javax.swing.JMenuItem jMenuViewBook;
    private javax.swing.JMenuItem jMenuViewCat;
    // End of variables declaration//GEN-END:variables
}
