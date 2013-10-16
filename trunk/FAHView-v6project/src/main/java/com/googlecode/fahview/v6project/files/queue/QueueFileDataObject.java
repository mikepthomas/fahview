package com.googlecode.fahview.v6project.files.queue;

/*
 * #%L
 * FAHView-v6project
 * %%
 * Copyright (C) 2011 - 2013 Mike Thomas <mikepthomas@outlook.com>
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * <p>QueueFileDataObject class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
@Messages({
    "LBL_QueueFile_LOADER=Files of QueueFile"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_QueueFile_LOADER",
        mimeType = "application/x-fahqueue",
        extension = {"dat", "DAT"},
        position = 200)
@DataObject.Registration(
        mimeType = "application/x-fahqueue",
        iconBase = "com/googlecode/fahview/v6project/files/queue/QueueFile.png",
        displayName = "#LBL_QueueFile_LOADER",
        position = 300)
@ActionReferences({
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300),
    @ActionReference(
            path = "Loaders/application/x-fahqueue/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400)
})
public class QueueFileDataObject extends MultiDataObject {

    /**
     * <p>Constructor for QueueFileDataObject.</p>
     *
     * @param pf a {@link org.openide.filesystems.FileObject} object.
     * @param loader a {@link org.openide.loaders.MultiFileLoader} object.
     * @throws org.openide.loaders.DataObjectExistsException if any.
     * @throws java.io.IOException if any.
     */
    public QueueFileDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("application/x-fahqueue", true);
    }

    /** {@inheritDoc} */
    @Override
    protected int associateLookup() {
        return 1;
    }

    /**
     * <p>createEditor.</p>
     *
     * @param lkp a {@link org.openide.util.Lookup} object.
     * @return a {@link org.netbeans.core.spi.multiview.text.MultiViewEditorElement} object.
     */
    @MultiViewElement.Registration(
            displayName = "#LBL_QueueFile_EDITOR",
            iconBase = "com/googlecode/fahview/v6project/files/queue/QueueFile.png",
            mimeType = "application/x-fahqueue",
            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
            preferredID = "QueueFile",
            position = 1000)
    @Messages("LBL_QueueFile_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }
}
