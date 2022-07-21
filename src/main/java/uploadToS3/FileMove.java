package uploadToS3;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

public class FileMove {

    @Test
    public void send() {

        String SFTPHOST = "syscononprod-sandbox.scloud.stibo.com";
        int SFTPPORT = 22;
        String SFTPUSER = "stibosw";
        String SFTPPASS = "Stib0sw!";
        String SFTPWORKINGDIR = "file/to/transfer";
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        System.out.println("preparing the host information for sftp.");

        try {

            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            System.out.println("Host connected.");
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("sftp channel opened and connected.");
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
//            File f = new File(fileName);

            String localFile = "C:\\STEP\\FF_BILL_TO_clean_293_TEMP1.txt";
            String remoteDir = "/upload/hotfolders/sysco/mdm/customer/inbound/billTo/test";

            channelSftp.put(localFile, remoteDir + "jschFile.txt");

//            channelSftp.put(new FileInputStream(f), f.getName());
            System.out.println("File transfered successfully to host");

        } catch (Exception ex) {

            System.out.println("Exception found while transfer the response");

        } finally {

            channelSftp.exit();
            System.out.println("sftp Channel exited");
            channel.disconnect();
            System.out.println("Channel disconnected.");
            session.disconnect();
            System.out.println("Host Session disconnected.");

        }

    }
}
