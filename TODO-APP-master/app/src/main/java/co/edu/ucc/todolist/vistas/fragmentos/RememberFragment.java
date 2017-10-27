package co.edu.ucc.todolist.vistas.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.vistas.presenters.IRememberPresenter;
import co.edu.ucc.todolist.vistas.presenters.RememberPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnRememberFagmentInteraction} interface
 * to handle interaction events.
 * Use the {@link RememberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RememberFragment extends Fragment implements IRememberFragmentView {

@BindView(R.id.txtEmailRemember)
    EditText txtEmailRemember;
    @BindView(R.id.btnRemember)
    Button btnRemember;
    private IRememberPresenter RememberPresenter;
    private OnRememberFagmentInteraction mListener;

    public RememberFragment() {
        // Required empty public constructor
    }

    public static RememberFragment newInstance() {
        RememberFragment fragment = new RememberFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_remember,container,false);
        ButterKnife.bind(this,view);
        RememberPresenter=new RememberPresenter(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRememberFagmentInteraction) {
            mListener = (OnRememberFagmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRememberFagmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

@OnClick(R.id.btnRemember)
    @Override
    public void RecordarContrasena() {
        final String  email=txtEmailRemember.getText().toString();
        RememberPresenter.RecordarContrasena(email);
        mListener.irALogin();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnRememberFagmentInteraction {
        // TODO: Update argument type and name
    void irALogin();
    }
}
