package transfer;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SetupConnection {

    public static Session setupConnection(String user, String host, int port, String pass) throws JSchException {

        JSch jsch = new JSch();

        Session session = jsch.getSession(user, host, port);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(pass);
        session.connect();
        System.out.println("Connection established.");
        System.out.println("Creating SFTP Channel.");
        return session;

    }

}