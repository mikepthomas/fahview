package info.mikethomas.fahview.v6project.files.config;

/*
 * #%L
 * This file is part of FAHView-v6project.
 * %%
 * Copyright (C) 2011 - 2017 Mike Thomas <mikepthomas@outlook.com>
 * %%
 * FAHView is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * %
 * FAHView is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * %
 * You should have received a copy of the GNU General Public License
 * along with FAHView.  If not, see <http://www.gnu.org/licenses/>.
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
 * <p>ConfigFileDataObject class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
@Messages({
    "LBL_ConfigFile_LOADER=Files of ConfigFile"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_ConfigFile_LOADER",
        mimeType = "text/x-fahconfig",
        extension = {"cfg", "CFG"},
        position = 100)
@DataObject.Registration(
        mimeType = "text/x-fahconfig",
        iconBase = "info/mikethomas/fahview/v6project/files/config/ConfigFile.png",
        displayName = "#LBL_ConfigFile_LOADER",
        position = 300)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300),
    @ActionReference(
            path = "Loaders/text/x-fahconfig/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400)
})
public class ConfigFileDataObject extends MultiDataObject {

    /**
     * <p>Constructor for ConfigFileDataObject.</p>
     *
     * @param pf a {@link org.openide.filesystems.FileObject} object.
     * @param loader a {@link org.openide.loaders.MultiFileLoader} object.
     * @throws org.openide.loaders.DataObjectExistsException if any.
     * @throws java.io.IOException if any.
     */
    public ConfigFileDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-fahconfig", true);
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
            displayName = "#LBL_ConfigFile_EDITOR",
            iconBase = "info/mikethomas/fahview/v6project/files/config/ConfigFile.png",
            mimeType = "text/x-fahconfig",
            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
            preferredID = "ConfigFile",
            position = 1000)
    @Messages("LBL_ConfigFile_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }
}
