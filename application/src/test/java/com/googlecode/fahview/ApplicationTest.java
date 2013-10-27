package com.googlecode.fahview;

/*
 * #%L
 * This file is part of FAHView-app.
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

import java.util.logging.Level;
import junit.framework.Test;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.junit.NbTestCase;

/**
 * <p>ApplicationTest class.</p>
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 * @since 1.0
 */
public class ApplicationTest extends NbTestCase {

    /**
     * <p>suite.</p>
     *
     * @return a {@link junit.framework.Test} object.
     */
    public static Test suite() {
        return NbModuleSuite.createConfiguration(ApplicationTest.class).
                gui(false).
                failOnMessage(Level.WARNING). // works at least in RELEASE71
                failOnException(Level.INFO).
                suite(); // RELEASE71+, else use NbModuleSuite.create(NbModuleSuite.createConfiguration(...))
    }

    /**
     * <p>Constructor for ApplicationTest.</p>
     *
     * @param n a {@link java.lang.String} object.
     */
    public ApplicationTest(String n) {
        super(n);
    }

    /**
     * <p>testApplication.</p>
     */
    public void testApplication() {
        // pass if there are merely no warnings/exceptions
        /* Example of using Jelly Tools with gui(true):
        new ActionNoBlock("Help|About", null).performMenu();
        new NbDialogOperator("About").closeByButton();
         */
    }
}
