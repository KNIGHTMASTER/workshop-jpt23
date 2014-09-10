package id.co.telkomsigma.webapp.action;

import java.io.IOException;

import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.engine.IEngineService;
import org.apache.tapestry.engine.ILink;
import id.co.telkomsigma.webapp.listener.StartupListener;

public abstract class Reload extends BasePage {
    public abstract IEngineService getEngineService();

    public ILink execute(IRequestCycle cycle) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'execute' method");
        }

        StartupListener.setupContext(getServletContext());
        MainMenu nextPage = (MainMenu) cycle.getPage("mainMenu");
        nextPage.setMessage(getText("reload.succeeded"));            
        return getEngineService().getLink(false, nextPage.getPageName());
    }
}
