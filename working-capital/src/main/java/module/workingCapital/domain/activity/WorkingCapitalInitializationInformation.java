/*
 * @(#)WorkingCapitalInitializationInformation.java
 *
 * Copyright 2010 Instituto Superior Tecnico
 * Founding Authors: Luis Cruz
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Working Capital Module.
 *
 *   The Working Capital Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The Working Capital Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Working Capital Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package module.workingCapital.domain.activity;

import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import module.workingCapital.domain.WorkingCapitalInitialization;
import module.workingCapital.domain.WorkingCapitalProcess;

/**
 * 
 * @author Luis Cruz
 * 
 */
public class WorkingCapitalInitializationInformation extends ActivityInformation<WorkingCapitalProcess> {

    private WorkingCapitalInitialization workingCapitalInitialization;

    public WorkingCapitalInitializationInformation(final WorkingCapitalProcess workingCapitalProcess,
            final WorkflowActivity<WorkingCapitalProcess, ? extends ActivityInformation<WorkingCapitalProcess>> activity) {
        super(workingCapitalProcess, activity);
    }

    public WorkingCapitalInitialization getWorkingCapitalInitialization() {
        return workingCapitalInitialization;
    }

    public void setWorkingCapitalInitialization(WorkingCapitalInitialization workingCapitalInitialization) {
        this.workingCapitalInitialization = workingCapitalInitialization;
    }

    @Override
    public boolean hasAllneededInfo() {
        return getWorkingCapitalInitialization() != null;
    }

}
