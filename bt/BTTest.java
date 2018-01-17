/**
 * 
 */
package bt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author
 *
 */

public class BTTest {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 */

	public static void main(String[] args) throws IOException {
		//get file from path args[0] when running command line
		Path path = FileSystems.getDefault().getPath(args[0]);
		ServerStatus sers = new ServerStatus();
		
		try (Stream<String>lines = Files.lines(path)){
			lines.forEach(s ->sers.event_process(new Event(s)));
		} catch (IOException ex) {
			System.out.println("Sorry there's been an error");
		}
		System.out.println(sers);
	}

}
