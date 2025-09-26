
import java.net.*;
import java.io.*;
public class SocketServer {
    public static void main(String[] args) throws Exception {
        ServerSocket servSocket= new ServerSocket(4000);
        System.out.println("***Server Side****");
        System.out.println("Serve ready for connection");
        Socket connSock=servSocket.accept();
        System.out.println("Connection is successful and ready forr file transfer");
        InputStream istream=connSock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        File filename=new File(fname);
        OutputStream ostream=connSock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        if(filename.exists()){
            BufferedReader contentRead=new BufferedReader(new FileReader(fname));
            System.out.println("Writing file content to the socket");
            String str;
            while((str=contentRead.readLine())!=null){
        pwrite.println(str);
        }
    contentRead.close();
    }else{
System.out.println("Requested file does not exist");
String msg="Requested file doesnt exist at server side";
pwrite.println(msg);
    
}
connSock.close();
servSocket.close();
fileRead.close();
pwrite.close();
}}
