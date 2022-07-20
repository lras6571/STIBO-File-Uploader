//package uploadToS3;
//
//import com.jcraft.jsch.*;
//
//public class FileTransfer {
//
//    private static final String REMOTE_HOST = "sftp://stibosw@syscononprod-sandbox.scloud.stibo.com";
////    private static final String REMOTE_HOST = "syscononprod-sandbox.scloud.stibo.com";
//    private static final String USERNAME = "stibosw";
//    private static final String PASSWORD = "Stib0sw!";
//    private static final int REMOTE_PORT = 22;
//    private static final int SESSION_TIMEOUT = 10000;
//    private static final int CHANNEL_TIMEOUT = 5000;
//
//    public static void main(String args[]) {
//        String localFile = "C:\\STEP\\FF_BILL_TO_clean_293_TEMP.txt";
//        String remoteFile = "/upload/hotfolders/sysco/mdm/customer/inbound/billTo/test/FF_BILL_TO_clean_293_TEMP.txt";
//        Session jschSession = null;
//        try {
//            JSch jsch = new JSch();
//            jsch.setKnownHosts("/home/javatpoint/.ssh/known_hosts");
//            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);
//            // authenticate using password
//            jschSession.setPassword(PASSWORD);
//            // 10 seconds session timeout
//            jschSession.connect(SESSION_TIMEOUT);
//            Channel sftp = jschSession.openChannel("sftp");
//            // 5 seconds timeout
//            sftp.connect(CHANNEL_TIMEOUT);
//            ChannelSftp channelSftp = (ChannelSftp) sftp;
//            // transfer file from local to remote server
//            channelSftp.put(localFile, remoteFile);
//            channelSftp.exit();
//        } catch (SftpException | JSchException e) {
//            e.printStackTrace();
//        } finally {
//            if (jschSession != null) {
//                jschSession.disconnect();
//            }
//        }
//        System.out.println("Done");
//    }
//}
