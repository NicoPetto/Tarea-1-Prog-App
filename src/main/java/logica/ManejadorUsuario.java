package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario {

    private Map<String, Usuario> usuariosNick;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuariosNick = new HashMap<>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        usuariosNick.put(usu.getNick(), usu);
    }

    public Usuario obtenerUsuario(String nick) {
        return usuariosNick.get(nick);
    }

    public Usuario[] getUsuarios() {
        return usuariosNick.values().toArray(new Usuario[0]);
    }
}