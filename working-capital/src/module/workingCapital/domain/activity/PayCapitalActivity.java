package module.workingCapital.domain.activity;

import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import module.workingCapital.domain.WorkingCapital;
import module.workingCapital.domain.WorkingCapitalInitialization;
import module.workingCapital.domain.WorkingCapitalProcess;
import module.workingCapital.domain.WorkingCapitalRequest;
import module.workingCapital.domain.WorkingCapitalSystem;
import myorg.domain.User;
import myorg.util.BundleUtil;

public class PayCapitalActivity extends WorkflowActivity<WorkingCapitalProcess, PayCapitalActivityInformation> {

    @Override
    public String getLocalizedName() {
	return BundleUtil.getStringFromResourceBundle("resources/WorkingCapitalResources", "activity." + getClass().getSimpleName());
    }

    @Override
    public boolean isActive(final WorkingCapitalProcess missionProcess, final User user) {
	final WorkingCapital workingCapital = missionProcess.getWorkingCapital();
	final WorkingCapitalSystem workingCapitalSystem = WorkingCapitalSystem.getInstance();
	if (workingCapital.isCanceledOrRejected() || !workingCapital.isTreasuryMember(user)) {
	    return false;
	}
	for (final WorkingCapitalRequest workingCapitalRequest : workingCapital.getWorkingCapitalRequestsSet()) {
	    if (workingCapitalRequest.getProcessedByTreasury() == null) {
		return true;
	    }
	}
	return false;
    }

    @Override
    protected void process(final PayCapitalActivityInformation payCapitalActivityInformation) {
	final WorkingCapitalRequest workingCapitalRequest = payCapitalActivityInformation.getWorkingCapitalRequest();
	workingCapitalRequest.pay(getLoggedPerson());
    }

    @Override
    public ActivityInformation<WorkingCapitalProcess> getActivityInformation(final WorkingCapitalProcess process) {
        return new PayCapitalActivityInformation(process, this);
    }

    @Override
    public boolean isDefaultInputInterfaceUsed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

}