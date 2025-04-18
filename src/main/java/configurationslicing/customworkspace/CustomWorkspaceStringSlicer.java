package configurationslicing.customworkspace;

import configurationslicing.project.AbstractSimpleProjectSlicer;
import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.FreeStyleProject;
import java.io.IOException;

/**
 * @author jacob_robertson
 */
@Extension
public class CustomWorkspaceStringSlicer extends AbstractSimpleProjectSlicer {

    public CustomWorkspaceStringSlicer() {
        super(new CustomWorkspaceStringSliceSpec());
    }

    public static class CustomWorkspaceStringSliceSpec
            extends AbstractSimpleProjectSlicer.AbstractSimpleProjectSliceSpec {

        public String getName() {
            return "Custom Workspace Slicer";
        }

        public String getUrl() {
            return "customworkspace";
        }

        @Override
        protected String getValue(AbstractProject item) {
            if (item instanceof FreeStyleProject project) {
                String ws = project.getCustomWorkspace();
                return ws;
            } else {
                return null;
            }
        }

        @Override
        protected void setValue(AbstractProject item, String value) throws IOException {
            if (item instanceof FreeStyleProject project) {
                project.setCustomWorkspace(value);
            }
        }
    }
}
