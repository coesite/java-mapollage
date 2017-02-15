/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.mapollage.ui.config;

import java.awt.event.FocusAdapter;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.almond.util.swing.LogPanel;
import se.trixon.almond.util.swing.dialogs.FileChooserPanel;
import se.trixon.mapollage.profile.Profile;
import se.trixon.mapollage.profile.ProfileSource;

/**
 *
 * @author Patrik Karlsson
 */
public class ModuleSourcePanel extends ModulePanel implements FileChooserPanel.FileChooserButtonListener {

    private ProfileSource mSource;

    /**
     * Creates new form ModuleSourcePanel
     */
    public ModuleSourcePanel() {
        initComponents();
        init();
        mTitle = Dict.SOURCE.toString();
    }

    @Override
    public StringBuilder getHeaderBuilder() {
        StringBuilder sb = new StringBuilder();

        sb.append(Dict.SOURCE.toString()).append("\n");
        append(sb, sourceChooserPanel.getHeader(), mSource.getDir().getAbsolutePath());
        append(sb, patternLabel.getText(), mSource.getFilePattern());
        optAppend(sb, mSource.isRecursive(), recursiveCheckBox.getText());
        optAppend(sb, mSource.isFollowLinks(), followLinksCheckBox.getText());
        sb.append("\n");

        return sb;
    }

    public FileChooserPanel getSourceChooserPanel() {
        return sourceChooserPanel;
    }

    public LogPanel getLogPanel() {
        return logPanel;
    }

    @Override
    public ImageIcon getIcon() {
        return MaterialIcon._Image.PHOTO_LIBRARY.get(ICON_SIZE, getIconColor());
    }

    @Override
    public boolean hasValidSettings() {
        if (patternTextField.getText().isEmpty()) {
            patternTextField.setText("*");
        }

        if (sourceChooserPanel.getTextField().getText().isEmpty()) {
            invalidSettings(Dict.INVALID_SOURCE.toString());
            return false;
        }

        return true;
    }

