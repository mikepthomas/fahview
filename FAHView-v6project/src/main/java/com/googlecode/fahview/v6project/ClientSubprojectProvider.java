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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.spi.project.SubprojectProvider;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 * <p>ClientSubprojectProvider class.</p>
 *
 * @author Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 * @version $Id: $Id
 */
public class ClientSubprojectProvider implements SubprojectProvider {

    /** Project <code>project</code>. */
    private final Project project;

    /**
     * <p>Constructor for ClientSubprojectProvider.</p>
     *
     * @param parentProject a {@link org.netbeans.api.project.Project} object.
     */
    public ClientSubprojectProvider(final Project parentProject) {
        this.project = parentProject;
    }

    /** {@inheritDoc} */
    @Override
    public final Set<?extends Project> getSubprojects() {
        Set<Project> newProjects = new HashSet<Project>();
        FileObject dir = project.getProjectDirectory();
        if (dir != null) {
            for (FileObject childFolder : dir.getChildren()) {
                try {
                    Project subp = ProjectManager.getDefault().
                            findProject(childFolder);
                    if (subp != null) {
                        newProjects.add(subp);
                    }
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (IllegalArgumentException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
        return Collections.unmodifiableSet(newProjects);
    }

    /** {@inheritDoc} */
    @Override
    public void addChangeListener(final ChangeListener listener) { }

    /** {@inheritDoc} */
    @Override
    public void removeChangeListener(final ChangeListener listener) { }
}
