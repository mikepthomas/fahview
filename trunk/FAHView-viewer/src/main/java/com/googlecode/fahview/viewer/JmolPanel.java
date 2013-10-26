package com.googlecode.fahview.viewer;

/*
 * #%L
 * This file is part of FAHView-viewer.
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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;
import org.jmol.adapter.smarter.SmarterJmolAdapter;
import org.jmol.api.JmolViewer;

/**
 * Class to embed Jmol 3D Molecule Viewer into FAHView.
 *
 * @see <a href="http://wiki.jmol.org/index.php/Applications_Embedding_Jmol">
 * Jmol Wiki - Applications Embedding</a>
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class JmolPanel extends JPanel {

    private JmolViewer viewer;
    private final Dimension currentSize = new Dimension();
    private final Rectangle rectClip = new Rectangle(); // ignored by Jmol

    /**
     * Constructor to initialize JmolPanel
     */
    public JmolPanel() {
        setViewer();
    }

    /**
     * Set the JPanel to the Jmol viewer
     */
    private void setViewer() {
        viewer = JmolViewer.allocateViewer(this, new SmarterJmolAdapter());
    }

    /**
     * Get the Jmol viewer
     *
     * @return a {@link org.jmol.api.JmolViewer} object.
     */
    public JmolViewer getViewer()
    {
        return viewer;
    }

    /**
     * {@inheritDoc}
     *
     * Override paint to allow Jmol to refresh
     */
    @Override
    public void paint(Graphics g) {
        getSize(currentSize);
        g.getClipBounds(rectClip);
        viewer.renderScreenImage(g, currentSize, rectClip);
    }
}