    private void init() {
        sourceChooserPanel.setDropMode(FileChooserPanel.DropMode.MULTI);
        sourceChooserPanel.setMode(JFileChooser.FILES_AND_DIRECTORIES);
        sourceChooserPanel.getFileChooser().setMultiSelectionEnabled(true);
        sourceChooserPanel.setButtonListener(this);
        sourceChooserPanel.getTextField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                saveSourcePath();
            }
        });

        sourceChooserPanel.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveSourcePath();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveSourcePath();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveSourcePath();
            }
        });

        patternTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveOption();
            }

            private void saveOption() {
                mSource.setFilePattern(patternTextField.getText());
            }
        });
    }

    private void saveSourcePath() {
        mSource.setDir(new File(sourceChooserPanel.getPath()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceChooserPanel = new se.trixon.almond.util.swing.dialogs.FileChooserPanel();
        patternPanel = new javax.swing.JPanel();
        patternLabel = new javax.swing.JLabel();
        patternTextField = new javax.swing.JTextField();
        recursiveCheckBox = new javax.swing.JCheckBox();
        followLinksCheckBox = new javax.swing.JCheckBox();
        logPanel = new se.trixon.almond.util.swing.LogPanel();
        includeNullCoordinateCheckBox = new javax.swing.JCheckBox();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/mapollage/ui/config/Bundle"); // NOI18N
        sourceChooserPanel.setHeader(bundle.getString("ModuleSourcePanel.sourceChooserPanel.header")); // NOI18N

        patternLabel.setText(Dict.FILE_PATTERN.getString());

        javax.swing.GroupLayout patternPanelLayout = new javax.swing.GroupLayout(patternPanel);
        patternPanel.setLayout(patternPanelLayout);
        patternPanelLayout.setHorizontalGroup(
            patternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patternPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(patternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patternPanelLayout.createSequentialGroup()
                        .addComponent(patternLabel)
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addComponent(patternTextField))
                .addContainerGap())
        );
        patternPanelLayout.setVerticalGroup(
            patternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patternPanelLayout.createSequentialGroup()
                .addComponent(patternLabel)
                .addGap(0, 0, 0)
                .addComponent(patternTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        recursiveCheckBox.setText(Dict.SUBDIRECTORIES.getString());
        recursiveCheckBox.setFocusable(false);
        recursiveCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        recursiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recursiveCheckBoxActionPerformed(evt);
            }
        });

        followLinksCheckBox.setText(Dict.FOLLOW_LINKS.getString());
        followLinksCheckBox.setFocusable(false);
        followLinksCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        followLinksCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followLinksCheckBoxActionPerformed(evt);
            }
        });

        includeNullCoordinateCheckBox.setText(bundle.getString("ModuleSourcePanel.includeNullCoordinateCheckBox.text")); // NOI18N
        includeNullCoordinateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                includeNullCoordinateCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sourceChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(patternPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recursiveCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(followLinksCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(includeNullCoordinateCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sourceChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(patternPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recursiveCheckBox)
                    .addComponent(followLinksCheckBox)
                    .addComponent(includeNullCoordinateCheckBox))
                .addGap(18, 18, 18)
                .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void recursiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recursiveCheckBoxActionPerformed
        mSource.setRecursive(recursiveCheckBox.isSelected());
    }//GEN-LAST:event_recursiveCheckBoxActionPerformed

    private void followLinksCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followLinksCheckBoxActionPerformed
        mSource.setFollowLinks(followLinksCheckBox.isSelected());
    }//GEN-LAST:event_followLinksCheckBoxActionPerformed

    private void includeNullCoordinateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_includeNullCoordinateCheckBoxActionPerformed
        mSource.setIncludeNullCoordinate(includeNullCoordinateCheckBox.isSelected());
    }//GEN-LAST:event_includeNullCoordinateCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox followLinksCheckBox;
    private javax.swing.JCheckBox includeNullCoordinateCheckBox;
    private se.trixon.almond.util.swing.LogPanel logPanel;
    private javax.swing.JLabel patternLabel;
    private javax.swing.JPanel patternPanel;
    private javax.swing.JTextField patternTextField;
    private javax.swing.JCheckBox recursiveCheckBox;
    private se.trixon.almond.util.swing.dialogs.FileChooserPanel sourceChooserPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(Profile profile) {
        mProfile = profile;
        mSource = profile.getSource();

        try {
            sourceChooserPanel.setPath(mSource.getDir().getAbsolutePath());
        } catch (NullPointerException e) {
        }

        patternTextField.setText(mSource.getFilePattern());
        recursiveCheckBox.setSelected(mSource.isRecursive());
        followLinksCheckBox.setSelected(mSource.isFollowLinks());

        includeNullCoordinateCheckBox.setSelected(mSource.isIncludeNullCoordinate());
    }

    @Override
    public void onFileChooserCancel(FileChooserPanel fileChooserPanel) {
        // nvm
    }

    @Override
    public void onFileChooserCheckBoxChange(FileChooserPanel fileChooserPanel, boolean isSelected) {
        // nvm
    }

    @Override
    public void onFileChooserDrop(FileChooserPanel fileChooserPanel) {
        if (fileChooserPanel == sourceChooserPanel) {
            saveSourcePath();
        }
    }

    @Override
    public void onFileChooserOk(FileChooserPanel fileChooserPanel, File file) {
        JFileChooser fileChooser = fileChooserPanel.getFileChooser();

        if (fileChooserPanel == sourceChooserPanel) {
            if (fileChooser.isMultiSelectionEnabled()) {
                String paths = StringUtils.join(fileChooser.getSelectedFiles(), SystemUtils.PATH_SEPARATOR);
                fileChooserPanel.setPath(paths);
            }

            saveSourcePath();
        }
    }

    @Override
    public void onFileChooserPreSelect(FileChooserPanel fileChooserPanel) {
        if (fileChooserPanel == sourceChooserPanel) {
            final String[] paths = sourceChooserPanel.getPath().split(SystemUtils.PATH_SEPARATOR);
            File[] files = new File[paths.length];

            for (int i = 0; i < files.length; i++) {
                files[i] = new File(paths[i]);
            }

            sourceChooserPanel.getFileChooser().setSelectedFiles(files);
        }
    }
}