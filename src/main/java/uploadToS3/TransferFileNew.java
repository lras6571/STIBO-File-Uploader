package uploadToS3;

import com.jcraft.jsch.*;
import org.junit.Test;

public class TransferFileNew {

    public ChannelSftp setupJsch() throws JSchException {
//        String remoteHost = "syscononprod-sandbox.scloud.stibo.com";
        String remoteHost = "sftp://stibosw@syscononprod-sandbox.scloud.stibo.com";
        String username = "stibosw";
        String password = "Stib0sw!";
        JSch jsch = new JSch();
//        jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
        Session jschSession = jsch.getSession(username, remoteHost);
        jschSession.setPassword(password);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    @Test
    public void whenUploadFileUsingJsch_thenSuccess() throws JSchException, SftpException {
        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();

        String localFile = "C:\\STEP\\FF_BILL_TO_clean_293_TEMP.txt";
        String remoteDir = "/upload/hotfolders/sysco/mdm/customer/inbound/billTo/test";

        channelSftp.put(localFile, remoteDir + "jschFile.txt");

        channelSftp.exit();
    }
}
