package com.googlecode.fahview.v6project.properties;

/*
 * #%L
 * FAHView-v6project
 * %%
 * Copyright (C) 2011 - 2013 Michael Thomas <mikepthomas@outlook.com>
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

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 * <p>GeneralClientProperties class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class GeneralClientProperties
    implements ProjectCustomizer.CompositeCategoryProvider {

    private static final String GENERAL = "General";

    /**
     * <p>createGeneral.</p>
     *
     * @return a {@link com.googlecode.fahview.v6project.properties.GeneralClientProperties} object.
     */
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "com-googlecode-fahview", position = 10)
    public static GeneralClientProperties createGeneral() {
        return new GeneralClientProperties();
    }

    /** {@inheritDoc} */
    @NbBundle.Messages("LBL_Config_General=General")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create(
                GENERAL,
                Bundle.LBL_Config_General(),
                null);
    }

    /** {@inheritDoc} */
    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        return new JPanel();
    }
}