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
package se.trixon.mapollage.ui;

import se.trixon.almond.util.Dict;
import se.trixon.mapollage.Options;

/**
 *
 * @author Patrik Karlsson
 */
public class OptionsPanel extends javax.swing.JPanel {

    private final Options mOptions = Options.getInstance();

    /**
     * Creates new form OptionsPanel
     */
    public OptionsPanel() {
        initComponents();
        localeComboBox.setSelectedItem(mOptions.getLocale());
        latSpinner.setValue(mOptions.getDefaultLat());
        lonSpinner.setValue(mOptions.getDefaultLon());
        thumbnailSizeSpinner.setValue(mOptions.getThumbnailSize());
        borderSizeSpinner.setValue(mOptions.getThumbnailBorderSize());
    }

    void save() {
        lookAndFeelPanel.save();
        mOptions.setLocale(localeComboBox.getSelectedItem());
        mOptions.setDefaultLat((Double) latSpinner.getModel().getValue());
        mOptions.setDefaultLon((Double) lonSpinner.getModel().getValue());
        mOptions.setThumbnailSize((int) thumbnailSizeSpinner.getModel().getValue());
        mOptions.setThumbnailBorderSize((int) borderSizeSpinner.getModel().getValue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lookAndFeelPanel = new se.trixon.almond.util.swing.dialogs.LookAndFeelPanel();
        localeLabel = new javax.swing.JLabel();
        localeComboBox = new se.trixon.almond.util.swing.LocaleComboBox();
        nullCoordinatePanel = new javax.swing.JPanel();
        coordinateLabel = new javax.swing.JLabel();
        latLabel = new javax.swing.JLabel();
        latSpinner = new javax.swing.JSpinner();
        lonLabel = new javax.swing.JLabel();
        lonSpinner = new javax.swing.JSpinner();
        placemarkLabel = new javax.swing.JLabel();
        thumbnailSizeLabel = new javax.swing.JLabel();
        thumbnailSizeSpinner = new javax.swing.JSpinner();
        borderSizeLabel = new javax.swing.JLabel();
        borderSizeSpinner = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(lookAndFeelPanel, gridBagConstraints);

        localeLabel.setText(Dict.CALENDAR_LANGUAGE.toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(localeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(localeComboBox, gridBagConstraints);

        nullCoordinatePanel.setLayout(new java.awt.GridBagLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/mapollage/ui/Bundle"); // NOI18N
        coordinateLabel.setText(bundle.getString("OptionsPanel.coordinateLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        nullCoordinatePanel.add(coordinateLabel, gridBagConstraints);

        latLabel.setText(Dict.LATITUDE.toString());
        latLabel.setPreferredSize(new java.awt.Dimension(100, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        nullCoordinatePanel.add(latLabel, gridBagConstraints);

        latSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, -90.0d, 90.0d, 0.01d));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        nullCoordinatePanel.add(latSpinner, gridBagConstraints);

        lonLabel.setText(Dict.LONGITUDE.toString());
        lonLabel.setPreferredSize(new java.awt.Dimension(100, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        nullCoordinatePanel.add(lonLabel, gridBagConstraints);

        lonSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, -180.0d, 180.0d, 0.01d));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        nullCoordinatePanel.add(lonSpinner, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(nullCoordinatePanel, gridBagConstraints);

        placemarkLabel.setFont(placemarkLabel.getFont().deriveFont((placemarkLabel.getFont().getStyle() | java.awt.Font.ITALIC), placemarkLabel.getFont().getSize()+3));
        placemarkLabel.setText(Dict.PLACEMARK.toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(placemarkLabel, gridBagConstraints);

        thumbnailSizeLabel.setText(bundle.getString("OptionsPanel.thumbnailSizeLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(thumbnailSizeLabel, gridBagConstraints);

        thumbnailSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(250, 100, 1200, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(thumbnailSizeSpinner, gridBagConstraints);

        borderSizeLabel.setText(bundle.getString("OptionsPanel.borderSizeLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 0);
        add(borderSizeLabel, gridBagConstraints);

        borderSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 0, 20, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(borderSizeSpinner, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borderSizeLabel;
    private javax.swing.JSpinner borderSizeSpinner;
    private javax.swing.JLabel coordinateLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel latLabel;
    private javax.swing.JSpinner latSpinner;
    private se.trixon.almond.util.swing.LocaleComboBox localeComboBox;
    private javax.swing.JLabel localeLabel;
    private javax.swing.JLabel lonLabel;
    private javax.swing.JSpinner lonSpinner;
    private se.trixon.almond.util.swing.dialogs.LookAndFeelPanel lookAndFeelPanel;
    private javax.swing.JPanel nullCoordinatePanel;
    private javax.swing.JLabel placemarkLabel;
    private javax.swing.JLabel thumbnailSizeLabel;
    private javax.swing.JSpinner thumbnailSizeSpinner;
    // End of variables declaration//GEN-END:variables
}
