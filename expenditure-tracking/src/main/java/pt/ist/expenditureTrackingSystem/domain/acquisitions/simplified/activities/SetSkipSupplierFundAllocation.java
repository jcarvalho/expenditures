/*
 * @(#)SetSkipSupplierFundAllocation.java
 *
 * Copyright 2009 Instituto Superior Tecnico
 * Founding Authors: Luis Cruz, Nuno Ochoa, Paulo Abrantes
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Expenditure Tracking Module.
 *
 *   The Expenditure Tracking Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The Expenditure Tracking Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Expenditure Tracking Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package pt.ist.expenditureTrackingSystem.domain.acquisitions.simplified.activities;

import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import pt.ist.bennu.core.domain.User;
import pt.ist.bennu.core.util.BundleUtil;
import pt.ist.expenditureTrackingSystem.domain.ExpenditureTrackingSystem;
import pt.ist.expenditureTrackingSystem.domain.acquisitions.RegularAcquisitionProcess;
import pt.ist.expenditureTrackingSystem.domain.acquisitions.simplified.SimplifiedProcedureProcess;
import pt.ist.expenditureTrackingSystem.domain.organization.Person;

/**
 * 
 * @author Paulo Abrantes
 * @author Luis Cruz
 * @author João Alfaiate
 * 
 */
public class SetSkipSupplierFundAllocation extends
        WorkflowActivity<RegularAcquisitionProcess, ActivityInformation<RegularAcquisitionProcess>> {

    @Override
    public boolean isActive(RegularAcquisitionProcess process, User user) {
        Person person = user.getExpenditurePerson();
        return isUserProcessOwner(process, user)
                && !process.getShouldSkipSupplierFundAllocation().booleanValue()
                && (process instanceof SimplifiedProcedureProcess && ((SimplifiedProcedureProcess) process)
                        .getProcessClassification().isCCP())
                && ((process.getAcquisitionProcessState().isInGenesis() && person == process.getRequestor() || (ExpenditureTrackingSystem
                        .isAcquisitionCentralGroupMember(user) && ((process.getAcquisitionProcessState().isAuthorized() && process
                        .isCommitted()) || process.getAcquisitionProcessState().isAcquisitionProcessed() || process
                            .isInvoiceReceived()))) || ExpenditureTrackingSystem.isSupplierFundAllocationManagerGroupMember());
    }

    @Override
    protected void process(ActivityInformation<RegularAcquisitionProcess> activityInformation) {
        activityInformation.getProcess().skipSupplierFundAllocation();
    }

    @Override
    public String getLocalizedName() {
        return BundleUtil.getStringFromResourceBundle(getUsedBundle(), "label." + getClass().getName());
    }

    @Override
    public String getUsedBundle() {
        return "resources/AcquisitionResources";
    }

}
