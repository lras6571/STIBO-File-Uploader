package transfer;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class SendFiles {

    public static void main(String[] args) throws Exception {

        String user = "stibosw";
        String host = "syscononprod-sandbox.scloud.stibo.com";
        int port = 22;
        String pass = "Stib0sw!";
        Session session = SetupConnection.setupConnection(user, host, port, pass);
        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        String localFile = "C:\\STEP\\FF_BILL_TO_clean_293_TEMP1.txt"; //source file path
        String remoteDir = "/upload/hotfolders/sysco/mdm/customer/inbound/billTo/test"; //target directory
        channelSftp.put(localFile, remoteDir);
        channelSftp.exit();
        System.out.println("File Transfer Success");

    }

}