package uploadToS3;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class uploadFile {

    @Test
    public void send() throws Exception {

        String SFTPHOST = "syscononprod-sandbox.scloud.stibo.com";
        int SFTPPORT = 22;
        String SFTPUSER = "stibosw";
        String SFTPPASS = "Stib0sw!";
        String SFTPWORKINGDIR = "/upload/hotfolders/sysco/mdm/customer/inbound/billTo/test";
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
            System.out.println("FILE NAME4444444444 ::::::::::::");
            System.out.println("FILE NAME55555555 ::::::::::::");

            String fileName = "nightly_data_replication.txt";

// BufferedInputStream bis = new

// BufferedInputStream(channelSftp.get(fileName));

            System.out.println("FILE NAME11111111111 ::::::::::::" + fileName);

            File f = new File("fileName");

                    System.out.println("FILE NAME222222222 ::::::::::::" + fileName);

            channelSftp.put(new FileInputStream(f), f.getName());

            System.out.println("FILE NAME333333333 ::::::::::::" + fileName);

        } catch (Exception ex) {

            System.out.println("Exception found while transfer the response.");

            throw new Exception();

        } finally {

            channelSftp.exit();

            System.out.println("sftp Channel exited.");

            channel.disconnect();

            System.out.println("Channel disconnected.");

            session.disconnect();

            System.out.println("Host Session disconnected.");

        }

    }
}

//https://www.quora.com/How-do-I-upload-files-to-SFTP-server-using-Java