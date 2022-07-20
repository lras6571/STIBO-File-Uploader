//package uploadToS3;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
//
//import java.io.File;
//import java.io.FileInputStream;
//
//public class transferFile {
//
//    public static void main(String[] fileName) {
//
//        String SFTPHOST = "sftp://syscononprod-sandbox.scloud.stibo.com";
//        int SFTPPORT = 22;
//        String SFTPUSER = "stibosw";
//        String SFTPPASS = "Stib0sw!";
//        String SFTPWORKINGDIR = "C:\\STEP";
//
//        Session session = null;
//        Channel channel = null;
//        ChannelSftp channelSftp = null;
//        System.out.println("preparing the host information for sftp.");
//
//        try {
//            JSch jsch = new JSch();
//            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
//            session.setPassword(SFTPPASS);
//            java.util.Properties config = new java.util.Properties();
//            config.put("StrictHostKeyChecking", "no");
//            session.setConfig(config);
//            session.connect();
//            System.out.println("Host connected.");
//            channel = session.openChannel("sftp");
//            channel.connect();
//            System.out.println("sftp channel opened and connected.");
//            channelSftp = (ChannelSftp) channel;
//            channelSftp.cd(SFTPWORKINGDIR);
//            File f = new File(String.valueOf(fileName));
//            channelSftp.put(new FileInputStream(f), f.getName());
//            System.out.println("File transfered successfully to host.");
//        } catch (Exception ex) {
//            System.out.println("Exception found while tranfer the response.");
////        } finally {
////            channelSftp.exit();
////            System.out.println("sftp Channel exited.");
////            channel.disconnect();
////            System.out.println("Channel disconnected.");
////            session.disconnect();
////            System.out.println("Host Session disconnected.");
////        }
//        }
//    }
//}
