package dependencyInject;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *
 * AgentFinder interface  with  two  implementations,  a SpreadsheetAgentFinder and WebServiceAgentFinder
 */
public interface AgentFinder {

    public List<Agent> findAllAgents();
}
