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
package com.googlecode.fahview.v6project.nodes;

import com.googlecode.fahview.v6project.ClientSubprojectProvider;
import com.googlecode.fahview.v6project.WorkProject;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 *
 * @author Michael Thomas <michael4.thomas@live.uwe.ac.uk>
 */
@NodeFactory.Registration(projectType = "com-googlecode-fahview-client", position = 10)
public class ClientSubProjectNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project p) {
        ClientSubprojectProvider csp = p.getLookup().
            lookup(ClientSubprojectProvider.class);
        assert csp != null;
        return new ReportsNodeList(csp.getSubprojects());
    }

    private class ReportsNodeList implements NodeList<Project> {

        Set<? extends Project> subprojects;

        public ReportsNodeList(Set<? extends Project> subprojects) {
            this.subprojects = subprojects;
        }

        @Override
        public List<Project> keys() {
            List<Project> result = new ArrayList<Project>();
            for (Project oneReportSubProject : subprojects) {
                result.add(oneReportSubProject);
            }
            return result;
        }

        @Override
        public void addChangeListener(ChangeListener l) {}

        @Override
        public void removeChangeListener(ChangeListener l) {}

        @Override
        public Node node(Project key) {
            FilterNode fn = null;
            try {
                fn = new FilterNode(DataObject.find(key.
                        getProjectDirectory()).getNodeDelegate(),
                        NodeFactorySupport.createCompositeChildren(
                        key, "Projects/com-googlecode-fahview-work/Nodes")){
                    @Override
                    public Image getIcon(int type) {
                        return ImageUtilities.loadImage(WorkProject.PROJECT_ICON);
                    }
                    @Override
                    public Image getOpenedIcon(int type) {
                        return getIcon(type);
                    }
                };
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            return fn;
        }

        @Override
        public void addNotify() {}

        @Override
        public void removeNotify() {}
    }
}