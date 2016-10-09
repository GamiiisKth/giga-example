package dependencyInject;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         page 57
 *         <p>
 *         In  order  to  use  the  agent  finders,  the  project  has  a  default
 *         HollywoodService class that gets a list of agents from a SpreadsheetAgentFinder
 */
public class HollywoodService {

    /**
     * look which problem we have ,
     * how the code is locked in to using the SpreadsheetAgentFinder
     * implementation of the AgentFind, which AgentFind has 2 implementation class
     * <p>
     * read page   58
     * <p>
     * solution is HOLLYWOOD SERVICE WITH FACTORY AND / OR SERVICE LOCATOR PATTERNS
     * <p>
     * BUT!!!
     * As developers moved toward writing cleaner code, the technique of
     * DI became more widely used, often replacing Factory and Service Locator pattern implementations.
     */
    private static List<Agent> agentList = new ArrayList<>();

    public static List<Agent> getFriendlyAgents() {
        AgentFinder finder = new SpreadsheetAgentFinder();
        List<Agent> agents = finder.findAllAgents();

        return filterAgents(agentList, "javaDeveloper");

    }

    private static List<Agent> filterAgents(List<Agent> agents, String agentType) {
        agents.forEach(agent -> {
            if (agent.getFirstName().equals(agentType)) {
                agentList.add(agent);
            }

        });
        return agentList;
    }


    /**
     * DI HollywoodService with hand-rolled DI for AgentFinder
     * <p>
     * page 59
     */

    private static class HollywoodWithDi {
        // Inject AgentFinder,
        public static List<Agent> getFriendlyAgents(AgentFinder finder) {

            List<Agent> agents = finder.findAllAgents();

            return filterAgents(agents, "javaDeveloper");

        }

        private static List<Agent> filterAgents(List<Agent> agents, String agentType) {
            agents.forEach(agent -> {
                if (agent.getFirstName().equals(agentType)) {
                    agentList.add(agent);
                }
            });
            return agentList;
        }

        public static void main(String[] args) {

            // now you can see how we use Di, it's not any more depends on
            // one implementation class
            getFriendlyAgents(new SpreadsheetAgentFinder());
            getFriendlyAgents(new WebServiceAgentFinder());
        }
    }

    /**
     * page 59
     */
    private static class HollyWoodServiceWithJSR330 {
//https://www.mkyong.com/spring3/spring-3-and-jsr-330-inject-and-named-example/

        // JSR-330 injected AgentFinder
        @Inject
        public void getFriendlyAgent(AgentFinder agentFinder) {

            /**
             * A specific implementation of AgentFinder
             (for example, WebServiceAgentFinder) is now injected at runtime by the
             DI framework that supports the JSR-330 @Inject annotation
             */

            /**
             * and the rest of code as above
             */


        }
    }
}
