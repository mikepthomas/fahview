/* %%Ignore-License */
package com.googlecode.fahview.v6project.utilities;

import java.awt.Component;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Class to Add JProgressBar into a JTable Cell.
 *
 * @see <a href="http://fahdshariff.blogspot.com/2009/12/adding-jprogressbar-to-jtable-cell.html">
 * fahd.blog - Adding a JProgressBar to a JTable Cell</a>
 * @author Fahd Shariff
 * @version $Id: $Id
 */
public class ProgressCellRenderer extends JProgressBar
        implements TableCellRenderer {

    /**
     * Creates a JProgressBar with the range 0,100.
     */
    public ProgressCellRenderer() {
        super(0, 100);
        setValue(0);
        setString("0%");
        setStringPainted(true);
    }

    /** {@inheritDoc} */
    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        //value is a percentage e.g. 95%
        final String sValue = value.toString();
        int index = sValue.indexOf('%');
        if (index != -1) {
            int p = 0;
            try {
                p = Integer.parseInt(sValue.substring(0, index));
            }
            catch (NumberFormatException e) {
            }
            setValue(p);
            setString(sValue);
        }
        return this;
    }
}
