/*
 *
 *
 * Copyright  1990-2007 Sun Microsystems, Inc. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License version
 * 2 only, as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License version 2 for more details (a copy is
 * included at /legal/license.txt).
 * 
 * You should have received a copy of the GNU General Public License
 * version 2 along with this work; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA
 * 
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa
 * Clara, CA 95054 or visit www.sun.com if you need additional
 * information or have any questions.
 */
package javax.microedition.location;

/**
 * This class is defined by the JSR-179 specification
 * <em>Location API for J2ME for J2ME&trade;.</em>
 */
// JAVADOC COMMENT ELIDED
public class Location {
    // JAVADOC COMMENT ELIDED
    public final static int MTE_SATELLITE = 0x00000001;

    // JAVADOC COMMENT ELIDED
    public final static int MTE_TIMEDIFFERENCE = 0x00000002;

    // JAVADOC COMMENT ELIDED
    public final static int MTE_TIMEOFARRIVAL = 0x00000004;

    // JAVADOC COMMENT ELIDED
    public final static int MTE_CELLID = 0x00000008;

    // JAVADOC COMMENT ELIDED
    public final static int MTE_SHORTRANGE = 0x00000010;

    // JAVADOC COMMENT ELIDED
    public final static int MTE_ANGLEOFARRIVAL = 0x00000020;

    // JAVADOC COMMENT ELIDED
    public final static int MTY_TERMINALBASED = 0x00010000;

    // JAVADOC COMMENT ELIDED
    public final static int MTY_NETWORKBASED = 0x00020000;

    // JAVADOC COMMENT ELIDED
    public final static int MTA_ASSISTED = 0x00040000;

    // JAVADOC COMMENT ELIDED
    public final static int MTA_UNASSISTED = 0x00080000;

    // JAVADOC COMMENT ELIDED
    protected Location() {
    }

    // JAVADOC COMMENT ELIDED
    public boolean isValid() {
        return false;
    }

    // JAVADOC COMMENT ELIDED
    public long getTimestamp() {
        return 0;
    }

    // JAVADOC COMMENT ELIDED
    public QualifiedCoordinates getQualifiedCoordinates() {
        return null;
    }

    // JAVADOC COMMENT ELIDED
    public float getSpeed() {
        return 0;
    }

    // JAVADOC COMMENT ELIDED
    public float getCourse() {
        return 0;
    }

    // JAVADOC COMMENT ELIDED
    public int getLocationMethod() {
        return 0;
    }

    // JAVADOC COMMENT ELIDED
    public AddressInfo getAddressInfo() {
        return null;
    }

    // JAVADOC COMMENT ELIDED
    public String getExtraInfo(String mimetype) {
        return null;
    }
}
