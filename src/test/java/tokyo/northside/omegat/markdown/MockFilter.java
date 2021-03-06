/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2016 Hiroshi Miura
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package tokyo.northside.omegat.markdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mock of OmegatMarkdownFilter.
 * Created by miurahr on 16/09/08.
 */

public class MockFilter extends OmegatMarkdownFilter {
    private List<String> entries = new ArrayList<>();

    public MockFilter() {
        super();
        printer = new MockPrinter();
    }

    /**
     * Mock for putEntry()
     * <p>
     * Store to local variable instead of writing file.
     * It don't call translation.
     *
     * @param text entry text
     * @param trans entry to be translated.
     */
    @Override
    void writeTranslate(final String text, final boolean trans) {
        if (trans) {
            entries.add(text);
        }
        try {
            printer.write(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    void setMode(final int status) {
        printer.setMode(status);
    }

    /** for test */
    List<String> getEntries() {
        return entries;
    }

    /**
     * Get buffer contents for Test.
     */
    String getOutbuf() {
        return printer.getOutput();
    }
}
