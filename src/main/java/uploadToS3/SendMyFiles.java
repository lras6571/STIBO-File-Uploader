package uploadToS3;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

public class SendMyFiles {

    static Properties props;

    public static void main(String[] args) {

        SendMyFiles sendMyFiles = new SendMyFiles();
        if (args.length < 1)
        {
            System.err.println("Usage: java " + sendMyFiles.getClass().getName()+
                    " Properties_file File_To_FTP ");
            System.exit(1);
        }

        String propertiesFile = args[0].trim();
        String fileToFTP = args[1].trim();
        sendMyFiles.startFTP(propertiesFile, fileToFTP);

    }

    public boolean startFTP(String propertiesFilename, String fileToFTP){

        props = new Properties();
        StandardFileSystemManager manager = new StandardFileSystemManager();

        try {

            props.load(new FileInputStream("properties/" + propertiesFilename));
            String serverAddress = "syscononprod-sandbox.scloud.stibo.com";
            String password = "Stib0sw!";
            String userId = "stibosw";
            String remoteDirectory = props.getProperty("remoteDirectory").trim();
            String localDirectory = props.getProperty("localDirectory").trim();

            //check if the file exists
            String filepath = localDirectory +  fileToFTP;
            File file = new File(filepath);
            if (!file.exists())
                throw new RuntimeException("Error. Local file not found");

            //Initializes the file manager
            manager.init();

            //Setup our SFTP configuration
            FileSystemOptions opts = new FileSystemOptions();
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(
                    opts, "no");
            SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
            SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

            //Create the SFTP URI using the host name, userid, password,  remote path and file name
            String sftpUri = "sftp://" + userId + ":" + password +  "@" + serverAddress + "/" +
                    remoteDirectory + fileToFTP;

            // Create local file object
            FileObject localFile = manager.resolveFile(file.getAbsolutePath());

            // Create remote file object
            FileObject remoteFile = manager.resolveFile(sftpUri, opts);

            // Copy local file to sftp server
            remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);
            System.out.println("File upload successful");

        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            manager.close();
        }

        return true;
    }


}