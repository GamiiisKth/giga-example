package dependencyInject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class SpreadsheetAgentFinder implements AgentFinder {
    private List<Agent> agents = new ArrayList<>();

    public List<Agent> getAgents() {
        return agents;
    }


    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    @Override
    public List<Agent> findAllAgents() {
        return getAgents();

    }
}
