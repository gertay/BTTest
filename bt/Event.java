/**
 * 
 */
package bt;

/**
 * @author
 *
 */

public class Event {

	long received;
	long sent;
	String node;
	ServerMsg msg;
	String other_node = "";
	ServerState node_state;

	public Event(String text) {
		String[] t = text.split("\\s+");

		this.received = Long.parseLong(t[0]);
		this.sent = Long.parseLong(t[1]);
		this.node = t[2];
		this.msg = ServerMsg.valueOf(t[3]);

		if (this.msg != ServerMsg.HELLO)
			this.other_node = t[4];

		if (this.msg == ServerMsg.HELLO || this.msg == ServerMsg.FOUND)
			this.node_state = ServerState.ALIVE;
		else
			this.node_state = ServerState.DEAD;
	}

	public String contacted_node() {
		if (this.msg == ServerMsg.HELLO)
			return this.node;
		return this.other_node;
	}

	@Override
	public String toString() {
		if(this.msg == ServerMsg.HELLO ) {
			return String.format("%s %s", this.msg, this.contacted_node());
		} else {
			return String.format("%s %s %s", this.node, this.msg, this.contacted_node());
		}
	}
}
