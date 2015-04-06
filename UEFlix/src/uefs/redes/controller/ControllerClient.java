package uefs.redes.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import uefs.redes.exceptions.*;
import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientAcess;
import uefs.redes.model.ClientTransferation;
import uefs.redes.model.MovieInformation;

public class ControllerClient {

    private ClientAcess client_acess;
    static private Socket client_socket;
    private int REP_REQS = 0;
    private ArrayList<MovieInformation> moviesInformation = new ArrayList<MovieInformation>();

    public void connect() throws UnknownHostException, IOException, InterruptedException {
       
        ControllerClient.client_socket = new Socket(Constants.HOST, Constants.PORT_ACESS);
        client_acess = new ClientAcess(ControllerClient.client_socket, this);
        Thread threadClient = new Thread(client_acess);
        threadClient.start();

    }

    public ClientAcess getClient() {
        return client_acess;
    }

    public ArrayList<MovieInformation> getMovies() {
        return moviesInformation;
    }

    public void send_pack(Object pack) throws IOException, InterruptedException {
        ObjectOutputStream out = new ObjectOutputStream(client_socket.getOutputStream());
        out.writeObject(pack);
        out.flush();

    }

    public void login(String login, String password) throws IOException, InterruptedException, LoginSucessException, LoginFailException {
        Pack login_pack = new Pack(Constants.LOGIN_REQ);

        String loginE = Encrypt(login);
        String passE = Encrypt(password);

        login_pack.addInformation(loginE);
        login_pack.addInformation(passE);
        this.send_pack(login_pack);
        
        Thread.sleep(200);
        if (client_acess.req() == Constants.LOGIN_REP) {
            this.getImage();
            throw new LoginSucessException();
        } else {
            throw new LoginFailException();
        }

    }

    public void getImage() throws IOException, InterruptedException {
        //System.out.println(moviesInformation.size());
        for (MovieInformation xMovie : this.moviesInformation) {
            String movie_name = xMovie.getName_file();
			//System.out.println(movie_name);

            Pack pack_image = new Pack(Constants.DOWNLOAD_IMAGE_REQ);
            pack_image.addInformation(movie_name);
            ClientTransferation client_channel = this.send_pack_file(pack_image);
            client_channel.getFileFromeServerImage(movie_name);
          
        }
    }

    public void search(String datagrams) throws IOException, InterruptedException, SearchSucessException, SearchFailException {
        Pack search_pack = new Pack(Constants.SEARCH_REQ);
        search_pack.addInformation(datagrams);
        this.send_pack(search_pack);

        Thread.sleep(200);
        if (client_acess.req() == Constants.SEARCH_REP) {
            throw new SearchSucessException();
        } else {
            throw new SearchFailException();
        }
    }

    public void logout(String login) throws IOException, InterruptedException, LogoutSucessException, LogoutFailException {
        Pack logout_pack = new Pack(Constants.LOGOUT_REQ);
        logout_pack.addInformation(login);
        this.send_pack(logout_pack);
        Thread.sleep(200);
        if (client_acess.req() == Constants.LOGOUT_REP) {
            throw new LogoutSucessException();
        } else {
            throw new LogoutFailException();
        }

    }

    public void donwload_movie(String name, String type) throws UnknownHostException, IOException, InterruptedException, DownloadSucessException, DownloadFailException {
        Pack download_pack = new Pack(Constants.DOWNLOAD_REQ);
        String name1 = name;
                // servi de arquivo 

        name = name + "-" + type;
        download_pack = new Pack(Constants.DOWNLOAD_REQ);
        download_pack.addInformation(name);

        ClientTransferation client_channel = send_pack_file(download_pack);

        client_channel.getFileFromServeR(name);
		// pedir pra assistir o filme

        download_pack = new Pack(Constants.DOWNLOAD_REQ);
        download_pack.addInformation(name1);

        this.send_pack(download_pack);

    }

    public ClientTransferation send_pack_file(Object pack) throws IOException, InterruptedException {
        Socket client_socket_file = new Socket(Constants.HOST, Constants.PORT_FILE);
        ClientTransferation client_channel = new ClientTransferation(client_socket_file);
        ObjectOutputStream out = new ObjectOutputStream(client_socket_file.getOutputStream());
        out.writeObject(pack);
        out.flush();
        return client_channel;
    }

    public void register(String name, String login, String password) throws IOException, InterruptedException, RegisterSucessException, RegisterFailException {
        Pack register_pack = new Pack(Constants.REGISTER_REQ);
        String loginE = Encrypt(login);
        String passE = Encrypt(password);

        register_pack.addInformation(name);
        register_pack.addInformation(loginE);
        // codigo para encryp
        register_pack.addInformation(passE);
        this.send_pack(register_pack);

        Thread.sleep(200);

        if (client_acess.req() == Constants.REGISTER_REP) {
            throw new RegisterSucessException();
        } else {
            throw new RegisterFailException();
        }
    }

    public void setMoviesInformation(ArrayList<MovieInformation> moviesInformation) {
        this.moviesInformation = moviesInformation;
    }

    public void setREP(int x) {
        REP_REQS = x;
    }

    public String Encrypt(String data) {
        String password = data;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControllerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

      //  System.out.println("Digest(in hex format):: " + sb.toString());
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();

    }
}
