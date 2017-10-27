package co.edu.ucc.todolist.vistas.presenters;

import butterknife.OnClick;
import co.edu.ucc.todolist.dominio.CallBackInteractor;
import co.edu.ucc.todolist.dominio.ILUsuario;
import co.edu.ucc.todolist.dominio.LUsuario;
import co.edu.ucc.todolist.vistas.fragmentos.IRememberFragmentView;
import co.edu.ucc.todolist.vistas.fragmentos.RememberFragment;

/**
 * Created by Rodolhan on 26/10/2017.
 */

public class RememberPresenter implements IRememberPresenter {
    private IRememberFragmentView view;
    private ILUsuario iUsuario;

    public RememberPresenter(IRememberFragmentView view) {
        this.view = view;
        iUsuario = new LUsuario();
    }
    @Override
    public void RecordarContrasena(String email) {
    iUsuario.recordarContrasena(email, new CallBackInteractor<Boolean>() {
        @Override
        public void success(Boolean data) {

        }

        @Override
        public void error(String error) {

        }
    });
    }
}
