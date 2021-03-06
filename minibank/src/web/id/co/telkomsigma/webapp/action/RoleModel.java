package id.co.telkomsigma.webapp.action;

import java.util.List;

import org.apache.tapestry.form.IPropertySelectionModel;

import id.co.telkomsigma.model.LabelValue;

public class RoleModel implements IPropertySelectionModel {
    private List roles = null;

    public RoleModel(List roles) {
        this.roles = roles;
    }

    public int getOptionCount() {
        return this.roles.size();
    }

    public Object getOption(int index) {
        LabelValue option = (LabelValue) this.roles.get(index);

        return option.getValue();
    }

    public String getLabel(int index) {
        LabelValue option = (LabelValue) this.roles.get(index);

        return option.getLabel();
    }

    public String getValue(int index) {
        LabelValue option = (LabelValue) this.roles.get(index);

        return option.getValue();
    }

    public Object translateValue(String value) {
        return value;
    }
}
