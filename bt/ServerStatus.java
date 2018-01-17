/**
 * 
 */
package bt;

import java.util.HashMap;

/**
 * @author
 *
 */

public class ServerStatus {
	// create a hashmap with String keys & values from event class
	// default values are kept but can be increased if more nodes are included
	HashMap<String, Event> status;

	public ServerStatus() {
		this.status = new HashMap<String, Event>();
	}

	public void event_process(Event e) {
		// check if the contacted node should be stored
		Event cont = this.status.get(e.contacted_node());
		if (cont == null || (e.received - cont.received) >= 50) {
			this.status.put(e.contacted_node(), e);
		}

		// check if the reporting node should be stored
		Event alive = this.status.get(e.node);
		if (alive == null || (e.received - alive.received) >= 50) {
			e.node_state = ServerState.ALIVE;
			this.status.put(e.node, e);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String node : this.status.keySet()) {
			Event e = this.status.get(node);
			sb.append(String.format("%s %s %s %s\n", node, e.node_state, e.received, e));
		}
		return sb.toString();
	}
}
