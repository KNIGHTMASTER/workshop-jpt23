package id.co.telkomsigma.webapp.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tapestry.engine.IEngineService;
import org.apache.tapestry.form.IFormComponent;
import org.apache.tapestry.valid.IValidationDelegate;
import org.apache.tapestry.valid.ValidationConstraint;
import org.apache.tapestry.valid.ValidationDelegate;
import id.co.telkomsigma.Constants;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public abstract class BasePage extends org.apache.tapestry.html.BasePage {
    protected final Log log = LogFactory.getLog(getClass());
    public abstract HttpServletRequest getRequest();
    public abstract HttpServletResponse getResponse();
    public abstract IEngineService getEngineService();
    public abstract String getMessage();
    public abstract void setMessage(String message);

    protected ValidationDelegate getDelegate() {
        // be nice to unit tests
        if (getSpecification() != null) {
            return (ValidationDelegate) getBeans().getBean("delegate");
        } else {
            return new ValidationDelegate();
        }
    }

    protected void addError(IValidationDelegate delegate, String componentId,
                            String message, ValidationConstraint constraint) {
        IFormComponent component = (IFormComponent) getComponent(componentId);

        delegate.setFormComponent(component);
        delegate.record(message, constraint);
    }

    /**
     * Convenience method to get the Configuration HashMap
     * from the servlet context.
     *
     * @return the user's populated form from the session
     */
    protected Map getConfiguration() {
        Map config = (HashMap) getServletContext().getAttribute(Constants.CONFIG);

        // so unit tests don't puke when nothing's been set
        if (config == null) {
            return new HashMap();
        }

        return config;
    }

    
    /**
     * Convenience method for unit tests.
     * @return boolean
     */
    public boolean hasErrors() {
        return (getSession().getAttribute("errors") != null);
    }

    public ServletContext getServletContext() {
        return getSession().getServletContext();
    }
    
    protected HttpSession getSession() {
        return getRequest().getSession();
    }
    
    protected String getText(String key) {
        return getMessages().getMessage(key);
    }
    
    protected String getText(String key, Object arg) {
        if (arg == null) {
            return getText(key);
        }

        if (arg instanceof String) {
            return getMessages().format(key, arg);
        } else if (arg instanceof Object[]) {
            return getMessages().format(key, (Object[]) arg);
        } else {
            log.error("argument '" + arg + "' not String or Object[]");
            return "";
        }
    }
}
