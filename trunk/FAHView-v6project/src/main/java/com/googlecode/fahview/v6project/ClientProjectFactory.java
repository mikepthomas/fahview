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
package com.googlecode.fahview.v6project;

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
 *
 * @author Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 */
@ServiceProvider(service = ProjectFactory.class)
public class ClientProjectFactory implements ProjectFactory2 {

    @Override
    public ProjectManager.Result isProject2(FileObject projectDirectory) {
        return isProject(projectDirectory)
                ? new ProjectManager.Result(new ImageIcon(ImageUtilities.loadImage(ClientProject.PROJECT_ICON)))
                : null;
    }

    @Override
    public boolean isProject(FileObject projectDirectory) {
        return projectDirectory.getFileObject(ClientProject.PROJECT_FILE) != null;
    }

    @Override
    public Project loadProject(FileObject projectDirectory, ProjectState state) throws IOException {
        return isProject(projectDirectory)
                ? new ClientProject(projectDirectory, state)
                : null;
    }

    @Override
    public void saveProject(Project project) throws IOException, ClassCastException {
        // leave unimplemented for the moment
    }
}
