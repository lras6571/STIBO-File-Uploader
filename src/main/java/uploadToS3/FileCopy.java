//package uploadToS3;
//
//public class FileCopy {
//
//    public void whenUploadFileUsingVfs_thenSuccess() throws IOException {
//
//        private String remoteHost = "ftp.example.com";
//        private String username = "ftpuser";
//        private String password = "ftppassword";
//
//        FileSystemManager manager = VFS.getManager();
//
//        FileObject local = manager.resolveFile(
//                System.getProperty("user.dir") + "/" + localFile);
//        FileObject remote = manager.resolveFile(
//                "sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir + "vfsFile.txt");
//
//        remote.copyFrom(local, Selectors.SELECT_SELF);
//
//        local.close();
//        remote.close();
//    }
//}
