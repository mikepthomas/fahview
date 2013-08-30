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

import com.googlecode.fahview.v6project.properties.ClientCustomizerProvider;
import java.awt.Image;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 * <p>ClientProject class.</p>
 *
 * @author Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 * @version $Id: $Id
 */
public class ClientProject implements Project {

    /** Constant <code>PROJECT_ICON</code>. */
    @StaticResource()
    public static final String PROJECT_ICON =
            "com/googlecode/fahview/v6project/client.png";
    /** Constant <code>PROJECT_FILE</code>. */
    public static final String PROJECT_FILE = "client.cfg";

    /** FileObject <code>directory</code>. */
    private final FileObject directory;
    /** ProjectState <code>state</code>. */
    private final ProjectState state;
    /** Lookup <code>lookup</code>. */
    private Lookup lookup;

    /**
     *
     * @param projectDirectory projectDirectory
     * @param projectState ProjectState
     */
    ClientProject(final FileObject projectDirectory,
                  final ProjectState projectState) {
        this.directory = projectDirectory;
        this.state = projectState;
    }

    /** {@inheritDoc} */
    @Override
    public final FileObject getProjectDirectory() {
        return directory;
    }

    /** {@inheritDoc} */
    @Override
    public final Lookup getLookup() {
        if (lookup == null) {
            lookup = Lookups.fixed(new Object[] {
                this,
                new ClientProjectInformation(),
                new ClientProjectLogicalView(this),
                new ClientCustomizerProvider(this),
                new ClientSubprojectProvider(this)
            });
        }
        return lookup;
    }

    /**
     * <p>ClientProjectInformation class.</p>
     */
    private final class ClientProjectInformation implements ProjectInformation {

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage(PROJECT_ICON));
        }

        @Override
        public Project getProject() {
            return ClientProject.this;
        }

        @Override
        public void addPropertyChangeListener(
                final PropertyChangeListener listener) { }

        @Override
        public void removePropertyChangeListener(
                final PropertyChangeListener listener) { }
    }

    /**
     * <p>ClientProjectLogicalView class.</p>
     */
    private static class ClientProjectLogicalView
            implements LogicalViewProvider {

        /** ClientProject <code>project</code>. */
        private final ClientProject project;

        /**
         *
         * @param clientProject ClientProject
         */
        public ClientProjectLogicalView(final ClientProject clientProject) {
            this.project = clientProject;
        }

        /** {@inheritDoc} */
        @Override
        public Node createLogicalView() {
            try {
                //Obtain the project directory's node:
                FileObject projectDirectory = project.getProjectDirectory();
                DataFolder projectFolder = DataFolder.findFolder(projectDirectory);
                Node nodeOfProjectFolder = projectFolder.getNodeDelegate();

                //Decorate the project directory's node:
                return new ProjectNode(nodeOfProjectFolder, project);

            } catch (DataObjectNotFoundException donfe) {
                Exceptions.printStackTrace(donfe);
                //Fallback-the directory couldn't be created -
                //read-only filesystem or something evil happened
                return new AbstractNode(Children.LEAF);
            }
        }

        @Override
        public Node findPath(final Node root, final Object target) {
            //leave unimplemented for now
            return null;
        }

        /**
         * <p>ProjectNode class.</p>
         */
        private static class ProjectNode extends FilterNode {

            /** ClientProject <code>project</code>. */
            private final ClientProject project;

            /**
             *
             * @param node Node
             * @param clientProject ClientProject
             * @throws DataObjectNotFoundException Exception
             */
            public ProjectNode(final Node node,
                               final ClientProject clientProject)
                    throws DataObjectNotFoundException {

                super(node,
                        NodeFactorySupport.createCompositeChildren(
                        clientProject,
                        "Projects/com-googlecode-fahview-client/Nodes"),
                        new ProxyLookup(
                        new Lookup[]{
                    Lookups.singleton(clientProject),
                    node.getLookup()
                }));

                this.project = clientProject;
            }

            @Override
            public Action[] getActions(final boolean arg0) {
                return new Action[]{
                    CommonProjectActions.customizeProjectAction(),
                    CommonProjectActions.deleteProjectAction(),
                    CommonProjectActions.closeProjectAction()
                };
            }

            @Override
            public Image getIcon(final int type) {
                return ImageUtilities.loadImage(PROJECT_ICON);
            }

            @Override
            public Image getOpenedIcon(final int type) {
                return getIcon(type);
            }

            @Override
            public String getDisplayName() {
                return project.getProjectDirectory().getName();
            }
        }
    }
}
