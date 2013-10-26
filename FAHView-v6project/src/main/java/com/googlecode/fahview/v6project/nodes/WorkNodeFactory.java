package com.googlecode.fahview.v6project.nodes;

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

import com.googlecode.fahview.v6project.WorkProject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 * <p>WorkNodeFactory class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
@NodeFactory.Registration(projectType = "com-googlecode-fahview-work", position = 10)
public class WorkNodeFactory implements NodeFactory {

    /** {@inheritDoc} */
    @Override
    public NodeList<?> createNodes(Project p) {
        WorkProject project = p.getLookup().lookup(WorkProject.class);
        assert project != null;
        return new WorkNodeList(project);
    }

    private class WorkNodeList implements NodeList<Node> {

        private final Project project;

        public WorkNodeList(Project project) {
            this.project = project;
        }

        @Override
        public List<Node> keys() {
            FileObject projectDirectory = project.getProjectDirectory();

            List<Node> result = new ArrayList<Node>();
            try {
                FileObject work = projectDirectory.getFileObject("current.xyz");
                result.add(DataObject.find(work).getNodeDelegate());

                for(int i = 0; i <= 9; i++)
                {
                    FileObject log = projectDirectory.getFileObject("logfile_0" + i + ".txt");
                    FileObject data = projectDirectory.getFileObject("wudata_0" + i + ".log");
                    if(log != null)
                        result.add(DataObject.find(log).getNodeDelegate());
                    if(data != null)
                        result.add(DataObject.find(data).getNodeDelegate());
                }

            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            return result;
        }

        @Override
        public void addChangeListener(ChangeListener l) {}

        @Override
        public void removeChangeListener(ChangeListener l) {}

        @Override
        public Node node(Node key) {
            return new FilterNode(key);
        }

        @Override
        public void addNotify() {}

        @Override
        public void removeNotify() {}
    }
}
