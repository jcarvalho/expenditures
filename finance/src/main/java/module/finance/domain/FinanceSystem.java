/*
 * @(#)FinanceSystem.java
 *
 * Copyright 2010 Instituto Superior Tecnico
 * Founding Authors: Luis Cruz
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Finance Module.
 *
 *   The Finance Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The Finance Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Finance Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package module.finance.domain;

import org.fenixedu.bennu.core.domain.Bennu;

import pt.ist.fenixframework.Atomic;

/**
 * 
 * @author Luis Cruz
 * 
 */
public final class FinanceSystem extends FinanceSystem_Base {

    public static FinanceSystem getInstance() {
        FinanceSystem system = Bennu.getInstance().getFinanceSystem();
        if (system == null) {
            return initialize();
        }
        return system;
    }

    @Atomic
    private static FinanceSystem initialize() {
        if (Bennu.getInstance().getFinanceSystem() == null) {
            return new FinanceSystem();
        }
        return Bennu.getInstance().getFinanceSystem();
    }

    private FinanceSystem() {
        super();
        setBennu(Bennu.getInstance());
    }

}
