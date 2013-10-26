package com.googlecode.fahview.v6project;

/*
 * #%L
 * This file is part of FAHView-v6project.
 * %%
 * Copyright (C) 2011 - 2013 Michael Thomas <mikepthomas@outlook.com>
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

import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectFactory2;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.ServiceProvider;

/**
 * <p>ClientProjectFactory class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
@ServiceProvider(service = ProjectFactory.class)
public class ClientProjectFactory implements ProjectFactory2 {

    /** {@inheritDoc} */
    @Override
    public final ProjectManager.Result isProject2(
            final FileObject projectDirectory) {

        if (isProject(projectDirectory)) {
            Image image = ImageUtilities.loadImage(ClientProject.PROJECT_ICON);
            return new ProjectManager.Result(new ImageIcon(image));
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isProject(final FileObject projectDirectory) {
        return projectDirectory.getFileObject(
                ClientProject.PROJECT_FILE) != null;
    }

    /** {@inheritDoc} */
    @Override
    public final Project loadProject(final FileObject projectDirectory,
            final ProjectState state) throws IOException {

        if (isProject(projectDirectory)) {
            return new ClientProject(projectDirectory, state);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public void saveProject(final Project project) throws IOException {
        // leave unimplemented for the moment
    }
}
