/*
 * Copyright (C) 2013 Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.googlecode.fahview.viewer.files.xyz;

import com.googlecode.fahview.viewer.JmolPanel;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * <p>XyzFileVisualElement class.</p>
 *
 * @author mike
 * @version $Id: $Id
 */
@MultiViewElement.Registration(
        displayName = "#LBL_XyzFile_VISUAL",
        iconBase = "com/googlecode/fahview/viewer/files/xyz/XyzFile.png",
        mimeType = "model/x-xyz",
        persistenceType = TopComponent.PERSISTENCE_NEVER,
        preferredID = "XyzFileVisual",
        position = 2000)
@Messages("LBL_XyzFile_VISUAL=Visual")
public final class XyzFileVisualElement extends JmolPanel implements MultiViewElement {

    private XyzFileDataObject obj;
    private JToolBar toolbar = new JToolBar();
    private transient MultiViewElementCallback callback;

    /**
     * <p>Constructor for XyzFileVisualElement.</p>
     *
     * @param lkp a {@link org.openide.util.Lookup} object.
     */
    public XyzFileVisualElement(Lookup lkp) {
        obj = lkp.lookup(XyzFileDataObject.class);
        assert obj != null;
        initComponents();
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return "XyzFileVisualElement";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /** {@inheritDoc} */
    @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public JComponent getToolbarRepresentation() {
        return toolbar;
    }

    /** {@inheritDoc} */
    @Override
    public Action[] getActions() {
        return new Action[0];
    }

    /** {@inheritDoc} */
    @Override
    public Lookup getLookup() {
        return obj.getLookup();
    }

    /** {@inheritDoc} */
    @Override
    public void componentOpened() {
        // Set model and get info
        getViewer().openFile(obj.getPrimaryFile().getPath());
//        System.out.println(getViewer().getProperty("readable", "modelInfo", null));
//        System.out.println(getViewer().getProperty("readable", "auxiliaryInfo", null));
    }

    /** {@inheritDoc} */
    @Override
    public void componentClosed() {
    }

    /** {@inheritDoc} */
    @Override
    public void componentShowing() {
    }

    /** {@inheritDoc} */
    @Override
    public void componentHidden() {
    }

    /** {@inheritDoc} */
    @Override
    public void componentActivated() {
    }

    /** {@inheritDoc} */
    @Override
    public void componentDeactivated() {
    }

    /** {@inheritDoc} */
    @Override
    public UndoRedo getUndoRedo() {
        return UndoRedo.NONE;
    }

    /** {@inheritDoc} */
    @Override
    public void setMultiViewCallback(MultiViewElementCallback callback) {
        this.callback = callback;
    }

    /** {@inheritDoc} */
    @Override
    public CloseOperationState canCloseElement() {
        return CloseOperationState.STATE_OK;
    }
}
