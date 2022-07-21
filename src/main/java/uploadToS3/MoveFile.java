package uploadToS3;

import com.jcraft.jsch.*;

public class MoveFile {
    public static void main(String args[]) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("stibosw", "syscononprod-sandbox.scloud.stibo.com", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("Stib0sw!");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            String localFile = "C:/STEP/FF_BILL_TO_clean_293_TEMP1.txt";
            String remoteDir = "/upload/hotfolders/sysco/mdm/customer/inbound/billTo/test";
            System.out.println("File transferred successfully to host");


            sftpChannel.put(localFile, remoteDir + "jschFile1.txt");
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
}