package uefs.redes.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import uefs.redes.controller.ControllerClient;
import uefs.redes.define.Constants;
import uefs.redes.define.Pack;

public class ClientAcess implements Runnable {

    private Socket socket;

    private String name_client;
    private String login_client;
    private String pass_client;
    private int en_req;
    private ControllerClient controll_client = null;
    private ArrayList<MovieInformation> history = new ArrayList<MovieInformation>();

    private ArrayList<MovieInformation> search = new ArrayList<MovieInformation>();

    public ClientAcess(Socket sock, ControllerClient cCLient) throws IOException {
        socket = sock;
        controll_client = cCLient;
    }

    public ClientAcess(Socket sock) throws IOException {
        socket = sock;
    }

    @SuppressWarnings("unused")
    @Override
    public void run() //	INHERIT THE RUN METHOD FROM THE Runnable INTERFACE
    {
        try {
            Pack pack_reqs = null;
            ObjectInputStream in = null;
            ObjectOutputStream out = null;
            String message;

            en_req = 0;

            do {
                in = new ObjectInputStream(socket.getInputStream());
                pack_reqs = (Pack) in.readObject();

                switch (pack_reqs.getCode()) {
                    case Constants.LOGIN_REP:
                        ClientInformation client_info = (ClientInformation) pack_reqs.getInformation(0);
                        message = (String) pack_reqs.getInformation(2);

                        //System.out.println(message);
                        login_client = client_info.getLogin();
                        name_client = client_info.getName();
                        pass_client = client_info.getPassword();
                        history = client_info.getMyMovies();
                        // da a mensagem na interface.

                        ArrayList<MovieInformation> moviesInformation = (ArrayList<MovieInformation>) pack_reqs.getInformation(1);

                        controll_client.setMoviesInformation(moviesInformation);
                        // modifica para a tela de filmes 
                        en_req = Constants.LOGIN_REP;
                        break;
                    case Constants.LOGIN_RER:

                        message = (String) pack_reqs.getInformation(0);

					// apresenta a messagem e 
                        // muda para a interface de fazer login 
                        en_req = Constants.LOGIN_RER;
                        break;
                    case Constants.LOGOUT_REP:

                        message = (String) pack_reqs.getInformation(0);

                        en_req = Constants.LOGOUT_REP;
					// apresenta a messagem e 
                        // muda para a interface de fazer login 
                        socket.close();
                        break;
                    case Constants.REGISTER_REP:
                        message = (String) pack_reqs.getInformation(0);

                        //System.out.println(message);
                        en_req = Constants.REGISTER_REP;

					// apresenta a messagem e 
                        // muda para a interface de fazer login 
                        break;
                    case Constants.REGISTER_RER:
                        message = (String) pack_reqs.getInformation(0);

                        //System.out.println(message);
                        en_req = Constants.REGISTER_RER;

					// apresenta a messagem e 
                        // muda para a interface de fazer Cadastro
                        break;
                    case Constants.SEARCH_REP:
                        message = (String) pack_reqs.getInformation(0);

                        //System.out.println(message);
                        search = (ArrayList<MovieInformation>) pack_reqs.getInformation(1);
                        // System.out.print(search.size());

                        en_req = Constants.SEARCH_REP;
                                        // apresenta a messagem e 
                        // muda para a interface apresentando a lista de filmes envontrados
                        break;
                    case Constants.SEARCH_RER:
                        message = (String) pack_reqs.getInformation(0);
                        System.out.println(message);
                        en_req = Constants.SEARCH_RER;
					// apresenta a messagem e 
                        // muda para a interface de fazer Cadastro
                        break;
                    case Constants.DOWNLOAD_REP:

                                   // history = (ArrayList<MovieInformation> )pack_reqs.getInformation(0);
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println(((MovieInformation) history.get(i)).getName_file());
                        }

                        en_req = Constants.DOWNLOAD_REP;
                        break;

                    default:

                        break;

                }

            } while (true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, " Conexão com o servidor fechada. ");
        }
    }

    public ArrayList<MovieInformation> getHistory() {
        return this.history;
    }

    public ArrayList<MovieInformation> getSearch() {
        return this.search;
    }

    public int req() {
        return en_req;
    }

    public String getLogin() {
        return login_client;
    }

    public String getName() {
        return name_client;
    }

    public Socket getSocket() {
        return socket;
    }

}
